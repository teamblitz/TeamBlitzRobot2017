package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachDrawbridge extends CommandGroup {
    
    public  AutoCommandBreachDrawbridge() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
    	addSequential(new AutoCommandMoveArm());
       	addSequential(new AutoCommandDrive(0*1000, 6));
       	
    }
}
