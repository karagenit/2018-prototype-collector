package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RangefinderTriggerCollector extends Command {

    public RangefinderTriggerCollector() {
        requires(Robot.collector);
        SmartDashboard.putNumber("Collector Power", 1);
        SmartDashboard.putNumber("Rangefinder Threshold", 2);
    }

    protected void initialize() {
    	double power = SmartDashboard.getNumber("Collector Power", 1);
    	Robot.collector.configDefaults();
    	Robot.collector.setPosition(true);
    	Robot.collector.setMotors(power, power);
    }

    protected void execute() {
    	double power = SmartDashboard.getNumber("Collector Power", 1);
    	double threshold = SmartDashboard.getNumber("Rangefinder Threshold", 2);
    	
    	if (Robot.collector.getRangefinder() > threshold) {
    		Robot.collector.setMotors(0, 0);
    		Robot.collector.setPosition(false);
    	} else {
    		Robot.collector.setMotors(power, power);
    		Robot.collector.setPosition(true);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.collector.setPosition(true);
    	Robot.collector.setMotors(0, 0);
    }
}
