package dev.cfernandezcairo.wastemanager.application.ports.input;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerCenterAuthOutputPort;
import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteCenterAuthorizationUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class WasteManagerCenterAuthorizationInputPort implements WasteCenterAuthorizationUseCase {

    @Autowired
    private WasteManagerOutputPort wasteManagerOutputPort;

    @Autowired
    private WasteManagerCenterAuthOutputPort wasteManagerCenterAuthOutputPort;

    @Override
    public WasteCenterAuthorization createCenterAuthorization(
            String authorizationNumber) {
        return WasteCenterAuthorization
                .builder().
                id(new Random().nextLong())
                .authorizationNumber(authorizationNumber)
                .build();
    }

    public void removeAll() {
        wasteManagerCenterAuthOutputPort.removeAll();
    }

    @Override
    public WasteManager addCenterAuthorizationToManager(WasteCenterAuthorization centerAuth, WasteManager centerManager) {
        Long managerId = centerManager.getId();
        WasteManager managerToAddAuth = wasteManagerOutputPort
                .retrieveWasteManager(managerId);
        managerToAddAuth.addCenterAuthorizationToManager(centerAuth);
        wasteManagerOutputPort.persistWasteManager(managerToAddAuth);
        return managerToAddAuth;
    }

    @Override
    public WasteManager removeCenterAuthorizationFromManager(WasteCenterAuthorization centerAuth, WasteManager centerManager) {
        Long managerId = centerManager.getId();
        WasteManager managerToRemoveAuth = wasteManagerOutputPort
                .retrieveWasteManager(managerId);

        managerToRemoveAuth.removeCenterAuthorizationFromManager(centerAuth);
        wasteManagerOutputPort.persistWasteManager(managerToRemoveAuth);

        return managerToRemoveAuth;
    }
}
