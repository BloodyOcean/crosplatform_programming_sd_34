import java.io.Serializable;

public class Debtor implements Serializable {
    private static final long serialVersionUID = 1L;
    private Abonement abonement;
    private long days;

    public Debtor(Abonement abonement, long days) {
        this.abonement = abonement;
        this.days = days;
    }

    @Override
    public String toString() {
        return "Debtor{" +
                "abonement=" + abonement +
                ", days=" + days +
                '}';
    }

    public Abonement getAbonement() {
        return abonement;
    }

    public void setAbonement(Abonement abonement) {
        this.abonement = abonement;
    }

    public long getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
