package org.usfirst.frc.team4338.robot;

/**
 * Class that maps the wiring of the robot
 * @author orianleitersdorf
 *
 */
public class Constants {

	/** PWM **/
	public static final int LIFT_MOTOR_PORT = 0;
	public static final int SERVO_PORT = 1;
	
	/** DIO **/
	public static final int A_BUTTON_PORT = 0;
	public static final int B_BUTTON_PORT = 1;
	public static final int START_BUTTON_PORT = 4;
	
	
	/** Desired Values - Main Motor **/
	public static final double MOTOR_START_SPEED = 0;
	
	public static final double MOTOR_BE_SPEED = 0;
	
	/** Desired Values - Servo Motor **/
	public static final double SERVO_INITIAL_POSITION = 0;
	public static final double SERVO_FINAL_POSITION = 0.5;
	
	public static final double SERVO_BC_TIMEOUT = 9; //9 sec
	

}
