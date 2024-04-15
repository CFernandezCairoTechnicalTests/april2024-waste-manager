package dev.cfernandezcairo.wastemanager.application.steps;

import dev.cfernandezcairo.wastemanager.application.ApplicationTestData;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.service.WasteCenterAuthorizationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.function.Predicate;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CenterAuthorizationRemove extends ApplicationTestData {

    Predicate<WasteCenterAuthorization> predicate;

    public CenterAuthorizationRemove(){
        loadData();
    }

    @Given("I know the center authorization I want to remove")
    public void i_know_the_centerauthorization_i_want_to_remove(){
        predicate = WasteCenterAuthorization.
                getCenterAuthorizationNumberPredicate("authorizationNumber");
        centerAuth = WasteCenterAuthorizationService.
                findCenterAuthorization(authorizations, predicate);
        assertEquals("authorizationNumber", centerAuth.getAuthorizationNumber());
    }

    @And("I have a manager to remove a center authorization")
    public void i_have_a_manager_to_remove_a_centerauthorization(){
        assertNotNull(manager);
    }

    @Then("I remove the center authorization from the manager")
    public void i_remove_the_centerauthorization_from_the_manager(){
        this.wasteCenterAuthorizationUseCase.
                removeCenterAuthorizationFromManager(centerAuth, manager);
        centerAuth = WasteCenterAuthorizationService.
                findCenterAuthorization(authorizations, predicate);
        assertNull(centerAuth);
    }
}
