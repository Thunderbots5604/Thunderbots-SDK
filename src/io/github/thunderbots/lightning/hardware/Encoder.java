package io.github.thunderbots.lightning.hardware;

/**
 * An {@code Encoder} represents a physical encoder that is attached to a specific motor.
 * 
 * @author Zach Ohara
 */
public class Encoder {

	private Motor baseMotor;
	private int zeroPoint;
	private double ticksPerRevolution;
	private double ticksPerInch;

	private static final double DEFAULT_TICKS_PER_REVOLUTION = 0d;
	private static final double DEFAULT_TICKS_PER_INCH = 0d;

	public Encoder(Motor motor) {
		this.baseMotor = motor;
		this.ticksPerRevolution = Encoder.DEFAULT_TICKS_PER_REVOLUTION;
		this.ticksPerInch = Encoder.DEFAULT_TICKS_PER_INCH;
		this.reset();
	}

	public void reset() {
		this.zeroPoint = this.baseMotor.getRawPosition();
	}

	public int getPosition() {
		return this.baseMotor.getRawPosition() - this.zeroPoint;
	}

	public double getRevolutions() {
		return this.getPosition() / this.ticksPerRevolution;
	}

	public double getInches() {
		return this.getPosition() / this.ticksPerInch;
	}

	public void setTicksPerRevolution(double ticks) {
		this.ticksPerRevolution = ticks;
	}

	public void setTicksPerInch(double ticks) {
		this.ticksPerInch = ticks;
	}

	@Override
	public String toString() {
		return "Encoder[" + this.baseMotor + "]";
	}

}