package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.constant.UserServicesConstant;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.enums.AddressType;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import io.mkolodziejczyk92.eventplannerapp.data.exception.*;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.UserMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import io.mkolodziejczyk92.eventplannerapp.data.service.UserService;
import io.mkolodziejczyk92.eventplannerapp.data.validation.UsernameAndEmailValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final AddressService addressService;
    private final UsernameAndEmailValidator validator;
    private final BCryptPasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository repository, AddressService addressService, UsernameAndEmailValidator validator,
                           BCryptPasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.repository = repository;
        this.addressService = addressService;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(UserDto userDto) throws UserNotFoundException, EmailExistException, UsernameExistException {
        validator.checkThatNewUsernameAndEmailNotRepeat(StringUtils.EMPTY, userDto.getUsername(), userDto.getPassword());
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.USER.getValue());
        user.setBackgroundPicturePath(userDto.getBackgroundPicturePath());
        user.setProfilePicturePath(userDto.getProfilePicturePath());
        AddressDto addressDto = userDto.getAddress();
        if(addressDto != null) {
            Address address = addressService.saveAddress(addressDto);
            address.setAddressType(AddressType.RESIDENCE);
            address.setUser(user);
            user.setAddress(address);
        }
        user.setOrders(userDto.getOrders());
        repository.save(user);
    }

    public UserDto findUserByUsername(String username){
        User currentUser = repository.findUserByUsername(username);
        return userMapper.mapToUserDto(currentUser);
    }

    @Override
    public void updateUser(Long id, UserDto userDto )
             {

        User currentUser = repository.findUserByUsername(userDto.getUsername());
        currentUser.setFirstName(userDto.getFirstName());
        currentUser.setLastName(userDto.getLastName());
        currentUser.setUsername(userDto.getUsername());
        currentUser.setEmail(userDto.getEmail());
        currentUser.setPhoneNumber(userDto.getPhoneNumber());
        currentUser.setBackgroundPicturePath(userDto.getBackgroundPicturePath());
        currentUser.setProfilePicturePath(userDto.getProfilePicturePath());
        AddressDto addressDto = userDto.getAddress();
        addressService.updateAddress(addressDto);
        repository.save(currentUser);
    }

    public void deleteUser(Long id) {

            Optional<User> optionalUser = repository.findById(id);
            if (optionalUser.isPresent()) {
                UserDto user = userMapper.mapToUserDto(optionalUser.get());
                repository.deleteById(id);

                Optional<AddressDto> optionalAddress = Optional.ofNullable(user.getAddress());
                optionalAddress.ifPresent(address -> addressService.deleteAddress(address.getId()));
            } else {

                throw new EntityNotFoundException("Entity id: " + id + " not found");
            }
        }

    @Override
    public void updateUserPassword(UserDto userDto )
    {
        User currentUser = repository.findUserByUsername(userDto.getUsername());
        String currentPassword = userDto.getCurrentPassword();
        String newPassword = userDto.getNewPassword();

        if (!passwordEncoder.matches(currentPassword, currentUser.getPassword())) {
        throw new InvalidPasswordException(UserServicesConstant.CURRENT_PASSWORD_NOT_MATCH);
    }

        if (currentPassword.equals(newPassword)) {
            throw new RepeatedPasswordException(UserServicesConstant.NOT_A_NEW_PASSWORD);
        }
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        currentUser.setPassword(encodedNewPassword);

        repository.save(currentUser);
    }
}
