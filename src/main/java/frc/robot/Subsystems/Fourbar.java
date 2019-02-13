package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Fourbar{
    private TalonSRX mIntakePivot, mArmPivot;
    private Double CountsPerRoation = 4096.0;
    private Double DegreesPerRotation = 360.0;

    public Fourbar(){
        mIntakePivot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        mIntakePivot.setSensorPhase(false);
        mIntakePivot.setInverted(false);
        //mIntakePivot.setStatusFramePeriod(frame, periodMs);
        //mIntakePivot.setStatusFramePeriod(frame, periodMs);
        mIntakePivot.configNominalOutputForward(0);
        mIntakePivot.configNominalOutputReverse(0);
        mIntakePivot.configPeakOutputForward(1);
        mIntakePivot.configPeakOutputReverse(-1);
        //mIntakePivot.selectProfileSlot(slotIdx, pidIdx);
        //mIntakePivot.config_kF(slotIdx, value);
        //mIntakePivot.config_kP(slotIdx, value);
        //mIntakePivot.configMotionCruiseVelocity(sensorUnitsPer100ms);
       // mIntakePivot.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mIntakePivot.setNeutralMode(NeutralMode.Brake);

        mArmPivot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        mArmPivot.setSensorPhase(false);
        mArmPivot.setInverted(false);
        //mArmPivot.setStatusFramePeriod(frame, periodMs);
        //mArmPivot.setStatusFramePeriod(frame, periodMs);
        mArmPivot.configNominalOutputForward(0);
        mArmPivot.configNominalOutputReverse(0);
        mArmPivot.configPeakOutputForward(1);
        mArmPivot.configPeakOutputReverse(-1);
        //mArmPivot.selectProfileSlot(slotIdx, pidIdx);
        //mArmPivot.config_kF(slotIdx, value);
        //mArmPivot.config_kP(slotIdx, value);
        //mArmPivot.configMotionCruiseVelocity(sensorUnitsPer100ms);
       // mArmPivot.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mArmPivot.setNeutralMode(NeutralMode.Brake);
    }
    public void FourbarAngle(Double angle) {
        Double counts = angle * (DegreesPerRotation / CountsPerRoation);
    }
    public void IntakeAngle(Double angle) {
        Double counts = angle * (DegreesPerRotation / CountsPerRoation);
    }
}