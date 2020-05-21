import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HotKeyClass implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
            System.out.println("WORKS!");

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}