package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.arm.RangefinderTriggerArm;
import org.usfirst.frc.team868.robot.commands.arm.ToggleArm;
import org.usfirst.frc.team868.robot.commands.collector.LimitPowerCollector;
import org.usfirst.frc.team868.robot.commands.collector.OscillateCollector;
import org.usfirst.frc.team868.robot.commands.collector.PeakDisableCollector;
import org.usfirst.frc.team868.robot.commands.collector.SetCollector;
import org.usfirst.frc.team868.robot.commands.collector.SimpleCollector;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static final XboxController driver = new XboxController(0);
	
	public static void setupDriver() {
		Button a = new JoystickButton(driver, 1);
		a.toggleWhenPressed(new SimpleCollector());
		
		Button b = new JoystickButton(driver, 2);
		b.toggleWhenPressed(new OscillateCollector());
		
		Button x = new JoystickButton(driver, 3);
		x.toggleWhenPressed(new PeakDisableCollector());
		
		Button y = new JoystickButton(driver, 4);
		y.toggleWhenPressed(new LimitPowerCollector());
		
		Button rb = new JoystickButton(driver, 5);
		rb.toggleWhenPressed(new SetCollector(-1));
		
		Button start = new JoystickButton(driver, 8);
		start.whenPressed(new ToggleArm());
		
		Button select = new JoystickButton(driver, 7);
		select.toggleWhenPressed(new RangefinderTriggerArm());
	}
}
