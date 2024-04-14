package dev.cfernandezcairo.wastemanager.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Predicate;

@Getter
@ToString
public class WasteCenterAuthorization {

    private Long id;
    private String authorizationNumber;

    @Builder
    public WasteCenterAuthorization(Long id, String authorizationNumber) {
        this.id = id;
        this.authorizationNumber = authorizationNumber;
    }

    public static Predicate<WasteCenterAuthorization> getCenterAuthorizationNumberPredicate(String authorizationNumber){
        return s -> s.getAuthorizationNumber().equals(authorizationNumber);
    }
}