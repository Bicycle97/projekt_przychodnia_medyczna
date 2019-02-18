package controller.AminController;

import controller.BasicController;
import controller.MenuFunction;
import dao.EmployeeModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.EmployeePOJO;
import utils.Language;
import view.adminView.AdminView;


public class AdminController {
    private BasicController basicController;
    private AdminModifyGraphicController adminModifyGraphicController;
    private AdminAddEmployeeController adminAddEmployeeController;
    private AdminDeleteEmployeeController adminDeleteEmployeeController;
    private AdminView adminView;
    MenuFunction menuFunction = new MenuFunction();

    public AdminController(BasicController basicController) {
        this.basicController = basicController;
        Language language = basicController.getCurrentLanguage();
        adminView = new AdminView(this);
        adminView.updateView();
        getBasicController().addToInternationalizationList(adminView);

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

        setOnActionButton1AdminButtonContent();
        setOnActionButton2AdminButtonContent();
        setOnActionButton3AdminButtonContent();
        setOnActionButton4AdminButtonContent();

    }

    public void initTable() {
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        ObservableList<EmployeePOJO> data = FXCollections.observableArrayList(employeeModelDao.getEmployeeDatabase());
        this.adminView.getTableAdminView().setItems(data);
    }

    private void setOnActionButton1AdminButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton1().setOnAction(event -> {
            setOnActionModifyButton1Content();
        });
    }
    private void setOnActionModifyButton1Content() {

        this.getAdminView().deleteAllElementsFromParent();
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(true);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
        adminModifyGraphicController = new AdminModifyGraphicController(getBasicController());
    }

    private void setOnActionButton2AdminButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton2().setOnAction(event -> {
            setOnActionAddButton2Content();
        });
    }

    private void setOnActionAddButton2Content() {
        this.getAdminView().deleteAllElementsFromParent();
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(true);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
        adminAddEmployeeController = new AdminAddEmployeeController(getBasicController());
    }

    private void setOnActionButton3AdminButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton3().setOnAction(event -> {
            setOnActionDeleteButton3Content();
        });
    }
    private void setOnActionDeleteButton3Content() {
        this.getAdminView().deleteAllElementsFromParent();
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(true);
        adminDeleteEmployeeController = new AdminDeleteEmployeeController(getBasicController());
    }

    private void setOnActionButton4AdminButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton4().setOnAction(event -> {
            menuFunction.setOnActionLogoutButtonContent(getBasicController());
        });
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdminView getAdminView() {
        return adminView;
    }
    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }
}
