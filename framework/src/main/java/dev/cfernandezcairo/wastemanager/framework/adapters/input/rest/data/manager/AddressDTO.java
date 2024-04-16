package dev.cfernandezcairo.wastemanager.framework.adapters.input.rest.data.manager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AddressDTO {

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    private String direccion;

}
