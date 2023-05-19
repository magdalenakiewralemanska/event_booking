package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Customer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Organizer;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
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
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UsernameAndEmailValidator validator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository repository, UsernameAndEmailValidator validator, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.validator = validator;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Customer registerNewCustomer(UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
        validator.checkThatNewUsernameAndEmailNotRepeat(StringUtils.EMPTY, userDto.getUsername(), userDto.getPassword());
        Customer customer = new Customer(userDto, bCryptPasswordEncoder.encode(userDto.getPassword()), getRolesForCustomer());
        return repository.save(customer);
    }

    @Override
    public Organizer registerNewOrganizer(UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
        validator.checkThatNewUsernameAndEmailNotRepeat(StringUtils.EMPTY, userDto.getUsername(), userDto.getPassword());
        Organizer organizer = new Organizer(userDto, bCryptPasswordEncoder.encode(userDto.getPassword()), getRolesForOrganizer());
        return repository.save(organizer);
    }

    @Override
    public List<Role> getRolesForCustomer() {
        return List.of(Role.CUSTOMER);
    }

    @Override
    public List<Role> getRolesForOrganizer() {
        return List.of(Role.ORGANIZER);
    }
}
