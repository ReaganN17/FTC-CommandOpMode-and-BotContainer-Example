package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Commands.CloseClaw;
import org.firstinspires.ftc.teamcode.Commands.DefaultAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.RunFlywheel;
import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Subsystems.SimpleClaw;

public class BotContainer {
    //systems of teh robot
    Flywheel wheel = Flywheel.getInstance();
    SimpleClaw claw = SimpleClaw.getInstance();
    //gamepad
    GamepadEx pilot = Constants.pilot;
    GamepadEx copilot = Constants.copilot;

    //create button
    Button x = new GamepadButton(pilot, GamepadKeys.Button.X);

    //construct
    public BotContainer() {
        setDefaultCommands();
        configBindings();
    }

    //sets default commands
    //when these subsystems are not being used, they run on this command
    public void setDefaultCommands() {
        //basic setup
        claw.setDefaultCommand(new CloseClaw());

        //lambda expression for when you dont want to make a whole command class
        wheel.setDefaultCommand(new RunCommand((()-> wheel.stop()), wheel));
    }

    //link gamepad buttons and controlls to commnads
    public void configBindings() {
        //basic setup
        pilot.getGamepadButton(GamepadKeys.Button.X).whenPressed(new RunFlywheel(5));

        //to avoid doing all that "getGamepadButton...) we can instead create a button to do that
        //(i made the button above constructor)
        //(another example of lambda expression cause i didnt want to make another command)
        x.whenHeld(new RunCommand((() -> claw.open()), claw), false);
        //^ the extra boolean put afterwards is optional (you dont have to add the extra parameter)
        //makes the command override other commands that try to use the same subsystem
        //good for priority commands

        //Key difference between whenPressed and whenHeld
        //whenPressed does not end the command itself when the button is no longer pressed
        //another command created using the same subsystem would have to be shceduled (whenReleased also exists)
        //whenHeld ends the command itself when it is no longer pressed
    }

    //default auto command
    public Command getAutonomousCommand() {
        return new DefaultAutoCommand();
    }
}
