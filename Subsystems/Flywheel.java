package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Bot;
import org.firstinspires.ftc.teamcode.Constants;

public class Flywheel extends SubsystemBase {
    //instance stuff
    //makes sure theres only once isntance (or object) of the class active (we dont want two duplicate objects)
    //instead of Flywheel wheel = new Flywheel() we would use Flywheel wheel = Flywheel.getInstance()
    private static Flywheel instance = null;

    //gets current instance, if not already made, make one
    public static synchronized Flywheel getInstance() {
        if (instance == null) instance = new Flywheel();
        return instance;
    }
    //^remember to make these static

    //motor used
    DcMotorEx wheel;

    //constructor that links it to the global hardware map
    public Flywheel() {
        wheel = Constants.hardwareMap.get(DcMotorEx.class, "wheely");
    }

    //set voltage
    //instead of power, which will change the velocity based on the robot's current battery power
    //we use this simple math equation to maintain consistent velocity
    //velocity to voltage is linear however varies depending on motor's gear ratio and wheel sizes
    public void setVoltage(double voltage) {
        wheel.setPower(voltage/Bot.getCurVoltage());
    }

    //stop method
    public void stop() {
        setVoltage(0);
    }

    //only while loop you will get
    @Override
    public void periodic() {

    }


}
