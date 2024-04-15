package dev.cfernandezcairo.wastemanager.application.steps;

import dev.cfernandezcairo.wastemanager.application.ApplicationTestData;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.service.WasteCenterAuthorizationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CenterAuthorizationAdd extends ApplicationTestData {

    public CenterAuthorizationAdd(){
        loadData();
    }

    @Given("I have a center authorization")
    public void i_have_a_centerauthorization(){
        centerAuth = wasteCenterAuthorizationUseCase.createCenterAuthorization(
                "9"
        );
        assertNotNull(centerAuth);
    }

    @And("I have a manager to add a center authorization")
    public void i_have_a_manager_to_add_a_centerauthorization(){
        assertNotNull(manager);
    }

    @Then("I add the center authorization to the manager")
    public void i_add_the_centerauthorization_to_the_manager(){
        var predicate = WasteCenterAuthorization.getCenterAuthorizationNumberPredicate("9");
        var centerAuthorizations = this.
                wasteCenterAuthorizationUseCase.
                addCenterAuthorizationToManager(centerAuth, manager).
                getListOfWasteCenterAuthorization();
        var centerAuthorizationNumber = WasteCenterAuthorizationService.
                findCenterAuthorization(centerAuthorizations, predicate).getAuthorizationNumber();
        assertEquals("9", centerAuthorizationNumber);
    }
}
