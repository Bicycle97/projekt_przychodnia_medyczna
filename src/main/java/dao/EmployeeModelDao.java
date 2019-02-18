package dao;

import model.EmployeeModel;
import model.TypeEmployeeModel;
import pojo.EmployeePOJO;

import java.util.List;

public interface EmployeeModelDao {

    boolean checkLoginAndPasswordEmployeeInDatabase(String login, String password);
    //boolean isInDatabase(EmployeeModel employeeModel);

    // List<EmployeeModel> getEmployeeInDatabase(EmployeeModel employeeModel);
    int getEmployeeInDatabase(String Pesel);
    List<TypeEmployeeModel> getTypeEmployeeInDatabase();
    List<EmployeePOJO> getEmployeeDatabase();
    List<EmployeePOJO> getDoctorInDatabase();

    EmployeeModel getEmployeeInDatabase(Long id);

    void save(EmployeeModel employeeModel);
    void delete(EmployeeModel employeeModel);
    void cleanUp();
}
