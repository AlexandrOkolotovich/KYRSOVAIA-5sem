package by.bsuir.coursework.collections;

public class TicketInf {
    private int idticket;
    private int schedule_idschedule;
    private int rowNumber;
    private int placeNumber;

    public TicketInf(int idticket, int schedule_idschedule, int rowNumber, int placeNumber) {
        this.idticket = idticket;
        this.schedule_idschedule = schedule_idschedule;
        this.rowNumber = rowNumber;
        this.placeNumber = placeNumber;
    }

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public int getSchedule_idschedule() {
        return schedule_idschedule;
    }

    public void setSchedule_idschedule(int schedule_idschedule) {
        this.schedule_idschedule = schedule_idschedule;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }
}
