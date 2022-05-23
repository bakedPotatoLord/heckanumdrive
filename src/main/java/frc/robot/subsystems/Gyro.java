package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyro extends SubsystemBase{

  AnalogGyro m_gyro = new AnalogGyro(0);

  public Gyro() {
    m_gyro.calibrate();
      
  }
    
}

