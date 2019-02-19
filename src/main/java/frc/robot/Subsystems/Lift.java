package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift{
    private TalonSRX mMotor1;
    private VictorSPX mMotor2;

    private static double offset = -0;
    private static double diameter = 1.25;
    private static double circumference = Math.PI * diameter;
    private static double countsPerRot = 4096;
    private static double distancePerCount = circumference/countsPerRot;
    private static double countsPerDistance = countsPerRot/circumference;

    double setPosition = 0;

    public Lift() {
        mMotor1 = new TalonSRX(21);
        mMotor2 = new VictorSPX(22);

        mMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        mMotor1.setSelectedSensorPosition(0);
        mMotor1.setSensorPhase(false);
        mMotor1.setInverted(false);
        mMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 0);
        mMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 0);
        mMotor1.configNominalOutputForward(0, 0);
        mMotor1.configNominalOutputReverse(0, 0);
        mMotor1.configPeakOutputForward(1, 0);
        mMotor1.configPeakOutputReverse(-1, 0);
        mMotor1.selectProfileSlot(0, 0);
        mMotor1.config_kF(0, .186, 0);
        mMotor1.config_kP(0, 2, 0);
        mMotor1.config_kD(0, 1, 0);
        mMotor1.configMotionCruiseVelocity(6000, 0);
        mMotor1.configMotionAcceleration(20000, 0);
        mMotor1.setNeutralMode(NeutralMode.Brake);

        mMotor2.setInverted(true);
        mMotor2.follow(mMotor1);
        mMotor2.setNeutralMode(NeutralMode.Brake);
    }

    public void setPosition(int position) {
        mMotor1.set(ControlMode.MotionMagic, position, DemandType.ArbitraryFeedForward, .3);
    }

    public void setPower(double Power) {
        mMotor1.set(ControlMode.PercentOutput, Power);
        mMotor2.follow(mMotor1);
    }
    public void setHeight(double inches) {
        double counts = (countsPerDistance * inches);
        SmartDashboard.putNumber("LiftHeight", counts);
        setPosition((int)counts);
    }

    public double getHeight() {
        return mMotor1.getSelectedSensorPosition(0) *distancePerCount;
    }
    public boolean getOnHeight(double target){
        return (Math.abs(getHeight() - target) < 3);
    }
}