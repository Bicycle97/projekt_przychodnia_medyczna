package view.adminView;

import controller.AminController.AdminController;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import pojo.EmployeePOJO;
import view.Internationalization;

public class AdminView implements Internationalization {

    private Label titleTextAdminView = new Label();
    private TableView<EmployeePOJO> tableAdminView = new TableView<>();
    private TableColumn tableColumn1 = new TableColumn();
    private TableColumn tableColumn2 = new TableColumn();
    private TableColumn tableColumn3 = new TableColumn();
    private TableColumn tableColumn4 = new TableColumn();
    private TableColumn tableColumn5 = new TableColumn();
    private Pane adminPane = new Pane();

    private AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
        setSettingsContent();
        setContentToParent();
    }





    private void setSettingsContent(){
        adminPane.setId("adminPane");
        adminPane.setPrefHeight(444);
        adminPane.setPrefWidth(500);
        adminPane.setLayoutX(29);
        adminPane.setLayoutY(14);

        tableColumn1.setId("tableColumn1");
        tableColumn1.setPrefWidth(75);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("name"));

        tableColumn2.setId("tableColumn2");
        tableColumn2.setPrefWidth(75);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("surname"));

        tableColumn3.setId("tableColumn3");
        tableColumn3.setPrefWidth(75);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("age"));

        tableColumn4.setId("tableColumn4");
        tableColumn4.setPrefWidth(75);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("email"));

        tableColumn5.setId("tableColumn5");
        tableColumn5.setPrefWidth(75);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<EmployeePOJO, String>("psl"));

        titleTextAdminView.setId("titleTextAdminView");
        titleTextAdminView.setLayoutX(70);
        titleTextAdminView.setLayoutY(23);
        titleTextAdminView.setPrefHeight(76);
        titleTextAdminView.setPrefWidth(360);
        titleTextAdminView.setTextAlignment(TextAlignment.CENTER);
        titleTextAdminView.setWrapText(true);
        titleTextAdminView.setFont(new Font("Avenir Next LT W04 Demi",27));

        tableAdminView.setId("tableAdminViewId");
        tableAdminView.setLayoutX(29);
        tableAdminView.setLayoutY(106);
        tableAdminView.setPrefHeight(261);
        tableAdminView.setPrefWidth(437);
        tableAdminView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3,tableColumn4,tableColumn5);

        adminPane.getChildren().addAll(titleTextAdminView,tableAdminView);
    }

    public void setContentToParent() {
        getAdminController().getBasicController().getBasicView().getMainPane().getChildren().addAll(adminPane);
    }
    public void deleteAllElementsFromParent() {
        getAdminController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(adminPane);
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public Label getTitleTextAdminView() {
        return titleTextAdminView;
    }

    public void setTitleTextAdminView(Label titleTextAdminView) {
        this.titleTextAdminView = titleTextAdminView;
    }

    public TableView getTableAdminView() {
        return tableAdminView;
    }

    public void setTableAdminView(TableView tableAdminView) {
        this.tableAdminView = tableAdminView;
    }

    public Pane getAdminPane() {
        return adminPane;
    }

    public void setAdminPane(Pane adminPane) {
        this.adminPane = adminPane;
    }

    @Override
    public void updateView() {
        adminController.getBasicController().getHeaderController().getHeaderView().getTextField().setText(adminController.getBasicController().getResourceBundle().getString("adminView.headerLabel"));
        titleTextAdminView.setText(adminController.getBasicController().getResourceBundle().getString("adminView.titleText"));
        adminController.getBasicController().getMenuController().getMenuView().getMenuButton1().setText(adminController.getBasicController().getResourceBundle().getString("adminView.menuButton1Admin"));
        adminController.getBasicController().getMenuController().getMenuView().getMenuButton2().setText(adminController.getBasicController().getResourceBundle().getString("adminView.menuButton2Admin"));
        adminController.getBasicController().getMenuController().getMenuView().getMenuButton3().setText(adminController.getBasicController().getResourceBundle().getString("adminView.menuButton3Admin"));
        adminController.getBasicController().getMenuController().getMenuView().getMenuButton4().setText(adminController.getBasicController().getResourceBundle().getString("menuView.menuButton4"));
        tableColumn1.setText(adminController.getBasicController().getResourceBundle().getString("adminView.tableColumn1"));
        tableColumn2.setText(adminController.getBasicController().getResourceBundle().getString("adminView.tableColumn2"));
        tableColumn3.setText(adminController.getBasicController().getResourceBundle().getString("adminView.tableColumn3"));
        tableColumn4.setText(adminController.getBasicController().getResourceBundle().getString("adminView.tableColumn4"));
        tableColumn5.setText(adminController.getBasicController().getResourceBundle().getString("adminView.tableColumn5"));

    }
}
