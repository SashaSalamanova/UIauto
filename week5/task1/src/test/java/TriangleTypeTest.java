import org.junit.*;
import org.junit.experimental.categories.Category;
import java.lang.*;

public class TriangleTypeTest extends Assert{
    private static Triangle testTriangle;

    @BeforeClass
    public static void init() { testTriangle = new Triangle();}
    @AfterClass
    public static void clear() { testTriangle = null; }

    @Category(categories.Rectangular.class)
    @Test
    public void isRectangular(){
        assertTrue("Треугольник не является прямоугольным",
                (Math.pow(testTriangle.getABLength(), 2) == Math.pow(testTriangle.getACLength(), 2) + Math.pow(testTriangle.getBCLength(), 2))
                        ||(Math.pow(testTriangle.getACLength(), 2) == Math.pow(testTriangle.getABLength(), 2) + Math.pow(testTriangle.getBCLength(), 2))
                        ||(Math.pow(testTriangle.getBCLength(), 2) == Math.pow(testTriangle.getABLength(), 2) + Math.pow(testTriangle.getACLength(), 2)));
    }

    @Category(categories.Equilateral.class)
    @Test
    public void isEquilateral(){
        assertTrue("Треугольник не является равносторонним",
                (testTriangle.getABLength() == testTriangle.getACLength())
                &&(testTriangle.getABLength() == testTriangle.getBCLength()));
    }

    @Category(categories.Isosceles.class)
    @Test
    public void isIsosceles(){
        assertTrue("Треугольник не является равнобедренным",
                (testTriangle.getABLength() == testTriangle.getACLength())
                        ||(testTriangle.getABLength() == testTriangle.getBCLength())
                        ||(testTriangle.getACLength() == testTriangle.getBCLength()));
    }
}
