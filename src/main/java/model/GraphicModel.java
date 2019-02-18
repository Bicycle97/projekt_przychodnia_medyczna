package model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "graphic")
public class GraphicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_graphic;
    private LocalDate date;
    private LocalTime time_start;
    private LocalTime time_end;

    @ManyToOne()
    @JoinColumn(name = "id_office")
    private OfficeModel officeModel;

    @ManyToOne()
    @JoinColumn(name = "id_employee")
    private EmployeeModel employeeModel;

    public GraphicModel(LocalDate date, LocalTime time_start, LocalTime time_end) {
        this.date = date;
        this.time_start = time_start;
        this.time_end = time_end;
    }

    public GraphicModel() {
    }

    public Long getId_graphic() {
        return id_graphic;
    }
    public void setId_graphic(Long id_graphic) {
        this.id_graphic = id_graphic;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime_start() {
        return time_start;
    }
    public void setTime_start(LocalTime time_start) {
        this.time_start = time_start;
    }

    public LocalTime getTime_end() {
        return time_end;
    }
    public void setTime_end(LocalTime time_end) {
        this.time_end = time_end;
    }

    public OfficeModel getOfficeModel() {
        return officeModel;
    }
    public void setOfficeModel(OfficeModel officeModel) {
        this.officeModel = officeModel;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }
    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }


    @Override
    public String toString() {
        return "GraphicModel{" +
                "id_graphic=" + id_graphic +
                ", date=" + date +
                ", time_start=" + time_start +
                ", time_end=" + time_end +
                ", officeModel=" + officeModel +
                ", employeeModel=" + employeeModel +
                '}';
    }
}
