package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetCollectorMotors extends Command {

	private final double motorPower;
	
	/**
	 * Set the collector intake motors to a certain power.
	 */
    public SetCollectorMotors(double power) {
        requires(Robot.collector);
        motorPower = power;
    }

    protected void initialize() {
    	Robot.collector.setMotors(motorPower, motorPower);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.collector.setMotors(0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
