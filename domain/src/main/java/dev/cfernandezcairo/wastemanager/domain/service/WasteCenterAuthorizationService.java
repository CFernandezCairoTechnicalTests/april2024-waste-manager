package dev.cfernandezcairo.wastemanager.domain.service;

import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WasteCenterAuthorizationService {

    public static List<WasteCenterAuthorization> filterAndRetrieveWasteCenterAuthorization(List<WasteCenterAuthorization> centerAuthorizations, Predicate<WasteCenterAuthorization> centerAuthorizationPredicate){
        return centerAuthorizations
                .stream()
                .filter(centerAuthorizationPredicate)
                .collect(Collectors.<WasteCenterAuthorization>toList());
    }

    public static WasteCenterAuthorization findCenterAuthorization(List<WasteCenterAuthorization> centerAuthorizations, Predicate<WasteCenterAuthorization> centerAuthorizationPredicate){
        return centerAuthorizations
                .stream()
                .filter(centerAuthorizationPredicate)
                .findFirst().orElse(null);
    }

}
