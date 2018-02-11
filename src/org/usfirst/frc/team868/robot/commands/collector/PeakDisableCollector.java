package org.usfirst.frc.team868.robot.commands.collector;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PeakDisableCollector extends Command {
	
	Timer rightTimeout = new Timer();
	Timer leftTimeout = new Timer();

    public PeakDisableCollector() {
        requires(Robot.collector);
        SmartDashboard.putNumber("Collector Power", 1);
        SmartDashboard.putNumber("Current Maxiumum", 20);
        SmartDashboard.putNumber("Current Overload Delay", 500); //ms
    }

    protected void initialize() {
    	Robot.collector.configDefaults();
    	rightTimeout.start();
    	leftTimeout.start();
    }

    /**
     * We really should do this checking in a thread, but that would be
     * quite a bit more difficult (though it would be easier to do at the
     * subsystem-level, with direct access to the motor controller) - we can
     * do this in the real code if we feel it's necessary.
     * 
     * Also, because all the timers start at 0 (we don't have a way of setting
     * their initial value) it won't start driving the motors until 'timeout' ms
     * after the command is start()ed.
     */
    protected void execute() {
    	double power = SmartDashboard.getNumber("Collector Power", 1);
    	double current = SmartDashboard.getNumber("Current Maximum", 20);
    	double timeout = SmartDashboard.getNumber("Current Overload Delay", 500);
    	
    	if (Robot.collector.getRightCurrent() > current) {
    		rightTimeout.reset();
    	}
    	
    	if (Robot.collector.getLeftCurrent() > current) {
    		leftTimeout.reset();
    	}
    	
    	if (rightTimeout.get() > timeout) {
    		Robot.collector.setRightMotor(power);
    	} else {
    		Robot.collector.setRightMotor(0);
    	}
    	
    	if (leftTimeout.get() > timeout) {
    		Robot.collector.setLeftMotor(power);
    	} else {
    		Robot.collector.setLeftMotor(0);
    	}
    }

    protected boolean isFinished() {
        return false;
    }
}
