package reviewClass01;

import org.testng.annotations.Test;

public class EnableDisable {

    @Test(enabled = false)
    public void testOne(){
        System.out.println("Test One");
    }
    @Test
    public void testTwo(){
        System.out.println("Test Two");
    }
}
