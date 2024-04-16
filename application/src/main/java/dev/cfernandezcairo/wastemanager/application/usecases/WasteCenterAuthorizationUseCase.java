package dev.cfernandezcairo.wastemanager.application.usecases;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;

public interface WasteCenterAuthorizationUseCase {

    WasteCenterAuthorization createCenterAuthorization(
            String authorizationNumber);

    void removeAll();

    WasteManager addCenterAuthorizationToManager(WasteCenterAuthorization centerAuth, WasteManager manager);

    WasteManager removeCenterAuthorizationFromManager(WasteCenterAuthorization centerAuth, WasteManager manager);
}
