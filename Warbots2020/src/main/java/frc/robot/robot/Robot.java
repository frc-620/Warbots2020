/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.loader.Load;
import frc.robot.loader.TestLoad;
import frc.robot.shooter.*;

public class Robot extends TimedRobot 
{
  private Command autonomousCommand;
  private RobotContainer robotContainer;

  //region Overrides
  @Override
  public void robotInit() 
  {
    robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() 
  {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit()
  {
    autonomousCommand = robotContainer.getAutonomousCommand();

    if (autonomousCommand != null) 
      autonomousCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() 
  {
  }

  @Override
  public void teleopInit() 
  {
    if(autonomousCommand != null) autonomousCommand.cancel();
    //var load = new TestLoad(robotContainer.loader);
    //load.schedule();
  }

  @Override
  public void testInit()
  {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }
  //endregion

  //region Unused Overrides
  @Override
  public void disabledInit() 
  {
  }

  @Override
  public void disabledPeriodic() 
  {
  }
  
  @Override
  public void teleopPeriodic() 
  {
    //robotContainer.shooter.shooter.set(ControlMode.PercentOutput, .25);
  }

  @Override
  public void testPeriodic() 
  {
  }
  //endregion
}