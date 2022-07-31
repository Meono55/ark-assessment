package com.ark.arkassessment.repository;

import com.ark.arkassessment.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

    List<Investor> findByClientId(Long clientId);
}
