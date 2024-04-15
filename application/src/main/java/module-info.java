module application {
    requires domain;
    requires static lombok;
    requires spring.beans;
    requires spring.boot;
    requires spring.context;

    exports dev.cfernandezcairo.wastemanager.application.ports.input;
    exports dev.cfernandezcairo.wastemanager.application.ports.output;
    exports dev.cfernandezcairo.wastemanager.application.usecases;

    opens dev.cfernandezcairo.wastemanager.application.ports.input; //open to spring.core

    provides dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase
            with dev.cfernandezcairo.wastemanager.application.ports.input.WasteManagerInputPort;
    provides dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerAddressUseCase
            with dev.cfernandezcairo.wastemanager.application.ports.input.WasteManagerAddressInputPort;
    provides dev.cfernandezcairo.wastemanager.application.usecases.WasteCenterAuthorizationUseCase
            with dev.cfernandezcairo.wastemanager.application.ports.input.WasteManagerCenterAuthorizationInputPort;
}