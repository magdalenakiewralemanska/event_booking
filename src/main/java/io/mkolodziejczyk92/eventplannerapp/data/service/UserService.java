package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserDto userDto) throws UserNotFoundException, UsernameExistException, EmailExistException;
    UserDto findUserByUsername(String username);
    void updateUser(Long id, UserDto userDto )
            throws UserNotFoundException, EmailExistException, UsernameExistException;

    void deleteUser(Long id);
    void updateUserPassword(UserDto userDto );

}
