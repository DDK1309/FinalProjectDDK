package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;


public class Shaker {
    private TranslateTransition tt ;
    public Shaker (Node node){
        tt=new TranslateTransition(Duration.millis(70),  node);
        tt.setFromY(0f);
        tt.setByX(10f);

        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public void PlayAnimation(){
        tt.playFromStart();
    }
}
