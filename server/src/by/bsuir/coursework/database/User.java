package by.bsuir.coursework.database;

public class User {
    private int id;
    private String surname;
    private String name;
    private String login;
    private String tel;
    private String email;
    private String password;
    private String role;

    public User(int id, String surname, String name, String login, String tel, String email, String password, String role) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
