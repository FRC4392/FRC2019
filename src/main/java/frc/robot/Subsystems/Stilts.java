package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Stilts{

    private TalonSRX mStilts1, mStilts2;

    public Stilts(){
        mStilts1 = new TalonSRX(51);
        mStilts2 = new TalonSRX(52);

        //mStilts1.configSelectedFeedbackSensor(feedbackDevice);
        mStilts1.setSensorPhase(Constants.LeftDrivetrainSensorPhase);
        mStilts1.setInverted(Constants.LeftDriveMotorsInverted);
        //mStilts1.setStatusFramePeriod(frame, periodMs);
        mStilts1.configNominalOutputForward(Constants.DrivetrainNominalOutputForward);
        mStilts1.configNominalOutputReverse(Constants.DrivetrainNominalOutputReverse);
        mStilts1.configPeakOutputForward(Constants.DrivetrainPeakOutputForward);
        mStilts1.configPeakOutputReverse(Constants.DrivetrainPeakOutputReverse);
        //mStilts1.selectProfileSlot(slotIdx, pidIdx);
        //mStilts1.config_kF(slotIdx, value, timeoutMs);
        //mStilts1.config_kP(slotIdx, value, timeoutMs);
        //mStilts1.configMotionCruiseVelocity(sensorUnitsPer100ms);
        //mStilts1.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mStilts1.setNeutralMode(NeutralMode.Coast);
    }

    public void Setspeed(double speed) {
        mStilts1.set(ControlMode.PercentOutput, speed);
    }

    public void Setposition(int position) {
        mStilts2.set(ControlMode.MotionMagic, position, DemandType.ArbitraryFeedForward, .0);
    }
}
