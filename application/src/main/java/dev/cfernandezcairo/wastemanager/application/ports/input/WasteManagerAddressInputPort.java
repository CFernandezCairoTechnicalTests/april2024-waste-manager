package dev.cfernandezcairo.wastemanager.application.ports.input;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerAddressOutputPort;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerAddressUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.entity.factory.WasteFactory;
import dev.cfernandezcairo.wastemanager.domain.vo.WasteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WasteManagerAddressInputPort implements WasteManagerAddressUseCase {

    @Autowired
    private WasteManagerAddressOutputPort wasteManagerAddressOutputPort;

    @Override
    public WasteManagerAddress createWasteManagerAddress(
            Boolean isEnabled,
            String direccion) {
        return (WasteManagerAddress) WasteFactory.getWaste(null,
                "",
                "",
                null,
                isEnabled,
                null,
                direccion,
                WasteType.MANAGER_ADDRESS
        );
    }

    /**
     *
     */
    @Override
    public void removeAll() {
        wasteManagerAddressOutputPort.removeAll();
    }

    public WasteManagerAddress retrieveWasteManagerAddress(Long id) {
        return wasteManagerAddressOutputPort.retrieveWasteManagerAddress(id);
    }
}
