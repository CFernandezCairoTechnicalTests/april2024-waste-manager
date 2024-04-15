package dev.cfernandezcairo.wastemanager.application.steps;

import dev.cfernandezcairo.wastemanager.application.ApplicationTestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ManagerCreate extends ApplicationTestData {

    public ManagerCreate(){
        loadData();
    }

    @Given("I provide all required data to create a manager")
    public void create_manager(){
        manager = this.wasteManagerUseCase.createWasteManager(
                "nombre",
                "nif",
                addressManager,
                true
        );
    }
    @Then("A new manager is created")
    public void a_new_manager_is_created(){
        assertNotNull(manager);
        assertEquals("nombre", manager.getNombre());
    }
}
