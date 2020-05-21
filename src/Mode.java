import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class Mode {

    private HashMap<Integer, Country> infected;
    private HashMap<Integer, Country> notInfected;

    private int countriesInfectionTime;
    private int numberOfCountries;
    private int peopleInfectionTime;
    private Mode address;
    private Country country;
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
        notInfected.put(1, new Country("China",200));
        notInfected.put(2, new Country("Ukraine",440));
        notInfected.put(3, new Country("USA",300));
        notInfected.put(4, new Country("Belarus",500));
        notInfected.put(5, new Country("Russia",100));
        notInfected.put(6, new Country("Canada",700));
        notInfected.put(7, new Country("France",300));
        notInfected.put(8, new Country("Greenland",100));
        notInfected.put(9, new Country("Italy",400));
        notInfected.put(10, new Country("Japan",400));
        notInfected.put(11, new Country("Africa",300));
        notInfected.put(12, new Country("Australia",300));
        notInfected.put(13, new Country("Poland",300));
        notInfected.put(14, new Country("Spain",500));
        notInfected.put(15, new Country("Lithuania",120));


        numberOfPeople = 0;
        for (int i = 1; i <= notInfected.size(); i++) {
            numberOfPeople += notInfected.get(i).getNumberOfPeople();
        }

        numberOfCountries = notInfected.size();
    }

    public HashMap<Integer, Country> getInfected() {
        return infected;
    }

    public HashMap<Integer, Country> getNotInfected() {
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
                ShowGame.setNumberOfInfected(numberOfInfectedPeople);
                ShowGame.getNumberOfInfectedPeople().setText("Currently infected People - " + ShowGame.getNumberOfInfected() + "/" + numberOfPeople);

//                Recovering people
                if (!ShowGame.getArrayListOfUpdates().isEmpty()){
                    v.recoverPeople();
                    numberOfRecoveredPeople += recoveredPerDay;
                    System.out.println("Recovered:         (" + k + ") " + v.getClass() + ": " + v.getNumberOfRecovered() + "/" + v.getNumberOfPeople());

                }

                ShowGame.getNumberOfRecoveredPeople().setText("Currently recovered People - " + numberOfRecoveredPeople + "/" +  numberOfInfectedPeople);

                System.out.println("Infected :         (" + k + ") " + v.getClass() + ": " + v.getNumberOfInfected() + "/" + v.getNumberOfPeople());
            }
        });
        if (numberOfRecoveredPeople >= numberOfInfectedPeople) {
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
