import java.util.Date;
import java.util.List;

public interface ILibrary {
    void sortBooks();
    void assignBook(Abonement abonement, Book book, Date plannedReturnDate);
    List<String> getAddressesForTwoBooks();
    Integer getNumTakenBooks(String author);
    void sendNotifications();
    int findBigNumOfBooks();
    void printBooks();
    List<Debtor> getDebtors(Date expirationDate);
}
