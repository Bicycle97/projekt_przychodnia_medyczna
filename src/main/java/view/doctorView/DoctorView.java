package view.doctorView;

import controller.DoctorController.DoctorController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.VisitsPOJO;
import view.Internationalization;

public class DoctorView implements Internationalization {
    private Label titleTextDoctorView = new Label();
    private TableView<VisitsPOJO> tableDoctorView = new TableView();
    private Pane doctorPane = new Pane();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();

    private DoctorController doctorController;

    public DoctorView(DoctorController doctorController) {
        this.doctorController = doctorController;
        setSettingsContent();
        setContentToParent();

    }

    private void setSettingsContent(){

        doctorPane.setId("doctorPane");
        doctorPane.setPrefHeight(444);
        doctorPane.setPrefWidth(500);
        doctorPane.setLayoutX(29);
        doctorPane.setLayoutY(14);

        titleTextDoctorView.setId("titleTextDoctorView");
        titleTextDoctorView.setLayoutX(49);
        titleTextDoctorView.setLayoutY(6);
        titleTextDoctorView.setPrefHeight(76);
        titleTextDoctorView.setPrefWidth(360);
        titleTextDoctorView.setTextAlignment(TextAlignment.CENTER);
        titleTextDoctorView.setWrapText(true);
        titleTextDoctorView.setFont(new Font("Avenir Next LT W04 Demi",27));

        tableColumn1.setPrefWidth(110);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("doctor"));

        tableColumn2.setPrefWidth(110);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("patient"));

        tableColumn3.setPrefWidth(110);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("date"));

        tableColumn4.setPrefWidth(110);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("time"));

        tableDoctorView.setId("tableDoctorView");
        tableDoctorView.setLayoutX(14);
        tableDoctorView.setLayoutY(70);
        tableDoctorView.setPrefHeight(345);
        tableDoctorView.setPrefWidth(457);

        tableDoctorView.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);

        doctorPane.getChildren().addAll(tableDoctorView,titleTextDoctorView);
    }

    public void setContentToParent() {
        getDoctorController().getBasicController().getBasicView().getMainPane().getChildren().addAll(doctorPane);
    }

    public void deleteAllElementsFromParent() {
        getDoctorController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(doctorPane);
    }

    public DoctorController getDoctorController() {
        return doctorController;
    }

    public TableView<VisitsPOJO> getTableDoctorView() {
        return tableDoctorView;
    }
    public void setTableDoctorView(TableView<VisitsPOJO> tableDoctorView) {
        this.tableDoctorView = tableDoctorView;
    }

    @Override
    public void updateView() {
        doctorController.getBasicController().getHeaderController().getHeaderView().getTextField().setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.headerLabel"));
        doctorController.getBasicController().getMenuController().getMenuView().getMenuButton1().setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.menuButton1Doctor"));
        doctorController.getBasicController().getMenuController().getMenuView().getMenuButton2().setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.menuButton2Doctor"));
        doctorController.getBasicController().getMenuController().getMenuView().getMenuButton3().setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.menuButton3Doctor"));
        doctorController.getBasicController().getMenuController().getMenuView().getMenuButton4().setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.menuButton4Doctor"));
        titleTextDoctorView.setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.title"));
        tableColumn1.setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.tableColumn1"));
        tableColumn2.setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.tableColumn2"));
        tableColumn3.setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.tableColumn3"));
        tableColumn4.setText(doctorController.getBasicController().getResourceBundle().getString("doctorView.tableColumn4"));
    }
}
