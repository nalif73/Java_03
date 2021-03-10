package ru.geekbrains.lesson_01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Array<Integer> array1 = new Array<>(new Integer[]{1, 2, 3, 48, 5});
        Array<String> array2 = new Array<>(new String[]{"Ivan", "Vasya", "Petya", "Kolya", "Fedya"});

        System.out.println(Arrays.toString(array1.getArray()));
        System.out.println(Arrays.toString(array1.swapElements(0,3)));
        System.out.println();
        System.out.println(Arrays.toString(array2.getArray()));
        System.out.println(Arrays.toString(array2.swapElements(1,4)));
        System.out.println();
        System.out.println(array1.convertToArrayList());
        System.out.println(array2.convertToArrayList());

        Box box1 = new Box();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());

        Box box2 = new Box();
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());

        Box box3 = new Box();

        Box box4 = new Box();
        box4.addFruit(new Orange());
        box4.addFruit(new Orange());
        box4.addFruit(new Orange());

        System.out.println();
        System.out.println("Box1 вес "+box1.getWeight());
        System.out.println("Box2 вес "+box2.getWeight());
        System.out.println("Box3 вес "+box3.getWeight());
        System.out.println("Box4 вес "+box4.getWeight());

        System.out.println();
        System.out.println(box1.compare(box2));
        System.out.println(box3.compare(box1));
        System.out.println(box2.compare(box4));

        System.out.println();
        box2.moveFruits(box4);
        System.out.println("Box2 вес "+box2.getWeight());
        System.out.println("Box4 вес "+box4.getWeight());


    }
}
