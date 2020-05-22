public class SingleRecordModel {

    private String playerName;
    private int scores;
    private int infectedCountries;
    private int allCountries;
    private int infectedPeople;
    private int recoveredPeople;
    private int allPeople;

    public SingleRecordModel(String playerName,
                             int infectedCountries,
                             int allCountries,
                             int infectedPeople,
                             int recoveredPeople,
                             int allPeople) {
        this.playerName = playerName;
        this.scores = recoveredPeople * 2;
        this.infectedCountries = infectedCountries;
        this.allCountries = allCountries;
        this.infectedPeople = infectedPeople;
        this.recoveredPeople = recoveredPeople;
        this.allPeople = allPeople;
    }

    @Override
    public String toString() {
        return
                "Player: " + playerName +
                " | Scores: " + scores +
                " | Infected Countries: " + infectedCountries +
                " out of " + allCountries +
                " | Infected People: " + infectedPeople +
                " | Recovered People: " + recoveredPeople +
                " | All People: " + allPeople;
    }
}
