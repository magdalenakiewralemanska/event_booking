package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.UserEvent;
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
@DiscriminatorValue("Customer")
public class Customer extends User {

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<UserEvent> userEvents;

    public Customer(UserDto userDto, String encryptedPassword, List<Role> roles) {
        super(userDto, encryptedPassword, roles);
        this.setFirstName(userDto.getFirstName());
        this.setLastName(userDto.getLastName());
    }
}
