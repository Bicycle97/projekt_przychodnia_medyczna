package view.adminView;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.AminController.AdminAddEmployeeController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class AdminAddEmployeeView implements Internationalization {
    private Pane addEmployeePane = new Pane();
    private Label textAddField = new Label();
    private JFXTextField nameField = new JFXTextField();
    private JFXTextField surnameField = new JFXTextField();
    private JFXTextField emailField = new JFXTextField();
    private JFXTextField peselField = new JFXTextField();
    private JFXTextField ageField = new JFXTextField();
    private JFXButton  addButton= new JFXButton();
    private JFXPasswordField passwordField = new JFXPasswordField();
    private JFXComboBox typField = new JFXComboBox();
    private ImageView addEmployImage = new ImageView();
    private Label information = new Label();
    Image image = new Image("@../../images/dodaniePracownika.jpg");

    private AdminAddEmployeeController adminAddEmployeeController;

    public AdminAddEmployeeView(AdminAddEmployeeController adminAddEmployeeController) {
        this.adminAddEmployeeController = adminAddEmployeeController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){
        addEmployeePane.setId("addEmployeePane");
        addEmployeePane.setPrefHeight(444);
        addEmployeePane.setPrefWidth(500);
        addEmployeePane.setLayoutX(29);
        addEmployeePane.setLayoutY(14);

        textAddField.setId("textAddField");
        textAddField.setLayoutX(116);
        textAddField.setLayoutY(6);
        textAddField.setPrefHeight(76);
        textAddField.setPrefWidth(278);
        textAddField.setTextAlignment(TextAlignment.CENTER);
        textAddField.setWrapText(true);
        textAddField.setFont(new Font("Avenir Next LT W04 Demi",27));

        nameField.setId("nameField");
        nameField.setLayoutX(60);
        nameField.setLayoutY(82);
        nameField.setFont(new Font("Microsoft PhagsPa Bold",13));

        surnameField.setId("surnameField");
        surnameField.setLayoutX(60);
        surnameField.setLayoutY(124);
        surnameField.setFont(new Font("Microsoft PhagsPa Bold",13));

        emailField.setId("emailField");
        emailField.setLayoutX(60);
        emailField.setLayoutY(166);
        emailField.setFont(new Font("Microsoft PhagsPa Bold",13));

        peselField.setId("peselField");
        peselField.setLayoutX(60);
        peselField.setLayoutY(208);
        peselField.setFont(new Font("Microsoft PhagsPa Bold", 13));

        ageField.setId("ageField");
        ageField.setLayoutX(60);
        ageField.setLayoutY(250);
        ageField.setFont(new Font("Microsoft PhagsPa Bold",13));

        passwordField.setId("passwordField");
        passwordField.setFocusColor(BLACK);
        passwordField.setLabelFloat(true);
        passwordField.setLayoutX(60);
        passwordField.setLayoutY(351);
        passwordField.setPrefHeight(35);
        passwordField.setPrefWidth(168);
        passwordField.setUnFocusColor(BLACK);
        passwordField.setFont(new Font("Microsoft PhagsPa Bold",13));

        typField.setId("typField");
        typField.setLayoutX(60);
        typField.setLayoutY(292);
        typField.setPrefHeight(31);
        typField.setPrefWidth(168);
        typField.setUnFocusColor(BLACK);
        typField.getItems().addAll("Employee","Doctor","Admin");

        addEmployImage.setId("imageEmployee");
        addEmployImage.setFitHeight(152);
        addEmployImage.setFitWidth(219);
        addEmployImage.setLayoutX(256);
        addEmployImage.setLayoutY(99);
        addEmployImage.setPickOnBounds(true);
        addEmployImage.setPreserveRatio(true);
        addEmployImage.setImage(image);

        information.setId("information");
        information.setLayoutX(60);
        information.setLayoutY(410);
        information.setPrefHeight(21);
        information.setPrefWidth(280);
        information.setFont(new Font("Arimo Bold", 15));
        information.setVisible(false);

        addButton.setId("addButton");
        addButton.setButtonType(JFXButton.ButtonType.RAISED);
        addButton.setLayoutX(285);
        addButton.setLayoutY(368);
        addButton.setPrefHeight(48);
        addButton.setPrefWidth(123);
        addButton.setRipplerFill(WHITE);

        addEmployeePane.getChildren().addAll(addButton, addEmployImage, typField, passwordField, ageField, peselField, emailField, surnameField, nameField, textAddField, information);
    }

    public void setContentToParent() {
        getAdminAddEmployeeController().getBasicController().getBasicView().getMainPane().getChildren().addAll(addEmployeePane);
    }

    public void deleteAllElementsFromParent() {
        getAdminAddEmployeeController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(addEmployeePane);
    }

    public Label getInformation() {
        return information;
    }
    public void setInformation(Label information) {
        this.information = information;
    }

    public AdminAddEmployeeController getAdminAddEmployeeController() {
        return adminAddEmployeeController;
    }

    public void setAdminAddEmployeeController(AdminAddEmployeeController adminAddEmployeeController) {
        this.adminAddEmployeeController = adminAddEmployeeController;
    }

    public Pane getAddEmployeePane() {
        return addEmployeePane;
    }

    public void setAddEmployeePane(Pane addEmployeePane) {
        this.addEmployeePane = addEmployeePane;
    }

    public Label getTextAddField() {
        return textAddField;
    }

    public void setTextAddField(Label textAddField) {
        this.textAddField = textAddField;
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

    public JFXTextField getAgeField() {
        return ageField;
    }

    public void setAgeField(JFXTextField ageField) {
        this.ageField = ageField;
    }

    public JFXButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JFXButton addButton) {
        this.addButton = addButton;
    }

    public JFXPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JFXPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JFXComboBox getTypField() {
        return typField;
    }

    public void setTypField(JFXComboBox typField) {
        this.typField = typField;
    }

    public ImageView getAddEmployImage() {
        return addEmployImage;
    }

    public void setAddEmployImage(ImageView addEmployImage) {
        this.addEmployImage = addEmployImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void updateView() {
        textAddField.setText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.title"));
        nameField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.nameLabel"));
        surnameField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.surnameLabel"));
        emailField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.emailLabel"));
        peselField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.PESELLabel"));
        ageField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.ageLabel"));
        typField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.typeEmployeeComboBox"));
        passwordField.setPromptText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.passwordLabel"));
        addButton.setText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.addButton"));
        information.setText(adminAddEmployeeController.getBasicController().getResourceBundle().getString("adminAddEmployee.information"));
    }
}
