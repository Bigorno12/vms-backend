package com.pacdesign.persistence.repository;

import com.pacdesign.persistence.entity.Person;
import com.pacdesign.persistence.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends GenericRepository<Person> {
}
