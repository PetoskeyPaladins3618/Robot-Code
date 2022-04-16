// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoDownIntakeCommand extends CommandBase {
  /** Creates a new AutoDownIntakeCommand. */
  double time;
  Timer timer = new Timer();
  public AutoDownIntakeCommand(double t) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_IntakeSubsystem);
    time = t;
  }

  public AutoDownIntakeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_IntakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_IntakeSubsystem.intakeArm.set(Value.kForward);
    RobotContainer.m_IntakeSubsystem.intakeDown.set(Value.kForward);
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.reset();
    timer.stop();
    RobotContainer.m_IntakeSubsystem.intakeDown.set(Value.kReverse);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.hasElapsed(time));
  }
}
