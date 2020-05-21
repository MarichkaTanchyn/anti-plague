import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameView extends JFrame {

    private int points;

    private static JLabel numberOfPoints;
    private static JLabel numberOfInfectedPeople;
    private static JLabel numberOfRecoveredPeople;
    private static JLabel timer;
    private static ArrayList<JButton> arrayListOfUpdates;
    JButton p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;

    public GameView(String title) {

        super(title);
        timer = new JLabel("00" + " : 00", JLabel.RIGHT);
        numberOfPoints = new JLabel("Number of points - 0", JLabel.LEFT);
        numberOfInfectedPeople = new JLabel("Currently infected People - 0", JLabel.CENTER);
        numberOfRecoveredPeople = new JLabel("Currently recovered People - 0", JLabel.CENTER);
        arrayListOfUpdates = new ArrayList<>();

        addKeyListener(new HotKeyClass());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1350, 628));

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
//        TODO: can try without BorderLayout
        updates.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Game", mainGame);
        tabs.addTab("Updates", updates);
        add(tabs);

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

        numberOfInfectedPeople.setText("Number of infected People - 0");
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

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

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
                arrayListOfUpdates.add(p3);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 50));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p4.addActionListener(actionEvent -> {
            //            TODO: 100 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p4);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 100));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p5.addActionListener(actionEvent -> {
            //            TODO: 150 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p5);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 150));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p6.addActionListener(actionEvent -> {
            //            TODO: 150 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p6);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 150));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p7.addActionListener(actionEvent -> {
            //            TODO: 250 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p7);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 250));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p8.addActionListener(actionEvent -> {
            //            TODO: 300 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p8);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 300));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p9.addActionListener(actionEvent -> {
            //            TODO: 350 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p9);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 350));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");
        });

        p10.addActionListener(actionEvent -> {
            //            TODO: 450 points
            if (points >= 1) {
                points -= 1;
                arrayListOfUpdates.add(p10);
                Mode.setRecoveredPerDay((int)(Mode.getRecoveringConstant() * 450));
                numberOfPoints.setText("Number of points - " + points);
            }else JOptionPane.showMessageDialog(null,"YOU NEED MORE POINTS TO BUY IT");

        });

    }


    public static JLabel getTimer() {
        return timer;
    }

    public static void easyType() {
        int input = JOptionPane.showOptionDialog(null, "Hello, it's a easy type of game" + "\n" +
                "To see details of game or to buy an updates click updates \n" +
                "You started game", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (input == JOptionPane.OK_OPTION) {
            new EasyMode();
            new GameView("Your Game");
            GameTimerModel.timerInGame();
        }else{
            new MainMenuView();
        }
    }


    public static void mediumType() {
        int inputM = JOptionPane.showOptionDialog(null, "Hello, it's a medium type of game" + "\n" +
                "To see details of game or to buy an updates click updates \n" +
                "You started game", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (inputM == JOptionPane.OK_OPTION) {
            new MediumMode();
            new GameView("Your Game");
            GameTimerModel.timerInGame();
        }else{
            new MainMenuView();
        }
    }

    public static void hardType() {
        int inputM = JOptionPane.showOptionDialog(null, "Hello, it's a hard type of game" + "\n" +
                "To see details of game or to buy an updates click updates \n" +
                "You started game, China is infected!", "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (inputM == JOptionPane.OK_OPTION) {
            new HardMode();
            new GameView("Your Game");
            GameTimerModel.timerInGame();

        }else{
            new MainMenuView();
        }
    }
    public static void infectCountryMassage(String country){
        JOptionPane.showMessageDialog(null,country + " is infected");
    }

    public static JLabel getNumberOfInfectedPeople() {
        return numberOfInfectedPeople;
    }

    public static ArrayList<JButton> getArrayListOfUpdates() {
        return arrayListOfUpdates;
    }

    public static JLabel getNumberOfRecoveredPeople() {
        return numberOfRecoveredPeople;
    }

    static class HotKeyClass implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
                System.out.println("WORKS!");

            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
        }
    }
}