package mk.ukim.finki.diansproekt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Monuments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Monument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "longitude")
    private int longitude;
    @Column(name = "latitude")
    private int latitude;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private String type;
    @Column(name = "opening_hours")
    private String openingHours;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Long phone;
}
