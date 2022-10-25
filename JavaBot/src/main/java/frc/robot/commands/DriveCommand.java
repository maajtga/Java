package frc.robot.commands;


import frc.robot.Constants;
import frc.robot.Input;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  
    private final DriveSubsystem m_subsystem;

    public DriveCommand(DriveSubsystem subsystem) {
      m_subsystem = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {
      m_subsystem.setBothMotors(0);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      //m_subsystem.setRightMotor(Input.getRightAxisX());
      //m_subsystem.setLeftMotor(Input.getJoystickLeftY());
      m_subsystem.RLDrive(Input.getRightTriggerAxis(), Input.setDeadzone(Input.getLeftAxisX(), Constants.JOYSTICK_LEFT_DEADZONE_X));
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
      return false;
    }
}
