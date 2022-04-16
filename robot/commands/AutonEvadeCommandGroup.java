// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonEvadeCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonEvadeCommandGroup. */
  public AutonEvadeCommandGroup() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoMoveBackwardPIDCommand(30));
    addCommands(new StartShooterCommand(0.25, 0.55));
    addCommands(new AutoShooterFeederCommand(0.3, 5));
    addCommands(new AutoMoveForwardPIDCommand(30));
  }
}
