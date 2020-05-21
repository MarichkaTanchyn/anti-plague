public class HardMode extends Mode {
    HardMode() {
        super();
        periodOfInfection();
        setCountriesInfectionTime(15000);
        setPeriod(10000);
        setPeopleInfectionTime(5000);
        setRecoveringConstant(0.05);
        setInfectedPerDay(50);
    }
}