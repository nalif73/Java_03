package ru.geekbrains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MethodsTests {

    @ParameterizedTest
    @MethodSource("streamArgs1")
    public void testArrayAfterFour(Integer[] a, Integer[] b) {
        Methods methods = new Methods();
        Assertions.assertArrayEquals(a, methods.arrayAfterFour(b));
    }

    public static Stream<Arguments> streamArgs1() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Integer[]{3,3},new Integer[] {1,3,3,4,3,3}));
        out.add(Arguments.arguments(new Integer[]{5,456},new Integer[] {2,3,23,44,31,30,4,4,4,5,456}));
        out.add(Arguments.arguments(new Integer[]{3},new Integer[] {111,23,35,40,4,3}));
        out.add(Arguments.arguments(null, new Integer[] {1,2,3,9,2,3,5,5}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("streamArgs2")
    public void testArrayCheckOneAndFour(boolean a, Integer[] b) {
        Methods methods = new Methods();
        Assertions.assertEquals(a, methods.arrayCheckOneAndFour(b));

    }

    public static Stream<Arguments> streamArgs2() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(false, new Integer[] {1,4,5,4,1,1}));
        out.add(Arguments.arguments(false, new Integer[] {1,1,1,1,1,1}));
        out.add(Arguments.arguments(false, new Integer[] {4,4,4,4,4,4,4,4,4,4,4,4,4}));
        out.add(Arguments.arguments(true, new Integer[] {1,4,4,1,1,1,1,1}));
        return out.stream();
    }

}
