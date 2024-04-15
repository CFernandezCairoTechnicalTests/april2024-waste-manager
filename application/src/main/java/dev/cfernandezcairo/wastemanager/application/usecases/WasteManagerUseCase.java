package dev.cfernandezcairo.wastemanager.application.usecases;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;

public interface WasteManagerUseCase {

    WasteManager createWasteManager(
            String nombre,
            String nif,
            WasteManagerAddress wasteManagerAddress,
            Boolean isEnabled);

    WasteManager removeWasteManager(Id id);

    WasteManager retrieveWasteManager(Id id);

    WasteManager persistManager(WasteManager manager);

}
