package dev.cfernandezcairo.wastemanager.application.ports.output;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;

import java.util.List;

public interface WasteManagerOutputPort {
    WasteManager retrieveWasteManager(Long id);
    List<WasteManager> retrieveAll();
    WasteManager removeWasteManager(Long id);
    void removeAll();
    WasteManager persistWasteManager(WasteManager manager);
    List<WasteManager> persistAll(List<WasteManager> managers);
}
