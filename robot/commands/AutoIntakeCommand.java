// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  public AutoIntakeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_IntakeSubsystem);
  }
  double speed;
  double time;
  Timer timer = new Timer();
  public AutoIntakeCommand(double s, double d) {
    addRequirements(RobotContainer.m_IntakeSubsystem);
    speed = s;
    time = d;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    IntakeSubsystem.intakeWheel.set(ControlMode.PercentOutput, -speed);
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
    IntakeSubsystem.intakeWheel.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.hasElapsed(time));
  }
}
