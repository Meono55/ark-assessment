package com.ark.arkassessment.controller;

import com.ark.arkassessment.model.Fund;
import com.ark.arkassessment.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FundController {

    @Autowired
    FundService fundService;

    @GetMapping("/funds")
    public ResponseEntity<List<Fund>> getAllFunds(){
        List<Fund> fundList = fundService.getAllFunds();
        return new ResponseEntity<>(fundList, HttpStatus.OK);
    }

    @GetMapping("/funds/{fundId}")
    public ResponseEntity<Fund> getFundById(@PathVariable("fundId") long id){
        Fund fund = fundService.getFundById(id);
        return new ResponseEntity<>(fund, HttpStatus.OK);
    }

    @GetMapping("/clients/{clientId}/funds")
    public ResponseEntity<List<Fund>> getAllFundsByClientId(@PathVariable("clientId") long id){
        List<Fund> investorListByClientId = fundService.getALlInvestorsByClientId(id);

        return new ResponseEntity<>(investorListByClientId, HttpStatus.OK);
    }


    @PostMapping("/clients/{clientId}/funds")
    public ResponseEntity<Fund> createFund(@PathVariable("clientId") long id, @RequestBody Fund fundRequest){
        Fund newFund = fundService.createFund(id, fundRequest);

        return new ResponseEntity<>(newFund, HttpStatus.OK);
    }

    @PutMapping("investors/{investorId}/{fundId}")
    public ResponseEntity<Fund> addNewInvestorToFund(@PathVariable("investorId") long investorId, @PathVariable("fundId")
                                                     long fundId){
        Fund updatedFundWithInvestor = fundService.addNewInvestorToFund(investorId, fundId);

        return new ResponseEntity<>(updatedFundWithInvestor, HttpStatus.OK);
    }
}
