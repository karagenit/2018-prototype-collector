package org.usfirst.frc.team868.robot.commands;

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
    	Robot.arm.set(true);
    }

    protected void execute() {
    	double threshold = SmartDashboard.getNumber("Rangefinder Threshold", 2);
    	
    	if (Robot.collector.getRangefinder() > threshold) {
    		Robot.arm.set(false);
    	} else {
    		Robot.arm.set(true);
    	}
    }

    protected boolean isFinished() {
        return false;
    }
}
