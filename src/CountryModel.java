public class CountryModel {

    private int numberOfPeople;
    private int numberOfRecovered;
    private int numberOfInfected;
    private String countryName;

    private int id;
    private static int idProvider = 1;


    public CountryModel(String countryName, int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        this.countryName = countryName;
        numberOfInfected = 0;
        numberOfRecovered = 0;
        id = idProvider++;
    }

    synchronized void startInfection(Mode process) {
        process.getNotInfected().remove(id);
        process.getInfected().put(id, this);
        System.out.println("Country " + countryName + " is infected!");
        GameView.infectCountryMessage(this);
    }

    synchronized void infectPeople() {
        numberOfInfected += Mode.getInfectedPerDay();
    }

    synchronized void recoverPeople() {
        numberOfRecovered += Mode.getRecoveredPerDay();
    }

    public int getNumberOfInfected() { return numberOfInfected; }

    public int getNumberOfRecovered() { return numberOfRecovered; }

    public int getNumberOfPeople() { return numberOfPeople; }

    public String getCountryName() { return countryName; }
}
