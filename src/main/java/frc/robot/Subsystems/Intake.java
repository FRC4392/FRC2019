package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class Intake{
    
    double intakeSpeed = -1;
    double outtakeSpeed = 1;

    private TalonSRX mintake1 = new TalonSRX(41);

    public Intake(){
        mintake1.setInverted(true);
        mintake1.setNeutralMode(NeutralMode.Brake);
    }
    
    public void setSpeed(double speed) {
        mintake1.set(ControlMode.PercentOutput, speed);
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