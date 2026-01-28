import static org.junit.jupiter.api.Assertions.*;

class ElectricVehicleTest {
    private ElectricVehicle testCar;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testCar = new ElectricVehicle("Tesla Model Y", 75.0, 0.5, 4.0);
    }

    /**
     * Tests the range calculation to ensure the mathematical formula
     * is applied correctly with current attributes.
     */
    @org.junit.jupiter.api.Test
    void range() {
        double expectedRange = 4.0 * 0.5 * 75;
        assertEquals(expectedRange, testCar.range(), 0.001);
    }

    /**
     * Verifies that updateEfficiency correctly mutates the efficiency
     * value across various temperature thresholds (hot, ideal, cold).
     */
    @org.junit.jupiter.api.Test
    void updateEfficiency() {
        //1. test the normal temperature
        testCar.updateEfficiency(70.0);
        assertEquals(4.0, testCar.getEfficiency(), 0.001);
        //2. test the high temperature
        testCar.updateEfficiency(80.0);
        assertEquals(4.0 * 0.85, testCar.getEfficiency(), 0.001);
        //3. test the low temperature
        testCar.updateEfficiency(64);
        assertEquals(4.0 * 0.99, testCar.getEfficiency(),0.001);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        //normal value
        assertEquals("Tesla Model Y", testCar.getName());
        //abnormal value: empty string
        ElectricVehicle emptyCarName = new ElectricVehicle("", 75.0, 0.5, 4.0);
        assertEquals("unknown EV", emptyCarName.getName());
        //abnormal value: null
        ElectricVehicle nullNameCar = new ElectricVehicle(null, 75.0, 0.5, 4.0);
        assertEquals("unknown EV", nullNameCar.getName());
    }

    @org.junit.jupiter.api.Test
    void getBatterySize() {
        //normal value
        assertEquals(75.0, testCar.getBatterySize(), 0.001);

        //testing clamping
        ElectricVehicle bigCar = new ElectricVehicle("Big Truck", 200.0, 0.5, 0.4);
        assertEquals(150, bigCar.getBatterySize(), 0.001);

    }

    @org.junit.jupiter.api.Test
    void getStateOfCharge() {
        //test the clamping for extreme low value(< 0.15)
        ElectricVehicle lowCar = new ElectricVehicle("Low", 50.0, 0.05, 3.0);
        assertEquals(0.15, lowCar.getStateOfCharge(), 0.001);
        //test the clamping for extreme high value(> 1.0)
        ElectricVehicle highCar = new ElectricVehicle("High", 50.0, 1.5, 3.0);
        assertEquals(1.0, highCar.getStateOfCharge(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void getEfficiency() {
        //test the high temperature
        testCar.updateEfficiency(80.0);
        assertEquals(3.4, testCar.getEfficiency(), 0.001);
        //test the low temperature
        testCar.updateEfficiency(60);
        assertEquals(3.8, testCar.getEfficiency(), 0.001);
        //test the extreme low temperature
        testCar.updateEfficiency(14);
        assertEquals(2.0, testCar.getEfficiency(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void setStateOfCharge() {
        //test the normal value
        testCar.setStateOfCharge(0.8);
        assertEquals(0.8, testCar.getStateOfCharge(), 0.001);
        //test the low value
        testCar.setStateOfCharge(0.05);
        assertEquals(0.15, testCar.getStateOfCharge(), 0.001);
        //test the high value
        testCar.setStateOfCharge(1.5);
        assertEquals(1.0, testCar.getStateOfCharge(), 0.001);
    }

    /**
     * Confirms that the toString method returns a string exactly
     * matching the required format and precision.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        ElectricVehicle ford = new ElectricVehicle("Ford MachE", 65.9, 0.5, 4.0);
        String expected = "Ford MachE SOC: 50.0% Range (miles): 131.8";
        assertEquals(expected, ford.toString());
    }
}