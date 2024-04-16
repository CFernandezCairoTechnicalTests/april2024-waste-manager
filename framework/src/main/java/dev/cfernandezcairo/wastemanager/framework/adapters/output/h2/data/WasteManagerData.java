package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "waste_manager_data")
public class WasteManagerData extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="waste_manager_id",
            columnDefinition = "long",
            updatable = false )
    private Long wasteManagerId;

    @Column(name="waste_manager_nombre")
    private String wasteManagerNombre;

    @Column(name="waste_manager_nif")
    private String wasteManagerNif;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL/*,
            mappedBy = "manager"*/)
    @JoinColumn(name = "waste_manager_address_id", referencedColumnName = "waste_manager_address_id", nullable = false)
    private WasteManagerAddressData wasteManagerAddress;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "waste_manager_id", referencedColumnName = "waste_manager_id", nullable = false)
    List <WasteCenterAuthorizationData> centerAuthorizations = new ArrayList< >();
}
