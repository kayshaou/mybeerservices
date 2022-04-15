package com.anocha.learn.mapper;

import com.anocha.learn.domain.Customer;
import com.anocha.learn.model.CustomerDto;

//@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
