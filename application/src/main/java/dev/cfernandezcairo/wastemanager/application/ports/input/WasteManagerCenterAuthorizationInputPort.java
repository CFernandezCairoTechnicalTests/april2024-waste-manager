package dev.cfernandezcairo.wastemanager.application.ports.input;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteCenterAuthorizationUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WasteManagerCenterAuthorizationInputPort implements WasteCenterAuthorizationUseCase {

    @Autowired
    private WasteManagerOutputPort wasteManagerOutputPort;

    @Override
    public WasteCenterAuthorization createCenterAuthorization(
            String authorizationNumber) {
        return WasteCenterAuthorization
                .builder().
                id(Id.withoutId())
                .authorizationNumber(authorizationNumber)
                .build();
    }

    @Override
    public WasteManager addCenterAuthorizationToManager(WasteCenterAuthorization centerAuth, WasteManager centerManager) {
        Id managerId = centerManager.getId();
        WasteManager managerToAddAuth = wasteManagerOutputPort
                .retrieveWasteManager(managerId);
        managerToAddAuth.addCenterAuthorizationToManager(centerAuth);
        wasteManagerOutputPort.persistWasteManager(managerToAddAuth);
        return managerToAddAuth;
    }

    @Override
    public WasteManager removeCenterAuthorizationFromManager(WasteCenterAuthorization centerAuth, WasteManager centerManager) {
        Id managerId = centerManager.getId();
        WasteManager managerToRemoveAuth = wasteManagerOutputPort
                .retrieveWasteManager(managerId);

        managerToRemoveAuth.removeCenterAuthorizationFromManager(centerAuth);
        wasteManagerOutputPort.persistWasteManager(managerToRemoveAuth);

        return managerToRemoveAuth;
    }
}
