package reviewClass01;

import org.testng.annotations.Test;

public class DependsOn {


    @Test
    public void login(){
        System.out.println("Hello World");
    }
    @Test(dependsOnMethods = "login")
    public void verifyDashBoardPage(){
        System.out.println("Depends on method.");
    }
}
