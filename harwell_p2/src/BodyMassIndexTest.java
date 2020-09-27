import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    public void testUnderweightBMI() {
        BodyMassIndex e = new BodyMassIndex(68,100);
        assertEquals(15.2, e.calculateBMI(68,100));
        assertEquals("Underweight", e.category(68,100));
    }

    @Test
    public void testNormalBMI() {
        BodyMassIndex e = new BodyMassIndex(70, 140);
        assertEquals(21.3, e.calculateBMI(68,140));
        assertEquals("Normal", e.category(68,140));
    }

    @Test
    public void testOverweightBMI() {
        BodyMassIndex e = new BodyMassIndex(65, 170);
        assertEquals(28.3, e.calculateBMI(65,170));
        assertEquals("Overweight", e.category(65,170));
    }

    @Test
    public void testObesityBMI() {
        BodyMassIndex e = new BodyMassIndex(72, 230);
        assertEquals(31.2, e.calculateBMI(72,230));
        assertEquals("Obesity", e.category(72,230));
    }

}