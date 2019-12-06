public class User {

    private long userId;
    private String firstName;
    private String lastName;

    public User(long userId, String firstName, String lastName) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {

        return userId;
    }

    public void setId(long userId) {

        this.userId = userId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    @Override
   public String toString() {

        return userId + ": " + firstName + " - " + lastName;
    }
}
