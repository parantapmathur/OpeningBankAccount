package com.blueharvest.repository.controler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<CustomerAccount, Long> { }
