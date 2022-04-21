package stepdefinitions.webordersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverHelper;

public class HookWebOrder {


    @Before

    public void beforeScenario(){
        System.out.println("it runs before each scenario");
    }

    @After

    public void afterWScenario(){
        DriverHelper.tearDown();
        System.out.println("it runs after each scenario");
    }
}
