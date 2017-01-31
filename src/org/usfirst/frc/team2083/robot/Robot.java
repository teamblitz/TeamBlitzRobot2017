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

import org.usfirst.frc.team2083.robot.RobotMap.DriveMotorControlType;
import org.usfirst.frc.team2083.robot.commands.ClimbRopeCommand;
import org.usfirst.frc.team2083.robot.commands.CommandBase;
import org.usfirst.frc.team2083.robot.commands.DriveCommand;
import org.usfirst.frc.team2083.robot.commands.GearDoorsCommand;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandBreachBaseLine;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandCenterTowerLift;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandDefault;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandLeftTowerLift;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandRightTowerLift;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// Robot command instances.
	DriveCommand driveCommand;
	ClimbRopeCommand climbRopeCommand;
	GearDoorsCommand gearDoorsCommand;
    // Autonomous command and selection instances.
    Command autonomousCommand;
    SendableChooser<CommandGroup> autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("ROBOT INIT");
       
        // Initialize motor controllers.
        RobotMap.leftForwardMotorController = new CANTalon(RobotMap.LEFT_FORWARD_MOTOR_CONTROLLER_ID);
        RobotMap.leftBackMotorController = new CANTalon(RobotMap.LEFT_BACK_MOTOR_CONTROLLER_ID);
        RobotMap.rightForwardMotorController = new CANTalon(RobotMap.RIGHT_FORWARD_MOTOR_CONTROLLER_ID);
        RobotMap.rightBackMotorController = new CANTalon(RobotMap.RIGHT_BACK_MOTOR_CONTROLLER_ID);
    
        if (RobotMap.driveMotorControlType == DriveMotorControlType.VOLTAGE) {
	        RobotMap.leftForwardMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	        RobotMap.leftBackMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	        RobotMap.rightForwardMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	        RobotMap.rightBackMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);                                            
        } else if (RobotMap.driveMotorControlType == DriveMotorControlType.PID) {
        	RobotMap.leftForwardMotorController.changeControlMode(CANTalon.TalonControlMode.Speed);
	        RobotMap.leftBackMotorController.changeControlMode(CANTalon.TalonControlMode.Speed );
	        RobotMap.rightForwardMotorController.changeControlMode(CANTalon.TalonControlMode.Speed);
	        RobotMap.rightBackMotorController.changeControlMode(CANTalon.TalonControlMode.Speed);
	        
	        RobotMap.leftForwardMotorController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	        RobotMap.leftBackMotorController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	        RobotMap.rightForwardMotorController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	        RobotMap.rightBackMotorController.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	        
	        RobotMap.leftForwardMotorController.reverseSensor(false);
	        RobotMap.leftBackMotorController.reverseSensor(false);
	        RobotMap.rightForwardMotorController.reverseSensor(false);
	        RobotMap.rightBackMotorController.reverseSensor(false);
	        
	        RobotMap.leftForwardMotorController.configEncoderCodesPerRev(12);
	        RobotMap.leftBackMotorController.configEncoderCodesPerRev(12);
	        RobotMap.rightForwardMotorController.configEncoderCodesPerRev(12);
	        RobotMap.rightBackMotorController.configEncoderCodesPerRev(12);
	        
	        RobotMap.leftForwardMotorController.configNominalOutputVoltage(+0.0f, -0.0f);
	        RobotMap.leftBackMotorController.configNominalOutputVoltage(+0.0f, -0.0f);
	        RobotMap.rightForwardMotorController.configNominalOutputVoltage(+0.0f, -0.0f);
	        RobotMap.rightBackMotorController.configNominalOutputVoltage(+0.0f, -0.0f);
	        
	        RobotMap.leftForwardMotorController.configPeakOutputVoltage(+12.0f, -12.0);
	        RobotMap.leftBackMotorController.configPeakOutputVoltage(+12.0f, -12.0);
	        RobotMap.rightForwardMotorController.configPeakOutputVoltage(+12.0f, -12.0);
	        RobotMap.rightBackMotorController.configPeakOutputVoltage(+12.0f, -12.0);

	        RobotMap.leftForwardMotorController.setPID(0, 0, 0, 0, 0, 0, 0);	// FIXME
	        RobotMap.leftBackMotorController.setPID(0, 0, 0, 0, 0, 0, 0);		// FIXME
	        RobotMap.rightForwardMotorController.setPID(0, 0, 0, 0, 0, 0, 0);	// FIXME
	        RobotMap.rightBackMotorController.setPID(0, 0, 0, 0, 0, 0, 0);		// FIXME
        }
       
        RobotMap.ropeClimbingMotorController = new CANTalon(RobotMap.ROPE_CLIMBING_MOTOR_CONTROLLER);
        
        RobotMap.ropeClimbingMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        
        RobotMap.rightGearDoorServo = new Servo(RobotMap.RIGHT_GEAR_DOOR_SERVO_ID);
        RobotMap.leftGearDoorServo = new Servo(RobotMap.LEFT_GEAR_DOOR_SERVO_ID);
        
        // Initialize all subsystems.
        CommandBase.init();
        driveCommand = new DriveCommand();
        driveCommand.disableControl();
        
        climbRopeCommand = new ClimbRopeCommand();
        climbRopeCommand.disableControl();
        
        gearDoorsCommand = new GearDoorsCommand();
                
        // Autonomous setup.
        autoChooser = new SendableChooser<CommandGroup>();
        autoChooser.addDefault("Default (Nothing)", new AutoCommandDefault());
        autoChooser.addObject("Breach Base Line", new AutoCommandBreachBaseLine());
        autoChooser.addObject("Left Tower Lift", new AutoCommandLeftTowerLift());
        autoChooser.addObject("Center Tower Lift", new AutoCommandCenterTowerLift());
        autoChooser.addObject("Right Tower Lift", new AutoCommandRightTowerLift());
        
        // SmartDashboard setup. 
        SmartDashboard.putData("Autonmous Mode", autoChooser);       
    }
    
    /**
     * This function is called to initialize autonoumous mode.
     */
    public void autonomousInit() {
        System.out.println("AUTONOMOUS INIT");

        driveCommand.enableControl();

        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();        
    }

    /**
     * This function is called periodically during autonomous.
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    /**
     * This function is called to initialize teleop mode.
     */
    public void teleopInit() {
        System.out.println("TELEOP INIT");

        driveCommand.enableControl();
        driveCommand.start();
        
        climbRopeCommand.enableControl();
        CommandBase.oi.ropeButton.whileHeld(climbRopeCommand);
       
        
        CommandBase.oi.gearDoorsButton.whenReleased(gearDoorsCommand);
    }

    /**
     * This function is called periodically during operator control.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called to initialize test mode.
     */
    public void testInit() {
        System.out.println("TEST INIT");
    }
    
    /**
     * This function is called periodically during test mode.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
