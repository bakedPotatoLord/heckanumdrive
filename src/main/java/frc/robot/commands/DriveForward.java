package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.*;

public class DriveForward extends WaitCommand {
    DriveBase driveBase;
    public DriveForward(DriveBase subsystem){
        super(2);
        
        driveBase = subsystem;
        addRequirements(driveBase);
    }

    @Override
    public void execute() {
 
        driveBase.driveCartesian(1,0,0,1);
    }
}
