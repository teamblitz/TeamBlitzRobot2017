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

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The rope-climbing subsystem. The subsystem is composed
 * of a single CAN-bus Talon motor controller.
 */
public class RopeClimbingSubsystem extends Subsystem {
    
    public CANTalon ropeMotor;
    
    public RopeClimbingSubsystem() {
    	super("Rope Climber");
    	ropeMotor = RobotMap.ropeClimbingMotorController;
    }
    
    protected void initDefaultCommand() {

    }
    
    public void enableControl() {
    	ropeMotor.enableControl();
    }
    
    public void disableControl() {
    	ropeMotor.disableControl();
    }

    public void setVoltage(double voltage)
    {
    	ropeMotor.set(voltage);
    }
}