package controller.AdministrationController;

import controller.BasicController;
import dao.VisitsModelDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import pojo.VisitsPOJO;
import view.administrationView.AdministrationVisitsView;

import java.time.LocalDate;

public class ShowVisitsController {

    private BasicController basicController;
    private AdministrationVisitsView administrationVisitsView;
    private LocalDate localDate;

    public ShowVisitsController(BasicController basicController) {
        this.basicController = basicController;
        administrationVisitsView = new AdministrationVisitsView(this);
        administrationVisitsView.updateView();
        getBasicController().addToInternationalizationList(administrationVisitsView);
        setOnActionShowVisit();
    }

    private void setOnActionShowVisit() {

        this.administrationVisitsView.getShowVisits().setOnAction(event -> {
            setOnActionContet();
        });
    }

    private void setOnActionContet() {
        localDate = this.administrationVisitsView.getDateVisits().getValue();
        System.out.println(localDate);
        if (localDate != null) {
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
    }

    public void initTable() {
        VisitsModelDaoImpl visitsModelDao = new VisitsModelDaoImpl();
        ObservableList<VisitsPOJO> data = FXCollections.observableArrayList(visitsModelDao.getVisitsThisDateDatabase(localDate));
        this.administrationVisitsView.getTableVisitsAdministrationPatientManagement().setItems(data);
    }


    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdministrationVisitsView getAdministrationVisitsView() {
        return administrationVisitsView;
    }

    public void setAdministrationVisitsView(AdministrationVisitsView administrationVisitsView) {
        this.administrationVisitsView = administrationVisitsView;
    }
}
