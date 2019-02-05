package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Drivetrain{
    private TalonSRX mLeft1, mRight1;
    private VictorSPX mLeft2, mLeft3, mRight2, mRight3;

    public Drivetrain() {
        mLeft1 = new TalonSRX(Constants.DrivetrainLeft1DeviceID);
        mRight1 = new TalonSRX(Constants.DrivetrainRight1DeviceID);
        mLeft2 = new VictorSPX(Constants.DrivetrainLeft2DeviceID);
        mLeft3 = new VictorSPX(Constants.DrivetrainLeft3DeviceID);
        mRight2 = new VictorSPX(Constants.DrivetrainRight2DeviceID);
        mRight3 = new VictorSPX(Constants.DrivetrainRight3DeviceID);

        mLeft1.configSelectedFeedbackSensor(feedbackDevice);
        mLeft1.setSensorPhase(Constants.LeftDrivetrainSensorPhase);
        mLeft1.setInverted(Constants.LeftDriveMotorsInverted);
        mLeft1.setStatusFramePeriod(frame, periodMs);
        mLeft1.configNominalOutputForward(Constants.DrivetrainNominalOutputForward);
        mLeft1.configNominalOutputReverse(Constants.DrivetrainNominalOutputReverse);
        mLeft1.configPeakOutputForward(Constants.DrivetrainPeakOutputForward);
        mLeft1.configPeakOutputReverse(Constants.DrivetrainPeakOutputReverse);
        mLeft1.selectProfileSlot(slotIdx, pidIdx);
        mLeft1.config_kF(slotIdx, value, timeoutMs);
        mLeft1.config_kP(slotIdx, value, timeoutMs);
        mLeft1.configMotionCruiseVelocity(sensorUnitsPer100ms);
        mLeft1.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mLeft1.setNeutralMode(neutralMode);

        mLeft2.follow(mLeft1);
        mLeft2.setInverted(true);
        mLeft2.setNeutralMode(neutralMode);
        mLeft3.follow(mLeft1);
        mLeft3.setInverted(true);
        mLeft3.setNeutralMode(neutralMode);

        mRight1.configSelectedFeedbackSensor(feedbackDevice);
        mRight1.setSensorPhase(false);
        mRight1.setInverted(true);
        mRight1.setStatusFramePeriod(frame, periodMs);
        mRight1.setStatusFramePeriod(frame, periodMs);
        mRight1.configNominalOutputForward(percentOut);
        mRight1.configNominalOutputReverse(percentOut);
        mRight1.configPeakOutputForward(percentOut);
        mRight1.configPeakOutputReverse(percentOut);
        mRight1.selectProfileSlot(slotIdx, pidIdx);
        mRight1.config_kF(slotIdx, value, timeoutMs);
        mRight1.config_kP(slotIdx, value, timeoutMs);
        mRight1.configMotionCruiseVelocity(sensorUnitsPer100ms);
        mRight1.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mRight1.setNeutralMode(neutralMode);

        mRight2.follow(mRight1);
        mRight2.setInverted(false);
        mRight2.setNeutralMode(neutralMode);
        mRight3.follow(mRight1);
        mRight3.setInverted(false);
        mRight3.setNeutralMode(neutralMode);

    }

    public void setLeftRight(double left, double right){
        mLeft1.set(ControlMode.PercentOutput, -left);
        
        mRight1.set(ControlMode.PercentOutput, -right);
    }
} 
        

