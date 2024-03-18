package org.myavlab.trigonometry;

import org.myavlab.Function;

import java.math.BigDecimal;

public class Cos extends Function {


    @Override
    public BigDecimal count(BigDecimal x) {
        Sin sin = new Sin();
        return sin.count(x.add(new BigDecimal(Math.PI / 2)));
    }
}
