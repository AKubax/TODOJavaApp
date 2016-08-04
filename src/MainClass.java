import TasksData.Task;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import TasksData.Storage;

import static java.lang.Thread.sleep;

public class MainClass{
    public static void main(String[] args) {

    }


    static{     //Все время, пока программа выполняется, идет поиск тасков, время которых сейчас, и если находит, то генерирует уведомление
        Runnable thr = () -> {
            while (true) {
                for (Task i : Storage.tasks) {
                    if (i.date.compareTo(new GregorianCalendar(TimeZone.getTimeZone("Europe/Moscow"))) == 0) { new Notification(i.toString()).show(); }
                }
                try {
                    sleep(1000);     //Чтобы не перегружать оперативку
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(thr, "Second Thread").start();
    }
}
