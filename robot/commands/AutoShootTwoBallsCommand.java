// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class AutoShootTwoBallsCommand extends CommandBase {
  private boolean isDone = false;
  private int Counter = 0;
  boolean switchstate = true;
  int miniCounter = 0;

  

  /** Creates a new AutoShooterLaunchCommand. */
  public AutoShootTwoBallsCommand() {
    addRequirements(RobotContainer.m_ShooterLaunchSubsystem);
    addRequirements(RobotContainer.m_ShooterFeederSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(Counter){
      case 0: 
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0.2);
        if (RobotContainer.m_ShooterFeederSubsystem.limitSwitch.get()) {
          Counter = 1;
        }
      case 1:
      RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0);
        RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0.5);
        Timer.delay(2);
        Counter = 2;
      case 2:
        RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0.2);
        if(RobotContainer.m_ShooterFeederSubsystem.limitSwitch.get()!=switchstate) {
          switchstate = RobotContainer.m_ShooterFeederSubsystem.limitSwitch.get();
          miniCounter ++;
          if (miniCounter >= 3) {
            Counter ++;
          }
        }
      
      case 3:
        Timer.delay(3);
        RobotContainer.m_ShooterLaunchSubsystem.spinMethod(0);
        RobotContainer.m_ShooterFeederSubsystem.feeder.set(ControlMode.PercentOutput, 0.2);
        isDone = true;
    }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
