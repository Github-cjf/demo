package org.sang.demo.dao;

import org.sang.demo.SexEnum;
import org.sang.demo.test.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CJF on 2018-12-24.
 */
@Repository
public interface UserJPA extends JpaRepository<Person, Long>{

    List<Person> findBySex(@Param("sex") SexEnum sex);

    List<Person> findByNameLike(@Param("name") String name);

    @Query(value = "select u.* from t_user u " +
            "where name = ?1 and sex = ?2", nativeQuery = true)
    List<Person> findByAttr(@Param("name") String name, @Param("sex")SexEnum sex);

    Page<Person> findByIdLessThan(long id, Pageable page);
}
