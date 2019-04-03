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

        mStiltDrive.setInverted(Constants.StiltsDriveMotorInverted);
        mStiltLift.setSensorPhase(Constants.StiltsLiftSensorPhase);
        mStiltLift.setInverted(Constants.StiltsLiftMotorInverted);
        mStiltLift.configNominalOutputForward(Constants.StiltsLiftNominalOutputForward);
        mStiltLift.configNominalOutputReverse(Constants.StiltsLiftNominalOutputReverse);
        mStiltLift.configPeakOutputForward(Constants.StiltsLiftPeakOutputForward);
        mStiltLift.configPeakOutputReverse(Constants.StiltsLiftPeakOutputReverse);
        mStiltLift.setNeutralMode(Constants.StiltsLiftNeutralMode);

        mStiltLift.config_kF(0, .8, 0);
        mStiltLift.config_kP(0, .1, 0);
        mStiltLift.configMotionCruiseVelocity(1285, 0);
        mStiltLift.configMotionAcceleration(1285*2, 0);
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
