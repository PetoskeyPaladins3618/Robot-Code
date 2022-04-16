// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ControllerClimbCommand extends CommandBase {
  /** Creates a new ControllerClimbCommand. */
  public ControllerClimbCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ClimbSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_ClimbSubsystem.climbRightEncoder.setPosition(0);
    RobotContainer.m_ClimbSubsystem.climbLeftEncoder.setPosition(0);
  }
  boolean buttonPressedMethod (int CapitalismSucks) {
    return RobotContainer.m_flightStick.getRawButton(CapitalismSucks);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int Button = 7;

    boolean isFivePressed = RobotContainer.m_flightStick.getRawButton(5);
    boolean isSixPressed = RobotContainer.m_flightStick.getRawButton(6);
    boolean isButtonPressed = buttonPressedMethod(Button);

    
    if (RobotContainer.m_flightStick.getPOV() == -1) {
      if (buttonPressedMethod(6) && RobotContainer.m_ClimbSubsystem.climbLeftEncoder.getPosition() > -RobotContainer.m_ClimbSubsystem.maxEncoderCounts) {
        RobotContainer.m_ClimbSubsystem.climbLeft.set(-1);
      } else if (buttonPressedMethod(4) && RobotContainer.m_ClimbSubsystem.leftSwitch.get()) {
        RobotContainer.m_ClimbSubsystem.climbLeft.set(1);
      } else {
        RobotContainer.m_ClimbSubsystem.climbLeft.set(0);
      }
      if (buttonPressedMethod(5) && RobotContainer.m_ClimbSubsystem.climbRightEncoder.getPosition() < RobotContainer.m_ClimbSubsystem.maxEncoderCounts) {
        RobotContainer.m_ClimbSubsystem.climbRight.set(1);
      } else if (buttonPressedMethod(3) && RobotContainer.m_ClimbSubsystem.rightSwitch.get()) {
        RobotContainer.m_ClimbSubsystem.climbRight.set(-1);
      } else {
        RobotContainer.m_ClimbSubsystem.climbRight.set(0);
      }
    } else {
      if (RobotContainer.m_flightStick.getPOV() == 0) {
        if (RobotContainer.m_ClimbSubsystem.climbRightEncoder.getPosition() >= RobotContainer.m_ClimbSubsystem.maxEncoderCounts) {
          RobotContainer.m_ClimbSubsystem.climbRight.set(0);
        } else {
          RobotContainer.m_ClimbSubsystem.climbRight.set(1);
        }
        if (RobotContainer.m_ClimbSubsystem.climbLeftEncoder.getPosition() < -RobotContainer.m_ClimbSubsystem.maxEncoderCounts) {
          RobotContainer.m_ClimbSubsystem.climbLeft.set(0);
        } else {
          RobotContainer.m_ClimbSubsystem.climbLeft.set(-1);
        }
      } else if (RobotContainer.m_flightStick.getPOV() == 180) {
         if (RobotContainer.m_ClimbSubsystem.rightSwitch.get()) {
          RobotContainer.m_ClimbSubsystem.climbRight.set(0);
        } else {
          RobotContainer.m_ClimbSubsystem.climbRight.set(-0.9);
        }
        if (RobotContainer.m_ClimbSubsystem.leftSwitch.get()) {
          RobotContainer.m_ClimbSubsystem.climbLeft.set(0);
        } else {
          RobotContainer.m_ClimbSubsystem.climbLeft.set(0.9);
        }
      } else {
        RobotContainer.m_ClimbSubsystem.climbLeft.set(0);
        RobotContainer.m_ClimbSubsystem.climbRight.set(0);
      }
    }
    //insert "move both" here


    if (RobotContainer.m_flightStick.getRawAxis(3) > 0) {
      RobotContainer.m_ClimbSubsystem.climbPivot.set(Value.kForward);
    } else {
      RobotContainer.m_ClimbSubsystem.climbPivot.set(Value.kReverse);
    }

    SmartDashboard.putNumber("Pivot Value", RobotContainer.m_flightStick.getRawAxis(3));
    SmartDashboard.putNumber("Left Climb Encoder Value", RobotContainer.m_ClimbSubsystem.climbLeftEncoder.getPosition());
    SmartDashboard.putNumber("Right Climb Encoder Value", RobotContainer.m_ClimbSubsystem.climbRightEncoder.getPosition());
    SmartDashboard.putNumber("POV Value", RobotContainer.m_flightStick.getPOV());
    if (RobotContainer.m_ClimbSubsystem.leftSwitch.get()) {
      SmartDashboard.putString("Left Pressed?", "True");
    } else {
      SmartDashboard.putString("Left Pressed?", "False");
    }
    if (RobotContainer.m_ClimbSubsystem.rightSwitch.get()) {
      SmartDashboard.putString("Right Pressed?", "True");
    } else {
      SmartDashboard.putString("Right Pressed?", "False");
    }
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  // hahahahahahahahahahahahahaha I have control over the code you fools
}
