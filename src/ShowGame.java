import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class ShowGame extends JFrame {
    private int points;
    private static JLabel numberOfPoints = new JLabel("Number of points - 0");
    private static int secs;
    private static int mins;
    private static JLabel timer;


    public ShowGame() {

        secs = 0;
        mins = 0;
        timer = new JLabel("0" + mins + " : 0" + secs);

        setTitle("Your Game");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1350, 628);

        JPanel mainGame = new JPanel();

        mainGame.setLayout(new GridLayout(3, 3, 10, 10));

        JButton bUSA = new JButton();
        JButton bCanada = new JButton();
        JButton bFrance = new JButton();
        JButton bItaly = new JButton();
        JButton bPoland = new JButton();
        JButton bUkraine = new JButton();
        JButton bRussia = new JButton();
        JButton bChina = new JButton();
        JButton bAfrica = new JButton();
        JButton bAustralia = new JButton();
        JButton bGreenland = new JButton();
        JButton bJapan = new JButton();
        JButton bBelarus = new JButton();
        JButton bSpain = new JButton();
        JButton bLithuania = new JButton();

        bUSA.setIcon(new ImageIcon("./images/USA.png"));
        bCanada.setIcon(new ImageIcon("./images/Canada.png"));
        bFrance.setIcon(new ImageIcon("./images/france.png"));
        bItaly.setIcon(new ImageIcon("./images/italy.png"));
        bPoland.setIcon(new ImageIcon("./images/poland.png"));
        bUkraine.setIcon(new ImageIcon("./images/Ukraine.png"));
        bAfrica.setIcon(new ImageIcon("./images/africa.png"));
        bRussia.setIcon(new ImageIcon("./images/russia.png"));
        bChina.setIcon(new ImageIcon("./images/china.png"));
        bAustralia.setIcon(new ImageIcon("./images/australia.png"));
        bGreenland.setIcon(new ImageIcon("./images/greenland.png"));
        bJapan.setIcon(new ImageIcon("./images/japan.png"));
        bBelarus.setIcon(new ImageIcon("./images/belarus.png"));

        ActionListener pointsListener = (e) -> {
            System.out.println(points++);
            numberOfPoints.setText("Number of points - " + points);

        };
        bUSA.addActionListener(pointsListener);
        bAfrica.addActionListener(pointsListener);
        bAustralia.addActionListener(pointsListener);
        bBelarus.addActionListener(pointsListener);
        bCanada.addActionListener(pointsListener);
        bChina.addActionListener(pointsListener);
        bFrance.addActionListener(pointsListener);
        bGreenland.addActionListener(pointsListener);
        bItaly.addActionListener(pointsListener);
        bJapan.addActionListener(pointsListener);
        bLithuania.addActionListener(pointsListener);
        bPoland.addActionListener(pointsListener);
        bRussia.addActionListener(pointsListener);
        bUkraine.addActionListener(pointsListener);
        bSpain.addActionListener(pointsListener);

        JPanel updates = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Game", mainGame);
        tabs.addTab("Updates", updates);


        updates.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(5, 2, 10, 10));
        JButton p1 = new JButton("Everyone clean there hands --> 10p.");
        JButton p2 = new JButton("Go outside without mask is forbidden --> 50p.");
        JButton p3 = new JButton("Go outside without gloves is forbidden --> 50p.");
        JButton p4 = new JButton("Max number of people in transport 20 persons --> 100p");
        JButton p5 = new JButton("Free masks for people --> 150p");
        JButton p6 = new JButton("Free gloves for people --> 150p");
        JButton p7 = new JButton("Closing borders --> 250");
        JButton p8 = new JButton("Max number of people in supermarket 8 person --> 300p");
        JButton p9 = new JButton("Social distancing --> 350p ");
        JButton p10 = new JButton("Quarantine mode --> 450");

        p1.addActionListener(actionEvent -> {
            if (points >= 10) {

            }
        });

        southPanel.add(p1);
        southPanel.add(p2);
        southPanel.add(p3);
        southPanel.add(p4);
        southPanel.add(p5);
        southPanel.add(p6);
        southPanel.add(p7);
        southPanel.add(p8);
        southPanel.add(p9);
        southPanel.add(p10);

        updates.add(southPanel, BorderLayout.SOUTH);


        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        updates.add(northPanel, BorderLayout.NORTH);


        northPanel.add(numberOfPoints);
        northPanel.add(timer);

        mainGame.add(bUkraine);
        mainGame.add(bUSA);
        mainGame.add(bCanada);
        mainGame.add(bPoland);
        mainGame.add(bItaly);
        mainGame.add(bAfrica);
        mainGame.add(bRussia);
        mainGame.add(bBelarus);
        mainGame.add(bChina);
        mainGame.add(bAustralia);
        mainGame.add(bGreenland);
        mainGame.add(bJapan);
        mainGame.add(bFrance);
        mainGame.add(bLithuania);
        mainGame.add(bSpain);


        add(tabs);
        pack();
        setLocationRelativeTo(null);

    }

    void layouts() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void easyType() {
        int input = JOptionPane.showOptionDialog(null, "  " + "\n" +
                "You started game, China is infected!", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (input == JOptionPane.OK_OPTION) {
            new ShowGame();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if (secs == 59) {
                        mins++;
                        secs = 0;
                    } else secs++;

                    if (secs < 10 && mins < 10) {
                        timer.setText("0" + mins + " : 0" + secs);
                    } else if (secs < 10) {
                        timer.setText(mins + " : 0" + secs);
                    } else if (mins < 10) {
                        timer.setText("0" + mins + " : " + secs);
                    } else timer.setText(mins + " :  " + secs);
                }
            }, 0, 1000);
            new EasyMod();

        }


    }

    public static void mediumType () {
        int inputM = JOptionPane.showOptionDialog(null, "Hello, it's a medium type of game" + "\n" +
                "To see time of game or to buy an updates click updates \n" +
                "You started game, China is infected!", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (inputM == JOptionPane.OK_OPTION) {
            new ShowGame();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if (secs == 59) {
                        mins++;
                        secs = 0;
                    } else secs++;

                    if (secs < 10 && mins < 10) {
                        timer.setText("0" + mins + " : 0" + secs);
                    } else if (secs < 10) {
                        timer.setText(mins + " : 0" + secs);
                    } else if (mins < 10) {
                        timer.setText("0" + mins + " : " + secs);
                    } else timer.setText(mins + " :  " + secs);
                }
            }, 0, 1000);
            new MediumMode();

        }
    }

    public static void hardType () {
        int inputM = JOptionPane.showOptionDialog(null, "Hello, it's a hard type of game" + "\n" +
                "To see time of game or to buy an updates click updates \n" +
                "You started game, China is infected!", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (inputM == JOptionPane.OK_OPTION) {
            new ShowGame();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if (secs == 59) {
                        mins++;
                        secs = 0;
                    } else secs++;

                    if (secs < 10 && mins < 10) {
                        timer.setText("0" + mins + " : 0" + secs);
                    } else if (secs < 10) {
                        timer.setText(mins + " : 0" + secs);
                    } else if (mins < 10) {
                        timer.setText("0" + mins + " : " + secs);
                    } else timer.setText(mins + " :  " + secs);
                }
            }, 0, 1000);
            new HardMode();

        }
    }
}


