package org.usfirst.frc.team868.robot.commands.collector;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetCollector extends Command {
	
	private final double power;

    public SetCollector(double power) {
    	requires(Robot.collector);
    	this.power = power;
    }

    protected void initialize() {
    	Robot.collector.setMotors(power, power);
    }

    protected boolean isFinished() {
        return false;
    }
}
