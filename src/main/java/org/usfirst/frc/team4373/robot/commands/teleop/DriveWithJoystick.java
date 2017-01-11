package org.usfirst.frc.team4373.robot.commands.teleop;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.CommandBase;
import org.usfirst.frc.team4373.robot.input.filter.HalfFilter;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;
import org.usfirst.frc.team4373.robot.subsystems.DriveTrain;

/**
 * This command handles operator control of the drive train subsystem.
 * It sets outputs based on joystick axes.
 * @author Henry Pitcairn
 */
public class DriveWithJoystick extends CommandBase {
    private DriveTrain driveTrain;
    private RooJoystick joystick;

    /**
     * Constructor for DriveWithJoystick.
     */
    public DriveWithJoystick() {
        requires(DriveTrain.getDriveTrain());
        driveTrain = DriveTrain.getDriveTrain();
        joystick = oi.getDriveJoystick();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double right = this.joystick.getAxis(RobotMap.JOYSTICK_FORWARD_AXIS)
                + this.joystick.getAxis(RobotMap.JOYSTICK_TWIST_AXIS, new HalfFilter());
        double left = this.joystick.getAxis(RobotMap.JOYSTICK_FORWARD_AXIS)
                - this.joystick.getAxis(RobotMap.JOYSTICK_TWIST_AXIS, new HalfFilter());
        driveTrain.setLeft(-left);
        driveTrain.setRight(-right);
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
