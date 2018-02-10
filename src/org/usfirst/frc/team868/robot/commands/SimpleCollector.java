package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SimpleCollector extends Command {

    public SimpleCollector() {
    	requires(Robot.collector);
    }

    protected void initialize() {
    	Robot.collector.setMotors(1, 1); // TODO: read smartdashboard for this value
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.collector.setMotors(0, 0);
    }
}
