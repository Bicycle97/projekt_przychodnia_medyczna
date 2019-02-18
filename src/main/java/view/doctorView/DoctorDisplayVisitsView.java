package view.doctorView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import controller.DoctorController.ShowVisitsController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.VisitsPOJO;
import view.Internationalization;

import static javafx.scene.paint.Color.WHITE;

public class DoctorDisplayVisitsView implements Internationalization {

    private Pane displayVisitsPane = new Pane();
    private Label titleTextDoctorDisplayVisits = new Label();
    private JFXButton displayButtonDoctorDisplayVisits = new JFXButton();
    private JFXDatePicker dateDoctorDisplayVisits = new JFXDatePicker();
    private TableView<VisitsPOJO> tableDoctorDisplayVisits = new TableView();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();

    private ShowVisitsController showVisitsController;

    public DoctorDisplayVisitsView(ShowVisitsController showVisitsController) {
        this.showVisitsController = showVisitsController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        displayVisitsPane.setId("displayVisitsPane");
        displayVisitsPane.setPrefHeight(444);
        displayVisitsPane.setPrefWidth(500);
        displayVisitsPane.setLayoutX(29);
        displayVisitsPane.setLayoutY(14);

        titleTextDoctorDisplayVisits.setId("titleTextDoctorDisplayVisits");
        titleTextDoctorDisplayVisits.setLayoutX(49);
        titleTextDoctorDisplayVisits.setLayoutY(6);
        titleTextDoctorDisplayVisits.setPrefHeight(76);
        titleTextDoctorDisplayVisits.setPrefWidth(360);
        titleTextDoctorDisplayVisits.setTextAlignment(TextAlignment.CENTER);
        titleTextDoctorDisplayVisits.setWrapText(true);
        titleTextDoctorDisplayVisits.setFont(new Font("Avenir Next LT W04 Demi",27));

        displayButtonDoctorDisplayVisits.setId("displayButtonDoctorDisplayVisits");
        displayButtonDoctorDisplayVisits.setButtonType(JFXButton.ButtonType.RAISED);
        displayButtonDoctorDisplayVisits.setLayoutX(285);
        displayButtonDoctorDisplayVisits.setLayoutY(368);
        displayButtonDoctorDisplayVisits.setPrefHeight(48);
        displayButtonDoctorDisplayVisits.setPrefWidth(123);
        displayButtonDoctorDisplayVisits.setRipplerFill(WHITE);

        dateDoctorDisplayVisits.setId("dateDoctorDisplayVisits");
        dateDoctorDisplayVisits.setLayoutX(49);
        dateDoctorDisplayVisits.setLayoutY(76);
        dateDoctorDisplayVisits.setPrefHeight(31);
        dateDoctorDisplayVisits.setPrefWidth(157);

        tableColumn1.setPrefWidth(110);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("doctor"));

        tableColumn2.setPrefWidth(110);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("patient"));

        tableColumn3.setPrefWidth(110);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("date"));

        tableColumn4.setPrefWidth(110);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("time"));


        tableDoctorDisplayVisits.setId("tableDoctorDisplayVisits");
        tableDoctorDisplayVisits.setLayoutX(31);
        tableDoctorDisplayVisits.setLayoutY(114);
        tableDoctorDisplayVisits.setPrefHeight(246);
        tableDoctorDisplayVisits.setPrefWidth(438);

        tableDoctorDisplayVisits.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        displayVisitsPane.getChildren().addAll(tableDoctorDisplayVisits,dateDoctorDisplayVisits,displayButtonDoctorDisplayVisits,titleTextDoctorDisplayVisits);
    }
    public void setContentToParent() {
        getShowVisitsController().getBasicController().getBasicView().getMainPane().getChildren().addAll(displayVisitsPane);
    }

    public void deleteAllElementsFromParent() {
        getShowVisitsController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(displayVisitsPane);
    }

    public ShowVisitsController getShowVisitsController() {
        return showVisitsController;
    }

    public void setShowVisitsController(ShowVisitsController showVisitsController) {
        this.showVisitsController = showVisitsController;
    }

    public TableView<VisitsPOJO> getTableDoctorDisplayVisits() {
        return tableDoctorDisplayVisits;
    }

    public void setTableDoctorDisplayVisits(TableView<VisitsPOJO> tableDoctorDisplayVisits) {
        this.tableDoctorDisplayVisits = tableDoctorDisplayVisits;
    }

    public JFXDatePicker getDateDoctorDisplayVisits() {
        return dateDoctorDisplayVisits;
    }

    public void setDateDoctorDisplayVisits(JFXDatePicker dateDoctorDisplayVisits) {
        this.dateDoctorDisplayVisits = dateDoctorDisplayVisits;
    }

    public JFXButton getDisplayButtonDoctorDisplayVisits() {
        return displayButtonDoctorDisplayVisits;
    }

    public void setDisplayButtonDoctorDisplayVisits(JFXButton displayButtonDoctorDisplayVisits) {
        this.displayButtonDoctorDisplayVisits = displayButtonDoctorDisplayVisits;
    }

    @Override
    public void updateView() {
        titleTextDoctorDisplayVisits.setText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.title"));
        tableColumn1.setText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.tableColumn1"));
        tableColumn2.setText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.tableColumn2"));
        tableColumn3.setText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.tableColumn3"));
        tableColumn4.setText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.tableColumn4"));
        dateDoctorDisplayVisits.setPromptText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.chooseADate"));
        displayButtonDoctorDisplayVisits.setText(showVisitsController.getBasicController().getResourceBundle().getString("doctorViewAppointments.displayButton"));
    }
}
