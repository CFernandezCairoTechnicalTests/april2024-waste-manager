package dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "waste_center_auth_data")
public class WasteCenterAuthorizationData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="waste_center_auth_id",
            columnDefinition = "long",
            updatable = false )
    private Long wasteCenterAuthId;

    @Column(name="waste_center_auth_number")
    private String wasteCenterAuthNumber;

}
