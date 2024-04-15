package dev.cfernandezcairo.wastemanager.domain.service;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WasteManagerAddressService {

    public static List<WasteManagerAddress> filterAndRetrieveWasteManagerAddress(List<WasteManagerAddress> managerAddress, Predicate<WasteManagerAddress> managerAddressPredicate){
        return managerAddress
                .stream()
                .filter(managerAddressPredicate)
                .collect(Collectors.<WasteManagerAddress>toList());
    }

    public static WasteManagerAddress findById(Map<Id, WasteManagerAddress> managerAddressMap, Id id){
        return managerAddressMap.get(id);
    }
}
