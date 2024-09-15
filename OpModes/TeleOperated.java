package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bot;
import org.firstinspires.ftc.teamcode.Constants;

//main thing that is ran for TeleOp
@TeleOp(name = "Toaster")
public class TeleOperated extends CommandOpMode {
    //robot
    private Robot bot;

    @Override
    public void initialize() {
        //sets the global variables to the given variables by CommandOpMode
        Constants.hardwareMap = hardwareMap;
        Constants.telemetry = telemetry;
        Constants.pilot = new GamepadEx(gamepad1);
        Constants.copilot = new GamepadEx(gamepad2);

        //creates new bot to TeleOp configuration
        bot = new Bot(Bot.OpMode.TELEOP);
    }

}
