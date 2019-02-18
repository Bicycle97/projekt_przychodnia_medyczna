package controller.DoctorController;

import controller.BasicController;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.VisitsPOJO;
import utils.User;
import view.doctorView.DoctorDisplayVisitsView;

import java.time.LocalDate;

public class ShowVisitsController {

    private BasicController basicController;
    private DoctorDisplayVisitsView doctorDisplayVisitsView;
    private LocalDate chosenDate;
    private ObservableList<VisitsPOJO> visits;

    public ShowVisitsController(BasicController basicController) {
        this.basicController = basicController;
        doctorDisplayVisitsView = new DoctorDisplayVisitsView(this);
        doctorDisplayVisitsView.updateView();
        getBasicController().addToInternationalizationList(doctorDisplayVisitsView);
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
        setOnActionShowVisits();
    }

    private void setOnActionShowVisits() {
        this.doctorDisplayVisitsView.getDisplayButtonDoctorDisplayVisits().setOnAction(event -> {
            setOnActionContent();
        });
    }

    private void setOnActionContent() {
        chosenDate = this.doctorDisplayVisitsView.getDateDoctorDisplayVisits().getValue();
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

    public void initTable() {
        VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();

        if (chosenDate == null) {
            visits = FXCollections.observableArrayList(visitsModelDao.getVisitsLogDoctorDatabase(User.getInstance().getId_user()));
        } else {
            visits = FXCollections.observableArrayList(visitsModelDao.getVisitsLogDoctorThisDateDatabase(chosenDate, User.getInstance().getId_user()));
        }

        this.doctorDisplayVisitsView.getTableDoctorDisplayVisits().setItems(visits);
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public DoctorDisplayVisitsView getDoctorDisplayVisitsView() {
        return doctorDisplayVisitsView;
    }

    public void setDoctorDisplayVisitsView(DoctorDisplayVisitsView doctorDisplayVisitsView) {
        this.doctorDisplayVisitsView = doctorDisplayVisitsView;
    }
}
