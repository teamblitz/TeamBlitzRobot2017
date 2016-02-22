package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

/**
 *
 */
public class AutoCommandMoveArm extends CommandBase {

	long duration;
	long startTime;
	double percentVBus;
	
    public AutoCommandMoveArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(armBar);
    	
    	this.duration = 2*1000;
    	this.percentVBus = -0.3;
    }

    public AutoCommandMoveArm(long duration, double percentVBus) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(armBar);
    	
    	this.duration = duration;
    	this.percentVBus = percentVBus;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(System.currentTimeMillis() - startTime < duration ) {
    		armBar.setPercentVBus(percentVBus);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime > duration;
    }

    // Called once after isFinished returns true
    protected void end() {
    	armBar.setPercentVBus(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
