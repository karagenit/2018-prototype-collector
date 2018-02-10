package org.usfirst.frc.team868.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

    private TalonSRX motorLeft = new WPI_TalonSRX(0); // TODO: fix port #s
    private TalonSRX motorRight = new WPI_TalonSRX(1);
    private Solenoid actuator = new Solenoid (0);
    private AnalogInput rangefinder = new AnalogInput(0);
    
    public Collector() {
    	configDefaults();
    }
    
    public void configDefaults() {
    	motorLeft.setInverted(false); // TODO: may need to invert these
    	motorRight.setInverted(false);
    	motorLeft.configPeakCurrentLimit(0, 0); // Disables peak current limiting
    	motorRight.configPeakCurrentLimit(0, 0);
    }
    
    public void configLimitPower() {
    	configDefaults();
    	motorLeft.configPeakCurrentLimit(20, 0);
    	motorRight.configPeakCurrentLimit(20, 0);
    	motorLeft.configPeakCurrentDuration(10, 0);
    	motorRight.configPeakCurrentDuration(10, 0);
    }
    
    public void setMotors(double left, double right) {
    	motorLeft.set(ControlMode.PercentOutput, left);
    	motorRight.set(ControlMode.PercentOutput, right);
    }
    
    public void setPosition(boolean open) {
    	actuator.set(open); // TODO: may need to invert this
    }
    
    public boolean getPosition() {
    	return actuator.get();
    }
    
    public double getRangefinder() {
    	return rangefinder.getVoltage();
    }

    public void initDefaultCommand() {}
}

