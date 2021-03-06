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
public class AutoCommandRightTowerLiftWithTracking extends CommandGroup
{    
    public  AutoCommandRightTowerLiftWithTracking()
    {    	
    	requires(CommandBase.leftDriveSubsystem);
    	requires(CommandBase.rightDriveSubsystem);
    	
    	// 1. Drive Forward.
       	addSequential(new AutoCommandDrive((long)1.2*1000, 0.2));
       	
       	// 2. Turn towards tower.
       	addSequential(new AutoCommandTurnLeft((long)2 * 1000, 0.2));
       	
       	// 3. Drive towards tower.
       	addSequential(new AutoCommandDriveWhileTracking(.2));
       	
       	// 4. Stall for a short period while the gear doors open.
       	addSequential(new AutoCommandDrive((long)1000, 0));
       	addParallel(new AutoCommandGearDoors(AutoCommandGearDoors.DoorAction.OPEN));
       	addSequential(new AutoCommandDrive((long)1000, 0));
       	
       	// 5. Drive backwards and close gear doors.
       	addSequential(new AutoCommandDrive((long)1000, -0.2));
       	addParallel(new AutoCommandGearDoors(AutoCommandGearDoors.DoorAction.CLOSE));
    }
}
