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
 *
 * @author Owner
 */
public class LeftDriveSubsystem extends Subsystem {
    
    public CANTalon leftFront;
    public CANTalon leftBack;
    
    public LeftDriveSubsystem() {
        //super("Left Drive", 0.01, 0, 0, 0.02);
    	super("Left Drive");
    	leftFront = RobotMap.leftForwardMotorController;
        leftBack = RobotMap.leftBackMotorController;
        //this.enable();
        //this.getPIDController().setOutputRange(-12, 12);
    }
    protected void initDefaultCommand() {
    }
    
    public void enableControl() {
        leftBack.enableControl();
        leftFront.enableControl();
    }
    public void disableControl() {
            leftBack.disableControl();
            leftFront.disableControl();
    }

//    public double returnPIDInput() {
//        return leftFront.getSpeed();
//    }
//
//    public void usePIDOutput(double d) {
// //   	System.out.println("Left " + getSetpoint() + " " + returnPIDInput() + " " + d + " " + leftFront.getOutputCurrent() + " " + leftBack.getOutputCurrent());
// // 	System.out.println("Left d = "+ d);
//        leftFront.set(d);
//        leftBack.set(d);
//    }
    public void setVoltage(double voltage)
    {
    	leftFront.set(voltage);
        leftBack.set(voltage);
    }
}