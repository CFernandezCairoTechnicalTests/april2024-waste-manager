package dev.cfernandezcairo.wastemanager.domain.service;

import dev.cfernandezcairo.wastemanager.domain.entity.Waste;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WasteManagerService {

    public static List<WasteManager> filterAndRetrieveWasteManager(List<WasteManager> wasteManagers, Predicate<Waste> wastePredicate){
        return wasteManagers
                .stream()
                .filter(wastePredicate)
                .collect(Collectors.<WasteManager>toList());
    }

    public static WasteManager findById(Map<Long, WasteManager> managersMap, Long id){
        return managersMap.get(id);
    }

    public static WasteManager update(WasteManager origin, WasteManager target) {

        /*Attributes update by contract*/
        target.setNombre(origin.getNombre());
        target.setNif(origin.getNif());

        //target.setIsEnabled(origin.getIsEnabled());
        //target.setWasteManagerAddress(origin.getWasteManagerAddress());
        //target.setListOfWasteCenterAuthorization(origin.getListOfWasteCenterAuthorization());

        return target;
    }
}
