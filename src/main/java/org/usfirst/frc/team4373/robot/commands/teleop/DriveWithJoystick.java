package org.usfirst.frc.team4373.robot.commands.teleop;

import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * This command handles operator control of the drive train subsystem.
 * It sets outputs based on joystick axes.
 * @author (tesla)
 */
public class DriveWithJoystick extends CommandBase {
    private DriveTrain driveTrain;
    private RooJoystick joystick;


    @Override
    protected void initialize() {
        driveTrain = DriveTrain.getDriveTrain();
        joystick = oi.getDriveJoystick();
    }

    @Override
    protected void execute() {
        double right = this.joystick.getAxis(1) - this.joystick.getAxis(3);
        double left = this.joystick.getAxis(1) + this.joystick.getAxis(3);
        driveTrain.setLeft(left);
        driveTrain.setRight(right);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        this.driveTrain.setBoth(0);
    }
}
