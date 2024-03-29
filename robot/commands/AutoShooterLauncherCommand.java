// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoShooterLauncherCommand extends CommandBase {
  /** Creates a new AutoShooterLauncherCommand. */
  double speed;
  int time;
  Timer timer = new Timer();

  public AutoShooterLauncherCommand() {
    addRequirements(RobotContainer.m_ShooterLaunchSubsystem);
  }

  public AutoShooterLauncherCommand(double s, int t) {
    speed = s;
    time = t;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    RobotContainer.m_ShooterLaunchSubsystem.shooterOne.set(ControlMode.PercentOutput, -speed);
    //RobotContainer.m_ShooterLaunchSubsystem.shooterOne.set(ControlMode.Velocity, [something]);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.reset();
    timer.stop();
    RobotContainer.m_ShooterLaunchSubsystem.shooterOne.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(time);
  }
}
