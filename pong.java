import java.awt.*;
import java.awt.event.*;

class Canvas11 extends Canvas implements KeyListener {
    private int x = 500;
    private int y = 350;
    private double angle;
    private double speed = 12;
    private final int ballSize = 20;
    private int score_a = 0;
    private int score_b = 0;
    private boolean press1, press2, press3, press4 = false;

    private int loc_a = 290;
    private int loc_b = 290;


    public Canvas11() {
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        angle = Math.random() * 2 * Math.PI;
        if((angle > 60 && angle < 120) || (angle > 240 && angle < 320) || (angle > 0 && angle < 30 ) || (angle > 150 && angle < 210) || (angle > 330)){
            angle = Math.random() * 2 * Math.PI;
        }
    }

    public void paint(Graphics p) {
        p.setColor(Color.white);
        p.drawLine(30, 0, 30, 700);
        p.drawLine(970, 0, 970, 700);

        p.setColor(Color.white);
        p.drawOval(x, y, ballSize, ballSize);
        p.fillOval(x, y, ballSize, ballSize);

        p.setColor(Color.white);
        p.drawRect(40, loc_a, 20, 120);
        p.fillRect(40, loc_a, 20, 120);

        p.setColor(Color.white);
        p.drawRect(940, loc_b, 20, 120);
        p.fillRect(940, loc_b, 20, 120);

        p.setColor(Color.white);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.drawString("Score A: " + score_a, 120, 30);
        p.drawString("Score B: " + score_b, getWidth() - 240, 30);

        if (x  >= 40 - ballSize && x <= 60 && y >= loc_a && y <= loc_a + 120) {
            angle = Math.PI - angle;
        }

        if (x >= 940 && x <= 970 - ballSize && y >= loc_b && y <= loc_b + 120) {
            angle = Math.PI - angle;
        }

        if(loc_a <= 0 ){
            loc_a = 0;
        }
        if(loc_a >= 600){
            loc_a = 600 ;
        }

        if(loc_b <= 0 ){
            loc_b = 0;
        }
        if(loc_b >= 600){
            loc_b = 600 ;
        }

        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);

        if (x <= 0 || x >= getWidth() - ballSize) {
            angle = Math.PI - angle;
        }

        if (y <= 0 || y >= getHeight() - ballSize) {
            angle = -angle;
        }

        if (x < 30) {
            score_b++;
            p.setColor(Color.white);
            p.setFont(new Font("Arial", Font.BOLD, 36));
            p.drawString("GOAL!", getWidth() / 2 - 50, getHeight() / 2);

            x = getWidth() / 2;
            y = getHeight() / 2;
            angle = Math.random() * 2 * Math.PI;
            updateScoreboard();
        }   if(x > 960) {
            score_a++;
            p.setColor(Color.white);
            p.setFont(new Font("Arial", Font.BOLD, 36));
            p.drawString("GOAL!", getWidth() / 2 - 50, getHeight() / 2);

            x = getWidth() / 2;
            y = getHeight() / 2;
            angle = Math.random() * 2 * Math.PI;
            updateScoreboard();
        }

        if (press1) {
            loc_a -= 12;
            }
            if (press2) {
                loc_a += 12;
            }

            if (press3) {
                loc_b -= 12;
            }
            if (press4) {
                loc_b += 12;
            }

        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }

        repaint();
    }
    private void updateScoreboard() {
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int tus1 = e.getKeyCode();
        if (tus1 == KeyEvent.VK_W ) {
            press1 = true;}
        if (tus1 == KeyEvent.VK_S ) {
            press2 = true ;
        }
        int tus2 = e.getKeyCode();
        if (tus2 == KeyEvent.VK_UP ) {
            press3 = true;}
        if (tus2 == KeyEvent.VK_DOWN ) {
            press4 = true ;
        }
    }

    public void keyReleased(KeyEvent e) {
        int tus1 = e.getKeyCode();
        if (tus1 == KeyEvent.VK_W ) {
            press1 = false;
        }if (tus1 == KeyEvent.VK_S) {
            press2 = false;
        }
        int tus2 = e.getKeyCode();
        if (tus2 == KeyEvent.VK_UP ) {
            press3 = false;}
        if (tus2 == KeyEvent.VK_DOWN ) {
            press4 = false ;
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}

    public class pong implements WindowListener {
    private Frame frame;
    private Canvas11 canvas;

    public pong() {
        frame = new Frame();
        canvas = new Canvas11();
        frame.addWindowListener(this);
        frame.add(canvas);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        pong uygulama = new pong();
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}

