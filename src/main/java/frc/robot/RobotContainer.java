// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.nio.channels.Channel;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.DigitalInput;

public class RobotContainer {
  Intake intake = new Intake();
  Intake feeder = new Intake();
  PS5Controller mDrivController = new PS5Controller(0);
  

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    
  }

  /**
   * 
   */
  private void configureBindings() {
    boolean intakedy ;
    boolean feeddy ;
    DigitalInput intakingcommand = new DigitalInput(0);
    DigitalInput feedingcommand = new DigitalInput(1);
    
    intakedy = intakingcommand.get();
    feeddy = feedingcommand.get();
    

   while (intakedy) {
    new JoystickButton(mDrivController, 1).whileTrue(new IntakeCommand(intake, 0, feeder,0.7));
    new JoystickButton(mDrivController, 2).whileTrue(new IntakeCommand(intake, 0,feeder, -0.7));
   }
    while (feeddy) {
    new JoystickButton(mDrivController, 1).whileTrue(new IntakeCommand(intake, 1, feeder,0));
    new JoystickButton(mDrivController, 2).whileTrue(new IntakeCommand(intake, -1,feeder, 0));
   }


   
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
