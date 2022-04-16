// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousPathFourCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousPathFourCommandGroup. */
  public AutonomousPathFourCommandGroup() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(new AutoMoveBackwardPIDCommand(27.5)); 
    addCommands(new StartShooterCommand(1, 0.55));
    addCommands(new AutoShooterFeederCommand(0.3, 3));
    addCommands(new AutoMoveForwardPIDCommand(27.5));
    
    
    
    
    /*addCommands(new AutoDownIntakeCommand(0.75));
    addCommands(new AutoMoveBackwardPIDCommand(27.5));
    addCommands(new AutoIntakeCommand(0.5, 2));
    addCommands(new StartShooterCommand(0.25, 0.55));
    addCommands(new AutoMoveForwardPIDCommand(5));
    addCommands(new AutoTurnRightCommand(1, 0.4));
    addCommands(new AutoShooterFeederCommand(0.3, 3)); */
      //2 balls should be gone now.

      //Now it goes back to the original position.
   // addCommands(new AutoTurnLeftCommand(1, 0.4));
   // addCommands(new StartShooterCommand(0.25, 0)); //This sets the shooter to 0.
   // addCommands(new AutoMoveForwardPIDCommand(22.5));

      //Now it turns 90 degrees and picks up the next ball.
    //addCommands(new AutoTurnRightCommand(4, 0.4));
    //addCommands(new StopTimeCommand(0.25));
    //addCommands(new AutoMoveBackwardPIDCommand(50));

      //Now it goes back to the start position.
    //addCommands(new AutoIntakeCommand(0.5, 2));
    //addCommands(new AutoMoveForwardPIDCommand(50));
    //addCommands(new AutoTurnLeftCommand(4, 0.4));

      //Now it shoots the ball low.
    //addCommands(new StartShooterCommand(0.25, 0.20));
    //addCommands(new AutoMoveForwardPIDCommand(20));
    //addCommands(new AutoShooterFeederCommand(0.8, 2));


    //END OF PATH 1B

  }
}
