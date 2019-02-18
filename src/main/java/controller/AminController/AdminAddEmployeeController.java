package controller.AminController;

import controller.BasicController;
import dao.EmployeeModelDaoImpl;
import model.EmployeeModel;
import model.TypeEmployeeModel;
import view.adminView.AdminAddEmployeeView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminAddEmployeeController {

    private BasicController basicController;
    private AdminAddEmployeeView adminAddEmployeeView;
    private AdminController adminController;

    public AdminAddEmployeeController(BasicController basicController) {
        this.basicController = basicController;
        adminAddEmployeeView = new AdminAddEmployeeView(this);
        adminAddEmployeeView.updateView();
        getBasicController().addToInternationalizationList(adminAddEmployeeView);
        setOnActionButtonAddEmployee();
    }

    private void setOnActionButtonAddEmployee() {
        Pattern pEmail = Pattern.compile("[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}");
        EmployeeModel employeeModel = new EmployeeModel();
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        this.getAdminAddEmployeeView().getAddButton().setOnAction(event -> {
            String name = this.adminAddEmployeeView.getNameField().getText();
            String surname = this.adminAddEmployeeView.getSurnameField().getText();
            String email = this.adminAddEmployeeView.getEmailField().getText();
            String PESEL = this.adminAddEmployeeView.getPeselField().getText();
            String age = this.adminAddEmployeeView.getAgeField().getText();
            String password = this.adminAddEmployeeView.getPasswordField().getText();
            String typEmployee;
            Matcher mEmail = pEmail.matcher(email);
            if (adminAddEmployeeView.getTypField().getSelectionModel().getSelectedItem() == null) {
                typEmployee = "";

            } else {
                typEmployee = adminAddEmployeeView.getTypField().getSelectionModel().getSelectedItem().toString();
            }
            if (name == "" || surname == "" || email == "" || PESEL == "" || age == "" || password == "" || typEmployee == "") {

                    adminAddEmployeeView.getInformation().setText(getBasicController().getResourceBundle().getString("adminAddEmployee.information"));
                    adminAddEmployeeView.getInformation().setVisible(true);

            } else {

                if (PESEL.length() != 11) {
                    adminAddEmployeeView.getInformation().setText(getBasicController().getResourceBundle().getString("adminAddEmployee.informationWrongPESEL"));
                    adminAddEmployeeView.getInformation().setVisible(true);
                } else if (!mEmail.find()) {
                    adminAddEmployeeView.getInformation().setText(getBasicController().getResourceBundle().getString("adminAddEmployee.informationWrongEmail"));
                    adminAddEmployeeView.getInformation().setVisible(true);
                }
                else{
                ArrayList<TypeEmployeeModel> typeEmployeeModels = new ArrayList<TypeEmployeeModel>();
                typeEmployeeModels = (ArrayList<TypeEmployeeModel>) employeeModelDao.getTypeEmployeeInDatabase();
                TypeEmployeeModel typeEmployeeModel = new TypeEmployeeModel();
                for (TypeEmployeeModel tem : typeEmployeeModels) {
                    if (typEmployee.equals(tem.getName())) {
                        typeEmployeeModel = tem;
                    }
                }
                employeeModel.setName(name);
                employeeModel.setSurname(surname);
                employeeModel.setEmail(email);
                employeeModel.setPESEL(PESEL);
                employeeModel.setAge(Integer.parseInt(age));
                employeeModel.setTypeEmployeeModel(typeEmployeeModel);
                employeeModel.setPassword(password);
                if (employeeModelDao.getEmployeeInDatabase(PESEL) == 0) {
                    employeeModelDao.save(employeeModel);
                    this.adminAddEmployeeView.deleteAllElementsFromParent();
                    this.setAdminController(new AdminController(getBasicController()));
                    getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
                } else {
                    adminAddEmployeeView.getInformation().setText(getBasicController().getResourceBundle().getString("adminAddEmployee.informationEmployeeIsInDatabase"));
                    adminAddEmployeeView.getInformation().setVisible(true);
                }
            }
            }
        });
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdminAddEmployeeView getAdminAddEmployeeView() {
        return adminAddEmployeeView;
    }

    public void setAdminAddEmployeeView(AdminAddEmployeeView adminAddEmployeeView) {
        this.adminAddEmployeeView = adminAddEmployeeView;
    }

    public AdminController getAdminController() {
        return adminController;
    }
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }
}
