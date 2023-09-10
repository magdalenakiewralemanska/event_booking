package io.mkolodziejczyk92.eventplannerapp.data.entity;

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
@Table(name = "event")
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "picture_path", columnDefinition = "LONGBLOB")
    private String picturePath;

    @OneToMany(mappedBy = "event")
    private List<Offer> offers;


}
