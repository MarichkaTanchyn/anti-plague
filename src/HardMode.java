public class HardMode extends Mode {
    HardMode() {
        super();
        periodOfInfection();
        int countriesInfectedTime = 15000;
        setCountriesInfectionTime(countriesInfectedTime);
        int period = 10000;
        setPeriod(period);
        int peopleInfectionTime = 5000;
        setPeopleInfectionTime(peopleInfectionTime);

        setRecoveringConstant(0.05);
        setInfectedPerDay(50);
    }
}