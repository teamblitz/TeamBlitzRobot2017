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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbRopeCommand extends CommandBase {
	
	public enum ClimbingDirection {
		UP,
		DOWN,
		HOLD
	}

	final double ropeMotorUpScaleFactor = 1; // Values between 0 and 1.
	final double ropeMotorDownScaleFactor = 0.2; // Values between 0 and 1.
	final double ropeMotorHoldScaleFactor = 0.3; 
	
	ClimbingDirection direction;
	
    public ClimbRopeCommand(ClimbingDirection direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ropeClimberSubsystem);
        
        this.direction = direction;
    }
    
    public void enableControl() {
    	ropeClimberSubsystem.enableControl();
    }
    
    public void disableControl() {
    	ropeClimberSubsystem.disableControl();
    }

    // Called just before this Command runs the first time.
    protected void initialize() {
    }
    
    // Called repeatedly when this Command is scheduled to run.
    protected void execute() {
    	switch (direction) {
	    	case UP:
	    		ropeClimberSubsystem.setVoltage(ropeMotorUpScaleFactor);
	    		break;
	    	case HOLD:
	    		ropeClimberSubsystem.setVoltage(ropeMotorHoldScaleFactor);
	    		break;
	    	case DOWN:
	    	default:
	    		ropeClimberSubsystem.setVoltage(-ropeMotorDownScaleFactor);
	    		break;
    	}
    	
        double rcc = RobotMap.ropeClimbingMotorController.getOutputCurrent();
        SmartDashboard.putNumber("Rope Climbing Motor Current", rcc);
    }

	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ropeClimberSubsystem.setVoltage(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	ropeClimberSubsystem.setVoltage(0);
    }
}
