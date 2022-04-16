// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterLauncherSubsystem;

public class StartShooterCommand extends CommandBase {
  /** Creates a new StartShooterCommand. */
  double time;
  double speed;
  public StartShooterCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public StartShooterCommand(double t, double s) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ShooterLaunchSubsystem);
    time = t;
    speed = s;
  }
  Timer timer = new Timer();

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    RobotContainer.m_ShooterLaunchSubsystem.shooterOne.set(ControlMode.PercentOutput, -speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.reset();
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(time);
  }
}
