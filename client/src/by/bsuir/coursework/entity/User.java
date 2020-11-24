package by.bsuir.coursework.entity;

public final class User {
    private String surname;
    private String name;
    private String login;
    private String tel;
    private String email;
    private String password;
    private String repass;
    private Role role;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(String surname, String name, String login, String tel, String email, String password, String repass) {
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.repass = repass;
    }

    public User(String surname, String name, String login, String tel, String email, String password, Role role){
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return surname + ' ' + name + ' ' + login + ' ' + tel + ' ' + email + ' ' + password + ' ' + role;
    }
}
