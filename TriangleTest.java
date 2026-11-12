import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    public void testTriangleArea() {
        TriangleArea s=new TriangleArea();
        double result=s.getArea(3, 4, 5);
        assertEquals(6.0, result);
    }
    
}
