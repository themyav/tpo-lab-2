import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.myavlab.logs.Ln;
import org.myavlab.trigonometry.Cos;
import org.myavlab.trigonometry.Sin;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {

    static Sin sin;
    static final Double accuracy = 0.0001;

    @BeforeAll
    public static void createEntities(){
        sin = new Sin();
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5, -0.75, -1.0 })
    public void testValues(double x) {
        assertEquals(Math.sin(x), sin.count(BigDecimal.valueOf(x)).doubleValue(), accuracy);
    }
}
