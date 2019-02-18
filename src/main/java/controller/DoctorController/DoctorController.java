package controller.DoctorController;

import controller.BasicController;
import controller.MenuFunction;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.VisitsPOJO;
import utils.User;
import view.doctorView.DoctorView;

import java.time.LocalDate;

public class DoctorController {

    private BasicController basicController;
    private DoctorView doctorView;
    private ShowGraphicController showGraphicController;
    private ShowVisitsController showVisitsController;
    private DisplayMedicalHistoryController displayMedicalHistoryController;

    MenuFunction menuFunction = new MenuFunction();

    public DoctorController(BasicController basicController) {

        this.basicController = basicController;
        doctorView = new DoctorView(this);
        doctorView.updateView();
        getBasicController().addToInternationalizationList(doctorView);
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
        setOnActionButton1DoctorButtonContent();
        setOnActionButton2DoctorButtonContent();
        setOnActionButton3DoctorButtonContent();
        setOnActionButton4DoctorButtonContent();
    }

    public void initTable() {
        VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
        ObservableList<VisitsPOJO> visits = FXCollections.observableArrayList(visitsModelDao.getVisitsLogDoctorThisDateDatabase(LocalDate.now(), User.getInstance().getId_user()));
        this.doctorView.getTableDoctorView().setItems(visits);
    }

    private void setOnActionButton1DoctorButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton1().setOnAction(event -> {
            setOnActionPatientManagementButtonContent();
        });
    }

    private void setOnActionPatientManagementButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(true);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
        doctorView.deleteAllElementsFromParent();
        showGraphicController = new ShowGraphicController(getBasicController());
    }

    private void setOnActionButton2DoctorButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton2().setOnAction(event -> {
            setOnActionShowVisitsButtonContent();
        });
    }

    private void setOnActionShowVisitsButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(true);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(false);
        doctorView.deleteAllElementsFromParent();
        showVisitsController = new ShowVisitsController(getBasicController());
    }

    private void setOnActionButton3DoctorButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton3().setOnAction(event -> {
            setOnActionShowMedicalHistoryButtonContent();
        });
    }

    private void setOnActionShowMedicalHistoryButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton1().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton2().setDisable(false);
        getBasicController().getMenuController().getMenuView().getMenuButton3().setDisable(true);
        doctorView.deleteAllElementsFromParent();
        displayMedicalHistoryController = new DisplayMedicalHistoryController(getBasicController());
    }

    private void setOnActionButton4DoctorButtonContent() {
        getBasicController().getMenuController().getMenuView().getMenuButton4().setOnAction(event -> {
            menuFunction.setOnActionLogoutButtonContent(getBasicController());
        });
    }
    public DoctorView getDoctorView() {
        return doctorView;
    }
    public void setDoctorView(DoctorView doctorView) {
        this.doctorView = doctorView;
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }
}
