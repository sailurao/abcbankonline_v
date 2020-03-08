package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class BillPayeeController{

    @Autowired
    BillPayeeRepository billPayeeRepository;

    @GetMapping("/billPayee")
    public List<BillPayee> getBillPayee(){
        return billPayeeRepository.findAll();
    }

    @GetMapping("/billPayee/{id}")
    public Optional<BillPayee> getBillPayeeById(@PathVariable(value = "id") Integer id)
    {
        return billPayeeRepository.findById(id);
    }

    @PostMapping("/billPayee")
    public @Valid BillPayee createBillPayee(@Valid @RequestBody BillPayee billPayee){
        return billPayeeRepository.save(billPayee);

    }

    @PutMapping("/billPayee/{id}")
    public BillPayee updateBillPayee(@PathVariable(value="id") Integer id, @Valid @RequestBody BillPayee billPayee)
            throws BillPayeeNotFoundException {
        BillPayee bp = billPayeeRepository.findById(id).orElseThrow(() ->new BillPayeeNotFoundException(id));
        bp.setAccountId(billPayee.getAccountId());
        bp.setPayeeAccountNo(billPayee.getPayeeAccountNo());
        bp.setPayeePhone(billPayee.getPayeePhone());
        bp.setPayeeAddress(billPayee.getPayeeAddress());
        BillPayee updUser = billPayeeRepository.save(bp);
        return updUser;
    }

    @DeleteMapping("/billPayee/{id}")
    public ResponseEntity<?> deleteUserAccount(@PathVariable ("id") Integer id) throws BillPayeeNotFoundException {
        BillPayee bp1=billPayeeRepository.findById(id).orElseThrow(()->new BillPayeeNotFoundException(id));
        billPayeeRepository.delete(bp1);
        return ResponseEntity.ok().build();
    }
}
