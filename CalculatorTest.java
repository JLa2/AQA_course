import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testCAddition_1() {
        Calculator a=new Calculator();
        int result=a.add(2, 3);
        assertEquals(5, result);
    }
    @Test
    public void testCAddition_2() {
        Calculator a=new Calculator();
        int result=a.add(5, 8);
        assertEquals(13, result);
    }
    @Test
    public void testCSubtraction_1() {
        Calculator b=new Calculator();
        int result=b.subtract(5, 4);
        assertEquals(1, result);
    }
    @Test
    public void testCSubtraction_2() {
        Calculator b=new Calculator();
        int result=b.subtract(-7, 5);
        assertEquals(-12, result);
    }
    @Test
    public void testMultiplication_1() {
        Calculator c=new Calculator();
        int result=c.multiply(5, 5);
        assertEquals(25, result);
    }
    @Test
    public void testMultiplication_2() {
        Calculator c=new Calculator();
        int result=c.multiply(10, 50);
        assertEquals(500, result);
    }
    @Test
    public void testDivision_1() {
        Calculator d=new Calculator();
        int result=d.divide(10, 2);
        assertEquals(5, result);
    }
    @Test
    public void testDivision_2() {
        Calculator d=new Calculator();
        int result=d.divide(2, 2);
        assertEquals(1, result);
    }
}
