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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    Joystick xbox;
    JoystickButton ropeButton;
    JoystickButton ropeReverseButton;
    JoystickButton gearDoorsButton;
    JoystickButton slowModeButton;
    
    public OI() {
        xbox = new Joystick(RobotMap.JS_DRIVER_PORT);
    	ropeButton = new JoystickButton(xbox, 1);
    	ropeReverseButton = new JoystickButton(xbox, 2);    	
    	gearDoorsButton = new JoystickButton(xbox, 4);
    	slowModeButton = new JoystickButton(xbox, 8);
    }
    
    public double getMotorDriveLeftRightValue() {
    	return xbox.getX();
    }
    
    public double getMotorDriveForwardBackValue() {
    	return -xbox.getY();
    }
   
    public double driveMotorFactor() {   
    	return xbox.getRawAxis(5);
    }
 }