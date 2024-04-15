package dev.cfernandezcairo.wastemanager.domain.entity;

import dev.cfernandezcairo.wastemanager.domain.specification.WasteEnableSpec;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter
@ToString
public class WasteManager extends Waste {


    private String nombre;
    private String nif;

    @Setter
    private WasteManagerAddress wasteManagerAddress;

    @Setter
    private List<WasteCenterAuthorization> listOfWasteCenterAuthorization;

    @Builder
    public WasteManager(Long id, String nombre, String nif, WasteManagerAddress wasteManagerAddress, Boolean isEnabled, List<WasteCenterAuthorization> wasteCenterAuthorizationList) {
        super(id, isEnabled);
        this.nombre = nombre;
        this.nif = nif;
        this.wasteManagerAddress = wasteManagerAddress;
        this.listOfWasteCenterAuthorization = wasteCenterAuthorizationList;
    }

    public boolean addCenterAuthorizationToManager(WasteCenterAuthorization centerAuthorization) {
        var availabilitySpec = new WasteEnableSpec();
        availabilitySpec.check(this);
        return this.listOfWasteCenterAuthorization.add(centerAuthorization);
    }

    public boolean removeCenterAuthorizationFromManager(WasteCenterAuthorization centerAuthorization){
        return this.listOfWasteCenterAuthorization.remove(centerAuthorization);
    }

    public static Predicate<Waste> getWasteManagerNIFPredicate(Waste wasteManager){
        return r -> ((WasteManager) r).getNif().equals(((WasteManager) wasteManager).getNif());
    }

    public static Predicate<WasteCenterAuthorization> getCenterAuthorizationNumberPredicate(String authorizationNumber){
        return s -> s.getAuthorizationNumber().equals(authorizationNumber);
    }
}