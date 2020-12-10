package by.bsuir.coursework.database;

public class Solvency {
    private int idsolvency;
    private int users_id;
    private double cash;

    public Solvency(int idsolvency, int users_id, double cash) {
        this.idsolvency = idsolvency;
        this.users_id = users_id;
        this.cash = cash;
    }

    public Solvency(int users_id, double cash) {
        this.users_id = users_id;
        this.cash = cash;
    }

    public int getIdsolvency() {
        return idsolvency;
    }

    public void setIdsolvency(int idsolvency) {
        this.idsolvency = idsolvency;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
