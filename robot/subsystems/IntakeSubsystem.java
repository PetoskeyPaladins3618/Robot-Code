// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
 public static TalonSRX intakeWheel = new TalonSRX(Constants.INTAKE_WHEEL_MOTOR);
 public static Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
 public static DoubleSolenoid intakeArm = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);
 public static DoubleSolenoid intakeDown = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
 
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
