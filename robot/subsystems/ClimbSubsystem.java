// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {

  public int maxEncoderCounts = 400; //used to be 350, but was too far at like 299, added 50 to 350.

  public DoubleSolenoid climbPivot = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  public CANSparkMax climbLeft = new CANSparkMax(Constants.LEFT_CLIMB_MOTOR, MotorType.kBrushless);
  public RelativeEncoder climbLeftEncoder = climbLeft.getEncoder();
  public CANSparkMax climbRight = new CANSparkMax(Constants.RIGHT_CLIMB_MOTOR, MotorType.kBrushless);
  public RelativeEncoder climbRightEncoder = climbRight.getEncoder();


  public DigitalInput leftSwitch = new DigitalInput(Constants.LEFT_CLIMB_SWITCH);
  public DigitalInput rightSwitch = new DigitalInput(Constants.RIGHT_CLIMB_SWITCH);

  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // The person who made the above text is a loser and a communist
  }

}
