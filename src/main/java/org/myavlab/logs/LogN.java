package org.myavlab.logs;

import org.myavlab.Function;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LogN extends Function {
    public BigDecimal base;
    public Ln ln = new Ln();
    public LogN(BigDecimal base){
        if(base.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("основание логарифма не может быть не положительно");
        if(base.compareTo(BigDecimal.ONE) == 0) throw new IllegalArgumentException("основание логарифма не может быть равно 1");
        this.base = base;

    }
    @Override
    public BigDecimal count(BigDecimal x) {
        return ln.count(x).divide(ln.count(this.base), RoundingMode.HALF_EVEN);
    }
}
