package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_history")
public class MedicalHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medical_history;
    private String description;
    private String drugs;
    private LocalDate date;
    private Long id_doctor;


    @ManyToOne()
    @JoinColumn(name = "id_patient")
    private PatientModel patientModell;

    public MedicalHistoryModel(String description, PatientModel patientModel, String drugs, LocalDate date, Long id_doctor) {
        this.description = description;
        this.drugs = drugs;
        this.date = date;
        this.id_doctor = id_doctor;
    }

    public MedicalHistoryModel() {
    }


    public Long getId_medical_history() {
        return id_medical_history;
    }
    public void setId_mednical_history(Long id_mednical_history) {
        this.id_medical_history = id_mednical_history;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public PatientModel getPatientModell() {
        return patientModell;
    }
    public void setPatientModell(PatientModel patientModell) {
        this.patientModell = patientModell;
    }

    public String getDrugs() {
        return drugs;
    }
    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId_doctor() {
        return id_doctor;
    }
    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    @Override
    public String toString() {
        return "MedicalHistoryModel{" +
                "id_medical_history=" + id_medical_history +
                ", description='" + description + '\'' +
                ", drugs='" + drugs + '\'' +
                ", date=" + date +
                ", id_doctor=" + id_doctor +
                ", patientModell=" + patientModell +
                '}';
    }
}
