import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class InfectionProcess extends Timer {

    private HashMap<Integer, Countries> infected;
    private HashMap<Integer, Countries> notInfected;
    private int speedOfInfection;
    private int numberOfCountries;
    private int speedOfSpreading;
    private InfectionProcess address;
    private Countries country;
    private int numberOfPeople;
    private int numberOfInfectedPeople;
    private int numberOfRecoveredPeople;



    InfectionProcess() {
        infected = new HashMap<>();
        notInfected = new HashMap<>();
        address = this;
        speedOfInfection = 100;
        speedOfSpreading = 200;
        numberOfInfectedPeople = 0;
        numberOfRecoveredPeople = 0;
        notInfected.put(1, new China(200));
        notInfected.put(2, new Ukraine(440));
        notInfected.put(3, new USA(300));
        notInfected.put(4, new Belarus(500));
        notInfected.put(5, new Russia(100));
        notInfected.put(6, new Canada(700));
        notInfected.put(7, new France(300));
        notInfected.put(8, new Greenland(100));
        notInfected.put(9, new Italy(400));
        notInfected.put(10, new Japan(400));
        notInfected.put(11, new Africa(300));
        notInfected.put(12, new Australia(100));
        notInfected.put(13, new Poland(300));
        notInfected.put(14, new Spain(500));
        notInfected.put(15, new Lithuania(120));

        numberOfPeople = 0;
        for (int i = 1; i <= notInfected.size(); i++) {
            numberOfPeople += notInfected.get(i).getNumberOfPeople();
        }

        numberOfCountries = notInfected.size();
        notInfected.get(1).startInfection(this);
        Thread thread;
        while (true) {
            if (numberOfPeople > numberOfInfectedPeople) {
                synchronized (this) {
                    thread = new Thread(() -> {
                        synchronized (this) {
                            try {
                                Thread.sleep(speedOfSpreading);
                                infected.forEach((k, v) -> {
                                    v.infectPeople();
                                    numberOfInfectedPeople+=10;
                                });
                                Thread.currentThread().interrupt();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                });
                    thread.start();
                }
            } else break;

            if (!notInfected.isEmpty()) {
                synchronized (this) {
                    thread = new Thread(() -> {
                        synchronized (this) {
                            try {
                                Thread.sleep(speedOfInfection);
                            } catch (InterruptedException e) {

                            }
                            boolean isOk = false;
                            int i = 1;
                            while (!isOk) {
                                if (!infected.containsKey(i)) isOk = true;
                                else i = (int) (1 + Math.random() * numberOfCountries);
                            }
                            country = notInfected.get(i);
                            country.startInfection(address);
                            Thread.currentThread().interrupt();
                        }
                    });

                    thread.start();
                }
            }
        }
        System.out.println("HELLO");
    }

    public HashMap<Integer, Countries> getInfected() {
        return infected;
    }

    public HashMap<Integer, Countries> getNotInfected() {
        return notInfected;
    }
}
