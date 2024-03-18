package org.myavlab;

import org.myavlab.logs.Ln;
import org.myavlab.logs.LogN;
import org.myavlab.trigonometry.Cos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class System extends Function{

    public Cos cos;
    public LogN log2;
    public LogN log5;
    public LogN log10;
    public Ln ln;

    public System(Cos cos, LogN log2, LogN log5, LogN log10, Ln ln){
        this.cos = cos;
        this.log2 = log2;
        this.log5 = log5;
        this.log10 = log10;
        this.ln = ln;
    }

    @Override
    public BigDecimal count(BigDecimal x) {
        if(x.compareTo(BigDecimal.ZERO) <= 0){
            return cos.count(x).multiply(cos.count(x));
        }
        else{
            BigDecimal numerator1 = log2.count(x).multiply(log5.count(x)).add(log5.count(x));
            BigDecimal denumerator1 = log5.count(x).pow(3);
            BigDecimal denumerator2 =  (ln.count(x).pow(3)).pow(3);
            BigDecimal multyplier1 = log10.count(x).divide(log10.count(x), RoundingMode.HALF_EVEN);
            return numerator1.divide(denumerator1, RoundingMode.HALF_EVEN).divide(denumerator2, RoundingMode.HALF_EVEN).multiply(multyplier1);
        }
    }
}

/*
x <= 0 : (cos(x) * cos(x))
x > 0 : (((((log_2(x) * log_5(x)) + log_5(x)) / (log_5(x) ^ 3)) / ((ln(x) ^ 3) ^ 3)) * (log_10(x) / log_10(x)))
 */