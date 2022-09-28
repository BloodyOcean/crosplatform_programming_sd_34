import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstManager implements IManager{
    private Map<String, List<Film>> dictionary;


    public FirstManager(Map<String, List<Film>> dictionary) {

        this.dictionary = dictionary;
    }

    public FirstManager() {
        this.dictionary = new HashMap<>();
    }

    @Override
    public void readFromFile(String path) {

        var res = ObjectReader.read(path);

        for (var item : res)
        {
            var old_lst = this.dictionary.get(item.getDirector());

            if (old_lst == null)
            {
                old_lst = new ArrayList<Film>();
                old_lst.add(item);
                this.dictionary.put(item.getDirector(), old_lst);
            }
            else
            {
                old_lst.add(item);
            }

            this.dictionary.put(item.getDirector(), old_lst);
        }
    }

    @Override
    public void print() {
        System.out.println(this.dictionary);
    }
}
