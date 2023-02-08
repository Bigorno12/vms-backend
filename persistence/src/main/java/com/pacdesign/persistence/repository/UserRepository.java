package com.pacdesign.persistence.repository;

import com.pacdesign.persistence.entity.User;
import com.pacdesign.persistence.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User> {
}
