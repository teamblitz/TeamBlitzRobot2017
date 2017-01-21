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

import org.usfirst.frc.team2083.robot.commands.CommandBase;
import org.usfirst.frc.team2083.robot.commands.DriveCommand;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandBreachBaseLine;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandCenterTowerLift;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandDefault;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandLeftTowerLift;
import org.usfirst.frc.team2083.robot.commands.auto.AutoCommandRightTowerLift;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
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

	// Robot commands
	DriveCommand driveCommand;

    // Autonomous commands and selection
    Command autonomousCommand;
    SendableChooser<CommandGroup> autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("ROBOT INIT");

        RobotMap.leftForwardMotorController = new CANTalon(RobotMap.LEFT_FORWARD_MOTOR_CONTROLLER_ID);
        RobotMap.leftBackMotorController = new CANTalon(RobotMap.LEFT_BACK_MOTOR_CONTROLLER_ID);
        RobotMap.rightForwardMotorController = new CANTalon(RobotMap.RIGHT_FORWARD_MOTOR_CONTROLLER_ID);
        RobotMap.rightBackMotorController = new CANTalon(RobotMap.RIGHT_BACK_MOTOR_CONTROLLER_ID);
        
        RobotMap.leftForwardMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        RobotMap.leftBackMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        RobotMap.rightForwardMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        RobotMap.rightBackMotorController.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
                
//        double p = 1;
//        double i = .01;
//        double d = 0;
//        double f = 0;
//        int izone = 0;
//        double closeLoopRampRate = 10;
//        int profile = 0;
        //RobotMap.armBarMotorController.setPID(p , i , d, f, izone, closeLoopRampRate, profile);
       // RobotMap.armBarMotorController.reverseSensor(false);
        
        
//        RobotMap.leftFront.setPositionMode(CANTalon.kQuadEncoder, 360, 0.01, 0, 0);
//        RobotMap.rightFront.setPositionMode(CANTalon.kQuadEncoder, 250, 0.01, 0, 0);
        
//        RobotMap.leftFront.setSpeedReference(CANTalon.SpeedReference.kQuadEncoder);
//        RobotMap.rightFront.setSpeedReference(CANTalon.SpeedReference.kQuadEncoder);
//        RobotMap.leftFront.setPositionReference(CANTalon.PositionReference.kQuadEncoder);
//        RobotMap.rightFront.setPositionReference(CANTalon.PositionReference.kQuadEncoder);
                                    
        // Initialize all subsystems
        CommandBase.init();
        driveCommand = new DriveCommand();
        driveCommand.disableControl();
                
        // Autonomous setup.
        autoChooser = new SendableChooser<CommandGroup>();
        autoChooser.addDefault("Default (Nothing)", new AutoCommandDefault());
        autoChooser.addObject("Breach Base Line", new AutoCommandBreachBaseLine());
        autoChooser.addObject("Left Tower Lift", new AutoCommandLeftTowerLift());
        autoChooser.addObject("Center Tower Lift", new AutoCommandCenterTowerLift());
        autoChooser.addObject("Right Tower Lift", new AutoCommandRightTowerLift());

        SmartDashboard.putData("Autonmous Mode", autoChooser);       
    }

    public void autonomousInit() {
        System.out.println("AUTONOMOUS INIT");

        driveCommand.enableControl();

        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
        System.out.println("TELEOP INIT");

        driveCommand.enableControl();
        driveCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
