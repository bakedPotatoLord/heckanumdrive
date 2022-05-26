// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveBase m_driveBase = new DriveBase();
  private final FRCGyro m_gyro = new FRCGyro();

  private final Alert sayHello = new Alert();
  private final Spin spin = new Spin(m_driveBase);
  private final DriveForward driveForward = new DriveForward(m_driveBase);

  private final Joystick stick = new Joystick(0);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_driveBase.setDefaultCommand(
      new RunCommand(
        () ->
          m_driveBase.driveCartesian(stick.getY(), stick.getX(),stick.getZ(), ((-stick.getThrottle())+1.7)/2.7),
        m_driveBase));

    m_gyro.setDefaultCommand(
      new RunCommand(
        () ->
          SmartDashboard.putNumber("gyroAngle", m_gyro.getAngle()),
        m_gyro));
  

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(stick, 1).whenPressed(sayHello);

    new JoystickButton(stick, 2).whenPressed(spin);

    new JoystickButton(stick, 3).whenPressed(driveForward);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand().andThen(
      ()->System.out.println("action 0")
    ).andThen(
      ()->System.out.println("action 1")
    );
  }
}
