package dev.cfernandezcairo.wastemanager.application.usecases;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;

public interface WasteManagerAddressUseCase {

    WasteManagerAddress createWasteManagerAddress(
            Boolean isEnabled,
            String direccion
            );

    void removeAll();

    WasteManagerAddress retrieveWasteManagerAddress(Long id);

}
