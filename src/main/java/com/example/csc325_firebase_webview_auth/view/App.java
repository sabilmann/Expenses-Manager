package com.example.csc325_firebase_webview_auth.view;


import com.example.csc325_firebase_webview_auth.model.FirestoreContext;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import java.util.Objects;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Firestore fstore;
    public static FirebaseAuth fauth;
    public static Scene scene;
    private final FirestoreContext contxtFirebase = new FirestoreContext();

    @Override
    public void start(Stage primaryStage) throws Exception {
        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();

        scene = new Scene(loadFXML("/files/login.fxml"), 700, 500); //loads the login page
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/files/main.css")).toExternalForm()); //uses the css
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
