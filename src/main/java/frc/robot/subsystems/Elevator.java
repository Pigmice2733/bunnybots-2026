package frc.robot.subsystems;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.CanConfig;

public class Elevator extends SubsystemBase{
    private TalonFX motor;
    double targetPosition;
    double speed;
    double currentHeight = 0;
    PositionVoltage positionRequest;
    public Elevator() {
        motor = new TalonFX(CanConfig.Elevator_ID);
        positionRequest = new PositionVoltage(0);
    }

    @Override
    public void periodic() {
        updateEntries();
        setHeight();
    }

    public void setHeight() {
        motor.setControl(positionRequest.withPosition(calculateRotations(targetPosition)));
    }

    public void setTargetHeight(double targetHeight) {
        targetPosition = targetHeight;
    }

    private double calculateRotations(double height) {
        return height/Constants.ElevatorConfig.ELEVATOR_RISE_RATIO;
    }

    private void updateEntries() {
        Constants.sendNumberToElastic("Elevator Speed", motor.getVelocity().getValueAsDouble(), 3);
    }
}
