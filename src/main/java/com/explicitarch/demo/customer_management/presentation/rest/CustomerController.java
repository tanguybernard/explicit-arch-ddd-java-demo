package com.explicitarch.demo.customer_management.presentation.rest;

import com.explicitarch.demo.customer_management.application_core.application.DeleteCustomer;
import com.explicitarch.demo.shared_kernel.CustomerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private DeleteCustomer deleteCustomer;

    @Autowired
    public void setInjectedBean(DeleteCustomer deleteCustomer) {
        this.deleteCustomer = deleteCustomer;
    }

    @GetMapping(value= "/{customerId}")
    public ResponseEntity<Object> delete(@PathVariable Integer customerId){
        this.deleteCustomer.deleteCustomer(new CustomerId(customerId));
        return ResponseEntity.ok().build();
    }

}
