package dev.cfernandezcairo.wastemanager.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Predicate;

@Getter
@ToString
public class WasteManagerAddress extends Waste {

    private String direccion;

    @Builder
    public WasteManagerAddress(Long id, String direccion, Boolean isEnabled) {
        super(id, isEnabled);
        this.direccion = direccion;
    }

    public static Predicate<WasteManagerAddress> getWasteManagerAddressDireccionPredicate(WasteManagerAddress wasteManagerAddress){
        return r -> r.getDireccion().equals(wasteManagerAddress.getDireccion());
    }

}