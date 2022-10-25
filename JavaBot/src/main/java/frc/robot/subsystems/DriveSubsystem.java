// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private TalonSRX talonLeft, talonRight;
  private VictorSPX[] victorsLeft, victorsRight;
  private AnalogGyro m_gyro;
  
    /** Creates a new DriveSubsystem. */
  public DriveSubsystem() 
  {
    
    m_gyro.calibrate();
    
    talonLeft = new TalonSRX(Constants.MOTOR_PORTS_LEFT[0]);
    talonRight = new TalonSRX(Constants.MOTOR_PORTS_RIGHT[0]);
 
    talonLeft.configFactoryDefault();
    talonRight.configFactoryDefault();
 
    talonLeft.setInverted(Constants.LEFT_INVERTED);
    talonRight.setInverted(Constants.RIGHT_INVERTED);
    
 
    talonLeft.configOpenloopRamp(Constants.RAMP_RATE);
    talonRight.configOpenloopRamp(Constants.RAMP_RATE);
  
    victorsLeft = new VictorSPX[Constants.MOTOR_PORTS_LEFT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_LEFT.length; i++) {
      victorsLeft[i-1] = new VictorSPX(Constants.MOTOR_PORTS_LEFT[i]);
      victorsLeft[i-1].configFactoryDefault();
      victorsLeft[i-1].follow(talonLeft);
      victorsLeft[i-1].setInverted(Constants.LEFT_INVERTED);
    }
 
    victorsRight = new VictorSPX[Constants.MOTOR_PORTS_RIGHT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_RIGHT.length; i++) {
      victorsRight[i-1] = new VictorSPX(Constants.MOTOR_PORTS_RIGHT[i]);
      victorsRight[i-1].configFactoryDefault();
      victorsRight[i-1].follow(talonRight);
      victorsRight[i-1].setInverted(Constants.RIGHT_INVERTED);
    }

  }
  
  public void setRightMotor(double speed) 
  {
    talonRight.set(ControlMode.PercentOutput, speed);
  }

  public void setLeftMotor(double speed) 
  {
    talonLeft.set(ControlMode.PercentOutput, speed);
  }

  public void setBothMotors(double speed) 
  {
    setRightMotor(speed);
    setLeftMotor(speed);
  }
  
  public void setBothMotors(double right_speed, double left_speed) 
  {
    setRightMotor(right_speed);
    setLeftMotor(left_speed);
  }
  
  public double getAngle() 
  {
    return m_gyro.getAngle();
  }

  public void resetGyro() 
  {
    m_gyro.reset();
  }

// DRIVE SYSTEMS/TRAINS ///

  public void RLDrive(double fSpeed, double tSpeed) {
    // Curve throttle speed????? // FIGURE THIS OUT LATER //
    fSpeed = Math.pow(fSpeed, 3);

    // Calculate turn power
    double turnPower = tSpeed * fSpeed;

    double rPower = fSpeed - turnPower;
    double lPower = fSpeed + turnPower;

    setBothMotors(rPower, lPower);
  }

  public void TankDrive(double rSpeed, double lSpeed) {
    setBothMotors(rSpeed, lSpeed);
  }

  public void ArcadeDrive(double fSpeed, double tSpeed) {
    setRightMotor(fSpeed - tSpeed);
    setLeftMotor(fSpeed + tSpeed);
  }

///////////////////////////

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
