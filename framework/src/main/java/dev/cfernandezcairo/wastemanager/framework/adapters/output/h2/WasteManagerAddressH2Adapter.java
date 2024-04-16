package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerAddressOutputPort;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.mappers.H2Mapper;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.repository.WasteManagerAddressH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteManagerAddressH2Adapter implements WasteManagerAddressOutputPort {

    @Autowired
    private WasteManagerAddressH2 addressRepository;

    @Override
    public WasteManagerAddress retrieveWasteManagerAddress(Long id) {
        var addressData = addressRepository.findById((id));
        return addressData.isEmpty() ? null : H2Mapper.addressDataToDomain(addressData.get());
    }

    /**
     *
     */
    @Override
    public void removeAll() {
        addressRepository.deleteAll();
    }
}
