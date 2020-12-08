package by.bsuir.coursework.database;

public class Order {
    private int idorder;
    private int users_id;
    private int ticket_idticket;
    private String paid;
    private String bron;

    public Order(int idorder, int users_id, int ticket_idticket, String paid, String bron) {
        this.idorder = idorder;
        this.users_id = users_id;
        this.ticket_idticket = ticket_idticket;
        this.paid = paid;
        this.bron = bron;
    }

    public Order(int users_id, int ticket_idticket, String paid, String bron) {
        this.users_id = users_id;
        this.ticket_idticket = ticket_idticket;
        this.paid = paid;
        this.bron = bron;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getTicket_idticket() {
        return ticket_idticket;
    }

    public void setTicket_idticket(int ticket_idticket) {
        this.ticket_idticket = ticket_idticket;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getBron() {
        return bron;
    }

    public void setBron(String bron) {
        this.bron = bron;
    }
}
