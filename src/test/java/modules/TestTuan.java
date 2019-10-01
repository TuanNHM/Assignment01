package modules;

import org.testng.annotations.*;

public class TestTuan {
    @BeforeTest
    public void beforeTest(){
        System.out.println("This is Before Test");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("THis is test 1");
    }
    @Test(priority = 1)
    public void test2(){
        System.out.println("This is test 2");
    }
    @Test(priority = 3)
    public void test3(){
        System.out.println("This is test 3");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("This is after test");
    }
}
