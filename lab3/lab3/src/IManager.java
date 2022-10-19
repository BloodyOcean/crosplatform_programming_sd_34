public interface IManager {
    void readFromFile(String path);

    void addFilm(Film f);

    void remove(Object key);

    void print();
}
