// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterLauncherSubsystem;

public class StartAutonCommand extends CommandBase {
  /** Creates a new StartAutonCommand. */
  public StartAutonCommand() {
    addRequirements(RobotContainer.m_ShooterLaunchSubsystem);
    addRequirements(RobotContainer.m_IntakeSubsystem);
  }

  
  Timer timer = new Timer();

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    IntakeSubsystem.intakeArm.set(Value.kForward);
    IntakeSubsystem.intakeDown.set(Value.kForward);
    IntakeSubsystem.intakeWheel.set(ControlMode.PercentOutput, 0.6);    
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
    IntakeSubsystem.intakeDown.set(Value.kReverse);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.hasElapsed(0.75));
  }
}
