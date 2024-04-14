package dev.cfernandezcairo.wastemanager.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Waste {
    protected Long id;
    protected Boolean isEnabled;
}
