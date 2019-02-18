package view.administrationView;

import controller.AdministrationController.AdministrationController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.VisitsPOJO;
import view.Internationalization;

public class AdministrationView implements Internationalization {

    private Label titleTextAdministrationView = new Label();
    private TableView<VisitsPOJO> tableAdministrationView = new TableView();
    private Pane administrationPane = new Pane();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();

    private AdministrationController administrationController;

    public AdministrationView(AdministrationController administrationController) {

        this.administrationController = administrationController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        administrationPane.setId("administrationPane");
        administrationPane.setPrefHeight(444);
        administrationPane.setPrefWidth(500);
        administrationPane.setLayoutX(29);
        administrationPane.setLayoutY(14);

        titleTextAdministrationView.setId("titleTextAdministrationView");
        titleTextAdministrationView.setLayoutX(49);
        titleTextAdministrationView.setLayoutY(6);
        titleTextAdministrationView.setPrefHeight(76);
        titleTextAdministrationView.setPrefWidth(360);
        titleTextAdministrationView.setTextAlignment(TextAlignment.CENTER);
        titleTextAdministrationView.setWrapText(true);
        titleTextAdministrationView.setFont(new Font("Avenir Next LT W04 Demi",27));

        tableAdministrationView.setId("tableAdministrationView");
        tableAdministrationView.setLayoutX(14);
        tableAdministrationView.setLayoutY(70);
        tableAdministrationView.setPrefHeight(345);
        tableAdministrationView.setPrefWidth(457);

        tableColumn1.setPrefWidth(110);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("doctor"));

        tableColumn2.setPrefWidth(110);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("patient"));

        tableColumn3.setPrefWidth(110);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("date"));

        tableColumn4.setPrefWidth(110);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<VisitsPOJO, String>("time"));

        tableAdministrationView.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);

        administrationPane.getChildren().addAll(titleTextAdministrationView,tableAdministrationView);
    }

    public void setContentToParent() {
        getAdministrationController().getBasicController().getBasicView().getMainPane().getChildren().addAll(administrationPane);
    }

    public void deleteAllElementsFromParent() {
        getAdministrationController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(administrationPane);
    }

    public AdministrationController getAdministrationController() {
        return administrationController;
    }

    public TableView<VisitsPOJO> getTableAdministrationView() {
        return tableAdministrationView;
    }

    public void setTableAdministrationView(TableView<VisitsPOJO> tableAdministrationView) {
        this.tableAdministrationView = tableAdministrationView;
    }

    @Override
    public void updateView() {
        administrationController.getBasicController().getHeaderController().getHeaderView().getTextField().setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.headerLabel"));
        administrationController.getBasicController().getMenuController().getMenuView().getMenuButton1().setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.menuButton1Administrator"));
        administrationController.getBasicController().getMenuController().getMenuView().getMenuButton2().setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.menuButton2Administrator"));
        administrationController.getBasicController().getMenuController().getMenuView().getMenuButton3().setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.menuButton3Administrator"));
        administrationController.getBasicController().getMenuController().getMenuView().getMenuButton4().setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.menuButton4Administrator"));
        titleTextAdministrationView.setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.title"));
        tableColumn1.setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.tableColumn1"));
        tableColumn2.setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.tableColumn2"));
        tableColumn3.setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.tableColumn3"));
        tableColumn4.setText(administrationController.getBasicController().getResourceBundle().getString("administrationView.tableColumn4"));

    }
}
