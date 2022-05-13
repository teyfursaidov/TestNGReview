package reviewClass01;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 1)
    public void biAmTestOne(){
        System.out.println("Test One");
    }
    @Test(priority = 2)
    public void aiAmTestTwo(){
        System.out.println("Test Two");
    }
}

