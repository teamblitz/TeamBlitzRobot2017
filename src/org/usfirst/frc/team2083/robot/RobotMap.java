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

package org.usfirst.frc.team2083.robot;
    
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public enum DriveMotorControlType {
		VOLTAGE,
		PID
	}
	
	// CAN IDs
    public static final int LEFT_FORWARD_MOTOR_CONTROLLER_ID = 2;
    public static final int LEFT_BACK_MOTOR_CONTROLLER_ID = 3;
    public static final int RIGHT_FORWARD_MOTOR_CONTROLLER_ID = 1;
    public static final int RIGHT_BACK_MOTOR_CONTROLLER_ID = 4;
    public static final int ROPE_CLIMBING_MOTOR_CONTROLLER = 5;
    
    // Servo IDs
    public static final int RIGHT_GEAR_DOOR_SERVO_ID = 0;
    public static final int LEFT_GEAR_DOOR_SERVO_ID = 1;
    
    // CAN-Based Instances 
    public static CANTalon leftForwardMotorController;
    public static CANTalon leftBackMotorController;
    public static CANTalon rightForwardMotorController;
    public static CANTalon rightBackMotorController;
    public static CANTalon ropeClimbingMotorController;
    
    // Servo-Based Instances
    public static Servo rightGearDoorServo;
    public static Servo leftGearDoorServo;

    // Global Configs
    public static final DriveMotorControlType driveMotorControlType = DriveMotorControlType.VOLTAGE;
  
    // Input Controls
    public static final int JS_DRIVER_PORT = 0;
    public static final int JS_DRIVER_CLIMBER_BUTTON = 5;

    public static void init() {
    	
    }
}
