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
import java.util.function.Predicate;

@Service
public class InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    FundRepository fundRepository;

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public List<Investor> getALlInvestorsByClientId(long id) {
        return investorRepository.findByClientId(id);
    }

    public Investor createInvestor(long id, Investor investorRequest) {

        Investor newInvestor = clientRepository.findById(id).map(client -> {
            investorRequest.setClient(client);
            return investorRepository.save(investorRequest);
        }).orElseThrow(() -> new EntityNotFoundException("Could not find Client with id of " + id));

        return newInvestor;
    }

    public Investor investInAFund(long id, long investorId, int amountToInvest) {

        Fund associatedFund = fundRepository.findById(id).get();
        return investorRepository.findById(investorId).map(investor -> {
            if(investor.getFundList().contains(associatedFund)) {
                associatedFund.setAmount(associatedFund.getAmount() + amountToInvest);
            } else {
                investor.getFundList().add(associatedFund);
                associatedFund.getInvestorList().add(investor);
                associatedFund.setAmount(associatedFund.getAmount() + amountToInvest);
            }

            return investorRepository.save(investor);
        }).orElseThrow(() -> new EntityNotFoundException("Could not find Investor with id of "+ investorId));

    }

    public Investor getInvestorById(long id) {
        return investorRepository.findById(id).get();
    }
}
