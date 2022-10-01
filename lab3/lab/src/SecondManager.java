import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondManager implements IManager{
    private Map<Integer, List<Film>> dictionary;

    public SecondManager() {
        this.dictionary = new HashMap<>();
    }

    public SecondManager(Map<Integer, List<Film>> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void readFromFile(String path) {

        var res = ObjectReader.read(path);

        for (var item : res)
        {
            this.addFilm(item);
        }

    }

    @Override
    public void addFilm(Film item) {
        var old_lst = this.dictionary.get(item.getYear());

        if (old_lst == null)
        {
            old_lst = new ArrayList<Film>();
            old_lst.add(item);
            this.dictionary.put(item.getYear(), old_lst);
        }
        else
        {
            old_lst.add(item);
        }

        this.dictionary.put(item.getYear(), old_lst);
    }

    @Override
    public void remove(Object key) {
        this.dictionary.remove(key);
    }

    @Override
    public void print() {
        System.out.println(this.dictionary);
    }
}
