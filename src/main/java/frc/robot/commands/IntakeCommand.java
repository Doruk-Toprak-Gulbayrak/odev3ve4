// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends Command {
  /** Creates a new IntakeCommand. */
  Intake m_intake;
  double m_speed;
  Intake m_feeder;
  double f_speed;


  public IntakeCommand(Intake intake, double speed,Intake feeder, double dspeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_intake = intake;
    this.m_speed = speed;
    addRequirements(m_intake);
    this.m_feeder = feeder;
    this.f_speed = dspeed;
    addRequirements(m_feeder);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.setIntake(m_speed);
    m_feeder.setIntake(f_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.mIntakeMotor.stopMotor();
    m_feeder.mIntakeMotor.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    
  }
}
