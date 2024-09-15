package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;

import org.firstinspires.ftc.teamcode.Constants;

public class SimpleClaw extends SubsystemBase {
    //instance stuff (explained more in fly wheel)
    private static SimpleClaw instance = null;
    public static synchronized SimpleClaw getInstance() {
        if (instance == null) { instance = new SimpleClaw();}
        return instance;
    }

    //motors used
    ServoEx right, left;

    //constructor, links motors to hardware map
    public SimpleClaw() {
        right = Constants.hardwareMap.get(ServoEx.class, "Right Claw");
        left = Constants.hardwareMap.get(ServoEx.class, "Left Claw");
    }

    //methods
    public void open() {
        right.setPosition(50);
        left.setPosition(-50);
    }

    public void close() {
        right.setPosition(0);
        left.setPosition(0);
    }

    public void set(double pos) {
        right.setPosition(pos);
        left.setPosition(pos);
    }


}
