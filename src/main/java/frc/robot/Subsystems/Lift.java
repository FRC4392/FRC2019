package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Lift{
    private TalonSRX mMotor1;
    private TalonSRX mMotor2;
    public Lift() {
        mMotor1.configSelectedFeedbackSensor(feedbackDevice);
        mMotor1.setSensorPhase(false);
        mMotor1.setInverted(false);
        mMotor1.setStatusFramePeriod(frame, periodMs);
        mMotor1.setStatusFramePeriod(frame, periodMs);
        mMotor1.configNominalOutputForward(percentOut);
        mMotor1.configNominalOutputReverse(percentOut);
        mMotor1.configPeakOutputForward(percentOut);
        mMotor1.configPeakOutputReverse(percentOut);
        mMotor1.selectProfileSlot(slotIdx, pidIdx);
        mMotor1.config_kF(slotIdx, value);
        mMotor1.config_kP(slotIdx, value);
        mMotor1.configMotionCruiseVelocity(sensorUnitsPer100ms);
        mMotor1.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mMotor1.setNeutralMode(NeutralMode.Brake);

        mMotor2.setInverted(true);
        mMotor2.follow(mMotor1);
        mMotor2.setNeutralMode(NeutralMode.Brake);
    }
}