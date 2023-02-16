package com.kazmiruk;

import com.kazmiruk.multiplication_table.MultiplicationTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main( String[] args ) {
        if (System.getProperty("type").equalsIgnoreCase("double")) {
            logger.info("Type double is selected using a system variable");
            MultiplicationTable<Double> multiplicationTable = new MultiplicationTable<>(Double.class);
            multiplicationTable.print();
        } else {
            logger.info("Type int is selected using a system variable");
            MultiplicationTable<Integer> multiplicationTable = new MultiplicationTable<>(Integer.class);
            multiplicationTable.print();
        }
    }
}
