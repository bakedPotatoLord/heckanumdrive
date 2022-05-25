package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class Alert extends CommandBase {
    public Alert(){
        System.out.println("trigger pressed");
    }

    public boolean isFinished() {
        return true;
    }
}
