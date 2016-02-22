/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc.team2083.robot.subsystems;

import org.usfirst.frc.team2083.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Owner
 */
public class RightDriveSubsystem extends Subsystem {
    
    public CANJaguar rightFront;
    public CANJaguar rightBack;
    
    public RightDriveSubsystem() {
    //    super("Right Drive", 0.01, 0, 0, 0.02);
    	super("Right Drive");
    	this.rightFront = RobotMap.rightForwardMotorController;
        this.rightBack = RobotMap.rightBackMotorController;
    //    this.enable();
    //    this.getPIDController().setOutputRange(-12, 12);
        
    }

    protected void initDefaultCommand() {
    }
    
    public void enableControl() {
        rightBack.enableControl();
        rightFront.enableControl();
    }
    public void disableControl() {
        rightBack.disableControl();
        rightFront.disableControl();
    }

//    public double returnPIDInput() {
//       return -rightFront.getSpeed();
//    }
//
//    public void usePIDOutput(double d) {
////    	System.out.println("Right " + getSetpoint() + " " + returnPIDInput() + " " + d + " " + rightFront.getOutputCurrent() + " " + rightBack.getOutputCurrent());
////    	System.out.println("Right d = " + d);
//        rightFront.set(-d);
//        rightBack.set(-d);
//    }
    public void setVoltage(double voltage)
    {
    	rightFront.set(-voltage);
        rightBack.set(-voltage);
    }
}
