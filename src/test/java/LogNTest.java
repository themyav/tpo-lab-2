import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.myavlab.logs.Ln;
import org.myavlab.logs.LogN;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogNTest {
    static final Double accuracy = 0.001;


    @ParameterizedTest(name = "testPositiveSmall")
    @ValueSource(doubles = {10, 100, 1000})
    public void testPositiveSmall(double x) {
        LogN logN = new LogN(BigDecimal.valueOf(10));
        assertEquals(Math.log(x) / Math.log(10), logN.count(BigDecimal.valueOf(x)).doubleValue(), accuracy);
    }

    //assertThrowa
}
