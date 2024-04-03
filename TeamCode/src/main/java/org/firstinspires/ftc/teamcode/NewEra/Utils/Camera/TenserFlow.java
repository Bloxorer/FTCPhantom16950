package org.firstinspires.ftc.teamcode.NewEra.Utils.Camera;

import org.firstinspires.ftc.teamcode.NewEra.Phantom;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

public class TenserFlow extends Phantom {
    public void startTenserflow(){
       tfodProcessor = TfodProcessor.easyCreateWithDefaults();
    }
}
