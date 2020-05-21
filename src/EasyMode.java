public class EasyMode extends Mode {
    EasyMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(20000);
        setPeriod(15000);
        setPeopleInfectionTime(10000);
        setRecoveringConstant(0.1);
        setInfectedPerDay(10);

    }
}