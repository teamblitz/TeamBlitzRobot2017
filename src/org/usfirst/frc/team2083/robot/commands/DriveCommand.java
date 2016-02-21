
package org.usfirst.frc.team2083.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2083.robot.RobotMap;

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
    //    leftDrive.enable();
    //    rightDrive.enable();
        leftDrive.enableControl();
        rightDrive.enableControl();
    }
    public void disableControl() {
    //    leftDrive.disable();
    //    rightDrive.disable();
        leftDrive.disableControl();
        rightDrive.disableControl();
    }
    //public void setVoltageRampRate() {
    
    //}

    // Called just before this Command runs the first time
    protected void initialize() {
    	//double getOutputVoltage();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = 0, y = 0;

    	if (RobotMap.auto) {
    		y = RobotMap.autoY;

    	} else {
    		x = xbox.getX();
    		y = -xbox.getY();
    		x = x*Math.abs(x);
    		y = y*Math.abs(y);
    		if (Math.abs(x) < 0.15 && Math.abs(y) < 0.15) {
        		//System.out.println("Raw (x, y) = (" + x + ", " + y + ")");
    			x = 0;
    			y = 0;
    		}
    		System.out.println("(x, y) = (" + x + ", " + y + ")");
    	}

    	//double leftSetPointVal = y*360+x*360;
    	//double rightSetPointVal = y*360-x*360;
    	double leftDriveVoltage = y*12+x*12;
    	double rightDriveVoltage = y*12-x*12;
    	    	
//		System.out.println("Left drive setPoint = " + leftSetPointVal);
//		System.out.println("Right drive setPoint = " + rightSetPointVal);
//		
//    	leftDrive.setSetpoint(leftSetPointVal);
//        rightDrive.setSetpoint(rightSetPointVal);
        
        leftDrive.setVoltage(leftDriveVoltage);
        rightDrive.setVoltage(rightDriveVoltage);
        
        double lfc = RobotMap.leftForwardMotorController.getOutputCurrent();
        double lbc = RobotMap.leftBackMotorController.getOutputCurrent();
        double rfc = RobotMap.rightForwardMotorController.getOutputCurrent();
        double rbc = RobotMap.rightBackMotorController.getOutputCurrent();
                
        SmartDashboard.putNumber("Left Front Current", lfc);
        SmartDashboard.putNumber("Left Back Current", lbc);
        SmartDashboard.putNumber("Right Front Current", rfc);
        SmartDashboard.putNumber("Right Back Current", rbc);

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
