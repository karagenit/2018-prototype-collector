package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	private Solenoid actuator = new Solenoid(0);
	
	public void setPosition(boolean open) {
		actuator.set(open); // TODO: may need to invert this
	}
	
	public boolean getPosition() {
		return actuator.get();
	}

	/**
	 * No default command set here, because setting
	 * the arms to a certain position would
	 * interfere with commands like ToggleArms etc
	 * (which finish right after setting the state).
	 */
    public void initDefaultCommand() {}
}

