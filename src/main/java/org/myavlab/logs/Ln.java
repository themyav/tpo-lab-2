package org.myavlab.logs;

import org.myavlab.Function;

import java.math.BigDecimal;
import java.math.MathContext;

public class Ln extends Function {


    @Override
    public BigDecimal count(BigDecimal x) {
        /*if (x.compareTo(BigDecimal.ZERO) <= 0) {
            if (x.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.valueOf(Double.NEGATIVE_INFINITY);
            }
            return BigDecimal.valueOf(Double.NaN);
        } else if (x.equals(BigDecimal.valueOf(Double.POSITIVE_INFINITY))) {
            return BigDecimal.valueOf(Double.POSITIVE_INFINITY);
        }*/

        BigDecimal current = BigDecimal.ZERO;
        BigDecimal prev;
        int iter = 1;

        int MAX_ITERATIONS = 500;
        if (x.subtract(BigDecimal.ONE).abs().compareTo(BigDecimal.ONE) <= 0) {
            do {
                prev = current;
                BigDecimal term = BigDecimal.valueOf(Math.pow(-1, iter - 1) * Math.pow(x.subtract(BigDecimal.ONE).doubleValue(), iter) / iter);
                current = current.add(term);
                iter++;
            } while (BigDecimal.valueOf(accuracy).compareTo(current.subtract(prev).abs()) <= 0 && iter < MAX_ITERATIONS);
        } else {
            do {
                prev = current;
                BigDecimal term = BigDecimal.valueOf(Math.pow(-1, iter - 1) * Math.pow(x.subtract(BigDecimal.ONE).doubleValue(), -iter) / iter);
                current = current.add(term);
                iter++;
            } while (BigDecimal.valueOf(accuracy).compareTo(current.subtract(prev).abs()) <= 0 && iter < MAX_ITERATIONS);

            current = current.add(count(x.subtract(BigDecimal.ONE)));
        }

        return current;
    }
}
