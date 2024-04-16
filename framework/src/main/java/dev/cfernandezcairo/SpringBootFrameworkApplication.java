package dev.cfernandezcairo;


//import net.lecousin.reactive.data.relational.repository.LcR2dbcRepositoryFactoryBean;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteCenterAuthorizationUseCase;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerAddressUseCase;
import dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteCenterAuthorization;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManager;
import dev.cfernandezcairo.wastemanager.domain.entity.WasteManagerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.ArrayList;

@Slf4j
@SpringBootApplication
//@EnableJpaRepositories
@EnableJpaAuditing
public class SpringBootFrameworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFrameworkApplication.class, args);
    }

    @Autowired
    private WasteManagerUseCase wasteManagerUseCase;

    @Autowired
    private WasteManagerAddressUseCase wasteManagerAddressUseCase;

    @Autowired
    private WasteCenterAuthorizationUseCase wasteCenterAuthorizationUseCase;

    @Override
    public void run(String... args) throws Exception {
        // Clean up database tables
        //wasteCenterAuthorizationUseCase.removeAll();
        //wasteManagerAddressUseCase.removeAll();
        //wasteManagerUseCase.removeAll();

        WasteManagerAddress address1 = new WasteManagerAddress(1L, "Direccion 01", true);
        WasteManagerAddress address2 = new WasteManagerAddress(2L, "Direccion 02", true);
        WasteManagerAddress address3 = new WasteManagerAddress(3L, "Direccion 03", true);
        WasteManagerAddress address4 = new WasteManagerAddress(4L, "Direccion 04", true);
        WasteManagerAddress address5 = new WasteManagerAddress(5L, "Direccion 04", true);


        WasteCenterAuthorization auth11 = new WasteCenterAuthorization(1L, "Code 11");
        WasteCenterAuthorization auth12 = new WasteCenterAuthorization(2L, "Code 12");
        WasteCenterAuthorization auth13 = new WasteCenterAuthorization(3L, "Code 13");
        WasteCenterAuthorization auth21 = new WasteCenterAuthorization(4L, "Code 21");
        WasteCenterAuthorization auth22 = new WasteCenterAuthorization(5L, "Code 22");
        WasteCenterAuthorization auth31 = new WasteCenterAuthorization(6L, "Code 31");
        WasteCenterAuthorization auth41 = new WasteCenterAuthorization(7L, "Code 41");


        WasteManager manager1 = new WasteManager(1L, "Nombre 01", "Nif 01", address1, true, new ArrayList<>());
        manager1.addCenterAuthorizationToManager(auth11);
        manager1.addCenterAuthorizationToManager(auth12);
        manager1.addCenterAuthorizationToManager(auth13);

        WasteManager manager2 = new WasteManager(2L, "Nombre 02", "Nif 02", address2, true, new ArrayList<>());
        manager2.addCenterAuthorizationToManager(auth21);
        manager2.addCenterAuthorizationToManager(auth22);

        WasteManager manager3 = new WasteManager(3L, "Nombre 03", "Nif 03", address3, true, new ArrayList<>());
        manager3.addCenterAuthorizationToManager(auth31);

        WasteManager manager4 = new WasteManager(4L, "Nombre 04", "Nif 04", address4, true, new ArrayList<>());
        manager4.addCenterAuthorizationToManager(auth41);

        WasteManager manager5 = new WasteManager(5L, "Nombre 05", "Nif 05", address5, true, new ArrayList<>());

        //manager1 = wasteManagerUseCase.persistManager(manager1);
        //manager2 = wasteManagerUseCase.persistManager(manager2);
        //manager3 = wasteManagerUseCase.persistManager(manager3);
        //manager4 = wasteManagerUseCase.persistManager(manager4);
        //manager5 = wasteManagerUseCase.persistManager(manager5);


        manager4.setNif("Nif 04 updated");
        WasteCenterAuthorization auth42 = new WasteCenterAuthorization(8L, "Code 42 updated");
        manager4.addCenterAuthorizationToManager(auth42);
        //wasteManagerUseCase.updateManager(manager4.getId(), manager4);

    }

}
