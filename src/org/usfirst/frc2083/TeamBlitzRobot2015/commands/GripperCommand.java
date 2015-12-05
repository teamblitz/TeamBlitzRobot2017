package org.usfirst.frc2083.TeamBlitzRobot2015.commands;

import org.usfirst.frc2083.TeamBlitzRobot2015.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

import org.usfirst.frc2083.TeamBlitzRobot2015.RobotMap;


import edu.wpi.first.wpilibj.Joystick;

public class GripperCommand extends CommandBase {
	public static Joystick xbox;

	public GripperCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(gripper);
	}
	
	public void enableControl() {
        gripper.enableControl();
    }
	
    public void disableControl() {
        gripper.disableControl();
    }

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double LT = 0;
		double RT = 0;
		double val = 0;
		LT = xbox.getRawAxis(RobotMap.xboxLeftTriggerAxisNum);
		RT = xbox.getRawAxis(RobotMap.xboxRightTriggerAxisNum);
		System.out.println("LT = " + LT + ", RT = " + RT);
		
		if (LT < 0.1) LT = 0;
		if (RT < 0.1) RT = 0;
		LT = LT * LT;
		RT = RT * RT;
		if (LT > 0) {
			if (RT == 0) {
				val = LT * RobotMap.gripperMotorVoltageLimit;
			} else {
				val = 0;
			}
		} else {
			val = -RT * RobotMap.gripperMotorVoltageLimit;
		}
//		val = LT * RobotMap.gripperMotorVoltageLimit;
//		int numAxes = xbox.getAxisCount();
//		double[] axisValues = new double[numAxes];
//		String toPrint = "numAxes = " + numAxes;
//		for (int i=0; i < numAxes; i++) {
//			axisValues[i] = xbox.getRawAxis(i);
//			toPrint += ", value " + i + " = " + axisValues[i];
//		}
		//System.out.println("LT = " + LT + ", RT = " + RT + ", val = " + val );
//		System.out.println(toPrint);
		gripper.setVoltage(val);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

