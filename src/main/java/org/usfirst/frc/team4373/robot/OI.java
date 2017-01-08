package org.usfirst.frc.team4373.robot;

import org.usfirst.frc.team4373.robot.input.hid.RooJoystick;

/**
 * Created by tesla on 10/22/16.
 */
public class OI {
    private static OI oi = null;

    public static OI getOI() {
        oi = oi == null ? new OI() : oi;
        return oi;
    }

    private RooJoystick driveJoystick;

    public OI() {
        this.driveJoystick = new RooJoystick(RobotMap.JOYSTICK_PORT);
    }

    public RooJoystick getDriveJoystick() {
        return this.driveJoystick;
    }
}
