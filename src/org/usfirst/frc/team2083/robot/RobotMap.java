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

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive Wheels
    public static final int LEFT_FORWARD_MOTOR_CONTROLLER_ID = 4;
    public static final int LEFT_BACK_MOTOR_CONTROLLER_ID = 1;
    public static final int RIGHT_FORWARD_MOTOR_CONTROLLER_ID = 3;
    public static final int RIGHT_BACK_MOTOR_CONTROLLER_ID = 2;

    public static CANTalon leftForwardMotorController;
    public static CANTalon leftBackMotorController;
    public static CANTalon rightForwardMotorController;
    public static CANTalon rightBackMotorController;
    
    // Arm
    public static final int ARM_BAR_MOTOR_CONTROLLER_ID = 18;
    public static CANTalon armBarMotorController;

    // Input Controls
    public static final int JS_DRIVER_PORT = 0;
    public static final int JS_DRIVER_ARM_BUTTON = 5;

    public static void init() {
    	
    }
}
