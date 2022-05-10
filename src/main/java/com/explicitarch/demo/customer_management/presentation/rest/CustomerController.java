package com.explicitarch.demo.customer_management.presentation.rest;

import com.explicitarch.demo.customer_management.application_core.application.DeleteCustomer;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;
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

    @DeleteMapping(value= "/{customerId}")
    public ResponseEntity<Object> delete(@PathVariable Integer customerId){
        try {
            System.out.println("INTO Cobtrooler");

            this.deleteCustomer.deleteCustomer(new CustomerId(customerId));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok().build();
    }

}
