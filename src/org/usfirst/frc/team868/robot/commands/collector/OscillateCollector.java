package org.usfirst.frc.team868.robot.commands.collector;

import org.usfirst.frc.team868.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OscillateCollector extends Command {

	public OscillateCollector() {
		requires(Robot.collector);
		SmartDashboard.putNumber("Collector Power", 1);
		SmartDashboard.putNumber("Oscillation Time", 0.5); //s, time high (aka 1/2 period)
		SmartDashboard.putBoolean("Oscillation Offset", false); //oscillate out-of-phase
	}

	protected void initialize() {
		Robot.collector.configDefaults();
	}

	protected void execute() {
		double power = SmartDashboard.getNumber("Collector Power", 1);
		double time = SmartDashboard.getNumber("Oscillation Time", 0.5);
		boolean outOfPhase = SmartDashboard.getBoolean("Oscillation Offset", false);

		double powerBase = .75 * power;					// Average will be 75% of max power setting
		double powerFluctuate = .25 * power;			// How much to fluctuation by (plus gets us to 100% power, minus gets to 50% power)
		double secsRunning = timeSinceInitialized();	// How long the command has been running
		double timeScaler = time / (2.0 * Math.PI);		// Controls how long it takes for a full oscillation (1/2 sec for full oscillation)

		double powerOutLeft = powerBase + powerFluctuate * Math.sin(secsRunning * timeScaler);
		double powerOutRight;

		if (outOfPhase) {
			powerOutRight = powerBase + powerFluctuate * Math.cos(secsRunning * timeScaler);
		} else {
			powerOutRight = powerOutLeft;
		}

		Robot.collector.setMotors(powerOutLeft, powerOutRight);
	}

	protected boolean isFinished() {
		return false;
	}
}