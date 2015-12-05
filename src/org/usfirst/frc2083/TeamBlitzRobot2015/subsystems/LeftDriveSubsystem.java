/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2083.TeamBlitzRobot2015.subsystems;

import org.usfirst.frc2083.TeamBlitzRobot2015.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Owner
 */
public class LeftDriveSubsystem extends PIDSubsystem {
    
    CANJaguar leftFront = RobotMap.leftForwardMotorController;
    CANJaguar leftBack = RobotMap.leftBackMotorController;
    
    public LeftDriveSubsystem() {
        super("Left Drive", 0.01, 0.0, 0.0, 0.02);
        this.enable();
        this.getPIDController().setOutputRange(-12, 12);
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

    public double returnPIDInput() {
        return leftFront.getSpeed();
    }

    public void usePIDOutput(double d) {
//        System.out.println("Left " + getSetpoint() + " " + returnPIDInput() + " " + d + " " + leftFront.getOutputCurrent() + " " + leftBack.getOutputCurrent());
        leftFront.set(-d);
        leftBack.set(-d);
    }
    
}