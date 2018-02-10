package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleCollectorPosition extends Command {

    public ToggleCollectorPosition() {
    	// We don't require the Collector subsystem, because
    	// this would stop us from using it with SimpleCollector
    }

    protected void initialize() {
    	Robot.collector.setPosition(Robot.collector.getPosition());
    }

    protected boolean isFinished() {
        return true;
    }
}
