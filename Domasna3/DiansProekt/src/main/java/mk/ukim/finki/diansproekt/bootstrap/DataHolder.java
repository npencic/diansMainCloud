package mk.ukim.finki.diansproekt.bootstrap;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import lombok.Getter;
import mk.ukim.finki.diansproekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Component
public class DataHolder {




//    public static List<Monument> monumentList = new ArrayList<Monument>();
 public static List<User> users = new ArrayList<>();



    @PostConstruct
    public void init() throws SQLException {


        users.add(new User("loren12358","123","Loren","Boshko"));
        users.add(new User("maca","123","Marija","Zografska"));

    }
}
