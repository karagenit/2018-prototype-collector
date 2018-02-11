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

    /**
     * Never finish?
     * No - makes it a pain to use from the SD
     * and doesn't really solve the 'default command'
     * problem - at that point, just put a 'set open'
     * command (which doesn't finish) to the dashboard
     * and have a 'set closed' command be the default
     */
    protected boolean isFinished() {
        return true;
    }
}
