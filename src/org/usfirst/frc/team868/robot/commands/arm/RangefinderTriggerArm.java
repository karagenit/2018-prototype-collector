package org.usfirst.frc.team868.robot.commands.arm;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RangefinderTriggerArm extends Command {

    public RangefinderTriggerArm() {
        requires(Robot.arm);
        SmartDashboard.putNumber("Rangefinder Threshold", 2);
    }

    protected void initialize() {
    	Robot.arm.setPosition(true);
    }

    protected void execute() {
    	double threshold = SmartDashboard.getNumber("Rangefinder Threshold", 2);
    	
    	if (Robot.collector.getRangefinder() > threshold) {
    		Robot.arm.setPosition(false);
    	} else {
    		Robot.arm.setPosition(true);
    	}
    }

    /**
     * TODO: finish after we've triggered the rangefinder once?
     */
    protected boolean isFinished() {
        return false;
    }
}
