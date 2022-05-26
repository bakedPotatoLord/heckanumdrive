package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.*;

public class Test extends WaitCommand {
    DriveBase driveBase;
    public Test(DriveBase subsystem){
        super(2);
        
        driveBase = subsystem;
        addRequirements(driveBase);
    }

    @Override
    public void execute() {
 
        driveBase.driveCartesian(0.5,0,0,1);
    }
}
