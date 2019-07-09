/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.jsonReaders.DriveSysReader;
import frc.robot.jsonReaders.RobotConfigReader;
import frc.robot.attachments.CargoIntake;
import frc.robot.attachments.HatchMechanism;
import frc.robot.attachments.Lift;
import frc.robot.driveSystem.DriveSystem;
import frc.robot.driveSystem.TalonSRX2spdDriveSystem;
import frc.robot.driveSystem.TalonSRXDriveSystem;
import frc.robot.driveSystem.VictorSPDriveSystem;
import frc.robot.util.LogitechF310;

/**
 * Main class for all robot code. Each "init" and "periodic" method is run 
 * before/during corresponding opmodes.
 */
public class Robot extends TimedRobot {
  //WPILib-generated instance variables
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  
  /*
   * Attachment and gamepad objects initialized null to prevent 
   * "object not initialized" error while enabling JSON configuration system
   */
  public DriveSystem driveSys;
  public CargoIntake cargoIntake=null;
  public HatchMechanism hatchMechanism=null;
  public Lift lift=null;
  LogitechF310 gamepad1;
  LogitechF310 gamepad2=null;

  //JSON config readers
  public RobotConfigReader robotConfigReader;
  public DriveSysReader driveSysReader;

  private boolean isTankDrive = false;
  private boolean isTwoGamepads = true;
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   * 
   * @see frc.robot.jsonReaders
   */
  @Override
  public void robotInit() {
    //WPILib-generated autonomous selector code
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    //Change constructor parameter to load different configuration in robots.json
    robotConfigReader = new RobotConfigReader("2019_robot");

    //Print values in selected robots.json configuration for debugging
    String driveSysString = robotConfigReader.getDriveSysName();
    System.out.println("frc6880: Robot: Drive System name - " + driveSysString);

    String navigationOptionString = robotConfigReader.getNavigationOption();
    System.out.println("frc6880: Robot: Navigation option - " + navigationOptionString);

    isTankDrive = robotConfigReader.isTankControl();
    System.out.println("frc6880: Robot: Is tank drive? - " + isTankDrive);

    String[] attachments = robotConfigReader.getAttachments();
    System.out.println("frc6880: Robot: Attachments - " + attachments);

    isTwoGamepads = robotConfigReader.isTwoGamepads();
    System.out.println("frc6880: Robot: Is two gamepads? - " + isTwoGamepads);
    
    driveSysReader = new DriveSysReader(driveSysString);

    //Generate driveSys and attachments using JSON configuration
    driveSys = generateDriveSys(driveSysString);
    generateAttachments(attachments);

    //Allows single/dual gamepad functionality based on JSON configuration
    gamepad1 = new LogitechF310(0);
    if(isTwoGamepads)
      gamepad2 = new LogitechF310(1);

    CameraServer.getInstance().startAutomaticCapture();

    System.out.println("frc6880: Robot: Done initializing");
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    cargoIntake.idleMotor();
  }

  /**
   * This function is called periodically during autonomous.
   * 
   * <p><i>Due to the Sandstorm period, the autonomous simply runs the TeleOp</i>
   */
  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

  /**
   * This function is called periodically during operator control. It contains code for both
   * single and dual gamepad configurations, as well as several automation features that prevent
   * human error while driving.
   * 
   * @see frc.robot.attachments
   * @see frc.robot.driveSystem
   * @see LogitechF310
   */
  @Override
  public void teleopPeriodic() {
    //All top-level if blocks check if attachment is initialized first

    //Cargo intake
    if(cargoIntake!=null){
      if(isTwoGamepads){
        if(gamepad2.dpadDown())
          cargoIntake.in();
        else if(gamepad2.dpadUp())
          cargoIntake.out();
        else
          cargoIntake.idleMotor();

        if(gamepad2.a())
          cargoIntake.down();
        else if (gamepad2.y())
          cargoIntake.up();
      }
      else{
        if(gamepad1.dpadDown())
          cargoIntake.in();
        else if(gamepad1.dpadUp())
          cargoIntake.out();
        else
          cargoIntake.idleMotor();

        if(gamepad1.a())
          cargoIntake.down();
        else if (gamepad1.y())
          cargoIntake.up();
      }
    }
    
    //Lift
    if(lift!=null){
      if(isTwoGamepads){
        lift.move(gamepad2.leftStickY());
      }
      else{
        double downPower = -Math.abs(gamepad1.leftTrigger());
        double upPower = Math.abs(gamepad1.rightTrigger());

        lift.move((downPower>upPower) ? downPower : upPower); //Ensures only 1 power direction used at a time
      }

      // if(lift.isInMidRange())
      //   driveSys.setSpeedMultiplier(0.75);
      // else if(lift.isInHighRange())
      //   driveSys.setSpeedMultiplier(0.25);
      // else
      //   driveSys.setSpeedMultiplier(1.0);
    }

    //Hatch mechanism
    if(hatchMechanism!=null){
      if(isTwoGamepads){
        //Prevents damage from punching hatch out while holding hatch
        if(gamepad2.rightBumper() && !hatchMechanism.isPlungerCompressed())
          hatchMechanism.punch();
        else if(gamepad2.leftBumper())
          hatchMechanism.retract();
        
        //Prevents damage from grabbing hatch in while punchers are extended
        if(gamepad2.x() && hatchMechanism.isPuncherRetracted())
          hatchMechanism.grab();
        else if(gamepad2.b())
          hatchMechanism.release();

        hatchMechanism.slide(-gamepad2.rightStickX());
      }
      else{
        if(gamepad1.dpadRight() && !hatchMechanism.isPlungerCompressed())
          hatchMechanism.punch();
        else if(gamepad1.dpadLeft())
          hatchMechanism.retract();
        
        if(gamepad1.x() && hatchMechanism.isPuncherRetracted())
          hatchMechanism.grab();
        else if(gamepad1.b())
          hatchMechanism.release();
      }
    }

    //Drivesystem
    if(gamepad1.leftBumper())
      driveSys.setLowGear();
    else if(gamepad1.rightBumper())
      driveSys.setHighGear();

    if(gamepad1.a())
      driveSys.reverse();

    if(isTankDrive){
      driveSys.tankDrive(gamepad1.leftStickY(), gamepad1.rightStickY());
    }
    else{
      driveSys.arcadeDrive(gamepad1.leftStickY(), -gamepad1.rightStickX());
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  /**
   * Creates a {@link DriveSystem} object that refers to drivesys type specified in
   * robots.json configuration.
   * 
   * @see frc.robot.driveSystem
   * @param driveSysString Drivesys type to be initialized
   * @return Initialized {@link DriveSystem} object
   */
  private DriveSystem generateDriveSys(String driveSysString){
    DriveSystem driveSystem=null;
    switch(driveSysString){
      case "VictorSPDriveSystem":
        driveSystem = new VictorSPDriveSystem(this);
        break;
      case "TalonSRX2spdDriveSystem":
        driveSystem = new TalonSRX2spdDriveSystem(this);
        break;
      case "TalonSRXDriveSystem":
        driveSystem = new TalonSRXDriveSystem(this);
        break;
      default:
        System.out.println("frc6880: Robot: Couldn't initialize " + driveSysString);
    }

    return driveSystem;
  }

  /**
   * Initializes the robot attachments listed in robots.json configuration, keeps
   * remaining attachments as null.
   * 
   * @see frc.robot.attachments
   * @param attachments List of attachment names to be initialized
   */
  private void generateAttachments(String[] attachments){
    for(String s : attachments){
      switch(s){
        case "CargoIntake":
          cargoIntake = new CargoIntake(this);
          break;
        case "Lift":
          lift = new Lift(this);
          break;
        case "HatchMechanism":
          hatchMechanism = new HatchMechanism(this);
          break;
        default:
          System.out.println("frc6880: Robot: Invalid attachment string ''" + s + "'");
          break;
      }
    }
  }
}
