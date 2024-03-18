package org.myavlab;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;


public abstract class Function {
    public abstract BigDecimal count(BigDecimal x);

    public final double accuracy = 0.00001;

    public final SortedMap<BigDecimal, BigDecimal> countRange(BigDecimal start, BigDecimal finish, BigDecimal step){
        SortedMap<BigDecimal, BigDecimal> result = new TreeMap<BigDecimal, BigDecimal>();
        for(BigDecimal i = start; i.compareTo(finish) <= 0; i = i.add(step))
            result.put(i, count(i));
        return result;
    }

    public final void toCsv(String path, SortedMap<BigDecimal, BigDecimal> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.println("x,y");
            for (Map.Entry<BigDecimal, BigDecimal> entry : data.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

}
