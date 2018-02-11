package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	private Solenoid actuator = new Solenoid(0);
	
	public void set(boolean open) {
		actuator.set(open); // TODO: may need to invert this
	}
	
	public boolean get() {
		return actuator.get();
	}

    public void initDefaultCommand() {}
}

