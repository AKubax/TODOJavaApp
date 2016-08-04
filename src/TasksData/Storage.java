package TasksData;

import java.io.*;
import java.util.ArrayList;

public class Storage {      //Класс для работы с файлами, а также фа
    public static ArrayList<Task> tasks;    //Хранятся все таски

    static{
        tasks = deser("./Files/tasks.ser", Task.class);
    }

    private Storage(){ /* Storage - класс со статическими методами*/ }

    private static void ser(ArrayList<?> list, String path) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            for(Object i : list) outputStream.writeObject(i);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static <T> ArrayList<T> deser(String path, Class<T> type) {
        ArrayList<T> list = new ArrayList<T>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))){
            while (inputStream.available() > 0){
                list.add((T) inputStream.readObject());
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Task getNewTask(int year, int month, int dayOfMonth, int hourOfDay, int minute, String title, String text){
        Task t = new Task(year, month, dayOfMonth, hourOfDay, minute, title, text);
        tasks.add(t);
        ser(tasks, "./Files/tasks.ser");
        return t;
    }

}

