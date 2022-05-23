// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

//import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  
  private final CANSparkMax m_fl = new CANSparkMax(5,MotorType.kBrushed);
  private final CANSparkMax m_rl = new CANSparkMax(6,MotorType.kBrushed);
  private final CANSparkMax m_fr = new CANSparkMax(7,MotorType.kBrushed);
  private final CANSparkMax m_rr = new CANSparkMax(8,MotorType.kBrushed);

  private final MecanumDrive m_drive;
  
  public DriveBase() {

    m_fr.setInverted(true);
    m_rr.setInverted(true);
    m_drive = new MecanumDrive(m_fl,m_rl,m_fr,m_rr);
  }

  public void driveCartesian(double y,double x,double z){
    Double yd=MathUtil.applyDeadband(y, 0.1);
    Double xd=MathUtil.applyDeadband(x, 0.1);
    Double zd=MathUtil.applyDeadband(z, 0.25);

    m_drive.driveCartesian(yd, -xd, -zd, 0.0);
  }
}
