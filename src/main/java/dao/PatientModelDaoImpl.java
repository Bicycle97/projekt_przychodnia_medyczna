package dao;

import model.PatientModel;
import pojo.PatientPOJO;
import utils.MyEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class PatientModelDaoImpl implements PatientModelDao {

    private EntityManager entityManager = MyEntityManagerFactory.getInstance().getEmFactory().createEntityManager();

    @Override
    public List<PatientPOJO> getPatientDatabase() {
        List<PatientModel> list = entityManager.
                createQuery("Select e from PatientModel e")
                .getResultList();

        List<PatientPOJO> patientPOJOList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(item -> {
                patientPOJOList.add(new PatientPOJO(item.getId_patient(), item.getName(), item.getSurname(), item.getEmail(), item.getPESEL(), item.getAddress()));
            });
        }
        return patientPOJOList;
    }

    @Override
    public int getPatientInDatabase(String PESEL) {
        List<PatientModel> list = entityManager.
                createQuery("Select e from PatientModel e where e.PESEL = :pesel")
                .setParameter("pesel", PESEL)
                .getResultList();
        return list.size();
    }
    @Override
    public PatientModel getPatientInDatabase(Long id) {
        List<PatientModel> list = entityManager.
                createQuery("Select e from PatientModel e where e.id_patient = :paramId")
                .setParameter("paramId", id)
                .getResultList();
        return list.get(0);
    }

    @Override
    public void save(PatientModel patientModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(patientModel);
        tx.commit();
    }

    @Override
    public void delete(PatientModel patientModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(patientModel);
        tx.commit();
    }

    @Override
    public void merge(PatientModel patientModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(patientModel);
        tx.commit();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }
}
