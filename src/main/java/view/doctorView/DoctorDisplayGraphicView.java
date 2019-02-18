package view.doctorView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import controller.DoctorController.ShowGraphicController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.GraphicPojo;
import view.Internationalization;

import java.sql.Time;
import java.util.Date;

import static javafx.scene.paint.Color.WHITE;

public class DoctorDisplayGraphicView implements Internationalization {
    private Pane displayGraphicPane = new Pane();
    private Label titleTextDoctorDisplayGraphic = new Label();
    private JFXButton showButtonDoctorDisplayGraphic = new JFXButton();
    private JFXDatePicker dataDoctorDisplayGraphic = new JFXDatePicker();
    private TableView<GraphicPojo> tableDoctorDisplayGraphic = new TableView();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private TableColumn tableColumn5 = new TableColumn();
    private TableColumn tableColumn6 = new TableColumn();
    private ShowGraphicController showGraphicController;

    public DoctorDisplayGraphicView(ShowGraphicController showGraphicController) {
        this.showGraphicController = showGraphicController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        displayGraphicPane.setId("displayGraphicPane");
        displayGraphicPane.setPrefHeight(444);
        displayGraphicPane.setPrefWidth(500);
        displayGraphicPane.setLayoutX(29);
        displayGraphicPane.setLayoutY(14);

        titleTextDoctorDisplayGraphic.setId("titleTextDoctorDisplayGraphic");
        titleTextDoctorDisplayGraphic.setLayoutX(49);
        titleTextDoctorDisplayGraphic.setLayoutY(6);
        titleTextDoctorDisplayGraphic.setPrefHeight(76);
        titleTextDoctorDisplayGraphic.setPrefWidth(360);
        titleTextDoctorDisplayGraphic.setTextAlignment(TextAlignment.CENTER);
        titleTextDoctorDisplayGraphic.setWrapText(true);
        titleTextDoctorDisplayGraphic.setFont(new Font("Avenir Next LT W04 Demi", 27));

        showButtonDoctorDisplayGraphic.setId("showButtonDoctorDisplayGraphic");
        showButtonDoctorDisplayGraphic.setButtonType(JFXButton.ButtonType.RAISED);
        showButtonDoctorDisplayGraphic.setLayoutX(285);
        showButtonDoctorDisplayGraphic.setLayoutY(368);
        showButtonDoctorDisplayGraphic.setPrefHeight(48);
        showButtonDoctorDisplayGraphic.setPrefWidth(123);
        showButtonDoctorDisplayGraphic.setRipplerFill(WHITE);

        dataDoctorDisplayGraphic.setId("dataDoctorDisplayGraphic");
        dataDoctorDisplayGraphic.setLayoutX(49);
        dataDoctorDisplayGraphic.setLayoutY(76);
        dataDoctorDisplayGraphic.setPrefHeight(31);
        dataDoctorDisplayGraphic.setPrefWidth(157);

        tableColumn1.setPrefWidth(75);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<GraphicPojo, String>("name"));

        tableColumn2.setPrefWidth(75);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<GraphicPojo, String>("surname"));

        tableColumn3.setPrefWidth(75);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<GraphicPojo, Date>("date"));

        tableColumn4.setPrefWidth(75);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<GraphicPojo, Time>("time_start"));

        tableColumn5.setPrefWidth(75);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<GraphicPojo, Time>("time_end"));

        tableColumn6.setPrefWidth(75);
        tableColumn6.setCellValueFactory(new PropertyValueFactory<GraphicPojo, String>("office"));


        tableDoctorDisplayGraphic.setId("tableDoctorDisplayGraphic");
        tableDoctorDisplayGraphic.setLayoutX(31);
        tableDoctorDisplayGraphic.setLayoutY(114);
        tableDoctorDisplayGraphic.setPrefHeight(246);
        tableDoctorDisplayGraphic.setPrefWidth(438);
        tableDoctorDisplayGraphic.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5, tableColumn6);
        displayGraphicPane.getChildren().addAll(dataDoctorDisplayGraphic, tableDoctorDisplayGraphic, showButtonDoctorDisplayGraphic, titleTextDoctorDisplayGraphic);
    }

    public void setContentToParent() {
        getShowGraphicController().getBasicController().getBasicView().getMainPane().getChildren().addAll(displayGraphicPane);
    }

    public void deleteAllElementsFromParent() {
        getShowGraphicController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(displayGraphicPane);
    }

    public ShowGraphicController getShowGraphicController() {
        return showGraphicController;
    }

    public void setShowGraphicController(ShowGraphicController showGraphicController) {
        this.showGraphicController = showGraphicController;
    }

    public JFXButton getShowButtonDoctorDisplayGraphic() {
        return showButtonDoctorDisplayGraphic;
    }

    public void setShowButtonDoctorDisplayGraphic(JFXButton showButtonDoctorDisplayGraphic) {
        this.showButtonDoctorDisplayGraphic = showButtonDoctorDisplayGraphic;
    }

    public JFXDatePicker getDataDoctorDisplayGraphic() {
        return dataDoctorDisplayGraphic;
    }

    public void setDataDoctorDisplayGraphic(JFXDatePicker dataDoctorDisplayGraphic) {
        this.dataDoctorDisplayGraphic = dataDoctorDisplayGraphic;
    }

    public TableView<GraphicPojo> getTableDoctorDisplayGraphic() {
        return tableDoctorDisplayGraphic;
    }

    public void setTableDoctorDisplayGraphic(TableView<GraphicPojo> tableDoctorDisplayGraphic) {
        this.tableDoctorDisplayGraphic = tableDoctorDisplayGraphic;
    }

    @Override
    public void updateView() {
        titleTextDoctorDisplayGraphic.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.title"));
        tableColumn1.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.tableColumn1"));
        tableColumn2.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.tableColumn2"));
        tableColumn3.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.tableColumn3"));
        tableColumn4.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.tableColumn4"));
        tableColumn5.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.tableColumn5"));
        tableColumn6.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.tableColumn6"));
        dataDoctorDisplayGraphic.setPromptText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.chooseADate"));
        showButtonDoctorDisplayGraphic.setText(showGraphicController.getBasicController().getResourceBundle().getString("doctorDisplayGraphic.displayButton"));
    }
}
