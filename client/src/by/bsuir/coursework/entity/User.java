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

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
