package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.AbstractEntity;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue(value = "User")
public class User extends AbstractEntity {

    private String username;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    public User(UserDto userDto, String encryptedPassword, List<Role> roles) {
        this.setUsername(userDto.getUsername());
        this.setEmail(userDto.getEmail());
        this.setPhoneNumber(userDto.getPhoneNumber());
        this.password = encryptedPassword;
        this.roles = roles;
    }
}
