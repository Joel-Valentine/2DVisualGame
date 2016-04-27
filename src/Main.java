import javax.swing.*;

/**
 * Created by Joel on 24/04/2016.
 */
public class Main extends JFrame {


    public static void main(String args[]){
        JFrame myFrame = new JFrame("BestGame");
        myFrame.setContentPane(new GameEngine(1920, 1080));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
