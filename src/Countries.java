abstract class Countries {

    private boolean isInfected;
    private int numberOfPeople;
    private int numberOfRecovered;
    private int numberOfInfected;
    private int id;
    private static int idProvider = 1;

    public Countries(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        numberOfInfected = 0;
        numberOfRecovered = 0;
        id = idProvider++;
        isInfected = false;
    }


    synchronized Countries startInfection(Mode process) {
        isInfected = true;
        process.getNotInfected().remove(id);
        process.getInfected().put(id, this);
        System.out.println("Country " + this.getClass() + " is infected!");
        return this;
    }

    synchronized Countries infectPeople() {
        numberOfInfected += 10;
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

}
