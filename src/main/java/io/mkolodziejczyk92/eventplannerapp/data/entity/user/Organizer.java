package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.UserDto;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.UserEvent;
import io.mkolodziejczyk92.eventplannerapp.data.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@DiscriminatorValue("Organizer")
public class Organizer extends User {

    @Column(name = "company_name")
    private String companyName;

    private String regon;

    @OneToMany(mappedBy = "organizer")
    private List<UserEvent> userEvents;

    @OneToMany(mappedBy = "organizer")
    private List<Offer> offers;

    public Organizer(UserDto userDto, String encryptedPassword, List<Role> roles) {
        super(userDto, encryptedPassword, roles);
        this.setCompanyName(userDto.getCompanyName());
        this.setRegon(userDto.getRegon());
    }

}
