import java.util.Timer;
import java.util.TimerTask;

public class GameTimerModel {
    private static int secs;
    private static int mins;

    synchronized static void timerInGame() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if ((Mode.getNumberOfRecoveredPeople() < Mode.getNumberOfInfectedPeople() || Mode.getNumberOfInfectedPeople() == 0) && !GameView.isKeyPressed()) {
                    if (secs == 59) {
                        mins++;
                        secs = 0;
                    } else secs++;
                    if (secs < 10 && mins < 10) {
                        GameView.getTimer().setText("0" + mins + " : 0" + secs);
                    } else if (secs < 10) {
                        GameView.getTimer().setText(mins + " : 0" + secs);
                    } else if (mins < 10) {
                        GameView.getTimer().setText("0" + mins + " : " + secs);
                    } else GameView.getTimer().setText(mins + " :  " + secs);
                } else {
                    cancel();
                }
            }
        }, 0, 1000);
    }
}
