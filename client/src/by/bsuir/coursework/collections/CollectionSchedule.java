package by.bsuir.coursework.collections;

import by.bsuir.coursework.connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Time;

public final class CollectionSchedule {
    private ObservableList<ScheduleInf> schedules = FXCollections.observableArrayList();

    private static CollectionSchedule instance;

    public static synchronized CollectionSchedule getInstance(){
        if(instance == null){
            instance = new CollectionSchedule();
        }
        return instance;
    }

    public ObservableList<ScheduleInf> getSchedules() {
        return schedules;
    }

    public void fillNewData(){
        String id = Connect.get();
        Integer idschedule = Integer.valueOf(id);
        String movieDate = Connect.get();
        Date sessionDate = Date.valueOf(movieDate);
        String movieTime = Connect.get();
        Time sessionTime = Time.valueOf(movieTime);
        String movieTitle = Connect.get();
        String genre = Connect.get();
        String format = Connect.get();
        String age = Connect.get();
        String p = Connect.get();
        Double price = Double.valueOf(p);

        ScheduleInf schedule = new ScheduleInf(idschedule, sessionDate, sessionTime, movieTitle, genre, format, age, price);
        schedules.add(schedule);
    }

    public void fillData(){
        try {
            schedules.removeAll(schedules);
            String array = Connect.get();
            System.out.println(array);
            JSONArray newArray = null;
            if (array != null) {
                newArray = new JSONArray(array);
                int count = newArray.length();
                for(int i = 0; i<count; i++) {
                    JSONObject object = newArray.getJSONObject(i);
                    Integer idschedule = object.getInt("idschedule");
                    String movieDate = object.getString( "sessionDate" );
                    Date sessionDate = Date.valueOf(movieDate);
                    String movieTime = object.getString( "sessionTime");
                    Time sessionTime = Time.valueOf(movieTime);
                    String movieTitle = object.getString( "movieTitle" );
                    String genre = object.getString( "genre" );
                    String format = object.getString( "format" );
                    String age = object.getString("age");
                    Double price = object.getDouble("price");
                    ScheduleInf schedule = new ScheduleInf(idschedule, sessionDate, sessionTime, movieTitle, genre, format, age, price);
                    schedules.add(schedule);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void delete(ScheduleInf schedule){
        schedules.remove(schedule);
    }

    public void chooseMovie(ScheduleInf schedule){

    }
}
