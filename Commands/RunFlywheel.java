package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;

public class RunFlywheel extends CommandBase {
    //system
    private Flywheel wheel = Flywheel.getInstance();
    //voltage
    double voltage;

    //command constructor, set voltage
    public RunFlywheel(double vol) {
        //makes sure no other commands are running the same system
        addRequirements(wheel);

        voltage = vol;
    }

    //initiaize (runs once)
    @Override
    public void initialize() {

    }

    //execute (loop)
    @Override
    public void execute() {
        wheel.setVoltage(voltage);
    }

    //end (runs once)
    @Override
    public void end(boolean interrupted) {
        wheel.stop();
    }

    //condition that ends the commands (doesn't have to)
    @Override
    public boolean isFinished() {
        return false;
    }




}
