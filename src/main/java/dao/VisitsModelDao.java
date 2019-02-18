package dao;

import model.EmployeeModel;
import model.PatientModel;
import model.VisitsModel;
import pojo.VisitsPOJO;

import java.time.LocalDate;
import java.util.List;

public interface VisitsModelDao {

    List<VisitsPOJO> getVisitsDatabase();
    List<VisitsPOJO> getVisitsThisDateDatabase(LocalDate date);
    List<VisitsPOJO> getVisitsLogDoctorThisDateDatabase(LocalDate selectDate, Long id);
    List<VisitsPOJO> getVisitsLogDoctorDatabase(Long id);

    VisitsModel getVisitsInDatabase(Long id);

    void save(VisitsModel visitsModel);
    void merge(VisitsModel visitsModel);
    void delete(VisitsModel visitsModel);
    void delete(EmployeeModel employeeModel);
    void delete(PatientModel patientModel);
    void cleanUp();
}
