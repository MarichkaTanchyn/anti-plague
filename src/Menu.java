import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {


    public Menu() {

        JPanel jPanel = new JPanel();

        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JButton b1 = new JButton("New Game");
        JButton b2 = new JButton("High Scores");
        JButton b3 = new JButton("Exit");

        b1.addActionListener(actionEvent -> {
            Show2dMenu sw = new Show2dMenu();
            this.dispose();
        });
        b3.addActionListener(actionEvent -> {
            //call a saving
            this.dispose();
        });


        jPanel.add(b1,gbc);
        jPanel.add(b2,gbc);
        jPanel.add(b3,gbc);


        add(jPanel);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360,120);




    }
}
