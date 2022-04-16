// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubystem. */
  public static CANSparkMax leftOne = new CANSparkMax(Constants.LEFT_MOTOR_1, MotorType.kBrushless);
  public static CANSparkMax leftTwo = new CANSparkMax(Constants.LEFT_MOTOR_2, MotorType.kBrushless);
  public static RelativeEncoder leftEncoder = leftTwo.getEncoder();
  public static MotorControllerGroup leftDrive = new MotorControllerGroup(leftOne, leftTwo);

  public static PIDController pidOne = new PIDController(0, 0, 0);
  public static double errorSum;
  public static double lastTimestamp;
  public static double error;
  public static double lastError;

  public static CANSparkMax rightOne = new CANSparkMax(Constants.RIGHT_MOTOR_1, MotorType.kBrushless);
  public static CANSparkMax rightTwo = new CANSparkMax(Constants.RIGHT_MOTOR_2, MotorType.kBrushless);
  
  public static RelativeEncoder rightEncoder = rightOne.getEncoder();
  public static MotorControllerGroup rightDrive = new MotorControllerGroup(rightOne, rightTwo);

  public static DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

  public static Ultrasonic ultrasonic = new Ultrasonic(Constants.ULTRASONIC_PING, Constants.ULTRASONIC_ECHO);
  
  public DriveSubsystem() {
    leftOne.setOpenLoopRampRate(1);
    leftOne.setClosedLoopRampRate(1);
    leftTwo.setOpenLoopRampRate(1);
    leftTwo.setClosedLoopRampRate(1);
    rightOne.setOpenLoopRampRate(1);
    rightOne.setClosedLoopRampRate(1);
    rightTwo.setOpenLoopRampRate(1);
    rightTwo.setClosedLoopRampRate(1);
    drive.setSafetyEnabled(false);
    Ultrasonic.setAutomaticMode(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
