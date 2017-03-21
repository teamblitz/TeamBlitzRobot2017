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

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The subsystem for the gear doors. The subsystem
 * consists of two servers, one controlling each
 * door.
 */
public class CameraLightsSubsystem extends Subsystem
{    
    public Relay cameraLightsRelay;
    
    public CameraLightsSubsystem()
    {
    	super("Camera Lights");
    	cameraLightsRelay = RobotMap.cameraLightsRelay;
    }
    
    protected void initDefaultCommand()
    {
    }
    
    public void enableControl()
    {
    }

    public void disableControl()
    {
    }
    
     public void toggle()
     {
    	if (cameraLightsRelay.get() == Relay.Value.kForward)
    	{
    		cameraLightsRelay.set(Relay.Value.kOff);
    	}
    	else if (cameraLightsRelay.get() == Relay.Value.kOff)
    	{
    		cameraLightsRelay.set(Relay.Value.kForward);
    	}
    	else
    	{
    		cameraLightsRelay.set(Relay.Value.kOff);
    	}
    }
}