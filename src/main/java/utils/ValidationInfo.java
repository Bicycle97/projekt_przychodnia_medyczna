package utils;

import controller.BasicController;

public class ValidationInfo {

    private boolean validationResult;
    private ValidationCommunicate communicate;
    private BasicController basicController;

    public ValidationInfo(BasicController basicController) {
        this.basicController = basicController;
        validationResult = true;
        communicate = ValidationCommunicate.NONE;
    }

    public String validationCommunicateToLabel() {
        if (communicate == ValidationCommunicate.EMPTY_FIELD)
            return this.getBasicController().getResourceBundle().getString("validator.EMPTY_FIELD");
        else if (communicate == ValidationCommunicate.EMPLOYEE_IN_DATABASE)
            return getBasicController().getResourceBundle().getString("validator.EMPLOYEE_IN_DATABASE");
        else if (communicate == ValidationCommunicate.NO_SUCH_USER_IN_DATABASE)
            return getBasicController().getResourceBundle().getString("validator.NO_SUCH_USER_IN_DATABASE");
        else return "";
    }

    public boolean isValidationResult() {
        return validationResult;
    }

    public void setValidationResult(boolean validationResult) {
        this.validationResult = validationResult;
    }

    public ValidationCommunicate getCommunicate() {
        return communicate;
    }

    public void setCommunicate(ValidationCommunicate communicate) {
        this.communicate = communicate;
    }

    public BasicController getBasicController() {
        return basicController;
    }

    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }
}
