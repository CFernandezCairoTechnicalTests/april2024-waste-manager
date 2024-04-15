package dev.cfernandezcairo.wastemanager.application.ports.output;


import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.domain.vo.Id;

public interface WasteManagerAddressOutputPort {
    WasteManagerAddress retrieveWasteManagerAddress(Id id);
}
