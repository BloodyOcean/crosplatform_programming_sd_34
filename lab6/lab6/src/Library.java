import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library implements ILibrary{
    private List<Book> books;
    private List<Abonement> abonements;
    private Map<Abonement, List<UserStory>> map;

    public void removeBook(Book book)
    {
        this.books.remove(book);
    }

    public Library(List<Book> books, List<Abonement> abonements) {
        this.books = books;
        this.abonements = abonements;
        this.map = new HashMap<>();
    }

    public List<Abonement> getAbonements() {
        return abonements;
    }

    public void setAbonements(List<Abonement> abonements) {
        this.abonements = abonements;
    }

    public Map<Abonement, List<UserStory>> getMap() {
        return map;
    }

    public void setMap(Map<Abonement, List<UserStory>> map) {
        this.map = map;
    }

    public void assignBook(Abonement abonement, Book book, Date plannedReturnDate) {
        if (this.abonements.contains(abonement) && this.books.contains(book)) {
            var userStory = new UserStory(abonement, book, plannedReturnDate);
            var lst = this.map.get(abonement);
            if (lst == null) {
                lst = new ArrayList<>();
            }
            lst.add(userStory);
            this.map.put(abonement, lst);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean existBook(Book book) {
        return this.books.contains(book);
    }

    public void addBook(Book book) {
        if (!this.books.contains(book))
        {
            this.books.add(book);
        }
    }

    @Override
    public void sortBooks() {
        this.books = this.books.stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
    }

    @Override
    public List<String> getAddressesForTwoBooks() {

        return this.map
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 2)
                .map(p -> p.getKey().getEmail())
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumTakenBooks(String author) {
        var res = this.map
                .entrySet()
                .stream()
                .filter(e -> e.getValue().stream().anyMatch(p -> p.getBook().getAuthor().equals(author)))
                .toList();

        return res.size();
    }

    @Override
    public void sendNotifications() {
        var res = this.map
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 2)
                .map(Map.Entry::getKey).toList();

        for (var item : this.abonements)
        {
            if (res.contains(item)) {
                System.out.println(item.getFullName() + "! " + "Please, return your books on time!");
            } else {
                System.out.println(item.getFullName() + "! " + "We have lots of new books! Please, come here!");
            }
        }
    }

    @Override
    public int findBigNumOfBooks() {
        var res = this.map.entrySet()
                .stream()
                .map(p -> p.getValue().size())
                .sorted((a, b) -> Integer.compare(b, a))
                .findFirst();

        if (res.isEmpty()) {
            return 0;
        }
        else {
            return res.get();
        }
    }

    @Override
    public void printBooks() {
        System.out.println(this.books);
    }

    @Override
    public List<Debtor> getDebtors(Date expirationDate) {
        var res = this.map
                .entrySet()
                .stream()
                .filter(p -> p.getValue().stream().anyMatch(l -> l.getPlannedReturnDate().before(expirationDate) && l.getRealReturnDate() == null))
                .map(i -> new Debtor(i.getKey(),
                        expirationDate.getTime() - i.getValue().stream().filter(l -> l.getPlannedReturnDate().before(expirationDate) && l.getRealReturnDate() == null).collect(Collectors.toList()).get(0).getPlannedReturnDate().getTime()))
                .toList();

        return res;
    }
}
