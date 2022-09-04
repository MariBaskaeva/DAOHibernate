package ru.netology.daohibernate.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernate.model.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DAOHibernateRepository implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Persons persons = Persons.builder()
                .surname("Ignatenko")
                .name("Mari")
                .age(21)
                .phoneNumber(123123)
                .cityOfLiving("Moscow")
                .build();
        entityManager.persist(persons);
    }

    public List<Persons> getPersonsByCity(String city){
        Query query = entityManager.createQuery("select p from Persons p where p.cityOfLiving = :city");
        query.setParameter("city", city);
        List<Persons> resultList = query.getResultList();
        return resultList;
    }

}
