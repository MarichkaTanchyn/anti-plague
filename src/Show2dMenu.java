import javax.swing.*;
import java.awt.*;

public class Show2dMenu extends JFrame {

    Show2dMenu() {

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setSize(360, 120);


        JPanel mainMenu = new JPanel();



        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JButton b1 = new JButton("Easy");
        JButton b2 = new JButton("Medium");
        JButton b3 = new JButton("Hard");
        JButton b4 = new JButton("Go back to Main Manu");

        mainMenu.add(b1, gbc);
        mainMenu.add(b2, gbc);
        mainMenu.add(b3, gbc);
        mainMenu.add(b4, gbc);

        b1.addActionListener(actionEvent -> {
            this.dispose();
            ShowGame.easyType();
        });
        b2.addActionListener(actionEvent -> {
            this.dispose();
            ShowGame.mediumType();

        });
        b3.addActionListener(actionEvent -> {
            this.dispose();
            ShowGame.hardType();
        });


        add(mainMenu);
        setLocationRelativeTo(null);

    }
}
