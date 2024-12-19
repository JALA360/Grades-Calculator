public class Fan {
    private boolean isOn; // Fan's on/off state
    private int speed;    // Fan's speed (1 to 5)

    // Constructor
    public Fan() {
        isOn = false;   // Fan is off by default
        speed = 0;      // Speed is 0 when the fan is off
    }

    // Method to turn the fan on
    public void turnOn() {
        isOn = true;
        speed = 1;      // Default speed is 1 when the fan is turned on
    }

    // Method to turn the fan off
    public void turnOff() {
        isOn = false;
        speed = 0;
    }

    // Method to set the fan speed
    public void setSpeed(int newSpeed) {
        if (isOn && newSpeed >= 1 && newSpeed <= 5) {
            speed = newSpeed;
        } else if (!isOn) {
            System.out.println("Cannot set speed. The fan is off.");
        } else {
            System.out.println("Speed must be between 1 and 5.");
        }
    }

    // Method to check if the fan is on
    public boolean getFanIsOn() {
        return isOn;
    }

    // Method to get the current speed of the fan
    public int getSpeed() {
        return speed;
    }
}
