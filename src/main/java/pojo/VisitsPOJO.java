package pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisitsPOJO {

    private Long id_visits;
    private LocalDate date;
    private LocalTime time;
    private String doctor;
    private String patient;

    public VisitsPOJO(Long id_visits, LocalDate date, LocalTime time, String doctor, String patient) {
        this.id_visits = id_visits;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
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

    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }
}
