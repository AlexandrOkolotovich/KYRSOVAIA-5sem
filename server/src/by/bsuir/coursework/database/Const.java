package by.bsuir.coursework.database;

public class Const {

    public static final String USER_TABLE="users";

    public static final String USER_ID="id";
    public static final String USER_SURNAME="surname";
    public static final String USER_NAME="name";
    public static final String USER_LOGIN="login";
    public static final String USER_TEL="tel";
    public static final String USER_EMAIL="email";
    public static final String USER_PASSWORD="password";
    public static final String USER_ROLE="role";

    public static final String MOVIE_TABLE="movie";

    public static final String MOVIE_ID="idmovie";
    public static final String MOVIE_TITLE="movieTitle";
    public static final String MOVIE_YEAR="productionYear";
    public static final String MOVIE_COUNTRY="country";
    public static final String MOVIE_GENRE="genre";
    public static final String MOVIE_DIRECTOR="director";
    public static final String MOVIE_AGE="age";
    public static final String MOVIE_TIME="time";
    public static final String MOVIE_DESCRIPTION="description";
    public static final String MOVIE_RATING="rating";

    public static final String SCHEDULE_TABLE="schedule";

    public static final String SCHEDULE_ID="idschedule";
    public static final String SCHEDULE_MOVIE_ID="movie_idmovie";
    public static final String SCHEDULE_SESSION_DATE="sessionDate";
    public static final String SCHEDULE_SESSION_TIME="sessionTime";
    public static final String SCHEDULE_FORMAT="format";
    public static final String SCHEDULE_PRICE="price";

    public static final String TICKET_TABLE="ticket";

    public static final String TICKET_ID="idticket";
    public static final String TICKET_SCHEDULE_ID="schedule_idschedule";
    public static final String TICKET_ROW_NUMBER="rowNumber";
    public static final String TICKET_PLACE_NUMBER="placeNumber";

    public static final String ORDER_TABLE="`order`";

    public static final String ORDER_ID="idorder";
    public static final String ORDER_USERS_ID="users_id";
    public static final String ORDER_TICKET_ID="ticket_idticket";
    public static final String ORDER_PAID="paid";
    public static final String ORDER_BRON="bron";

    public static final String SOLVENCY_TABLE="solvency";

    public static final String SOLVENCY_ID="idsolvency";
    public static final String SOLVENCY_USERS_ID="users_id";
    public static final String SOLVENCY_CASH="cash";

    public static final String CINEMAINFO_TABLE="cinemainfo";

    public static final String CINEMAINFO_ID="idcinemaInfo";
    public static final String CINEMAINFO_PARAGRAPH1="paragraph1";
    public static final String CINEMAINFO_PARAGRAPH2="paragraph2";
    public static final String CINEMAINFO_PARAGRAPH3="paragraph3";
    public static final String CINEMAINFO_PARAGRAPH4="paragraph4";

}
