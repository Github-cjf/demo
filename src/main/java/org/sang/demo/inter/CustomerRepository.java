package org.sang.demo.inter;

import org.sang.demo.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by CJF on 2018-9-26.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
