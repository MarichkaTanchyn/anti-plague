import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class Mode {

    private HashMap<Integer, CountryModel> infected;
    private HashMap<Integer, CountryModel> notInfected;

    private int countriesInfectionTime;
    private int numberOfCountries;
    private int peopleInfectionTime;
    private Mode address;
    private CountryModel country;
    private int numberOfPeople;
    private int numberOfInfectedPeople;
    private boolean isOpen = true;
    private int period;

    private static int infectedPerDay;
    private static int recoveredPerDay;

    private static int numberOfRecoveredPeople;
    private static double recoveringConstant;

    Mode() {
        infected = new HashMap<>();
        notInfected = new HashMap<>();
        address = this;
        period = 5000;
        countriesInfectionTime = 1000;
        peopleInfectionTime = 2000;
        numberOfInfectedPeople = 0;
        numberOfRecoveredPeople  = 0;
        recoveredPerDay = 0;
        notInfected.put(1, new CountryModel("China",200));
        notInfected.put(2, new CountryModel("Ukraine",440));
        notInfected.put(3, new CountryModel("USA",300));
        notInfected.put(4, new CountryModel("Belarus",500));
        notInfected.put(5, new CountryModel("Russia",100));
        notInfected.put(6, new CountryModel("Canada",700));
        notInfected.put(7, new CountryModel("France",300));
        notInfected.put(8, new CountryModel("Greenland",100));
        notInfected.put(9, new CountryModel("Italy",400));
        notInfected.put(10, new CountryModel("Japan",400));
        notInfected.put(11, new CountryModel("Africa",300));
        notInfected.put(12, new CountryModel("Australia",300));
        notInfected.put(13, new CountryModel("Poland",300));
        notInfected.put(14, new CountryModel("Spain",500));
        notInfected.put(15, new CountryModel("Lithuania",120));


        numberOfPeople = 0;
        for (int i = 1; i <= notInfected.size(); i++) {
            numberOfPeople += notInfected.get(i).getNumberOfPeople();
        }

        numberOfCountries = notInfected.size();
    }

    public HashMap<Integer, CountryModel> getInfected() {
        return infected;
    }

    public HashMap<Integer, CountryModel> getNotInfected() {
        return notInfected;
    }

    void periodOfInfection(){
        notInfected.get(1).startInfection(this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (numberOfPeople >= numberOfInfectedPeople) {
                    changeStateOfPeopleInCountries();
                } else cancel();

                if (!notInfected.isEmpty()) {
                    infectCountry();
                }


            }
        }, 0, period);
        System.out.println(numberOfPeople + " " + numberOfInfectedPeople);
    }

    public synchronized void changeStateOfPeopleInCountries() {
        while (!isOpen && !notInfected.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("1 Interrupted");
            }
        }

        try {
            wait(getPeopleInfectionTime());
        } catch (InterruptedException ignore) {
        }
        System.out.println("\n\n---- ---- ----\nProcess:");

        isOpen = false;

        infected.forEach((k, v) -> {
            if (v.getNumberOfPeople() > v.getNumberOfInfected()) {
                v.infectPeople();
                numberOfInfectedPeople += infectedPerDay;
//                Updating label
                GameView.getNumberOfInfectedPeople().setText("Currently infected People - " + numberOfInfectedPeople + "/" + numberOfPeople);

//                Recovering people
                if (!GameView.getArrayListOfUpdates().isEmpty()){
                    v.recoverPeople();
                    numberOfRecoveredPeople += recoveredPerDay;
                    System.out.println("Recovered:         (" + k + ") " + v.getClass() + ": " + v.getNumberOfRecovered() + "/" + v.getNumberOfPeople());

                }

                GameView.getNumberOfRecoveredPeople().setText("Currently recovered People - " + numberOfRecoveredPeople + "/" +  numberOfInfectedPeople);
                System.out.println("Infected :         (" + k + ") " + v.getClass() + ": " + v.getNumberOfInfected() + "/" + v.getNumberOfPeople());
            }
        });
        if (numberOfRecoveredPeople >= numberOfInfectedPeople) {
//            TODO: improve
            new Data();
        }

        System.out.println("---- ---- ----\n\n");
        notifyAll();
    }

    public synchronized void infectCountry() {
        while (isOpen) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("1 Interrupted");
            }
        }
        try {
            wait(getCountriesInfectionTime());
            System.out.println(getCountriesInfectionTime());
        } catch (InterruptedException ignore) {}
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
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setPeopleInfectionTime(int peopleInfectionTime) {
        this.peopleInfectionTime = peopleInfectionTime;
    }

    public void setCountriesInfectionTime(int countriesInfectionTime) {
        this.countriesInfectionTime = countriesInfectionTime;
    }

    public int getPeopleInfectionTime() {
        return peopleInfectionTime;
    }


    public int getCountriesInfectionTime() {
        return countriesInfectionTime;
    }

    public int getNumberOfInfectedPeople() {
        return numberOfInfectedPeople;
    }


    public static double getRecoveringConstant() {
        return recoveringConstant;
    }

    public static void setRecoveringConstant(double recoveringConstant) {
        Mode.recoveringConstant = recoveringConstant;
    }

    public static int getInfectedPerDay() {
        return infectedPerDay;
    }

    public static int getRecoveredPerDay() {
        return recoveredPerDay;
    }

    public static void setInfectedPerDay(int infectedPerDay) {
        Mode.infectedPerDay = infectedPerDay;
    }

    public static void setRecoveredPerDay(int recoveredPerDay) {
        Mode.recoveredPerDay = recoveredPerDay;
    }

}
