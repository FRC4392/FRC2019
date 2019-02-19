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
import frc.robot.Subsystems.Fourbar;
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
  Fourbar mFourbar = new Fourbar();
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
    DriveSignal signal = mCheesy.cheesyDrive(mDriverController.getY(Hand.kLeft), - mDriverController.getX(Hand.kRight), mDriverController.getBumper(Hand.kRight));

    Double left = signal.leftMotor;
    Double right = signal.rightMotor;

    mDrivetrain.setLeftRight(left, right);
    mDrivetrain.setGear(mDriverController.getBumper(Hand.kLeft));

    // if(mOperatorController.getXButton()){
    //     mLift.setHeight(54.5);
    // } else if (mOperatorController.getYButton()){
    //   mLift.setHeight(1);
    // } else if (mOperatorController.getBackButton()){
    //   mLift.setHeight(27.25);
    // }
 
    if (mOperatorController.getTriggerAxis(Hand.kRight)>0.05){
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mIntake.setOuttake();
      } else {
        mIntake.setIntake();
      }
    } else if (mOperatorController.getTriggerAxis(Hand.kLeft)>0.05){
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mIntake.setIntake();
      } else {
      mIntake.setOuttake();
      }
    } else {
      mIntake.stop();
    }

    double offset = mOperatorController.getStickButton(Hand.kLeft) ? 15.0 : 0.0;
    if (mOperatorController.getStartButton()){
      mFourbar.IntakeAngle(2800.0);
      mIntake.setOuttake();
    } else if(mOperatorController.getBumper(Hand.kRight)){
      if(mOperatorController.getStickButton(Hand.kLeft)){
        mLift.setHeight(0);
        mFourbar.IntakeAngle(1350.0);
        mFourbar.ArmAngle(2666.0-2038);
      } else {
        mFourbar.IntakeAngle(2000.0);
        mFourbar.ArmAngle(4000.0-2038);
        mLift.setHeight(10);
      }
    } else if(mOperatorController.getBumper(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
        mIntake.setOuttake();
    }else if(mOperatorController.getAButton()){
      //Floor pickup
      mFourbar.ArmAngle(2666.0-2038);
      mFourbar.IntakeAngle(2800.0);
      mLift.setHeight(0);
    } else if (mOperatorController.getXButton()){
      //Low Goal
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
        mFourbar.ArmAngle(2666.0-2038);
      } else {
        mFourbar.IntakeAngle(2000.0);
        mFourbar.ArmAngle(4000.0-2038);
      }
      mLift.setHeight(0);
    } else if (mOperatorController.getYButton()){
      //Medium Goal
      mFourbar.ArmAngle(4000.0-2038);
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
      } else {
        mFourbar.IntakeAngle(2000.0);
      }
      mLift.setHeight(27.25-offset);
    } else if (mOperatorController.getBButton()){
      //High Goal
      mFourbar.ArmAngle(4000.0-2038);
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
      } else {
        mFourbar.IntakeAngle(2000.0);
      }
      mLift.setHeight(54.5-offset);
    }

    
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
