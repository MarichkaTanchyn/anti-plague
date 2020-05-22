public class EasyMode extends Mode {
    EasyMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(4000);
        setPeriod(1500);
        setPeopleInfectionTime(2000);
        setRecoveringConstant(0.1);
        setInfectedPerDay(10);

    }
}