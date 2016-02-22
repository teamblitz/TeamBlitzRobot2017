


package org.usfirst.frc.team2083.robot.commands;

import org.usfirst.frc.team2083.robot.RobotMap;

/**
 *
 */
public class  ArmCommand extends CommandBase {
	public static double powerFactor = 1;

	public ArmCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(armBar);
		armBar.setPercentVBus(0);
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
		rY = oi.getArmUpDownValue();
		System.out.println("Y = " + rY);
		double Y = rY; 		
		Y = Y*Math.abs(Y)  *powerFactor;
		if (Math.abs(Y) < 0.15) {
			Y = 0;
		}
		
		System.out.println("y arm = " + Y + "");
		System.out.println("Forward limit: " + RobotMap.armBarMotorController.isFwdLimitSwitchClosed());
		System.out.println("Reverse limit: " + RobotMap.armBarMotorController.isRevLimitSwitchClosed());

		//System.out.println("Y = " + Y + ", rY = " + rY + ", curpos = " + curpos);
		armBar.setPercentVBus(Y);
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
