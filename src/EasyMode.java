public class EasyMode extends Mode {
    EasyMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(1000);
        setPeriod(2000);
        setPeopleInfectionTime(1000);
        setRecoveringConstant(0.2);
        setInfectedPerDay(15);

    }
}