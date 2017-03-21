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

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * The subsystem for the left drive wheel. The subsystem
 * consists of two CAN-bus Talon motor controllers with
 * an encoder..
 */
public class RightDrivePIDSubsystem extends PIDSubsystem
{
    public CANTalon rightFront;
    public CANTalon rightBack;
    
    public RightDrivePIDSubsystem()
    {
        super("Right Drive", 0.01, 0, 0, 0.02);

    	this.rightFront = RobotMap.rightForwardMotorController;
        this.rightBack = RobotMap.rightBackMotorController;

        this.getPIDController().setOutputRange(-12, 12);        
    }

    protected void initDefaultCommand()
    {
    }
    
    public void enableControl()
    {
        rightBack.enableControl();
        rightFront.enableControl();
    }
    
    public void disableControl()
    {
        rightBack.disableControl();
        rightFront.disableControl();
    }

    public double returnPIDInput()
    {
       return -rightFront.getSpeed();
    }

    public void usePIDOutput(double d)
    {
//    	System.out.println("Right " + getSetpoint() + " " + returnPIDInput() + " " + d + " " + rightFront.getOutputCurrent() + " " + rightBack.getOutputCurrent());
//    	System.out.println("Right d = " + d);
        rightFront.pidWrite(-d);
        rightBack.pidWrite(-d);
    }
}
