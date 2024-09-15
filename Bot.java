package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.Robot;

//configuration container for tele and auto modes
//rather than having individual procedures in the opmodes, we move them into here so its more consolidated
public class Bot extends Robot {
    //auto command that runs
    public Command autoCommand = null;
    //Bot conatiner
    public BotContainer container = null;
    //default auto or not
    boolean defaultAuto = true;

    //modes
    public enum OpMode {
        TELEOP, AUTO
    }

    //Tele Op and default auto constructor
    public Bot(OpMode opMode) {
        container = new BotContainer();

        switch (opMode) {
            case TELEOP: {
                initTele();
            } break;
            case AUTO: {
                initAuto();
            } break;
        }
    }

    //custom auto constructor
    public Bot(OpMode opMode, Command auto) {
        defaultAuto = false;
        autoCommand = auto;
    }

    //initialize teleOp, cancels current auto command if its running
    public void initTele() {
        if (autoCommand != null) {
            autoCommand.cancel();
        }
    }

    //initialize auto and schedules command
    public void initAuto() {
        //if default auto, grab default auto command from Bot Container
        if (defaultAuto) {
            autoCommand = container.getAutonomousCommand();
        }

        if (autoCommand != null) {
            autoCommand.schedule();
        }

    }

    //It made more sense to me to have a Bot.getCurVoltage() than Constants.getCurVoltage()
    //hence why i put it in here (its up to you)
    //just remember to make it static because its a global method we want to use (doesnt correlate to actual object made)
    public static double getCurVoltage() {
        return Constants.hardwareMap.voltageSensor.get("Motor Controller 1").getVoltage();
    }



}
