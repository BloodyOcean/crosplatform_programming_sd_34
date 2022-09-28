import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;
    private String title;
    private int year;
    private String director;
    private List<String> producers;

    public Film(String title, int year, String director, List<String> producers) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.producers = producers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    @Override
    public String toString() {
        return this.director + " " + this.title + " " + this.year + " " + this.producers;
    }
}
