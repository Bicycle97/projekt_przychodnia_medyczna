package dao;

import model.MedicalHistoryModel;
import model.PatientModel;

import java.util.List;

public interface MedicalHistoryDao {
    List<MedicalHistoryModel> getMedicalHistorySelectedPatientInDatabase(PatientModel patientModel);

    void save(MedicalHistoryModel medicalHistoryModel);
    void delete(MedicalHistoryModel medicalHistoryModel);
    void delete(PatientModel patientModel);
    void cleanUp();
}
