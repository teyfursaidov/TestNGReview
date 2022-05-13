package reviewClass01;

import org.testng.annotations.*;

public class BasicAnnotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BEFORE METHOD");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @Test
    public void test1(){
        System.out.println("TEST 1");
    }
    @Test
    public void test2(){
        System.out.println("TEST 2");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AFTER METHOD");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BEFORE SUITE");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AFTER SUITE");
    }

}

// we need to write down the code that opens the browser and
// navigates to a particular url
// in testNG under which annotation that kind of method should be written

// you need to read a file that has the link to the website
// some information regarding credentials
// some information regarding the browser