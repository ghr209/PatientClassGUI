package sample;

import DataValidator.DataValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    TextField textCprNumber = new TextField();  // Et tekstfelt med en linje (som i vores tilfælde vil ligge i indtast CPR felt)
    TextArea resultField = new TextArea();
    DataValidator dataValidator = new DataValidator(); // Vi genbruger DataValidator class fra øvelserne.

    @Override
    public void start(Stage primaryStage) {     // a Stage is the main window for a JavaFX application
        primaryStage.setTitle("Enter CPR number and hit the button for accessing patient information, regarding tests, sensor data");   // set the title shown int th title bar
        GridPane grid = new GridPane();         // Laver et  GridPane for pænt/fleksibelt layout
        grid.setAlignment(Pos.CENTER);          // Sørge for at  grid  forholder sig til center(midten) af applikationsvinduet.
        Label CPR = new Label("CPR: ");      // Laver et label som viser "CPR"
        grid.add(CPR, 0, 0);
        grid.setHgap(10);                       // Visualisering  (10 pixels)--> Horisontal
        grid.setVgap(10);                       // Visualisering  (10 pixels)--> Vertical


        textCprNumber.setPromptText("Enter your patient's CPR Number");   // display brugelig tekst til brugeren
        textCprNumber.setFocusTraversable(false);
        textCprNumber.setMaxWidth(150);         // Max bredde på CPR field.
        textCprNumber.setTooltip(new Tooltip("CPR Number must be in the format ######-####")); // Når man bevæger musen henover feltet, vises denne besked.
        resultField.setPromptText("Enter a patient's CPR number in the above field and click on 'Access patient information'. This field will then show if the format of the CPR number can be validated");
        resultField.setPrefHeight(100);         // højde af  resultat   feltet
        resultField.setPrefWidth(300);          //  bredde af  resultat   feltet
        resultField.setEditable(false);         // Sørge for at man ikke kan ændre i resultat feltet
        resultField.setWrapText(true);          //
        Button buttonAccess = new Button("Access patient information");  // Vi laver en ny knap, man kan trykke på
        Button buttonClearAll = new Button("Clear All");    // Vi laver en ny knap, man kan trykke på

        // now create an event --> kaldes når knappen er blevet trykket på
        buttonAccess.setOnMouseClicked(event -> {
            if (dataValidator.isValidCPR(textCprNumber.getText())) {
                // Når input er korrekt/valid vises nedenstående i  "result field"
                String text = textCprNumber.getText();
                resultField.setText("CPR number: " + text + "," + " " + "CPR is in correct format, therefore u can access patient information");
            } else {
                // Hvis CPR er forkert format vil nedenstående advarsel vises
                resultField.setText("Patient-CPR number is not in correct format, therefore patient information can not be accessed");
            }
        });

        buttonClearAll.setOnMouseClicked(event -> {
            clearFields();  // Funktionen som clear felterne kaldes.
        });

        // Placering af knapperne;
        grid.add(textCprNumber, 1, 0);
        grid.add(buttonAccess, 2, 0);
        grid.add(resultField, 1, 1);
        grid.add(buttonClearAll, 2, 4);

        Scene scene = new Scene(grid, 600, 400); // Format
        primaryStage.setScene(scene);                   // tilføjer en  scene til stage(applikationsvindue)
        primaryStage.show();                 // Vi viser stage ved show (som python)
    }

    public void clearFields() { // metode som gør at de to felter bliver bliver tomme/clear, en form for slet-knap
        textCprNumber.clear();
        resultField.clear();
    }

    public static void main(String[] args) { launch(args); }
}