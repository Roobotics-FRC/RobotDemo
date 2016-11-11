package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * Created by tesla on 10/22/16.
 */
public class Robot extends IterativeRobot {
    private TalonSRX test;

    @Override
    public void robotInit() {
        test = new TalonSRX(2);
        super.robotInit();
    }

    @Override
    public void teleopInit() {
        super.teleopInit();
    }

    @Override
    public void autonomousInit() {
        super.autonomousInit();
    }

    @Override
    public void autonomousPeriodic() {
        test.set(1.0);
        super.autonomousPeriodic();
    }

    @Override
    public void teleopPeriodic() {
        super.teleopPeriodic();
    }
}
