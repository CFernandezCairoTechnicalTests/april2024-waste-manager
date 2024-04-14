package dev.cfernandezcairo.wastemanager.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

}
