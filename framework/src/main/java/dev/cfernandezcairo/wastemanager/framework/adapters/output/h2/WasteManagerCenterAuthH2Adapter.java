package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerCenterAuthOutputPort;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.repository.WasteManagerCenterAuthH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteManagerCenterAuthH2Adapter implements WasteManagerCenterAuthOutputPort {

    @Autowired
    private WasteManagerCenterAuthH2 authRepository;

    /**
     *
     */
    @Override
    public void removeAll() {
        authRepository.deleteAll();
    }
}
