import java.io.Serializable;
import java.util.Date;

public class UserStory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Abonement abonement;
    private Book book;
    private Date receiveDate;
    private Date plannedReturnDate;
    private Date realReturnDate;

    public UserStory(Abonement abonement, Book book, Date plannedReturnDate) {
        this.abonement = abonement;
        this.book = book;
        this.plannedReturnDate = plannedReturnDate;
    }

    public UserStory(Abonement abonement, Book book, Date receiveDate, Date plannedReturnDate) {
        this.abonement = abonement;
        this.book = book;
        this.receiveDate = receiveDate;
        this.plannedReturnDate = plannedReturnDate;
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "abonement=" + abonement +
                ", book=" + book +
                ", receiveDate=" + receiveDate +
                ", plannedReturnDate=" + plannedReturnDate +
                ", realReturnDate=" + realReturnDate +
                '}';
    }

    public Abonement getAbonement() {
        return abonement;
    }

    public void setAbonement(Abonement abonement) {
        this.abonement = abonement;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getPlannedReturnDate() {
        return plannedReturnDate;
    }

    public void setPlannedReturnDate(Date plannedReturnDate) {
        this.plannedReturnDate = plannedReturnDate;
    }

    public Date getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(Date realReturnDate) {
        this.realReturnDate = realReturnDate;
    }
}
