package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;

public class Intake{
    
    double intakeSpeed = 1;
    double outtakeSpeed = -1;
    int lastIntake = 0;

    private TalonSRX mintake1 = new TalonSRX(41);
    private Solenoid mIntakeClamp = new Solenoid(3);

    public Intake(){
        mintake1.setInverted(Constants.IntakeMotorInverted);
        mintake1.setNeutralMode(Constants.IntakeNeutralMode);
        mintake1.configPeakCurrentDuration(Constants.IntakePeakCurrentDuration);
        mintake1.configContinuousCurrentLimit(Constants.IntakeContinuousCurrentLimit);
        mintake1.configPeakCurrentLimit(Constants.IntakeContinuousCurrentLimit);
        mintake1.enableCurrentLimit(Constants.IntakeEnableCurrentLimit);
    }
    
    public void setSpeed(double speed) {
        mintake1.set(ControlMode.PercentOutput, speed);
    }

    public void setIntake() {
        setSpeed(intakeSpeed);
        openClamp();
        lastIntake = 1;
    }

    public void setOuttake() {
        setSpeed(outtakeSpeed);
        openClamp(); 
        lastIntake = -1;   
    }

    public void stop() {
        setSpeed(lastIntake * .2);
        closeClamp();
    } 

    public void closeClamp(){
        mIntakeClamp.set(false);
    }

    public void openClamp(){
        mIntakeClamp.set(true);
    }
}