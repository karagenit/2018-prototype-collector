package org.usfirst.frc.team868.robot.commands.collector;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LimitPowerCollector extends Command {

    public LimitPowerCollector() {
    	requires(Robot.collector);
    	SmartDashboard.putNumber("Collector Power", 1);
    }

    protected void initialize() {
    	Robot.collector.configLimitPower();
    }

    protected void execute() {
    	double power = SmartDashboard.getNumber("Collector Power", 1);
    	Robot.collector.setMotors(power, power);
    }

    protected boolean isFinished() {
        return false;
    }
}