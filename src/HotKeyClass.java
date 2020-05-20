import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HotKeyClass extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == (KeyEvent.VK_SHIFT & KeyEvent.VK_Q & KeyEvent.VK_CONTROL)) {
            new Menu();
        }
    }
}
