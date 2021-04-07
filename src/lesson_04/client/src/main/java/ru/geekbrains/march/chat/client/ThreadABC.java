package ru.geekbrains.march.chat.client;

public class ThreadABC {
    private final Object monitor = new Object();
    private volatile char cLetter = 'A';

    public static void main(String[] args) {
        ThreadABC w = new ThreadABC();
        Thread threadA = new Thread(() -> {
            w.printA();
        });
        Thread threadB = new Thread(() -> {
            w.printB();
        });
        Thread threadC = new Thread(() -> {
            w.printC();
        });
        threadA.start();
        threadB.start();
        threadC.start();

    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (cLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    cLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (cLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    cLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (cLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C");
                    cLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
