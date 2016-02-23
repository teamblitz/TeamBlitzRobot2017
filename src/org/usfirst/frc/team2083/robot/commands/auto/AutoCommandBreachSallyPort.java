package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandBreachSallyPort extends CommandGroup {
    
    public  AutoCommandBreachSallyPort() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
    	addSequential(new AutoCommandMoveArm());
     	addSequential(new AutoCommandDrive((long) (2*1000), 3));
       	addSequential(new AutoCommandMoveArm((long)1.5*1000, -0.25));
       	addSequential(new AutoCommandMoveArm((long)0.5*1000, 0.2));
       	addSequential(new AutoCommandDrive((long)1.5*1000, 2));
       	addSequential(new AutoCommandTurnLeft((long)0.25*1000, 8));
       	addSequential(new AutoCommandTurnRight((long)0.25*1000, 8));
       	addSequential(new AutoCommandDrive(4*1000, 6));
       	
    }
}
