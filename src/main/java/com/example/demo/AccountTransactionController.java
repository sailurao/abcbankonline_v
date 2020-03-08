package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController

public class AccountTransactionController{

    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @GetMapping("/accountTransaction")
    public List<AccountTransaction> getAccountTransaction(){
        return accountTransactionRepository.findAll();
    }

    @GetMapping("/accountTransaction/{id}")
    public Optional<AccountTransaction> getAccountTransactionById(@PathVariable(value = "id") Integer id)
    {
        return accountTransactionRepository.findById(id);
    }

    @PostMapping("/accountTransaction")
    public @Valid AccountTransaction createAccountTransaction(@Valid @RequestBody AccountTransaction accountTransaction){
        return accountTransactionRepository.save(accountTransaction);
    }

    @PutMapping("/accountTransaction/{id}")
    public @Valid AccountTransaction updateAccountTransaction(@PathVariable(value="id") Integer id, @Valid @RequestBody AccountTransaction accountTransaction)
            throws AccountTransactionNotFoundException {
        AccountTransaction acc = accountTransactionRepository.findById(id).orElseThrow(() -> new AccountTransactionNotFoundException(id));
        acc.setAccountId(accountTransaction.getAccountId());
        acc.setTransactionNo(accountTransaction.getTransactionNo());
        acc.setTransactionDate(accountTransaction.getTransactionDate());
        acc.setTransactionAmount(accountTransaction.getTransactionAmount());
        acc.setTransactionType(accountTransaction.getTransactionType());
        acc.setLoanId(accountTransaction.getLoanId());
        acc.setPayeeId(accountTransaction.getPayeeId());
        acc.setBalance(accountTransaction.getBalance());

        AccountTransaction updAccount = accountTransactionRepository.save(acc);

        return updAccount;
    }

    @DeleteMapping("/accountTransaction/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable ("id") Integer id) throws AccountTransactionNotFoundException {
        AccountTransaction acc1=accountTransactionRepository.findById(id).orElseThrow(()->new AccountTransactionNotFoundException(id));
        accountTransactionRepository.delete(acc1);
        return ResponseEntity.ok().build();
    }

}

