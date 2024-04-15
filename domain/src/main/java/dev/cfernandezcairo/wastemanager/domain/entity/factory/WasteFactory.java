package dev.cfernandezcairo.wastemanager.domain.entity.factory;

import dev.cfernandezcairo.wastemanager.domain.entity.Waste;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;

public class WasteFactory {

    public static Waste getWaste(Id id,
                                 String nombre,
                                 String nif,
                                 WasteManagerAddress wasteManagerAddress,
                                 Boolean isEnabled,
                                 String direccion,
                                 WasteType wasteType){

        switch (wasteType){
            case MANAGER:
                return WasteManager.builder().
                        id(id==null ? Id.withoutId():id).
                        nombre(nombre).
                        nif(nif).
                        wasteManagerAddress(wasteManagerAddress).
                        isEnabled(isEnabled).
                        build();
            case MANAGER_ADDRESS:
                return WasteManagerAddress.builder().
                        id(id==null ? Id.withoutId():id).
                        isEnabled(isEnabled).
                        direccion(direccion).
                        build();
            default:
                return null;
        }
    }
}
