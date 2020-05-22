import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Graphs extends JPanel {

    static class Coordinate {
        double cordinate1;
        double cordinate2;

        public Coordinate(double cordinate1, double cordinate2) {
            this.cordinate1 = cordinate1/10;
            this.cordinate2 = cordinate2/10;

        }
    }

    private int unitOfTime;
    private static boolean changed;
    private static ArrayList<Coordinate> infectedCoordinates;
    private static ArrayList<Coordinate> recoveredCoordinates;

    Graphs() {
        infectedCoordinates = new ArrayList<>();
        recoveredCoordinates = new ArrayList<>();
        changed = false;
        unitOfTime = 35;
        listenForChanges();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(30,30, 30, 600);
        g.drawLine(30, 600, 1750, 600);
        drawGreenLines(g);
        drawRedLines(g);
    }

    public void drawRedLines(Graphics g) {
        Graphics2D g2red = (Graphics2D) g;
        g2red.setColor(Color.RED);
        g2red.setStroke(new BasicStroke(3));
        Coordinate c;
        for (int i = 0; i < infectedCoordinates.size(); i++) {
            c = infectedCoordinates.get(i);
            System.out.println("Inf: " + c.cordinate1 + " " + c.cordinate2);
            g2red.draw(new Line2D.Double(unitOfTime, 595 - c.cordinate1, unitOfTime+30, 595 - c.cordinate2));
            unitOfTime+= 30;
        }
        unitOfTime = 35;
    }

    public void drawGreenLines(Graphics g) {
        Graphics2D g2green = (Graphics2D) g;
        g2green.setColor(Color.GREEN);
        g2green.setStroke(new BasicStroke(3));
        Coordinate c;
        for (int i = 0; i < recoveredCoordinates.size(); i++) {
            c = recoveredCoordinates.get(i);
            System.out.println("Rec: " + c.cordinate1 + " " + c.cordinate2);
            g2green.draw(new Line2D.Double(unitOfTime, 595 - c.cordinate1, unitOfTime+30, 595 - c.cordinate2));
            unitOfTime+= 30;
        }

        unitOfTime = 35;
    }

    void listenForChanges() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (changed) {
                    changed = false;
                    repaint();
                }

                if ((Mode.getNumberOfInfectedPeople() != 0  && Mode.getNumberOfRecoveredPeople() >= Mode.getNumberOfInfectedPeople())
                        || GameView.isKeyPressed())  {
                    System.out.println("3. Graph timer is canceled");
                    cancel();
                }
            }
        }, 0, 50);
    }

    public static void setChanged(boolean changed) {
        Graphs.changed = changed;
    }

    public static ArrayList<Coordinate> getInfectedCoordinates() {
        return infectedCoordinates;
    }

    public static ArrayList<Coordinate> getRecoveredCoordinates() {
        return recoveredCoordinates;
    }
}