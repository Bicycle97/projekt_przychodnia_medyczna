package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employee")
public class EmployeeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String PESEL;
    private String password;

    @ManyToOne()
    @JoinColumn(name = "type_employee_id")
    private TypeEmployeeModel typeEmployeeModel;

    @OneToMany(mappedBy = "employeeModel")
    private List<GraphicModel> graphicModels = new ArrayList<>();

    @OneToMany(mappedBy = "employeeModell")
    private List<VisitsModel> visitsModels = new ArrayList<>();


    public EmployeeModel(String name, String surname, int age, String email, String PESEL, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.PESEL = PESEL;
        this.password = password;
    }

    public EmployeeModel() {
    }

    public Long getId_employee() {
        return id_employee;
    }
    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public TypeEmployeeModel getTypeEmployeeModel() {
        return typeEmployeeModel;
    }

    public void setTypeEmployeeModel(TypeEmployeeModel typeEmployeeModel) {
        this.typeEmployeeModel = typeEmployeeModel;
    }

    public List<GraphicModel> getGraphicModels() {
        return graphicModels;
    }
    public void setGraphicModels(List<GraphicModel> graphicModels) {
        this.graphicModels = graphicModels;
    }

    public List<VisitsModel> getVisitsModels() {
        return visitsModels;
    }
    public void setVisitsModels(List<VisitsModel> visitsModels) {
        this.visitsModels = visitsModels;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
