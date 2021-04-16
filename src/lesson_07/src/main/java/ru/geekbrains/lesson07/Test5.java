package ru.geekbrains.lesson07;

@Priority(priority = 3)
public class Test5 {

    public void method1() {
        System.out.println("method1() выполнился");
    }

    @Test
    public void method2() {
        System.out.println("method2() выполнился");
    }

    @BeforeSuite
    public void method3() {
        System.out.println("method3() выполнился");
    }

    @Test
    public void method4() {
        System.out.println("method4() выполнился");
    }

    @Test
    public void method5() {
        System.out.println("method5() выполнился");
    }

    @AfterSuite
    public void method6() {
        System.out.println("method6() выполнился");
    }
}
