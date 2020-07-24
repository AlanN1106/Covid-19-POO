package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

;import java.awt.*;

public class Main extends Application {

    AnimationTimer animationTimer;
    double brightness = 1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane TOP = FXMLLoader.load(getClass().getResource("/sample/fxml/BuscadorView.fxml"));
        AnchorPane BOTTOM = FXMLLoader.load(getClass().getResource("/sample/fxml/ControllerView.fxml"));
        Group root = new Group();
        root.getChildren().addAll(TOP);
        primaryStage.setTitle("Hello World");


        AnchorPane anchorPaneInicial = new AnchorPane();
        Text text = new Text("Informaciones COVID-19");
        text.setLayoutX(217);
        text.setLayoutY(208);
        text.setFont(Font.font(24));
        text.setStyle("-fx-font-style: italic;");
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                brightness -= 0.005;
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(brightness);
                text.setEffect(colorAdjust);
            }
        };
        animationTimer.start();
        HBox hBoxInicial = new HBox(5);
        Hyperlink hyperlinkInicial = new Hyperlink("Empezar!");
        hyperlinkInicial.setFont(Font.font(24));
        hyperlinkInicial.setAlignment(Pos.CENTER);
        hyperlinkInicial.setContentDisplay(ContentDisplay.CENTER);
        hBoxInicial.getChildren().addAll(hyperlinkInicial);
        hBoxInicial.setLayoutX(292);
        hBoxInicial.setLayoutY(295);
        anchorPaneInicial.getChildren().addAll(text,hBoxInicial);

        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// obtenemos dimesiones de la pantalla
        Scene scene = new Scene(anchorPaneInicial,700,510);
        primaryStage.setScene(scene);


        hyperlinkInicial.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scene.setRoot(root);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void sceneInitial(){

    }
}
