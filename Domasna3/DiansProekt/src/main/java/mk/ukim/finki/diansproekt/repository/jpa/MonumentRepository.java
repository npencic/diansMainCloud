package mk.ukim.finki.diansproekt.repository.jpa;

import mk.ukim.finki.diansproekt.model.Monument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonumentRepository extends JpaRepository<Monument,Long> {
    List<Monument> findByName(String name);
    List<Monument> findByCity(String city);
    List<Monument> findByNameOrType(String name, String type);
    List<Monument> findByCityOrType(String city,String type);

}
