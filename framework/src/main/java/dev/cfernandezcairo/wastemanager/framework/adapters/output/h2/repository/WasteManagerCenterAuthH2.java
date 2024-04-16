package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.repository;

import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data.WasteCenterAuthorizationData;
import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data.WasteManagerAddressData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteManagerCenterAuthH2 extends JpaRepository<WasteCenterAuthorizationData, Long> {
}
