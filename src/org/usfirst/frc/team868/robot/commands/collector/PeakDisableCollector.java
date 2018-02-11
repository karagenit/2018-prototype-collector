package org.usfirst.frc.team868.robot.commands.collector;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PeakDisableCollector extends Command {

    public PeakDisableCollector() {
        requires(Robot.collector);
        SmartDashboard.putNumber("Collector Power", 1);
        SmartDashboard.putNumber("Current Maxiumum", 20);
    }

    protected void initialize() {
    	double power = SmartDashboard.getNumber("Collector Power", 1);
    	Robot.collector.configDefaults();
    	Robot.collector.setMotors(power, power);
    }

    /**
     * We really should do this checking in a thread, but that would be
     * quite a bit more difficult (though it would be easier to do at the
     * subsystem-level, with direct access to the motor controller) - we can
     * do this in the real code if we feel it's necessary.
     */
    protected void execute() {
    	double power = SmartDashboard.getNumber("Collector Power", 1);
    	double current = SmartDashboard.getNumber("Current Maximum", 20);
    	
    	if (Robot.collector.getRightCurrent() > current) {
    		Robot.collector.setRightMotor(0);
    	} else {
    		Robot.collector.setRightMotor(power);
    	}
    	
    	if (Robot.collector.getLeftCurrent() > current) {
    		Robot.collector.setLeftMotor(0);
    	} else {
    		Robot.collector.setLeftMotor(power);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.collector.setMotors(0, 0);
    }
}
