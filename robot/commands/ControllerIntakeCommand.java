// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ControllerIntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  public ControllerIntakeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_IntakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_xboxController.getLeftTriggerAxis() >= 0.25) {
      IntakeSubsystem.intakeWheel.set(ControlMode.PercentOutput, (RobotContainer.m_xboxController.getLeftTriggerAxis() - 0.25) * 0.75);
    } else if (RobotContainer.m_xboxController.getRightTriggerAxis() >= 0.25) {
      IntakeSubsystem.intakeWheel.set(ControlMode.PercentOutput, (RobotContainer.m_xboxController.getRightTriggerAxis() - 0.25) * -0.75);
    } else {
      IntakeSubsystem.intakeWheel.set(ControlMode.PercentOutput, 0);
    }

    if (RobotContainer.m_xboxController.getLeftBumperPressed()) {
      IntakeSubsystem.intakeDown.set(Value.kForward);
      IntakeSubsystem.intakeArm.set(Value.kForward);
    } else if (RobotContainer.m_xboxController.getLeftBumperReleased()) {
      IntakeSubsystem.intakeDown.set(Value.kReverse);
    } else if (RobotContainer.m_xboxController.getRightBumperPressed()) {
      IntakeSubsystem.intakeArm.set(Value.kReverse);
      IntakeSubsystem.intakeDown.set(Value.kForward);
    } else if (RobotContainer.m_xboxController.getRightBumperReleased()) {
      IntakeSubsystem.intakeDown.set(Value.kReverse);
    }

    /*
    if (RobotContainer.m_flightStick.getRawButton(3)) {
      IntakeSubsystem.intakeDown.set(Value.kForward);
    } else if (RobotContainer.m_flightStick.getRawButton(4)) {
      IntakeSubsystem.intakeDown.set(Value.kReverse);
    }
    */


  }

  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
