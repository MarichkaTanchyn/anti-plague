public class EasyMode extends Mode {
    EasyMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(2000);
        setPeriod(1500);
        setPeopleInfectionTime(1000);
        setRecoveringConstant(0.1);
        setInfectedPerDay(10);

    }
}