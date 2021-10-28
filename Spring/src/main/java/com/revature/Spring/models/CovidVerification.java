package com.revature.Spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CovidVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "covid_id")
    int covidId;
    @Column(name = "covid_status")
    String covidStatus;
    @Column(name = "vaccination_status")
    boolean vaccinationStatus;

}
