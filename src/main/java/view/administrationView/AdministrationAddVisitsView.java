package view.administrationView;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import controller.AdministrationController.AddVisitsController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

public class AdministrationAddVisitsView implements Internationalization {

    Image image = new Image("@../../images/dodanieWizyty.png");
    private Pane addVisitsPane = new Pane();
    private Label titleTextAdministrationAddVisits = new Label();
    private JFXButton addVisitsAdministrationAddVisits = new JFXButton();
    private JFXButton addVisitsAdministrationModifyVisits = new JFXButton();
    private Label employeeDataL = new Label();
    private Label patientDataL = new Label();
    private Label dateVisitsL = new Label();
    private Label timeVisitsL = new Label();
    private Label Information = new Label();
    private JFXComboBox employeeData = new JFXComboBox();
    private JFXComboBox patientData = new JFXComboBox();
    private JFXDatePicker dateVisits = new JFXDatePicker();
    private JFXTimePicker timeVisits = new JFXTimePicker();
    private ImageView addVisitsImage = new ImageView();
    private AddVisitsController addVisitsController;

    public AdministrationAddVisitsView(AddVisitsController addVisitsController) {
        this.addVisitsController = addVisitsController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent() {

        addVisitsPane.setId("addVisitsPane");
        addVisitsPane.setPrefHeight(444);
        addVisitsPane.setPrefWidth(500);
        addVisitsPane.setLayoutX(29);
        addVisitsPane.setLayoutY(14);

        titleTextAdministrationAddVisits.setId("titleTextAdministrationAddVisits");
        titleTextAdministrationAddVisits.setLayoutX(31);
        titleTextAdministrationAddVisits.setLayoutY(11);
        titleTextAdministrationAddVisits.setPrefHeight(76);
        titleTextAdministrationAddVisits.prefWidth(360);
        titleTextAdministrationAddVisits.setTextAlignment(TextAlignment.CENTER);
        titleTextAdministrationAddVisits.setWrapText(true);
        titleTextAdministrationAddVisits.setFont(new Font("Avenir Next LT W04 Demi", 27));

        addVisitsAdministrationModifyVisits.setId("addVisitsAdministrationModifyVisits");
        addVisitsAdministrationModifyVisits.setButtonType(JFXButton.ButtonType.RAISED);
        addVisitsAdministrationModifyVisits.setLayoutX(285);
        addVisitsAdministrationModifyVisits.setLayoutY(368);
        addVisitsAdministrationModifyVisits.setPrefHeight(48);
        addVisitsAdministrationModifyVisits.setPrefWidth(123);
        addVisitsAdministrationModifyVisits.setRipplerFill(Paint.valueOf("WHITE"));
        addVisitsAdministrationModifyVisits.setVisible(false);

        addVisitsAdministrationAddVisits.setId("addVisitsAdministrationAddVisits");
        addVisitsAdministrationAddVisits.setButtonType(JFXButton.ButtonType.RAISED);
        addVisitsAdministrationAddVisits.setLayoutX(285);
        addVisitsAdministrationAddVisits.setLayoutY(368);
        addVisitsAdministrationAddVisits.setPrefHeight(48);
        addVisitsAdministrationAddVisits.setPrefWidth(123);
        addVisitsAdministrationAddVisits.setRipplerFill(Paint.valueOf("WHITE"));

        addVisitsImage.setId("addVisitsImage");
        addVisitsImage.setFitHeight(117);
        addVisitsImage.setFitWidth(114);
        addVisitsImage.setLayoutX(363);
        addVisitsImage.setLayoutY(8);
        addVisitsImage.setPickOnBounds(true);
        addVisitsImage.setPreserveRatio(true);
        addVisitsImage.setImage(image);

        employeeData.setId("employeeData");
        employeeData.setLayoutX(168);
        employeeData.setLayoutY(117);
        employeeData.setPrefHeight(37);
        employeeData.setPrefWidth(205);

        employeeDataL.setId("employeeDataL");
        employeeDataL.setLayoutX(30);
        employeeDataL.setLayoutY(125);
        employeeDataL.setFont(new Font("Microsoft PhagsPa Bold", 15));

        patientData.setId("patientData");
        patientData.setLayoutX(168);
        patientData.setLayoutY(166);
        patientData.setPrefHeight(37);
        patientData.setPrefWidth(205);

        patientDataL.setId("patientDataL");
        patientDataL.setLayoutX(30);
        patientDataL.setLayoutY(174);
        patientDataL.setFont(new Font("Microsoft PhagsPa Bold", 15));

        dateVisits.setId("dateVisits");
        dateVisits.setLayoutX(168);
        dateVisits.setLayoutY(215);
        dateVisits.setPrefHeight(37);
        dateVisits.setPrefWidth(205);

        dateVisitsL.setId("dateVisitsL");
        dateVisitsL.setLayoutX(30);
        dateVisitsL.setLayoutY(223);
        dateVisitsL.setFont(new Font("Microsoft PhagsPa Bold", 15));

        timeVisits.setId("timeVisits");
        timeVisits.setLayoutX(168);
        timeVisits.setLayoutY(264);
        timeVisits.setPrefHeight(37);
        timeVisits.setPrefWidth(205);

        timeVisitsL.setId("timeVisitsL");
        timeVisitsL.setLayoutX(30);
        timeVisitsL.setLayoutY(272);
        timeVisitsL.setFont(new Font("Microsoft PhagsPa Bold", 15));

        Information.setId("information");
        Information.setLayoutX(83);
        Information.setLayoutY(368);
        Information.setPrefHeight(21);
        Information.setPrefWidth(180);
        Information.setFont(new Font("Arimo Bold", 15));
        Information.setVisible(false);

        addVisitsPane.getChildren().addAll(addVisitsImage, timeVisitsL, timeVisits, dateVisits, dateVisitsL, patientDataL, patientData, employeeDataL, employeeData, addVisitsAdministrationAddVisits, addVisitsAdministrationModifyVisits, titleTextAdministrationAddVisits, Information);

    }

    public void setContentToParent() {
        getAddVisitsController().getBasicController().getBasicView().getMainPane().getChildren().addAll(addVisitsPane);
    }

    public void deleteAllElementsFromParent() {
        getAddVisitsController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(addVisitsPane);
    }

    public AddVisitsController getAddVisitsController() {
        return addVisitsController;
    }

    public void setAddVisitsController(AddVisitsController addVisitsController) {
        this.addVisitsController = addVisitsController;
    }

    public Label getTitleTextAdministrationAddVisits() {
        return titleTextAdministrationAddVisits;
    }

    public void setTitleTextAdministrationAddVisits(Label titleTextAdministrationAddVisits) {
        this.titleTextAdministrationAddVisits = titleTextAdministrationAddVisits;
    }

    public JFXButton getAddVisitsAdministrationAddVisits() {
        return addVisitsAdministrationAddVisits;
    }

    public void setAddVisitsAdministrationAddVisits(JFXButton addVisitsAdministrationAddVisits) {
        this.addVisitsAdministrationAddVisits = addVisitsAdministrationAddVisits;
    }

    public JFXButton getAddVisitsAdministrationModifyVisits() {
        return addVisitsAdministrationModifyVisits;
    }

    public void setAddVisitsAdministrationModifyVisits(JFXButton addVisitsAdministrationModifyVisits) {
        this.addVisitsAdministrationModifyVisits = addVisitsAdministrationModifyVisits;
    }

    public JFXComboBox getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(JFXComboBox employeeData) {
        this.employeeData = employeeData;
    }

    public JFXComboBox getPatientData() {
        return patientData;
    }

    public void setPatientData(JFXComboBox patientData) {
        this.patientData = patientData;
    }

    public JFXDatePicker getDateVisits() {
        return dateVisits;
    }

    public void setDateVisits(JFXDatePicker dateVisits) {
        this.dateVisits = dateVisits;
    }

    public JFXTimePicker getTimeVisits() {
        return timeVisits;
    }

    public void setTimeVisits(JFXTimePicker timeVisits) {
        this.timeVisits = timeVisits;
    }

    public Label getInformation() {
        return Information;
    }

    public void setInformation(Label information) {
        Information = information;
    }

    @Override
    public void updateView() {
        employeeDataL.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.dataEmployeeTag"));
        patientDataL.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.dataPatientTag"));
        dateVisitsL.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.dateOfTheVistTag"));
        timeVisitsL.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.timeOfVistTag"));
        employeeData.setPromptText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.dataEmployee"));
        patientData.setPromptText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.dataPatient"));
        dateVisits.setPromptText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.dateOfTheVist"));
        timeVisits.setPromptText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.timeOfVist"));
        Information.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.information"));
        if (addVisitsController.getBasicController().isIfModify()) {
            addVisitsAdministrationModifyVisits.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewModifyVisits.modifyButton"));
            titleTextAdministrationAddVisits.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewModifyVisits.title"));
        } else {
            addVisitsAdministrationAddVisits.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.addButton"));
            titleTextAdministrationAddVisits.setText(addVisitsController.getBasicController().getResourceBundle().getString("administrationViewAddVisits.title"));
        }
    }
}
