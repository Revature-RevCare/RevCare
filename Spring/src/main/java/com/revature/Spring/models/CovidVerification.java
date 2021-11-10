
package com.revature.Spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * CovidVerification class implements Serializable. Table annotated to match DB table "covid_verification".
 * Uses lombok @AllArgsConstructor and @NoArgsConstructor annotations
 */
@Entity
@Table(name = "covid_verification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidVerification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "covid_id")
    private Integer covidId;
    @Column(name = "covid_status")
    private String covidStatus;
    @Column(name = "vaccination_status")
    private boolean vaccinationStatus;

}

