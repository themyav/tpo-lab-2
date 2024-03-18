package org.myavlab;

import org.myavlab.logs.Ln;
import org.myavlab.logs.LogN;
import org.myavlab.trigonometry.Cos;
import org.myavlab.trigonometry.Sin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cos cos = new Cos();
        LogN log2 = new LogN(BigDecimal.valueOf(2));
        LogN log5 = new LogN(BigDecimal.valueOf(5));
        LogN log10 = new LogN(BigDecimal.valueOf(10));
        Ln ln = new Ln();
        System system = new System(cos, log2, log5, log10, ln);
        for(int i = 0; i < 10; i++){
            java.lang.System.out.println(i + " " + system.count(BigDecimal.valueOf(i)));
        }
    }
}

