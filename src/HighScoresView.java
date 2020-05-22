import javax.swing.*;
import java.awt.*;

public class HighScoresView extends JFrame {

    public HighScoresView(boolean finishedGame) {
        super("High Scores");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JList records = new JList<>(new InfoCollectionModel(finishedGame));
        records.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        JScrollPane scroll = new JScrollPane(records);
        scroll.setPreferredSize(new Dimension(1350, 628));
        add(scroll);

        JButton mainMenu = new JButton("Menu");
        mainMenu.addActionListener(actionEvent -> {
            this.dispose();
            new MainMenuView();
        });
        add(mainMenu, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
