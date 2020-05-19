public class MediumMode extends Mode {
    MediumMode() {
        super();

        periodOfInfection();
        int countriesInfectedTime = 17000;
        setCountriesInfectionTime(countriesInfectedTime);
        int period = 13000;
        setPeriod(period);
        int peopleInfectionTime = 7000;
        setPeopleInfectionTime(peopleInfectionTime);

        setRecoveringConstant(0.08);
        setInfectedPerDay(25);
    }
}