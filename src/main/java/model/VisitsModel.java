package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "visits")
public class VisitsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visits;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne()
    @JoinColumn(name = "id_employee")
    private EmployeeModel employeeModell;

    @ManyToOne()
    @JoinColumn(name = "id_patient")
    private PatientModel patientModel;

    public VisitsModel(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public VisitsModel() {
    }

    public Long getId_visits() {
        return id_visits;
    }
    public void setId_visits(Long id_visits) {
        this.id_visits = id_visits;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public EmployeeModel getEmployeeModell() {
        return employeeModell;
    }
    public void setEmployeeModell(EmployeeModel employeeModell) {
        this.employeeModell = employeeModell;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }
    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    @Override
    public String toString() {
        return "VisitsModel{" +
                "id_visits=" + id_visits +
                ", date=" + date +
                ", time=" + time +
                ", employeeModell=" + employeeModell +
                ", patientModel=" + patientModel +
                '}';
    }
}
