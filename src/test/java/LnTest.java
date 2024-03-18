import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.myavlab.logs.Ln;
import org.myavlab.trigonometry.Cos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnTest {

    static Ln ln;
    static final Double accuracy = 0.0001;

    @BeforeAll
    public static void createEntities(){
        ln = new Ln();
    }

    @ParameterizedTest(name = "testPositiveSmall")
    @ValueSource(doubles = {0.5, 0.1, 0.7, 1 })
    public void testPositiveSmall(double x) {
        assertEquals(Math.log(x), ln.count(BigDecimal.valueOf(x)).doubleValue(), accuracy);
    }

    @ParameterizedTest(name = "testPositiveBig")
    @ValueSource(doubles = {2, 4, 5})
    public void testPositiveBig(double x) {
        assertEquals(Math.log(x), ln.count(BigDecimal.valueOf(x)).doubleValue(), 0.01);
    }
}
