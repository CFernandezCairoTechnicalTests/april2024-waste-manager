package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2;

import dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.mappers.H2Mapper;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data.WasteManagerData;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.repository.WasteManagerH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WasteManagerH2Adapter implements WasteManagerOutputPort {

    @Autowired
    private WasteManagerH2 managerRepository;

    @Override
    public WasteManager retrieveWasteManager(Long id) {
        var wasteManagerData = managerRepository.findById(id);
        return wasteManagerData.isEmpty() ? null : H2Mapper.managerDataToDomain(wasteManagerData.get());
    }

    /**
     * @return
     */
    @Override
    public List<WasteManager> retrieveAll() {
        return H2Mapper.getManagersFromData(managerRepository.findAll());
    }

    @Override
    public WasteManager removeWasteManager(Long id) {
        var managerData = managerRepository.findById(id);
        managerRepository.delete(managerData.get());
        return H2Mapper.managerDataToDomain(managerData.get());
    }

    /**
     * @return
     */
    @Override
    public void removeAll() {
        managerRepository.deleteAll();
    }

    @Override
    //@Transactional
    public WasteManager persistWasteManager(WasteManager manager) {
        var managerData = H2Mapper.managerDomainToData(manager);
        WasteManagerData savedManager = managerRepository.saveAndFlush(managerData);
        return H2Mapper.managerDataToDomain(savedManager);
    }

    /**
     * @param managers
     * @return
     */
    @Override
    public List<WasteManager> persistAll(List<WasteManager> managers) {
        List<WasteManagerData> savedManagers = managerRepository.saveAll(H2Mapper.getManagersFromDomain(managers));
        return H2Mapper.getManagersFromData(savedManagers);
    }
}