package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachBaseLine extends CommandGroup {
    
    public  AutoCommandBreachBaseLine() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
       	addSequential(new AutoCommandDrive(1*1000, 6));
       	addSequential(new AutoCommandTurnRight(1*500, 6));
       	addSequential(new AutoCommandDrive(1*1000, 6));
    }
}