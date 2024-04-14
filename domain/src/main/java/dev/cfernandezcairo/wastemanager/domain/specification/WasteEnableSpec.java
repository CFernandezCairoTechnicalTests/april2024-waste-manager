package dev.cfernandezcairo.wastemanager.domain.specification;

import dev.cfernandezcairo.wastemanager.domain.entity.Waste;
import dev.cfernandezcairo.wastemanager.domain.exception.GenericSpecificationException;
import dev.cfernandezcairo.wastemanager.domain.specification.shared.AbstractSpecification;


public class WasteEnableSpec extends AbstractSpecification<Waste> {

    @Override
    public boolean isSatisfiedBy(Waste waste) {
        return waste.getIsEnabled();
    }

    @Override
    public void check(Waste aWaste) throws GenericSpecificationException {
        if(!isSatisfiedBy(aWaste))
            throw new GenericSpecificationException("It's not enabled");
    }
}
