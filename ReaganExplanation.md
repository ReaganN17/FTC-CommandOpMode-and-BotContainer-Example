reagan's explanation of thigns (not good probably)

LinearOpMode is simple for basic java, its runs a while loop and contains if statements for gamepad, similiar to gameloops in basic code.org type games
CommandOpMode instead is all initialization for setup configuration, ie creating gamebutton binds to commands
Its better for the use of commands as its more condensed and organized
No actual while loops, however there is a default 'public void periodic()' method in subsystem classes
that always run when the robot runs, so do you what you want (efficiently in there)

Similiarly like LinearOpMode, your opmode classes TeleOp and Autonomous are still the main ones being called and used
however unlike LinearOpMode, instead of individual functions in each class, 
we create a singular bot class to do all those things, its better for condensing.

Important notes

Constants class 
 - remember how we had hardware map in the constructor as a parameter, well its better to keep it a global variable for this one
 - HardwareMap, Telemetry, and your two GamepadEx classes are the four main global objects used throughout your code (you can definitely add more)
 - they are kept null (because they dont exist yet until the bot is turned on) until the CommandOpMode and its initialization method is ran (then connect)

CommandOpMode is the main file used
 - initialization method
   - just connects your Constants class such has hardwareMap and telemetry to the actual hardware map and telemetry so they can be used
 - literally nothing else except creating the bot class with a config

Bot class contains all your setup for autonomous and teleop
 - Initialization for auto and tele
   - Small thing: you can also use subsystems in here as well for initialization purposes (remember that hardwareMap is already declared, no worry for null)
 - Constructor to change robot initizliation based on OpMode given
 - Auto Command Schedule for autonomous
 - Bot Container for TeleOp (more info right here)

Bot Container contains all your commands used for TeleOp
 - default commands, commands that run when a subsystem used by the command is not being used
 - configure bindings, connects gamepad buttons to do commands based on their state
   - no need for an if statement to constantly run, just link it and it will be used
 - default autonomous command, if you dont have a custom command for auto, just grab the default from here (definitely optional now that im thinking about it)

Commands
 - init, loop, end, isFinished are the four main parts of the command
 - constructor is used not just for creating the command but also putting optional custom inputs in the command if we want to run differently based on different inputs
 - multiple commands may run that use the same subsystem, to make sure only one runs, "addRequirements(mySubsystem)" is needed in the constructor for every subsystem used
   - note that command groups may not need this if the commands used already have it

Subsystem Instances
 - Instead of creating a new subsystem everytime we want to use it, we want to keep a subsystem the same when we use it in commands
 - In each subsystem, we create a static Subsystem of itself to keep global to be used anywhere (furthur explaiend in Flywheel)
 - Instead of a claw class that we would normally do "Claw thisclaw = new Claw()" we would do instead "Claw thisclaw = Claw.getInstance()"


hey see that custom button in BotConatiner, I dare you guys to make your own custom GamepadEx class with all the buttons to use instead of Constants.pilot
