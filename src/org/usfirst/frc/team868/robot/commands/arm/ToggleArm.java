package org.usfirst.frc.team868.robot.commands.arm;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleArm extends Command {

    public ToggleArm() {
    	requires(Robot.arm);
    }

    protected void initialize() {
    	Robot.arm.set(Robot.arm.get());
    }

    protected boolean isFinished() {
        return true;
    }
}
