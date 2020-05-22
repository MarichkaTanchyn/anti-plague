public class MediumMode extends Mode {
    MediumMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(3000);
        setPeriod(1500);
        setPeopleInfectionTime(1500);
        setRecoveringConstant(0.08);
        setInfectedPerDay(25);
    }
}