


package org.usfirst.frc.team2083.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2083.robot.Robot;
import org.usfirst.frc.team2083.robot.RobotMap;

/**
 *
 */
public class  ArmCommand extends CommandBase {
	public static Joystick xbox;
	//public double position = 0;

	public ArmCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(armBar);
		armBar.setVoltage(0);
		//position = fourBar.getController().getAnalogInPosition();
	}

	public void enableControl() {
		armBar.enableControl();
	}

	public void disableControl() {
		armBar.disableControl();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double rY;
		rY = -xbox.getRawAxis(5);
		double Y = rY; 		
		Y = Y*Math.abs(Y)*.2;
		if (Math.abs(Y) < 0.15) {
			Y = 0;
		}
		
		
		System.out.println("y arm = " + Y + "");
		
		//position += 2 * Y;
		//double curpos = armBar.getController().getAnalogInPosition();
		//System.out.println("Y = " + Y + ", rY = " + rY + ", curpos = " + curpos);
		armBar.setVoltage(Y);
 
	 
		
//		int numAxes = xbox.getAxisCount();
//		double[] axisValues = new double[numAxes];
//		String toPrint = "numAxes = " + numAxes;
//		for (int i=0; i < numAxes; i++) {
//			axisValues[i] = xbox.getRawAxis(i);
//			toPrint += ", value " + i + " = " + axisValues[i];
//		}
		//		System.out.println("LT = " + LT + ", RT = " + RT + ", val = " + val );
//		System.out.println(toPrint);
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
