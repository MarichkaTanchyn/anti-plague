import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShowGame extends JFrame {
    public ShowGame() {
        JPanel jPanel = new JPanel();

        setTitle("Your Game");
        setSize(1350,628);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        jPanel.setLayout(new GridLayout(3,3,10,10));

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

        add(jPanel);
        jPanel.add(bUkraine);
        jPanel.add(bUSA);
        jPanel.add(bCanada);
        jPanel.add(bPoland);
        jPanel.add(bItaly);
        jPanel.add(bAfrica);
        jPanel.add(bRussia);
        jPanel.add(bBelarus);
        jPanel.add(bChina);
        jPanel.add(bAustralia);
        jPanel.add(bGreenland);
        jPanel.add(bJapan);
        jPanel.add(bFrance);

        validate();

        new InfectionProcess();

    }
}
