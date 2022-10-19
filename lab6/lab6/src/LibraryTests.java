import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTests {
    Library library;

    @BeforeEach
    void setUp() {
        var lst = new ArrayList<Book>();
        lst.add(new Book("E. Kovalenko", 1984, "A wonderful story"));
        lst.add(new Book("E. Kovalenko", 2001, "Y wonderful story"));
        lst.add(new Book("C. Prikol", 2004, "B wonderful story"));
        lst.add(new Book("D. Vasya", 1856, "Z wonderful story"));
        lst.add(new Book("J Rowling", 1990, "Harry Potter"));

        var users =  new ArrayList<Abonement>();
        users.add(new Abonement("Eduard Kovalenko", "asds@gmail.com"));
        users.add(new Abonement("Vasil Prikol", "44vva123sds@gmail.com"));
        users.add(new Abonement("Mikola Shaxnenko", "11vvasds@gmail.com"));
        users.add(new Abonement("Ivan Petrenko", "asdasdhhh22@ukr.net"));
        users.add(new Abonement("Taras Boiko", "66hhasds@mail.ua"));
        users.add(new Abonement("Taras Mukha", "tmukha@gmail.com"));

        library = new Library(lst, users);

        library.assignBook(library.getAbonements().get(4), library.getBooks().get(0), new Date(2023, 05, 24));
        library.assignBook(library.getAbonements().get(0), library.getBooks().get(1), new Date(2022, 05, 24));
        library.assignBook(library.getAbonements().get(0), library.getBooks().get(2), new Date(2021, 05, 24));

        library.assignBook(library.getAbonements().get(1), library.getBooks().get(0), new Date(2020, 05, 24));
        library.assignBook(library.getAbonements().get(3), library.getBooks().get(1), new Date(2024, 05, 24));
        library.assignBook(library.getAbonements().get(1), library.getBooks().get(2), new Date(2022, 05, 24));

        library.assignBook(library.getAbonements().get(2), library.getBooks().get(3), new Date(2023, 05, 24));
        library.assignBook(library.getAbonements().get(1), library.getBooks().get(4), new Date(2022, 05, 24));
        library.assignBook(library.getAbonements().get(0), library.getBooks().get(0), new Date(2021, 05, 24));

        library.assignBook(library.getAbonements().get(5), library.getBooks().get(3), new Date(2020, 05, 24));
        library.assignBook(library.getAbonements().get(5), library.getBooks().get(4), new Date(2024, 05, 24));
        library.assignBook(library.getAbonements().get(5), library.getBooks().get(0), new Date(2022, 05, 24));
        library.assignBook(library.getAbonements().get(5), library.getBooks().get(4), new Date(2022, 05, 24));
    }

    @Test
    @DisplayName("Should return proper num of users taken corresponding author books")
    void calcNumbOfBooksAuthor() {
        var res = library.getNumTakenBooks("E. Kovalenko");
        assertTrue(res == 5);
    }

    @Test
    @DisplayName("Should return debtors list by corresponding date")
    void getDebtorsByDate() {
        var res = library.getDebtors(new Date(2022, 06, 26));
        System.out.println(res);
        assertTrue(res.size() == 3);
    }

    @Test
    @DisplayName("Should print list of books")
    void printBooks() {
        this.library.printBooks();
    }

    @Test
    @DisplayName("Should show notifications to abonements")
    void sendNotifications() {
        library.sendNotifications();
    }

    @Test
    @DisplayName("Should return the max taken number of books")
    void getBiggestNumberTaken() {
        var res = library.findBigNumOfBooks();
        assertTrue(res == 4);
    }


    @Test
    @DisplayName("Should return list of emails of people who took more than 2 books")
    void getListOfEmails() {
        var res = library.getAddressesForTwoBooks();
        assertTrue(res.size() == 3);
    }

    @Test
    @DisplayName("Should sort books in ascending order")
    void sortBooks() {
        var lst = new ArrayList<Book>();
        lst.add(new Book("E. Kovalenko", 1984, "A wonderful story"));
        lst.add(new Book("E. Kovalenko", 2001, "Y wonderful story"));
        lst.add(new Book("C. Prikol", 2004, "B wonderful story"));
        lst.add(new Book("D. Vasya", 1856, "Z wonderful story"));
        lst.add(new Book("J Rowling", 1990, "Harry Potter"));

        library.sortBooks();
        assertTrue(library.getBooks().size() == lst.size() && library.getBooks().containsAll(lst) && lst.containsAll(library.getBooks()));
    }
}
