package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Bot;
import org.firstinspires.ftc.teamcode.Commands.CloseClaw;
import org.firstinspires.ftc.teamcode.Commands.RunFlywheel;
import org.firstinspires.ftc.teamcode.Constants;

//autonomous file
//this one runs the custom auto that i give it
@Autonomous (name = "Custom Auto")
public class MyAuto extends CommandOpMode {
    //robot
    private Robot bot;
    //custom command that i also made half alsspe
    private Command autoCommand = new SequentialCommandGroup(new RunFlywheel(5).withTimeout(50), new CloseClaw());

    @Override
    public void initialize() {
        Constants.hardwareMap = hardwareMap;
        Constants.telemetry = telemetry;
        Constants.pilot = new GamepadEx(gamepad1);
        Constants.copilot = new GamepadEx(gamepad2);

        //construction for custom auto command
        bot = new Bot(Bot.OpMode.AUTO, autoCommand);
    }
}
