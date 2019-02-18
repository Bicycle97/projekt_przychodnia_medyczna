package view.administrationView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import controller.AdministrationController.VisitsManagementController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.VisitsPOJO;
import view.Internationalization;

public class AdministrationVisitsManagementView implements Internationalization {

    private Label titleTextAdministrationManagementView = new Label();
    private JFXButton deleteVisitsAdministrationManagementView = new JFXButton();
    private JFXButton modifyVisitsAdministrationManagementView = new JFXButton();
    private JFXButton addVisitsAdministrationManagementView = new JFXButton();
    private TableView<VisitsPOJO> tableAdministrationManagementView = new TableView<>();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private Pane visitsManagementPane = new Pane();
    private JFXCheckBox checkField = new JFXCheckBox();


    private VisitsManagementController visitsManagementController;

    public AdministrationVisitsManagementView(VisitsManagementController visitsManagementController) {

        this.visitsManagementController = visitsManagementController;
        setSettingsContent();
        setContentToParent();
    }
    private void setSettingsContent(){

        visitsManagementPane.setId("visitsManagementPane");
        visitsManagementPane.setPrefHeight(444);
        visitsManagementPane.setPrefWidth(500);
        visitsManagementPane.setLayoutX(29);
        visitsManagementPane.setLayoutY(14);

        titleTextAdministrationManagementView.setId("titleTextAdministrationManagementView");
        titleTextAdministrationManagementView.setLayoutX(49);
        titleTextAdministrationManagementView.setLayoutY(6);
        titleTextAdministrationManagementView.setPrefHeight(76);
        titleTextAdministrationManagementView.setPrefWidth(360);
        titleTextAdministrationManagementView.setTextAlignment(TextAlignment.CENTER);
        titleTextAdministrationManagementView.setWrapText(true);
        titleTextAdministrationManagementView.setFont(new Font("Avenir Next LT W04 Demi",27));

        deleteVisitsAdministrationManagementView.setId("deleteVisitsAdministrationManagementView");
        deleteVisitsAdministrationManagementView.setButtonType(JFXButton.ButtonType.RAISED);
        deleteVisitsAdministrationManagementView.setLayoutX(29);
        deleteVisitsAdministrationManagementView.setLayoutY(340);
        deleteVisitsAdministrationManagementView.setPrefHeight(31);
        deleteVisitsAdministrationManagementView.setPrefWidth(103);
        deleteVisitsAdministrationManagementView.setRipplerFill(Paint.valueOf("WHITE"));

        checkField.setId("checkField");
        checkField.setLayoutX(150);
        checkField.setLayoutY(347);

        modifyVisitsAdministrationManagementView.setId("modifyVisitsAdministrationManagementView");
        modifyVisitsAdministrationManagementView.setButtonType(JFXButton.ButtonType.RAISED);
        modifyVisitsAdministrationManagementView.setLayoutX(29);
        modifyVisitsAdministrationManagementView.setLayoutY(380);
        modifyVisitsAdministrationManagementView.setPrefHeight(31);
        modifyVisitsAdministrationManagementView.setPrefWidth(103);
        modifyVisitsAdministrationManagementView.setRipplerFill(Paint.valueOf("WHITE"));


        addVisitsAdministrationManagementView.setId("addVisitsAdministrationManagementView");
        addVisitsAdministrationManagementView.setButtonType(JFXButton.ButtonType.RAISED);
        addVisitsAdministrationManagementView.setLayoutX(420);
        addVisitsAdministrationManagementView.setLayoutY(70);
        addVisitsAdministrationManagementView.setPrefHeight(48);
        addVisitsAdministrationManagementView.setPrefWidth(57);
        addVisitsAdministrationManagementView.setRipplerFill(Paint.valueOf("WHITE"));
        addVisitsAdministrationManagementView.setText("+");
        addVisitsAdministrationManagementView.setFont(new Font(26));

        tableColumn1.setPrefWidth(80);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("doctor"));

        tableColumn2.setPrefWidth(80);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("patient"));

        tableColumn3.setPrefWidth(80);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("date"));

        tableColumn4.setPrefWidth(80);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("time"));

        tableAdministrationManagementView.setId("tableAdministrationManagementView");
        tableAdministrationManagementView.setLayoutX(10);
        tableAdministrationManagementView.setLayoutY(70);
        tableAdministrationManagementView.setPrefHeight(261);
        tableAdministrationManagementView.setPrefWidth(400);
        tableAdministrationManagementView.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);

        visitsManagementPane.getChildren().addAll(checkField, tableAdministrationManagementView, addVisitsAdministrationManagementView, modifyVisitsAdministrationManagementView, deleteVisitsAdministrationManagementView, titleTextAdministrationManagementView);

    }

    public void setContentToParent() {
        getVisitsManagementController().getBasicController().getBasicView().getMainPane().getChildren().addAll(visitsManagementPane);
    }

    public void deleteAllElementsFromParent() {
        getVisitsManagementController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(visitsManagementPane);
    }

    public VisitsManagementController getVisitsManagementController() {
        return visitsManagementController;
    }

    public void setVisitsManagementController(VisitsManagementController visitsManagementController) {
        this.visitsManagementController = visitsManagementController;
    }

    public Label getTitleTextAdministrationManagementView() {
        return titleTextAdministrationManagementView;
    }

    public void setTitleTextAdministrationManagementView(Label titleTextAdministrationManagementView) {
        this.titleTextAdministrationManagementView = titleTextAdministrationManagementView;
    }

    public JFXButton getDeleteVisitsAdministrationManagementView() {
        return deleteVisitsAdministrationManagementView;
    }

    public void setDeleteVisitsAdministrationManagementView(JFXButton deleteVisitsAdministrationManagementView) {
        this.deleteVisitsAdministrationManagementView = deleteVisitsAdministrationManagementView;
    }

    public JFXButton getModifyVisitsAdministrationManagementView() {
        return modifyVisitsAdministrationManagementView;
    }

    public void setModifyVisitsAdministrationManagementView(JFXButton modifyVisitsAdministrationManagementView) {
        this.modifyVisitsAdministrationManagementView = modifyVisitsAdministrationManagementView;
    }

    public JFXButton getAddVisitsAdministrationManagementView() {
        return addVisitsAdministrationManagementView;
    }

    public void setAddVisitsAdministrationManagementView(JFXButton addVisitsAdministrationManagementView) {
        this.addVisitsAdministrationManagementView = addVisitsAdministrationManagementView;
    }

    public TableView<VisitsPOJO> getTableAdministrationManagementView() {
        return tableAdministrationManagementView;
    }

    public void setTableAdministrationManagementView(TableView<VisitsPOJO> tableAdministrationManagementView) {
        this.tableAdministrationManagementView = tableAdministrationManagementView;
    }

    public Pane getVisitsManagementPane() {
        return visitsManagementPane;
    }
    public void setVisitsManagementPane(Pane visitsManagementPane) {
        this.visitsManagementPane = visitsManagementPane;
    }

    public JFXCheckBox getCheckField() {
        return checkField;
    }
    public void setCheckField(JFXCheckBox checkField) {
        this.checkField = checkField;
    }

    @Override
    public void updateView() {
        titleTextAdministrationManagementView.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.title"));
        tableColumn1.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.tableColumn1"));
        tableColumn2.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.tableColumn2"));
        tableColumn3.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.tableColumn3"));
        tableColumn4.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.tableColumn4"));
        deleteVisitsAdministrationManagementView.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.deleteButton"));
        modifyVisitsAdministrationManagementView.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.modifyButton"));
        checkField.setText(visitsManagementController.getBasicController().getResourceBundle().getString("administrationViewVisitsManagement.deleteCheckBox"));
    }
}
