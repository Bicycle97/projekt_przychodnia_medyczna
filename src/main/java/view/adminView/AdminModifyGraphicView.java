package view.adminView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import controller.AminController.AdminModifyGraphicController;
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

public class AdminModifyGraphicView implements Internationalization {

    private Label promptTextModifyGraphic = new Label();
    private JFXButton addButtonModifyGraphic = new JFXButton();
    private JFXButton deleteButtonModifyGraphic = new JFXButton();
    private JFXButton modifyButtonModifyGraphic = new JFXButton();
    private JFXComboBox dateBoxModifyGraphic = new JFXComboBox();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private TableColumn tableColumn5 = new TableColumn();
    private TableColumn tableColumn6 = new TableColumn();
    private TableView<GraphicPojo> listModifyGraphic = new TableView<>();
    private Pane modifyGraphicPane = new Pane();

    private AdminModifyGraphicController adminModifyGraphicController;

    public AdminModifyGraphicView(AdminModifyGraphicController adminModifyGraphicController) {
        this.adminModifyGraphicController = adminModifyGraphicController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        modifyGraphicPane.setId("modifyGraphicPane");
        modifyGraphicPane.setPrefHeight(444);
        modifyGraphicPane.setPrefWidth(500);
        modifyGraphicPane.setLayoutX(29);
        modifyGraphicPane.setLayoutY(14);

        promptTextModifyGraphic.setId("promptTextModifyGraphic");
        promptTextModifyGraphic.setLayoutX(49);
        promptTextModifyGraphic.setLayoutY(6);
        promptTextModifyGraphic.setPrefHeight(76);
        promptTextModifyGraphic.setPrefWidth(360);
        promptTextModifyGraphic.setTextAlignment(TextAlignment.CENTER);
        promptTextModifyGraphic.setWrapText(true);
        promptTextModifyGraphic.setFont(new Font("Avenir Next LT W04 Demi",27));

        addButtonModifyGraphic.setId("addButtonModifyGraphic");
        addButtonModifyGraphic.setButtonType(JFXButton.ButtonType.RAISED);
        addButtonModifyGraphic.setLayoutX(381);
        addButtonModifyGraphic.setLayoutY(92);
        addButtonModifyGraphic.setPrefHeight(48);
        addButtonModifyGraphic.setPrefWidth(57);
        addButtonModifyGraphic.setRipplerFill(WHITE);
        addButtonModifyGraphic.setText("+");
        addButtonModifyGraphic.setFont(new Font(26));

        deleteButtonModifyGraphic.setId("deleteButtonModifyGraphic");
        deleteButtonModifyGraphic.setButtonType(JFXButton.ButtonType.RAISED);
        deleteButtonModifyGraphic.setLayoutX(376);
        deleteButtonModifyGraphic.setLayoutY(175);
        deleteButtonModifyGraphic.setPrefHeight(31);
        deleteButtonModifyGraphic.setPrefWidth(103);
        deleteButtonModifyGraphic.setRipplerFill(WHITE);

        modifyButtonModifyGraphic.setId("modifyButtonModifyGraphic");
        modifyButtonModifyGraphic.setButtonType(JFXButton.ButtonType.RAISED);
        modifyButtonModifyGraphic.setLayoutX(376);
        modifyButtonModifyGraphic.setLayoutY(224);
        modifyButtonModifyGraphic.setPrefHeight(31);
        modifyButtonModifyGraphic.setPrefWidth(103);
        modifyButtonModifyGraphic.setRipplerFill(WHITE);

        listModifyGraphic.setId("listModifyGraphicId");
        listModifyGraphic.setLayoutX(36);
        listModifyGraphic.setLayoutY(127);
        listModifyGraphic.setPrefHeight(225);
        listModifyGraphic.setPrefWidth(320);

        tableColumn1.setId("tableColumn1");
        tableColumn1.setPrefWidth(75);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<GraphicPojo, String>("name"));

        tableColumn2.setId("tableColumn2");
        tableColumn2.setPrefWidth(75);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<GraphicPojo, String>("surname"));

        tableColumn3.setId("tableColumn3");
        tableColumn3.setPrefWidth(75);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<GraphicPojo, Date>("date"));

        tableColumn4.setId("tableColumn4");
        tableColumn4.setPrefWidth(75);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<GraphicPojo, Time>("time_start"));

        tableColumn5.setId("tableColumn5");
        tableColumn5.setPrefWidth(75);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<GraphicPojo, Time>("time_end"));

        tableColumn6.setId("tableColumn6");
        tableColumn6.setPrefWidth(75);
        tableColumn6.setCellValueFactory(new PropertyValueFactory<GraphicPojo, String>("office"));

        listModifyGraphic.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4, tableColumn5, tableColumn6);
        modifyGraphicPane.getChildren().addAll(listModifyGraphic, modifyButtonModifyGraphic, deleteButtonModifyGraphic, addButtonModifyGraphic, promptTextModifyGraphic);
    }
    public void setContentToParent() {
        getAdminModifyGraphicController().getBasicController().getBasicView().getMainPane().getChildren().addAll(modifyGraphicPane);
    }

    public void deleteAllElementsFromParent() {
        getAdminModifyGraphicController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(modifyGraphicPane);
    }

    public AdminModifyGraphicController getAdminModifyGraphicController() {
        return adminModifyGraphicController;
    }

    public void setAdminModifyGraphicController(AdminModifyGraphicController adminModifyGraphicController) {
        this.adminModifyGraphicController = adminModifyGraphicController;
    }

    public Label getPromptTextModifyGraphic() {
        return promptTextModifyGraphic;
    }

    public void setPromptTextModifyGraphic(Label promptTextModifyGraphic) {
        this.promptTextModifyGraphic = promptTextModifyGraphic;
    }

    public JFXButton getAddButtonModifyGraphic() {
        return addButtonModifyGraphic;
    }

    public void setAddButtonModifyGraphic(JFXButton addButtonModifyGraphic) {
        this.addButtonModifyGraphic = addButtonModifyGraphic;
    }

    public JFXButton getDeleteButtonModifyGraphic() {
        return deleteButtonModifyGraphic;
    }

    public void setDeleteButtonModifyGraphic(JFXButton deleteButtonModifyGraphic) {
        this.deleteButtonModifyGraphic = deleteButtonModifyGraphic;
    }

    public JFXButton getModifyButtonModifyGraphic() {
        return modifyButtonModifyGraphic;
    }

    public void setModifyButtonModifyGraphic(JFXButton modifyButtonModifyGraphic) {
        this.modifyButtonModifyGraphic = modifyButtonModifyGraphic;
    }

    public JFXComboBox getDateBoxModifyGraphic() {
        return dateBoxModifyGraphic;
    }

    public void setDateBoxModifyGraphic(JFXComboBox dateBoxModifyGraphic) {
        this.dateBoxModifyGraphic = dateBoxModifyGraphic;
    }

    public TableView getListModifyGraphic() {
        return listModifyGraphic;
    }

    public void setListModifyGraphic(TableView listModifyGraphic) {
        this.listModifyGraphic = listModifyGraphic;
    }

    public Pane getModifyGraphicPane() {
        return modifyGraphicPane;
    }

    public void setModifyGraphicPane(Pane modifyGraphicPane) {
        this.modifyGraphicPane = modifyGraphicPane;
    }

    @Override
    public void updateView() {
        tableColumn1.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.tableColumn1"));
        tableColumn2.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.tableColumn2"));
        tableColumn3.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.tableColumn3"));
        tableColumn4.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.tableColumn4"));
        tableColumn5.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.tableColumn5"));
        tableColumn6.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.tableColumn6"));
        deleteButtonModifyGraphic.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.deleteButton"));
        modifyButtonModifyGraphic.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.modifyButton"));
        promptTextModifyGraphic.setText(adminModifyGraphicController.getBasicController().getResourceBundle().getString("adminModifyGraphicView.title"));
    }
}
