// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterLauncherSubsystem;

public class ControllerShooterLauncherCommand extends CommandBase {
  /** Creates a new ControllerShooterLaungerCommand. */
  public double mod = 0;
  Timer timer = new Timer();
  public ControllerShooterLauncherCommand() {
    addRequirements(RobotContainer.m_ShooterLaunchSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_ShooterLaunchSubsystem.shooterOne.configVoltageCompSaturation(12.4);
    RobotContainer.m_ShooterLaunchSubsystem.shooterOne.enableVoltageCompensation(true);
    timer.start();
    SmartDashboard.putNumber("Shooter Speed", RobotContainer.m_ShooterLaunchSubsystem.shooterOne.getSelectedSensorVelocity());
    //SmartDashboard.putBoolean("In Low Range?", DriveSubsystem.ultrasonic.getRangeInches() > 10 && DriveSubsystem.ultrasonic.getRangeInches() < 33);
    SmartDashboard.putBoolean("Ultrasonic Enabled?", DriveSubsystem.ultrasonic.isEnabled());
    SmartDashboard.putNumber("Ultrasonic Number", DriveSubsystem.ultrasonic.getRangeInches());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_xboxController.getYButton()) {
      timer.reset();
    }

    if (timer.get() < 3.0) {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.3 + mod);
    } else if (RobotContainer.m_flightStick.getRawButton(8)) {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.55 + mod);
    } else if (RobotContainer.m_flightStick.getRawButton(10)) {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.8 + mod);
    } else {
      RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0);
    }
    if (RobotContainer.m_flightStick.getRawButtonPressed(7)||RobotContainer.m_flightStick.getRawButtonPressed(8)||RobotContainer.m_flightStick.getRawButtonPressed(10)) {
      mod = 0;
    } else if (RobotContainer.m_flightStick.getRawButtonPressed(11)) {
      mod = mod - 0.05;
    } else if (RobotContainer.m_flightStick.getRawButtonPressed(12)) {
      mod = mod + 0.05;
    }
  
   // "Is Shooter at Speed?", RobotContainer.m_ShooterLaunchSubsystem.shooterOne.getSelectedSensorVelocity() <= -12000
    SmartDashboard.putNumber("Shooter Speed", RobotContainer.m_ShooterLaunchSubsystem.shooterOne.getSelectedSensorVelocity());
   // SmartDashboard.putBoolean("In Low Range?", DriveSubsystem.ultrasonic.getRangeInches() > 10 && DriveSubsystem.ultrasonic.getRangeInches() < 33);
    SmartDashboard.putBoolean("Ultrasonic Enabled?", DriveSubsystem.ultrasonic.isEnabled()); 
    SmartDashboard.putNumber("Ultrasonic Number", DriveSubsystem.ultrasonic.getEchoChannel());

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

