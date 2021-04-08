package ru.geekbrains;


public class MainClass {
    public static final int CARS_COUNT = 4;
    private static Thread[]  threads = new Thread[CARS_COUNT];

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
        threads[i] = new Thread(cars[i]);
        threads[i].start();
        }
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // гонка начинается
            if (Car.isFlag()) break;
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        for (int i = 0; i < cars.length; i++) {
            try {
                // ждем когда все закончат гонку
                threads[i].join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        // сделал вроде все, за исключением определения победителя.
        // как это делать совсем непонятно, пробовол но не получилось, расскажите как определять

    }
}
