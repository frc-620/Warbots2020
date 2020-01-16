/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveTrain;

public class DriveDistance extends DriveCommand 
{
  //region Constructors
  public DriveDistance(DriveTrain dt, int distance) 
  {
    super(dt);
    distanceToTravel = distance;
  }
  //endregion

  //region Overrides
  @Override
  public void execute() 
  {
    driveTrain.arcadeInput(.5, 0);
  }

  @Override
  public boolean isFinished()
  {
    return driveTrain.distanceTraveled() > distanceToTravel;
  }
  //endregion

  //region Fields
  private final double distanceToTravel;
  //endregion
}