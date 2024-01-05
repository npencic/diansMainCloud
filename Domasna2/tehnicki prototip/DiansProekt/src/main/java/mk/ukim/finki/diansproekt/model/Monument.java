package mk.ukim.finki.diansproekt.model;

import lombok.Data;

import java.util.List;

@Data
public class Monument {
    private Long id;
    private String name;
    private String Country;
    private String City;
    private int Longitude;
    private int Latitude;
    private String Address;
    private String Type;
    private String OpeningHours;
    private String Email;
    private Long Phone;

    public Monument(Long id,String name, String country, String city, int longitude, int latitude, String address, String type, String openingHours, String email, Long phone) {
        this.id = id;
        this.name = name;
        Country = country;
        City = city;
        Longitude = longitude;
        Latitude = latitude;
        Address = address;
        Type = type;
        OpeningHours = openingHours;
        Email = email;
        Phone = phone;
    }


}
