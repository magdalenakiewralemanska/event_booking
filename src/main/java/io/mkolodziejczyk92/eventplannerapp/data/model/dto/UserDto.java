package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.UserEvent;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Customer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Organizer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.user.User;
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
    private String companyName;
    private String regon;
    private List<UserEvent> userEvents;
    private List<Offer> offers;

    public UserDto(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setEmail(user.getEmail());
        this.setPhoneNumber(user.getPhoneNumber());
    }

    public UserDto(Organizer organizer) {
        this((User) organizer);
        this.setCompanyName(organizer.getCompanyName());
        this.setRegon(organizer.getRegon());
    }

    public UserDto(Customer customer) {
        this((User) customer);
        this.setFirstName(customer.getFirstName());
        this.setLastName(customer.getLastName());
    }

}
