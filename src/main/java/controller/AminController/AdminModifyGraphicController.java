package controller.AminController;

import controller.BasicController;
import dao.GraphicModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import model.GraphicModel;
import pojo.GraphicPojo;
import view.adminView.AdminModifyGraphicView;

public class AdminModifyGraphicController {

    private BasicController basicController;
    private AdminModifyGraphicView adminModifyGraphicView;
    private AdminAddAnnotationController adminAddAnnotationController;
    private GraphicModel graphicModel;

    public AdminModifyGraphicController(BasicController basicController) {
        this.basicController = basicController;
        adminModifyGraphicView = new AdminModifyGraphicView(this);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                initGraphicTable();
                System.out.println("TABLE LOADED");
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        adminModifyGraphicView.updateView();
        getBasicController().addToInternationalizationList(adminModifyGraphicView);
        setOnActionButtonAddAnnotation();
        setOnActionButtonDeleteRowGraphicButton();
        setOnActionButtonEditRowGraphicButton();
    }

    public void initGraphicTable() {
        GraphicModelDaoImpl graphicModelDao = new GraphicModelDaoImpl();
        ObservableList<GraphicPojo> data = FXCollections.observableArrayList(graphicModelDao.getGraphicDatabase());
        this.getAdminModifyGraphicView().getListModifyGraphic().setItems(data);
    }

    private void setOnActionButtonAddAnnotation() {
        this.getAdminModifyGraphicView().getAddButtonModifyGraphic().setOnAction(event -> {
            setOnActionAddAnnotationContent();
        });
    }

    private void setOnActionAddAnnotationContent() {
        this.adminModifyGraphicView.deleteAllElementsFromParent();
        basicController.setModifyAnnotation(false);
        this.setAdminAddAnnotationController(new AdminAddAnnotationController(getBasicController()));
    }

    private void setOnActionButtonDeleteRowGraphicButton() {
        this.getAdminModifyGraphicView().getDeleteButtonModifyGraphic().setDisable(true);
        this.getAdminModifyGraphicView().getModifyButtonModifyGraphic().setDisable(true);
        this.getAdminModifyGraphicView().getListModifyGraphic().setOnMouseClicked(event -> {
            if (this.getAdminModifyGraphicView().getListModifyGraphic().getSelectionModel().getSelectedItem() == null) {
                this.getAdminModifyGraphicView().getDeleteButtonModifyGraphic().setDisable(true);
                this.getAdminModifyGraphicView().getModifyButtonModifyGraphic().setDisable(true);
            } else {
                this.getAdminModifyGraphicView().getDeleteButtonModifyGraphic().setDisable(false);
                this.getAdminModifyGraphicView().getModifyButtonModifyGraphic().setDisable(false);
            }
        });
        this.getAdminModifyGraphicView().getDeleteButtonModifyGraphic().setOnAction(event -> {
            setOnActionDeleteRowGraphicButtonContent();
        });
    }

    private void setOnActionDeleteRowGraphicButtonContent() {
        GraphicModelDaoImpl graphicModelDao = new GraphicModelDaoImpl();
        GraphicPojo selectedObjectFromTable = (GraphicPojo) this.getAdminModifyGraphicView().getListModifyGraphic().getSelectionModel().getSelectedItem();

        if (selectedObjectFromTable != null) {
            Long selectedId = selectedObjectFromTable.getId_graphic();
            GraphicModel graphicModel = graphicModelDao.getById(selectedId);

            if (graphicModel != null) {
                graphicModelDao.remove(graphicModel);
                Task<Void> task = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        initGraphicTable();
                        System.out.println("TABLE LOADED");
                        return null;
                    }
                };
                Thread th = new Thread(task);
                th.setDaemon(true);
                th.start();
            }
        }
        this.getAdminModifyGraphicView().getDeleteButtonModifyGraphic().setDisable(true);
    }

    private void setOnActionButtonEditRowGraphicButton() {

        this.getAdminModifyGraphicView().getModifyButtonModifyGraphic().setOnAction(event -> {
            setOnActionEditRowGraphicButtonContent();
        });
    }

    private void setOnActionEditRowGraphicButtonContent() {
        basicController.setModifyAnnotation(true);
        basicController.setSelectGraphic((GraphicPojo) this.getAdminModifyGraphicView().getListModifyGraphic().getSelectionModel().getSelectedItem());
        this.setAdminAddAnnotationController(new AdminAddAnnotationController(getBasicController()));
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdminModifyGraphicView getAdminModifyGraphicView() {
        return adminModifyGraphicView;
    }

    public void setAdminModifyGraphicView(AdminModifyGraphicView adminModifyGraphicView) {
        this.adminModifyGraphicView = adminModifyGraphicView;
    }

    public AdminAddAnnotationController getAdminAddAnnotationController() {
        return adminAddAnnotationController;
    }

    public void setAdminAddAnnotationController(AdminAddAnnotationController adminAddAnnotationController) {
        this.adminAddAnnotationController = adminAddAnnotationController;
    }

    public GraphicModel getGraphicModel() {
        return graphicModel;
    }
    public void setGraphicModel(GraphicModel graphicModel) {
        this.graphicModel = graphicModel;
    }
}
