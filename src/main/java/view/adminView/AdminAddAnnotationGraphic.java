package view.adminView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import controller.AminController.AdminAddAnnotationController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

import static javafx.scene.paint.Color.BLACK;

public class AdminAddAnnotationGraphic implements Internationalization {
    private Label titleTextAddAnnotation = new Label();
    private JFXButton addButtonAddAnnotation = new JFXButton();
    private JFXButton modifyButtonAddAnnotation = new JFXButton();
    private JFXComboBox choiceEmployeeAddAnnotation = new JFXComboBox();
    private JFXComboBox choiceOfficeAddAnnotation = new JFXComboBox();
    private JFXTimePicker choiceStartTimeAddAnnotation = new JFXTimePicker();
    private JFXTimePicker choiceEneTieAddAnnotation = new JFXTimePicker();
    private JFXDatePicker datePicker = new JFXDatePicker();
    private Pane addAnnotation = new Pane();
    private Label information = new Label();

    private AdminAddAnnotationController adminAddAnnotationController;

    public AdminAddAnnotationGraphic(AdminAddAnnotationController adminAddAnnotationController) {
        this.adminAddAnnotationController = adminAddAnnotationController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){
        addAnnotation.setId("addAnnotation");
        addAnnotation.setPrefHeight(444);
        addAnnotation.setPrefWidth(500);
        addAnnotation.setLayoutX(29);
        addAnnotation.setLayoutY(14);

        titleTextAddAnnotation.setId("titleTextAddAnnotation");
        titleTextAddAnnotation.setLayoutX(49);
        titleTextAddAnnotation.setLayoutY(6);
        titleTextAddAnnotation.setPrefHeight(76);
        titleTextAddAnnotation.setPrefWidth(360);
        titleTextAddAnnotation.setTextAlignment(TextAlignment.CENTER);
        titleTextAddAnnotation.setWrapText(true);
        titleTextAddAnnotation.setFont(new Font("Avenir Next LT W04 Demi",27));

        addButtonAddAnnotation.setId("addButtonAddAnnotation");
        addButtonAddAnnotation.setButtonType(JFXButton.ButtonType.RAISED);
        addButtonAddAnnotation.setLayoutX(285);
        addButtonAddAnnotation.setLayoutY(368);
        addButtonAddAnnotation.setPrefHeight(48);
        addButtonAddAnnotation.setPrefWidth(123);
        addButtonAddAnnotation.setRipplerFill(Paint.valueOf("WHITE"));

        modifyButtonAddAnnotation.setId("modifyButtonAddAnnotation");
        modifyButtonAddAnnotation.setButtonType(JFXButton.ButtonType.RAISED);
        modifyButtonAddAnnotation.setLayoutX(285);
        modifyButtonAddAnnotation.setLayoutY(368);
        modifyButtonAddAnnotation.setPrefHeight(48);
        modifyButtonAddAnnotation.setPrefWidth(123);
        modifyButtonAddAnnotation.setRipplerFill(Paint.valueOf("WHITE"));
        modifyButtonAddAnnotation.setVisible(false);

        datePicker.setId("datePicker");
        datePicker.setLayoutX(68);
        datePicker.setLayoutY(335);

        choiceEmployeeAddAnnotation.setId("choiceEmployeeAddAnnotation");
        choiceEmployeeAddAnnotation.setLayoutX(68);
        choiceEmployeeAddAnnotation.setLayoutY(89);
        choiceEmployeeAddAnnotation.setPrefHeight(31);
        choiceEmployeeAddAnnotation.setPrefWidth(168);
        choiceEmployeeAddAnnotation.setUnFocusColor(BLACK);

        choiceOfficeAddAnnotation.setId("choiceOfficeAddAnnotation");
        choiceOfficeAddAnnotation.setLayoutX(68);
        choiceOfficeAddAnnotation.setLayoutY(150);
        choiceOfficeAddAnnotation.setPrefHeight(31);
        choiceOfficeAddAnnotation.setPrefWidth(168);
        choiceOfficeAddAnnotation.setUnFocusColor(BLACK);

        choiceStartTimeAddAnnotation.setId("choiceStartTimeAddAnnotation");
        choiceStartTimeAddAnnotation.setPrefHeight(Region.USE_COMPUTED_SIZE);
        choiceStartTimeAddAnnotation.setPrefWidth(Region.USE_COMPUTED_SIZE);
        choiceStartTimeAddAnnotation.setLayoutX(65);
        choiceStartTimeAddAnnotation.setLayoutY(213);

        information.setId("information");
        information.setLayoutX(60);
        information.setLayoutY(380);
        information.setPrefHeight(21);
        information.setPrefWidth(180);
        information.setFont(new Font("Arimo Bold", 15));
        information.setVisible(false);

        choiceEneTieAddAnnotation.setId("choiceEneTieAddAnnotation");
        choiceEneTieAddAnnotation.setLayoutX(68);
        choiceEneTieAddAnnotation.setLayoutY(272);

        addAnnotation.getChildren().addAll(modifyButtonAddAnnotation, information, datePicker, choiceEneTieAddAnnotation, choiceStartTimeAddAnnotation, choiceOfficeAddAnnotation, choiceEmployeeAddAnnotation, addButtonAddAnnotation, titleTextAddAnnotation);
    }

    public void setContentToParent() {
        getAdminAddAnnotationController().getBasicController().getBasicView().getMainPane().getChildren().addAll(addAnnotation);
    }

    public void deleteAllElementsFromParent() {
        getAdminAddAnnotationController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(addAnnotation);
    }

    public AdminAddAnnotationController getAdminAddAnnotationController() {
        return adminAddAnnotationController;
    }

    public void setAdminAddAnnotationController(AdminAddAnnotationController adminAddAnnotationController) {
        this.adminAddAnnotationController = adminAddAnnotationController;
    }

    public JFXTimePicker getChoiceStartTimeAddAnnotation() {
        return choiceStartTimeAddAnnotation;
    }

    public void setChoiceStartTimeAddAnnotation(JFXTimePicker choiceStartTimeAddAnnotation) {
        this.choiceStartTimeAddAnnotation = choiceStartTimeAddAnnotation;
    }

    public JFXTimePicker getChoiceEneTieAddAnnotation() {
        return choiceEneTieAddAnnotation;
    }

    public void setChoiceEneTieAddAnnotation(JFXTimePicker choiceEneTieAddAnnotation) {
        this.choiceEneTieAddAnnotation = choiceEneTieAddAnnotation;
    }

    public JFXDatePicker getDatePicker() {
        return datePicker;
    }
    public void setDatePicker(JFXDatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public Label getInformation() {
        return information;
    }

    public void setInformation(Label information) {
        this.information = information;
    }

    public JFXButton getModifyButtonAddAnnotation() {
        return modifyButtonAddAnnotation;
    }

    public void setModifyButtonAddAnnotation(JFXButton modifyButtonAddAnnotation) {
        this.modifyButtonAddAnnotation = modifyButtonAddAnnotation;
    }

    public Label getTitleTextAddAnnotation() {
        return titleTextAddAnnotation;
    }

    public void setTitleTextAddAnnotation(Label titleTextAddAnnotation) {
        this.titleTextAddAnnotation = titleTextAddAnnotation;
    }

    public JFXButton getAddButtonAddAnnotation() {
        return addButtonAddAnnotation;
    }

    public void setAddButtonAddAnnotation(JFXButton addButtonAddAnnotation) {
        this.addButtonAddAnnotation = addButtonAddAnnotation;
    }

    public JFXComboBox getChoiceEmployeeAddAnnotation() {
        return choiceEmployeeAddAnnotation;
    }

    public void setChoiceEmployeeAddAnnotation(JFXComboBox choiceEmployeeAddAnnotation) {
        this.choiceEmployeeAddAnnotation = choiceEmployeeAddAnnotation;
    }

    public JFXComboBox getChoiceOfficeAddAnnotation() {
        return choiceOfficeAddAnnotation;
    }

    public void setChoiceOfficeAddAnnotation(JFXComboBox choiceofficeAddAnnotation) {
        this.choiceOfficeAddAnnotation = choiceofficeAddAnnotation;
    }

    public Pane getAddAnnotation() {
        return addAnnotation;
    }

    public void setAddAnnotation(Pane addAnnotation) {
        this.addAnnotation = addAnnotation;
    }


    @Override
    public void updateView() {
        if (adminAddAnnotationController.getBasicController().getModifyAnnotation()) {
            titleTextAddAnnotation.setText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminModifyAnnotation.title"));
            modifyButtonAddAnnotation.setText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminModifyAnnotation.modifyButton"));
        } else {
            titleTextAddAnnotation.setText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.title"));
            addButtonAddAnnotation.setText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.addButton"));
        }
        choiceEmployeeAddAnnotation.setPromptText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.typeEmployeeComboBox"));
        choiceOfficeAddAnnotation.setPromptText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.officeComboBox"));
        choiceStartTimeAddAnnotation.setPromptText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.time_start"));
        choiceEneTieAddAnnotation.setPromptText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.time_end"));
        datePicker.setPromptText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.date"));
        information.setText(adminAddAnnotationController.getBasicController().getResourceBundle().getString("adminAddAnnotation.information"));
    }
}
