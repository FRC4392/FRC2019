package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
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
        mIntakePivot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        mIntakePivot.setSensorPhase(false);
        mIntakePivot.setInverted(false);
        mIntakePivot.configNominalOutputForward(0);
        mIntakePivot.configNominalOutputReverse(0);
        mIntakePivot.configPeakOutputForward(1);
        mIntakePivot.configPeakOutputReverse(-1);
        mIntakePivot.selectProfileSlot(0, 0);
        mIntakePivot.config_kF(0, 0);
        mIntakePivot.config_kP(0, 0);
        mIntakePivot.configMotionCruiseVelocity(0);
        mIntakePivot.configMotionAcceleration(0);
        mIntakePivot.setNeutralMode(NeutralMode.Brake);

        mArmPivot = new TalonSRX(31);
        mArmPivot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        mArmPivot.setSensorPhase(false);
        mArmPivot.setInverted(false);
        mArmPivot.configNominalOutputForward(0);
        mArmPivot.configNominalOutputReverse(0);
        mArmPivot.configPeakOutputForward(1);
        mArmPivot.configPeakOutputReverse(-1);
        mArmPivot.selectProfileSlot(0, 0);
        mArmPivot.config_kF(0, 0);
        mArmPivot.config_kP(0, 0);
        mArmPivot.configMotionCruiseVelocity(0);
        mArmPivot.configMotionAcceleration(0);
        mArmPivot.setNeutralMode(NeutralMode.Brake);
    }


    public void ArmAngle(Double angle) {
        Double counts = angle * (DegreesPerRotation / CountsPerRoation);
        mArmPivot.set(ControlMode.MotionMagic, counts);
    }
    public void IntakeAngle(Double angle) {
        Double counts = angle * (DegreesPerRotation / CountsPerRoation);
        mIntakePivot.set(ControlMode.MotionMagic, counts);
    }

    public void setArmOpenLoop(Double output){
        mArmPivot.set(ControlMode.PercentOutput, output);
    }

    public void setIntakeOpenLoop(Double output){
        mIntakePivot.set(ControlMode.PercentOutput, output);
    }
}