package org.firstinspires.ftc.teamcode.NewEra.Utils.Camera;

import static org.firstinspires.ftc.vision.VisionPortal.makeMultiPortalView;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.NewEra.Utils.Camera.AprilTag;
import org.firstinspires.ftc.teamcode.old.methods.Methods_for_OpenCV;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionPortalImpl;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

public class EasyCam extends AprilTag {
    int[] i = makeMultiPortalView(2, VisionPortal.MultiPortalLayout.VERTICAL);
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
    public EasyCam(boolean openCvIsTrue, boolean camera, boolean aprilTagIsTrue, boolean tenserFlowIsTrue) {
        OpenCvIsTrue = openCvIsTrue;
        Camera = camera;
        AprilTagIsTrue = aprilTagIsTrue;
        TenserFlowIsTrue = tenserFlowIsTrue;
    }

    public void cameraEasy(){
        if(OpenCvIsTrue){
            if (Camera){
                camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), i[1]);
                camera.openCameraDeviceAsync(cameraAsync);
                thread.start();
            } else {
                phonecam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, i[1]);
                phonecam.openCameraDeviceAsync(phonecamlistener);
                thread.start();
            }
        }
        if (AprilTagIsTrue) {
            startAprilTag();
            if (Camera){
            visionPortal = new VisionPortal.Builder()
                    .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
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
        } else if (TenserFlowIsTrue) {
            startTenserflow();
            if (Camera){
                visionPortal = new VisionPortal.Builder()
                        .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                        .addProcessor(tfodProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();
            } else {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(BuiltinCameraDirection.BACK)
                        .addProcessor(tfodProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();
            }
        } else if (TenserFlowIsTrue | AprilTagIsTrue) {
            startTenserflow();
            startAprilTag();
            if (Camera){
                visionPortal = new VisionPortal.Builder()
                        .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                        .addProcessors(tfodProcessor, aprilTagProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();
            } else {
                visionPortal = new VisionPortal.Builder()
                        .setCamera(BuiltinCameraDirection.BACK)
                        .addProcessors(tfodProcessor, aprilTagProcessor)
                        .setLiveViewContainerId(i[2])
                        .build();

            }
        }
    }
}
