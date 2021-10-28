package com.revature.Spring.models;

import javax.persistence.*;

public class PatientDiagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "age")
    private Integer age;
    @Column(name="complaint")
    private String complaint;
    @Column(name="symptoms")
    private String symptoms;
    @Column(name="medhistory")
    private String medhistory;
    @Column(name="famhistory")
    private String famhistory;
    @Column(name="allergies")
    private String allergies;
    @Column(name="currentmeds")
    private String currentmeds;
    @Column(name = "date")
    private String date;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "height")
    private Integer height;
    @Column(name = "temp")
    private Integer temp;
    @Column(name = "BP")
    private Integer BP;
    @Column(name = "pulse")
    private Integer pulse;
    @Column(name = "diagnosisB")
    private boolean diagnosisB;
    @Column(name = "diagnosisT")
    private String diagnosisT;
    @OneToOne
    @Column(name="covidId")
    private String covidId;
    @ManyToOne
    @Column(name = "nurseId")
    private Integer nurseId;
    @ManyToOne
    @Column(name = "doctorId")
    private Integer doctorId;

}
