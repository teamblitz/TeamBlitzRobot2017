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

import org.usfirst.frc.team2083.robot.commands.CommandBase;

/**
 *
 */
public class AutoCommandGearDoors extends CommandBase
{
	public enum DoorAction
	{
		OPEN,
		CLOSE
	}

	DoorAction action; 
	
    public AutoCommandGearDoors(DoorAction action)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(gearDoorsSubsystem);
    	
    	this.action = action;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	switch (action)
    	{
    		case OPEN:
        			gearDoorsSubsystem.open();
    			break;
    		case CLOSE:
    		default:
        			gearDoorsSubsystem.close();
    			break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	switch (action) {
			case OPEN:
				return gearDoorsSubsystem.isOpen();
			case CLOSE:
			default:
				return gearDoorsSubsystem.isClosed();
    	}
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
