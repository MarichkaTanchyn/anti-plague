import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ShowGame extends JFrame {

    private int points;
    private static JLabel numberOfPoints;
    private static JLabel numberOfInfectedPeople;
    private static JLabel numberOfRecoveredPeople;
    private static int numberOfInfected;
    private static int secs;
    private static int mins;
    private static JLabel timer;
    private static ArrayList<JButton> arrayListOfUpdates;


    JButton p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;


    public ShowGame() {

        secs = 0;
        mins = 0;
        timer = new JLabel("0" + mins + " : 0" + secs, JLabel.RIGHT);
        numberOfPoints = new JLabel("Number of points - 0", JLabel.LEFT);
        numberOfInfectedPeople = new JLabel("Currently infected People - 0", JLabel.CENTER);
        numberOfRecoveredPeople = new JLabel("Currently recovered People - 0", JLabel.CENTER);
        arrayListOfUpdates = new ArrayList<>();

        addKeyListener(new HotKeyClass());
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
            points++;
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
        updates.setFocusable(false);
        mainGame.setFocusable(false);


        updates.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(5, 2, 10, 10));

        updates();

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
        northPanel.setLayout(new GridLayout(1, 4, 10,10));
        updates.add(northPanel, BorderLayout.NORTH);

        numberOfInfectedPeople.setText("Number of infected People - " + numberOfInfected);
        numberOfInfectedPeople.setForeground(Color.RED);
        numberOfRecoveredPeople.setForeground(new Color(0, 122, 43));

        northPanel.add(numberOfPoints);
        northPanel.add(numberOfRecoveredPeople);
        northPanel.add(numberOfInfectedPeople);
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

    void updates() {

        p1 = new JButton("Everyone clean there hands --> 10p.");
        p2 = new JButton("Go outside without mask is forbidden --> 50p.");
        p3 = new JButton("Go outside without gloves is forbidden --> 50p.");
        p4 = new JButton("Max number of people in transport 20 persons --> 100p");
        p5 = new JButton("Free masks for people --> 150p");
        p6 = new JButton("Free gloves for people --> 150p");
        p7 = new JButton("Closing borders --> 250");
        p8 = new JButton("Max number of people in supermarket 8 person --> 300p");
        p9 = new JButton("Social distancing --> 350p ");
        p10 = new JButton("Quarantine mode --> 450");

        p1.addActionListener(actionEvent -> {
//            TODO: 10 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);

                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 10));
                numberOfPoints.setText("Number of points - " + points);

            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p2.addActionListener(actionEvent -> {
            //            TODO: 50 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p2);

                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 20));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p3.addActionListener(actionEvent -> {
            //            TODO: 50 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 50));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p4.addActionListener(actionEvent -> {
            //            TODO: 100 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 100));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p5.addActionListener(actionEvent -> {
            //            TODO: 150 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 150));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p6.addActionListener(actionEvent -> {
            //            TODO: 150 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 150));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p7.addActionListener(actionEvent -> {
            //            TODO: 250 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 250));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p8.addActionListener(actionEvent -> {
            //            TODO: 300 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 300));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p9.addActionListener(actionEvent -> {
            //            TODO: 350 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 350));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p10.addActionListener(actionEvent -> {
            //            TODO: 450 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p1);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 450));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");

        });

    }


    synchronized static void timerInGame() {
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
    }

    public static void easyType() {
        int input = JOptionPane.showOptionDialog(null, "Hello, it's a easy type of game" + "\n" +
                "To see details of game or to buy an updates click updates \n" +
                "You started game", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (input == JOptionPane.OK_OPTION) {
            new EasyMod();
            new ShowGame();
            timerInGame();
        }else{
            new Menu();
        }
    }


    public static void mediumType() {
        int inputM = JOptionPane.showOptionDialog(null, "Hello, it's a medium type of game" + "\n" +
                "To see details of game or to buy an updates click updates \n" +
                "You started game", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (inputM == JOptionPane.OK_OPTION) {
            new MediumMode();
            new ShowGame();
            timerInGame();
        }else{
            new Menu();
        }
    }

    public static void hardType() {
        int inputM = JOptionPane.showOptionDialog(null, "Hello, it's a hard type of game" + "\n" +
                "To see details of game or to buy an updates click updates \n" +
                "You started game, China is infected!", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (inputM == JOptionPane.OK_OPTION) {
            new HardMode();
            new ShowGame();
            timerInGame();

        }else{
            new Menu();
        }
    }
    public static void infectCountryMassage(String country){
        JOptionPane.showMessageDialog(null,country + " is infected");
    }

    public static JLabel getNumberOfInfectedPeople() {
        return numberOfInfectedPeople;
    }

    public static int getNumberOfInfected() {
        return numberOfInfected;
    }

    public static void setNumberOfInfected(int numberOfInfected) {
        ShowGame.numberOfInfected = numberOfInfected;
    }

    public static ArrayList<JButton> getArrayListOfUpdates() {
        return arrayListOfUpdates;
    }

    public static JLabel getNumberOfRecoveredPeople() {
        return numberOfRecoveredPeople;
    }
}


