/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.dashboard;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.bling.*;
import frc.robot.robot.Robot;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.FlyWheel;
import frc.robot.vision.*;

public class Update extends CommandBase {

    private DriveTrain train;
    private Climber climb;
    private FlyWheel wheel;
    private Shooter shoot;
    private PowerDistributionPanel p;

    public Update(Dashboard dashboard, DriveTrain drivetrain, Climber climber, FlyWheel flyWheel, Intake intake,
            Shooter shooter, Bling bling, Vision vision) {
        addRequirements(dashboard);
        train = drivetrain;
        climb = climber;
        wheel = flyWheel;
        shoot = shooter;
        
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(climber);
        SmartDashboard.putData(flyWheel);
        SmartDashboard.putData(intake);
        SmartDashboard.putData(shooter);
        SmartDashboard.putData(bling);
        SmartDashboard.putData(vision);

        p = new PowerDistributionPanel();
        //Create shuffleboardtabs
        //getTab creates the tab if it does not already exist

        //shows the motor temp out of 100 in Shuffleboard tab 'drive'
        
        /**
         * TODO
         * update drive camera
         * battery voltage
         * flywheel speed
         * ball loaded sensor
         * gyro angle
         * elevation and yaw to target
         */
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    //Update all entries in the Shuffleboard, just like in the constructor

    public void execute() {
        //updates motor temperature in the drive tab
        Shuffleboard.getTab("Drive").add("Motor Temperature", 100).withWidget(BuiltInWidgets.kDial).getEntry().setDouble(train.getAvgMotorTemp());
        Shuffleboard.getTab("Drive").add("Gyro", 360).withWidget(BuiltInWidgets.kGyro).getEntry().setDouble(train.getYaw());
        Shuffleboard.getTab("Drive").add("Battery Voltage", 13.5).withWidget(BuiltInWidgets.kDial).getEntry().setDouble(p.getVoltage());
        //the camera
        Shuffleboard.getTab("Climber").add("Activated?", false).withWidget(BuiltInWidgets.kBooleanBox).getEntry().setBoolean(climb.atSetPosition());
        Shuffleboard.getTab("Shooter").add("Flywheel Speed", 1).withWidget(BuiltInWidgets.kDial).getEntry().setDouble(wheel.flyWheelSpeed());
        Shuffleboard.getTab("Shooter").add("Ball Loaded", false).withWidget(BuiltInWidgets.kBooleanBox).getEntry().setBoolean(shoot.ballLoaded());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
