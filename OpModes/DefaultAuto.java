package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Bot;
import org.firstinspires.ftc.teamcode.Constants;

//autonomous file
//this one runs the default auto command from Bot container
@Autonomous(name = "Default")
public class DefaultAuto extends CommandOpMode {
    //robot class
    private Robot bot;

    //initialization, sets up the global constants
    @Override
    public void initialize() {
        Constants.hardwareMap = hardwareMap;
        Constants.telemetry = telemetry;
        Constants.pilot = new GamepadEx(gamepad1);
        Constants.copilot = new GamepadEx(gamepad2);

        //create bot according to mode
        bot = new Bot(Bot.OpMode.AUTO);
    }



}
