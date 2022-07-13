package factory.phone.phone.web.service;

import factory.phone.phone.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
}
