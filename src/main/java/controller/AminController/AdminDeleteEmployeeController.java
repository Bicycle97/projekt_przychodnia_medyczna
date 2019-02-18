package controller.AminController;

import controller.BasicController;
import dao.EmployeeModelDaoImpl;
import dao.GraphicModelDaoImpl;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import model.EmployeeModel;
import pojo.EmployeePOJO;
import view.adminView.AdminDeleteEmployeeView;

public class AdminDeleteEmployeeController {

    private BasicController basicController;
    private AdminDeleteEmployeeView adminDeleteEmployeeView;

    private AdminController adminController;

    public AdminDeleteEmployeeController(BasicController basicController) {
        this.basicController = basicController;
        adminDeleteEmployeeView = new AdminDeleteEmployeeView(this);
        adminDeleteEmployeeView.updateView();
        getBasicController().addToInternationalizationList(adminDeleteEmployeeView);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                initTable();
                System.out.println("TABLE LOADED");
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        setOnActionButtonDeleteEmployee();
    }
//Delete Employee
    private void setOnActionButtonDeleteEmployee() {
        this.adminDeleteEmployeeView.getCheckField().setDisable(true);
        this.adminDeleteEmployeeView.getDeleteEmployeeButton().setDisable(true);
        this.getAdminDeleteEmployeeView().getTableEmployee().setOnMouseClicked(event -> {
            if (this.getAdminDeleteEmployeeView().getTableEmployee().getSelectionModel().getSelectedItem() == null) {
                this.adminDeleteEmployeeView.getCheckField().setDisable(true);
            } else {
                this.adminDeleteEmployeeView.getCheckField().setDisable(false);
            }
        });
        this.getAdminDeleteEmployeeView().getCheckField().setOnMouseClicked(event -> {
            if (this.getAdminDeleteEmployeeView().getCheckField().isSelected()) {
                this.adminDeleteEmployeeView.getDeleteEmployeeButton().setDisable(false);
            } else {
                this.adminDeleteEmployeeView.getDeleteEmployeeButton().setDisable(true);
            }
        });
        this.getAdminDeleteEmployeeView().getDeleteEmployeeButton().setOnAction(event -> {
            EmployeeModel employeeModel = new EmployeeModel();
            GraphicModelDaoImpl graphicModelDao = new GraphicModelDaoImpl();
            VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
            EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();

            Long id = this.adminDeleteEmployeeView.getTableEmployee().getSelectionModel().getSelectedItem().getId_employee();
            employeeModel = employeeModelDao.getEmployeeInDatabase(id);

            graphicModelDao.delete(employeeModel);
            visitsModelDao.delete(employeeModel);
            employeeModelDao.delete(employeeModel);
            getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
            this.getAdminDeleteEmployeeView().deleteAllElementsFromParent();
            this.setAdminController(new AdminController(getBasicController()));
        });
    }

    public void initTable() {
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        ObservableList<EmployeePOJO> data = FXCollections.observableArrayList(employeeModelDao.getEmployeeDatabase());
        this.adminDeleteEmployeeView.getTableEmployee().setItems(data);
    }
    //Getter and Setter
    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdminDeleteEmployeeView getAdminDeleteEmployeeView() {
        return adminDeleteEmployeeView;
    }

    public void setAdminDeleteEmployeeView(AdminDeleteEmployeeView adminDeleteEmployeeView) {
        this.adminDeleteEmployeeView = adminDeleteEmployeeView;
    }

    public AdminController getAdminController() {
        return adminController;
    }
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }
}
