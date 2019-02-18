package dao;

import model.EmployeeModel;
import model.TypeEmployeeModel;
import pojo.EmployeePOJO;
import utils.MyEntityManagerFactory;
import utils.User;
import utils.UserNames;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModelDaoImpl implements EmployeeModelDao {

    private EntityManager entityManager = MyEntityManagerFactory.getInstance().getEmFactory().createEntityManager();


    @Override
    public boolean checkLoginAndPasswordEmployeeInDatabase(String login, String password) {
        boolean databaseContain = false;

        List<EmployeeModel> list = entityManager.
                createQuery("Select e from EmployeeModel e where ((e.email like :paramEmail)and (e.password like :paramPassword) )")
                .setParameter("paramEmail", login)
                .setParameter("paramPassword", password)
                .getResultList();

        if (!list.isEmpty()) {
            if(list.get(0).getTypeEmployeeModel().getName().equals("Admin")){
                User.getInstance().setCurrentUser(UserNames.ADMIN);
                setUserParameters(list);
            }
            else if(list.get(0).getTypeEmployeeModel().getName().equals("Doctor")){
                User.getInstance().setCurrentUser(UserNames.DOCTOR);
                setUserParameters(list);
            }
            else if(list.get(0).getTypeEmployeeModel().getName().equals("Employee")){
                User.getInstance().setCurrentUser(UserNames.EMPLOYEE);
                setUserParameters(list);
            }
            databaseContain = true;
        }
        cleanUp();
        return databaseContain;
    }

    @Override
    public int getEmployeeInDatabase(String Pesel) {
        List<EmployeeModel> list = entityManager.
                createQuery("Select e from EmployeeModel e where e.PESEL = :pesel")
                .setParameter("pesel", Pesel)
                .getResultList();
        return list.size();
    }

    private void setUserParameters(List<EmployeeModel> list) {
        User.getInstance().setId_user(list.get(0).getId_employee());
        User.getInstance().setName_user(list.get(0).getName());
        User.getInstance().setSurname_user(list.get(0).getSurname());
    }

//    @Override
//    public boolean isInDatabase(EmployeeModel employeeModel) {
//        boolean databaseContain = false;
//
//        List<EmployeeModel> list = entityManager.
//                createQuery("Select e from EmployeeModel e where e.email like :paramEmail")
//                .setParameter("paramEmail", employeeModel.getEmail())
//                .getResultList();
//        if (!list.isEmpty()) {
//            databaseContain = true;
//        }
//        cleanUp();
//        return databaseContain;
//    }

//    public List<EmployeeModel> getEmployeeInDatabase(EmployeeModel employeeModel) {
//        List<EmployeeModel> list = entityManager.
//                createQuery("Select e from EmployeeModel e")
//                .getResultList();
//        cleanUp();
//        return list;
//    }

    @Override
    public List<EmployeePOJO> getDoctorInDatabase() {
        List<EmployeeModel> list = entityManager.
                createQuery("Select e from EmployeeModel e where e.typeEmployeeModel.name like :type")
                .setParameter("type", "Doctor")
                .getResultList();

        List<EmployeePOJO> employeePOJOList = new ArrayList<>();
        employeePOJOList = addToEmployeePOJOList(list);
        return employeePOJOList;
    }

    @Override
    public List<TypeEmployeeModel> getTypeEmployeeInDatabase() {
        List<TypeEmployeeModel> list = entityManager.
                createQuery("Select e from TypeEmployeeModel e")
                .getResultList();
        return list;
    }

    @Override
    public List<EmployeePOJO> getEmployeeDatabase() {
        List<EmployeeModel> list = entityManager.
                createQuery("Select e from EmployeeModel e")
                .getResultList();
        List<EmployeePOJO> employeePOJOList = new ArrayList<>();
        employeePOJOList = addToEmployeePOJOList(list);
        return employeePOJOList;
    }

    private List<EmployeePOJO> addToEmployeePOJOList(List<EmployeeModel> list) {
        List<EmployeePOJO> employeePOJOList = new ArrayList<>();
        if(!list.isEmpty()){
            list.forEach(item ->{
                employeePOJOList.add(new EmployeePOJO(item.getId_employee(), item.getName(), item.getSurname(), item.getAge(), item.getEmail(), item.getPESEL()));
            });
        }
        return employeePOJOList;
    }
    @Override
    public EmployeeModel getEmployeeInDatabase(Long id) {
        List<EmployeeModel> list = entityManager.
                createQuery("Select e from EmployeeModel e where e.id_employee = :paramId")
                .setParameter("paramId",id )
                .getResultList();

        return list.get(0);
    }

    @Override
    public void save(EmployeeModel employeeModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(employeeModel);
        tx.commit();

    }

    @Override
    public void delete(EmployeeModel employeeModel) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(employeeModel);
        tx.commit();

    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }
}
