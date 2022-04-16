// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathFiveCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathFiveCommandGroup. */
  public AutonomousPathFiveCommandGroup() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoMoveBackwardPIDCommand(35));
    addCommands(new AutoIntakeCommand(0.5, 2));
    addCommands(new AutoTurnLeftCommand(1, 0.4));
    addCommands(new StartShooterCommand(2, 0.55));


    addCommands(new AutoShooterFeederCommand(0.4, 3));
    addCommands(new AutoTurnRightPIDCommand(4.4, 0.2));
    addCommands(new StartShooterCommand(0.25, 0));


    //addCommands(new AutoMoveBackwardPIDLONGCommand(80));
    //addCommands(new AutoIntakeCommand(0.55, 1.5));


    //addCommands(new AutoMoveForwardPIDLONGCommand(80));
    //addCommands(new StartShooterCommand(0.25, 0.55));
    //addCommands(new AutoTurnLeftPIDCommand(2.45, 0.2));
    //addCommands(new AutoShooterFeederCommand(0.7, 1));

  }
}

//25 encoder counts = 45.5 inches
