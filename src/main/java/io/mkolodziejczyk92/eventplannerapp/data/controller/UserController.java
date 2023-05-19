package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Customer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Organizer;
import io.mkolodziejczyk92.eventplannerapp.data.exception.EmailExistException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.ExceptionHandle;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UserNotFoundException;
import io.mkolodziejczyk92.eventplannerapp.data.exception.UsernameExistException;
import io.mkolodziejczyk92.eventplannerapp.data.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController extends ExceptionHandle {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerCustomer")
    public ResponseEntity<Customer> saveNewUserCustomer(@RequestBody UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
        Customer customer = userService.registerNewCustomer(userDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/registerOrganizer")
    public ResponseEntity<Organizer> saveNewUserOrganizer(@RequestBody UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
        Organizer organizer = userService.registerNewOrganizer(userDto);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }
}
