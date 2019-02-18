package view.doctorView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import controller.DoctorController.MedicalHistoryAddAnnotationController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

import static javafx.scene.paint.Color.WHITE;

public class DoctorAddAnnotationView implements Internationalization {

    private Pane displayAddAnnotationDoctorPane = new Pane();
    private Label titleTextDoctorAddAnnotation = new Label();
    private JFXButton addDoctorAddAnnotation = new JFXButton();
    private JFXTextArea descriptionVisits = new JFXTextArea();
    private JFXTextArea recommendedDrugs = new JFXTextArea();
    private Label descriptionVisitsTag = new Label();
    private Label recommendedDrugsTag = new Label();
    private Label information = new Label();

    private MedicalHistoryAddAnnotationController medicalHistoryAddAnnotationController;

    public DoctorAddAnnotationView(MedicalHistoryAddAnnotationController medicalHistoryAddAnnotationController) {
        this.medicalHistoryAddAnnotationController = medicalHistoryAddAnnotationController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        displayAddAnnotationDoctorPane.setId("displayAddAnnotationDoctorPane");
        displayAddAnnotationDoctorPane.setPrefHeight(444);
        displayAddAnnotationDoctorPane.setPrefWidth(500);
        displayAddAnnotationDoctorPane.setLayoutX(29);
        displayAddAnnotationDoctorPane.setLayoutY(14);

        descriptionVisitsTag.setId("descriptionVisitsTag");
        descriptionVisitsTag.setLayoutX(37);
        descriptionVisitsTag.setLayoutY(82);
        descriptionVisitsTag.setPrefHeight(25);
        descriptionVisitsTag.setPrefWidth(156.76171875);
        descriptionVisitsTag.setFont(new Font("Microsoft PhagsPa Bold", 13));

        recommendedDrugsTag.setId("recommendedDrugsTag");
        recommendedDrugsTag.setLayoutX(37);
        recommendedDrugsTag.setLayoutY(222);
        recommendedDrugsTag.setPrefHeight(25);
        recommendedDrugsTag.setPrefWidth(156.76171875);
        recommendedDrugsTag.setFont(new Font("Microsoft PhagsPa Bold", 13));

        titleTextDoctorAddAnnotation.setId("titleTextDoctorAddAnnotation");
        titleTextDoctorAddAnnotation.setLayoutX(49);
        titleTextDoctorAddAnnotation.setLayoutY(6);
        titleTextDoctorAddAnnotation.setPrefHeight(76);
        titleTextDoctorAddAnnotation.setPrefWidth(360);
        titleTextDoctorAddAnnotation.setTextAlignment(TextAlignment.CENTER);
        titleTextDoctorAddAnnotation.setWrapText(true);
        titleTextDoctorAddAnnotation.setFont(new Font("Avenir Next LT W04 Demi",27));


        addDoctorAddAnnotation.setId("addDoctorAddAnnotation");
        addDoctorAddAnnotation.setButtonType(JFXButton.ButtonType.RAISED);
        addDoctorAddAnnotation.setLayoutX(285);
        addDoctorAddAnnotation.setLayoutY(368);
        addDoctorAddAnnotation.setPrefHeight(48);
        addDoctorAddAnnotation.setPrefWidth(123);
        addDoctorAddAnnotation.setRipplerFill(WHITE);

        descriptionVisits.setId("descriptionVisits");
        descriptionVisits.setLayoutX(23);
        descriptionVisits.setLayoutY(113);
        descriptionVisits.setPrefHeight(87);
        descriptionVisits.setPrefWidth(432);

        recommendedDrugs.setId("recommendedDrugs");
        recommendedDrugs.setLayoutX(23);
        recommendedDrugs.setLayoutY(252);
        recommendedDrugs.setPrefHeight(87);
        recommendedDrugs.setPrefWidth(432);

        information.setId("information");
        information.setLayoutX(53);
        information.setLayoutY(368);
        information.setPrefHeight(21);
        information.setPrefWidth(280);
        information.setFont(new Font("Arimo Bold", 15));
        information.setVisible(false);

        displayAddAnnotationDoctorPane.getChildren().addAll(information, recommendedDrugsTag, descriptionVisitsTag, titleTextDoctorAddAnnotation, addDoctorAddAnnotation, descriptionVisits, recommendedDrugs);
    }
    public void setContentToParent() {
        getMedicalHistoryAddAnnotationController().getBasicController().getBasicView().getMainPane().getChildren().addAll(displayAddAnnotationDoctorPane);
    }

    public void deleteAllElementsFromParent() {
        getMedicalHistoryAddAnnotationController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(displayAddAnnotationDoctorPane);
    }

    public MedicalHistoryAddAnnotationController getMedicalHistoryAddAnnotationController() {
        return medicalHistoryAddAnnotationController;
    }

    public void setMedicalHistoryAddAnnotationController(MedicalHistoryAddAnnotationController medicalHistoryAddAnnotationController) {
        this.medicalHistoryAddAnnotationController = medicalHistoryAddAnnotationController;
    }

    public JFXButton getAddDoctorAddAnnotation() {
        return addDoctorAddAnnotation;
    }

    public void setAddDoctorAddAnnotation(JFXButton addDoctorAddAnnotation) {
        this.addDoctorAddAnnotation = addDoctorAddAnnotation;
    }

    public JFXTextArea getDescriptionVisits() {
        return descriptionVisits;
    }
    public void setDescriptionVisits(JFXTextArea descriptionVisits) {
        this.descriptionVisits = descriptionVisits;
    }

    public JFXTextArea getRecommendedDrugs() {
        return recommendedDrugs;
    }
    public void setRecommendedDrugs(JFXTextArea recommendedDrugs) {
        this.recommendedDrugs = recommendedDrugs;
    }

    public Label getInformation() {
        return information;
    }
    public void setInformation(Label information) {
        this.information = information;
    }

    @Override
    public void updateView() {
        titleTextDoctorAddAnnotation.setText(medicalHistoryAddAnnotationController.getBasicController().getResourceBundle().getString("doctorViewAddAnnotation.title"));
        descriptionVisitsTag.setText(medicalHistoryAddAnnotationController.getBasicController().getResourceBundle().getString("doctorViewAddAnnotation.descriptionVisitsTag"));
        recommendedDrugsTag.setText(medicalHistoryAddAnnotationController.getBasicController().getResourceBundle().getString("doctorViewAddAnnotation.recommendedDrugsTag"));
        addDoctorAddAnnotation.setText(medicalHistoryAddAnnotationController.getBasicController().getResourceBundle().getString("doctorViewAddAnnotation.addButton"));
        information.setText(medicalHistoryAddAnnotationController.getBasicController().getResourceBundle().getString("doctorViewAddAnnotation.information"));
    }
}
