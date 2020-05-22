import javax.swing.*;
import java.util.ArrayList;

public class InfoCollectionModel extends AbstractListModel<SingleRecordModel> {
    private static ArrayList<SingleRecordModel> players = new ArrayList<>();

    InfoCollectionModel(boolean finishedGame) {
        if (finishedGame) {
            enters();
        }
    }

    private void enters() {
        String playerName = JOptionPane.showInputDialog("Enter Your Nickname: ");
        players.add(new SingleRecordModel(playerName, Mode.getInfected().size(), Mode.getNumberOfCountries(), Mode.getNumberOfInfectedPeople(),Mode.getNumberOfRecoveredPeople(), Mode.getNumberOfPeople()));
    }

    @Override
    public int getSize() {
        return players.size();
    }

    @Override
    public SingleRecordModel getElementAt(int i) {
        return players.get(i);
    }
}
