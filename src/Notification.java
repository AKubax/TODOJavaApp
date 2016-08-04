import javax.swing.*;

public class Notification {
    private String text;

    public Notification(String text){
        this.text = text;
    }

    public void show(){
        JOptionPane.showMessageDialog(null, text);
    }
}
