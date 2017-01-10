package org.usfirst.frc.team4373.robot;

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

    private OI() {
        this.driveJoystick = new RooJoystick(RobotMap.JOYSTICK_PORT, new CubeFilter());
    }

    public RooJoystick getDriveJoystick() {
        return this.driveJoystick;
    }
}
