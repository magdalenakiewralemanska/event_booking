package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Order;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
    private AddressDto address;
    private List<Order> orders;
    private String backgroundPicturePath;
    private String profilePicturePath;
    private String currentPassword;
    private String newPassword;

}
