package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.entity.AbstractEntity;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String username;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Address> allAddresses;

}
