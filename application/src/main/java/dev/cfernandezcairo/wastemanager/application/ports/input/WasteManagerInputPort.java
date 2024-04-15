package dev.cfernandezcairo.wastemanager.application.ports.input;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.entity.factory.WasteFactory;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WasteManagerInputPort implements WasteManagerUseCase {


    @Autowired
    private WasteManagerOutputPort wasteManagerOutputPort;

    @Override
    public WasteManager createWasteManager(String nombre,
                                    String nif,
                                    WasteManagerAddress wasteManagerAddress,
                                    Boolean isEnabled) {
        return (WasteManager) WasteFactory.getWaste(null,
                nombre,
                nif,
                wasteManagerAddress,
                isEnabled,
                "",
                WasteType.MANAGER
        );
    }

    @Override
    public WasteManager removeWasteManager(Id id) {
        return wasteManagerOutputPort.removeWasteManager(id);
    }

    @Override
    public WasteManager retrieveWasteManager(Id id) {
        return wasteManagerOutputPort.retrieveWasteManager(id);
    }

    @Override
    public WasteManager persistManager(WasteManager manager) {
        return wasteManagerOutputPort.persistWasteManager(manager);
    }

}