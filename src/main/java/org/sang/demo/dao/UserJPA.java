package org.sang.demo.dao;

import org.sang.demo.test.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by CJF on 2018-12-24.
 */
public interface UserJPA extends JpaRepository<Person, Long>{
}
