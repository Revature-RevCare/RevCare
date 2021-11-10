package com.revature.Spring.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Entity model class PatientDiagnosis annotated to match DB table "patient_diagnosis"
 */
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
    @Column(name = "submission_date")
    private LocalDate current_date;
    @Column(name = "patient_weight")
    private float patient_weight;
    @Column(name = "patient_height")
    private float patient_height;
    @Column(name = "patient_temp")
    private float patient_temp;
    @Column(name = "blood_pressure_high")
    private Integer blood_pressure_high;
    @Column(name = "blood_pressure_low")
    private Integer blood_pressure_low;
    @Column(name = "pulse")
    private Integer pulse;
    @Column(name = "doctor_verification")
    private boolean doctor_verification;
    @Column(name = "diagnosis_text")
    private String diagnosis_text;
    //@OneToOne
    @Column(name="covid_id")
    private Integer covid_id;
    //@ManyToOne
    @Column(name = "nurse_id")
    private Integer nurse_id;
    //@ManyToOne
    @Column(name = "doctor_id")
    private Integer doctor_id;

    /**
     * PatientDiagnosis no-arg constructor
     */
    public PatientDiagnosis() {
    }


    /**
     * PatientDiagnosis with args constructor 1
     * @param fname
     * @param lname
     * @param patient_age
     * @param complaint
     * @param symptoms
     * @param med_history
     * @param fam_history
     * @param allergies
     * @param current_meds
     * @param current_date
     * @param patient_weight
     * @param patient_height
     * @param patient_temp
     * @param blood_pressure_high
     * @param blood_pressure_low
     * @param pulse
     * @param doctor_verification
     * @param diagnosis_text
     * @param covid_id
     * @param nurse_id
     * @param doctor_id
     */
    public PatientDiagnosis(String fname, String lname, Integer patient_age, String complaint, String symptoms, String med_history, String fam_history, String allergies, String current_meds, LocalDate current_date, Integer patient_weight, Integer patient_height, float patient_temp, Integer blood_pressure_high, Integer blood_pressure_low, Integer pulse, boolean doctor_verification, String diagnosis_text, Integer covid_id, Integer nurse_id, Integer doctor_id) {

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
        this.blood_pressure_high = blood_pressure_high;
        this.blood_pressure_low = blood_pressure_low;
        this.pulse = pulse;
        this.doctor_verification = doctor_verification;
        this.diagnosis_text = diagnosis_text;
        this.covid_id = covid_id;
        this.nurse_id = nurse_id;
        this.doctor_id = doctor_id;
    }

    /**
     * PatientDiagnosis with args constructor 2
     * @param id
     * @param fname
     * @param lname
     * @param patient_age
     * @param complaint
     * @param symptoms
     * @param med_history
     * @param fam_history
     * @param allergies
     * @param current_meds
     * @param current_date
     * @param patient_weight
     * @param patient_height
     * @param patient_temp
     * @param blood_pressure_high
     * @param blood_pressure_low
     * @param pulse
     * @param doctor_verification
     * @param diagnosis_text
     * @param covid_id
     * @param nurse_id
     * @param doctor_id
     */
    public PatientDiagnosis(Integer id, String fname, String lname, Integer patient_age, String complaint, String symptoms, String med_history, String fam_history, String allergies, String current_meds, LocalDate current_date, Integer patient_weight, Integer patient_height, float patient_temp, Integer blood_pressure_high, Integer blood_pressure_low, Integer pulse, boolean doctor_verification, String diagnosis_text, Integer covid_id, Integer nurse_id, Integer doctor_id) {
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
        this.blood_pressure_high = blood_pressure_high;
        this.blood_pressure_low = blood_pressure_low;
        this.pulse = pulse;
        this.doctor_verification = doctor_verification;
        this.diagnosis_text = diagnosis_text;
        this.covid_id = covid_id;
        this.nurse_id = nurse_id;
        this.doctor_id = doctor_id;
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

    public LocalDate getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(LocalDate current_date) {
        this.current_date = current_date;
    }

    public float getPatient_weight() {
        return patient_weight;
    }

    public void setPatient_weight(float patient_weight) {
        this.patient_weight = patient_weight;
    }

    public float getPatient_height() {
        return patient_height;
    }

    public void setPatient_height(float patient_height) {
        this.patient_height = patient_height;
    }

    public float getPatient_temp() {
        return patient_temp;
    }

    public void setPatient_temp(float patient_temp) {
        this.patient_temp = patient_temp;
    }

    public Integer getBlood_pressure_high() {
        return blood_pressure_high;
    }

    public void setBlood_pressure_high(Integer blood_pressure_high) {
        this.blood_pressure_high = blood_pressure_high;
    }

    public Integer getBlood_pressure_low() {
        return blood_pressure_low;
    }

    public void setBlood_pressure_low(Integer blood_pressure_low) {
        this.blood_pressure_low = blood_pressure_low;
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

    public Integer getCovid_id() {
        return covid_id;
    }

    public void setCovid_id(Integer covid_id) {
        this.covid_id = covid_id;
    }

    public Integer getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(Integer nurse_id) {
        this.nurse_id = nurse_id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
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
                ", current_date=" + current_date +
                ", patient_weight=" + patient_weight +
                ", patient_height=" + patient_height +
                ", patient_temp=" + patient_temp +
                ", blood_pressure_high=" + blood_pressure_high +
                ", blood_pressure_low=" + blood_pressure_low +
                ", pulse=" + pulse +
                ", doctor_verification=" + doctor_verification +
                ", diagnosis_text='" + diagnosis_text + '\'' +
                ", covid_id=" + covid_id +
                ", nurse_id=" + nurse_id +
                ", doctor_id=" + doctor_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientDiagnosis)) return false;
        PatientDiagnosis that = (PatientDiagnosis) o;
        return Float.compare(that.patient_weight, patient_weight) == 0 && Float.compare(that.patient_height, patient_height) == 0 && Float.compare(that.patient_temp, patient_temp) == 0 && doctor_verification == that.doctor_verification && Objects.equals(id, that.id) && Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(patient_age, that.patient_age) && Objects.equals(complaint, that.complaint) && Objects.equals(symptoms, that.symptoms) && Objects.equals(med_history, that.med_history) && Objects.equals(fam_history, that.fam_history) && Objects.equals(allergies, that.allergies) && Objects.equals(current_meds, that.current_meds) && Objects.equals(current_date, that.current_date) && Objects.equals(blood_pressure_high, that.blood_pressure_high) && Objects.equals(blood_pressure_low, that.blood_pressure_low) && Objects.equals(pulse, that.pulse) && Objects.equals(diagnosis_text, that.diagnosis_text) && Objects.equals(covid_id, that.covid_id) && Objects.equals(nurse_id, that.nurse_id) && Objects.equals(doctor_id, that.doctor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname, patient_age, complaint, symptoms, med_history, fam_history, allergies, current_meds, current_date, patient_weight, patient_height, patient_temp, blood_pressure_high, blood_pressure_low, pulse, doctor_verification, diagnosis_text, covid_id, nurse_id, doctor_id);
    }
}



