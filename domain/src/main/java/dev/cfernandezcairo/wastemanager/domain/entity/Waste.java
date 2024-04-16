package dev.cfernandezcairo.wastemanager.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public abstract class Waste {
    protected Long id;

    @Setter
    protected Boolean isEnabled;

    public static Predicate<Waste> getEnabledPredicate(Boolean status){
        return r -> r.isEnabled == status;
    }
}
