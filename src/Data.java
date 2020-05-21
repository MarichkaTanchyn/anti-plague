import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Data extends JFrame {
    private String playerSName;
    private ArrayList<String> players;

    Data() {
        players = new ArrayList<>();
        enters();
    }

    private void enters() {
        setTitle("Game is ended");
        setSize(250, 320);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel jLabel = new JLabel("Enter your nickname: ");


        JTextField enterName = new JTextField();

        enterName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                playerSName = String.valueOf(enterName.getText());
                players.add(playerSName);
                System.out.println(playerSName);
            }

        });
        setLayout(new FlowLayout());
        add(jLabel);
        add(enterName);



    }

}
