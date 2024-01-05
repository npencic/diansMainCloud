package mk.ukim.finki.diansproekt.bootstrap;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import lombok.Getter;
import mk.ukim.finki.diansproekt.model.Monument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Getter
@Component
public class DataHolder {

    public static List<Monument> monumentList = new ArrayList<Monument>();
    @PostConstruct
    public void init() throws ServletException {
        monumentList.add(new Monument(1L,"Меморијален центар АСНОМ", "North Macedonia", "Пелинце", 21,42, "Memorial Center ASNOM, R1207, Pelince, North Macedonia", "museum", "always open", "email",38972213249L));
        monumentList.add(new Monument(2L,"Кокино", "North Macedonia", "Кокино", 21,42, "Кокино, R2244, Kokino, North Macedonia", "archaeological_site", "always open", "email",38974440645L));
        monumentList.add(new Monument(3L,"Св. Великомаченик Георгиј", "North Macedonia", "Staro Nagorichane", 21,42, "Church of St. George, R1207, Staro Nagorichane, North Macedonia", "church", "Mon-Sunday 07:00-19:00", "email",38974370927L));
        monumentList.add(new Monument(4L,"Манастир Св. Богородица", "North Macedonia", "Pobozhje", 21,42, "St. Holy Mother of God Monastery, R2239, Pobozhje, North Macedonia", "church", "Mon-Fri 08:00-16:00", "email",38979882985L));
        monumentList.add(new Monument(5L,"Костоперска Карпа", "North Macedonia", "Mlado Nagorichane", 21,42, "Костоперска Карпа, A2, Mlado Nagorichane, North Macedonia", "archaeological_site", "always open", "email",38979405111L));
        monumentList.add(new Monument(6L,"Симиќева кула", "North Macedonia", "Кратово", 21,42, "Simikj Tower, Трајче Арсов, Kratovo, North Macedonia", "monument", "always open", "email",38977734634L));
        monumentList.add(new Monument(7L,"Споменик Костурница", "North Macedonia", "Куманово", 21,42, "Споменик Костурница, Средорек, 1300 Kumanovo, North Macedonia", "monument", "always open", "email",38973463626L));
        monumentList.add(new Monument(8L,"Јосип Броз - Тито", "North Macedonia", "Куманово", 21,42, "Јосип Броз - Тито, Иво Лола Рибар, 1300 Kumanovo, North Macedonia", "monument", "always open", "email",38975468954L));

    }
}
