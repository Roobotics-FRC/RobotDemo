package org.usfirst.frc.team4373.robot.input.filter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Piecewise linear function for more granular joystick control.
 * @author (tesla)
 */
public class PiecewiseFilter2 implements IFilter {
    @Override
    public Object applyFilter(Object input) {
        Double x = (Double)input;
        double y;
        if (Math.abs(x) <= 0.8) {
            y = 0.5 * x;
        } else {
            y = (3 * x) - (Math.signum(x) * 2);
        }
        SmartDashboard.putNumber("In", x);
        SmartDashboard.putNumber("Out", y);
        return y;
    }
}
