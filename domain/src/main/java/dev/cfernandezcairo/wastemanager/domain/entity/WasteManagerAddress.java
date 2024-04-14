package dev.cfernandezcairo.wastemanager.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WasteManagerAddress extends Waste {

    private String direccion;

    @Builder
    public WasteManagerAddress(Long id, String direccion, Boolean isEnabled) {
        super(id, isEnabled);
        this.direccion = direccion;
    }

}
