package view.adminView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import controller.AminController.AdminDeleteEmployeeController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.EmployeePOJO;
import view.Internationalization;

public class AdminDeleteEmployeeView implements Internationalization {
    private Pane deleteEmployeePane = new Pane();
    private Label deleteEmployeeLabel = new Label();
    private JFXButton deleteEmployeeButton = new JFXButton();
    private TableView<EmployeePOJO> tableEmployee = new TableView<>();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private TableColumn tableColumn5 = new TableColumn();
    private JFXCheckBox  checkField = new JFXCheckBox();

    private AdminDeleteEmployeeController adminDeleteEmployeeController;

    public AdminDeleteEmployeeView(AdminDeleteEmployeeController adminDeleteEmployeeController) {
        this.adminDeleteEmployeeController = adminDeleteEmployeeController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        deleteEmployeePane.setId("deleteEmployeePane");
        deleteEmployeePane.setPrefHeight(444);
        deleteEmployeePane.setPrefWidth(500);
        deleteEmployeePane.setLayoutX(29);
        deleteEmployeePane.setLayoutY(14);

        deleteEmployeeLabel.setId("deleteEmployeeLabel");
        deleteEmployeeLabel.setLayoutX(117);
        deleteEmployeeLabel.setPrefHeight(76);
        deleteEmployeeLabel.setPrefWidth(236);
        deleteEmployeeLabel.setTextAlignment(TextAlignment.CENTER);
        deleteEmployeeLabel.setWrapText(true);
        deleteEmployeeLabel.setFont(new Font("Avenir Next LT W04 Demi",27));

        deleteEmployeeButton.setId("deleteEmployeeButton");
        deleteEmployeeButton.setButtonType(JFXButton.ButtonType.RAISED);
        deleteEmployeeButton.setLayoutX(285);
        deleteEmployeeButton.setLayoutY(368);
        deleteEmployeeButton.setPrefHeight(48);
        deleteEmployeeButton.setPrefWidth(123);
        deleteEmployeeButton.setRipplerFill(Paint.valueOf("WHITE"));

        tableColumn1.setPrefWidth(80);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("name"));

        tableColumn2.setPrefWidth(80);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("surname"));

        tableColumn3.setPrefWidth(80);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("age"));

        tableColumn4.setPrefWidth(80);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("email"));

        tableColumn5.setPrefWidth(80);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("psl"));

        tableEmployee.setId("tableEmployee");
        tableEmployee.setLayoutX(29);
        tableEmployee.setLayoutY(70);
        tableEmployee.setPrefHeight(261);
        tableEmployee.setPrefWidth(400);
        tableEmployee.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);

        checkField.setId("checkField");
        checkField.setLayoutX(97);
        checkField.setLayoutY(347);

        deleteEmployeePane.getChildren().addAll(checkField, deleteEmployeeLabel, deleteEmployeeButton, tableEmployee);
    }

    public void setContentToParent() {
        getAdminDeleteEmployeeController().getBasicController().getBasicView().getMainPane().getChildren().addAll(deleteEmployeePane);
    }

    public void deleteAllElementsFromParent() {
        getAdminDeleteEmployeeController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(deleteEmployeePane);
    }

    public AdminDeleteEmployeeController getAdminDeleteEmployeeController() {
        return adminDeleteEmployeeController;
    }

    public void setAdminDeleteEmployeeController(AdminDeleteEmployeeController adminDeleteEmployeeController) {
        this.adminDeleteEmployeeController = adminDeleteEmployeeController;
    }

    public Pane getDeleteEmployeePane() {
        return deleteEmployeePane;
    }

    public void setDeleteEmployeePane(Pane deleteEmployeePane) {
        this.deleteEmployeePane = deleteEmployeePane;
    }

    public Label getDeleteEmployeeLabel() {
        return deleteEmployeeLabel;
    }

    public void setDeleteEmployeeLabel(Label deleteEmployeeLabel) {
        this.deleteEmployeeLabel = deleteEmployeeLabel;
    }

    public JFXButton getDeleteEmployeeButton() {
        return deleteEmployeeButton;
    }

    public void setDeleteEmployeeButton(JFXButton deleteEmployeeButton) {
        this.deleteEmployeeButton = deleteEmployeeButton;
    }

    public TableView<EmployeePOJO> getTableEmployee() {
        return tableEmployee;
    }

    public void setTableEmployee(TableView<EmployeePOJO> tableEmployee) {
        this.tableEmployee = tableEmployee;
    }

    public JFXCheckBox getCheckField() {
        return checkField;
    }

    public void setCheckField(JFXCheckBox checkField) {
        this.checkField = checkField;
    }

    @Override
    public void updateView() {
        deleteEmployeeLabel.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.title"));
        tableColumn1.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.tableColumn1"));
        tableColumn2.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.tableColumn2"));
        tableColumn3.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.tableColumn3"));
        tableColumn4.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.tableColumn4"));
        tableColumn5.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.tableColumn5"));
        deleteEmployeeButton.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.removeButton"));
        checkField.setText(adminDeleteEmployeeController.getBasicController().getResourceBundle().getString("adminRemoveEmployee.textCheckBox"));

    }
}
