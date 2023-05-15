package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "client")
public class Client extends AbstractEntity {


    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nip;

    @OneToMany(mappedBy = "client")
    private Set<Address> allAddresses;

}
