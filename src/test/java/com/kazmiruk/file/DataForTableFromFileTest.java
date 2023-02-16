package com.kazmiruk.file;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DataForTableFromFileTest {

    @Mock
    private ExternalPropertiesFile epf;

    @Test
    void testIntegerGetter() {
        Mockito.when(epf.getProperty("min")).thenReturn("2");
        Mockito.when(epf.getProperty("max")).thenReturn("10");
        Mockito.when(epf.getProperty("inc")).thenReturn("2");
        Mockito.when(epf.getFilename()).thenReturn("data.properties");

        DataForTableFromFile data = new DataForTableFromFile(Integer.class, epf);

        assertAll(
                () -> assertEquals(2, data.getMin()),
                () -> assertEquals(10, data.getMax()),
                () -> assertEquals(2, data.getInc())
        );
    }

    @Test
    void testDoubleGetter() {
        Mockito.when(epf.getProperty("min")).thenReturn("2.0");
        Mockito.when(epf.getProperty("max")).thenReturn("10.0");
        Mockito.when(epf.getProperty("inc")).thenReturn("2.0");
        Mockito.when(epf.getFilename()).thenReturn("data.properties");

        DataForTableFromFile data = new DataForTableFromFile(Double.class, epf);

        assertAll(
                () -> assertEquals(2.0, data.getMin()),
                () -> assertEquals(10.0, data.getMax()),
                () -> assertEquals(2.0, data.getInc())
        );
    }
}