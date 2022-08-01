package com.ark.arkassessment.controller;

import com.ark.arkassessment.model.AmountToInvest;
import com.ark.arkassessment.model.Investor;
import com.ark.arkassessment.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestorController {

    @Autowired
    InvestorService investorService;

    @GetMapping("/investors")
    public ResponseEntity<List<Investor>> getAllInvestors(){
        List<Investor> investorList = investorService.getAllInvestors();
        return new ResponseEntity<>(investorList, HttpStatus.OK);
    }

    @GetMapping("/investors/{investorId}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable("investorId") long id) {
        Investor investor = investorService.getInvestorById(id);
        return new ResponseEntity<>(investor, HttpStatus.OK);
    }

    @GetMapping("/clients/{clientId}/investors")
    public ResponseEntity<List<Investor>> getAllInvestorsByClientId(@PathVariable("clientId") long id){
        List<Investor> investorListByClientId = investorService.getALlInvestorsByClientId(id);

        return new ResponseEntity<>(investorListByClientId, HttpStatus.OK);
    }

    @PostMapping("/clients/{clientId}/investors")
    public ResponseEntity<Investor> createInvestor(@PathVariable("clientId") long id, @RequestBody Investor investorRequest){
        Investor newInvestor = investorService.createInvestor(id, investorRequest);

        return new ResponseEntity<>(newInvestor, HttpStatus.OK);
    }

    @PutMapping("/funds/{fundId}/{investorId}")
    public ResponseEntity<Investor> investInAFund(@PathVariable("fundId") long id, @PathVariable("investorId") long investorId, @RequestBody AmountToInvest amountToInvest){
        Investor updatedInvestorWithFund = investorService.investInAFund(id, investorId, amountToInvest.getAmount());

        return new ResponseEntity<>(updatedInvestorWithFund, HttpStatus.OK);
    }
}
