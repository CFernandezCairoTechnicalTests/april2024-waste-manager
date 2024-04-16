package dev.cfernandezcairo.wastemanager.application.usecases;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;

import java.util.List;

public interface WasteManagerUseCase {

    WasteManager createWasteManager(
            String nombre,
            String nif,
            WasteManagerAddress wasteManagerAddress,
            Boolean isEnabled);

    WasteManager removeWasteManager(Long id);

    void removeAll();

    WasteManager retrieveWasteManager(Long id);

    List<WasteManager> retrieveAll();

    WasteManager persistManager(WasteManager manager);

    List<WasteManager> persistAll(List<WasteManager> managers);

    WasteManager updateManager(Long id, WasteManager manager);

}
