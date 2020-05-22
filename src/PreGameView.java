import javax.swing.*;
import java.awt.*;

public class PreGameView extends JFrame {

    PreGameView() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setSize(360, 120);

        JPanel mainMenu = new JPanel();

        JButton b1 = new JButton("Easy");
        JButton b2 = new JButton("Medium");
        JButton b3 = new JButton("Hard");
        JButton b4 = new JButton("Go back to Main Manu");

        mainMenu.add(b1);
        mainMenu.add(b2);
        mainMenu.add(b3);
        mainMenu.add(b4);

        b1.addActionListener(actionEvent -> {
            this.dispose();
            GameView.easyType();
        });
        b2.addActionListener(actionEvent -> {
            this.dispose();
            GameView.mediumType();

        });
        b3.addActionListener(actionEvent -> {
            this.dispose();
            GameView.hardType();
        });

        b4.addActionListener(actionEvent -> {
            this.dispose();
            new MainMenuView();
        });

        add(mainMenu);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
