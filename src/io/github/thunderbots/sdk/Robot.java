package io.github.thunderbots.sdk;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import io.github.thunderbots.sdk.control.TGamepad;
import io.github.thunderbots.sdk.hardware.TMotor;
import io.github.thunderbots.sdk.hardware.TServo;

/**
 * 
 *
 * @author Zach Ohara
 */
public class Robot {
	
	private static HardwareMap robotHardware;
	private static TGamepad gamepad1;
	private static TGamepad gamepad2;
	
	public static void initializeRobot(HardwareMap hardware, Gamepad pad1, Gamepad pad2) {
		robotHardware = hardware;
		gamepad1 = new TGamepad(pad1);
		gamepad2 = new TGamepad(pad2);
	}
	
	public static TGamepad getGamepad1() {
		return gamepad1;
	}
	
	public static TGamepad getGamepad2() {
		return gamepad2;
	}
	
	public static TGamepad getGamepad(int gamepad) {
		switch(gamepad) {
			case 1:
				return getGamepad1();
			case 2:
				return getGamepad2();
			default:
				return null;
		}
	}
	
	public static TMotor getMotor(String name) {
		return new TMotor(robotHardware.dcMotor.get(name));
	}
	
	public static TServo getServo(String name) {
		return new TServo(robotHardware.servo.get(name));
	}

}