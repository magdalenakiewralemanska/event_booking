package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.User;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;

public interface UserMapper {

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
