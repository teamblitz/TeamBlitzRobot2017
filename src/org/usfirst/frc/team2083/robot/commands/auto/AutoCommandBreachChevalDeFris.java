package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachChevalDeFris extends CommandGroup {
    
    public  AutoCommandBreachChevalDeFris() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
    	addSequential(new AutoCommandMoveArm());
//    	addSequential(new AutoCommandMoveArm((long)0.5*1000, .3));
//       	addSequential(new AutoCommandDrive((long)3.5*1000, 6));
//        addSequential(new AutoCommandMoveArm());
//        addSequential(new AutoCommandDrive(5*1000, 2));
//        addSequential(new AutoCommandMoveArm(1000, 1));
    }    
}
