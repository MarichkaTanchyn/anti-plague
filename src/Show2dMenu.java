import javax.swing.*;
import java.awt.*;

public class Show2dMenu extends JFrame {

    Show2dMenu() {
        JPanel jPanel = new JPanel();

        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JButton b1 = new JButton("Easy");
        JButton b2 = new JButton("Medium");
        JButton b3 = new JButton("Hard");
        JButton b4 = new JButton("Go back to Main Manu");

        jPanel.add(b1,gbc);
        jPanel.add(b2,gbc);
        jPanel.add(b3,gbc);
        jPanel.add(b4,gbc);
        b4.addActionListener(actionEvent -> {
            Menu menu = new Menu();
            this.dispose();
        });
        b1.addActionListener(actionEvent -> {
            ShowGame showGame = new ShowGame();
            this.dispose();
            new InfectionProcess();
        });
        b2.addActionListener(actionEvent -> {
            ShowGame showGame = new ShowGame();
            this.dispose();
        });
        b3.addActionListener(actionEvent -> {
            ShowGame showGame = new ShowGame();
            this.dispose();
        });

        add(jPanel);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setSize(360,120);
    }
}
