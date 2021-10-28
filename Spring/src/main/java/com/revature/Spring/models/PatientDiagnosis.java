package com.revature.Spring.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="patient_diagnosis")
public class PatientDiagnosis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "patient_age")
    private Integer patient_age;
    @Column(name="complaint")
    private String complaint;
    @Column(name="symptoms")
    private String symptoms;
    @Column(name="med_history")
    private String med_history;
    @Column(name="fam_history")
    private String fam_history;
    @Column(name="allergies")
    private String allergies;
    @Column(name="current_meds")
    private String current_meds;
    @Column(name = "current_date")
    private String current_date;
    @Column(name = "patient_weight")
    private Integer patient_weight;
    @Column(name = "patient_height")
    private Integer patient_height;
    @Column(name = "patient_temp")
    private Integer patient_temp;
    @Column(name = "BP")
    private Integer BP;
    @Column(name = "pulse")
    private Integer pulse;
    @Column(name = "diagnosis_boolean")
    private boolean diagnosis_boolean;
    @Column(name = "diagnosis_text")
    private String diagnosis_text;
    //@OneToOne
    @Column(name="covidId")
    private String covidId;
    //@ManyToOne
    @Column(name = "nurseId")
    private Integer nurseId;
    //@ManyToOne
    @Column(name = "doctorId")
    private Integer doctorId;

}
