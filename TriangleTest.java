import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    public void testTriangleArea_1() {
        TriangleArea s=new TriangleArea();
        double result=s.getArea(3, 4, 5);
        assertEquals(6.0, result);
    }
      @Test
    public void testTriangleArea_2() {
        TriangleArea s=new TriangleArea();
        double result=s.getArea(6, 8, 10);
        assertEquals(24.0, result);
    }
      @Test
    public void testTriangleArea_3() {
        TriangleArea s=new TriangleArea();
        double result=s.getArea(5, 12, 13);
        assertEquals(30.0, result);
    }
      @Test
    public void testTriangleArea_4() {
        TriangleArea s=new TriangleArea();
        double result=s.getArea(10, 10, 12);
        assertEquals(48.0, result);
    }
}
