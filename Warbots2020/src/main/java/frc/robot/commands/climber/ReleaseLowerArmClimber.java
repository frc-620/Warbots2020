/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ReleaseLowerArmClimber extends CommandBase {

    private final Climber climber;
    private int frames;

    /**
     * Creates a new ReleaseLowerArm.
     */
    public ReleaseLowerArmClimber(Climber c) {
        climber = c;
        addRequirements(climber);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        frames = 0;
        climber.setAngleLower(34);
        System.out.println("********RELEASE LOWER ARM HAS RUN************");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        climber.setAngleLower(34);

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return frames++ > 25;
    }

}
