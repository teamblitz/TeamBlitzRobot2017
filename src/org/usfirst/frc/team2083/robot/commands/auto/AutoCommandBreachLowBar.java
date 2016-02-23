package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachLowBar extends CommandGroup {
    
    public  AutoCommandBreachLowBar() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
    	addSequential(new AutoCommandMoveArm());
       	addSequential(new AutoCommandDrive(3*1000, 6));
       	addSequential(new AutoCommandDrive(1*1000, 6));
    }
}
