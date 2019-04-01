package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Constants {

    //Drivetrain Constants
    //Drivetrain Motor Controller IDs
    public static final Integer DrivetrainLeft1DeviceID = 14;
    public static final Integer DrivetrainLeft2DeviceID = 15;
    public static final Integer DrivetrainLeft3DeviceID = 16;
    public static final Integer DrivetrainRight1DeviceID = 11;
    public static final Integer DrivetrainRight2DeviceID = 12;
    public static final Integer DrivetrainRight3DeviceID = 13;

    //Drivetrain Parameters
    public static final Double DrivetrainNominalOutputForward = 0.0;
    public static final Double DrivetrainNominalOutputReverse = 0.0;
    public static final Double DrivetrainPeakOutputForward = 1.0;
    public static final Double DrivetrainPeakOutputReverse = -1.0;

    //Left parameters
    public static final Boolean LeftDrivetrainSensorPhase = false;
    public static final Boolean LeftDriveMotorsInverted = false;

    //Right Parameters

    //Stilt lift
    public static final Double StiltsLiftNominalOutputForward = 0.0;
    public static final Double StiltsLiftNominalOutputReverse = 0.0;
    public static final Double StiltsLiftPeakOutputForward = 1.0;
    public static final Double StiltsLiftPeakOutputReverse = -1.0;

    public static final Boolean StiltsLiftSensorPhase = false;
    public static final NeutralMode StiltsLiftNeutralMode = NeutralMode.Coast;
    public static final Boolean StiltsLiftMotorInverted = false;

    //Stilts drive
    public static final Boolean StiltsDriveMotorInverted = true;

    //Intake
    public static final Boolean IntakeMotorInverted = true;
    public static final NeutralMode IntakeNeutralMode = NeutralMode.Brake;
    public static final Integer IntakePeakCurrentDuration = 100;
    public static final Integer IntakeContinuousCurrentLimit = 5;
    public static final Integer IntakePeakCurrentLimit = 20;
    public static final Boolean IntakeEnableCurrentLimit = true;

}
