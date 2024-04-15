package dev.cfernandezcairo.wastemanager.domain.entity;

import dev.cfernandezcairo.wastemanager.domain.vo.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Predicate;

@Getter
@ToString
public class WasteCenterAuthorization {

    private Id id;
    private String authorizationNumber;

    @Builder
    public WasteCenterAuthorization(Id id, String authorizationNumber) {
        this.id = id;
        this.authorizationNumber = authorizationNumber;
    }

    public static Predicate<WasteCenterAuthorization> getCenterAuthorizationNumberPredicate(String authorizationNumber){
        return s -> s.getAuthorizationNumber().equals(authorizationNumber);
    }
}