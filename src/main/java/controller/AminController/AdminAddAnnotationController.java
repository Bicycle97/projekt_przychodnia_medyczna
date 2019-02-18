package controller.AminController;

import controller.BasicController;
import dao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EmployeeModel;
import model.GraphicModel;
import model.OfficeModel;
import pojo.EmployeePOJO;
import pojo.GraphicPojo;
import view.adminView.AdminAddAnnotationGraphic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AdminAddAnnotationController {
    private GraphicModel graphicModel;
    private BasicController basicController;
    private AdminAddAnnotationGraphic adminAddAnnotationGraphic;
    private AdminModifyGraphicController adminModifyGraphicController;
    GraphicModelDaoImpl graphicModelDao = new GraphicModelDaoImpl();

    public AdminAddAnnotationController(BasicController basicController) {
        this.basicController = basicController;
        adminAddAnnotationGraphic = new AdminAddAnnotationGraphic(this);
        adminAddAnnotationGraphic.updateView();
        getBasicController().addToInternationalizationList(adminAddAnnotationGraphic);
        setOnActionButtonChoiceEmployee();
        setOnActionButtonChoiceOffice();
        if (basicController.getModifyAnnotation() == true) {
            setOnActionModifyButton();
        } else {
            setOnActionAddButton();
        }
        setOnActionAddButton();
    }

    private void setOnActionButtonChoiceEmployee() {
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        ObservableList<EmployeePOJO> data = FXCollections.observableArrayList(employeeModelDao.getEmployeeDatabase());
        data.forEach(singleEmployeePojo -> {
            this.getAdminAddAnnotationGraphic().getChoiceEmployeeAddAnnotation().getItems().add(singleEmployeePojo);
        });
    }

    private void setOnActionButtonChoiceOffice() {
        ArrayList<OfficeModel> listOffice = new ArrayList<>();
        OfficeModel officeModel = new OfficeModel();
        OfficeModelDaoImpl officeModelDao = new OfficeModelDaoImpl();
        listOffice = (ArrayList<OfficeModel>) officeModelDao.getOfficeInDatabase(officeModel);
        for (OfficeModel om : listOffice) {
            this.getAdminAddAnnotationGraphic().getChoiceOfficeAddAnnotation().getItems().add(om.getNumber());
        }
    }

    private void setOnActionAddButton() {
        this.getAdminAddAnnotationGraphic().getAddButtonAddAnnotation().setOnAction(event -> {
            setOnActionAddButtonContent();
        });
    }

    private void setOnActionAddButtonContent() {
        graphicModel = new GraphicModel();
        if (!setOnActionContent(graphicModel)) {
            GraphicModelDao graphicModelDao = new GraphicModelDaoImpl();
            graphicModelDao.save(graphicModel);
            adminAddAnnotationGraphic.deleteAllElementsFromParent();
            this.setAdminModifyGraphicController(new AdminModifyGraphicController(getBasicController()));
        }
    }
    private void setOnActionModifyButton() {
        GraphicPojo selectGraphic = basicController.getSelectGraphic();
        graphicModel = graphicModelDao.getById(selectGraphic.getId_graphic());
        GraphicModel finalGrphicModel = graphicModel;
        EmployeeModelDaoImpl employeeModelDao = new EmployeeModelDaoImpl();
        ObservableList<EmployeePOJO> data = FXCollections.observableArrayList(employeeModelDao.getEmployeeDatabase());
        int index = 0;
        Long selectedId = selectGraphic.getId_graphic();
        graphicModel = graphicModelDao.getById(selectedId);
        data.forEach(singleEmployeePojo -> {
            if (singleEmployeePojo.getId_employee() == graphicModel.getEmployeeModel().getId_employee()) {
                adminAddAnnotationGraphic.getChoiceEmployeeAddAnnotation().getSelectionModel().select(data.indexOf(singleEmployeePojo));
            }
        });

        ArrayList<OfficeModel> listOffice = new ArrayList<>();
        OfficeModel officeModel = new OfficeModel();
        OfficeModelDaoImpl officeModelDao = new OfficeModelDaoImpl();
        listOffice = (ArrayList<OfficeModel>) officeModelDao.getOfficeInDatabase(officeModel);
        for (OfficeModel om : listOffice) {
            if (om.getNumber().equals(graphicModel.getOfficeModel().getNumber()))
                adminAddAnnotationGraphic.getChoiceOfficeAddAnnotation().getSelectionModel().select(listOffice.indexOf(om));
        }
        this.adminAddAnnotationGraphic.getChoiceStartTimeAddAnnotation().setValue(graphicModel.getTime_start());
        this.adminAddAnnotationGraphic.getChoiceEneTieAddAnnotation().setValue(graphicModel.getTime_end());
        this.adminAddAnnotationGraphic.getDatePicker().setValue(graphicModel.getDate());
        this.adminAddAnnotationGraphic.getAddButtonAddAnnotation().setVisible(false);
        this.adminAddAnnotationGraphic.getModifyButtonAddAnnotation().setVisible(true);

        this.getAdminAddAnnotationGraphic().getModifyButtonAddAnnotation().setOnAction(event -> {
            graphicModel = graphicModelDao.getById(graphicModel.getId_graphic());
            if (!setOnActionContent(finalGrphicModel)) {
                graphicModelDao.merge(finalGrphicModel);
                this.setAdminModifyGraphicController(new AdminModifyGraphicController(getBasicController()));
            }
        });
    }
    private boolean setOnActionContent(GraphicModel graphicModel) {

        String selectedEmployee;
        String office;
        LocalTime time_start;
        LocalTime time_end;
        LocalDate date;
        boolean ifNull = false;
        if (this.adminAddAnnotationGraphic.getChoiceEmployeeAddAnnotation().getSelectionModel().getSelectedItem() == null) {
            selectedEmployee = "";
        } else {
            selectedEmployee = this.adminAddAnnotationGraphic.getChoiceEmployeeAddAnnotation().getSelectionModel().getSelectedItem().toString();
        }

        if (this.getAdminAddAnnotationGraphic().getChoiceOfficeAddAnnotation().getSelectionModel().getSelectedItem() == null) {
            office = "";
        } else {
            office = this.adminAddAnnotationGraphic.getChoiceEmployeeAddAnnotation().getSelectionModel().getSelectedItem().toString();
        }

        if (this.getAdminAddAnnotationGraphic().getChoiceStartTimeAddAnnotation().getValue() == null) {
            time_start = null;
        } else {
            time_start = this.getAdminAddAnnotationGraphic().getChoiceStartTimeAddAnnotation().getValue();
        }

        if (this.getAdminAddAnnotationGraphic().getChoiceStartTimeAddAnnotation().getValue() == null) {
            time_end = null;
        } else {
            time_end = this.getAdminAddAnnotationGraphic().getChoiceEneTieAddAnnotation().getValue();
        }

        if (this.getAdminAddAnnotationGraphic().getChoiceStartTimeAddAnnotation().getValue() == null) {
            date = null;
        } else {
            date = this.getAdminAddAnnotationGraphic().getDatePicker().getValue();
        }
        if (selectedEmployee == "" || office == "" || time_start == null || time_end == null || date == null) {
            adminAddAnnotationGraphic.getInformation().setVisible(true);
            ifNull = true;
        } else {

            graphicModel.setDate(date);
            graphicModel.setTime_start(time_start);
            graphicModel.setTime_end(time_end);

            EmployeePOJO employee = (EmployeePOJO) this.adminAddAnnotationGraphic.getChoiceEmployeeAddAnnotation().getSelectionModel().getSelectedItem();
            Long id_employee = employee.getId_employee();
            EmployeeModelDao employeeModelDao = new EmployeeModelDaoImpl();
            EmployeeModel employeeModel = employeeModelDao.getEmployeeInDatabase(id_employee);

            String nr = this.getAdminAddAnnotationGraphic().getChoiceOfficeAddAnnotation().getSelectionModel().getSelectedItem().toString();
            OfficeModelDao officeModelDao = new OfficeModelDaoImpl();
            OfficeModel officeModel = officeModelDao.getOfficeInDatabase(nr);
            graphicModel.setOfficeModel(officeModel);
            graphicModel.setEmployeeModel(employeeModel);
            this.adminAddAnnotationGraphic.deleteAllElementsFromParent();
            ifNull = false;
        }

        return ifNull;
    }

    public BasicController getBasicController() {
        return basicController;
    }

    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public AdminAddAnnotationGraphic getAdminAddAnnotationGraphic() {
        return adminAddAnnotationGraphic;
    }

    public void setAdminAddAnnotationGraphic(AdminAddAnnotationGraphic adminAddAnnotationGraphic) {
        this.adminAddAnnotationGraphic = adminAddAnnotationGraphic;
    }

    public AdminModifyGraphicController getAdminModifyGraphicController() {
        return adminModifyGraphicController;
    }

    public void setAdminModifyGraphicController(AdminModifyGraphicController adminModifyGraphicController) {
        this.adminModifyGraphicController = adminModifyGraphicController;
    }
}
