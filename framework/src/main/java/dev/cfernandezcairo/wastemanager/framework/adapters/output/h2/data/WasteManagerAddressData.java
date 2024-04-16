package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "waste_manager_address_data")
public class WasteManagerAddressData extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="waste_manager_address_id",
            columnDefinition = "long",
            updatable = false )
    private Long wasteManagerAddressId;

    @Column(name="waste_manager_address_direccion")
    private String wasteManagerAddressDireccion;

}
