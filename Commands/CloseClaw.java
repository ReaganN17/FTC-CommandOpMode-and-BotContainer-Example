package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.SimpleClaw;

//command to close claw
public class CloseClaw extends CommandBase {
    //system we use
    SimpleClaw claw = SimpleClaw.getInstance();

    //constructor
    public CloseClaw() {

    }

    //initialization (runs once)
    @Override
    public void initialize() {

    }

    //execute (loop)
    @Override
    public void execute() {
        claw.close();
    }

    //end (runs once)
    @Override
    public void end(boolean interrupted) {
        claw.open();
    }

    //condition that ends the commands (doesn't have to)
    @Override
    public boolean isFinished() {
        return false;
    }

}
