public class EasyMode extends Mode {
    EasyMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(10000);
        setPeriod(7500);
        setPeopleInfectionTime(10000);
        setRecoveringConstant(0.2);
        setInfectedPerDay(15);

    }
}