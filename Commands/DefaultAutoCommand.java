package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

public class DefaultAutoCommand extends SequentialCommandGroup {

    //i made this half asleep
    public DefaultAutoCommand() {
        //sequence based on time
        addCommands(
                new RunFlywheel(5).withTimeout(500),
                new CloseClaw().withTimeout(500)
        );

        //again very underwhelming because of simplicity example
        //but i would highly encourage looking up other command group types in ftc
    }



}
