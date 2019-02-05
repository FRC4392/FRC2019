package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain{
    private TalonSRX Left, Right;
    private VictorSPX left1,left2, right1, right2;
    public void setLeftRight(double left, double right){
        Left.set(ControlMode.PercentOutput, -left);
        left1.set(ControlMode.PercentOutput, -left);
        left2.set(ControlMode.PercentOutput, -left);
        
        Right.set(ControlMode.PercentOutput, -right);
        right1.set(ControlMode.PercentOutput, -right);
        right2.set(ControlMode.PercentOutput, -right);

        SmartDashboard.putNumber("Left", left);
        SmartDashboard.putNumber("Right", right);}
        public Drivetrain() {
        Left = new TalonSRX(deviceNumber);
        Right = new TalonSRX(deviceNumber);
        left1 = new VictorSPX(deviceNumber);
        left2 = new VictorSPX(deviceNumber);
        right1 = new VictorSPX(deviceNumber);
        right2 = new VictorSPX(deviceNumber);

        pidgey = new PidgeonIMU();

        Left.configSelectedFeedbackSensor(feedbackDevice);
        Left.setSensorPhase(false);
        Left.setInverted(false);
        Left.setStatusFramePeriod(frame, periodMs);
        Left.setStatusFramePeriod(frame, periodMs);
        Left.configNominalOutputForward(percentOut);
        Left.configNominalOutputReverse(percentOut);
        Left.configPeakOutputForward(percentOut);
        Left.configPeakOutputReverse(percentOut);
        Left.selectProfileSlot(slotIdx, pidIdx);
        Left.config_kF(slotIdx, value, timeoutMs);
        Left.config_kP(slotIdx, value, timeoutMs);
        Left.configMotionCruiseVelocity(sensorUnitsPer100ms);
        Left.configMotionAcceleration(sensorUnitsPer100msPerSec);
        Left.setNeutralMode(neutralMode);

        left1.follow(Left);
        left1.setInverted(true);
        left1.setNeutralMode(neutralMode);
        left2.follow(Left);
        left2.setInverted(true);
        left2.setNeutralMode(neutralMode);

        Right.configSelectedFeedbackSensor(feedbackDevice);
        Right.setSensorPhase(false);
        Right.setInverted(true);
        Right.setStatusFramePeriod(frame, periodMs);
        Right.setStatusFramePeriod(frame, periodMs);
        Right.configNominalOutputForward(percentOut);
        Right.configNominalOutputReverse(percentOut);
        Right.configPeakOutputForward(percentOut);
        Right.configPeakOutputReverse(percentOut);
        Right.selectProfileSlot(slotIdx, pidIdx);
        Right.config_kF(slotIdx, value, timeoutMs);
        Right.config_kP(slotIdx, value, timeoutMs);
        Right.configMotionCruiseVelocity(sensorUnitsPer100ms);
        Right.configMotionAcceleration(sensorUnitsPer100msPerSec);
        Right.setNeutralMode(neutralMode);

        right1.follow(right1);
        right1.setInverted(false);
        right1.setNeutralMode(neutralMode);
        right2.follow(right2);
        right2.setInverted(false);
        right2.setNeutralMode(neutralMode);

        }
    } 
        

