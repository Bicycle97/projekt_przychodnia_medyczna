package view.administrationView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import controller.AdministrationController.PatientManagementController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.PatientPOJO;
import view.Internationalization;

public class AdministrationPatientManagementView implements Internationalization {

    private Pane patientManagementPane = new Pane();
    private Label titleTextAdministrationPatientManagement = new Label();
    private JFXButton deletePatientAdministrationPatientManagement = new JFXButton();
    private JFXButton modifyPatientAdministrationPatientManagement = new JFXButton();
    private JFXButton addPatientAdministrationPatientManagement = new JFXButton();
    private TableView<PatientPOJO> tablePatient = new TableView<>();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private TableColumn tableColumn5 = new TableColumn();
    private JFXCheckBox checkField = new JFXCheckBox();

    private PatientManagementController patientManagementController;

    public AdministrationPatientManagementView(PatientManagementController patientManagementController) {
        this.patientManagementController = patientManagementController;
        setSettingsContent();
        setContentToParent();

    }
    private void setSettingsContent(){

        patientManagementPane.setId("patientManagementPane");
        patientManagementPane.setPrefHeight(444);
        patientManagementPane.setPrefWidth(500);
        patientManagementPane.setLayoutX(29);
        patientManagementPane.setLayoutY(14);

        titleTextAdministrationPatientManagement.setId("titleTextAdministrationPatientManagement");
        titleTextAdministrationPatientManagement.setLayoutX(49);
        titleTextAdministrationPatientManagement.setLayoutY(6);
        titleTextAdministrationPatientManagement.setPrefHeight(76);
        titleTextAdministrationPatientManagement.setPrefWidth(360);
        titleTextAdministrationPatientManagement.setTextAlignment(TextAlignment.CENTER);
        titleTextAdministrationPatientManagement.setWrapText(true);
        titleTextAdministrationPatientManagement.setFont(new Font("Avenir Next LT W04 Demi",27));

        deletePatientAdministrationPatientManagement.setId("deletePatientAdministrationPatientManagement");
        deletePatientAdministrationPatientManagement.setButtonType(JFXButton.ButtonType.RAISED);
        deletePatientAdministrationPatientManagement.setLayoutX(29);
        deletePatientAdministrationPatientManagement.setLayoutY(340);
        deletePatientAdministrationPatientManagement.setPrefHeight(31);
        deletePatientAdministrationPatientManagement.setPrefWidth(103);
        deletePatientAdministrationPatientManagement.setRipplerFill(Paint.valueOf("WHITE"));


        modifyPatientAdministrationPatientManagement.setId("modifyPatientAdministrationPatientManagement");
        modifyPatientAdministrationPatientManagement.setButtonType(JFXButton.ButtonType.RAISED);
        modifyPatientAdministrationPatientManagement.setLayoutX(29);
        modifyPatientAdministrationPatientManagement.setLayoutY(380);
        modifyPatientAdministrationPatientManagement.setPrefHeight(31);
        modifyPatientAdministrationPatientManagement.setPrefWidth(103);
        modifyPatientAdministrationPatientManagement.setRipplerFill(Paint.valueOf("WHITE"));

        checkField.setId("checkField");
        checkField.setLayoutX(150);
        checkField.setLayoutY(347);

        addPatientAdministrationPatientManagement.setId("addPatientAdministrationPatientManagement");
        addPatientAdministrationPatientManagement.setButtonType(JFXButton.ButtonType.RAISED);
        addPatientAdministrationPatientManagement.setLayoutX(420);
        addPatientAdministrationPatientManagement.setLayoutY(70);
        addPatientAdministrationPatientManagement.setPrefHeight(48);
        addPatientAdministrationPatientManagement.setPrefWidth(57);
        addPatientAdministrationPatientManagement.setRipplerFill(Paint.valueOf("WHITE"));
        addPatientAdministrationPatientManagement.setText("+");
        addPatientAdministrationPatientManagement.setFont(new Font(26));

        tableColumn1.setPrefWidth(80);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<PatientPOJO, String>("name"));

        tableColumn2.setPrefWidth(80);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<PatientPOJO, String>("surname"));

        tableColumn3.setPrefWidth(80);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<PatientPOJO, String>("email"));

        tableColumn4.setPrefWidth(80);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<PatientPOJO, String>("pesel"));

        tableColumn5.setPrefWidth(80);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<PatientPOJO, String>("address"));

        tablePatient.setId("tablePatient");
        tablePatient.setLayoutX(10);
        tablePatient.setLayoutY(70);
        tablePatient.setPrefHeight(261);
        tablePatient.setPrefWidth(400);
        tablePatient.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);

        patientManagementPane.getChildren().addAll(checkField, addPatientAdministrationPatientManagement, modifyPatientAdministrationPatientManagement, deletePatientAdministrationPatientManagement, tablePatient, titleTextAdministrationPatientManagement);
    }

    public void setContentToParent() {
        getPatientManagementController().getBasicController().getBasicView().getMainPane().getChildren().addAll(patientManagementPane);
    }

    public void deleteAllElementsFromParent() {
        getPatientManagementController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(patientManagementPane);
    }

    public PatientManagementController getPatientManagementController() {
        return patientManagementController;
    }

    public void setPatientManagementController(PatientManagementController patientManagementController) {
        this.patientManagementController = patientManagementController;
    }

    public Pane getPatientManagementPane() {
        return patientManagementPane;
    }

    public void setPatientManagementPane(Pane patientManagementPane) {
        this.patientManagementPane = patientManagementPane;
    }

    public Label getTitleTextAdministrationPatientManagement() {
        return titleTextAdministrationPatientManagement;
    }

    public void setTitleTextAdministrationPatientManagement(Label titleTextAdministrationPatientManagement) {
        this.titleTextAdministrationPatientManagement = titleTextAdministrationPatientManagement;
    }

    public JFXButton getDeletePatientAdministrationPatientManagement() {
        return deletePatientAdministrationPatientManagement;
    }

    public void setDeletePatientAdministrationPatientManagement(JFXButton deletePatientAdministrationPatientManagement) {
        this.deletePatientAdministrationPatientManagement = deletePatientAdministrationPatientManagement;
    }

    public JFXButton getModifyPatientAdministrationPatientManagement() {
        return modifyPatientAdministrationPatientManagement;
    }

    public void setModifyPatientAdministrationPatientManagement(JFXButton modifyPatientAdministrationPatientManagement) {
        this.modifyPatientAdministrationPatientManagement = modifyPatientAdministrationPatientManagement;
    }

    public JFXButton getAddPatientAdministrationPatientManagement() {
        return addPatientAdministrationPatientManagement;
    }

    public void setAddPatientAdministrationPatientManagement(JFXButton addPatientAdministrationPatientManagement) {
        this.addPatientAdministrationPatientManagement = addPatientAdministrationPatientManagement;
    }

    public TableView<PatientPOJO> getTablePatient() {
        return tablePatient;
    }
    public void setTablePatient(TableView<PatientPOJO> tablePatient) {
        this.tablePatient = tablePatient;
    }

    public JFXCheckBox getCheckField() {
        return checkField;
    }
    public void setCheckField(JFXCheckBox checkField) {
        this.checkField = checkField;
    }

    @Override
    public void updateView() {
        titleTextAdministrationPatientManagement.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.title"));
        tableColumn1.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.tableColumn1"));
        tableColumn2.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.tableColumn2"));
        tableColumn3.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.tableColumn3"));
        tableColumn4.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.tableColumn4"));
        tableColumn5.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.tableColumn5"));
        deletePatientAdministrationPatientManagement.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.deleteButton"));
        modifyPatientAdministrationPatientManagement.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.modifyButton"));
        checkField.setText(patientManagementController.getBasicController().getResourceBundle().getString("administrationViewPatientManagement.deleteCheckBox"));
    }
}
