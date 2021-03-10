package ru.geekbrains.lesson_01;


import java.util.ArrayList;
import java.util.Arrays;

public class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T[] swapElements(int cell1, int cell2) {
        if (cell1 >= 0 && cell2 >= 0 && cell1 != cell2 && cell1 < array.length && cell2 < array.length) {
            T buffer = array[cell1];
            array[cell1] = array[cell2];
            array[cell2] = buffer;
            return array;
        }
        throw new ArrayIndexOutOfBoundsException("Задано значение индексов массива, " +
                "не принадлежащее допустимому диапазону");
    }

    public ArrayList<T> convertToArrayList() {
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(array));
        return arrayList;
    }
}
