package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Customer;
import io.mkolodziejczyk92.eventplannerapp.data.enums.ERole;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    Customer registerNewCustomer(UserDto userDto) throws UserNotFoundException, UsernameExistException, EmailExistException;

    List<ERole> getRolesForCustomer();

    List<ERole> getRolesForOrganizer();
}
