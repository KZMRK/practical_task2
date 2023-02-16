package com.kazmiruk.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataForTableFromFile {

    private final Logger logger = LoggerFactory.getLogger(DataForTableFromFile.class);

    private final Class<? extends Number> cls;

    private Number min;

    private Number max;

    private Number inc;

    public DataForTableFromFile(Class<? extends Number> cls, String filename) {
        this(cls, new ExternalPropertiesFile(filename));
    }

    public DataForTableFromFile(Class<? extends Number> cls, ExternalPropertiesFile epf) {
        this.cls = cls;
        String strMin = epf.getProperty("min");
        String strMax = epf.getProperty("max");
        String strInc = epf.getProperty("inc");
        logger.info("Property values are taken from the file {}", epf.getFilename());
        parseData(strMin, strMax, strInc);
    }

    private void parseData(String strMin, String strMax, String strInc) {
        min = parseAccordingToType(strMin);
        max = parseAccordingToType(strMax);
        inc = parseAccordingToType(strInc);
        logger.info("Property values are converted to {} type", cls.getName());
    }

    private Number parseAccordingToType(String strNum) {
        if (cls.equals(Integer.class)) {
            return Integer.parseInt(strNum);
        } else {
            return Double.parseDouble(strNum);
        }
        //return cls.equals(Integer.class) ? Integer.parseInt(strNum) : Double.parseDouble(strNum);
    }

    public Number getMin() {
        return min;
    }

    public Number getMax() {
        return max;
    }

    public Number getInc() {
        return inc;
    }
}
