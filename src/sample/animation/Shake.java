package sample.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node){   // анимация, когда пользоваетель оставил поля пустыми
        tt = new TranslateTransition(Duration.millis(70),node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(6);
        tt.setAutoReverse(true);
    }
    public void playAnimation(){
        tt.playFromStart();
    }
}
