import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShowGame extends JFrame {
    private int points;

    public ShowGame() {

        setTitle("Your Game");
        setSize(1350, 628);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        JPanel mainGame = new JPanel();


        JPanel features = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Game", mainGame);
        tabs.addTab("Settings", features);

        setLayout(new BorderLayout());

//        mainGame.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent keyEvent) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent keyEvent) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent keyEvent) {
//
//            }
//        });

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

//        KeyAdapter listener = new KeyAdapter(){
//            @Override
//            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
//                if (e.getKeyCode() ==)
//            }
//        };

        ActionListener pointsListener = (e) -> {
            points++;
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
        validate();

    }

    public static void easyType() {
        new ShowGame();
        int input = JOptionPane.showOptionDialog(null, "You started game, China is infected!", "The title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (input == JOptionPane.OK_OPTION) {
            new InfectionProcess();
        }
    }

}
