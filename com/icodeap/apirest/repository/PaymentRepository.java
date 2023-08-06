package com.icodeap.apirest.repository;

import com.icodeap.apirest.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository <Payment,Long> {
}
