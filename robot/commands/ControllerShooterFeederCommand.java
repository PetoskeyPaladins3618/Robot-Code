// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ControllerShooterFeederCommand extends CommandBase {
  /** Creates a new ShooterFeederControllerCommand. */
  public ControllerShooterFeederCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ShooterFeederSubsystem);
  }
  
  Timer timer = new Timer();

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (RobotContainer.m_xboxController.getYButtonPressed()) {
      timer.reset();
    }

    if (!RobotContainer.m_ShooterFeederSubsystem.limitSwitch.get() && !RobotContainer.m_flightStick.getTrigger() && (timer.get() > 3.0 || timer.get() < 0.5)) {
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0);
    } else if (timer.get() > 0.5 && timer.get() < 3.0) {
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, -0.8);
    } else {
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, -0.4);
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
}
