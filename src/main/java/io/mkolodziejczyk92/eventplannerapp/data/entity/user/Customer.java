package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.entity.UserEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "customers")
public class Customer extends User {

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<UserEvent> userEvents;
}
