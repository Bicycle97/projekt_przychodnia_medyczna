package pojo;

public class EmployeePOJO {

    private Long id_employee;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String psl;

    public EmployeePOJO(Long id_employee, String name, String surname, int age, String email, String psl) {
        this.id_employee = id_employee;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.psl = psl;
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

    public String getPsl() {
        return psl;
    }
    public void setPsl(String psl) {
        this.psl = psl;
    }

    @Override
    public String toString() {
        return
                name + " " + surname;
    }
}
