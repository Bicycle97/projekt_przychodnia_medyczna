package dao;


import model.EmployeeModel;
import model.GraphicModel;
import pojo.GraphicPojo;

import java.time.LocalDate;
import java.util.List;

public interface GraphicModelDao {
    List<GraphicPojo> getGraphicDatabase();
    List<GraphicPojo> getGraphicLogDoctorThisDateDatabase(LocalDate chosenDate, Long id);
    List<GraphicPojo> getGraphicLogDoctorDatabase(Long id);

    GraphicModel getById(Long selectedId);

    void save(GraphicModel graphicModel);

    // void change(GraphicModel graphicModel);
    void remove(GraphicModel graphicModel);
    void merge(GraphicModel graphicModel);
    void delete(EmployeeModel employeeModel);
    void cleanUp();
}
