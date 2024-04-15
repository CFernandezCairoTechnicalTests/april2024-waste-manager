package dev.cfernandezcairo.wastemanager.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class Id {

    private final Long id;

    private Id(Long id){
        this.id = id;
    }

    public static Id withId(String id){
        return new Id(Long.valueOf(id));
    }

    public static Id withoutId(){
        return new Id(new Random().nextLong());
    }
}
