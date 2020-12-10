package by.bsuir.coursework.collections;

import by.bsuir.coursework.connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class CollectionTicket {
    private ObservableList<TicketInf> tickets = FXCollections.observableArrayList();

    private static CollectionTicket instance;

    public static synchronized CollectionTicket getInstance(){
        if(instance == null){
            instance = new CollectionTicket();
        }
        return instance;
    }

    public ObservableList<TicketInf> getTickets() {
        return tickets;
    }

    public void fillData(){
        try {
            tickets.removeAll(tickets);
            String array = Connect.get();
            System.out.println(array);
            JSONArray newArray = null;
            if (array != null) {
                newArray = new JSONArray(array);
                int count = newArray.length();
                for(int i = 0; i<count; i++) {
                    JSONObject object = newArray.getJSONObject( i );
                    Integer idticket = object.getInt("idticket");
                    Integer schedule_idschedule = object.getInt( "schedule_idschedule" );
                    Integer rowNumber = object.getInt("rowNumber");
                    Integer placeNumber = object.getInt("placeNumber");

                    TicketInf ticket = new TicketInf(idticket, schedule_idschedule, rowNumber, placeNumber);
                    tickets.add(ticket);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
