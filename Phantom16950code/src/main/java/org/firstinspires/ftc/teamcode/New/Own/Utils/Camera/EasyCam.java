package org.firstinspires.ftc.teamcode.New.Own.Utils.Camera;

import static org.firstinspires.ftc.vision.VisionPortal.makeMultiPortalView;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

/**
 * класс запуска камеры
 */
public class EasyCam extends AprilTag {
    WebcamName webcamName;
    int[] i = makeMultiPortalView(3, VisionPortal.MultiPortalLayout.VERTICAL);
    boolean OpenCvIsTrue = false;
    boolean Camera = false;
    boolean AprilTagIsTrue = false;
    boolean TenserFlowIsTrue = false;
    Thread thread = new Thread(() -> {
        while (opModeInInit()){
            valLeft = OpenCvOld.getValLeft();
            valRight = OpenCvOld.getValRight();
        }
    });
    /**
     * открытваем внешнюю камеру ассинхронно
     */
    OpenCvCamera.AsyncCameraOpenListener cameraAsync = new OpenCvCamera.AsyncCameraOpenListener() {
        @Override
        public void onOpened() {
            camera.setPipeline(new OpenCvOld.StageSwitchingPipeline());
            camera.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
        }
        @Override
        public void onError(int i) {
        }
    };
    /**
     * открытваем камеру телефона ассинхронно
     */
    OpenCvCamera.AsyncCameraOpenListener phonecamlistener = new OpenCvCamera.AsyncCameraOpenListener() {
        @Override
        public void onOpened() {
            phonecam.setPipeline(new OpenCvOld.StageSwitchingPipeline());
            phonecam.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
        }
        @Override
        public void onError(int i) {
        }
    };

    /**
     * Конструктор камеры, принимает значнеия от пользователя
     * @param webcamName имя вебкмеры, требуется  hardwareMap.get(WebcamName.class, "имя камеры")
     * @param openCvIsTrue используете ли вы opencv
     * @param camera используете ли вы внешнюю камеру
     * @param aprilTagIsTrue используете ли вы април тэги
     * @param tenserFlowIsTrue используете ли вы април тэнсорфлоу
     */
    public EasyCam(WebcamName webcamName, boolean openCvIsTrue, boolean camera, boolean aprilTagIsTrue, boolean tenserFlowIsTrue) {
        this.webcamName = webcamName;
        OpenCvIsTrue = openCvIsTrue;
        Camera = camera;
        AprilTagIsTrue = aprilTagIsTrue;
        TenserFlowIsTrue = tenserFlowIsTrue;
    }
    // проверяем значения полученные от пользователя
        public void cameraEasy(){

        if(OpenCvIsTrue){
            if (Camera){
                camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, i[1]);
                camera.openCameraDeviceAsync(cameraAsync);
                thread.start();
            } else {
                phonecam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, i[1]);
                phonecam.openCameraDeviceAsync(phonecamlistener);
                thread.start();
            }
        }
        if (AprilTagIsTrue && !TenserFlowIsTrue) {
            startAprilTag();
            if (Camera){
                visionPortal = new VisionPortal.Builder()
                        .setCamera(webcamName)
                        .addProcessor(aprilTagProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();
            } else{
                visionPortal = new VisionPortal.Builder()
                        .setCamera(BuiltinCameraDirection.BACK)
                        .addProcessor(aprilTagProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();
            }
        } else if (TenserFlowIsTrue && !AprilTagIsTrue) {
            startTenserflow();
            if (Camera){
                visionPortal = new VisionPortal.Builder()
                        .setCamera(webcamName)
                        .addProcessor(tfod)
                        .setLiveViewContainerId(i[2])
                        .build();
            } else {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(BuiltinCameraDirection.BACK)
                        .addProcessor(tfod)
                        .setLiveViewContainerId(i[2])
                        .build();
            }
        } else if (TenserFlowIsTrue && AprilTagIsTrue) {
            startTenserflow();
            startAprilTag();
            if (Camera) {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(webcamName)
                        .addProcessors(tfod, aprilTagProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();
            } else {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(BuiltinCameraDirection.BACK)
                        .addProcessors(tfod, aprilTagProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();

            }
        }
    }
}
