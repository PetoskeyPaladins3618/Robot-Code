// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathThreeCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathThreeCommandGroup. */
  public AutonomousPathThreeCommandGroup() {
    //PATH THREE: Picks up 1-2 balls, pushes 1-2 away, starts closest to own alliance's terminal
    addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoMoveBackwardPIDCommand(33));
    addCommands(new AutoIntakeCommand(0.5, 2));
    addCommands(new AutoTurnLeftCommand(2, 0.5));
    addCommands(new StartShooterCommand(3, 0.55));
    addCommands(new AutoShooterFeederCommand(0.25, 4));
  }
}

//25 encoder counts = 45.5 inches
