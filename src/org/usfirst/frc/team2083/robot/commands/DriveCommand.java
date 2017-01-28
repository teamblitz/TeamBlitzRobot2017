/*
 * Copyright 2017 "TeamBlitz Robotics Club"
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.usfirst.frc.team2083.robot.commands;

import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.robot.RobotMap.DriveMotorControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveCommand extends CommandBase {

	// Used to prevent controller input when joystick doesn't center properly.
	final double joystickZeroThreshold = 0.15;
	
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDrive);
        requires(rightDrive);
    }

	public void enableControl() {
        leftDrive.enableControl();
        rightDrive.enableControl();
    }
    
    public void disableControl() {
        leftDrive.disableControl();
        rightDrive.disableControl();
    }

    // Called just before this Command runs the first time.
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
    	double x = 0, y = 0;

    	// Get controller input.
    	x = oi.getMotorDriveLeftRightValue();
    	y = oi.getMotorDriveForwardBackValue();
    	x = x*Math.abs(x);
    	y = y*Math.abs(y);
    	
    	// Set drive motor input to zero if joystic is close to zero.
    	if (Math.abs(x) < joystickZeroThreshold && Math.abs(y) < joystickZeroThreshold) {
    		//System.out.println("Raw (x, y) = (" + x + ", " + y + ")");
    		x = 0;
    		y = 0;
    	}
    	
    	System.out.println("(x, y) = (" + x + ", " + y + ")");

    	if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE) {
    		
    		/*if (){
    			double driveMotorScaleFactor = -oi.driveMotorFactor()*.11+.22; // Values between 0.125 and 0.5.
    		}
    		else {
    			
    		}*/ //TODO Add Start Button checks
    		double driveMotorScaleFactor = .25;
	    	double leftDriveVoltage = (y + x) * driveMotorScaleFactor;
	    	double rightDriveVoltage = (y - x) * driveMotorScaleFactor * .9;
	    	    	
	//		System.out.println("Left drive setPoint = " + leftSetPointVal);
	//		System.out.println("Right drive setPoint = " + rightSetPointVal);
	//		
	//    	leftDrive.setSetpoint(leftSetPointVal);
	//        rightDrive.setSetpoint(rightSetPointVal);
	        
	        leftDrive.setVoltage(leftDriveVoltage);
	        rightDrive.setVoltage(rightDriveVoltage);
    	} else if (RobotMap.driveMotorControlType == DriveMotorControlType.PID) {
    		// FIXME
    	}
    	
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
