package com.explicitarch.demo.customer_management.domain;

import com.explicitarch.demo.shared_kernel.CustomerId;

public record Customer(CustomerId id, CustomerName name) {
}
