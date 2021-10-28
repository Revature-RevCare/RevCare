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
    @Column(name = "blood_pressure")
    private Integer blood_pressure;
    @Column(name = "pulse")
    private Integer pulse;
    @Column(name = "doctor_verification")
    private boolean doctor_verification;
    @Column(name = "diagnosis_text")
    private String diagnosis_text;
    //@OneToOne
    @Column(name="covid_id")
    private String covid_id;
    //@ManyToOne
    @Column(name = "nurse_id")
    private Integer nurse_id;
    //@ManyToOne
    @Column(name = "doctor_id")
    private Integer doctor_id;

    public PatientDiagnosis() {
    }

    public PatientDiagnosis(String fname, String lname, Integer patient_age, String complaint, String symptoms, String med_history, String fam_history, String allergies, String current_meds, String current_date, Integer patient_weight, Integer patient_height, Integer patient_temp, Integer blood_pressure, Integer pulse, boolean doctor_verification, String diagnosis_text, String covidId, Integer nurseId, Integer doctorId) {
        this.fname = fname;
        this.lname = lname;
        this.patient_age = patient_age;
        this.complaint = complaint;
        this.symptoms = symptoms;
        this.med_history = med_history;
        this.fam_history = fam_history;
        this.allergies = allergies;
        this.current_meds = current_meds;
        this.current_date = current_date;
        this.patient_weight = patient_weight;
        this.patient_height = patient_height;
        this.patient_temp = patient_temp;
        this.blood_pressure = blood_pressure;
        this.pulse = pulse;
        this.doctor_verification = doctor_verification;
        this.diagnosis_text = diagnosis_text;
        this.covidId = covidId;
        this.nurseId = nurseId;
        this.doctorId = doctorId;
    }

    public PatientDiagnosis(Integer id, String fname, String lname, Integer patient_age, String complaint, String symptoms, String med_history, String fam_history, String allergies, String current_meds, String current_date, Integer patient_weight, Integer patient_height, Integer patient_temp, Integer blood_pressure, Integer pulse, boolean doctor_verification, String diagnosis_text, String covidId, Integer nurseId, Integer doctorId) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.patient_age = patient_age;
        this.complaint = complaint;
        this.symptoms = symptoms;
        this.med_history = med_history;
        this.fam_history = fam_history;
        this.allergies = allergies;
        this.current_meds = current_meds;
        this.current_date = current_date;
        this.patient_weight = patient_weight;
        this.patient_height = patient_height;
        this.patient_temp = patient_temp;
        this.blood_pressure = blood_pressure;
        this.pulse = pulse;
        this.doctor_verification = doctor_verification;
        this.diagnosis_text = diagnosis_text;
        this.covidId = covidId;
        this.nurseId = nurseId;
        this.doctorId = doctorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(Integer patient_age) {
        this.patient_age = patient_age;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getMed_history() {
        return med_history;
    }

    public void setMed_history(String med_history) {
        this.med_history = med_history;
    }

    public String getFam_history() {
        return fam_history;
    }

    public void setFam_history(String fam_history) {
        this.fam_history = fam_history;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getCurrent_meds() {
        return current_meds;
    }

    public void setCurrent_meds(String current_meds) {
        this.current_meds = current_meds;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public Integer getPatient_weight() {
        return patient_weight;
    }

    public void setPatient_weight(Integer patient_weight) {
        this.patient_weight = patient_weight;
    }

    public Integer getPatient_height() {
        return patient_height;
    }

    public void setPatient_height(Integer patient_height) {
        this.patient_height = patient_height;
    }

    public Integer getPatient_temp() {
        return patient_temp;
    }

    public void setPatient_temp(Integer patient_temp) {
        this.patient_temp = patient_temp;
    }

    public Integer getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(Integer blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public boolean isDoctor_verification() {
        return doctor_verification;
    }

    public void setDoctor_verification(boolean doctor_verification) {
        this.doctor_verification = doctor_verification;
    }

    public String getDiagnosis_text() {
        return diagnosis_text;
    }

    public void setDiagnosis_text(String diagnosis_text) {
        this.diagnosis_text = diagnosis_text;
    }

    public String getCovidId() {
        return covidId;
    }

    public void setCovidId(String covidId) {
        this.covidId = covidId;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "PatientDiagnosis{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", patient_age=" + patient_age +
                ", complaint='" + complaint + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", med_history='" + med_history + '\'' +
                ", fam_history='" + fam_history + '\'' +
                ", allergies='" + allergies + '\'' +
                ", current_meds='" + current_meds + '\'' +
                ", current_date='" + current_date + '\'' +
                ", patient_weight=" + patient_weight +
                ", patient_height=" + patient_height +
                ", patient_temp=" + patient_temp +
                ", blood_pressure=" + blood_pressure +
                ", pulse=" + pulse +
                ", doctor_verification=" + doctor_verification +
                ", diagnosis_text='" + diagnosis_text + '\'' +
                ", covidId='" + covidId + '\'' +
                ", nurseId=" + nurseId +
                ", doctorId=" + doctorId +
                '}';
    }
}
