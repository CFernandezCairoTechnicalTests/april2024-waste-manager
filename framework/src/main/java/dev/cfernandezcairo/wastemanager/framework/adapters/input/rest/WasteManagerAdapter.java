package dev.cfernandezcairo.wastemanager.framework.adapters.input.rest;


import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import dev.cfernandezcairo.wastemanager.framework.adapters.input.rest.data.manager.ManagerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("/manager")
@Tag(name = "Waste Manager Operations", description = "Waste manager operations")
public class WasteManagerAdapter {

    @Autowired
    private WasteManagerUseCase wasteManagerUseCase;

    private static final Logger logger =
            LoggerFactory.getLogger(WasteManagerAdapter.class);

    private static final String ID = "Id";
    private static final String NEW_MANAGER_LOG = "New manager was created id:{}";
    private static final String MANAGER_UPDATED_LOG = "Manager:{} was updated";

    @Operation(operationId = "createManager",
            description = "Create a new manager",
            summary = "Create a new manager")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Manager is created",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = WasteManager.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Manager not created",
                    content = @Content)
    })

    @PostMapping(path = "/create/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<WasteManager> create(@Valid @RequestBody ManagerDTO managerIncomingDTO) {

        var incomingManager = wasteManagerUseCase.createWasteManager(
                managerIncomingDTO.getNombre(),
                managerIncomingDTO.getNif(),
                WasteManagerAddress.builder()
                        .direccion(managerIncomingDTO.getWasteManagerAddress().getDireccion())
                        .isEnabled(true)
                        .build(),
                true
        );
        incomingManager.setListOfWasteCenterAuthorization(
                managerIncomingDTO.getListOfWasteCenterAuthorization().stream().map(e ->
                            WasteCenterAuthorization.builder().
                                    authorizationNumber(e.getAuthorizationNumber()).
                                    build()).
                        toList()
        );

        final WasteManager createdManager =
                wasteManagerUseCase.persistManager(incomingManager);
        logger.info(NEW_MANAGER_LOG, createdManager.toString());

        return Optional.of(createdManager)
                .map(r -> new ResponseEntity<>(r, HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.valueOf("NOT_CREATED")).build());

    }

    @Operation(operationId = "updateManager",
            description = "Update a manager by ID in repository",
            summary = "Update an manager by its id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Manager was updated",
                                        content = {
                                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @Schema(implementation = ManagerDTO.class))
                                        }),
            @ApiResponse(responseCode = "404", description = "Manager not found",
                                        content = @Content)
    })
    @PutMapping(path = "/update/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody ManagerDTO managerIncomingDTO) {

        var incomingManager = wasteManagerUseCase.createWasteManager(
                managerIncomingDTO.getNombre(),
                managerIncomingDTO.getNif(),
                WasteManagerAddress.builder()
                        .direccion(managerIncomingDTO.getWasteManagerAddress().getDireccion())
                        .isEnabled(true)
                        .build(),
                true
        );
        incomingManager.setListOfWasteCenterAuthorization(
                managerIncomingDTO.getListOfWasteCenterAuthorization().stream().map(e ->
                                WasteCenterAuthorization.builder().
                                        authorizationNumber(e.getAuthorizationNumber()).
                                        build()).
                        toList()
        );

        final WasteManager updatedManager =
                wasteManagerUseCase.updateManager(id, incomingManager);
        logger.info(MANAGER_UPDATED_LOG, updatedManager.toString());

        Optional<WasteManager> result =  updatedManager == null ? Optional.empty() : Optional.of(updatedManager);
        return result
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * GET /manager/retrieve/{id}
     */

    @Operation(operationId = "retrieveManager",
            description = "Retrieve a manager from repository",
            summary = "Get a manager by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the manager",
                    content = {
                        @Content(mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = WasteManager.class))
            }),
            @ApiResponse(responseCode = "404", description = "Manager not found", content = @Content)
    })
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<WasteManager> findById(@PathVariable("id") Long id) {

        final WasteManager retievedManager = wasteManagerUseCase.retrieveWasteManager(id);

        Optional<WasteManager> result =  retievedManager == null ? Optional.empty() : Optional.of(retievedManager);
        return result
                .map(manager -> new ResponseEntity<>(manager,HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
