package com.ark.arkassessment.repository;

import com.ark.arkassessment.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<Fund, Long> {

    List<Fund> findByClientId(Long clientId);
}
