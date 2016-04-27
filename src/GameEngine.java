import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by Joel on 24/04/2016.
 */
public class GameEngine extends JPanel implements Runnable, KeyListener {
    private int screenWidth;
    private int screenHeight;
    private int FPS = 120;

    private long targetTime = 1000 / FPS;

    private boolean running;

    private BufferedImage background;

    private Graphics2D graphics2D;

    private Thread gameThread;

    GameEngine(int x, int y){
        setScreenWidth(x);
        setScreenHeight(y);
        setPreferredSize(new Dimension(getScreenWidth(), getScreenHeight()));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if(gameThread == null){
            gameThread = new Thread(this);
            addKeyListener(this);
            gameThread.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        init();

        long start;
        long elapsed;
        long wait;

        while(running){

            start = System.nanoTime();

            updateG();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed /1000000;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateG() {
    }

    private void drawToScreen() {
        Graphics game2 = getGraphics();
        game2.drawImage(background, 0, 0, null);
        game2.dispose();
    }

    private void draw() {
    }

    private void init() {
        background = new BufferedImage(getX(), getY(), BufferedImage.TYPE_INT_RGB);
        setRunning(true);
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
