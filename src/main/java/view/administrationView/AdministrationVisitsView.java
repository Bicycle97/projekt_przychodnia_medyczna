package view.administrationView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import controller.AdministrationController.ShowVisitsController;
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

public class AdministrationVisitsView implements Internationalization {

    private Label titleTextAdministrationVisitsView = new Label();
    private TableView<VisitsPOJO> tableVisitsAdministrationPatientManagement = new TableView<>();
    private JFXButton showVisits = new JFXButton();
    private Pane visitsPane = new Pane();
    private JFXDatePicker dateVisits = new JFXDatePicker();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();

    private ShowVisitsController showVisitsController;

    public AdministrationVisitsView(ShowVisitsController showVisitsController) {
        this.showVisitsController = showVisitsController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){
        visitsPane.setId("visitsPane");
        visitsPane.setPrefHeight(444);
        visitsPane.setPrefWidth(500);
        visitsPane.setLayoutX(29);
        visitsPane.setLayoutY(14);

        titleTextAdministrationVisitsView.setId("titleTextAdministrationVisitsView");
        titleTextAdministrationVisitsView.setLayoutX(49);
        titleTextAdministrationVisitsView.setLayoutY(6);
        titleTextAdministrationVisitsView.setPrefHeight(76);
        titleTextAdministrationVisitsView.setPrefWidth(360);
        titleTextAdministrationVisitsView.setTextAlignment(TextAlignment.CENTER);
        titleTextAdministrationVisitsView.setWrapText(true);
        titleTextAdministrationVisitsView.setFont(new Font("Avenir Next LT W04 Demi",27));

        showVisits.setId("showVisits");
        showVisits.setButtonType(JFXButton.ButtonType.RAISED);
        showVisits.setLayoutX(285);
        showVisits.setLayoutY(368);
        showVisits.setPrefHeight(48);
        showVisits.setPrefWidth(123);
        showVisits.setRipplerFill(Paint.valueOf("WHITE"));

        dateVisits.setId("dateVisits");
        dateVisits.setLayoutX(59);
        dateVisits.setLayoutY(82);
        dateVisits.setPrefHeight(31);
        dateVisits.setPrefWidth(157);

        tableColumn1.setPrefWidth(110);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("doctor"));

        tableColumn2.setPrefWidth(110);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("patient"));

        tableColumn3.setPrefWidth(110);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("date"));

        tableColumn4.setPrefWidth(110);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("time"));

        tableVisitsAdministrationPatientManagement.setId("tableVisitsAdministrationPatientManagement");
        tableVisitsAdministrationPatientManagement.setLayoutX(30);
        tableVisitsAdministrationPatientManagement.setLayoutY(128);
        tableVisitsAdministrationPatientManagement.setPrefHeight(230);
        tableVisitsAdministrationPatientManagement.setPrefWidth(440);

        tableVisitsAdministrationPatientManagement.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        visitsPane.getChildren().addAll(showVisits, tableVisitsAdministrationPatientManagement, dateVisits, titleTextAdministrationVisitsView);
    }

    public void setContentToParent() {
        getShowVisitsController().getBasicController().getBasicView().getMainPane().getChildren().addAll(visitsPane);
    }

    public void deleteAllElementsFromParent() {
        getShowVisitsController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(visitsPane);
    }

    public ShowVisitsController getShowVisitsController() {
        return showVisitsController;
    }

    public void setShowVisitsController(ShowVisitsController showVisitsController) {
        this.showVisitsController = showVisitsController;
    }

    public JFXDatePicker getDateVisits() {
        return dateVisits;
    }
    public void setDateVisits(JFXDatePicker dateVisits) {
        this.dateVisits = dateVisits;
    }

    public TableView<VisitsPOJO> getTableVisitsAdministrationPatientManagement() {
        return tableVisitsAdministrationPatientManagement;
    }

    public void setTableVisitsAdministrationPatientManagement(TableView<VisitsPOJO> tableVisitsAdministrationPatientManagement) {
        this.tableVisitsAdministrationPatientManagement = tableVisitsAdministrationPatientManagement;
    }

    public JFXButton getShowVisits() {
        return showVisits;
    }
    public void setShowVisits(JFXButton showVisits) {
        this.showVisits = showVisits;
    }

    @Override
    public void updateView() {
        titleTextAdministrationVisitsView.setText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.title"));
        dateVisits.setPromptText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.date"));
        tableColumn1.setText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.tableColumn1"));
        tableColumn2.setText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.tableColumn2"));
        tableColumn3.setText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.tableColumn3"));
        tableColumn4.setText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.tableColumn4"));
        showVisits.setText(showVisitsController.getBasicController().getResourceBundle().getString("administrationViewShowVisits.ShowButton"));
    }
}
