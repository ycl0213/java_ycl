package extend;

import org.junit.Test;

public class CircleTest {

    @Test
    public void testFindArea() {
        Circle c = new Circle();
        System.out.println(c.findArea());
        c.setRadius(0.2);
        System.out.println(c.getRadius());
    }
}