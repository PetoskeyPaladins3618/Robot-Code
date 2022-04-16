// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoShooterFeederCommand extends CommandBase {
  /** Creates a new AutoShooterFeederCommand. */
  double speed;
  int time;
  Timer timer = new Timer();
  public AutoShooterFeederCommand() {
    addRequirements(RobotContainer.m_ShooterFeederSubsystem);
  }

  public AutoShooterFeederCommand(double s, int t) {
    addRequirements(RobotContainer.m_ShooterFeederSubsystem);
    speed = s;
    time = t;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, -speed);
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.reset();
    timer.stop();
    RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(time);
  }
}
