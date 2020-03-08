package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController

public class LoanController{

    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/loan")
    public List<Loan> getLoan(){
        return loanRepository.findAll();
    }

    @GetMapping("/loan/{id}")
    public Optional<Loan> getLoanById(@PathVariable(value = "id") Integer id)
    {
        return loanRepository.findById(id);
    }

    @PostMapping("/loan")
    public @Valid Loan createLoan(@Valid @RequestBody Loan loan){
        return loanRepository.save(loan);
    }

    @PutMapping("/loan/{id}")
    public @Valid Loan updateLoan(@PathVariable(value="id") Integer id, @Valid @RequestBody Loan loan)
            throws LoanNotFoundException {
        Loan acc = loanRepository.findById(id).orElseThrow(() -> new LoanNotFoundException(id));
        acc.setLoanId(loan.getLoanId());
        acc.setLoanType(loan.getLoanType());
        acc.setLoanAmount(loan.getLoanAmount());
        acc.setUserId(loan.getUserId());
        acc.setAccountId(loan.getAccountId());
        acc.setLoanOpenDate(loan.getLoanOpenDate());
        acc.setLoanStatus(loan.getLoanStatus());
        acc.setLoanTerm(loan.getLoanTerm());
        Loan updLoan = loanRepository.save(acc);
        return updLoan;
    }

    @DeleteMapping("/loan/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable ("id") Integer id) throws LoanNotFoundException {
        Loan acc1=loanRepository.findById(id).orElseThrow(()->new LoanNotFoundException(id));
        loanRepository.delete(acc1);
        return ResponseEntity.ok().build();
    }

}
