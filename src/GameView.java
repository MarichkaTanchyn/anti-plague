import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameView extends JFrame {

    private int points;

    private static JLabel numberOfPoints;
    private static JLabel numberOfInfectedPeople;
    private static JLabel numberOfRecoveredPeople;
    private static JLabel timer;
    private static ArrayList<JButton> arrayListOfUpdates;

    ArrayList<JButton> countryButtons;
    ArrayList<JButton> updateButtons;

    private static Mode mode;

    public GameView(String title) {
        super(title);
        timer = new JLabel("00" + " : 00", JLabel.RIGHT);
        numberOfPoints = new JLabel("Number of points - 0", JLabel.LEFT);
        numberOfInfectedPeople = new JLabel("Currently infected People - 0", JLabel.CENTER);
        numberOfRecoveredPeople = new JLabel("Currently recovered People - 0", JLabel.CENTER);
        arrayListOfUpdates = new ArrayList<>();
        countryButtons = new ArrayList<>(15);
        updateButtons = new ArrayList<>(10);

        addKeyListener(new HotKey());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1350, 628));

        JPanel mainGame = new JPanel();
        mainGame.setLayout(new GridLayout(3, 3, 10, 10));

        ActionListener pointsListener = (e) -> {
            points++;
            numberOfPoints.setText("Number of points - " + points);
        };

        for (int i = 0; i < 15; i++) {
            countryButtons.add(new JButton());
            countryButtons.get(i).addActionListener(pointsListener);
            countryButtons.get(i).setFocusable(false);
        }
        setIcons();

        JPanel updates = new JPanel();
        updates.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Game", mainGame);
        tabs.addTab("Updates", updates);
        tabs.setFocusable(false);
        add(tabs);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(5, 2, 10, 10));

        updates();

        for (JButton b : updateButtons) {
            southPanel.add(b);
        }

        updates.add(southPanel, BorderLayout.SOUTH);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 4, 10, 10));
        updates.add(northPanel, BorderLayout.NORTH);

        numberOfInfectedPeople.setText("Number of infected People - 0");
        numberOfInfectedPeople.setForeground(Color.RED);
        numberOfRecoveredPeople.setForeground(new Color(0, 122, 43));

        northPanel.add(numberOfPoints);
        northPanel.add(numberOfRecoveredPeople);
        northPanel.add(numberOfInfectedPeople);
        northPanel.add(timer);


        for (JButton b : countryButtons) {
            mainGame.add(b);
        }

        checkIfGameIsOver(mode);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setIcons() {
        countryButtons.get(0).setIcon(new ImageIcon("./images/USA.png"));
        countryButtons.get(1).setIcon(new ImageIcon("./images/Canada.png"));
        countryButtons.get(2).setIcon(new ImageIcon("./images/france.png"));
        countryButtons.get(3).setIcon(new ImageIcon("./images/italy.png"));
        countryButtons.get(4).setIcon(new ImageIcon("./images/poland.png"));
        countryButtons.get(5).setIcon(new ImageIcon("./images/Ukraine.png"));
        countryButtons.get(6).setIcon(new ImageIcon("./images/africa.png"));
        countryButtons.get(7).setIcon(new ImageIcon("./images/russia.png"));
        countryButtons.get(8).setIcon(new ImageIcon("./images/china.png"));
        countryButtons.get(9).setIcon(new ImageIcon("./images/australia.png"));
        countryButtons.get(10).setIcon(new ImageIcon("./images/greenland.png"));
        countryButtons.get(11).setIcon(new ImageIcon("./images/japan.png"));
        countryButtons.get(12).setIcon(new ImageIcon("./images/belarus.png"));
        countryButtons.get(13).setIcon(new ImageIcon("./images/belarus.png"));
        countryButtons.get(14).setIcon(new ImageIcon("./images/belarus.png"));
    }

    void updates() {

        updateButtons.add(new JButton("Everyone clean there hands --> 10p."));
        updateButtons.add(new JButton("Go outside without mask is forbidden --> 50p."));
        updateButtons.add(new JButton("Go outside without gloves is forbidden --> 50p."));
        updateButtons.add(new JButton("Max number of people in transport 20 persons --> 100p"));
        updateButtons.add(new JButton("Free masks for people --> 150p"));
        updateButtons.add(new JButton("Free gloves for people --> 150p"));
        updateButtons.add(new JButton("Closing borders --> 250"));
        updateButtons.add(new JButton("Max number of people in supermarket 8 person --> 300p"));
        updateButtons.add(new JButton("Social distancing --> 350p "));
        updateButtons.add(new JButton("Quarantine mode --> 450"));

        for (JButton b : updateButtons) {
            b.setFocusable(false);
        }

        updateButtons.get(0).addActionListener(actionEvent -> updatePoints(10, 0));
        updateButtons.get(1).addActionListener(actionEvent -> updatePoints(50, 1));
        updateButtons.get(2).addActionListener(actionEvent -> updatePoints(50, 2));
        updateButtons.get(3).addActionListener(actionEvent -> updatePoints(100, 3));
        updateButtons.get(4).addActionListener(actionEvent -> updatePoints(150, 4));
        updateButtons.get(5).addActionListener(actionEvent -> updatePoints(150, 5));
        updateButtons.get(6).addActionListener(actionEvent -> updatePoints(250, 6));
        updateButtons.get(7).addActionListener(actionEvent -> updatePoints(300, 7));
        updateButtons.get(8).addActionListener(actionEvent -> updatePoints(350, 8));
        updateButtons.get(9).addActionListener(actionEvent -> updatePoints(450, 9));
    }

    void updatePoints(int points, int numbOfButton) {
        if (this.points >= points) {
            this.points -= points;
            arrayListOfUpdates.add(updateButtons.get(numbOfButton));
            Mode.setRecoveredPerDay((int) (Mode.getRecoveringConstant() * 1000)); // TODO: change 100 to this.points
            numberOfPoints.setText("Number of points - " + this.points);
        } else JOptionPane.showMessageDialog(null, "YOU NEED MORE POINTS TO BUY IT");
    }


    public static void easyType() {
        int input = JOptionPane.showOptionDialog(null,
                "Hello, it's a easy type of game" + "\n" +
                        "To see details of game or to buy an updates click updates \n" +
                        "You started game", "Message",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                null
        );

        if (input == JOptionPane.OK_OPTION) {
            mode = new EasyMode();
            new GameView("Your Game");
            GameTimerModel.timerInGame();
        } else {
            new MainMenuView();
        }
    }

    public static void mediumType() {
        int inputM = JOptionPane.showOptionDialog(null,
                "Hello, it's a medium type of game" + "\n" +
                        "To see details of game or to buy an updates click updates \n" +
                        "You started game", "Message",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                null
        );

        if (inputM == JOptionPane.OK_OPTION) {
            mode = new MediumMode();
            new GameView("Your Game");
            GameTimerModel.timerInGame();
        } else {
            new MainMenuView();
        }
    }

    public static void hardType() {
        int inputM = JOptionPane.showOptionDialog(null,
                "Hello, it's a hard type of game" + "\n" +
                        "To see details of game or to buy an updates click updates \n" +
                        "You started game, China is infected!", "Message",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                null
        );

        if (inputM == JOptionPane.OK_OPTION) {
            mode = new HardMode();
            new GameView("Your Game");
            GameTimerModel.timerInGame();

        } else {
            new MainMenuView();
        }
    }

    void checkIfGameIsOver(Mode mode) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (mode.getNumberOfInfectedPeople() != 0 && mode.getNumberOfRecoveredPeople() >= mode.getNumberOfInfectedPeople()) {
                    myDispose();
                    cancel();
                }
            }
        }, 0, 2000);
    }

    public void myDispose() {
        this.dispose();
    }



    public static void infectCountryMessage(CountryModel country) {
        JOptionPane.showMessageDialog(null, "Country " + country.getCountryName() + " is infected");
    }

    public static JLabel getTimer() {
        return timer;
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
}