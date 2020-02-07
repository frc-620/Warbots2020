/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class Enable extends CommandBase
{
  private final Shooter shooter;
  private final double targetVelocity;
  /**
   * Creates a new Enable.
   *
   * @param Shooter The subsystem used by this command.
   */
  public Enable(Shooter s, double speed) 
  {
    shooter = s;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    targetVelocity = speed;
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
    shooter.setShootSpeed(targetVelocity);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    //TODO: Schedule blinglights
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return Math.abs(shooter.flyWheelSpeed() - targetVelocity) < Constants.ShooterConstants.spinRateTolerance;
  }
}   