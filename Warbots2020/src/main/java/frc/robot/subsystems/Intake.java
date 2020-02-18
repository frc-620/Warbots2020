/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Pin;

public class Intake extends SubsystemBase {

    private final TalonSRX intakeMotor;

    // region Constructors
    public Intake() {
        intakeMotor = new TalonSRX(Pin.IntakeMotor.id);
    }
    // endregion

    public void intake() {
        intakeMotor.set(ControlMode.PercentOutput, 0.75);
    }

    public void end() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

}