package com.jumia.phoneverification.backend.repo;

import com.jumia.phoneverification.backend.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findByPhoneContaining (String code);

}
