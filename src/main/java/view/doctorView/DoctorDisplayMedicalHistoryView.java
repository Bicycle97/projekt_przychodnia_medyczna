package view.doctorView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import controller.DoctorController.DisplayMedicalHistoryController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.PatientPOJO;
import view.Internationalization;

import static javafx.scene.paint.Color.WHITE;

public class DoctorDisplayMedicalHistoryView implements Internationalization {

    private Label titleTextDoctorDisplayMedicalHistory = new Label();
    private JFXButton displayButtonDoctorDisplayMedicalHistory = new JFXButton();
    private JFXComboBox choiceDoctorDisplayMedicalHistory = new JFXComboBox();
    private Pane medicalHistoryPane = new Pane();
    private TableView<PatientPOJO> tablePatient = new TableView<>();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private TableColumn tableColumn5 = new TableColumn();

    private DisplayMedicalHistoryController displayMedicalHistoryController;

    public DoctorDisplayMedicalHistoryView(DisplayMedicalHistoryController displayMedicalHistoryController) {
        this.displayMedicalHistoryController = displayMedicalHistoryController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent() {

        medicalHistoryPane.setId("medicalHistoryPane");
        medicalHistoryPane.setPrefHeight(444);
        medicalHistoryPane.setPrefWidth(500);
        medicalHistoryPane.setLayoutX(29);
        medicalHistoryPane.setLayoutY(14);

        titleTextDoctorDisplayMedicalHistory.setId("titleTextDoctorDisplayMedicalHistory");
        titleTextDoctorDisplayMedicalHistory.setLayoutX(49);
        titleTextDoctorDisplayMedicalHistory.setLayoutY(6);
        titleTextDoctorDisplayMedicalHistory.setPrefHeight(76);
        titleTextDoctorDisplayMedicalHistory.setPrefWidth(360);
        titleTextDoctorDisplayMedicalHistory.setTextAlignment(TextAlignment.CENTER);
        titleTextDoctorDisplayMedicalHistory.setWrapText(true);
        titleTextDoctorDisplayMedicalHistory.setFont(new Font("Avenir Next LT W04 Demi", 27));

        displayButtonDoctorDisplayMedicalHistory.setId("displayButtonDoctorDisplayMedicalHistory");
        displayButtonDoctorDisplayMedicalHistory.setButtonType(JFXButton.ButtonType.RAISED);
        displayButtonDoctorDisplayMedicalHistory.setLayoutX(285);
        displayButtonDoctorDisplayMedicalHistory.setLayoutY(368);
        displayButtonDoctorDisplayMedicalHistory.setPrefHeight(48);
        displayButtonDoctorDisplayMedicalHistory.setPrefWidth(123);
        displayButtonDoctorDisplayMedicalHistory.setRipplerFill(WHITE);

        choiceDoctorDisplayMedicalHistory.setId("choiceDoctorDisplayMedicalHistory");
        choiceDoctorDisplayMedicalHistory.setLayoutX(49);
        choiceDoctorDisplayMedicalHistory.setLayoutY(76);
        choiceDoctorDisplayMedicalHistory.setPrefHeight(31);
        choiceDoctorDisplayMedicalHistory.setPrefWidth(157);
        choiceDoctorDisplayMedicalHistory.setVisible(false);

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
        tablePatient.setLayoutX(31);
        tablePatient.setLayoutY(114);
        tablePatient.setPrefHeight(246);
        tablePatient.setPrefWidth(438);
        tablePatient.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5);

        medicalHistoryPane.getChildren().addAll(tablePatient, choiceDoctorDisplayMedicalHistory, displayButtonDoctorDisplayMedicalHistory, titleTextDoctorDisplayMedicalHistory);

    }

    public void setContentToParent() {
        getDisplayMedicalHistoryController().getBasicController().getBasicView().getMainPane().getChildren().addAll(medicalHistoryPane);
    }

    public void deleteAllElementsFromParent() {
        getDisplayMedicalHistoryController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(medicalHistoryPane);
    }

    public DisplayMedicalHistoryController getDisplayMedicalHistoryController() {
        return displayMedicalHistoryController;
    }

    public void setDisplayMedicalHistoryController(DisplayMedicalHistoryController displayMedicalHistoryController) {
        this.displayMedicalHistoryController = displayMedicalHistoryController;
    }

    public TableView<PatientPOJO> getTablePatient() {
        return tablePatient;
    }
    public void setTablePatient(TableView<PatientPOJO> tablePatient) {
        this.tablePatient = tablePatient;
    }

    public JFXButton getDisplayButtonDoctorDisplayMedicalHistory() {
        return displayButtonDoctorDisplayMedicalHistory;
    }

    public void setDisplayButtonDoctorDisplayMedicalHistory(JFXButton displayButtonDoctorDisplayMedicalHistory) {
        this.displayButtonDoctorDisplayMedicalHistory = displayButtonDoctorDisplayMedicalHistory;
    }

    @Override
    public void updateView() {
        titleTextDoctorDisplayMedicalHistory.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.title"));
        tableColumn1.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.tableColumn1"));
        tableColumn2.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.tableColumn2"));
        tableColumn3.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.tableColumn3"));
        tableColumn4.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.tableColumn4"));
        tableColumn5.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.tableColumn5"));
        displayButtonDoctorDisplayMedicalHistory.setText(displayMedicalHistoryController.getBasicController().getResourceBundle().getString("doctorViewDisplayMedicalHistory.displayButton"));
    }
}
