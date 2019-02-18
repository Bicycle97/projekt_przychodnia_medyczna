package view.administrationView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.AdministrationController.AddPatientController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

public class AdministrationAddPatient implements Internationalization {

    Image image = new Image("@../../images/dodaniePacjenta.jpg");
    private AddPatientController addPatientController;
    private Pane patientAddPane = new Pane();
    private Label titleTextAdministrationAddPatient = new Label();
    private JFXButton addPatientAdministrationAddPatient = new JFXButton();
    private JFXButton addPatientAdministrationModifyPatient = new JFXButton();
    private JFXTextField nameField = new JFXTextField();
    private JFXTextField surnameField = new JFXTextField();
    private JFXTextField emailField = new JFXTextField();
    private JFXTextField peselField = new JFXTextField();
    private JFXTextField addressField = new JFXTextField();
    private Label nameFieldTag = new Label();
    private Label surnameFieldTag = new Label();
    private Label emailFieldTag = new Label();
    private Label peselFieldTag = new Label();
    private Label addressFieldTag = new Label();
    private Label Information = new Label();
    private ImageView addPatientImage = new ImageView();

    public AdministrationAddPatient(AddPatientController addPatientController) {
        this.addPatientController = addPatientController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent() {

        patientAddPane.setId("patientAddPane");
        patientAddPane.setPrefHeight(444);
        patientAddPane.setPrefWidth(500);
        patientAddPane.setLayoutX(29);
        patientAddPane.setLayoutY(14);

        titleTextAdministrationAddPatient.setId("titleTextAdministrationAddPatient");
        titleTextAdministrationAddPatient.setLayoutX(31);
        titleTextAdministrationAddPatient.setLayoutY(11);
        titleTextAdministrationAddPatient.setPrefHeight(76);
        titleTextAdministrationAddPatient.prefWidth(360);
        titleTextAdministrationAddPatient.setTextAlignment(TextAlignment.CENTER);
        titleTextAdministrationAddPatient.setWrapText(true);
        titleTextAdministrationAddPatient.setFont(new Font("Avenir Next LT W04 Demi", 27));

        addPatientAdministrationModifyPatient.setId("addPatientAdministrationModifyPatient");
        addPatientAdministrationModifyPatient.setButtonType(JFXButton.ButtonType.RAISED);
        addPatientAdministrationModifyPatient.setLayoutX(285);
        addPatientAdministrationModifyPatient.setLayoutY(368);
        addPatientAdministrationModifyPatient.setPrefHeight(48);
        addPatientAdministrationModifyPatient.setPrefWidth(123);
        addPatientAdministrationModifyPatient.setRipplerFill(Paint.valueOf("WHITE"));
        addPatientAdministrationModifyPatient.setVisible(false);

        addPatientAdministrationAddPatient.setId("addPatientAdministrationAddPatient");
        addPatientAdministrationAddPatient.setButtonType(JFXButton.ButtonType.RAISED);
        addPatientAdministrationAddPatient.setLayoutX(285);
        addPatientAdministrationAddPatient.setLayoutY(368);
        addPatientAdministrationAddPatient.setPrefHeight(48);
        addPatientAdministrationAddPatient.setPrefWidth(123);
        addPatientAdministrationAddPatient.setRipplerFill(Paint.valueOf("WHITE"));

        addPatientImage.setId("addPatientImage");
        addPatientImage.setFitHeight(128);
        addPatientImage.setFitWidth(171);
        addPatientImage.setLayoutX(307);
        addPatientImage.setLayoutY(11);
        addPatientImage.setPickOnBounds(true);
        addPatientImage.setPreserveRatio(true);
        addPatientImage.setImage(image);


        nameField.setId("nameField");
        nameField.setLayoutX(150);
        nameField.setLayoutY(129);
        nameField.setPrefHeight(31);
        nameField.setPrefWidth(168);
        nameField.setFont(new Font("Microsoft PhagsPa Bold", 13));

        nameFieldTag.setId("nameFieldTag");
        nameFieldTag.setLayoutX(50);
        nameFieldTag.setLayoutY(129);
        nameFieldTag.setPrefHeight(25);
        nameFieldTag.setPrefWidth(156.76171875);
        nameFieldTag.setFont(new Font("Microsoft PhagsPa Bold", 13));


        surnameField.setId("surnameField");
        surnameField.setLayoutX(150);
        surnameField.setLayoutY(174);
        surnameField.setPrefHeight(25);
        surnameField.setPrefWidth(157);
        surnameField.setFont(new Font("Microsoft PhagsPa Bold", 13));

        surnameFieldTag.setId("surnameFieldTag");
        surnameFieldTag.setLayoutX(50);
        surnameFieldTag.setLayoutY(174);
        surnameFieldTag.setPrefHeight(25);
        surnameFieldTag.setPrefWidth(157);
        surnameFieldTag.setFont(new Font("Microsoft PhagsPa Bold", 13));

        emailField.setId("emailField");
        emailField.setLayoutX(150);
        emailField.setLayoutY(219);
        emailField.setPrefHeight(25);
        emailField.setPrefWidth(156.76171875);
        emailField.setFont(new Font("Microsoft PhagsPa Bold", 13));

        emailFieldTag.setId("emailFieldTag");
        emailFieldTag.setLayoutX(50);
        emailFieldTag.setLayoutY(219);
        emailFieldTag.setPrefHeight(25);
        emailFieldTag.setPrefWidth(156.76171875);
        emailFieldTag.setFont(new Font("Microsoft PhagsPa Bold", 13));


        peselField.setId("peselField");
        peselField.setLayoutX(150);
        peselField.setLayoutY(264);
        peselField.setPrefHeight(25);
        peselField.setPrefWidth(156.76171875);
        peselField.setFont(new Font("Microsoft PhagsPa Bold", 13));

        peselFieldTag.setId("peselFieldTag");
        peselFieldTag.setLayoutX(50);
        peselFieldTag.setLayoutY(264);
        peselFieldTag.setPrefHeight(25);
        peselFieldTag.setPrefWidth(156.76171875);
        peselFieldTag.setFont(new Font("Microsoft PhagsPa Bold", 13));


        addressField.setId("addressField");
        addressField.setLayoutX(150);
        addressField.setLayoutY(309);
        addressField.setPrefHeight(25);
        addressField.setPrefWidth(156.76171875);
        addressField.setFont(new Font("Microsoft PhagsPa Bold", 13));

        addressFieldTag.setId("addressFieldTag");
        addressFieldTag.setLayoutX(50);
        addressFieldTag.setLayoutY(309);
        addressFieldTag.setPrefHeight(25);
        addressFieldTag.setPrefWidth(156.76171875);
        addressFieldTag.setFont(new Font("Microsoft PhagsPa Bold", 13));

        Information.setId("information");
        Information.setLayoutX(83);
        Information.setLayoutY(368);
        Information.setPrefHeight(21);
        Information.setPrefWidth(280);
        Information.setFont(new Font("Arimo Bold", 15));
        Information.setVisible(false);


        patientAddPane.getChildren().addAll(addPatientAdministrationModifyPatient, Information, addPatientImage, titleTextAdministrationAddPatient, addPatientAdministrationAddPatient, nameField, nameFieldTag, surnameField, surnameFieldTag, emailField, emailFieldTag, peselField, peselFieldTag, addressField, addressFieldTag);

    }

    public void setContentToParent() {
        getAddPatientController().getBasicController().getBasicView().getMainPane().getChildren().addAll(patientAddPane);
    }

    public void deleteAllElementsFromParent() {
        getAddPatientController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(patientAddPane);
    }

    public AddPatientController getAddPatientController() {
        return addPatientController;
    }

    public void setAddPatientController(AddPatientController addPatientController) {
        this.addPatientController = addPatientController;
    }

    public JFXTextField getNameField() {
        return nameField;
    }
    public void setNameField(JFXTextField nameField) {
        this.nameField = nameField;
    }

    public JFXTextField getSurnameField() {
        return surnameField;
    }
    public void setSurnameField(JFXTextField surnameField) {
        this.surnameField = surnameField;
    }

    public JFXTextField getEmailField() {
        return emailField;
    }
    public void setEmailField(JFXTextField emailField) {
        this.emailField = emailField;
    }

    public JFXTextField getPeselField() {
        return peselField;
    }
    public void setPeselField(JFXTextField peselField) {
        this.peselField = peselField;
    }

    public JFXTextField getAddressField() {
        return addressField;
    }
    public void setAddressField(JFXTextField addressField) {
        this.addressField = addressField;
    }

    public Pane getPatientAddPane() {
        return patientAddPane;
    }
    public void setPatientAddPane(Pane patientAddPane) {
        this.patientAddPane = patientAddPane;
    }

    public JFXButton getAddPatientAdministrationAddPatient() {
        return addPatientAdministrationAddPatient;
    }

    public void setAddPatientAdministrationAddPatient(JFXButton addPatientAdministrationAddPatient) {
        this.addPatientAdministrationAddPatient = addPatientAdministrationAddPatient;
    }

    public Label getInformation() {
        return Information;
    }
    public void setInformation(Label information) {
        Information = information;
    }

    public Label getTitleTextAdministrationAddPatient() {
        return titleTextAdministrationAddPatient;
    }

    public void setTitleTextAdministrationAddPatient(Label titleTextAdministrationAddPatient) {
        this.titleTextAdministrationAddPatient = titleTextAdministrationAddPatient;
    }

    public JFXButton getAddPatientAdministrationModifyPatient() {
        return addPatientAdministrationModifyPatient;
    }

    public void setAddPatientAdministrationModifyPatient(JFXButton addPatientAdministrationModifyPatient) {
        this.addPatientAdministrationModifyPatient = addPatientAdministrationModifyPatient;
    }

    @Override
    public void updateView() {

        nameFieldTag.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.nameTag"));
        surnameFieldTag.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.surnameTag"));
        emailFieldTag.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.emailTag"));
        peselFieldTag.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.PESELTag"));
        addressFieldTag.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.AddressTag"));
        nameField.setPromptText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.nameTag"));
        surnameField.setPromptText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.surnameTag"));
        emailField.setPromptText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.emailTag"));
        peselField.setPromptText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.PESELTag"));
        addressField.setPromptText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.AddressTag"));
        Information.setText(addPatientController.getBasicController().getResourceBundle().getString("adminAddAnnotation.information"));
        if (addPatientController.getBasicController().isIfModify()) {
            addPatientAdministrationModifyPatient.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewModifyPatient.modifyButton"));
            titleTextAdministrationAddPatient.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewModifyPatient.title"));

        } else {
            addPatientAdministrationAddPatient.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.addButton"));
            titleTextAdministrationAddPatient.setText(addPatientController.getBasicController().getResourceBundle().getString("administrationViewAddPatient.title"));
        }
    }
}
