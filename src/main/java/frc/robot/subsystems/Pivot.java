package frc.robot.subsystems;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConfig;

public class Pivot extends SubsystemBase {
    private SparkMax motor;
    private double targetSpeed;
    private boolean on;

    public Pivot() {
        motor = new SparkMax(CanConfig.PIVOT_ID,MotorType.kBrushless);
    }

    @Override
    public void periodic(){
        setSpeed();
    }

    public void setSpeed() {
        motor.set(targetSpeed);
    }

    public void intakeDown() {

    }
}
