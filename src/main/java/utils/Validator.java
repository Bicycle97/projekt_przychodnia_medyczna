package utils;

import controller.BasicController;
import dao.EmployeeModelDaoImpl;

public class Validator {

    private BasicController basicController;

    private Validator(){
    }

    public static Validator getInstance(){return  SingletonHolder.Instance;}

    private static class SingletonHolder{
        private static final Validator Instance = new Validator();
    }

    public ValidationInfo validate(String login, String password) {

        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        ValidationInfo validationInfo = new ValidationInfo(getBasicController());

        if (login.equals("") || password.equals("")) {
            validationInfo.setValidationResult(false);
            validationInfo.setCommunicate(ValidationCommunicate.EMPTY_FIELD);
            return validationInfo;
        } else if (employeeModelDao.checkLoginAndPasswordEmployeeInDatabase(login, password)) {
            validationInfo.setValidationResult(true);
            validationInfo.setCommunicate(ValidationCommunicate.EMPLOYEE_LOGIN_IN);
            return validationInfo;
        } else {
            validationInfo.setValidationResult(false);
            validationInfo.setCommunicate(ValidationCommunicate.NO_SUCH_USER_IN_DATABASE);
            return validationInfo;
        }
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

}
