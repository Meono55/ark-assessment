package com.ark.arkassessment.service;

import com.ark.arkassessment.model.Fund;
import com.ark.arkassessment.model.Investor;
import com.ark.arkassessment.repository.ClientRepository;
import com.ark.arkassessment.repository.FundRepository;
import com.ark.arkassessment.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FundService {

    @Autowired
    FundRepository fundRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    InvestorRepository investorRepository;

    public List<Fund> getAllFunds() {
        return fundRepository.findAll();
    }
    public List<Fund> getALlInvestorsByClientId(long id) {
        return fundRepository.findByClientId(id);
    }


    public Fund createFund(long id, Fund fundRequest) {

        Fund newFund = clientRepository.findById(id).map(client -> {
            fundRequest.setClient(client);
            return fundRepository.save(fundRequest);
        }).orElseThrow(() -> new EntityNotFoundException("Could not find Client with id of" + id));

        return newFund;
    }

    public Fund addNewInvestorToFund(long investorId, long fundId) {

        Investor investorToFund = investorRepository.findById(investorId).get();

        return fundRepository.findById(fundId).map(fund -> {
            fund.getInvestorList().add(investorToFund);
            investorToFund.getFundList().add(fund);
            return fundRepository.save(fund);
        }).orElseThrow(() -> new EntityNotFoundException("Could not find Fund with id of " + fundId));
    }

    public Fund getFundById(long id) {
        return fundRepository.findById(id).get();
    }
}
