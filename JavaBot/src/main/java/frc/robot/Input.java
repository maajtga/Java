// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Input extends SubsystemBase {
  
  private static XboxController Controller = new XboxController(Constants.XBOX_PORT);
  //private static Joystick joyLeft = new Joystick(Constants.JOYSTICK_PORT_LEFT);
  //private static Joystick joyRight = new Joystick(Constants.JOYSTICK_PORT_RIGHT);
  
  //public static double getJoystickLeftY()
  //{
  //  return (Math.abs(joyLeft.getY()) < Constants.JOYSTICK_LEFT_DEADZONE_Y ? 0: joyLeft.getY());
  //}
  
  //public static double getJoystickRightY()
  //{
  // return (Math.abs(joyRight.getY()) < Constants.JOYSTICK_RIGHT_DEADZONE_Y ? 0: joyRight.getY());
  //}

  public static boolean getButtonA() 
  {
    return Controller.getAButton();
  }

  public static boolean getButtonB() 
  {
    return Controller.getBButton();
  }

  public static boolean getButtonX() 
  {
    return Controller.getXButton();
  }

  public static boolean getButtonY() 
  {
    return Controller.getYButton();
  }

  public static boolean getRightBumperPressed()
  {
    return Controller.getRightBumperPressed();
  }

  public static boolean getLeftBumperPressed() {
    return Controller.getLeftBumperPressed();
  }

  public static double getRightAxisX() {
    return Controller.getRightX();
  }

  public static double getRightAxisY() {
    return Controller.getRightY();
  }

  public static double getLeftAxisX() {
    return Controller.getLeftX();
  }

  public static double getLeftAxisY() {
    return Controller.getLeftY();
  }

  /** Creates a new Input. */
  public Input() {}

}
