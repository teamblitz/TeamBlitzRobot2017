package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

/**
 *
 */
public class AutoCommandDrive extends CommandBase {

	long duration;
	long startTime;
	double voltage;
	
    public AutoCommandDrive(long duration, double voltage) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(leftDrive);
    	requires(rightDrive);
    	
    	this.duration = duration;
    	this.voltage = voltage;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(System.currentTimeMillis() - startTime < duration ) {
    		leftDrive.setVoltage(voltage);
    		rightDrive.setVoltage(voltage);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime > duration;
    }

    // Called once after isFinished returns true
    protected void end() {
    	leftDrive.setVoltage(0);
    	rightDrive.setVoltage(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
