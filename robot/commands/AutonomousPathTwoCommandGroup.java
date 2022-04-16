// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathTwoCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathTwoCommandGroup. */
  public AutonomousPathTwoCommandGroup() {
    //PATH TWO: Starts between Paths 1 and 3, picks up 1 ball, pushes away 2 others

    addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoMoveBackwardPIDCommand(35));
    addCommands(new AutoIntakeCommand(0.5, 2));
    addCommands(new AutoTurnLeftCommand(1, 0.4));
    addCommands(new StartShooterCommand(2, 0.55));
    addCommands(new AutoShooterFeederCommand(0.25, 4));


    /*
    addCommands(new StartAutonCommand());
    addCommands(new AutoMoveBackwardPIDCommand(35));
    addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoTurnLeftPIDCommand(1.7, 0.2));
    addCommands(new AutoShooterFeederCommand(0.9, 1));
    addCommands(new AutoTurnRightPIDCommand(4.4, 0.2));
    addCommands(new StopTimeCommand(0.25));
    addCommands(new AutoMoveBackwardPIDLONGCommand(80));
    addCommands(new StopTimeCommand(0.5));
    addCommands(new AutoMoveForwardPIDLONGCommand(80));
    addCommands(new AutoTurnLeftPIDCommand(2.45, 0.2));
    addCommands(new AutoShooterFeederCommand(0.9, 1));
    */
// The problem is that the intake stays firmly down and pressurized.
// Adding a timer to StartAutonCommand that will release pressure after a certain time.

    /*
    addCommands(new AutoTurnRightPIDCommand(1, 0.1));
    addCommands(new StopTimeCommand(0.25));
    addCommands(new AutoMoveForwardPIDLONGCommand(120));
    addCommands(new AutoTurnLeftPIDCommand(7.5, 0.2));
    addCommands(new AutoShooterFeederCommand(0.9, 1));
  */
  }
}
