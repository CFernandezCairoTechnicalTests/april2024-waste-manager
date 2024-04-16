package dev.cfernandezcairo.wastemanager.application.ports.output;


import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;

public interface WasteManagerAddressOutputPort {
    WasteManagerAddress retrieveWasteManagerAddress(Long id);
    void removeAll();
}
