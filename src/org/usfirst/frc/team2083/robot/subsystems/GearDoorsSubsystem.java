/*
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

package org.usfirst.frc.team2083.robot.subsystems;

import org.usfirst.frc.team2083.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 * @author Owner
 */
public class GearDoorsSubsystem extends Subsystem {
    
    public Servo rightDoor;
    public Servo leftDoor;
    
    public GearDoorsSubsystem() {
    	super("Gear Door");
    	rightDoor = RobotMap.rightGearDoorServo;
        leftDoor = RobotMap.leftGearDoorServo;
    }
    
    protected void initDefaultCommand() {
    
    }
    
    public void enableControl() {

    }

    public void disableControl() {

    }

    public void toggle() {
    	System.out.println("executing gear door command()");
	    if (leftDoor.getAngle() < 85) {
	    	leftDoor.setAngle(170);
	    	rightDoor.setAngle(170);
	    }
	    else {
	    	leftDoor.setAngle(0);
	    	rightDoor.setAngle(0);
	    }	
    }
    
}