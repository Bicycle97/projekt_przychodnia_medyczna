package controller.DoctorController;

import controller.BasicController;
import dao.GraphicModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.GraphicPojo;
import utils.User;
import view.doctorView.DoctorDisplayGraphicView;

import java.time.LocalDate;

public class ShowGraphicController {

    private BasicController basicController;
    private DoctorDisplayGraphicView doctorDisplayGraphicView;
    private LocalDate chosenDate;
    private ObservableList<GraphicPojo> garphic;

    public ShowGraphicController(BasicController basicController) {
        this.basicController = basicController;
        doctorDisplayGraphicView = new DoctorDisplayGraphicView(this);
        doctorDisplayGraphicView.updateView();
        getBasicController().addToInternationalizationList(doctorDisplayGraphicView);
        setOnActionShowGraphic();
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
    private void setOnActionShowGraphic() {

        this.doctorDisplayGraphicView.getShowButtonDoctorDisplayGraphic().setOnAction(event -> {
            setOnActionContent();
        });
    }

    private void setOnActionContent() {
        chosenDate = this.doctorDisplayGraphicView.getDataDoctorDisplayGraphic().getValue();
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
        GraphicModelDaoImpl graphicModelDao = new GraphicModelDaoImpl();

        if (chosenDate == null) {
            garphic = FXCollections.observableArrayList(graphicModelDao.getGraphicLogDoctorDatabase(User.getInstance().getId_user()));
        } else {
            garphic = FXCollections.observableArrayList(graphicModelDao.getGraphicLogDoctorThisDateDatabase(chosenDate, User.getInstance().getId_user()));
        }
        this.doctorDisplayGraphicView.getTableDoctorDisplayGraphic().setItems(garphic);
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public DoctorDisplayGraphicView getDoctorDisplayGraphicView() {
        return doctorDisplayGraphicView;
    }

    public void setDoctorDisplayGraphicView(DoctorDisplayGraphicView doctorDisplayGraphicView) {
        this.doctorDisplayGraphicView = doctorDisplayGraphicView;
    }
}
