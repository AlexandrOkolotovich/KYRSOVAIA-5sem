package by.bsuir.coursework.collections;

import by.bsuir.coursework.connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class CollectionUsers {

    private ObservableList<UserInf> users = FXCollections.observableArrayList();

    private static CollectionUsers instance;

    public static synchronized CollectionUsers getInstance(){
        if(instance == null){
            instance = new CollectionUsers();
        }
        return instance;
    }

    public ObservableList<UserInf> getUsers() {
        return users;
    }

    public void fillData(){
        try {
            users.removeAll(users);
            String array = Connect.get();
            System.out.println(array);
            JSONArray newArray = null;
            if (array != null) {
                newArray = new JSONArray(array);
                int count = newArray.length();
                for(int i = 0; i<count; i++) {
                    JSONObject object = newArray.getJSONObject( i );
                    Integer id = object.getInt("id");
                    String surname = object.getString( "surname" );
                    String name = object.getString( "name" );
                    String login = object.getString( "login" );
                    String tel = object.getString( "tel" );
                    String email = object.getString( "email" );
                    String password=object.getString("password");
                    UserInf user = new UserInf(id, surname, name, login, tel, email, password);
                    users.add(user);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void delete(UserInf user){
        users.remove(user);
    }
}
