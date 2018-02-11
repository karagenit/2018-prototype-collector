package org.usfirst.frc.team868.robot.commands.collector;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OscillateCollector extends Command {

	private Timer timer = new Timer();
	private boolean rightPowered = false;
	@SuppressWarnings("unused") //technically never used, but helpful
	private boolean leftPowered = false;

	public OscillateCollector() {
		requires(Robot.collector);
		SmartDashboard.putNumber("Collector Power", 1);
		SmartDashboard.putNumber("Oscillation Time", 100); //ms, time high (aka 1/2 period)
		SmartDashboard.putBoolean("Oscillation Offset", false); //oscillate out-of-phase
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.collector.configDefaults();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double power = SmartDashboard.getNumber("Collector Power", 1);
		double time = SmartDashboard.getNumber("Oscillation Time", 100);
		boolean offset = SmartDashboard.getBoolean("Oscillation Offset", false);

		if (timer.hasPeriodPassed(time/1000)) {
			if (offset) {
				if (rightPowered) {
					rightPowered = false;
					leftPowered = true;
					Robot.collector.setMotors(0, power);
				} else { //either left is powered or neither are
					rightPowered = true;
					leftPowered = false;
					Robot.collector.setMotors(power, 0);
				}
			} else {
				if (rightPowered) {
					rightPowered = false;
					leftPowered = false;
					Robot.collector.setMotors(0, 0);
				} else {
					rightPowered = true;
					leftPowered = true;
					Robot.collector.setMotors(power, power);
				}
			}
		}
	}

	protected boolean isFinished() {
		return false;
	}
}