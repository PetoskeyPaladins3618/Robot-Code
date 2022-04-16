// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathOneCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathOneCommandGroup. */
  public AutonomousPathOneCommandGroup() {
    //PATH ONE: Grabs 5 balls, starts closest to the opposing alliance's hub
    //addCommands(new AutoDownIntakeCommand());

   addCommands(new StopTimeCommand(5));
   addCommands(new StartShooterCommand(2, 0.3));
   addCommands(new AutoShooterFeederCommand(0.3, 2));
   addCommands(new AutoMoveBackwardPIDCommand(27.5));
    

   
   
   
   
    /* addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoMoveBackwardPIDCommand(27.5));
    addCommands(new AutoIntakeCommand(0.5, 2));
    addCommands(new StartShooterCommand(0.25, 0.55));
    addCommands(new AutoShooterFeederCommand(0.3, 3)); */
    
    

    /*
    addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoMoveBackwardPIDCommand(27.5));
    addCommands(new AutoIntakeCommand(0.5, 2));
    addCommands(new AutoUpIntakeCommand(0.75));
    addCommands(new AutoTurnLeftCommand(1, 0.4));
    addCommands(new StartShooterCommand(2));
    addCommands(new AutoShooterFeederCommand(0.3, 4));
    */

    /*
    addCommands(new AutoDownIntakeCommand(0.5));
    addCommands(new MoveIntakeCommandGroup(20, 2));
    addCommands(new AutoUpIntakeCommand(1));
    addCommands(new AutoTurnRightPIDCommand(1, 0.05));
    addCommands(new FeedAndShootParallelCommandGroup(2));
    addCommands(new AutoTurnRightPIDCommand(10, 0.2));
    addCommands(new AutoDownIntakeCommand(0.5));
    addCommands(new MoveIntakeCommandGroup(50, 4));
    addCommands(new AutoUpIntakeCommand(1));
    addCommands(new AutoTurnLeftPIDCommand(5, 0.1));
    addCommands(new AutoMoveForwardPIDCommand(10));
    addCommands(new FeedAndShootParallelCommandGroup(2));
    */
  }
}
