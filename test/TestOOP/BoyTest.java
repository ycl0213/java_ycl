package TestOOP;

import junit.framework.TestCase;

public class BoyTest extends TestCase {

    public void testMarry() {
        Boy b = new Boy();
        b.setName("小华");
        b.setAge(24);
        Girl g = new Girl();
        g.setName("去去");
        b.marry(g);
    }

    public void testShout() {
        Boy b = new Boy();
        b.setName("小华");
        b.setAge(24);
        Girl g = new Girl();
        g.setName("去去");
        b.shout();


    }
}