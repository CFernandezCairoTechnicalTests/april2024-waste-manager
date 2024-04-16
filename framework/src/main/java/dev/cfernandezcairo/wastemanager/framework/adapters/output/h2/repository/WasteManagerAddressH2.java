package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.repository;

import dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data.WasteManagerAddressData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WasteManagerAddressH2 extends JpaRepository<WasteManagerAddressData, Long> {
}
