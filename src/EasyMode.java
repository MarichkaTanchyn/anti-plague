public class EasyMode extends Mode {


    EasyMode() {
        super();
        periodOfInfection();
        int countriesInfectedTime = 2000; // 20000
        setCountriesInfectionTime(countriesInfectedTime);
        int period = 1000; // 15000
        setPeriod(period);
        int peopleInfectionTime = 10000;
        setPeopleInfectionTime(peopleInfectionTime);
        setRecoveringConstant(0.1);
        setInfectedPerDay(10);

    }
}