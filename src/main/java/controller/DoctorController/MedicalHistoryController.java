package controller.DoctorController;

import controller.BasicController;
import dao.EmployeeModelDaoImpl;
import dao.MedicalHistoryDaoImpl;
import dao.PatientModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import model.EmployeeModel;
import model.MedicalHistoryModel;
import model.PatientModel;
import view.doctorView.DoctorMedicalHistoryView;

public class MedicalHistoryController {

    private BasicController basicController;
    private DoctorMedicalHistoryView doctorMedicalHistoryView;
    private MedicalHistoryAddAnnotationController medicalHistoryAddAnnotationController;

    public MedicalHistoryController(BasicController basicController) {
        this.basicController = basicController;
        doctorMedicalHistoryView = new DoctorMedicalHistoryView(this);
        doctorMedicalHistoryView.updateView();
        getBasicController().addToInternationalizationList(doctorMedicalHistoryView);
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
        setOnActionMedicalHistory();
    }

    public void initTable() {
        MedicalHistoryDaoImpl medicalHistoryDaoImpl = new MedicalHistoryDaoImpl();
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
        Long selectedPatient_id = basicController.getSelectPatient().getId_patient();
        PatientModel patientModel = patientModelDao.getPatientInDatabase(selectedPatient_id);

        ObservableList<MedicalHistoryModel> medicalHistory = FXCollections.observableArrayList(medicalHistoryDaoImpl.getMedicalHistorySelectedPatientInDatabase(patientModel));

        medicalHistory.forEach(item -> {
            EmployeeModel employeeModel = employeeModelDao.getEmployeeInDatabase(item.getId_doctor());
            this.doctorMedicalHistoryView.getHistoryMedical().appendText("Dane lekarza:  " + employeeModel.getName() + " " + employeeModel.getSurname() + "\n");
            this.doctorMedicalHistoryView.getHistoryMedical().appendText("Data wizyty:  " + item.getDate() + "\n");
            this.doctorMedicalHistoryView.getHistoryMedical().appendText("Opis wizyty:\n" + item.getDescription() + "\n");
            this.doctorMedicalHistoryView.getHistoryMedical().appendText("Zalecane leki:\n" + item.getDrugs() + "\n\n\n");
        });

    }

    private void setOnActionMedicalHistory() {

        String patientName = getBasicController().getSelectPatient().getName();
        String patientSurname = getBasicController().getSelectPatient().getSurname();
        String patientPESEL = getBasicController().getSelectPatient().getPesel();
        String patientEmail = getBasicController().getSelectPatient().getEmail();
        this.doctorMedicalHistoryView.getPatientName().setText(patientName + " " + patientSurname);
        this.doctorMedicalHistoryView.getPatientPESEL().setText(patientPESEL);
        this.doctorMedicalHistoryView.getPatientEmail().setText(patientEmail);
        this.doctorMedicalHistoryView.getAddDoctorMedicalHistory().setOnAction(event -> {
            setOnActionContent();
        });
    }

    private void setOnActionContent() {
        doctorMedicalHistoryView.deleteAllElementsFromParent();
        medicalHistoryAddAnnotationController = new MedicalHistoryAddAnnotationController(getBasicController());
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

}
