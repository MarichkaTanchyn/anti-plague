import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Mode {

    private static HashMap<Integer, CountryModel> infected;
    private HashMap<Integer, CountryModel> notInfected;

    private int countriesInfectionTime;
    private int peopleInfectionTime;

    private static int numberOfCountries;
    private static int numberOfPeople;
    private static int numberOfInfectedPeople;
    private static int numberOfRecoveredPeople;
    private CountryModel country;

    private static int infectedPerDay;
    private static int recoveredPerDay;

    private boolean isOpen;
    private int period;
    private static double recoveringConstant;

    private Timer mainTimer;

    private Mode address;

    Mode() {
        infected = new HashMap<>();
        notInfected = new HashMap<>();
        isOpen = true;
        address = this;
        period = 5000;
        countriesInfectionTime = 1000;
        peopleInfectionTime = 2000;
        numberOfInfectedPeople = 0;
        numberOfRecoveredPeople  = 0;
        recoveredPerDay = 0;

        notInfected.put( 1, new CountryModel( "China",    200));
        notInfected.put( 2, new CountryModel( "Ukraine",  440));
        notInfected.put( 3, new CountryModel( "USA",      300));
        notInfected.put( 4, new CountryModel( "Belarus",  500));
        notInfected.put( 5, new CountryModel( "Russia",   100));
        notInfected.put( 6, new CountryModel( "Canada",   700));
        notInfected.put( 7, new CountryModel( "France",   300));
        notInfected.put( 8, new CountryModel( "Greenland",100));
        notInfected.put( 9, new CountryModel( "Italy",    400));
        notInfected.put(10, new CountryModel("Japan",     400));
        notInfected.put(11, new CountryModel("Africa",    300));
        notInfected.put(12, new CountryModel("Australia", 300));
        notInfected.put(13, new CountryModel("Poland",    300));
        notInfected.put(14, new CountryModel("Spain",     500));
        notInfected.put(15, new CountryModel("Lithuania", 120));

        numberOfPeople = 0;
        for (int i = 1; i <= notInfected.size(); i++) {
            numberOfPeople += notInfected.get(i).getNumberOfPeople();
        }
        numberOfCountries = notInfected.size();
    }


    void periodOfInfection() {
        notInfected.get(1).startInfection(this);
        mainTimer = new Timer();
        mainTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (numberOfPeople > numberOfInfectedPeople) {
                    changeStateOfPeopleInCountries();
                } else {
                    new HighScoresView(true);
                    cancel();
                }

                if (!notInfected.isEmpty()) {
                    infectCountry();
                }
            }
        }, 0, period);
    }

    public synchronized void changeStateOfPeopleInCountries() {
        while (!isOpen && !notInfected.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignore) {}
        }

        try {
            wait(getPeopleInfectionTime());
        } catch (InterruptedException ignore) {}
        isOpen = false;

        infected.forEach((k, v) -> {
            if (v.getNumberOfPeople() > v.getNumberOfInfected()) {
                v.infectPeople();
                numberOfInfectedPeople += infectedPerDay;

                GameView.getNumberOfInfectedPeople()
                        .setText("Currently infected People - " + numberOfInfectedPeople + "/" + numberOfPeople);

                if (!GameView.getArrayListOfUpdates().isEmpty()){
                    v.recoverPeople();
                    numberOfRecoveredPeople += recoveredPerDay;
                }

                GameView.getNumberOfRecoveredPeople().setText("Currently recovered People - " + numberOfRecoveredPeople + "/" +  numberOfInfectedPeople);
            }
        });
        if (numberOfRecoveredPeople >= numberOfInfectedPeople) {
            numberOfRecoveredPeople = numberOfInfectedPeople;
            mainTimer.cancel();
            Thread.currentThread().interrupt();
            new HighScoresView(true);
        }

        notifyAll();
    }

    public synchronized void infectCountry() {
        while (isOpen) {
            try {
                wait();
            } catch (InterruptedException ignore) {}
        }
        try {
            wait(getCountriesInfectionTime());
        } catch (InterruptedException ignore) {}

        if (numberOfInfectedPeople > 0 && numberOfRecoveredPeople < numberOfInfectedPeople) {
            isOpen = true;
            boolean isOk = false;
            int i = 1;
            while (!isOk) {
                if (!infected.containsKey(i)) isOk = true;
                else i = (int) (1 + Math.random() * numberOfCountries);
            }
            country = notInfected.get(i);
            country.startInfection(address);

            notifyAll();
        } else {
            Thread.currentThread().interrupt();
        }
    }

    public static HashMap<Integer, CountryModel> getInfected() { return infected; }

    public HashMap<Integer, CountryModel> getNotInfected() { return notInfected; }

    public int getPeopleInfectionTime() { return peopleInfectionTime; }

    public int getCountriesInfectionTime() { return countriesInfectionTime; }

    public static double getRecoveringConstant() { return recoveringConstant; }

    public static int getInfectedPerDay() { return infectedPerDay; }

    public static int getRecoveredPerDay() { return recoveredPerDay; }

    public static int getNumberOfInfectedPeople() { return numberOfInfectedPeople; }

    public static int getNumberOfRecoveredPeople() { return numberOfRecoveredPeople; }

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }
    public static int getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setPeriod(int period) { this.period = period; }

    public void setPeopleInfectionTime(int peopleInfectionTime) { this.peopleInfectionTime = peopleInfectionTime; }

    public void setCountriesInfectionTime(int countriesInfectionTime) { this.countriesInfectionTime = countriesInfectionTime; }

    public static void setRecoveringConstant(double recoveringConstant) { Mode.recoveringConstant = recoveringConstant; }

    public static void setInfectedPerDay(int infectedPerDay) { Mode.infectedPerDay = infectedPerDay; }

    public static void setRecoveredPerDay(int recoveredPerDay) { Mode.recoveredPerDay = recoveredPerDay; }

}
