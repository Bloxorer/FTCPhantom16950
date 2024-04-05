package org.firstinspires.ftc.teamcode.NewEra.Utils.Camera;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class AprilTag extends TenserFlow {
    public void startAprilTag(){
        aprilTagProcessor = new AprilTagProcessor.Builder()
                .build();
    }
}
