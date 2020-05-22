import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class HotKey implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
            GameView.setKeyPressed(true);
            new MainMenuView();

        }
    }
    public void keyReleased(KeyEvent ignore) {
    }

    public void keyTyped(KeyEvent ignore) {
    }
}