package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "office")
public class OfficeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_office;
    private String number;

    @OneToMany(mappedBy = "officeModel")
    private List<GraphicModel> graphicModels = new ArrayList<>();

    public OfficeModel(String number) {
        this.number = number;
    }

    public OfficeModel() {
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId_office() {
        return id_office;
    }
    public void setId_office(Long id_office) {
        this.id_office = id_office;
    }

    public List<GraphicModel> getGraphicModels() {
        return graphicModels;
    }
    public void setGraphicModels(List<GraphicModel> graphicModels) {
        this.graphicModels = graphicModels;
    }

    @Override
    public String toString() {
        return "OfficeModel{" +
                "id_office=" + id_office +
                ", number='" + number + '\'' +
                ", graphicModels=" + graphicModels +
                '}';
    }
}
