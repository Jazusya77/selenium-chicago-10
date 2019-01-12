package testng;

import org.testng.annotations.*;

public class Apple {

    @BeforeClass
    public void setup(){
        System.out.println("Setting up the environment in Before class annotation");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing everything in After Class annotation");
    }
    @BeforeMethod
    public void bm(){
        System.out.println("Before each test");
    }

    @Test(priority = 1)
    public void wappleInfo(){
        System.out.println("Test 1 here");
    }

    @Ignore
    @Test(priority = 2)
    public void test2(){
        System.out.println("TEst 2 here");
    }

    @Test(dependsOnMethods = "wappleInfo")
    public void post(){
        System.out.println("Posting something on my timeline");
    }
}
