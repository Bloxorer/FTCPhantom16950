package org.firstinspires.ftc.teamcode.NewEra.Own.Utils.Camera;

import org.firstinspires.ftc.teamcode.NewEra.Own.Phantom;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

/**
 * класс для работы с тэнзорфлоу
 */
public class TenserFlow extends Phantom {

    // TODO: НА СЛЕДУЮЩИЙ СЕЗОН РАЗОБРАТЬСЯ С МОДЕЛЬКОЙ ДЛЯ ТЕНЗОРФЛОУ
    public void startTenserflow(){
        tfod = new TfodProcessor.Builder().build();
    }
}
