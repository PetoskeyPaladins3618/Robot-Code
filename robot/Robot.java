// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static RobotContainer m_robotContainer;
  public static Command m_autonomousCommand;
  public static int AutonomousChosen;
  public static UsbCamera cameraOne;
  public static UsbCamera cameraTwo;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    //cameraOne = CameraServer.startAutomaticCapture(0);
    //cameraOne.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
    //cameraTwo = CameraServer.startAutomaticCapture(1);
    //cameraTwo.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Left Encoder Value", RobotContainer.m_DriveSubsystem.leftEncoder.getPosition());
    SmartDashboard.putNumber("Right Encoder Value", RobotContainer.m_DriveSubsystem.rightEncoder.getPosition());
    AutonomousChosen = RobotContainer.m_autoChooser.getSelected();
    
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    RobotContainer.m_DriveSubsystem.leftEncoder.setPosition(0);
    RobotContainer.m_DriveSubsystem.rightEncoder.setPosition(0);
    m_autonomousCommand = m_robotContainer.getAutonomousCommand(); //look in RobotContainer for more instructions

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    //m_robotContainer.m_CameraCommand.schedule();
    //CameraServer.startAutomaticCapture();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    m_robotContainer.m_controllerDriveCommand.schedule();
    m_robotContainer.m_controllerIntakeCommand.schedule();
    m_robotContainer.m_controllerShooterFeederCommand.schedule();
    m_robotContainer.m_controllerShooterLauncherCommand.schedule();
    m_robotContainer.m_ControllerClimbCommand.schedule();

    //m_robotContainer.m_CameraCommand.schedule();
    
    //SmartDashboard.putData("PID Controller", RobotContainer.m_DriveSubsystem.pidOne);
  } //put teleop commands here

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
