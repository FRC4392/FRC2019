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
import frc.robot.Subsystems.*;
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
  Ramp mRamp = new Ramp();
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
    teleopPeriodic();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    int intakeAdd = 0;
    DriveSignal signal = mCheesy.cheesyDrive(mDriverController.getY(Hand.kLeft), - mDriverController.getX(Hand.kRight), mDriverController.getBumper(Hand.kRight));

    Double left = signal.leftMotor;
    Double right = signal.rightMotor;

    if(mDriverController.getTriggerAxis(Hand.kLeft) > 0.1){
      left *= .5;
      right *= .4;
    }

    mDrivetrain.setLeftRight(left, right);
    mDrivetrain.setGear(mDriverController.getBumper(Hand.kLeft));

    if (mDriverController.getStartButton()){
      mRamp.Deploy();
      mRamp.openLatch();
    }

    if((mDriverController.getTriggerAxis(Hand.kRight) > 0.1) & mRamp.getDeployed()){
      mRamp.engagePTO();
    } else {
      mRamp.disengagePTO();
    }
 
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
      mIntake.setIntake();
    } else if(mOperatorController.getBumper(Hand.kRight)){
      if(mOperatorController.getStickButton(Hand.kLeft)){
        mLift.setHeight(0);
        mFourbar.IntakeAngle(1350.0);
        mFourbar.ArmAngle(2666.0-2538);
      } else {
        mFourbar.IntakeAngle(2000.0);
        mFourbar.ArmAngle(3600.0-2538);
        mLift.setHeight(20);
      }
    } else if(mOperatorController.getBumper(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
        mIntake.setOuttake();
    }else if(mOperatorController.getAButton()){
      //Floor pickup
      mFourbar.ArmAngle(2666.0-2538);
      mFourbar.IntakeAngle(2800.0);
      mLift.setHeight(0);
    } else if (mOperatorController.getXButton()){
      //Low Goal
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
        mFourbar.ArmAngle(2666.0-2538);
      } else {
        mFourbar.IntakeAngle(2000.0);
        mFourbar.ArmAngle(4000.0-2538);
      }
      mLift.setHeight(0);
    } else if (mOperatorController.getYButton()){
      //Medium Goal
      mFourbar.ArmAngle(4000.0-2538);
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
      } else {
        mFourbar.IntakeAngle(2000.0);
      }
      mLift.setHeight(27.25-offset);
    } else if (mOperatorController.getBButton()){
      //High Goal
      mFourbar.ArmAngle(4000.0-2538);
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
