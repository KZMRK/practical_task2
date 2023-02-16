package com.kazmiruk.multiplication_table;

import com.kazmiruk.file.DataForTableFromFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MultiplicationTableTest {

    @Mock
    private DataForTableFromFile data;

    @Test
    void testMultipleTableGetter() {
        Mockito.when(data.getMin()).thenReturn(1);
        Mockito.when(data.getMax()).thenReturn(8);
        Mockito.when(data.getInc()).thenReturn(2);

        List<Integer> expectedMultipliers = new ArrayList<>(
                Arrays.asList(1, 3, 5, 7)
        );

        List<List<Integer>> expectedAfterMultiply = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 3, 5, 7),
                        Arrays.asList(3, 9, 15, 21),
                        Arrays.asList(5, 15, 25, 35),
                        Arrays.asList(7, 21, 35, 49)
                )
        );

        MultiplicationTable<Integer> multiplicationTable = new MultiplicationTable<>(Integer.class, data);
        assertAll(
                () -> assertEquals(expectedMultipliers, multiplicationTable.getMultipliers()),
                () -> assertEquals(expectedAfterMultiply, multiplicationTable.getAfterMultiply())
        );
    }
}