package TasksData;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Task {      //Класс, в котором описывается все основные данные задачи
    public GregorianCalendar date;    //Дата оповещения
    public String title;
    public String text;

    Task(int year, int month, int dayOfMonth, int hourOfDay, int minute, String title, String text){
        date = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, 0);
        date.setTimeZone( TimeZone.getTimeZone("Europe/Moscow") );
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return title + ": " + text;
    }
}
