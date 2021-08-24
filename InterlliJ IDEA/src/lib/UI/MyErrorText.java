package lib.UI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class MyErrorText extends MyText {
    public MyErrorText() {
        initStyle();
    }

    public MyErrorText(String text) {
        setText(text);
        initStyle();
    }

    public void initStyle() {
        imageView = new ImageView(ImagesPath.App_Cross1);
        setStyle(
                "-fx-pref-width: 300;" +
                        "-fx-pref-height: 15;" +
                        "-fx-background-color: #FFE3E6;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: #ECBCBF;"
        );
        setPadding(new Insets(10,10,10,20));
        text.setFont(Font.font("SongTi", FontWeight.THIN, 15.0));
        imageView.setFitHeight(17);
        imageView.setPreserveRatio(true);
        button.setStyle("-fx-background-color: transparent");
        button.setGraphic(imageView);
        setLeft(text);
        setRight(button);
        setAlignment(button,Pos.CENTER_RIGHT);
        setAlignment(text, Pos.CENTER_LEFT);
        button.setCursor(Cursor.HAND);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setmanaged(false);
            }
        });
    }
}
