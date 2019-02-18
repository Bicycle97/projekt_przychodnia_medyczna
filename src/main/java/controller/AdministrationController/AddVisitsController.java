package controller.AdministrationController;

import controller.BasicController;
import dao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EmployeeModel;
import model.PatientModel;
import model.VisitsModel;
import pojo.EmployeePOJO;
import pojo.PatientPOJO;
import pojo.VisitsPOJO;
import view.administrationView.AdministrationAddVisitsView;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddVisitsController {

    VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
    EmployeeModelDao employeeModelDao = new EmployeeModelDaoImpl();
    PatientModelDao patientModelDao = new PatientModelDaoImpl();
    private BasicController basicController;
    private AdministrationAddVisitsView administrationAddVisitsView;
    private VisitsManagementController visitsManagementController;
    private VisitsModel visitsModel;
    private EmployeeModel employeeModel;
    private PatientModel patientModel;
    private LocalDate localDate;
    private LocalTime localTime;

    public AddVisitsController(BasicController basicController) {
        this.basicController = basicController;
        administrationAddVisitsView = new AdministrationAddVisitsView(this);
        administrationAddVisitsView.updateView();
        getBasicController().addToInternationalizationList(administrationAddVisitsView);
        setOnActionButtonChoiceEmployee();
        setOnActionButtonChoicePatient();
        setOnActionAddVisits();
        setOnActionModifyVisits();
    }

    private void setOnActionButtonChoiceEmployee() {
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        ObservableList<EmployeePOJO> data = FXCollections.observableArrayList(employeeModelDao.getDoctorInDatabase());
        data.forEach(singleEmployeePojo -> {
            this.getAdministrationAddVisitsView().getEmployeeData().getItems().add(singleEmployeePojo);
        });
    }

    private void setOnActionButtonChoicePatient() {
        PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
        ObservableList<PatientPOJO> patients = FXCollections.observableArrayList(patientModelDao.getPatientDatabase());
        patients.forEach(singlePatientPojo -> {
            this.getAdministrationAddVisitsView().getPatientData().getItems().add(singlePatientPojo);
        });
    }

    private void setOnActionModifyVisits() {
        if (basicController.isIfModify()) {
            ObservableList<EmployeePOJO> employeePOJOS = FXCollections.observableArrayList(employeeModelDao.getEmployeeDatabase());
            ObservableList<PatientPOJO> patientPOJOS = FXCollections.observableArrayList(patientModelDao.getPatientDatabase());
            VisitsPOJO selectVisits = basicController.getSelectVisits();
            visitsModel = visitsModelDao.getVisitsInDatabase(selectVisits.getId_visits());
            VisitsModel finalVisitsModel = visitsModel;

            employeePOJOS.forEach(singleEmployeePojo -> {
                if (singleEmployeePojo.getId_employee() == visitsModel.getEmployeeModell().getId_employee()) {
                    administrationAddVisitsView.getEmployeeData().getSelectionModel().select(employeePOJOS.indexOf(singleEmployeePojo));
                }
            });

            patientPOJOS.forEach(singlePatientPojo -> {
                if (singlePatientPojo.getId_patient() == visitsModel.getPatientModel().getId_patient()) {
                    administrationAddVisitsView.getPatientData().getSelectionModel().select(patientPOJOS.indexOf(singlePatientPojo));
                }
            });
            this.administrationAddVisitsView.getTimeVisits().setValue(visitsModel.getTime());
            this.administrationAddVisitsView.getDateVisits().setValue(visitsModel.getDate());

            this.administrationAddVisitsView.getAddVisitsAdministrationAddVisits().setVisible(false);
            this.administrationAddVisitsView.getAddVisitsAdministrationModifyVisits().setVisible(true);
            this.administrationAddVisitsView.getTitleTextAdministrationAddVisits().setText("Modyfikuj dane");
            this.administrationAddVisitsView.getAddVisitsAdministrationModifyVisits().setOnAction(event -> {
                if (!setOnActionContent(finalVisitsModel)) {
                    visitsModelDao.merge(finalVisitsModel);
                    this.setVisitsManagementController(new VisitsManagementController(getBasicController()));
                }
            });
        }
    }

    private void setOnActionAddVisits() {

        visitsModel = new VisitsModel();
        this.administrationAddVisitsView.getAddVisitsAdministrationAddVisits().setOnAction(event -> {

            if (!setOnActionContent(visitsModel)) {
                visitsModelDao.save(visitsModel);
                this.setVisitsManagementController(new VisitsManagementController(getBasicController()));
            }
        });
    }

    private boolean setOnActionContent(VisitsModel visitsModel) {
        boolean ifNull = false;
        EmployeePOJO employee = (EmployeePOJO) this.administrationAddVisitsView.getEmployeeData().getSelectionModel().getSelectedItem();
        if (employee != null) {
            Long id_employee = employee.getId_employee();
            employeeModel = employeeModelDao.getEmployeeInDatabase(id_employee);
        }
        PatientPOJO patient = (PatientPOJO) this.administrationAddVisitsView.getPatientData().getSelectionModel().getSelectedItem();
        if (patient != null) {
            Long id_patient = patient.getId_patient();
            patientModel = patientModelDao.getPatientInDatabase(id_patient);
        }
        localDate = this.administrationAddVisitsView.getDateVisits().getValue();
        localTime = this.administrationAddVisitsView.getTimeVisits().getValue();

        if (employeeModel == null || patientModel == null || localDate == null || localTime == null) {
            this.administrationAddVisitsView.getInformation().setVisible(true);
            ifNull = true;
        } else {
            visitsModel.setPatientModel(patientModel);
            visitsModel.setEmployeeModell(employeeModel);
            visitsModel.setDate(localDate);
            visitsModel.setTime(localTime);

            this.administrationAddVisitsView.deleteAllElementsFromParent();
            ifNull = false;
        }
        return ifNull;
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdministrationAddVisitsView getAdministrationAddVisitsView() {
        return administrationAddVisitsView;
    }

    public void setAdministrationAddVisitsView(AdministrationAddVisitsView administrationAddVisitsView) {
        this.administrationAddVisitsView = administrationAddVisitsView;
    }

    public VisitsManagementController getVisitsManagementController() {
        return visitsManagementController;
    }

    public void setVisitsManagementController(VisitsManagementController visitsManagementController) {
        this.visitsManagementController = visitsManagementController;
    }
}
