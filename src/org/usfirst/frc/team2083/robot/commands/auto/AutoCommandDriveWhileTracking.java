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

package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.TargetTracker;
import org.usfirst.frc.team2083.robot.commands.CommandBase;

/**
 *
 */
public class AutoCommandDriveWhileTracking extends CommandBase
{
	final long DEACQUISITION_DURATION_LIMIT = 200; 	// ms
	final long ROBOT_CENTER_POSITION = 200; 	    // FIXME
	
	double voltage;
	double xPos;
	double targetAreaTheshold;
	long lostTargetTimerStart;
	
    public AutoCommandDriveWhileTracking(double voltage, double xPos, double targetAreaThreshold)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(leftDriveSubsystem);
    	requires(rightDriveSubsystem);
    	
    	this.voltage = voltage;
    	this.xPos = xPos;
    	this.targetAreaTheshold = targetAreaThreshold;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	long x = TargetTracker.getX();
    	double scaleFactor = Math.min(0.25, 1 - Math.abs(x - ROBOT_CENTER_POSITION)/ROBOT_CENTER_POSITION);
    	
    	if (x > 0 && x < ROBOT_CENTER_POSITION)
    	{
    		// Turn left while driving forward.
    		leftDriveSubsystem.setVoltage(voltage * scaleFactor);
    		rightDriveSubsystem.setVoltage(voltage);
    	}
    	else if (x > 0 && x > ROBOT_CENTER_POSITION)
    	{
    		// Turn right while driving forward.
    		leftDriveSubsystem.setVoltage(voltage);
    		rightDriveSubsystem.setVoltage(voltage * scaleFactor);
    	}
    	else
    	{
    		// Keep going straight.
    		leftDriveSubsystem.setVoltage(voltage);
    		rightDriveSubsystem.setVoltage(voltage);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	if (!TargetTracker.isTracking())
    	{
    		if (lostTargetTimerStart == 0)
    		{
    			// Start timer because we've just lost the target.
    			lostTargetTimerStart = System.currentTimeMillis();
    		}
    		else
    		{
    			// We haven't re-acquired the target, so prepare to stop.
    			if ((System.currentTimeMillis() - lostTargetTimerStart) > DEACQUISITION_DURATION_LIMIT)
    			{
    				// abort
    				return true;
    			}
    		}
    	}
    	else
    	{        	
        	// Reset the timer in case we're re-acquired the target.
    		lostTargetTimerStart = 0;    		
    	}

    	return TargetTracker.getArea() > targetAreaTheshold;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	leftDriveSubsystem.setVoltage(0);
    	rightDriveSubsystem.setVoltage(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
