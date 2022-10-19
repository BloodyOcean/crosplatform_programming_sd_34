public class Abonement {
    private String fullName;
    private String email;

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Abonement(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
