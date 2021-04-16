package ru.geekbrains.lesson07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainApp {

    public static void main(String[] args) {
        try {
            Class[] classes = new Class[]{Test1.class, Test2.class, Test3.class, Test4.class, Test5.class};
            start(classes);
        } catch (RuntimeException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkAnnotationInClass(Class cl, Class ann1, Class ann2) {
        int a1 = 0;
        int a2 = 0;
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ann1)) a1++;
            if (m.isAnnotationPresent(ann2)) a2++;
            if (a1 > 1 || a2 > 1) return false;
        }
        return true;
    }

    public static void start(Class[] classes) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        sortClasses(classes);
        for (Class cl : classes) {
            if (!checkAnnotationInClass(cl, BeforeSuite.class, AfterSuite.class))
                throw new RuntimeException("В тестовом классе " + cl.getName() +
                        " методы с аннотациями @BeforeSuite и/или @AfterSuite не в единственном экземпляре");
            System.out.println("Тестовый класс " + cl.getName() + " приоритет " +
                    ((Priority) cl.getAnnotation(Priority.class)).priority());
            runMethods(cl, BeforeSuite.class);
            runMethods(cl, Test.class);
            runMethods(cl, AfterSuite.class);
            System.out.println();
        }
    }

    public static void runMethods(Class cl, Class ann) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ann)) {
                System.out.print("@" + ann.getSimpleName() + " ");
                m.invoke(cl.newInstance());
            }
        }
    }

    public static void sortClasses(Class[] classes) {
        Class tmp;
        for (int i = 0; i < classes.length; i++) {
            for (int j = i + 1; j < classes.length; j++) {
                int a = ((Priority) classes[i].getAnnotation(Priority.class)).priority();
                int b = ((Priority) classes[j].getAnnotation(Priority.class)).priority();
                if (b < a) {
                    tmp = classes[i];
                    classes[i] = classes[j];
                    classes[j] = tmp;
                }
            }
        }
    }

}

