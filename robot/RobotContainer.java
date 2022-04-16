// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoDownIntakeCommand;
import frc.robot.commands.AutoIntakeCommand;
import frc.robot.commands.AutoMoveBackwardCommand;
import frc.robot.commands.AutoMoveBackwardPIDCommand;
import frc.robot.commands.AutoMoveBackwardPIDLONGCommand;
import frc.robot.commands.AutoMoveForwardCommand;
import frc.robot.commands.AutoMoveForwardPIDCommand;
import frc.robot.commands.AutoMoveForwardPIDLONGCommand;
import frc.robot.commands.AutoMoveLongAndIntakeParalellCommandGroup;
import frc.robot.commands.AutoShootOneBallCommand;
import frc.robot.commands.AutoShootTwoBallsCommand;
import frc.robot.commands.AutoShooterFeederCommand;
import frc.robot.commands.AutoTurnLeftCommand;
import frc.robot.commands.AutoTurnLeftPIDCommand;
import frc.robot.commands.AutoTurnRightCommand;
import frc.robot.commands.AutoTurnRightPIDCommand;
import frc.robot.commands.AutoUpIntakeCommand;
import frc.robot.commands.AutonEvadeCommandGroup;
import frc.robot.commands.AutonomousPathFiveCommandGroup;
import frc.robot.commands.AutonomousPathFourCommandGroup;
import frc.robot.commands.AutonomousPathOneCommandGroup;
import frc.robot.commands.AutonomousPathThreeCommandGroup;
import frc.robot.commands.AutonomousPathTwoCommandGroup;
import frc.robot.commands.ControllerClimbCommand;
import frc.robot.commands.ControllerDriveCommand;
import frc.robot.commands.ControllerIntakeCommand;
import frc.robot.commands.ControllerShooterFeederCommand;
import frc.robot.commands.ControllerShooterLauncherCommand;
import frc.robot.commands.StartAutonCommand;
import frc.robot.commands.StartShooterCommand;
import frc.robot.commands.StopTimeCommand;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterFeederSubsystem;
import frc.robot.subsystems.ShooterLauncherSubsystem;
import frc.robot.subsystems.USB0Camera;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // examples:

  //subsystems:
  public static final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  public static final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();
  public static final ShooterLauncherSubsystem m_ShooterLaunchSubsystem = new ShooterLauncherSubsystem();
  public static final ShooterFeederSubsystem m_ShooterFeederSubsystem = new ShooterFeederSubsystem();
  public static final ClimbSubsystem m_ClimbSubsystem = new ClimbSubsystem();
  public static final CameraSubsystem m_CameraSubsystem = new CameraSubsystem();

  //Commands for teleop:
  public ControllerDriveCommand m_controllerDriveCommand = new ControllerDriveCommand();
  public ControllerIntakeCommand m_controllerIntakeCommand = new ControllerIntakeCommand();
  public ControllerShooterFeederCommand m_controllerShooterFeederCommand = new ControllerShooterFeederCommand();
  public ControllerShooterLauncherCommand m_controllerShooterLauncherCommand = new ControllerShooterLauncherCommand();
  public ControllerClimbCommand m_ControllerClimbCommand = new ControllerClimbCommand();

  //Movement commands for Autonomous:
  public AutoMoveForwardCommand m_AutoMoveForwardCommand = new AutoMoveForwardCommand();
  public AutoMoveBackwardCommand m_AutoMoveBackwardCommand = new AutoMoveBackwardCommand();
  public AutoTurnRightCommand m_AutoMoveTurnRightCommand = new AutoTurnRightCommand();
  public AutoTurnLeftCommand m_AutoMoveTurnLeftCommand =new AutoTurnLeftCommand();
  public AutoMoveForwardPIDCommand m_AutoMoveForwardPIDCommand = new AutoMoveForwardPIDCommand();
  public AutoMoveBackwardPIDCommand m_AutoMoveBackwardPIDComand = new AutoMoveBackwardPIDCommand();
  public AutoTurnLeftPIDCommand m_AutoTurnLeftPIDCommand = new AutoTurnLeftPIDCommand();
  public AutoTurnRightPIDCommand m_AutoTurnRightPIDCommand = new AutoTurnRightPIDCommand();
  // public AutoMoveArcCommand m_AutoMoveArcCommand = new AutoMoveArcCommand();
  public AutoMoveBackwardPIDLONGCommand m_AutoMoveBackwardPIDLONGCommand = new AutoMoveBackwardPIDLONGCommand();
  public AutoMoveForwardPIDLONGCommand m_AutoMoveForwardPIDLONGCommand = new AutoMoveForwardPIDLONGCommand();

  public StartAutonCommand m_StartAutonCommand = new StartAutonCommand();

  //Intake command for Autonomous:
  public AutoIntakeCommand m_IntakeCommand = new AutoIntakeCommand();
  public AutoDownIntakeCommand m_DownIntakeCommand = new AutoDownIntakeCommand();
  public AutoUpIntakeCommand m_AutoUpIntakeCommand = new AutoUpIntakeCommand();
  public AutoMoveLongAndIntakeParalellCommandGroup m_AutoMoveLongAndIntakeParalellCommandGroup = new AutoMoveLongAndIntakeParalellCommandGroup();

  //Shooter commands for Autonomous:
  public AutoShootTwoBallsCommand m_AutoShootTwoBallsCommand = new AutoShootTwoBallsCommand();
  public AutoShootOneBallCommand m_AutoShootOneBallCommand = new AutoShootOneBallCommand();
  public AutoShooterFeederCommand m_AutoShooterFeederCommand = new AutoShooterFeederCommand();
  public StartShooterCommand m_StartShooterCommand = new StartShooterCommand();
  
  //Command Groups for Autonomous:
  public AutonomousPathOneCommandGroup m_AutonomousPathOneCommandGroup = new AutonomousPathOneCommandGroup();
  public AutonomousPathTwoCommandGroup m_AutonomousPathTwoCommandGroup = new AutonomousPathTwoCommandGroup();
  public AutonomousPathThreeCommandGroup m_AutonomousPathThreeCommandGroup = new AutonomousPathThreeCommandGroup();
  public AutonomousPathFourCommandGroup m_AutonomousPathFourCommandGroup = new AutonomousPathFourCommandGroup();
  public AutonomousPathFiveCommandGroup m_AutonomousPathFiveCommandGroup = new AutonomousPathFiveCommandGroup();
  public AutonEvadeCommandGroup m_AutonEvadeCommandGroup = new AutonEvadeCommandGroup();

  public StopTimeCommand m_StopTimeCommand = new StopTimeCommand();
  //camera system
  public static final USB0Camera M_USB0CAMERA = new USB0Camera();
  

  //Controllers (Xbox Controller and Flight Stick)
  public static XboxController m_xboxController = new XboxController(0);
  public static Joystick m_flightStick = new Joystick(1);

  public static SendableChooser<Integer> m_autoChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_autoChooser.setDefaultOption("Autonomous One", 1);
    m_autoChooser.addOption("Autonomous Two", 2);
    m_autoChooser.addOption("Autonomous Three", 3);
    m_autoChooser.addOption("Autonomous Four", 4);
    m_autoChooser.addOption("Autonomous Five", 5);
    m_autoChooser.addOption("Autonomous Other", 6);
    SmartDashboard.putData("Autonomous Option Selected", m_autoChooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //JoystickButton leftTrigger = new JoystickButton(m_xboxController, Constants.LEFT_STICK_NUMBER);
    //leftTrigger.whenHeld(m_controllerIntakeCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    switch (Robot.AutonomousChosen) {
      case (1):
        return m_AutonomousPathOneCommandGroup;
      case (2):
        return m_AutonomousPathTwoCommandGroup;
      case (3): 
        return m_AutonomousPathThreeCommandGroup;
      case (4):
        return m_AutonomousPathFourCommandGroup;
      case (5):
        return m_AutonomousPathFiveCommandGroup;
      case (6):
        return m_AutonEvadeCommandGroup;
      default:
        return m_AutonomousPathThreeCommandGroup;
    }
    
  } //in here, place the command group you want to run in autonomous.
}
