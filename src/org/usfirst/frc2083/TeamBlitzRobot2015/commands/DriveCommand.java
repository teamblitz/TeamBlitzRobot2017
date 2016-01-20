
package org.usfirst.frc2083.TeamBlitzRobot2015.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

import org.usfirst.frc2083.TeamBlitzRobot2015.RobotMap;

/**
 *
 * @author bradmiller
 */
public class DriveCommand extends CommandBase {
    
    public static Joystick xbox;

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDrive);
        requires(rightDrive);
    }
    
    public void enableControl() {
        leftDrive.enable();
        rightDrive.enable();
        leftDrive.enableControl();
        rightDrive.enableControl();
    }
    public void disableControl() {
        leftDrive.disable();
        rightDrive.disable();
        leftDrive.disableControl();
        rightDrive.disableControl();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double X = 0, Y = 0;

    	if (RobotMap.auto) {
    		Y = RobotMap.autoY;

    	} else {
    		X = xbox.getX();
    		//    	System.out.println("X = " + X);
    		Y = -xbox.getY(); //-xbox.getRawAxis(5);
    		//    	System.out.println("Y = " + Y);
    		if (Math.abs(X) < 0.1) X = 0;
    		if (Math.abs(Y) < 0.1) Y = 0;
    		X = X*Math.abs(X);
    		Y = Y*Math.abs(Y);
    	}

    	System.out.println("Y = " + Y);
    	leftDrive.setSetpoint(Y*360+X*240);
        rightDrive.setSetpoint(Y*360-X*240);
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
