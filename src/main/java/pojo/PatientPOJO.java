package pojo;

public class PatientPOJO {

    private Long id_patient;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String PESEL;

    public PatientPOJO(Long id_patient, String name, String surname, String email, String PESEL, String address) {
        this.id_patient = id_patient;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.PESEL = PESEL;
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

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return PESEL;
    }
    public void setPesel(String PESEL) {
        this.PESEL = PESEL;
    }

    @Override
    public String toString() {
        return
                name + " " + surname;

    }
}
