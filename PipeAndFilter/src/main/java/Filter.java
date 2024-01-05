import java.util.List;

public interface Filter <T>{

    T execute(List<?> input);

}
