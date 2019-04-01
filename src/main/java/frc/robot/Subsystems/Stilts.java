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
        mStiltLift.setSensorPhase(false);
        mStiltLift.setInverted(false);
        mStiltLift.configNominalOutputForward(Constants.StiltsLiftNominalOutputForward);
        mStiltLift.configNominalOutputReverse(Constants.StiltsLiftNominalOutputReverse);
        mStiltLift.configPeakOutputForward(Constants.StiltsLiftPeakOutputForward);
        mStiltLift.configPeakOutputReverse(Constants.StiltsLiftPeakOutputReverse);
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
