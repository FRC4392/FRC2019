package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Fourbar{
    private TalonSRX mIntakePivot, mArmPivot;
    private Double CountsPerRoation = 4096.0*2;
    private Double DegreesPerRotation = 360.0;

    public Fourbar(){
        mIntakePivot = new TalonSRX(32);
        mIntakePivot.configFeedbackNotContinuous(true, 0);
        mIntakePivot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        mIntakePivot.setSelectedSensorPosition(mIntakePivot.getSensorCollection().getPulseWidthPosition());
        mIntakePivot.setSensorPhase(false);
        mIntakePivot.setInverted(false);
        mIntakePivot.configNominalOutputForward(0);
        mIntakePivot.configNominalOutputReverse(0);
        mIntakePivot.configPeakOutputForward(1);
        mIntakePivot.configPeakOutputReverse(-1);
        mIntakePivot.selectProfileSlot(0, 0);
        mIntakePivot.config_kF(0, 1.34);
        mIntakePivot.config_kP(0, 8);
        mIntakePivot.configMotionCruiseVelocity(766);
        mIntakePivot.configMotionAcceleration(766);
        mIntakePivot.setNeutralMode(NeutralMode.Coast);
        mIntakePivot.configContinuousCurrentLimit(10);
        mIntakePivot.configPeakCurrentLimit(10);
        mIntakePivot.configPeakCurrentDuration(1);
        mIntakePivot.enableCurrentLimit(true);

        mArmPivot = new TalonSRX(31);
        mArmPivot.configFeedbackNotContinuous(true, 0);
        mArmPivot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        mArmPivot.setSelectedSensorPosition(mArmPivot.getSensorCollection().getPulseWidthPosition());
        mArmPivot.setSensorPhase(false);
        mArmPivot.setInverted(false);
        mArmPivot.configNominalOutputForward(0);
        mArmPivot.configNominalOutputReverse(0);
        mArmPivot.configPeakOutputForward(1);
        mArmPivot.configPeakOutputReverse(-1);
        mArmPivot.selectProfileSlot(0, 0);
        mArmPivot.config_kF(0, 1.34);
        mArmPivot.config_kP(0, 8);
        mArmPivot.configMotionCruiseVelocity(766);
        mArmPivot.configMotionAcceleration(766);
        mArmPivot.setNeutralMode(NeutralMode.Brake);
        mArmPivot.configContinuousCurrentLimit(10);
        mArmPivot.configPeakCurrentLimit(10);
        mArmPivot.configPeakCurrentDuration(1);
        mArmPivot.enableCurrentLimit(true);
    }

    public void ArmAngle(Double angle) {
        //Double counts = angle * (DegreesPerRotation / CountsPerRoation);
        mArmPivot.set(ControlMode.MotionMagic, angle, DemandType.ArbitraryFeedForward, -.1);
    }
    public void IntakeAngle(Double angle) {
        //Double counts = angle * (DegreesPerRotation / CountsPerRoation);
        mIntakePivot.set(ControlMode.MotionMagic, angle);
    }

    public void setArmOpenLoop(Double output){
        mArmPivot.set(ControlMode.PercentOutput, output);
    }

    public void setIntakeOpenLoop(Double output){
        mIntakePivot.set(ControlMode.PercentOutput, output);
    }
}