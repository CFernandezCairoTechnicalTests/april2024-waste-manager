package dev.cfernandezcairo.wastemanager.application.ports.output;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;

public interface WasteManagerOutputPort {
    WasteManager retrieveWasteManager(Id id);

    WasteManager removeWasteManager(Id id);

    WasteManager persistWasteManager(WasteManager manager);
}
