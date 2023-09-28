package user;

public class User {
    private String name;
    private String surname;
    private int birthYear;

    User(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return name;
    }

    public void setSurname(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge() {
        return 2023 - birthYear;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + getAge() + " г.";
    }

    public static void main(String[] args) {

        User us1 = new User("Адам", "Дженсен", 1990);
        System.out.println(us1);
        System.out.println(us1.toString());
        System.out.println(us1.hashCode());
    }
}


