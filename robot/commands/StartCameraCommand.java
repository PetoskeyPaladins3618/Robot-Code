// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class StartCameraCommand extends CommandBase {
  /** Creates a new StartCameraCommand. */
  public StartCameraCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);
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
