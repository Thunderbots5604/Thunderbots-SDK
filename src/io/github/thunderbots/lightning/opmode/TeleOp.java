/* Copyright (C) 2015 Thunderbots-5604
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.thunderbots.lightning.opmode;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;

/**
 * The TeleOp class is a base class that all tele-op programs should extend. It will handle
 * everything directly related to driving and moving the robot.
 *
 * @author Zach Ohara
 */
public abstract class TeleOp extends SimpleOpMode {

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			Joystick drivingGamepad = Lightning.getJoystick(1);
			this.getDrive().setMovement(drivingGamepad.leftStickY(), drivingGamepad.rightStickX());
			Lightning.sendTelemetryData("joy1",
					drivingGamepad.leftStickY() + ", " + drivingGamepad.rightStickX());
		}
	}

}