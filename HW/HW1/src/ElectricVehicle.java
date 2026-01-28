/**
 * Represents an Electric Vehicle (EV) that tracks battery characteristics
 * and calculates range based on environmental factors.
 */
public class ElectricVehicle {
    /**
     * Constructs an ElectricVehicle with specific constraints and clamping.
     * * @param name The name of the EV. Cannot be null or empty.
     * @param batterySize The capacity in kWh. Clamped between 10.0 and 150.0.
     * @param stateOfCharge The decimal percentage (0.15 to 1.0). Clamped accordingly.
     * @param defaultEfficiency The rated efficiency. Clamped between 0.5 and 4.5.
     */
    private String name;//the name of the EV
    private double batterySize;//kilowatt-hours (kWh)
    private double stateOfCharge;//range from 0.15 to 1.0
    private double currentEfficiency;//change to weather condition
    private final double defaultEfficiency;


    public ElectricVehicle(String name, double batterySize, double stateOfCharge, double defaultEfficiency) {
        //name: can not be empty or null
        if (name == null || name.isEmpty()) {
            this.name = "unknown EV";
        } else {
            this.name = name;
        }

        //batterySize: clamping (10.0 - 150.0)
        if (batterySize < 10.0) {
            this.batterySize = 10.0;
        } else if (batterySize > 150.0) {
            this.batterySize = 150.0;
        } else {
            this.batterySize = batterySize;
        }

        //default efficiency: clamping (0.5 - 4.5)
        if (defaultEfficiency < 0.5) {
            this.defaultEfficiency = 0.5;
        } else if (defaultEfficiency > 4.5) {
            this.defaultEfficiency = 4.5;
        } else {
            this.defaultEfficiency = defaultEfficiency;
        }

        //initialization of current efficiency
        this.currentEfficiency = this.defaultEfficiency;

        //state of charge: use the setter to do the clamping
        this.setStateOfCharge(stateOfCharge);
    }

    /**
     * Calculates the current driving range of the vehicle.
     * * @return The estimated range computed as: current efficiency * state of charge * battery size.
     */
    public double range() {
        return this.currentEfficiency * this.stateOfCharge * this.batterySize;
    }

    /**
     * Updates the vehicle's efficiency based on the outside temperature.
     * Efficiency remains 100% between 65F and 77F, drops to 85% above 77F,
     * and decreases by 1% per degree below 65F (capped at 50% reduction).
     * * @param currentTemp The current temperature in Fahrenheit.
     */
    public void updateEfficiency(double currentTemp) {
        if (currentTemp >= 65.0 && currentTemp <= 77.0) {
            this.currentEfficiency = this.defaultEfficiency;
        } else if (currentTemp > 77.0) {
            this.currentEfficiency = this.defaultEfficiency * 0.85;
        } else {
            double degreeBelow = 65.0 - currentTemp;
            double reductionPercent = degreeBelow * 0.01;
            if (reductionPercent > 0.50) {
                reductionPercent = 0.50;
            }
            this.currentEfficiency = this.defaultEfficiency * (1.0 - reductionPercent);

        }
    }


    public String getName() {
        return this.name;
    }
    public double getBatterySize(){
        return this.batterySize;
    }
    public double getStateOfCharge(){
        return this.stateOfCharge;
    }
    public double getEfficiency() {
        return this.currentEfficiency;
    }

    /**
     * Sets a new State of Charge (SoC) for the vehicle.
     * * @param stateOfCharge The new SoC as a decimal. Clamped between 0.15 and 1.0.
     */
    public void setStateOfCharge(double stateOfCharge) {
        if (stateOfCharge < 0.15) {
            this.stateOfCharge = 0.15;
        } else if (stateOfCharge > 1.0) {
            this.stateOfCharge = 1.0;
        } else {
            this.stateOfCharge = stateOfCharge;
        }
    }
    /**
     * Returns a string representation of the EV including name, SoC percentage, and range.
     * Format: "Name SOC: 00.0% Range (miles): 00.0"
     * * @return A formatted string describing the vehicle state.
     */
    @Override
    public String toString () {
        double socPercent = this.stateOfCharge * 100;
        return String.format("%s SOC: %.1f%% Range (miles): %.1f", this.name, socPercent, this.range() );
    }
}
