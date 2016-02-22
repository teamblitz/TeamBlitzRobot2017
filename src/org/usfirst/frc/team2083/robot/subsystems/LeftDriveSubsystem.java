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
public class LeftDriveSubsystem extends Subsystem {
    
    public CANJaguar leftFront;
    public CANJaguar leftBack;
    
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