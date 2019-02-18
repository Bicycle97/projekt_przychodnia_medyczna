package dao;

import model.PatientModel;
import pojo.PatientPOJO;

import java.util.List;

public interface PatientModelDao {

    List<PatientPOJO> getPatientDatabase();
    int getPatientInDatabase(String Pesel);

    PatientModel getPatientInDatabase(Long id);

    void save(PatientModel patientModel);
    void delete(PatientModel patientModel);
    void merge(PatientModel patientModel);
    void cleanUp();
}
