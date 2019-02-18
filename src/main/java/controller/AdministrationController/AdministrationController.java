package controller.AdministrationController;

import controller.BasicController;
import controller.MenuFunction;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.VisitsPOJO;
import view.administrationView.*;

import java.time.LocalDate;

public class AdministrationController {

    private BasicController basicController;
    private AdministrationView administrationView;
    private AddPatientController addPatientController;
    private AddVisitsController addVisitsController;
    private PatientManagementController patientManagementController;
    private ShowVisitsController showVisitsController;
    private VisitsManagementController visitsManagementController;
    private AdministrationAddPatient administrationAddPatient;
    private LocalDate currentDate;
    private AdministrationVisitsView administrationVisitsView;
    private AdministrationVisitsManagementView administrationVisitsManagementView;
    private AdministrationPatientManagementView administrationPatientManagementView;

    MenuFunction menuFunction = new MenuFunction();

    public AdministrationController(BasicController basicController) {
        this.basicController = basicController;
        administrationView = new AdministrationView(this);
        administrationView.updateView();
        getBasicController().addToInternationalizationList(administrationView);
        currentDate = LocalDate.now();
        System.out.println(currentDate);
        if (currentDate != null) {
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
        }
        setOnActionButton1AdministrationButtonContent();
        setOnActionButton2AdministrationButtonContent();
        setOnActionButton3AdministrationButtonContent();
        setOnActionButton4AdministrationButtonContent();

    }

    public void initTable() {
        VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
        ObservableList<VisitsPOJO> data = FXCollections.observableArrayList(visitsModelDao.getVisitsThisDateDatabase(currentDate));
        this.administrationView.getTableAdministrationView().setItems(data);
    }
    private void setOnActionButton1AdministrationButtonContent() {

        getBasicController().getMenuController().getMenuView().getMenuButton1().setOnAction(event -> {
            setOnActionPatientManagementButton1Content();
        });
    }

    private void setOnActionPatientManagementButton1Content() {
        getBasicController().getAdministrationController().getAdministrationView().deleteAllElementsFromParent();
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(true);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
        patientManagementController = new PatientManagementController(getBasicController());
    }


    private void setOnActionButton2AdministrationButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton2().setOnAction(event -> {
            setOnActionVisitsManagementButton2Content();
        });
    }

    private void setOnActionVisitsManagementButton2Content() {
        getBasicController().getAdministrationController().getAdministrationView().deleteAllElementsFromParent();
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(true);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
        visitsManagementController = new VisitsManagementController(getBasicController());
    }

    private void setOnActionButton3AdministrationButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton3().setOnAction(event -> {
            setOnActionVisitsButton3Content();
        });
    }

    private void setOnActionVisitsButton3Content() {
        getBasicController().getAdministrationController().getAdministrationView().deleteAllElementsFromParent();
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(true);
        showVisitsController = new ShowVisitsController(getBasicController());
    }

    private void setOnActionButton4AdministrationButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton4().setOnAction(event -> {
            menuFunction.setOnActionLogoutButtonContent(getBasicController());
        });
    }

    private void setAdministrationView() {
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdministrationView getAdministrationView() {
        return administrationView;
    }

    public void setAdministrationView(AdministrationView administrationView) {
        this.administrationView = administrationView;
    }
}
