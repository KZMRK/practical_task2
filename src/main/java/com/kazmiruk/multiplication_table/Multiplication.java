package com.kazmiruk.multiplication_table;

import java.util.ArrayList;
import java.util.List;

public class Multiplication<T extends Number> {

    private final Class<T> cls;

    public Multiplication(Class<T> cls) {
        this.cls = cls;
    }

    @SuppressWarnings("unchecked")
    public List<List<T>> multiply(List<T> firstMultipliers, List<T> secondMultipliers) {
        List<List<T>> afterMultiply = new ArrayList<>();

        for (int i = 0; i < firstMultipliers.size(); i++) {
            List<T> row = new ArrayList<>(firstMultipliers.size());
            for (int j = 0; j < secondMultipliers.size(); j++) {
                Number multiplyTwo;
                if (cls.equals(Integer.class)) {
                    multiplyTwo = firstMultipliers.get(i).intValue() * secondMultipliers.get(j).intValue();
                } else {
                    multiplyTwo = firstMultipliers.get(i).doubleValue() * secondMultipliers.get(j).doubleValue();
                }
                row.add((T) multiplyTwo);
            }
            afterMultiply.add(row);
        }
        return afterMultiply;
    }

}
