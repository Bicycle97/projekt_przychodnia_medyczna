package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_patient;
    private String name;
    private String surname;
    private String email;
    private String PESEL;
    private String address;

    @OneToMany(mappedBy = "patientModel")
    private List<VisitsModel> visitsModels1 = new ArrayList<>();

    @OneToMany(mappedBy = "patientModell")
    private List<MedicalHistoryModel> medicalHistoryModel = new ArrayList<>();

    public PatientModel(String name, String surname, String email, String PESEL, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.PESEL = PESEL;
        this.address = address;
    }

    public PatientModel() {
    }

    public Long getId_patient() {
        return id_patient;
    }
    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPESEL() {
        return PESEL;
    }
    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public List<VisitsModel> getVisitsModels1() {
        return visitsModels1;
    }
    public void setVisitsModels1(List<VisitsModel> visitsModels1) {
        this.visitsModels1 = visitsModels1;
    }

    public List<MedicalHistoryModel> getMedicalHistoryModel() {
        return medicalHistoryModel;
    }

    public void setMedicalHistoryModel(List<MedicalHistoryModel> medicalHistoryModel) {
        this.medicalHistoryModel = medicalHistoryModel;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
