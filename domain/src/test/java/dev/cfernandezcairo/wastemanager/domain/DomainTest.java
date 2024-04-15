package dev.cfernandezcairo.wastemanager.domain;

import dev.cfernandezcairo.wastemanager.domain.entity.Waste;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.exception.GenericSpecificationException;
import dev.cfernandezcairo.wastemanager.domain.service.WasteCenterAuthorizationService;
import dev.cfernandezcairo.wastemanager.domain.service.WasteManagerService;
import dev.cfernandezcairo.wastemanager.domain.service.WasteManagerAddressService;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DomainTest {

    @Test
    public void addCenterAuthorizationToManager(){

        var managerAddress = createWasteManagerAddress(Id.withId("1"), true, "Waste Manager 01 Address");
        var manager = createManager(Id.withId("1"), "Waste Manager 01", "nif 01", true, managerAddress);

        var centerAuthorization = createCenterAuthorization("1");
        assertTrue(manager.addCenterAuthorizationToManager(centerAuthorization));
    }

    @Test
    public void addCenterAuthorizationToManager_failBecauseManagerIsNotEnable(){
        var managerAddress = createWasteManagerAddress(Id.withId("2"), true, "Waste Manager 02 Address");
        var manager = createManager(Id.withId("2"), "Waste Manager 02", "nif 02", false, managerAddress);

        var centerAuthorization = createCenterAuthorization("2");
        assertThrows(GenericSpecificationException.class, () -> manager.addCenterAuthorizationToManager(centerAuthorization));
    }

    @Test
    public void removeCenterAuthorization(){
        var managerAddress = createWasteManagerAddress(Id.withId("3"), true, "Waste Manager 03 Address");
        var manager = createManager(Id.withId("3"), "Waste Manager 03", "nif 03", true, managerAddress);

        var centerAuthorization = createCenterAuthorization("3");
        manager.addCenterAuthorizationToManager(centerAuthorization);

        assertEquals(1, manager.getListOfWasteCenterAuthorization().size());
        assertTrue(manager.removeCenterAuthorizationFromManager(centerAuthorization));
        assertEquals(0, manager.getListOfWasteCenterAuthorization().size());
    }

    @Test
    public void filterWasteManagerByStatus(){
        List<WasteManager> wasteManagers = new ArrayList<>();

        var managerAddress = createWasteManagerAddress(Id.withId("5"), true,"Waste Manager Address");

        var managerEnabled = createManager(Id.withId("5"), "Waste Manager 05", "nif 05", true, managerAddress);
        var managerDisabled = createManager(Id.withId("6"), "Waste Manager 06", "nif 06", false, managerAddress);

        wasteManagers.add(managerEnabled);
        wasteManagers.add(managerDisabled);

        var wasteManagersEnabled = WasteManagerService.filterAndRetrieveWasteManager(wasteManagers,
                Waste.getEnabledPredicate(true));
        var actualEnabledWasteManagers = wasteManagersEnabled.get(0).getIsEnabled();
        assertEquals(true, actualEnabledWasteManagers);

        var wasteManagersDisabled = WasteManagerService.filterAndRetrieveWasteManager(wasteManagers,
                Waste.getEnabledPredicate(false));
        var actualDisabledWasteManagers = wasteManagersDisabled.get(0).getIsEnabled();
        assertEquals(false, actualDisabledWasteManagers);
    }

    @Test
    public void filterWasteManagerByNIF(){
        List<WasteManager> wasteManagers = new ArrayList<>();

        var managerAddress = createWasteManagerAddress(Id.withId("6"), true, "Waste Manager Address");

        var managerNIF0 = createManager(Id.withId("7"), "Waste Manager 07", "nif 07", true, managerAddress);
        var managerNIF1 = createManager(Id.withId("8"), "Waste Manager 08", "nif 18", false, managerAddress);

        wasteManagers.add(managerNIF0);
        wasteManagers.add(managerNIF1);

        var wasteManagersNIF0 = WasteManagerService.filterAndRetrieveWasteManager(wasteManagers,
                WasteManager.getWasteManagerNIFPredicate(managerNIF0));
        var actualNIF0WasteManager = wasteManagersNIF0.get(0).getNif();
        assertEquals(managerNIF0.getNif(), actualNIF0WasteManager);

        var wasteManagersNIF1 = WasteManagerService.filterAndRetrieveWasteManager(wasteManagers,
                WasteManager.getWasteManagerNIFPredicate(managerNIF1));
        var actualNIF1WasteManager = wasteManagersNIF1.get(0).getNif();
        assertEquals(managerNIF1.getNif(), actualNIF1WasteManager);
    }

    @Test
    public void filterWastManagerAddressByDireccion(){
        List<WasteManagerAddress> address = new ArrayList<>();

        var managerAddress = createWasteManagerAddress(Id.withId("7"), true,"Waste Manager Address");
        address.add(managerAddress);

        var actualAddress = WasteManagerAddressService.filterAndRetrieveWasteManagerAddress(address,
                WasteManagerAddress.getWasteManagerAddressDireccionPredicate(managerAddress));
        var actualAddressDireccion = actualAddress.get(0).getDireccion();
        assertEquals(managerAddress.getDireccion(), actualAddressDireccion);
    }

    @Test
    public void filterCenterAuthorizationByNumber(){

        var centerAuthorization = createCenterAuthorization("2");
        var centerAuthorizations = createCenterAuthorizations(centerAuthorization);

        var expectedNumber = centerAuthorization.getAuthorizationNumber();
        var actualNumber = WasteCenterAuthorizationService.filterAndRetrieveWasteCenterAuthorization(centerAuthorizations,
                WasteManager.getCenterAuthorizationNumberPredicate(centerAuthorization.getAuthorizationNumber())).get(0).getAuthorizationNumber();
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void findWasteManagerById(){
        Map<Id, WasteManager> wasteManagers = new HashMap<>();

        var managerAddress = createWasteManagerAddress(Id.withId("8"), true, "Waste Manager Address");
        var manager_1 = createManager(Id.withId("9"), "Waste Manager 09", "nif 09", true, managerAddress);
        var manager_2 = createManager(Id.withId("10"), "Waste Manager 10", "nif 10", false, managerAddress);

        wasteManagers.put(manager_1.getId(), manager_1);
        wasteManagers.put(manager_2.getId(), manager_2);

        var expectedId = manager_1.getId();
        var actualId = WasteManagerService.findById(wasteManagers, expectedId).getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    public void findWasteManagerAddressById(){
        Map<Id, WasteManagerAddress> wasteManagerAddress = new HashMap<>();

        var managerAddress_1 = createWasteManagerAddress(Id.withId("5"), true,"Waste MAnager Address");

        wasteManagerAddress.put(managerAddress_1.getId(), managerAddress_1);

        var expectedId = managerAddress_1.getId();
        var actualId = WasteManagerAddressService.findById(wasteManagerAddress, expectedId).getId();
        assertEquals(expectedId, actualId);
    }

    private WasteManagerAddress createWasteManagerAddress(Id id, Boolean isEnabled, String direccion){
        return WasteManagerAddress.builder().
                id(id).
                isEnabled(isEnabled).
                direccion(direccion).
                build();
    }


    private WasteCenterAuthorization createCenterAuthorization(String authorizationNumber){
        return WasteCenterAuthorization.builder().
                id(Id.withId(authorizationNumber)).
                authorizationNumber(authorizationNumber).
                build();
    }

    private List<WasteCenterAuthorization> createCenterAuthorizations(WasteCenterAuthorization centerAuth){
        List<WasteCenterAuthorization> listOfCenterAuthorization = new ArrayList<>();
        listOfCenterAuthorization.add(centerAuth);
        return listOfCenterAuthorization;
    }

    private WasteManager createManager(Id id, String nombre, String nif, Boolean isEnabled, WasteManagerAddress wasteManagerAddress){
        return WasteManager.builder().
                id(id).
                nombre(nombre).
                nif(nif).
                wasteManagerAddress(wasteManagerAddress).
                isEnabled(isEnabled).
                wasteCenterAuthorizationList(new ArrayList<>()).
                build();
    }

}
