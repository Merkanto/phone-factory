package factory.phone.phone.web.service;

import factory.phone.phone.web.model.CustomerDto;
import factory.phone.phone.web.model.PhoneDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);
}
