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
 * The subsystem for the gear doors. The subsystem
 * consists of two servers, one controlling each
 * door.
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
    
    public boolean isOpen() {
    	return isLeftDoorOpen() && isRightDoorOpen();
    }
    
    public boolean isLeftDoorOpen() {
    	return leftDoor.getAngle() > 119;
    }
    
    public boolean isRightDoorOpen() {
    	return rightDoor.getAngle() > 169;
    }
    
    public boolean isClosed() {
    	return isLeftDoorClosed() && isRightDoorClosed();
    }
    
    public boolean isLeftDoorClosed() {
    	return leftDoor.getAngle() < 1;
    }

    public boolean isRightDoorClosed() {
    	return leftDoor.getAngle() < 1;
    }

    public void open() {
    	leftDoor.setAngle(120);	
    	rightDoor.setAngle(140);
    	System.out.println("Open Doors");
    }
    
    public void close() {
    	leftDoor.setAngle(0);	
    	rightDoor.setAngle(0);
    	System.out.println("Closed Doors");
    }
    
    public void toggle() {
	    if (isClosed()) {
	    	open();
	    }
	    else {
	    	close();
	    }
    }
}