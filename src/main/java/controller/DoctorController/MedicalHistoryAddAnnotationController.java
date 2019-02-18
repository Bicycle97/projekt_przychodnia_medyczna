package controller.DoctorController;

import controller.BasicController;
import dao.MedicalHistoryDaoImpl;
import dao.PatientModelDaoImpl;
import model.MedicalHistoryModel;
import utils.User;
import view.doctorView.DoctorAddAnnotationView;

import java.time.LocalDate;

public class MedicalHistoryAddAnnotationController {

    BasicController basicController;
    DoctorAddAnnotationView doctorAddAnnotationView;
    MedicalHistoryController medicalHistoryController;
    MedicalHistoryDaoImpl medicalHistoryDaoImpl = new MedicalHistoryDaoImpl();
    private MedicalHistoryModel medicalHistoryModel;

    public MedicalHistoryAddAnnotationController(BasicController basicController) {
        this.basicController = basicController;
        doctorAddAnnotationView = new DoctorAddAnnotationView(this);
        doctorAddAnnotationView.updateView();
        getBasicController().addToInternationalizationList(doctorAddAnnotationView);
        setOnActionAddMedicalHistory();
    }

    private void setOnActionAddMedicalHistory() {

        medicalHistoryModel = new MedicalHistoryModel();
        this.doctorAddAnnotationView.getAddDoctorAddAnnotation().setOnAction(event -> {
            setOnActionContent();
        });
    }

    private void setOnActionContent() {

        String description = this.doctorAddAnnotationView.getDescriptionVisits().getText();
        String drugs = this.doctorAddAnnotationView.getRecommendedDrugs().getText();

        if (description.equals("")) {
            this.doctorAddAnnotationView.getInformation().setVisible(true);
        } else {
            medicalHistoryModel.setDescription(description);
            PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
            Long id = basicController.getSelectPatient().getId_patient();
            medicalHistoryModel.setPatientModell(patientModelDao.getPatientInDatabase(id));
            medicalHistoryModel.setDate(LocalDate.now());
            medicalHistoryModel.setId_doctor(User.getInstance().getId_user());


            if (drugs != "") {
                medicalHistoryModel.setDrugs(drugs);
            } else {
                medicalHistoryModel.setDrugs("-");
            }
            medicalHistoryDaoImpl.save(medicalHistoryModel);
            doctorAddAnnotationView.deleteAllElementsFromParent();
            medicalHistoryController = new MedicalHistoryController(getBasicController());
        }

    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }
}
