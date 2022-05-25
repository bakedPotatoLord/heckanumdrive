package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.InstantCommand;




public class Alert extends InstantCommand {

    public Alert() {
        super(
            ()->System.out.println("trigger pressed")
            );

    }

}
