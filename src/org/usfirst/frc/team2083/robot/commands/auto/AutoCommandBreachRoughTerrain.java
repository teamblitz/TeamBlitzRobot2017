package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachRoughTerrain extends CommandGroup {
    
    public  AutoCommandBreachRoughTerrain() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
       	addSequential(new AutoCommandDrive(3*1000, 6));
       	;
    }
}
