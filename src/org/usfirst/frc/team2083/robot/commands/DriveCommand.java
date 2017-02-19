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
	
	// The robot is back heavy, so when coming to a fast stop in reverse
	// followed by a sudden acceleration in the forward direction, the robot
	// is prone to tipping over backwards. To prevent this, we impose a stop
	// delay when the robot decelerates to zero in the reverse direction.
	// The user won't be able to apply drive input until this delay has expired.
	// The delay units are in milliseconds.
	final double backwardStopDelay = 0;
	boolean backwardStopDelayInEffect;
	double backwardStopDelayStartTime;
	double prevY;

	
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDriveSubsystem);
        requires(rightDriveSubsystem);
    }

	public void enableControl() {
        leftDriveSubsystem.enableControl();
        rightDriveSubsystem.enableControl();
    }
    
    public void disableControl() {
        leftDriveSubsystem.disableControl();
        rightDriveSubsystem.disableControl();
    }

    // Called just before this Command runs the first time.
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
    	if (System.currentTimeMillis() - backwardStopDelayStartTime < backwardStopDelay ) {
    		return;
    	}

    	double x = 0, y = 0;

    	// Get controller input.
    	x = oi.getMotorDriveLeftRightValue();
    	y = oi.getMotorDriveForwardBackValue();
    	x = x*Math.abs(x);
    	y = y*Math.abs(y);
    	
    	// Check for sudden change of direction going from reverse to forward.
		if (prevY <= -joystickZeroThreshold && y > -joystickZeroThreshold) {
			// We have decelerated in the reverse direction and are attempting
			// to stop or move forward, so initiate a backwardStopDelay.
			backwardStopDelayInEffect = true;
			backwardStopDelayStartTime = System.currentTimeMillis();
			x = 0;
			y = 0;
		}

    	// Set drive motor input to zero if joystick is close to zero.
    	if (Math.abs(x) < joystickZeroThreshold && Math.abs(y) < joystickZeroThreshold) {
    		//System.out.println("Raw (x, y) = (" + x + ", " + y + ")");
    		x = 0;
    		y = 0;    		
    	}
    	
    	// System.out.println("(x, y) = (" + x + ", " + y + ")");
    	
    	if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE) {
    		
    		double driveMotorScaleFactor = -oi.driveMotorFactor()*.2+.22; // Values between 0.125 and 0.5.
			double leftDriveVoltage = (y + x) * driveMotorScaleFactor;
			double rightDriveVoltage = (y - x) * driveMotorScaleFactor;
	        
	        leftDriveSubsystem.setVoltage(leftDriveVoltage);
	        rightDriveSubsystem.setVoltage(rightDriveVoltage);
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
        
    	prevY = y;
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
