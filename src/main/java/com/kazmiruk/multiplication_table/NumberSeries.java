package com.kazmiruk.multiplication_table;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class NumberSeries<T> {

    private final Class<T> cls;

    public NumberSeries(Class<T> cls) {
        this.cls = cls;
    }

    public List<T> form(Number min, Number max, Number inc) {
        if (cls.equals(Integer.class)) {
            return formInteger(min.intValue(), max.intValue(), inc.intValue());
        } else {
            return formDouble(min.doubleValue(), max.doubleValue(), inc.doubleValue());
        }
    }

    private List<T> formInteger(Integer min, Integer max, Integer inc) {
        List<T> numberSeries = new ArrayList<>();
        for (Integer el = min; el <= max; el += inc) {
            numberSeries.add((T) el);
        }
        return numberSeries;
    }

    private List<T> formDouble(Double min, Double max, Double inc) {
        List<T> numberSeries = new ArrayList<>();
        for (Double el = min; el <= max; el += inc) {
            numberSeries.add((T) el);
        }
        return numberSeries;
    }


}
