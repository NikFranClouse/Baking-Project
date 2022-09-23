package com.example.demo;

import foodcalculations.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene home, biscuit, bread, cake, choux, cookie, crepe, fritter, muffin, pancake, pasta, pie, popover, sponge;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //Home screen
        Label homeLabel = new Label("Welcome to Baking Ratios! Select what you want to bake.");
        GridPane.setConstraints(homeLabel, 0, 0, 10, 1);

        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        Button biscuitButton = new Button("Biscuit");
        biscuitButton.setMaxSize(100, 100);
        biscuitButton.setOnAction(e -> window.setScene(biscuit));
        GridPane.setConstraints(biscuitButton, 0, 3);

        Button breadButton = new Button("Bread");
        breadButton.setMaxSize(100, 100);
        breadButton.setOnAction(e -> window.setScene(bread));
        GridPane.setConstraints(breadButton, 0, 4);

        Button cakeButton = new Button("Cake");
        cakeButton.setMaxSize(100, 100);
        cakeButton.setOnAction(e -> window.setScene(cake));
        GridPane.setConstraints(cakeButton, 0, 5);

        Button chouxButton = new Button("Choux");
        chouxButton.setMaxSize(100, 100);
        chouxButton.setOnAction(e -> window.setScene(choux));
        GridPane.setConstraints(chouxButton, 0, 6);

        Button cookieButton = new Button("Cookie");
        cookieButton.setMaxSize(100, 100);
        cookieButton.setOnAction(e -> window.setScene(cookie));
        GridPane.setConstraints(cookieButton, 0, 7);

        Button crepeButton = new Button("Crepe");
        crepeButton.setMaxSize(100, 100);
        crepeButton.setOnAction(e -> window.setScene(crepe));
        GridPane.setConstraints(crepeButton,1,3);

        Button fritterButton = new Button("Fritter");
        fritterButton.setMaxSize(100, 100);
        fritterButton.setOnAction(e -> window.setScene(fritter));
        GridPane.setConstraints(fritterButton, 1, 4);

        Button muffinButton = new Button("Muffin");
        muffinButton.setMaxSize(100, 100);
        muffinButton.setOnAction(e -> window.setScene(muffin));
        GridPane.setConstraints(muffinButton, 1, 5);

        Button pancakeButton = new Button("Pancake");
        pancakeButton.setMaxSize(100, 100);
        pancakeButton.setOnAction(e -> window.setScene(pancake));
        GridPane.setConstraints(pancakeButton, 1, 6);

        Button pastaButton = new Button("Pasta");
        pastaButton.setMaxSize(100, 100);
        pastaButton.setOnAction(e -> window.setScene(pasta));
        GridPane.setConstraints(pastaButton, 1, 7);

        Button pieButton = new Button("Pie Dough");
        pieButton.setMaxSize(100, 100);
        pieButton.setOnAction(e -> window.setScene(pie));
        GridPane.setConstraints(pieButton, 2, 3);

        Button popoverButton = new Button("Popover");
        popoverButton.setMaxSize(100, 100);
        popoverButton.setOnAction(e -> window.setScene(popover));
        GridPane.setConstraints(popoverButton, 2, 4);

        Button spongeButton = new Button("Sponge Cake");
        spongeButton.setMaxSize(100, 100);
        spongeButton.setOnAction(e -> window.setScene(sponge));
        GridPane.setConstraints(spongeButton, 2, 5);

        grid.getChildren().addAll(homeLabel, biscuitButton, breadButton, cakeButton, chouxButton,
                cookieButton, crepeButton,fritterButton,muffinButton,pancakeButton,pastaButton,
                pieButton,popoverButton,spongeButton);
        Scene home = new Scene(grid, 400,400);

        //Biscuit screen
        //Home Button Setup
        Button homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid Setup
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour entry label and text fields
        Label flourAmtBiscuit = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtBiscuit, 0, 1, 5, 1);

        TextField flourInputBiscuit = new TextField();
        GridPane.setConstraints(flourInputBiscuit,0,2);

        //Fat result textfield display
        Label fatAmtBiscuit = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtBiscuit, 0, 4, 5, 1);

        TextField fatInputBiscuit = new TextField();
        fatInputBiscuit.setDisable(true);
        GridPane.setConstraints(fatInputBiscuit,0,5);

        //Liquid result textfield display
        Label liquidAmtBiscuit = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtBiscuit, 0, 6, 5, 1);

        TextField liquidInputBiscuit = new TextField();
        liquidInputBiscuit.setDisable(true);
        GridPane.setConstraints(liquidInputBiscuit,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button biscuitCalc = new Button("Calculate");
        biscuitCalc.setOnAction(e ->
        {
            try {
                String flourValStrBiscuit = flourInputBiscuit.getText();
                double flourValBiscuit = Double.parseDouble(flourValStrBiscuit);
                CalculationResult biscuitCalcResult = Biscuit.calculateBiscuit(flourValBiscuit);
                liquidInputBiscuit.setText(String.valueOf(biscuitCalcResult.liquid));
                fatInputBiscuit.setText(String.valueOf(biscuitCalcResult.fat));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(biscuitCalc,0,3);

        //Button to clear all fields
        Button biscuitClear = new Button ("Clear");
        biscuitClear.setOnAction(b -> {
            flourInputBiscuit.clear();
            liquidInputBiscuit.clear();
            fatInputBiscuit.clear();
        });
        GridPane.setConstraints(biscuitClear,1,3);

        //Grid setup, lists what will display on the grid
        grid.getChildren().addAll(homeButton, flourAmtBiscuit, flourInputBiscuit, biscuitCalc,
                fatAmtBiscuit, fatInputBiscuit, liquidAmtBiscuit, liquidInputBiscuit, biscuitClear);
        biscuit = new Scene (grid, 400,400);

        //Bread screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid setup
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour label and textinput field
        Label flourAmtBread = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtBread, 0, 1, 5, 1);

        TextField flourInputBread = new TextField();
        GridPane.setConstraints(flourInputBread,0,2);

        //Liquid textfield to display result of needed liquid
        Label liquidAmtBread = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtBread, 0, 4, 5, 1);

        TextField liquidInputBread = new TextField();
        liquidInputBread.setDisable(true);
        GridPane.setConstraints(liquidInputBread,0,5);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button breadCalc = new Button("Calculate");
        breadCalc.setOnAction(e ->
        {
            try {
                String flourValStrBread = flourInputBread.getText();
                double flourValBread = Double.parseDouble(flourValStrBread);
                CalculationResult breadCalcResult = Bread.calculateBread(flourValBread);
                liquidInputBread.setText(String.valueOf(breadCalcResult.liquid));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(breadCalc,0,3);

        //Button to clear all fields
        Button breadClear = new Button ("Clear");
        breadClear.setOnAction(b -> {
            flourInputBread.clear();
            liquidInputBread.clear();
        });
        GridPane.setConstraints(breadClear,1,3);

        //Grid setup, lists what will display on the grid
        grid.getChildren().addAll(homeButton, flourAmtBread, flourInputBread, breadCalc, liquidAmtBread,
                liquidInputBread, breadClear);
        bread = new Scene (grid, 400,400);

        //Cake screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtCake = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtCake, 0, 1, 5, 1);

        TextField flourInputCake = new TextField();
        GridPane.setConstraints(flourInputCake,0,2);

        //Fat textfield will return fat amount needed
        Label fatAmtCake = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtCake, 0, 4, 5, 1);

        TextField fatInputCake = new TextField();
        fatInputCake.setDisable(true);
        GridPane.setConstraints(fatInputCake,0,5);

        //Egg textfiel will return amount of egg needed
        Label eggAmtCake = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtCake, 0, 6, 5, 1);

        TextField eggInputCake = new TextField();
        eggInputCake.setDisable(true);
        GridPane.setConstraints(eggInputCake,0,7);

        //Sugar textfield will return amount of sugar needed
        Label sugarAmtCake = new Label ("Amount of sugar in grams:");
        GridPane.setConstraints(sugarAmtCake, 0, 8, 5, 1);

        TextField sugarInputCake = new TextField();
        sugarInputCake.setDisable(true);
        GridPane.setConstraints(sugarInputCake,0,9);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button cakeCalc = new Button("Calculate");
        cakeCalc.setOnAction(e ->
        {
            try {
                String flourValStrCake = flourInputCake.getText();
                double flourValCake = Double.parseDouble(flourValStrCake);
                CalculationResult cakeCalcResult = Cake.calculateCake(flourValCake);
                fatInputCake.setText(String.valueOf(cakeCalcResult.fat));
                eggInputCake.setText(String.valueOf(cakeCalcResult.egg));
                sugarInputCake.setText(String.valueOf(cakeCalcResult.sugar));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(cakeCalc,0,3);

        //Button to clear all fields
        Button cakeClear = new Button ("Clear");
        cakeClear.setOnAction(b -> {
            flourInputCake.clear();
            fatInputCake.clear();
            eggInputCake.clear();
            sugarInputCake.clear();
        });
        GridPane.setConstraints(cakeClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtCake, flourInputCake, cakeCalc, fatAmtCake, fatInputCake,
                eggAmtCake, eggInputCake, sugarInputCake, sugarAmtCake, cakeClear);
        cake = new Scene (grid, 400,400);

        //Choux screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtChoux = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtChoux, 0, 1, 5, 1);

        TextField flourInputChoux = new TextField();
        GridPane.setConstraints(flourInputChoux,0,2);

        //Fat textfield will return fat amount needed
        Label fatAmtChoux = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtChoux, 0, 4, 5, 1);

        TextField fatInputChoux = new TextField();
        fatInputChoux.setDisable(true);
        GridPane.setConstraints(fatInputChoux,0,5);

        //Liquid textfield will return amount of liquid needed
        Label liquidAmtChoux = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtChoux, 0, 6, 5, 1);

        TextField liquidInputChoux = new TextField();
        liquidInputChoux.setDisable(true);
        GridPane.setConstraints(liquidInputChoux,0,7);

        //egg textfield will return amount of egg needed
        Label eggAmtChoux = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtChoux, 0, 8, 5, 1);

        TextField eggInputChoux = new TextField();
        eggInputChoux.setDisable(true);
        GridPane.setConstraints(eggInputChoux,0,9);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button chouxCalc = new Button("Calculate");
        chouxCalc.setOnAction(e ->
        {
            try {
                String flourValStrChoux = flourInputChoux.getText();
                double flourValChoux = Double.parseDouble(flourValStrChoux);
                CalculationResult chouxCalcResult = Choux.calculateChoux(flourValChoux);
                fatInputChoux.setText(String.valueOf(chouxCalcResult.fat));
                liquidInputChoux.setText(String.valueOf(chouxCalcResult.liquid));
                eggInputChoux.setText(String.valueOf(chouxCalcResult.egg));
            }
            catch (NumberFormatException a){
                 Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(chouxCalc,0,3);

        //Button to clear all fields
        Button chouxClear = new Button ("Clear");
        chouxClear.setOnAction(b -> {
            flourInputChoux.clear();
            liquidInputChoux.clear();
            eggInputChoux.clear();
        });
        GridPane.setConstraints(chouxClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtChoux, flourInputChoux, chouxCalc, fatAmtChoux,
                fatInputChoux, eggAmtChoux,eggInputChoux, liquidInputChoux, liquidAmtChoux, chouxClear);
        choux = new Scene (grid, 400,400);

        //Cookie screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtCookie = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtCookie, 0, 1, 5, 1);

        TextField flourInputCookie = new TextField();
        GridPane.setConstraints(flourInputCookie,0,2);

        //Fat textfield will return fat amount needed
        Label fatAmtCookie = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtCookie, 0, 4, 5, 1);

        TextField fatInputCookie = new TextField();
        fatInputCookie.setDisable(true);
        GridPane.setConstraints(fatInputCookie,0,5);

        //Sugar textfield will return amount of sugar needed
        Label sugarAmtCookie = new Label ("Amount of sugar in grams:");
        GridPane.setConstraints(sugarAmtCookie, 0, 6, 5, 1);

        TextField sugarInputCookie = new TextField();
        sugarInputCookie.setDisable(true);
        GridPane.setConstraints(sugarInputCookie,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button cookieCalc = new Button("Calculate");
        cookieCalc.setOnAction(e ->
        {
            try {
                String flourValStrCookie = flourInputCookie.getText();
                double flourValCookie = Double.parseDouble(flourValStrCookie);
                CalculationResult cookieCalcResult = Cookie.calculateCookie(flourValCookie);
                fatInputCookie.setText(String.valueOf(cookieCalcResult.fat));
                sugarInputCookie.setText(String.valueOf(cookieCalcResult.sugar));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(cookieCalc,0,3);

        //Button to clear all fields
        Button cookieClear = new Button ("Clear");
        cookieClear.setOnAction(b -> {
            flourInputCookie.clear();
            fatInputCookie.clear();
            sugarInputCookie.clear();
        });
        GridPane.setConstraints(cookieClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtCookie, flourInputCookie, cookieCalc, fatAmtCookie,
                fatInputCookie, sugarInputCookie, sugarAmtCookie, cookieClear);
        cookie = new Scene (grid, 400,400);

        //Crepe screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtCrepe = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtCrepe, 0, 1, 5, 1);

        TextField flourInputCrepe = new TextField();
        GridPane.setConstraints(flourInputCrepe,0,2);

        //Liquid textfield will return liquid amount needed
        Label liquidAmtCrepe = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtCrepe, 0, 4, 5, 1);

        TextField liquidInputCrepe = new TextField();
        liquidInputCrepe.setDisable(true);
        GridPane.setConstraints(liquidInputCrepe,0,5);

        //Egg textfield will return amount of egg needed
        Label eggAmtCrepe = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtCrepe, 0, 6, 5, 1);

        TextField eggInputCrepe = new TextField();
        eggInputCrepe.setDisable(true);
        GridPane.setConstraints(eggInputCrepe,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button crepeCalc = new Button("Calculate");
        crepeCalc.setOnAction(e ->
        {
            try {
                String flourValStrCrepe = flourInputCrepe.getText();
                double flourValCrepe = Double.parseDouble(flourValStrCrepe);
                CalculationResult crepeCalcResult = Crepe.calculateCrepe(flourValCrepe);
                liquidInputCrepe.setText(String.valueOf(crepeCalcResult.liquid));
                eggInputCrepe.setText(String.valueOf(crepeCalcResult.egg));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(crepeCalc,0,3);

        //Button to clear all fields
        Button crepeClear = new Button ("Clear");
        crepeClear.setOnAction(b -> {
            flourInputCrepe.clear();
            liquidInputCrepe.clear();
            eggInputCrepe.clear();

        });
        GridPane.setConstraints(crepeClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtCrepe, flourInputCrepe, crepeCalc, liquidAmtCrepe,
                liquidInputCrepe, eggInputCrepe, eggAmtCrepe, crepeClear);
        crepe = new Scene (grid, 400,400);

        //Fritter screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtFritter = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtFritter, 0, 1, 5, 1);

        TextField flourInputFritter = new TextField();
        GridPane.setConstraints(flourInputFritter,0,2);

        //Liquid textfield will return liquid amount needed
        Label liquidAmtFritter = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtFritter, 0, 4, 5, 1);

        TextField liquidInputFritter = new TextField();
        liquidInputFritter.setDisable(true);
        GridPane.setConstraints(liquidInputFritter,0,5);

        //Egg textfield will return amount of egg needed
        Label eggAmtFritter = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtFritter, 0, 6, 5, 1);

        TextField eggInputFritter = new TextField();
        eggInputFritter.setDisable(true);
        GridPane.setConstraints(eggInputFritter,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button fritterCalc = new Button("Calculate");
        fritterCalc.setOnAction(e ->
        {
            try {
                String flourValStrFritter = flourInputFritter.getText();
                double flourValFritter = Double.parseDouble(flourValStrFritter);
                CalculationResult fritterCalcResult = Fritter.calculateFritter(flourValFritter);
                liquidInputFritter.setText(String.valueOf(fritterCalcResult.liquid));
                eggInputFritter.setText(String.valueOf(fritterCalcResult.egg));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(fritterCalc,0,3);

        //Button to clear all fields
        Button fritterClear = new Button ("Clear");
        fritterClear.setOnAction(b -> {
            flourInputFritter.clear();
            liquidInputFritter.clear();
            eggInputFritter.clear();

        });
        GridPane.setConstraints(fritterClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtFritter, flourInputFritter, fritterCalc, liquidAmtFritter,
                liquidInputFritter, eggInputFritter, eggAmtFritter, fritterClear);
        fritter = new Scene (grid, 400,400);

        //Muffin screen
        //Home Button Setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid Setup
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour entry label and text fields
        Label flourAmtMuffin = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtMuffin, 0, 1, 5, 1);

        TextField flourInputMuffin = new TextField();
        GridPane.setConstraints(flourInputMuffin,0,2);

        //Fat result textfield display
        Label fatAmtMuffin = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtMuffin, 0, 4, 5, 1);

        TextField fatInputMuffin = new TextField();
        fatInputMuffin.setDisable(true);
        GridPane.setConstraints(fatInputMuffin,0,5);

        //Liquid result textfield display
        Label liquidAmtMuffin = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtMuffin, 0, 6, 5, 1);

        TextField liquidInputMuffin = new TextField();
        liquidInputMuffin.setDisable(true);
        GridPane.setConstraints(liquidInputMuffin,0,7);

        //Egg textfield will return amount of egg needed
        Label eggAmtMuffin = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtMuffin, 0, 8, 5, 1);

        TextField eggInputMuffin = new TextField();
        eggInputMuffin.setDisable(true);
        GridPane.setConstraints(eggInputMuffin,0,9);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button muffinCalc = new Button("Calculate");
        muffinCalc.setOnAction(e ->
        {
            try {
                String flourValStrMuffin = flourInputMuffin.getText();
                double flourValMuffin = Double.parseDouble(flourValStrMuffin);
                CalculationResult muffinCalcResult = Muffin.calculateMuffin(flourValMuffin);
                liquidInputMuffin.setText(String.valueOf(muffinCalcResult.liquid));
                fatInputMuffin.setText(String.valueOf(muffinCalcResult.fat));
                eggInputMuffin.setText(String.valueOf(muffinCalcResult.egg));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(muffinCalc,0,3);

        //Button to clear all fields
        Button muffinClear = new Button ("Clear");
        muffinClear.setOnAction(b -> {
            flourInputMuffin.clear();
            fatInputMuffin.clear();
            eggInputMuffin.clear();

        });
        GridPane.setConstraints(muffinClear,1,3);

        //Grid setup, lists what will display on the grid
        grid.getChildren().addAll(homeButton, flourAmtMuffin, flourInputMuffin, muffinCalc, fatAmtMuffin,
                fatInputMuffin, liquidAmtMuffin, liquidInputMuffin, eggInputMuffin, eggAmtMuffin, muffinClear);
        muffin = new Scene (grid, 400,400);

        //Pancake screen
        //Home Button Setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid Setup
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour entry label and text fields
        Label flourAmtPancake = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtPancake, 0, 1, 5, 1);

        TextField flourInputPancake = new TextField();
        GridPane.setConstraints(flourInputPancake,0,2);

        //Fat result textfield display
        Label fatAmtPancake = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtPancake, 0, 4, 5, 1);

        TextField fatInputPancake = new TextField();
        fatInputPancake.setDisable(true);
        GridPane.setConstraints(fatInputPancake,0,5);

        //Liquid result textfield display
        Label liquidAmtPancake = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtPancake, 0, 6, 5, 1);

        TextField liquidInputPancake = new TextField();
        liquidInputPancake.setDisable(true);
        GridPane.setConstraints(liquidInputPancake,0,7);

        //Egg textfield will return amount of egg needed
        Label eggAmtPancake = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtPancake, 0, 8, 5, 1);

        TextField eggInputPancake = new TextField();
        eggInputPancake.setDisable(true);
        GridPane.setConstraints(eggInputPancake,0,9);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button pancakeCalc = new Button("Calculate");
        pancakeCalc.setOnAction(e ->
        {
            try {
                String flourValStrPancake = flourInputPancake.getText();
                double flourValPancake = Double.parseDouble(flourValStrPancake);
                CalculationResult pancakeCalcResult = Pancake.calculatePancake(flourValPancake);
                liquidInputPancake.setText(String.valueOf(pancakeCalcResult.liquid));
                fatInputPancake.setText(String.valueOf(pancakeCalcResult.fat));
                eggInputPancake.setText(String.valueOf(pancakeCalcResult.egg));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(pancakeCalc,0,3);

        //Button to clear all fields
        Button pancakeClear = new Button ("Clear");
        pancakeClear.setOnAction(b -> {
            flourInputPancake.clear();
            fatInputPancake.clear();
            eggInputPancake.clear();

        });
        GridPane.setConstraints(pancakeClear,1,3);

        //Grid setup, lists what will display on the grid
        grid.getChildren().addAll(homeButton, flourAmtPancake, flourInputPancake, pancakeCalc, fatAmtPancake,
                fatInputPancake, liquidAmtPancake, liquidInputPancake, eggInputPancake, eggAmtPancake, pancakeClear);
        pancake = new Scene (grid, 400,400);

        //Pasta screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtPasta = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtPasta, 0, 1, 5, 1);

        TextField flourInputPasta = new TextField();
        GridPane.setConstraints(flourInputPasta,0,2);

        //Egg textfield will return amount of egg needed
        Label eggAmtPasta = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtPasta, 0, 4, 5, 1);

        TextField eggInputPasta = new TextField();
        eggInputPasta.setDisable(true);
        GridPane.setConstraints(eggInputPasta,0,5);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button pastaCalc = new Button("Calculate");
        pastaCalc.setOnAction(e ->
        {
            try {
                String flourValStrPasta = flourInputPasta.getText();
                double flourValPasta = Double.parseDouble(flourValStrPasta);
                CalculationResult pastaCalcResult = Pasta.calculatePasta(flourValPasta);
                eggInputPasta.setText(String.valueOf(pastaCalcResult.egg));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(pastaCalc,0,3);

        //Button to clear all fields
        Button pastaClear = new Button ("Clear");
        pastaClear.setOnAction(b -> {
            flourInputPasta.clear();
            eggInputPasta.clear();

        });
        GridPane.setConstraints(pastaClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtPasta, flourInputPasta, pastaCalc, eggInputPasta,
                eggAmtPasta, pastaClear);
        pasta = new Scene (grid, 400,400);

        //Pie Dough screen
        //Home Button Setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid Setup
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour entry label and text fields
        Label flourAmtPie = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtPie, 0, 1, 5, 1);

        TextField flourInputPie = new TextField();
        GridPane.setConstraints(flourInputPie,0,2);

        //Fat result textfield display
        Label fatAmtPie = new Label ("Amount of fat in grams:");
        GridPane.setConstraints(fatAmtPie, 0, 4, 5, 1);

        TextField fatInputPie = new TextField();
        fatInputPie.setDisable(true);
        GridPane.setConstraints(fatInputPie,0,5);

        //Liquid result textfield display
        Label liquidAmtPie = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtPie, 0, 6, 5, 1);

        TextField liquidInputPie = new TextField();
        liquidInputPie.setDisable(true);
        GridPane.setConstraints(liquidInputPie,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button pieCalc = new Button("Calculate");
        pieCalc.setOnAction(e ->
        {
            try {
                String flourValStrPie = flourInputPie.getText();
                double flourValPie = Double.parseDouble(flourValStrPie);
                CalculationResult pieCalcResult = Pie.calculatePie(flourValPie);
                liquidInputPie.setText(String.valueOf(pieCalcResult.liquid));
                fatInputPie.setText(String.valueOf(pieCalcResult.fat));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(pieCalc,0,3);

        //Button to clear all fields
        Button pieClear = new Button ("Clear");
        pieClear.setOnAction(b -> {
            flourInputPie.clear();
            liquidInputPie.clear();
            fatInputPie.clear();

        });
        GridPane.setConstraints(pieClear,1,3);

        //Grid setup, lists what will display on the grid
        grid.getChildren().addAll(homeButton, flourAmtPie, flourInputPie, pieCalc,
                fatAmtPie, fatInputPie, liquidAmtPie, liquidInputPie, pieClear);
        pie = new Scene (grid, 400,400);

        //Popover screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtPopover = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtPopover, 0, 1, 5, 1);

        TextField flourInputPopover = new TextField();
        GridPane.setConstraints(flourInputPopover,0,2);

        //Liquid textfield will return liquid amount needed
        Label liquidAmtPopover = new Label ("Amount of liquid in grams:");
        GridPane.setConstraints(liquidAmtPopover, 0, 4, 5, 1);

        TextField liquidInputPopover = new TextField();
        liquidInputPopover.setDisable(true);
        GridPane.setConstraints(liquidInputPopover,0,5);

        //Egg textfield will return amount of egg needed
        Label eggAmtPopover = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtPopover, 0, 6, 5, 1);

        TextField eggInputPopover = new TextField();
        eggInputPopover.setDisable(true);
        GridPane.setConstraints(eggInputPopover,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button popoverCalc = new Button("Calculate");
        popoverCalc.setOnAction(e ->
        {
            try {
                String flourValStrPopover = flourInputPopover.getText();
                double flourValPopover = Double.parseDouble(flourValStrPopover);
                CalculationResult popoverCalcResult = Popover.calculatePopover(flourValPopover);
                liquidInputPopover.setText(String.valueOf(popoverCalcResult.liquid));
                eggInputPopover.setText(String.valueOf(popoverCalcResult.egg));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });
        GridPane.setConstraints(popoverCalc,0,3);

        //Button to clear all fields
        Button popoverClear = new Button ("Clear");
        popoverClear.setOnAction(b -> {
            flourInputPopover.clear();
            liquidInputPopover.clear();
            eggInputPopover.clear();

        });
        GridPane.setConstraints(popoverClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtPopover, flourInputPopover, popoverCalc, liquidAmtPopover,
                liquidInputPopover, eggInputPopover, eggAmtPopover, popoverClear);
        popover = new Scene (grid, 400,400);

        //Sponge Cake screen
        //Home button setup
        homeButton = new Button("Home");
        homeButton.setOnAction(e -> window.setScene(home));
        GridPane.setConstraints(homeButton, 0, 0);

        //Grid set up
        grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(75));
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(25);

        //Flour input label and text field
        Label flourAmtSponge = new Label ("Enter amount of flour in grams:");
        GridPane.setConstraints(flourAmtSponge, 0, 1, 5, 1);

        TextField flourInputSponge = new TextField();
        GridPane.setConstraints(flourInputSponge,0,2);

        //Egg textfiel will return amount of egg needed
        Label eggAmtSponge = new Label ("Amount of egg in grams:");
        GridPane.setConstraints(eggAmtSponge, 0, 4, 5, 1);

        TextField eggInputSponge = new TextField();
        eggInputSponge.setDisable(true);
        GridPane.setConstraints(eggInputSponge,0,5);

        //Sugar textfield will return amount of sugar needed
        Label sugarAmtSponge = new Label ("Amount of sugar in grams:");
        GridPane.setConstraints(sugarAmtSponge, 0, 6, 5, 1);

        TextField sugarInputSponge = new TextField();
        sugarInputSponge.setDisable(true);
        GridPane.setConstraints(sugarInputSponge,0,7);

        //Calculation button setup and activation. Button takes flour input as string and
        //parses to a Double value.
        Button spongeCalc = new Button("Calculate");
        spongeCalc.setOnAction(e ->
        {
            try {
                String flourValStrSponge = flourInputSponge.getText();
                double flourValSponge = Double.parseDouble(flourValStrSponge);
                CalculationResult spongeCalcResult = Sponge.calculateSponge(flourValSponge);
                eggInputSponge.setText(String.valueOf(spongeCalcResult.egg));
                sugarInputSponge.setText(String.valueOf(spongeCalcResult.sugar));
            }
            catch (NumberFormatException a){
                Error.display("Error!", "It said input amount of flour in grams!");
            }
        });

        GridPane.setConstraints(spongeCalc,0,3);

        //Button to clear all fields
        Button spongeClear = new Button ("Clear");
        spongeClear.setOnAction(b -> {
            flourInputSponge.clear();
            eggInputSponge.clear();
            sugarInputSponge.clear();

        });
        GridPane.setConstraints(spongeClear,1,3);

        grid.getChildren().addAll(homeButton, flourAmtSponge, flourInputSponge, spongeCalc,
                eggAmtSponge, eggInputSponge, sugarInputSponge, sugarAmtSponge, spongeClear);
        sponge = new Scene (grid, 400,400);

        window.setScene(home);
        window.setTitle("Baking Ratios");
        window.show();



    }
}