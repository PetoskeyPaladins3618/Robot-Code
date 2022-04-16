// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX; //USE THIS DURING THE REAL THING
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterLauncherSubsystem extends SubsystemBase {
  /** Creates a new ShooterLaunchSubsystem. */
  public TalonFX shooterOne = new TalonFX(Constants.SHOOTER_LAUNCH_WHEEL_1);
 

  // public TalonFX shooterMotor = new TalonFX(Constants.SHOOTER_LAUNCH_WHEEL_1); //USE THIS FOR THE REAL THING

  public void spinMethod(double speed) {
    shooterOne.set(ControlMode.PercentOutput, -speed);
  }


  public ShooterLauncherSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
