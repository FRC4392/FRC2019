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
        public void init() {
            
        }
    } 
        

