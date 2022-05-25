package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FRCGyro extends SubsystemBase {

  AnalogGyro m_gyro = new AnalogGyro(0);

  public FRCGyro() {
    m_gyro.calibrate();
    
  }

  public double getAngle(){
    return m_gyro.getAngle();
  }


    
}

