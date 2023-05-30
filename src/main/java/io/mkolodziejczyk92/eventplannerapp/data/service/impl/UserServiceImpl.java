package io.mkolodziejczyk92.eventplannerapp.data.service.impl;


import io.mkolodziejczyk92.eventplannerapp.data.entity.Customer;
import io.mkolodziejczyk92.eventplannerapp.data.enums.ERole;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.UserService;
import io.mkolodziejczyk92.eventplannerapp.data.validation.UsernameAndEmailValidator;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl {
    private final UserRepository repository;
    private final UsernameAndEmailValidator validator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository repository, UsernameAndEmailValidator validator, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.validator = validator;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @Override
//    public Customer registerNewCustomer(UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
//        validator.checkThatNewUsernameAndEmailNotRepeat(StringUtils.EMPTY, userDto.getUsername(), userDto.getPassword());
//        Customer customer = new Customer(userDto, bCryptPasswordEncoder.encode(userDto.getPassword()), getRolesForCustomer());
//        return repository.save(customer);
//    }


//    @Override
//    public List<ERole> getRolesForCustomer() {
//        return List.of(ERole.CUSTOMER);
//    }


}
