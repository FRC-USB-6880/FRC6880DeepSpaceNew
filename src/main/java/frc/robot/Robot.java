/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.jsonReaders.DriveSysReader;
import frc.robot.jsonReaders.RobotConfigReader;
import frc.robot.attachments.CargoIntake;
import frc.robot.attachments.Lift;
import frc.robot.navigation.BobPathCreator;
import frc.robot.navigation.Navigation;
import frc.robot.driveSystem.DriveSystem;
import frc.robot.driveSystem.TalonSRX2spdDriveSystem;
import frc.robot.driveSystem.TalonSRXDriveSystem;
import frc.robot.driveSystem.VictorSPDriveSystem;
import frc.robot.util.LogitechF310;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  
  public DriveSystem driveSys;
  public CargoIntake cargoIntake=null;
  public Lift lift=null;
  LogitechF310 gamepad1;
  LogitechF310 gamepad2;
  public BobPathCreator bob = null;
  LogitechF310 gamepad;

  public RobotConfigReader robotConfigReader;
  public DriveSysReader driveSysReader;
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    robotConfigReader = new RobotConfigReader("2019_robot");
    System.out.println("frc6880: Robot: Drive System name - " + robotConfigReader.getDriveSysName());
    System.out.println("frc6880: Robot: Navigation option - " + robotConfigReader.getNavigationOption());
    System.out.println("frc6880: Robot: Autonomous Position - " + robotConfigReader.getAutoPosition());
    System.out.println("frc6880: Robot: Autonomous option - " + robotConfigReader.getAutoOption());
    System.out.println("frc6880: Robot: Robot Width - " + robotConfigReader.getRobotWidth());
    System.out.println("frc6880: Robot: Is tank drive? - " + robotConfigReader.isTankControl());
    System.out.println("frc6880: Robot: Attachments - " + robotConfigReader.getAttachments());
    String driveSysString = robotConfigReader.getDriveSysName();
    String navigationTypeString = robotConfigReader.getNavigationOption();
    driveSysReader = new DriveSysReader(driveSysString);
    driveSys = generateDriveSys(driveSysString);
    generateAttachments();

    gamepad1 = new LogitechF310(0);
    // gamepad2 = new LogitechF310(1);

    System.out.println("frc6880: Robot: Done initializing");
    navigationReader = new NavigationReader(navigationTypeString);
    bob = (BobPathCreator)(generateNavigation(navigationTypeString));
    gamepad = new LogitechF310(0);
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
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    if(cargoIntake!=null){
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
    
    if(lift!=null){
      // lift.move(gamepad2.rightStickY());
    }

    if(gamepad1.leftBumper())
      driveSys.setLowSpeed();
    else if(gamepad1.rightBumper())
      driveSys.setHiSpeed();

    driveSys.arcadeDrive(gamepad1.leftStickY(), -gamepad1.rightStickX());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

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

  private void generateAttachments(){
    String[] attachments = robotConfigReader.getAttachments();
    for(String s : attachments){
      switch(s){
        case "CargoIntake":
          cargoIntake = new CargoIntake(this);
          break;
        case "Lift":
          lift = new Lift(this);
          break;
        default:
          System.out.println("frc6880: Robot: Invalid attachment string ''" + s + "'");
          break;
      }
    }
  }
  private Navigation generateNavigation(String navigationTypeString){
    Navigation nav = null;
    switch(navigationTypeString){
      case "BobTrajectory":
        nav = new BobPathCreator(this);
        break;
      default:
        System.out.println("frc6880: Robot: Couldn't initialize " + navigationTypeString);
    }
    return nav;
  }

}
