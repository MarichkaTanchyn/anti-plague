public class MediumMode extends Mode {
    MediumMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(17000);
        setPeriod(13000);
        setPeopleInfectionTime(7000);
        setRecoveringConstant(0.08);
        setInfectedPerDay(25);
    }
}