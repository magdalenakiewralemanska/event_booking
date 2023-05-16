package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.UserEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "organizers")
public class Organizer extends User {

    @Column(name = "company_name")
    private String companyName;

    private String regon;

    @OneToMany(mappedBy = "organizer")
    private List<UserEvent> userEvents;

    @OneToMany(mappedBy = "organizer")
    private List<Offer> offers;

}
