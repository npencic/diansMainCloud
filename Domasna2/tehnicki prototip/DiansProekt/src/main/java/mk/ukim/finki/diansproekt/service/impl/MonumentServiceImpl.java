package mk.ukim.finki.diansproekt.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.diansproekt.model.Monument;
import mk.ukim.finki.diansproekt.repository.MonumentRepository;
import mk.ukim.finki.diansproekt.service.MonumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MonumentServiceImpl implements MonumentService {

    private final MonumentRepository monumentRepository;

    @Override
    public List<Monument> findAll() {
        return this.monumentRepository.findAll();
    }

    @Override
    public Optional<Monument> findById(Long id) {
        return this.monumentRepository.findById(id);
    }


    @Override
    public List<Monument> searchByName(String name,String type){
        return monumentRepository.searchByName(name,type);
    }

    @Override
    public List<Monument> searchByCity(String city,String type){
        return monumentRepository.searchByCity(city,type);
    }
}
