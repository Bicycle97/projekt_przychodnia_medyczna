package controller.DoctorController;

import controller.BasicController;
import dao.PatientModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.PatientPOJO;
import view.doctorView.DoctorDisplayMedicalHistoryView;

public class DisplayMedicalHistoryController {

    private BasicController basicController;
    private DoctorDisplayMedicalHistoryView doctorDisplayMedicalHistoryView;
    private MedicalHistoryController medicalHistoryController;

    public DisplayMedicalHistoryController(BasicController basicController) {
        this.basicController = basicController;
        doctorDisplayMedicalHistoryView = new DoctorDisplayMedicalHistoryView(this);
        doctorDisplayMedicalHistoryView.updateView();
        getBasicController().addToInternationalizationList(doctorDisplayMedicalHistoryView);
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

        setOnActionShowMedicalHistory();
    }

    public void initTable() {
        PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
        ObservableList<PatientPOJO> data = FXCollections.observableArrayList(patientModelDao.getPatientDatabase());
        this.doctorDisplayMedicalHistoryView.getTablePatient().setItems(data);
    }

    private void setOnActionShowMedicalHistory() {
        this.doctorDisplayMedicalHistoryView.getDisplayButtonDoctorDisplayMedicalHistory().setDisable(true);
        this.doctorDisplayMedicalHistoryView.getTablePatient().setOnMouseClicked(event -> {
            if (this.doctorDisplayMedicalHistoryView.getTablePatient().getSelectionModel().getSelectedItem() == null) {
                this.doctorDisplayMedicalHistoryView.getDisplayButtonDoctorDisplayMedicalHistory().setDisable(true);
            } else {
                this.doctorDisplayMedicalHistoryView.getDisplayButtonDoctorDisplayMedicalHistory().setDisable(false);
            }
        });

        this.doctorDisplayMedicalHistoryView.getDisplayButtonDoctorDisplayMedicalHistory().setOnAction(event -> {
            setOnActionContent();
        });
    }

    private void setOnActionContent() {
        PatientPOJO selectedPatient = this.doctorDisplayMedicalHistoryView.getTablePatient().getSelectionModel().getSelectedItem();
        this.basicController.setSelectPatient(selectedPatient);
        doctorDisplayMedicalHistoryView.deleteAllElementsFromParent();
        medicalHistoryController = new MedicalHistoryController(getBasicController());
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }
}
