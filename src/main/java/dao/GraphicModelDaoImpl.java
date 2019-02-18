package dao;

import model.EmployeeModel;
import model.GraphicModel;
import pojo.GraphicPojo;
import utils.MyEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GraphicModelDaoImpl implements GraphicModelDao {

    private EntityManager entityManager = MyEntityManagerFactory.getInstance().getEmFactory().createEntityManager();


    @Override
    public List<GraphicPojo> getGraphicDatabase() {
        List<GraphicModel> list = entityManager.
                createQuery("Select g from GraphicModel g")
                .getResultList();
        List<GraphicPojo> graphicPojoList = new ArrayList<>();
        graphicPojoList = addToGraphicPOJOList(list);
        return graphicPojoList;
    }

    @Override
    public List<GraphicPojo> getGraphicLogDoctorThisDateDatabase(LocalDate chosenDate, Long id) {
        List<GraphicModel> list = entityManager.
                createQuery("Select g from GraphicModel g where  g.date = :date and g.employeeModel.id_employee = :currentEmployee")
                .setParameter("date", chosenDate)
                .setParameter("currentEmployee", id)
                .getResultList();
        List<GraphicPojo> graphicPojoList = new ArrayList<>();
        graphicPojoList = addToGraphicPOJOList(list);
        return graphicPojoList;
    }

    @Override
    public List<GraphicPojo> getGraphicLogDoctorDatabase(Long id) {
        List<GraphicModel> list = entityManager.
                createQuery("Select g from GraphicModel g where  g.employeeModel.id_employee = :currentEmployee")
                .setParameter("currentEmployee", id)
                .getResultList();
        List<GraphicPojo> graphicPojoList = new ArrayList<>();
        graphicPojoList = addToGraphicPOJOList(list);
        return graphicPojoList;
    }

    private List<GraphicPojo> addToGraphicPOJOList(List<GraphicModel> list) {
        List<GraphicPojo> graphicPojoList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(singleGraphic -> {
                Long id_graphic = singleGraphic.getId_graphic();
                LocalDate date = singleGraphic.getDate();
                LocalTime time_start = singleGraphic.getTime_start();
                LocalTime time_end = singleGraphic.getTime_end();
                String office = singleGraphic.getOfficeModel().getNumber();
                EmployeeModel employeeModel = singleGraphic.getEmployeeModel();
                String name = employeeModel.getName();
                String surname = employeeModel.getSurname();
                graphicPojoList.add(new GraphicPojo(id_graphic, date, time_start, time_end, name, surname, office));
            });
        }

        return graphicPojoList;
    }
    @Override
    public GraphicModel getById(Long selectedId) {
        List<GraphicModel> list = entityManager.
                createQuery("Select g from GraphicModel g where g.id_graphic = :paramId")
                .setParameter("paramId", selectedId)
                .getResultList();

        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }


    @Override
    public void save(GraphicModel graphicModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(graphicModel);
        tx.commit();
    }

//    @Override
//    public void change(GraphicModel graphicModel) {
//        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        entityManager.merge(graphicModel);
//        tx.commit();
//    }

    @Override
    public void remove(GraphicModel graphicModel) {

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(graphicModel);
        tx.commit();

    }

    @Override
    public void merge(GraphicModel graphicModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(graphicModel);
        tx.commit();
    }

    public void delete(GraphicModel graphicModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(graphicModel);
        tx.commit();
    }


    @Override
    public void delete(EmployeeModel employee) {
        List<GraphicModel> list = entityManager.
                createQuery("Select g from GraphicModel g where g.employeeModel = :employee")
                .setParameter("employee", employee)
                .getResultList();
        if (!list.isEmpty()) {
            list.forEach(singleGraphic -> {
                delete(singleGraphic);
            });
        }

    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }
}
