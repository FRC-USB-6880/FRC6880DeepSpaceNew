package frc.robot.driveSystem;

public interface DriveSystem{
    enum Gears {LOW, HIGH};
    void tankDrive(double leftSpeed, double rightSpeed);
    void arcadeDrive(double speed, double direction);
    void resetEncoders();
    double getEncoderDist();
    double getLeftEncoderDist();
    double getRightEncoderDist();
    void setLowGear();
    void setHighGear();
    boolean isMoving();
    Gears getCurGear();
    void setSpeedMultiplier(double multiplier);
    void setDirectionMultiplier(double multiplier);
    double getSpeedMultiplier();
    void reverse();
    double getWidth();
}