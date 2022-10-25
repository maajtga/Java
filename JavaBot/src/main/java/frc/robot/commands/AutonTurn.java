// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutonTurn extends CommandBase {
  
  private final DriveSubsystem m_subsystem;

  private final float m_angle;
  private final float m_high = 0.50f;
  private final float m_low = 0.10f;

  private float m_currentAngle;

  public AutonTurn(DriveSubsystem subsystem, float angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_subsystem = subsystem;
    m_angle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    m_subsystem.setBothMotors(0);

    m_subsystem.resetGyro();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    m_currentAngle = m_angle - (float)m_subsystem.getAngle(); // m_subsystem.m_gyro.getAngle();

    if (m_currentAngle > 50) 
    {
      // m_subsystem.setRightMotor(m_high);
      // m_subsystem.setLeftMotor(-m_high);
      m_subsystem.setBothMotors(m_high, -m_high);
    }

    else if (m_currentAngle < -50) 
    {
      // m_subsystem.setRightMotor(-m_high);
      // m_subsystem.setLeftMotor(m_high); 
      m_subsystem.setBothMotors(-m_high, m_high);
    }

    else if (m_currentAngle > 10)
    {
      // m_subsystem.setRightMotor(m_low);
      // m_subsystem.setLeftMotor(-m_low);
      m_subsystem.setBothMotors(m_low, -m_low);
    }
    else if (m_currentAngle < -10)
    {
     // m_subsystem.setRightMotor(-m_low);
     // m_subsystem.setLeftMotor(m_low);
      m_subsystem.setBothMotors(-m_low, m_low);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    m_subsystem.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_subsystem.getAngle() <= 10 && m_subsystem.getAngle() >= -10);
  }
}
