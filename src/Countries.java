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


    Countries startInfection(InfectionProcess process) {
        isInfected = true;
        process.getNotInfected().remove(id);
        process.getInfected().put(id, this);
        System.out.println("Country " + this.getClass() + " is infected!");
        return this;
    }

    Countries infectPeople() {
        if (numberOfInfected < numberOfPeople) {
            numberOfInfected += 10;
            System.out.printf("Infected in " + this.getClass() + " %d/%d\n", numberOfInfected, numberOfPeople);
        }
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
