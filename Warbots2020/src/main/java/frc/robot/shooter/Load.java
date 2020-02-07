/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class Load extends CommandBase
{
  private final Shooter shooter; 

  /**
   * Creates a new Load.
   *
   * @param Shooter The subsystem used by this command.
   */
  public Load(Shooter s) 
  {
    shooter = s;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    this.withTimeout(Constants.ShooterConstants.loaderTimeout);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
   {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}   