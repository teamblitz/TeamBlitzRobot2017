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

import org.usfirst.frc.team2083.robot.OI;
import org.usfirst.frc.team2083.robot.subsystems.GearDoorsSubsystem;
import org.usfirst.frc.team2083.robot.subsystems.LeftDriveSubsystem;
import org.usfirst.frc.team2083.robot.subsystems.RightDriveSubsystem;
import org.usfirst.frc.team2083.robot.subsystems.RopeClimbingSubsystem;
import org.usfirst.frc.team2083.robot.subsystems.CameraLightsSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase creates and stores each control system. To access a subsystem
 * elsewhere in your code in your code use CommandBase.exampleSubsystem
 */
public abstract class CommandBase extends Command {

    // Create a single static instance of each of your subsystems.
	public static LeftDriveSubsystem leftDriveSubsystem = new LeftDriveSubsystem();
    public static RightDriveSubsystem rightDriveSubsystem = new RightDriveSubsystem();
    public static RopeClimbingSubsystem ropeClimberSubsystem = new RopeClimbingSubsystem();
    public static GearDoorsSubsystem gearDoorsSubsystem = new GearDoorsSubsystem();
    public static CameraLightsSubsystem cameraLightsSubsystem = new CameraLightsSubsystem();
    
    public static OI oi;
    
    public static void init() {
    	
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
       
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(leftDriveSubsystem);
        SmartDashboard.putData(rightDriveSubsystem);
        SmartDashboard.putData(ropeClimberSubsystem);
        SmartDashboard.putData(gearDoorsSubsystem);
        SmartDashboard.putData(cameraLightsSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
