package ru.mytest.functions;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DistanceTests {

    @Test
    public void DistTest1() {
        Point d = new Point (5.0, 5.0, 2.0, 1.0);
        Assert.assertEquals(d.distance(),5.0);
    }
    @Test
    public void DistTest2() {
        Point d = new Point (2.0, 5.0, 5.0, 1.0);
        Assert.assertEquals(d.distance(),5.0);
    }
    @Test
    public void DistTest3() {
        Point d = new Point (7.0, 5.0, 2.0, 0.0);
        Assert.assertEquals(d.distance(),4.0);
    }
    @Test
    public void DistTest4() {
        Point d = new Point (15.0, 5.0, 2.0, 1.0);
        Assert.assertEquals(d.distance(),6.0);
    }


}
