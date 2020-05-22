import java.awt.*;
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

        notInfected.put( 0, new CountryModel( "USA",    200));
        notInfected.put( 1, new CountryModel( "Algeria",    200));
        notInfected.put( 2, new CountryModel( "France",  440));
        notInfected.put( 3, new CountryModel( "Italy",      300));
        notInfected.put( 4, new CountryModel( "Poland",  500));
        notInfected.put( 5, new CountryModel( "Ukraine",   100));
        notInfected.put( 6, new CountryModel( "Canada",   700));
        notInfected.put( 7, new CountryModel( "Russia",   300));
        notInfected.put( 8, new CountryModel( "China",100));
        notInfected.put( 9, new CountryModel( "Australia",    400));
        notInfected.put(10, new CountryModel("Greenland",     400));
        notInfected.put(11, new CountryModel("Japan",    300));
        notInfected.put(12, new CountryModel("Lithuania", 300));
        notInfected.put(13, new CountryModel("Spain",    300));
        notInfected.put(14, new CountryModel("Belarus",     500));


        numberOfPeople = 0;
        for (int i = 0; i < notInfected.size(); i++) {
            numberOfPeople += notInfected.get(i).getNumberOfPeople();
        }
        numberOfCountries = notInfected.size();
    }


    void periodOfInfection() {
        notInfected.get(8).startInfection(this, "Coronavirus");
        mainTimer = new Timer();
        mainTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (numberOfPeople > numberOfInfectedPeople) {
                    changeStateOfPeopleInCountries();
                } else{
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

        int numbOfInfBefore = numberOfInfectedPeople - infectedPerDay * infected.size();
        int numbOfInfAfter = numberOfInfectedPeople;
        int numbOfRecBefore = numberOfRecoveredPeople - recoveredPerDay * infected.size();
        int numbOfRecAfter = numberOfRecoveredPeople;
        Graphs.getInfectedCoordinates().add(new Graphs.Coordinate(numbOfInfBefore, numbOfInfAfter));
        Graphs.getRecoveredCoordinates().add(new Graphs.Coordinate(numbOfRecBefore, numbOfRecAfter));
        Graphs.setChanged(true);


        if (GameView.isKeyPressed()) {
            mainTimer.cancel();
            notifyAll();
            Thread.currentThread().interrupt();
        }

        if (numberOfRecoveredPeople >= numberOfInfectedPeople) {
            numberOfRecoveredPeople = numberOfInfectedPeople;
            mainTimer.cancel();
            notifyAll();
            new HighScoresView(true);
            Thread.currentThread().interrupt();
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

        if (numberOfInfectedPeople > 0 && numberOfRecoveredPeople < numberOfInfectedPeople && !GameView.isKeyPressed()) {
            isOpen = true;
            boolean isOk = false;
            int i = 8;
            while (!isOk) {
                if (!infected.containsKey(i)) {
                    isOk = true;
                }
                else {
                    i = (int)(Math.random() * numberOfCountries);
                }
            }
            CountryModel country = notInfected.get(i);
            GameView.getCountryButtons().get(i).setBackground(new Color(160, 1,0));
            String transport = "";
            switch ((int)(1 + Math.random() * 5)) {
                case 1:
                    transport = "Airplane";
                    break;
                case 2:
                    transport = "Car";
                    break;
                case 3:
                    transport = "Train";
                    break;
                case 4:
                    transport = "Ship";
                    break;
                case 5:
                    transport = "Cargo";
                    break;

            }
            country.startInfection(address, transport);
        } else {
            mainTimer.cancel();
            notifyAll();
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
