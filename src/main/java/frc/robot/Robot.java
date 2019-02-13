/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Lift;
import frc.util.CheesyDriveHelper;
import frc.util.DriveSignal;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  Drivetrain mDrivetrain = new Drivetrain();
  Lift mLift = new Lift();
  XboxController mDriverController = new XboxController(0);
  XboxController mOperatorController = new XboxController(1);
  CheesyDriveHelper mCheesy = new CheesyDriveHelper();
  Intake mIntake = new Intake();

  /**
   * This function
   *  is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    DriveSignal signal = mCheesy.cheesyDrive(mDriverController.getY(Hand.kLeft), - mDriverController.getX(Hand.kRight), false);

    Double left = signal.leftMotor;
    Double right = signal.rightMotor;

    mDrivetrain.setLeftRight(left, right);
    mDrivetrain.setGear(mDriverController.getBumper(Hand.kLeft));

    if(mOperatorController.getAButton()){
        mLift.setPower(-1);
    } else if (mOperatorController.getBButton()){
      mLift.setPower(1);
    } else {
      mLift.setPower(0);
    }

    if (mOperatorController.getBumper(Hand.kRight)){
      mIntake.setIntake();
    } else if (mOperatorController.getBumper(Hand.kLeft)){
      mIntake.setOuttake();
    } else {
      mIntake.stop();
    }
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
