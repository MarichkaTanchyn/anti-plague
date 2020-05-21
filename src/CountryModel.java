public class CountryModel {

    private boolean isInfected;
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
        isInfected = false;
    }


    synchronized CountryModel startInfection(Mode process) {
        isInfected = true;
        process.getNotInfected().remove(id);
        process.getInfected().put(id, this);
        System.out.println("Country " + this.getClass() + " is infected!");
        GameView.infectCountryMassage(this.toString());
        return this;
    }

    synchronized CountryModel infectPeople() {
        numberOfInfected += Mode.getInfectedPerDay();
        return this;
    }

    synchronized CountryModel recoverPeople() {
        numberOfRecovered += Mode.getRecoveredPerDay();
        return this;
    }

    public int getNumberOfInfected() {
        return numberOfInfected;
    }

    public int getNumberOfRecovered() {
        return numberOfRecovered;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public boolean isInfected() {
        return isInfected;
    }

    @Override
    public String toString() {
        return this.getClass().toString().split("@")[0].replace("class", "Country");
    }
}
