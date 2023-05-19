package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Customer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Organizer;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    Customer registerNewCustomer(UserDto userDto) throws UserNotFoundException, UsernameExistException, EmailExistException;
    Organizer registerNewOrganizer(UserDto userDto) throws UserNotFoundException, UsernameExistException, EmailExistException;
    List<Role> getRolesForCustomer();
    List<Role> getRolesForOrganizer();
}
