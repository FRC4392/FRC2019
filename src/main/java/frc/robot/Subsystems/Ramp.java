package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;

public class Ramp{

    private Solenoid mLatch = new Solenoid(5);
    private Solenoid mDeployer = new Solenoid(4);
    private Solenoid mPTO = new Solenoid(2);
    

    public void openLatch(){
        mLatch.set(true);
    }

    public void closeLatch(){
        mLatch.set(false);
    }
    
    public void Deploy(){
        mDeployer.set(true);
    }

    public void notDeploy(){
        mDeployer.set(false);
    }

    public void engagePTO(){
        mPTO.set(true);
    }

    public void disengagePTO(){
        mPTO.set(false);
    }

    public Boolean getDeployed(){
        return mDeployer.get();
    }
}