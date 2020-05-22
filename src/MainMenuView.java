import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {


    public MainMenuView() {

        JPanel jPanel = new JPanel();

        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton b1 = new JButton("New Game");
        JButton b2 = new JButton("High Scores");
        JButton b3 = new JButton("Exit");

        b1.addActionListener(actionEvent -> {
            PreGameView sw = new PreGameView();
            this.dispose();
        });
        b2.addActionListener(actionEvent -> {
            this.dispose();
            new HighScoresView(false);
        });
        b3.addActionListener(actionEvent -> {
            this.dispose();
            System.exit(0);
        });

        jPanel.add(b1,gbc);
        jPanel.add(b2,gbc);
        jPanel.add(b3,gbc);

        add(jPanel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360,120);
        setLocationRelativeTo(null);

    }
}
