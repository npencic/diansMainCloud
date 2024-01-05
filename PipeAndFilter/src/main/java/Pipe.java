import java.util.ArrayList;
import java.util.List;

public class Pipe <T extends List<?>>{

    private List<Filter> filters=new ArrayList<Filter>();
    public void addFilter(Filter<T> filter)
    {
        filters.add(filter);
    }
    public T runFilters(T input){
        for(Filter<T> filter:filters){
            input = filter.execute(input);
        }
        return input;
    }
}