package web.model;

public class User {
    private int id;
    private String name;
    private String surname;
    private String country;
    private int age;

    public User() {
    }

    public User(int id, String name, String surname, String country, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
