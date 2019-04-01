package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Stilts{

    private VictorSPX mStiltLift;
    private CANSparkMax mStiltDrive;

    public Stilts(){
        mStiltDrive = new CANSparkMax(51, MotorType.kBrushless);
        mStiltLift = new VictorSPX(52);

        mStiltDrive.setInverted(true);

        //mStiltLift.configSelectedFeedbackSensor(feedbackDevice);
        mStiltLift.setSensorPhase(Constants.LeftDrivetrainSensorPhase);
        mStiltLift.setInverted(Constants.LeftDriveMotorsInverted);
        //mStiltLift.setStatusFramePeriod(frame, periodMs);
        mStiltLift.configNominalOutputForward(Constants.DrivetrainNominalOutputForward);
        mStiltLift.configNominalOutputReverse(Constants.DrivetrainNominalOutputReverse);
        mStiltLift.configPeakOutputForward(Constants.DrivetrainPeakOutputForward);
        mStiltLift.configPeakOutputReverse(Constants.DrivetrainPeakOutputReverse);
        //mStiltLift.selectProfileSlot(slotIdx, pidIdx);
        //mStiltLift.config_kF(slotIdx, value, timeoutMs);
        //mStiltLift.config_kP(slotIdx, value, timeoutMs);
        //mStiltLift.configMotionCruiseVelocity(sensorUnitsPer100ms);
        //mStiltLift.configMotionAcceleration(sensorUnitsPer100msPerSec);
        mStiltLift.setNeutralMode(NeutralMode.Coast);
    }

    public void Setspeed(double speed) {
        mStiltDrive.set(speed);
    }

    public void Setposition(int position) {
        mStiltLift.set(ControlMode.MotionMagic, position);
    }

    public void setUpDownSpeed(double speed){
        mStiltLift.set(ControlMode.PercentOutput, speed);
    }
}
