package controller.AdministrationController;

import controller.BasicController;
import dao.MedicalHistoryDaoImpl;
import dao.PatientModelDaoImpl;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import model.PatientModel;
import pojo.PatientPOJO;
import view.administrationView.AdministrationPatientManagementView;

public class PatientManagementController {

    private BasicController basicController;
    private AdministrationPatientManagementView administrationPatientManagementView;
    private AddPatientController addPatientController;

    public PatientManagementController(BasicController basicController) {
        this.basicController = basicController;
        administrationPatientManagementView = new AdministrationPatientManagementView(this);
        administrationPatientManagementView.updateView();
        getBasicController().addToInternationalizationList(administrationPatientManagementView);
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

        setOnActionButtonAddPatient();
        setOnActionButtonDeletePatient();
        setOnActionButtonModifyPatient();
    }

    public void initTable() {
        PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
        ObservableList<PatientPOJO> data = FXCollections.observableArrayList(patientModelDao.getPatientDatabase());
        this.administrationPatientManagementView.getTablePatient().setItems(data);
    }
    //Add Patient
    private void setOnActionButtonAddPatient() {
        this.getAdministrationPatientManagementView().getAddPatientAdministrationPatientManagement().setOnAction(event -> {
            setOnActionAddPatientContent();
        });
    }
    private void setOnActionAddPatientContent() {
        basicController.setIfModify(false);
        this.getAdministrationPatientManagementView().deleteAllElementsFromParent();
        this.setAddPatientController(new AddPatientController(getBasicController()));
    }

    //Delete Patient
    private void setOnActionButtonDeletePatient() {
        this.administrationPatientManagementView.getCheckField().setDisable(true);
        this.administrationPatientManagementView.getDeletePatientAdministrationPatientManagement().setDisable(true);
        this.administrationPatientManagementView.getModifyPatientAdministrationPatientManagement().setDisable(true);
        this.administrationPatientManagementView.getTablePatient().setOnMouseClicked(event -> {
            if (this.administrationPatientManagementView.getTablePatient().getSelectionModel().getSelectedItem() == null) {
                this.administrationPatientManagementView.getCheckField().setDisable(true);
            } else {
                this.administrationPatientManagementView.getCheckField().setDisable(false);
                this.administrationPatientManagementView.getModifyPatientAdministrationPatientManagement().setDisable(false);
            }
        });
        this.administrationPatientManagementView.getCheckField().setOnMouseClicked(event -> {
            if (this.administrationPatientManagementView.getCheckField().isSelected()) {
                this.administrationPatientManagementView.getDeletePatientAdministrationPatientManagement().setDisable(false);
            } else {
                this.administrationPatientManagementView.getDeletePatientAdministrationPatientManagement().setDisable(true);
            }
        });

        this.getAdministrationPatientManagementView().getDeletePatientAdministrationPatientManagement().setOnAction(event -> {
            setOnActionDeletePatientContent();
        });
    }
    private void setOnActionDeletePatientContent() {

        PatientModel patientModel = new PatientModel();
        PatientModelDaoImpl patientModelDaoImpl = new PatientModelDaoImpl();
        VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
        MedicalHistoryDaoImpl medicalHistoryDao = new MedicalHistoryDaoImpl();

        Long id = this.administrationPatientManagementView.getTablePatient().getSelectionModel().getSelectedItem().getId_patient();
        patientModel = patientModelDaoImpl.getPatientInDatabase(id);
        visitsModelDao.delete(patientModel);
        medicalHistoryDao.delete(patientModel);
        patientModelDaoImpl.delete(patientModel);

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
    //Modify Patient
    private void setOnActionButtonModifyPatient() {
        this.getAdministrationPatientManagementView().getModifyPatientAdministrationPatientManagement().setOnAction(event -> {
            setOnActionModifyPatientContent();
        });
    }
    private void setOnActionModifyPatientContent() {
        basicController.setIfModify(true);
        PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
        basicController.setSelectPatient(this.getAdministrationPatientManagementView().getTablePatient().getSelectionModel().getSelectedItem());
        this.setAddPatientController(new AddPatientController(getBasicController()));
    }

    //Getter and Setter
    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdministrationPatientManagementView getAdministrationPatientManagementView() {
        return administrationPatientManagementView;
    }

    public void setAdministrationPatientManagementView(AdministrationPatientManagementView administrationPatientManagementView) {
        this.administrationPatientManagementView = administrationPatientManagementView;
    }

    public AddPatientController getAddPatientController() {
        return addPatientController;
    }

    public void setAddPatientController(AddPatientController addPatientController) {
        this.addPatientController = addPatientController;
    }
}
