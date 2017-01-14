package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandRightTowerLift extends CommandGroup {
    
    public  AutoCommandRightTowerLift() {    	
    	requires(CommandBase.leftDrive);
    	requires(CommandBase.rightDrive);
    	requires(CommandBase.armBar);
    	
     	addSequential(new AutoCommandDrive((long) (2.3*1000), 3));
//       	addSequential(new AutoCommandMoveArm((long)1.5*1000, -0.25));
     	addSequential(new AutoCommandDrive((long) (1*1000), -3));
       	
    }
}
