package controller.AdministrationController;

import controller.BasicController;
import dao.PatientModelDaoImpl;
import model.PatientModel;
import pojo.PatientPOJO;
import view.administrationView.AdministrationAddPatient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPatientController {

    private BasicController basicController;
    private AdministrationAddPatient administrationAddPatient;
    private PatientManagementController patientManagementController;
    PatientModelDaoImpl patientModelDao = new PatientModelDaoImpl();
    private PatientModel patientModel;
    public AddPatientController(BasicController basicController) {
        this.basicController = basicController;
        administrationAddPatient = new AdministrationAddPatient(this);
        administrationAddPatient.updateView();
        getBasicController().addToInternationalizationList(administrationAddPatient);
        if (basicController.isIfModify()) {
            setOnActionModifyPatient();
        } else {
            setOnActionAddPatient();
        }
    }

    private void setOnActionAddPatient() {

        patientModel = new PatientModel();
        this.administrationAddPatient.getAddPatientAdministrationAddPatient().setOnAction(event -> {

            if (!setOnActionContent(patientModel)) {
                if(patientModelDao.getPatientInDatabase(patientModel.getPESEL())== 0){
                    this.administrationAddPatient.deleteAllElementsFromParent();
                    patientModelDao.save(patientModel);
                    this.setPatientManagementController(new PatientManagementController(getBasicController()));
                }
                else{
                    administrationAddPatient.getInformation().setText(getBasicController().getResourceBundle().getString("administrationViewAddPatient.informationEmployeeIsInDatabase"));
                    administrationAddPatient.getInformation().setVisible(true);
                }

            }
        });
    }

    private void setOnActionModifyPatient() {

        PatientPOJO selectPatient = basicController.getSelectPatient();
        patientModel = patientModelDao.getPatientInDatabase(selectPatient.getId_patient());
        PatientModel finalPatientModel = patientModel;

        this.administrationAddPatient.getNameField().setText(selectPatient.getName());
        this.administrationAddPatient.getSurnameField().setText(selectPatient.getSurname());
        this.administrationAddPatient.getEmailField().setText(selectPatient.getEmail());
        this.administrationAddPatient.getPeselField().setText(selectPatient.getPesel());
        this.administrationAddPatient.getAddressField().setText(selectPatient.getAddress());
        this.administrationAddPatient.getAddPatientAdministrationAddPatient().setVisible(false);
        this.administrationAddPatient.getAddPatientAdministrationModifyPatient().setVisible(true);
        this.administrationAddPatient.getTitleTextAdministrationAddPatient().setText("Modyfikuj dane");
        this.administrationAddPatient.getAddPatientAdministrationModifyPatient().setOnAction(event -> {
            patientModel = patientModelDao.getPatientInDatabase(selectPatient.getId_patient());
            if (!setOnActionContent(finalPatientModel)) {
                this.administrationAddPatient.deleteAllElementsFromParent();
                patientModelDao.merge(finalPatientModel);
                this.setPatientManagementController(new PatientManagementController(getBasicController()));
            }
        });
    }

    private boolean setOnActionContent(PatientModel patientModel) {
        Pattern pEmail = Pattern.compile("[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}");
        String name = this.administrationAddPatient.getNameField().getText();
        String surname = this.administrationAddPatient.getSurnameField().getText();
        String address = this.administrationAddPatient.getAddressField().getText();
        String email = this.administrationAddPatient.getEmailField().getText();
        String pesel = this.administrationAddPatient.getPeselField().getText();
        boolean ifNull = false;
        Matcher mEmail = pEmail.matcher(email);
        if (name.equals("") || surname.equals("") || address.equals("") || email.equals("") || pesel.equals("")) {

                administrationAddPatient.getInformation().setText(getBasicController().getResourceBundle().getString("adminAddAnnotation.information"));
                administrationAddPatient.getInformation().setVisible(true);

            ifNull = true;
        } else {
            if (pesel.length() != 11) {
                administrationAddPatient.getInformation().setText(getBasicController().getResourceBundle().getString("administrationViewAddPatient.informationWrongPESEL"));
                administrationAddPatient.getInformation().setVisible(true);
                ifNull = true;
            } else if (!mEmail.find()) {
                administrationAddPatient.getInformation().setText(getBasicController().getResourceBundle().getString("administrationViewAddPatient.informationWrongEmail"));
                administrationAddPatient.getInformation().setVisible(true);
                ifNull = true;
            }
            else{
                patientModel.setName(name);
                patientModel.setSurname(surname);
                patientModel.setAddress(address);
                patientModel.setEmail(email);
                patientModel.setPESEL(pesel);
                ifNull = false;
            }
        }
        return ifNull;
    }
    public BasicController getBasicController() {
        return basicController;
    }

    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdministrationAddPatient getAdministrationAddPatient() {
        return administrationAddPatient;
    }

    public void setAdministrationAddPatient(AdministrationAddPatient administrationAddPatient) {
        this.administrationAddPatient = administrationAddPatient;
    }

    public PatientManagementController getPatientManagementController() {
        return patientManagementController;
    }

    public void setPatientManagementController(PatientManagementController patientManagementController) {
        this.patientManagementController = patientManagementController;
    }
}
