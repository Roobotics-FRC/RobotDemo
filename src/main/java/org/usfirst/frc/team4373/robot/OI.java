package org.usfirst.frc.team4373.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import org.usfirst.frc.team4373.robot.input.filter.CubeFilter;
import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * OI encapsulates various inputs and outputs.
 * @author Henry Pitcairn
 */
public class OI {
    private static OI oi = null;

    public static OI getOI() {
        oi = oi == null ? new OI() : oi;
        return oi;
    }

    private RooJoystick driveJoystick;
    private ADXRS450_Gyro gyro;

    private OI() {
        this.driveJoystick = new RooJoystick(RobotMap.JOYSTICK_PORT, new CubeFilter());
    }

    public RooJoystick getDriveJoystick() {
        return this.driveJoystick;
    }

    public ADXRS450_Gyro getGyro() {
        return gyro;
    }
}
