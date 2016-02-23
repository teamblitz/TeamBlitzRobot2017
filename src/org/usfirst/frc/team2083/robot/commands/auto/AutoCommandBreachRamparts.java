package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachRamparts extends CommandGroup {
    
    public  AutoCommandBreachRamparts() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
       	addSequential(new AutoCommandDrive(1*1000, 6));
       	addSequential(new AutoCommandTurnRight(1*500, 6));
       	addSequential(new AutoCommandDrive(1*1000, 6));
    }
}