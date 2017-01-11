package org.usfirst.frc.team4373.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4373.robot.RobotMap;
import org.usfirst.frc.team4373.robot.commands.teleop.DriveWithJoystick;

/**
 * Programmatic representation of physical drive train components.
 * @author aaplmath
 * @author Henry Pitcairn
 */
public class DriveTrain extends Subsystem {
    private CANTalon left1;
    private CANTalon left2;
    private CANTalon right1;
    private CANTalon right2;
    private static DriveTrain driveTrain = null;

    public static DriveTrain getDriveTrain() {
        driveTrain = driveTrain == null ? new DriveTrain() : driveTrain;
        return driveTrain;
    }

    /**
     * Initializes motors on respective ports, sets break and reverse modes, and sets followers.
    */
    public DriveTrain() {
        super("DriveTrain");
        this.left1 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_1);
        this.left2 = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_2);
        this.right1 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_1);
        this.right2 = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_2);

        this.left1.enableBrakeMode(true);
        this.left2.enableBrakeMode(true);
        this.right1.enableBrakeMode(true);
        this.right2.enableBrakeMode(true);

        this.left1.reverseOutput(false);
        this.left2.reverseOutput(false);
        this.right1.reverseOutput(true);
        this.right2.reverseOutput(true);

        this.right2.changeControlMode(CANTalon.TalonControlMode.Follower);
        this.right2.set(RobotMap.RIGHT_DRIVE_MOTOR_1);
        this.left2.changeControlMode(CANTalon.TalonControlMode.Follower);
        this.left2.set(RobotMap.LEFT_DRIVE_MOTOR_1);
    }

    /**
     * Sets power to the left motors.
     * @param power The power to allocate to the left motors from -1 to 1.
     */
    public void setLeft(double power) {
        this.left1.set(power);
        this.left2.set(power);
    }

    /**
     * Sets power to the right motors.
     * @param power The power to allocate to the right motors from -1 to 1.
     */
    public void setRight(double power) {
        this.right1.set(power);
        this.right2.set(power);
    }

    /**
     * Sets power to both motors simultaneously.
     * @param power The power to allocate to both motors from -1 to 1.
     */
    public void setBoth(double power) {
        setLeft(power);
        setRight(power);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }

}
