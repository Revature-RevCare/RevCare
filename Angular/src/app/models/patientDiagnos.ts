<<<<<<< HEAD
export interface patientForm {
   id: number;
   fname: string;
   lname: string;
   patient_age: number;
   complaint: string;
   symptoms: string;
   med_history: string;
   fam_history: string;
   allergies: string;
   current_meds: string;
   current_date: string;
   patient_weight: number;
   patient_height: number;
   patient_temp: number;
   blood_pressure_high: number;
   blood_pressure_low: number;
   pulse: number;
   doctor_verification: boolean;
   diagnosis_text: string;
   covid_id: number;
   nurse_id: number;
   doctor_id: number;

=======
import { Covid } from "./covidVerification";

export interface patientForm{
   Patientid: number;
   FirstName: string;
   LastName: string;
   PatientAge: number;
   Complaint: string;
   Symptoms: string;
   MedicalHistory: string;
   FamilyHistory: string;
   Allergies: string;
   CurrentMedication: string;
   CurrentDate: string;
   Weight: number;
   Height: number;
   Temperature: number;
   BloodpresureH: number;
   BloodpresureL: number;
   Pulse: number;
   Doctorverification: boolean;
   Diagnosis: string;
   Covidid: Covid;
   Nurseid: number;
   Doctorid: number;
>>>>>>> staging
}