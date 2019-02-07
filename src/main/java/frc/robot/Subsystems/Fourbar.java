package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Fourbar{
    private TalonSRX mIntakePivot, mArmPivot;

    public Fourbar(){
        mIntakePivot.configSelectedFeedbackSensor(feedbackDevice);
        mIntakePivot.setSensorPhase(false);
        mIntakePivot.setInverted(false);
        mIntakePivot.setStatusFramePeriod(frame, periodMs);
        mIntakePivot.setStatusFramePeriod(frame, periodMs);
        mIntakePivot.configNominalOutputForward(percentOut);
        mIntakePivot.configNominalOutputReverse(percentOut);
        mIntakePivot.configPeakOutputForward(percentOut);
        mIntakePivot.configPeakOutputReverse(percentOut);
        mIntakePivot.selectProfileSlot(slotIdx, pidIdx);
        mIntakePivot.config_kF(slotIdx, value);
        mIntakePivot.config_kP(slotIdx, value);
        mIntakePivot.configMotionCruiseVelocity(sensorUnitsPer100ms);
        mIntakePivot.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mIntakePivot.setNeutralMode(neutralMode);

        mArmPivot.setInverted(true);
        mArmPivot.follow(mIntakePivot);
        mArmPivot.setNeutralMode(neutralMode);
    }

}