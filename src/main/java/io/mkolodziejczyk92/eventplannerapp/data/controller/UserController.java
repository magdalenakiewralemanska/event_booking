package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.constant.UserServicesConstant;
import io.mkolodziejczyk92.eventplannerapp.data.exception.*;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController extends ExceptionHandle {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        try {
            userService.registerUser(userDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (EmailExistException e) {
            return ResponseEntity.badRequest().body(UserServicesConstant.EMAIL_ALREADY_EXISTS);
        } catch (UsernameExistException e) {
            return ResponseEntity.badRequest().body(UserServicesConstant.USERNAME_ALREADY_EXISTS);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(UserServicesConstant.NO_USER_FOUND_BY_USERNAME + userDto.getUsername());
        }
    }

    @GetMapping("/details/{username}")
    public UserDto getUserByUsername(@PathVariable("username") String username){
        return userService.findUserByUsername(username);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto) throws UserNotFoundException, EmailExistException,
            UsernameExistException {
        userService.updateUser( id, userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody UserDto userDto) {
        try {
            userService.updateUserPassword(userDto);
            return ResponseEntity.ok("Password changed successfully");
        } catch (InvalidPasswordException e) {
            return ResponseEntity.badRequest().body(UserServicesConstant.CURRENT_PASSWORD_NOT_MATCH);
        } catch (RepeatedPasswordException e){
            return ResponseEntity.badRequest().body(UserServicesConstant.NOT_A_NEW_PASSWORD);
        }
    }

}
