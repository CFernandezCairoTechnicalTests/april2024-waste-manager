package dev.cfernandezcairo.wastemanager.application.ports.input;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.entity.factory.WasteFactory;
import dev.cfernandezcairo.wastemanager.domain.service.WasteManagerService;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
                null,
                "",
                WasteType.MANAGER
        );
    }

    @Override
    public WasteManager removeWasteManager(Long id) {
        return wasteManagerOutputPort.removeWasteManager(id);
    }

    /**
     * @return
     */
    @Override
    public void removeAll() {
        wasteManagerOutputPort.removeAll();
    }

    @Override
    public WasteManager retrieveWasteManager(Long id) {
        return wasteManagerOutputPort.retrieveWasteManager(id);
    }

    /**
     * @return
     */
    @Override
    public List<WasteManager> retrieveAll() {
       return wasteManagerOutputPort.retrieveAll();
    }

    @Override
    public WasteManager persistManager(WasteManager manager) {
        return wasteManagerOutputPort.persistWasteManager(manager);
    }

    /**
     * @param managers
     * @return
     */
    @Override
    public List<WasteManager> persistAll(List<WasteManager> managers) {
        return wasteManagerOutputPort.persistAll(managers);
    }

    /**
     * @param id
     * @param managerOrigin
     * @return
     */
    @Override
    public WasteManager updateManager(Long id, WasteManager managerOrigin) {

        WasteManager managerTarget = wasteManagerOutputPort.retrieveWasteManager(id);
        managerTarget =  WasteManagerService.update(managerOrigin, managerTarget);
        managerTarget = wasteManagerOutputPort.persistWasteManager(managerTarget);

        return managerTarget;

    }

}