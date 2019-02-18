package view.doctorView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import controller.DoctorController.MedicalHistoryController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

import static javafx.scene.paint.Color.WHITE;

public class DoctorMedicalHistoryView implements Internationalization {

    private Pane medicalHistoryPane = new Pane();
    private Label titleTextDoctorMedicalHistory = new Label();
    private Label patientName = new Label();
    private Label patientPESEL = new Label();
    private Label patientEmail = new Label();
    private Label patientNameTag = new Label();
    private Label patientPESELTag = new Label();
    private Label patientEmailTag = new Label();
    private JFXButton addDoctorMedicalHistory = new JFXButton();
    private JFXTextArea historyMedical = new JFXTextArea();

    private MedicalHistoryController medicalHistoryController;

    public DoctorMedicalHistoryView(MedicalHistoryController medicalHistoryController) {
        this.medicalHistoryController = medicalHistoryController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        medicalHistoryPane.setId("medicalHistoryPane");
        medicalHistoryPane.setPrefHeight(444);
        medicalHistoryPane.setPrefWidth(500);
        medicalHistoryPane.setLayoutX(29);
        medicalHistoryPane.setLayoutY(14);

        titleTextDoctorMedicalHistory.setId("titleTextDoctorMedicalHistory");
        titleTextDoctorMedicalHistory.setLayoutX(49);
        titleTextDoctorMedicalHistory.setLayoutY(6);
        titleTextDoctorMedicalHistory.setPrefHeight(76);
        titleTextDoctorMedicalHistory.setPrefWidth(360);
        titleTextDoctorMedicalHistory.setTextAlignment(TextAlignment.CENTER);
        titleTextDoctorMedicalHistory.setWrapText(true);
        titleTextDoctorMedicalHistory.setFont(new Font("Avenir Next LT W04 Demi",27));

        patientName.setId("patientName");
        patientName.setLayoutX(340);
        patientName.setLayoutY(14);
        patientName.setPrefHeight(37);
        patientName.setPrefWidth(157);
        patientName.setText("Imię i Nazwisko:");
        patientName.setTextAlignment(TextAlignment.CENTER);
        patientName.setTextFill(Paint.valueOf("#030303"));
        patientName.setWrapText(true);
        patientName.setFont(new Font("Avenir Next LT W04 Demi", 13));

        patientNameTag.setId("patientNameTag");
        patientNameTag.setLayoutX(280);
        patientNameTag.setLayoutY(14);
        patientNameTag.setPrefHeight(37);
        patientNameTag.setPrefWidth(114);
        patientNameTag.setTextAlignment(TextAlignment.CENTER);
        patientNameTag.setWrapText(true);
        patientNameTag.setFont(new Font("Avenir Next LT W04 Demi", 13));

        patientPESEL.setId("patientPESEL");
        patientPESEL.setLayoutX(340);
        patientPESEL.setLayoutY(33);
        patientPESEL.setPrefHeight(37);
        patientPESEL.setPrefWidth(157);
        patientPESEL.setText("PESEL");
        patientPESEL.setTextAlignment(TextAlignment.CENTER);
        patientPESEL.setWrapText(true);
        patientPESEL.setFont(new Font("Avenir Next LT W04 Demi", 13));

        patientPESELTag.setId("patientPESELTag");
        patientPESELTag.setLayoutX(280);
        patientPESELTag.setLayoutY(33);
        patientPESELTag.setPrefHeight(37);
        patientPESELTag.setPrefWidth(86);

        patientPESELTag.setTextAlignment(TextAlignment.CENTER);
        patientPESELTag.setWrapText(true);
        patientPESELTag.setFont(new Font("Avenir Next LT W04 Demi", 13));

        patientEmail.setId("patientEmail");
        patientEmail.setLayoutX(340);
        patientEmail.setLayoutY(52);
        patientEmail.setPrefHeight(37);
        patientEmail.setPrefWidth(157);
        patientEmail.setText("Email");
        patientEmail.setTextAlignment(TextAlignment.CENTER);
        patientEmail.setWrapText(true);
        patientEmail.setFont(new Font("Avenir Next LT W04 Demi", 13));

        patientEmailTag.setId("patientEmailTag");
        patientEmailTag.setLayoutX(280);
        patientEmailTag.setLayoutY(52);
        patientEmailTag.setPrefHeight(37);
        patientEmailTag.setPrefWidth(86);
        patientEmailTag.setTextAlignment(TextAlignment.CENTER);
        patientEmailTag.setWrapText(true);
        patientEmailTag.setFont(new Font("Avenir Next LT W04 Demi", 13));

        addDoctorMedicalHistory.setId("addDoctorMedicalHistory");
        addDoctorMedicalHistory.setButtonType(JFXButton.ButtonType.RAISED);
        addDoctorMedicalHistory.setLayoutX(391);
        addDoctorMedicalHistory.setLayoutY(92);
        addDoctorMedicalHistory.setPrefHeight(48);
        addDoctorMedicalHistory.setPrefWidth(57);
        addDoctorMedicalHistory.setRipplerFill(WHITE);
        addDoctorMedicalHistory.setText("+");
        addDoctorMedicalHistory.setFont(new Font(26));

        historyMedical.setId("historyMedical");
        historyMedical.setLayoutX(34);
        historyMedical.setLayoutY(161);
        historyMedical.setPrefHeight(255);
        historyMedical.setPrefWidth(432);
        historyMedical.setEditable(false);

        medicalHistoryPane.getChildren().addAll(titleTextDoctorMedicalHistory, patientName, patientNameTag, patientPESEL, patientPESELTag, patientEmail, patientEmailTag, addDoctorMedicalHistory, historyMedical);

    }
    public void setContentToParent() {
        getMedicalHistoryController().getBasicController().getBasicView().getMainPane().getChildren().addAll(medicalHistoryPane);
    }

    public void deleteAllElementsFromParent() {
        getMedicalHistoryController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(medicalHistoryPane);
    }

    public MedicalHistoryController getMedicalHistoryController() {
        return medicalHistoryController;
    }

    public void setMedicalHistoryController(MedicalHistoryController medicalHistoryController) {
        this.medicalHistoryController = medicalHistoryController;
    }

    public JFXButton getAddDoctorMedicalHistory() {
        return addDoctorMedicalHistory;
    }

    public void setAddDoctorMedicalHistory(JFXButton addDoctorMedicalHistory) {
        this.addDoctorMedicalHistory = addDoctorMedicalHistory;
    }

    public JFXTextArea getHistoryMedical() {
        return historyMedical;
    }
    public void setHistoryMedical(JFXTextArea historyMedical) {
        this.historyMedical = historyMedical;
    }

    public Label getPatientName() {
        return patientName;
    }
    public void setPatientName(Label patientName) {
        this.patientName = patientName;
    }

    public Label getPatientPESEL() {
        return patientPESEL;
    }
    public void setPatientPESEL(Label patientPESEL) {
        this.patientPESEL = patientPESEL;
    }

    public Label getPatientEmail() {
        return patientEmail;
    }
    public void setPatientEmail(Label patientEmail) {
        this.patientEmail = patientEmail;
    }

    @Override
    public void updateView() {
        titleTextDoctorMedicalHistory.setText(medicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewTheMedicalHistory.title"));
        patientNameTag.setText(medicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewTheMedicalHistory.dataPatient"));
        patientEmailTag.setText(medicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewTheMedicalHistory.pesel"));
        patientPESELTag.setText(medicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewTheMedicalHistory.email"));
    }
}
