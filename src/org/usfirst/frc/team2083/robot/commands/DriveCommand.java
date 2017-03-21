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
	
    public DriveCommand()
    {
        // Use requires() here to declare subsystem dependencies
        // e.g., requires(chassis);
    	if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE)
    	{
    		requires(leftDriveSubsystem);
        	requires(rightDriveSubsystem);
    	}
    	else
    	{
    		requires(leftDrivePIDSubsystem);
        	requires(rightDrivePIDSubsystem);
    	}
    }

	public void enableControl()
	{
    	if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE)
    	{
    		leftDriveSubsystem.enableControl();
    		rightDriveSubsystem.enableControl();
    	}
    	else
    	{
    		leftDrivePIDSubsystem.enableControl();
    		rightDrivePIDSubsystem.enableControl();
    	}
    }
    
    public void disableControl()
    {
    	if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE)
    	{
    		leftDriveSubsystem.disableControl();
    		rightDriveSubsystem.disableControl();
    	}
    	else
    	{
    		leftDrivePIDSubsystem.disableControl();
    		rightDrivePIDSubsystem.disableControl();
    	}
    }

    // Called just before this Command runs the first time.
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run.
    protected void execute()
    {
    	double x = 0, y = 0;

    	// Get controller input.
    	x = oi.getMotorDriveLeftRightValue();
    	y = oi.getMotorDriveForwardBackValue();
    	x = x * Math.abs(x);
    	y = y * Math.abs(y);
    	
    	// Set drive motor input to zero if joystick is close to zero.
    	if (Math.abs(x) < joystickZeroThreshold && Math.abs(y) < joystickZeroThreshold)
    	{
    		//System.out.println("Raw (x, y) = (" + x + ", " + y + ")");
    		x = 0;
    		y = 0;    		
    	}
    	
    	// System.out.println("(x, y) = (" + x + ", " + y + ")");
    	
    	if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE)
    	{
    		double m = -oi.getMoterDriveScaleFactor();
    		final double a0 = 0.4;
    		final double a1 = 0.26666;
    		final double a2 = 0.2;
    		final double a3 = 0.13333;
    		double driveMotorScaleFactor = a0 + (a1 * m) + (a2 * Math.pow(m, 2)) + (a3 * Math.pow(m, 3));
			double leftDriveVoltage = (y + x) * driveMotorScaleFactor;
			double rightDriveVoltage = (y - x) * driveMotorScaleFactor;
	        
	        leftDriveSubsystem.setVoltage(leftDriveVoltage);
	        rightDriveSubsystem.setVoltage(rightDriveVoltage);
    	}
    	else if (RobotMap.driveMotorControlType == DriveMotorControlType.PID)
    	{
    		leftDrivePIDSubsystem.setSetpoint((y * 360) + (x * 240));
    		rightDrivePIDSubsystem.setSetpoint((y * 360) - (x * 240));
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
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
