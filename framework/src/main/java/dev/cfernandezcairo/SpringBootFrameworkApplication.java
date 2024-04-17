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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
//import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class SpringBootFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFrameworkApplication.class, args);
    }

}
