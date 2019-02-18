package pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class GraphicPojo {

    private Long id_graphic;
    private LocalDate date;
    private LocalTime time_start;
    private LocalTime time_end;
    private String office;
    private String name;
    private String surname;

    public GraphicPojo(Long id_graphic, LocalDate date, LocalTime time_start, LocalTime time_end, String name, String surname, String office) {
        this.id_graphic = id_graphic;
        this.date = date;
        this.time_start = time_start;
        this.time_end = time_end;
        this.name = name;
        this.surname = surname;
        this.office = office;
    }

    public Long getId_graphic() {
        return id_graphic;
    }
    public void setId_grafic(Long id_grafic) {
        this.id_graphic = id_grafic;
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

    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "GraphicPojo{" +
                "id_grafic=" + id_graphic +
                ", date=" + date +
                ", time_start=" + time_start +
                ", time_end=" + time_end +
                ", office='" + office + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
