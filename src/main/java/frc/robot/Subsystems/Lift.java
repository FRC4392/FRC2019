package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Lift{
    private TalonSRX mMotor1;
    private TalonSRX mMotor2;

    private static double offset = -400;
    private static double diameter = 1.273;
    private static double circumference = Math.PI * diameter;
    private static double countsPerRot = 4096;
    private static double distancePerCount = circumference/countsPerRot;
    private static double countsPerDistance = countsPerRot/circumference;

    double setPosition = 0;

    public Lift() {
        mMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        mMotor1.setSensorPhase(false);
        mMotor1.setInverted(false);
        mMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 0);
        mMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 0);
        mMotor1.configNominalOutputForward(0, 0);
        mMotor1.configNominalOutputReverse(0, 0);
        mMotor1.configPeakOutputForward(1, 0);
        mMotor1.configPeakOutputReverse(-1, 0);
        mMotor1.selectProfileSlot(0, 0);
        mMotor1.config_kF(0, .16, 0);
        mMotor1.config_kP(0, .8, 0);
        mMotor1.configMotionCruiseVelocity(6387, 0);
        mMotor1.configMotionAcceleration(((int)(6387*2)), 0);
        mMotor1.setNeutralMode(NeutralMode.Brake);

        mMotor2.setInverted(true);
        mMotor2.follow(mMotor1);
        mMotor2.setNeutralMode(NeutralMode.Brake);
    }

    public void setPosition(int position) {
        mMotor1.set(ControlMode.MotionMagic, position);
        mMotor2.follow(mMotor1);
    }

    public void setPower(double Power) {
        mMotor1.set(ControlMode.PercentOutput, Power);
        mMotor2.follow(mMotor1);
    }
    public void setHeight(double inches) {
        double counts = (countsPerDistance * inches * -1 + offset)/2;
    }

    public void getHeight() {
        return mMotor1.getSelectedSensorPosition(0) *distancePerCount;
    }
    public boolean getOnHeight(double target){
        return (Math.abs(getHeight() - target) < 3);
    }
}