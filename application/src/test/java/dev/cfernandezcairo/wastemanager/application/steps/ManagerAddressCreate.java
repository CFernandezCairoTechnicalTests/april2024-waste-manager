package dev.cfernandezcairo.wastemanager.application.steps;

import dev.cfernandezcairo.wastemanager.application.ApplicationTestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ManagerAddressCreate extends ApplicationTestData {

    public ManagerAddressCreate(){
        loadData();
    }

    @Given("I provide all required data to create a address")
    public void i_provide_all_required_data_to_create_a_address(){
        addressManager = this.wasteManagerAddressUseCase.createWasteManagerAddress(
                true,
                "address example"
        );
    }

    @Then("A new address is created")
    public void a_new_address_is_created() {
        assertNotNull(manager);
        assertEquals(true, addressManager.getIsEnabled());
        assertEquals("address example", addressManager.getDireccion());
    }
}
