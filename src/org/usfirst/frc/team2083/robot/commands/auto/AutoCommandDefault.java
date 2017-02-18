/*
 * Copyright 2017 "TeamBlitz Robotics Club"
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandDefault extends CommandGroup {
    
    public  AutoCommandDefault() {    	
    	requires(CommandBase.leftDriveSubsystem);
    	requires(CommandBase.rightDriveSubsystem);

//        	addSequential(new AutoCommandMoveArm());
//        	addSequential(new AutoCommandMoveArm(100, 0.3));
//         	addSequential(new AutoCommandDrive((long) (2*1000), 3));
//        	addSequential(new AutoCommandMoveArm());
//         	addSequential(new AutoCommandDrive((long) (1.2*1000), 4));     
//         	addSequential(new AutoCommandMoveArm(100, 1));
//         	addSequential(new AutoCommandDrive((long) (2.25*1000), 4));     
    }
}
