package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.mappers;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.entity.factory.WasteFactory;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data.*;

import java.util.*;

public class H2Mapper {

    public static WasteManager managerDataToDomain(WasteManagerData managerData){
        var managerDomain = WasteFactory.getWaste(
                managerData.getWasteManagerId(),
                managerData.getWasteManagerNombre(),
                managerData.getWasteManagerNif(),
                addressDataToDomain(managerData.getWasteManagerAddress()),
                true,
                getCenterAuthsFromData(managerData.getCenterAuthorizations()),
                "",
                WasteType.MANAGER);

        return (WasteManager) managerDomain;
    }

    public static WasteManagerData managerDomainToData(WasteManager managerDomain){
        var managerData = WasteManagerData.builder().
                wasteManagerId(managerDomain.getId()).
                wasteManagerNombre(managerDomain.getNombre()).
                wasteManagerNif(managerDomain.getNif()).
                wasteManagerAddress(addressDomainToData(managerDomain.getWasteManagerAddress())).
                centerAuthorizations(getcenterAuthsFromDomain(managerDomain.getListOfWasteCenterAuthorization())).
                build();

        return managerData;
    }

    public static WasteManagerAddress addressDataToDomain(WasteManagerAddressData addressData){
        return WasteManagerAddress.builder()
                .id(addressData.getWasteManagerAddressId())
                .isEnabled(true)
                .direccion(addressData.getWasteManagerAddressDireccion())
                .build();
    }
    public static WasteManagerAddressData addressDomainToData(WasteManagerAddress addressDomain){
        return WasteManagerAddressData.builder()
                .wasteManagerAddressId(addressDomain.getId())
                .wasteManagerAddressDireccion(addressDomain.getDireccion())
                .build();
    }

    public static List<WasteManager> getManagersFromData(List<WasteManagerData> wasteManagersData) {
        List<WasteManager> managersDomain = new ArrayList<>();
        wasteManagersData.forEach(managerData -> {
            var managerDomain = managerDataToDomain(managerData);
            managersDomain.add(managerDomain);
        });
        return managersDomain;
    }

    public static List<WasteCenterAuthorization> getCenterAuthsFromData(List<WasteCenterAuthorizationData> wasteCenterAuthorizationData) {
        List<WasteCenterAuthorization> centerAuths = new ArrayList<>();
        wasteCenterAuthorizationData.forEach(data -> {
            var auth = new WasteCenterAuthorization(
                    data.getWasteCenterAuthId(),
                    data.getWasteCenterAuthNumber()
            );
            centerAuths.add(auth);
        });
        return centerAuths;
    }

    public static List<WasteManagerData> getManagersFromDomain(List<WasteManager> managers) {
        List<WasteManagerData> managersData = new ArrayList<>();
        if(managers!=null) {
            managers.forEach(managerDpmain -> {
                var managerData = managerDomainToData(managerDpmain);
                managersData.add(managerData);
            });
        }
        return managersData;
    }

    public static List<WasteCenterAuthorizationData> getcenterAuthsFromDomain(List<WasteCenterAuthorization> centerAuths) {
        List<WasteCenterAuthorizationData> wasteCenterAuthorizationDataList = new ArrayList<>();
        if(centerAuths!=null) {
            centerAuths.forEach(auth -> {
                var authData = new WasteCenterAuthorizationData (
                        auth.getId(),
                        auth.getAuthorizationNumber()
                );
                wasteCenterAuthorizationDataList.add(authData);
            });
        }
        return wasteCenterAuthorizationDataList;
    }

}
