package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] numbersInteger = {1, 2, 3, 4, 5};
        Double[] numbersDouble = {1.0, 2.0, 3.0, 4.0, 5.0};
        Long[] numbersLong = {1L, 2L, 3L, 4L, 5L};
        Filter<Integer> filterInt = o -> o * 2;
        Filter<Double> filterDouble = o -> o * 2.0;
        Filter<Long> filterLong = o -> o * 2L;

        Integer [] newIntegerArr = filter(numbersInteger, filterInt);
        Double [] newDoubleArr = filter(numbersDouble, filterDouble);
        Long [] newLongArr = filter(numbersLong, filterLong);
        for (Integer number : newIntegerArr) {
            System.out.println(number);
        }
        System.out.println("-----");
        for (Double number : newDoubleArr) {
            System.out.println(number);
        }
        System.out.println("-----");
        for (Long number : newLongArr) {
            System.out.println(number);
        }
    }

    public static <T> T[] filter(T[] array, Filter<T> filter) {
        T[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }
        return result;
    }
}