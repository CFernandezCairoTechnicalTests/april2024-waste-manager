package dev.cfernandezcairo.wastemanager.domain.entity.factory;

import dev.cfernandezcairo.wastemanager.domain.entity.Waste;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;

import java.util.List;
import java.util.Random;

public class WasteFactory {

    public static Waste getWaste(Long id,
                                 String nombre,
                                 String nif,
                                 WasteManagerAddress wasteManagerAddress,
                                 Boolean isEnabled,
                                 List<WasteCenterAuthorization> auths,
                                 String direccion,
                                 WasteType wasteType){

        switch (wasteType){
            case MANAGER:
                return WasteManager.builder().
                        id(id==null ? new Random().nextLong() : id).
                        nombre(nombre).
                        nif(nif).
                        wasteManagerAddress(wasteManagerAddress).
                        wasteCenterAuthorizationList(auths).
                        isEnabled(isEnabled).
                        build();
            case MANAGER_ADDRESS:
                return WasteManagerAddress.builder().
                        id(id==null ? new Random().nextLong() : id).
                        isEnabled(isEnabled).
                        direccion(direccion).
                        build();
            default:
                return null;
        }
    }
}
