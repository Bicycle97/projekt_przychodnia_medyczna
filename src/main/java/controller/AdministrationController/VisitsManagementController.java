package controller.AdministrationController;

import controller.BasicController;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import model.VisitsModel;
import pojo.VisitsPOJO;
import view.administrationView.AdministrationVisitsManagementView;

public class VisitsManagementController {

    private BasicController basicController;
    private AdministrationVisitsManagementView administrationVisitsManagementView;
    private AddVisitsController addVisitsController;

    public VisitsManagementController(BasicController basicController) {
        this.basicController = basicController;
        administrationVisitsManagementView = new AdministrationVisitsManagementView(this);
        administrationVisitsManagementView.updateView();
        getBasicController().addToInternationalizationList(administrationVisitsManagementView);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                initTable();
                System.out.println("TABLE LOADED");
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        setOnActionButtonAddVisits();
        setOnActionButtonModifyVisits();
        setOnActionButtonDeleteVisits();
    }

    public void initTable() {
        VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
        ObservableList<VisitsPOJO> data = FXCollections.observableArrayList(visitsModelDao.getVisitsDatabase());
        this.administrationVisitsManagementView.getTableAdministrationManagementView().setItems(data);
    }
    //Add Visits
    private void setOnActionButtonAddVisits() {

        this.getAdministrationVisitsManagementView().getAddVisitsAdministrationManagementView().setOnAction(event -> {
            setOnActionAddVisitsContent();
        });
    }
    private void setOnActionAddVisitsContent() {

        basicController.setIfModify(false);
        this.getAdministrationVisitsManagementView().deleteAllElementsFromParent();
        this.setAddVisitsController(new AddVisitsController(getBasicController()));
    }
    //Delete Patient
    private void setOnActionButtonDeleteVisits() {
        this.administrationVisitsManagementView.getCheckField().setDisable(true);
        this.administrationVisitsManagementView.getDeleteVisitsAdministrationManagementView().setDisable(true);
        this.administrationVisitsManagementView.getModifyVisitsAdministrationManagementView().setDisable(true);
        this.administrationVisitsManagementView.getTableAdministrationManagementView().setOnMouseClicked(event -> {
            if (this.administrationVisitsManagementView.getTableAdministrationManagementView().getSelectionModel().getSelectedItem() == null) {
                this.administrationVisitsManagementView.getCheckField().setDisable(true);
            } else {
                this.administrationVisitsManagementView.getCheckField().setDisable(false);
                this.administrationVisitsManagementView.getModifyVisitsAdministrationManagementView().setDisable(false);
            }
        });
        this.administrationVisitsManagementView.getCheckField().setOnMouseClicked(event -> {
            if (this.administrationVisitsManagementView.getCheckField().isSelected()) {
                this.administrationVisitsManagementView.getDeleteVisitsAdministrationManagementView().setDisable(false);
            } else {
                this.administrationVisitsManagementView.getDeleteVisitsAdministrationManagementView().setDisable(true);
            }
        });

        this.administrationVisitsManagementView.getDeleteVisitsAdministrationManagementView().setOnAction(event -> {
            setOnActionDeleteVisitsContent();
            this.administrationVisitsManagementView.getCheckField().setDisable(true);
            this.administrationVisitsManagementView.getCheckField().setSelected(false);
            this.administrationVisitsManagementView.getDeleteVisitsAdministrationManagementView().setDisable(true);
            this.administrationVisitsManagementView.getModifyVisitsAdministrationManagementView().setDisable(true);
        });
    }

    private void setOnActionDeleteVisitsContent() {

        VisitsModel visitsModel = new VisitsModel();
        VisitsModelDaoImpl visitsModelDaoImpl = new VisitsModelDaoImpl();

        Long id = this.administrationVisitsManagementView.getTableAdministrationManagementView().getSelectionModel().getSelectedItem().getId_visits();
        visitsModel = visitsModelDaoImpl.getVisitsInDatabase(id);

        visitsModelDaoImpl.delete(visitsModel);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                initTable();
                System.out.println("TABLE LOADED");
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    //Modify Visits
    private void setOnActionButtonModifyVisits() {

        this.getAdministrationVisitsManagementView().getModifyVisitsAdministrationManagementView().setOnAction(event -> {
            setOnActionModifyVisitsContent();
        });
    }

    private void setOnActionModifyVisitsContent() {
        basicController.setIfModify(true);
        basicController.setSelectVisits(this.getAdministrationVisitsManagementView().getTableAdministrationManagementView().getSelectionModel().getSelectedItem());
        this.getAdministrationVisitsManagementView().deleteAllElementsFromParent();
        this.setAddVisitsController(new AddVisitsController(getBasicController()));
    }
    //Getter and Setter
    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdministrationVisitsManagementView getAdministrationVisitsManagementView() {
        return administrationVisitsManagementView;
    }

    public void setAdministrationVisitsManagementView(AdministrationVisitsManagementView administrationVisitsManagementView) {
        this.administrationVisitsManagementView = administrationVisitsManagementView;
    }

    public AddVisitsController getAddVisitsController() {
        return addVisitsController;
    }

    public void setAddVisitsController(AddVisitsController addVisitsController) {
        this.addVisitsController = addVisitsController;
    }
}
