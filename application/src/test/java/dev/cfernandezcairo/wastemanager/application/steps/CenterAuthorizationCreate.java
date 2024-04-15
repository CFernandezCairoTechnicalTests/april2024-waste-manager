package dev.cfernandezcairo.wastemanager.application.steps;

import dev.cfernandezcairo.wastemanager.application.ApplicationTestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CenterAuthorizationCreate extends ApplicationTestData {

    public CenterAuthorizationCreate(){
        loadData();
    }

    @Given("I provide all required data to create a center authorization")
    public void i_provide_all_required_data_to_create_a_centerauthorization(){
        centerAuth = wasteCenterAuthorizationUseCase.createCenterAuthorization(
                "8"
        );
    }

    @Then("A new center authorization is created")
    public void a_new_centerauthorization_is_created(){
        assertNotNull(centerAuth);
        assertEquals("8", centerAuth.getAuthorizationNumber());
    }
}
