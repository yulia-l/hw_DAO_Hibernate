package org.example.repository;

import org.example.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        String jpql = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = LOWER(:city)";
        return entityManager.createQuery(jpql, Person.class)
                .setParameter("city", city.toLowerCase())
                .getResultList();
    }
}
