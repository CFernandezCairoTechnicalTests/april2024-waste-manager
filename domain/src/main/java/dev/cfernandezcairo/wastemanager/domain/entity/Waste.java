package dev.cfernandezcairo.wastemanager.domain.entity;

import dev.cfernandezcairo.wastemanager.domain.vo.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public abstract class Waste {
    protected Id id;
    protected Boolean isEnabled;

    public static Predicate<Waste> getEnabledPredicate(Boolean status){
        return r -> r.isEnabled == status;
    }
}
