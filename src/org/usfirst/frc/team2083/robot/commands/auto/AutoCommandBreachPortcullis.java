package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachPortcullis extends CommandGroup {
    
    public  AutoCommandBreachPortcullis() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
        	addSequential(new AutoCommandMoveArm());
        	addSequential(new AutoCommandMoveArm(100, 0.3));
         	addSequential(new AutoCommandDrive((long) (2*1000), 3));
        	addSequential(new AutoCommandMoveArm());
         	addSequential(new AutoCommandDrive((long) (1.2*1000), 4));     
         	addSequential(new AutoCommandMoveArm(100, 1));
         	addSequential(new AutoCommandDrive((long) (1*1000), 4));     
    }
}
