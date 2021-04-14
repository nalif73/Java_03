package ru.geekbrains;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Methods {
//    public static void main(String[] args) {
//        Integer[] array = new Integer[]{1, 1, 1, 4, 1, 1, 1, 1, 1, 4};
//        System.out.println(arrayCheckOneAndFour(array));
//    }

    public Integer[] arrayAfterFour(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        try {
            Integer index = list.lastIndexOf(4);
            if (index >= 0) {
                return Arrays.copyOfRange(array, index + 1, array.length);
            }
            throw new RuntimeException("Нет числа 4 в массиве");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean arrayCheckOneAndFour(Integer[] array) {
        // не совсем понял что должен делать метод. Судя по заданию из методички где приведены примеры и результат
        // должны быть в массиве только 1 и 4 вместе (остальные цифры не допускаются), тогда true иначе false.
        // я так понял
        boolean flag1 = false;
        boolean flag2 = false;
        for (int a : array) {
            if (a == 4) flag1 = true;
            if (a == 1) flag2 = true;
            if (!(a == 4 || a == 1)) return false;
        }
        if (flag1 && flag2) return true;
        return false;
    }
}