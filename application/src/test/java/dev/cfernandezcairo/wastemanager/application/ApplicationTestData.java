package dev.cfernandezcairo.wastemanager.application;

import dev.cfernandezcairo.wastemanager.application.ports.input.WasteManagerCenterAuthorizationInputPort;
import dev.cfernandezcairo.wastemanager.application.ports.input.WasteManagerInputPort;
import dev.cfernandezcairo.wastemanager.application.ports.input.WasteManagerAddressInputPort;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteCenterAuthorizationUseCase;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerAddressUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.entity.factory.WasteFactory;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationTestData {

    protected WasteManagerUseCase wasteManagerUseCase;

    protected WasteManagerAddressUseCase wasteManagerAddressUseCase;

    protected WasteCenterAuthorizationUseCase wasteCenterAuthorizationUseCase;

    protected WasteManager manager;

    protected WasteManager newManager;

    protected WasteManagerAddress addressManager;

    protected List<WasteManager> managers = new ArrayList<>();

    protected List<WasteManagerAddress> address = new ArrayList<>();

    protected List<WasteCenterAuthorization> authorizations = new ArrayList<>();

    protected WasteCenterAuthorization centerAuth;



    public void loadData(){
        this.wasteManagerUseCase = new WasteManagerInputPort();
        this.wasteManagerAddressUseCase = new WasteManagerAddressInputPort();
        this.wasteCenterAuthorizationUseCase = new WasteManagerCenterAuthorizationInputPort();

        this.centerAuth = WasteCenterAuthorization.builder().
                id(new Random().nextLong()).
                authorizationNumber("authorizationNumber").
                build();
        this.authorizations.add(centerAuth);
        this.addressManager = (WasteManagerAddress) WasteFactory.getWaste(null,
                "",
                "",
                null,
                true,
                null,
                "direccion",
                WasteType.MANAGER_ADDRESS
        );
        this.manager = (WasteManager) WasteFactory.getWaste(1111L,
                "nombre",
                "nif",
                addressManager,
                true,
                null,
                "",
                WasteType.MANAGER
        );
        this.newManager = (WasteManager) WasteFactory.getWaste(null,
                "new nombre",
                "new nif",
                addressManager,
                true,
                null,
                "",
                WasteType.MANAGER
        );
    }
}
