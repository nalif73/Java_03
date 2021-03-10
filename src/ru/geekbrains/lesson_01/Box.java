package ru.geekbrains.lesson_01;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public ArrayList<T> getFruit() {
        return fruits;
    }

    public double getWeight() {
        if (fruits.isEmpty()) return 0;
        else
            return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void moveFruits(Box box) {
        if (!this.fruits.isEmpty()) {
            if (box.fruits.isEmpty()) {
                box.fruits.addAll(this.fruits);
                this.fruits.clear();
                return;
            }
            if (this.fruits.get(0).getClass().equals((box.fruits.get(0).getClass()))) {
                box.fruits.addAll(this.fruits);
                this.fruits.clear();
            } else
            throw new IllegalArgumentException("В ящиках разные фрукты. Нельзя пересыпать");
        } else
            throw new RuntimeException("Ящик из которого пересыпают пустой");
    }
}
