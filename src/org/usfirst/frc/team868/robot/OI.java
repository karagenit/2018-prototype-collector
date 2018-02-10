package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.SetCollectorMotors;
import org.usfirst.frc.team868.robot.commands.ToggleCollectorPosition;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private static XboxController driver = new XboxController(0);
	
	public OI() {
		
	}
	
	public static void setupDriver() {
		JoystickButton aButton = new JoystickButton(driver, 1);
		aButton.toggleWhenPressed(new SetCollectorMotors(1));
		
		JoystickButton yButton = new JoystickButton(driver, 2);
		yButton.whenPressed(new ToggleCollectorPosition());
	}
}
