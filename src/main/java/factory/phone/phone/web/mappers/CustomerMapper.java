package factory.phone.phone.web.mappers;

import factory.phone.phone.domain.Customer;
import factory.phone.phone.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);
}
