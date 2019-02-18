package pojo;

import java.time.LocalDate;

public class MedicalHistoryPOJO {

    private Long id_medical_history;
    private String description;
    private String drugs;
    private LocalDate date;
    private Long id_doctor;

    public MedicalHistoryPOJO(Long id_medical_history, String description, String drugs, LocalDate date, Long id_doctor) {
        this.id_medical_history = id_medical_history;
        this.description = description;
        this.drugs = drugs;
        this.date = date;
        this.id_doctor = id_doctor;
    }

    public Long getId_medical_history() {
        return id_medical_history;
    }
    public void setId_medical_history(Long id_medical_history) {
        this.id_medical_history = id_medical_history;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
        return "MedicalHistoryPOJO{" +
                "id_medical_history=" + id_medical_history +
                ", description='" + description + '\'' +
                ", drugs='" + drugs + '\'' +
                ", date=" + date +
                ", id_doctor=" + id_doctor +
                '}';
    }
}
