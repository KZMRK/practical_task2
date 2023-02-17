package com.kazmiruk.multiplication_table;

import com.kazmiruk.file.DataForTableFromFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTable<T extends Number> {

    private final Logger logger = LoggerFactory.getLogger(MultiplicationTable.class);

    private final List<List<T>> afterMultiply;

    private final List<T> multipliers;

    public MultiplicationTable(Class<T> cls) {
        this(cls, new DataForTableFromFile(cls, "info.properties"));
    }

    public MultiplicationTable(Class<T> cls, DataForTableFromFile data) {
        NumberSeries<T> numberSeries = new NumberSeries<>(cls);
        Multiplication<T> multiplication = new Multiplication<>(cls);

        multipliers = numberSeries.form(data.getMin(), data.getMax(), data.getInc());
        logger.info("Multiplier list have been created");
        afterMultiply = multiplication.multiply(multipliers, new ArrayList<>(multipliers));
        logger.info("Two multiplier lists were multiplied");
    }

    public void print() {
        for (int i = 0; i < multipliers.size(); i++) {
            for (int j = 0; j < multipliers.size(); j++) {
                logger.info("{} * {} = {}",
                        multipliers.get(i),
                        multipliers.get(j),
                        afterMultiply.get(i).get(j)
                );
            }
        }
    }

    public List<List<T>> getAfterMultiply() {
        return afterMultiply;
    }

    public List<T> getMultipliers() {
        return multipliers;
    }
}
