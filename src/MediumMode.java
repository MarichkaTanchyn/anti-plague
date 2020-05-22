public class MediumMode extends Mode {
    MediumMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(12000);
        setPeriod(10000);
        setPeopleInfectionTime(10000);
        setRecoveringConstant(0.16);
        setInfectedPerDay(35);
    }
}