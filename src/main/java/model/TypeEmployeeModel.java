package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_employee")
public class TypeEmployeeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_employee;
    private String name;

    @OneToMany(mappedBy = "typeEmployeeModel")
    private List<EmployeeModel> employeeModels = new ArrayList<>();

    public TypeEmployeeModel(String name) {
        this.name = name;
    }

    public TypeEmployeeModel() {
    }

    public Long getId_type_employee() {
        return id_type_employee;
    }
    public void setId_type_employee(Long id_type_employee) {
        this.id_type_employee = id_type_employee;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeModel> getEmployeeModels() {
        return employeeModels;
    }
    public void setEmployeeModels(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }

    @Override
    public String toString() {
        return "TypeEmployeeModel{" +
                "id_type_employee=" + id_type_employee +
                ", name='" + name + '\'' +
                ", employeeModels=" + employeeModels +
                '}';
    }
}
