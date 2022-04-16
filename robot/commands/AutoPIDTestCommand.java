// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class AutoPIDTestCommand extends CommandBase {
  /** Creates a new AutoPIDForwardCommand. */
  private double goalOne;
  public AutoPIDTestCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
  }
  double dt;
  double robotSpeed;
  double errorRate;

  //REMEMBER THESE:
  //LEFT ENCODER VALUES GO UP WHEN IT SPINS IN THE DIRECTION OF THE INTAKE.
  //RIGHT ENCODER VALUES GO UP WHEN IT SPINS IN THE DIRECTION OF THE LAUNCHER.

  public AutoPIDTestCommand(double a) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveSubsystem);
    goalOne = a;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveSubsystem.leftEncoder.setPosition(0);
    DriveSubsystem.rightEncoder.setPosition(0);
    DriveSubsystem.pidOne.setSetpoint(goalOne);
    DriveSubsystem.rightDrive.setInverted(true);

    DriveSubsystem.pidOne.setP(1/goalOne);
    DriveSubsystem.pidOne.setI(0);
    DriveSubsystem.pidOne.setD(0);

    SmartDashboard.putNumber("P value", 1/goalOne);

    DriveSubsystem.errorSum = 0;
    DriveSubsystem.lastTimestamp = Timer.getFPGATimestamp();
    errorRate = 0;
    DriveSubsystem.lastError = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("PID Calculation", DriveSubsystem.pidOne.calculate(DriveSubsystem.leftEncoder.getPosition(), goalOne));
    SmartDashboard.putNumber("Motor Speed", DriveSubsystem.leftOne.get());

    dt = Timer.getFPGATimestamp() - DriveSubsystem.lastTimestamp;
    DriveSubsystem.error = goalOne - DriveSubsystem.leftEncoder.getPosition();
    if (Math.abs(DriveSubsystem.leftEncoder.getPosition() - goalOne) < Math.abs(goalOne/3)) {
      DriveSubsystem.errorSum += DriveSubsystem.error * dt;
      errorRate = (DriveSubsystem.error - DriveSubsystem.lastError) / dt;
    }

    robotSpeed = DriveSubsystem.pidOne.getP() * DriveSubsystem.error + DriveSubsystem.pidOne.getI() * DriveSubsystem.errorSum + DriveSubsystem.pidOne.getD() * errorRate;

    DriveSubsystem.drive.arcadeDrive(robotSpeed, 0);

    DriveSubsystem.lastError = DriveSubsystem.error;
    DriveSubsystem.lastTimestamp = Timer.getFPGATimestamp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.leftDrive.set(0);
    DriveSubsystem.rightDrive.set(0);
    DriveSubsystem.leftEncoder.setPosition(0);
    DriveSubsystem.rightEncoder.setPosition(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  //  return (DriveSubsystem.pidOne.atSetpoint());
  return false;
  }
}
