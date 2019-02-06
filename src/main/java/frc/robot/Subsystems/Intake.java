package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class Intake{
    
    double intakeSpeed = -1;
    double outtakeSpeed = .5;

    private TalonSRX mintake1 = new TalonSRX(deviceNumber);
    private TalonSRX mintake2 = new TalonSRX(deviceNumber);

    public Intake(){
        mintake1.follow(mintake2);
        mintake1.setInverted(true);
        mintake1.setNeutralMode(NeutralMode.Brake);
        mintake2.setNeutralMode(NeutralMode.Brake);
    }
    
    public void setSpeed(double speed) {
        mintake2.set(ControlMode.PercentOutput, speed);
    }

    public void setIntake() {
        setSpeed(intakeSpeed);
    }

    public void setOuttake() {
        setSpeed(outtakeSpeed);    
    }

    public void stop() {
        setSpeed(0);
    } 
}