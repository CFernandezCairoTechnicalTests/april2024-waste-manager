package dev.cfernandezcairo.wastemanager.framework.adapters.input.rest.data.manager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ManagerDTO {

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    @NotNull
    @Valid
    private String nombre;

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    private String nif;

    @JsonProperty(required = true)
    @NotEmpty
    AddressDTO wasteManagerAddress;

    @JsonProperty(required = true)
    @NotEmpty
    List <AuthorizationDTO> listOfWasteCenterAuthorization;

}
