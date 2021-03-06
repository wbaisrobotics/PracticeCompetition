package org.usfirst.frc.team4338.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Practice Competition - Marble Game 
 * 
 * @author Orian Leitersdorf
 *
 * December 4th, 2017
 *
 */
public class Robot extends IterativeRobot {

	/** Marble object representing the marble's current position **/
	private Marble marble;

	/** The system representing the Lift **/
	private Lift lift; 

	/** The Servo motor used in the center **/
	private Servo servo; 

	/** The button which starts everything **/
	private DebouncedDigitalInput start; 
	/** The button at finish **/
	private DebouncedDigitalInput finish;
	/** The button at point B **/
	private DebouncedDigitalInput pointB; 

	/**
	 * Sets up digital inputs, motors, controllers, and timers
	 */
	@Override
	public void robotInit() {

		lift = new Lift (new Victor (Constants.LIFT_MOTOR_PORT));

		servo = new Servo (Constants.SERVO_PORT);

		start = new DebouncedDigitalInput (Constants.START_BUTTON_PORT);
		pointB = new DebouncedDigitalInput (Constants.B_BUTTON_PORT);
		finish = new DebouncedDigitalInput (Constants.A_BUTTON_PORT);

	}

	/**
	 * Reset motors, marble position, etc once teleop starts
	 */
	public void teleopInit () {

		marble = new Marble();

		updateMotors();

	}

	/**
	 * Checks the values of the digital inputs and prints out the results
	 */
	@Override
	public void teleopPeriodic() {

		if (start.isNewPressed()) {
			marble.startPressed();
		}
		else if (pointB.isNewPressed()) {
			marble.bPressed();
		}
		else if (finish.isNewPressed()) {
			marble.finishedPressed();
		}

		updateMotors(); 

	}

	/**
	 * Sets the motors to the correct position based on the marble variable
	 * (Main motor and Servo)
	 */
	private void updateMotors() {

		switch (marble.getLocation()) {

		case STILL_NOT_PLACED:
			lift.stop();
			servo.set(Constants.SERVO_INITIAL_POSITION);
			break;
			
		case AF:
			servo.set(Constants.SERVO_INITIAL_POSITION);
			lift.moveSlowly();
			break;
			
		case F:
			servo.set(Constants.SERVO_INITIAL_POSITION);
			lift.stop();
			break;
			
		case FB:
			servo.set(Constants.SERVO_INITIAL_POSITION);
			lift.moveQuickly();
			break;
			
		case BE:
			servo.set(Constants.SERVO_INITIAL_POSITION);
			lift.stop();
			break;
			
		case EA:
			servo.set(Constants.SERVO_FINAL_POSITION);
			lift.stop();
			break;
			
		case FINISHED:
			lift.stop();
			servo.set(Constants.SERVO_INITIAL_POSITION);
			break;
			
		}

	}

	/**
	 * Initializes test code for changing the position of the servo
	 */
	public void testInit() {
		lift.stop();
		SmartDashboard.putNumber(Constants.TESTING_MODE_SERVO_KEY, Constants.SERVO_INITIAL_POSITION);
	}
	
	/**
	 * Updates the servo's position to that given by the SmartDashboard
	 */
	public void testPeriodic() {
		servo.set(SmartDashboard.getNumber(Constants.TESTING_MODE_SERVO_KEY, Constants.SERVO_INITIAL_POSITION));
	}


}

