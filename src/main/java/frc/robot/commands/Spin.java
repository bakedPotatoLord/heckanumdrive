// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;



/** An example command that uses an example subsystem. */
public class Spin extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveBase m_driveBase;

  Timer spinTimer = new Timer();
  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Spin(DriveBase subsystem) {
    m_driveBase = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    spinTimer.reset();
    spinTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
		m_driveBase.driveCartesian(0, 0, 1,1); 
	}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spinTimer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (spinTimer.get() >= 2); 
  }
}
