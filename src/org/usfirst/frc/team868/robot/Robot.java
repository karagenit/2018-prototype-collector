/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.arm.RangefinderTriggerArm;
import org.usfirst.frc.team868.robot.commands.arm.ToggleArm;
import org.usfirst.frc.team868.robot.commands.collector.LimitPowerCollector;
import org.usfirst.frc.team868.robot.commands.collector.OscillateCollector;
import org.usfirst.frc.team868.robot.commands.collector.PeakDisableCollector;
import org.usfirst.frc.team868.robot.commands.collector.SimpleCollector;
import org.usfirst.frc.team868.robot.subsystems.Arm;
import org.usfirst.frc.team868.robot.subsystems.Collector;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	public static final Collector collector = new Collector();
	public static final Arm arm = new Arm();

	@Override
	public void robotInit() {
		SmartDashboard.putData("Toggle Arm Position", new ToggleArm());
		SmartDashboard.putData("Simple Power", new SimpleCollector());
		SmartDashboard.putData("Close via Rangefinder", new RangefinderTriggerArm());
		SmartDashboard.putData("Oscillating Power", new OscillateCollector());
		SmartDashboard.putData("Disable on Stall", new PeakDisableCollector());
		SmartDashboard.putData("Limit Current Draw", new LimitPowerCollector());
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Right Current", collector.getRightCurrent());
		SmartDashboard.putNumber("Right Voltage", collector.getRightVoltage());
		SmartDashboard.putNumber("Left Current", collector.getLeftCurrent());
		SmartDashboard.putNumber("Left Voltage", collector.getLeftVoltage());
	}
}
