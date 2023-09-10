package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{

    private final BCryptPasswordEncoder passwordEncoder;
    private final AddressMapperImpl addressMapper;

    public UserMapperImpl(BCryptPasswordEncoder passwordEncoder, AddressMapperImpl addressMapper) {
        this.passwordEncoder = passwordEncoder;
        this.addressMapper = addressMapper;
    }

    @Override
    public UserDto mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }
        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName(user.getLastName());
        userDto.setEmail( user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRole(Role.valueOf(user.getRole()));
        userDto.setBackgroundPicturePath(user.getBackgroundPicturePath());
        userDto.setAddress( addressMapper.mapToAddressDto(user.getAddress()) );
        userDto.setProfilePicturePath(user.getProfilePicturePath());
        return userDto;
    }

    @Override
    public User mapToUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(addressMapper.mapToAddress(userDto.getAddress()));
        user.setBackgroundPicturePath(userDto.getBackgroundPicturePath());
        user.setProfilePicturePath(userDto.getProfilePicturePath());

        return user;
    }
}
