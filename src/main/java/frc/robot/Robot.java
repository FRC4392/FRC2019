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
import edu.wpi.first.wpilibj.buttons.POVButton;
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
  Stilts mStilts = new Stilts();
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

    if (mDriverController.getAButton()){
      mStilts.Setspeed(left);
    } else {
      mStilts.Setspeed(0);
    }
    
    mDrivetrain.setGear(mDriverController.getBumper(Hand.kLeft));
  
 
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
        mFourbar.ArmAngle(2666.0*1.12-2905);
      } else {
        mFourbar.IntakeAngle(2000.0);
        mFourbar.ArmAngle(3600.0*1.12-2905);
        mLift.setHeight(20);
      }
    } else if(mOperatorController.getBumper(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
        mIntake.setOuttake();
    }else if(mOperatorController.getAButton()){
      //Floor pickup
      mFourbar.ArmAngle(584.0);
      mFourbar.IntakeAngle(2800.0);
      mLift.setHeight(0);
    } else if (mOperatorController.getXButton()){
      //Low Goal
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
        mFourbar.ArmAngle(2666.0*1.12-2905);
      } else {
        mFourbar.IntakeAngle(2000.0);
        mFourbar.ArmAngle(4000.0*1.12-2905);
      }
      mLift.setHeight(0);
    } else if (mOperatorController.getYButton()){
      //Medium Goal
      mFourbar.ArmAngle(4000.0*1.12-2905);
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
      } else {
        mFourbar.IntakeAngle(2000.0);
      }
      mLift.setHeight(27.25-offset);
    } else if (mOperatorController.getBButton()){
      //High Goal
      mFourbar.ArmAngle(4000.0*1.12-2905);
      if (mOperatorController.getStickButton(Hand.kLeft)){
        mFourbar.IntakeAngle(800.0);
      } else {
        mFourbar.IntakeAngle(2000.0);
      }
      mLift.setHeight(54.5-offset);
    } else if (mOperatorController.getPOV() == 0){
      //Level 2
      mLift.setHeight(0);
      mFourbar.ArmAngle(100.0);
      mFourbar.IntakeAngle(3500.0);
      mStilts.Setposition(13032);
    } else if (mOperatorController.getPOV() == 90){
      //Level 3
      mLift.setHeight(0);
      mFourbar.ArmAngle(0.0);
      mFourbar.IntakeAngle(0.0);
      mStilts.Setposition(28672);
    } else if (mOperatorController.getPOV() == 180){
      //Stilts up
      mStilts.Setposition(0);
    } else if (mOperatorController.getBackButton()){
      //Back in frame
      mFourbar.ArmAngle(2905.0);
    }

    



    
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
