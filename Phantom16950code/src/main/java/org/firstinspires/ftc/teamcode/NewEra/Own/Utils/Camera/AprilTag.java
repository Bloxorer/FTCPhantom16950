package org.firstinspires.ftc.teamcode.NewEra.Own.Utils.Camera;

import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

/**
 * класс для работы с априлтэгом
 */
public class AprilTag extends TenserFlow {
    public void startAprilTag(){
        aprilTagProcessor = new AprilTagProcessor.Builder()
                .build();
    }
}
