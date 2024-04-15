package dev.cfernandezcairo.wastemanager.application.usecases;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;

public interface WasteManagerAddressUseCase {

    WasteManagerAddress createWasteManagerAddress(
            Boolean isEnabled,
            String direccion
            );

    WasteManagerAddress retrieveWasteManagerAddress(Id id);

}
