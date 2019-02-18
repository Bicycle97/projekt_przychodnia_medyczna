package dao;

import model.EmployeeModel;
import model.PatientModel;
import model.VisitsModel;
import pojo.VisitsPOJO;
import utils.MyEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class VisitsModelDaoImpl implements VisitsModelDao {
    private EntityManager entityManager = MyEntityManagerFactory.getInstance().getEmFactory().createEntityManager();

    @Override
    public List<VisitsPOJO> getVisitsDatabase() {
        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel  v")
                .getResultList();

        List<VisitsPOJO> visitsPOJOList = new ArrayList<>();
        visitsPOJOList = addToEmployeePOJOList(list);
        return visitsPOJOList;
    }

    @Override
    public List<VisitsPOJO> getVisitsThisDateDatabase(LocalDate selectDate) {
        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel  v where  v.date = :date")
                .setParameter("date", selectDate)
                .getResultList();

        List<VisitsPOJO> visitsPOJOList = new ArrayList<>();
        visitsPOJOList = addToEmployeePOJOList(list);
        return visitsPOJOList;
    }

    @Override
    public List<VisitsPOJO> getVisitsLogDoctorThisDateDatabase(LocalDate selectDate, Long id) {

        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel  v where  v.date = :date and v.employeeModell.id_employee = :currentEmployee")
                .setParameter("date", selectDate)
                .setParameter("currentEmployee", id)
                .getResultList();

        List<VisitsPOJO> visitsPOJOList = new ArrayList<>();
        visitsPOJOList = addToEmployeePOJOList(list);
        return visitsPOJOList;
    }

    @Override
    public List<VisitsPOJO> getVisitsLogDoctorDatabase(Long id) {
        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel  v where   v.employeeModell.id_employee = :currentEmployee")
                .setParameter("currentEmployee", id)
                .getResultList();

        List<VisitsPOJO> visitsPOJOList = new ArrayList<>();
        visitsPOJOList = addToEmployeePOJOList(list);
        return visitsPOJOList;
    }

    private List<VisitsPOJO> addToEmployeePOJOList(List<VisitsModel> list) {
        List<VisitsPOJO> visitsPOJOList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(item -> {
                Long id_visit = item.getId_visits();
                LocalDate date = item.getDate();
                LocalTime time = item.getTime();
                EmployeeModel employeeModel = item.getEmployeeModell();
                String employee = employeeModel.toString();
                PatientModel patientModel = item.getPatientModel();
                String patient = patientModel.toString();
                visitsPOJOList.add(new VisitsPOJO(id_visit, date, time, employee, patient));
            });
        }
        return visitsPOJOList;
    }

    @Override
    public VisitsModel getVisitsInDatabase(Long id) {
        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel v where v.id_visits = :paramId")
                .setParameter("paramId", id)
                .getResultList();
        return list.get(0);
    }

    @Override
    public void save(VisitsModel visitsModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(visitsModel);
        tx.commit();
    }

    @Override
    public void merge(VisitsModel visitsModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(visitsModel);
        tx.commit();
    }

    @Override
    public void delete(VisitsModel visitsModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(visitsModel);
        tx.commit();
    }

    @Override
    public void delete(EmployeeModel employee) {
        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel v where v.employeeModell = :employee")
                .setParameter("employee", employee)
                .getResultList();
        if (!list.isEmpty()) {
            list.forEach(singleVisit -> {
                delete(singleVisit);
            });
        }
    }

    @Override
    public void delete(PatientModel patientModel) {
        List<VisitsModel> list = entityManager.
                createQuery("Select v from VisitsModel v where v.patientModel = :patient")
                .setParameter("patient", patientModel)
                .getResultList();
        if (!list.isEmpty()) {
            list.forEach(singleVisit -> {
                delete(singleVisit);
            });
        }
    }


    @Override
    public void cleanUp() {

    }
}
