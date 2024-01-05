package mk.ukim.finki.diansproekt.service;

import mk.ukim.finki.diansproekt.model.Monument;

import java.util.List;
import java.util.Optional;

public interface MonumentService {

    List<Monument> findAll();

    Optional <Monument> findById(Long id);

    List<Monument> searchByName(String name,String type);
    List<Monument> searchByCity(String city,String type);

    List<Monument> searchCityWithoutType(String city);

    List<Monument> searchNameWithoutType(String name);
}
