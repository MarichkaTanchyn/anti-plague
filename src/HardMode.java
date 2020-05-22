public class HardMode extends Mode {
    HardMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(9000);
        setPeriod(7000);
        setPeopleInfectionTime(9000);
        setRecoveringConstant(0.10);
        setInfectedPerDay(50);
    }
}