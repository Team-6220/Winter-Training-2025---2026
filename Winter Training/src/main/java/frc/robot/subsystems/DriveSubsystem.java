// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final VictorSPX rightMaster = new VictorSPX(Constants.rightMasterID);
  private final VictorSPX rightSlave = new VictorSPX(Constants.rightSlaveID);
  private final VictorSPX leftMaster = new VictorSPX(Constants.leftMasterID);
  private final VictorSPX leftSlave = new VictorSPX(Constants.leftSlaveID);

  public DriveSubsystem() {
    rightSlave.follow(rightMaster);
    leftSlave.follow(leftMaster);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    rightMaster.set(ControlMode.PercentOutput, rightSpeed);
    leftMaster.set(ControlMode.PercentOutput, leftSpeed);
 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
