// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterFeederSubsystem extends SubsystemBase {
  /** Creates a new ShooterFeederCommand. */
  public ShooterFeederSubsystem() {}

  public int isRunning;
  public TalonSRX feeder = new TalonSRX(Constants.SHOOTER_FEEDER_MOTOR);
  public DigitalInput limitSwitch = new DigitalInput(Constants.SHOOTER_LIMIT_SWITCH);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
