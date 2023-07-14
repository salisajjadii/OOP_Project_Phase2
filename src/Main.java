import Functions.Functions;
import Map.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Classes.*;
import java.io.*;
import Functions.StaticArrayLists ;


public class Main extends Application {
    StaticArrayLists staticArrayLists = new StaticArrayLists();
    Map map = new Map("F:\\CP Projects\\OOP\\Phase2\\src\\graph.txt");

    public static void main(String[] args) {
        launch(args);
    }

    public void loadWellcomeScreen(Stage primaryStage) {
        Pane pane = new Pane();

        Label label = new Label("Wellcome to our program ....");
        label.setFont(Font.font("Calibri Bold", 25));
        label.setLayoutX(130);
        label.setLayoutY(40);
        label.setPrefSize(340, 40);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#3a648c"));
        pane.getChildren().add(label);

        Button loginButton = new Button("LOG IN");
        loginButton.setFont(Font.font("Calibri", 18));
        loginButton.setLayoutX(150);
        loginButton.setLayoutY(140);
        loginButton.setPrefSize(90, 35);
        loginButton.setId("adminID");
        pane.getChildren().add(loginButton);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCaptchaBFLoginScreen(primaryStage);
            }
        });

        Button signUpButton = new Button("SIGN UP");
        signUpButton.setFont(Font.font("Calibri", 18));
        signUpButton.setLayoutX(255);
        signUpButton.setLayoutY(140);
        signUpButton.setPrefSize(90, 35);
        signUpButton.setId("userID");
        pane.getChildren().add(signUpButton);
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCaptchaBFSignUpScreen(primaryStage);
            }
        });

        Button exitButton = new Button("EXIT");
        exitButton.setFont(Font.font("Calibri", 18));
        exitButton.setLayoutX(360);
        exitButton.setLayoutY(140);
        exitButton.setId("deliveryID");
        exitButton.setPrefSize(90, 35);
        pane.getChildren().add(exitButton);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
                serializeObjects(staticArrayLists);
            }
        });

        Label productLabel = new Label("Producted by Mahdi, MoMehdi, Seyedali");
        productLabel.setFont(Font.font(8));
        productLabel.setLayoutY(386);
        productLabel.setPrefSize(298, 17);
        productLabel.setTextFill(javafx.scene.paint.Color.valueOf("#404040"));
        pane.getChildren().add(productLabel);

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane.setBackground(new Background(myBackground));

        Scene scene = new Scene(pane, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static int randomNumber(){
        return  (int) (Math.random() * 10) ;
    }

    public static String StringPath(String string){
        switch (string){
            case "0" :
                return "0.jpg" ;
            case "1" :
                return "1.jpg" ;
            case "2" :
                return "2.jpg" ;
            case "3" :
                return "3.jpg" ;
            case "4" :
                return "4.jpg" ;
            case "5" :
                return "5.jpg" ;
            case "6" :
                return "6.jpg" ;
            case "7" :
                return "7.jpg" ;
            case "8" :
                return "8.jpg" ;
            case "9" :
                return "9.jpg" ;
            default:
                return "" ;
        }
    }

    public void loadCaptchaBFLoginScreen(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        String firstNumbr = Integer.toString(randomNumber());
        Image firstImage = new Image(StringPath(firstNumbr));
        ImageView firstImageView = new ImageView(firstImage);
        firstImageView.setFitWidth(100);
        firstImageView.setFitHeight(100);

        String secondNumbr = Integer.toString(randomNumber());
        Image secondImage = new Image(StringPath(secondNumbr));
        ImageView secondImageView = new ImageView(secondImage);
        secondImageView.setFitWidth(100);
        secondImageView.setFitHeight(100);

        String thirdNumbr = Integer.toString(randomNumber());
        Image thirdImage = new Image(StringPath(thirdNumbr));
        ImageView thirdImageView = new ImageView(thirdImage);
        thirdImageView.setFitWidth(100);
        thirdImageView.setFitHeight(100);

        String fourthNumbr = Integer.toString(randomNumber());
        Image fourthImage = new Image(StringPath(fourthNumbr));
        ImageView fourthImageView = new ImageView(fourthImage);
        fourthImageView.setFitWidth(100);
        fourthImageView.setFitHeight(100);

        String value = firstNumbr + secondNumbr + thirdNumbr + fourthNumbr;

        TextField textField = new TextField();
        textField.setId("textfield");
        textField.setPrefWidth(150);

        Button buttonNext = new Button("Next");
        buttonNext.setPrefSize(80,20);
        buttonNext.setId("userID");

        Button buttonBack = new Button("Back");
        buttonBack.setPrefSize(80,20);
        buttonBack.setId("deliveryID");

        HBox hBoxOne = new HBox(0, firstImageView, secondImageView, thirdImageView, fourthImageView);
        hBoxOne.setAlignment(Pos.CENTER);
        hBoxOne.setLayoutX(100);
        hBoxOne.setLayoutY(110);

        HBox hboxTwo = new HBox(20, textField, buttonNext, buttonBack);
        hboxTwo.setAlignment(Pos.CENTER);
        hboxTwo.setLayoutX(125);
        hboxTwo.setLayoutY(220);

        Label captchaLabel = new Label("Captcha Test");
        captchaLabel.setFont(new Font(20));
        captchaLabel.setLayoutX(230);
        captchaLabel.setLayoutY(50);
        captchaLabel.setId("fontWhite");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(130);
        notifLabel.setLayoutY(250);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        pane.getChildren().addAll(hBoxOne,hboxTwo, notifLabel, captchaLabel);
        Scene scene = new Scene(pane);
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textField.getText().equals(value))
                    loadLoginScreen(primaryStage);
                else {
                    notifLabel.setText("Try again please, it's not true ...");
                    textField.clear();
                }
            }
        });
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadWellcomeScreen(primaryStage);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane.setBackground(new Background(myBackground));
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCaptchaBFSignUpScreen(Stage primaryStage){
        Pane pane0 = new Pane();
        pane0.setPrefSize(600, 400);

        String firstNumbr = Integer.toString(randomNumber());
        Image firstImage = new Image(StringPath(firstNumbr));
        ImageView firstImageView = new ImageView(firstImage);
        firstImageView.setFitWidth(100);
        firstImageView.setFitHeight(100);

        String secondNumbr = Integer.toString(randomNumber());
        Image secondImage = new Image(StringPath(secondNumbr));
        ImageView secondImageView = new ImageView(secondImage);
        secondImageView.setFitWidth(100);
        secondImageView.setFitHeight(100);

        String thirdNumbr = Integer.toString(randomNumber());
        Image thirdImage = new Image(StringPath(thirdNumbr));
        ImageView thirdImageView = new ImageView(thirdImage);
        thirdImageView.setFitWidth(100);
        thirdImageView.setFitHeight(100);

        String fourthNumbr = Integer.toString(randomNumber());
        Image fourthImage = new Image(StringPath(fourthNumbr));
        ImageView fourthImageView = new ImageView(fourthImage);
        fourthImageView.setFitWidth(100);
        fourthImageView.setFitHeight(100);

        String value = firstNumbr + secondNumbr + thirdNumbr + fourthNumbr;

        TextField textField = new TextField();
        textField.setPrefWidth(150);
        textField.setId("textfield");

        Button buttonNext = new Button("Next");
        buttonNext.setPrefSize(80,20);
        buttonNext.setId("userID");

        Button buttonBack = new Button("Back");
        buttonBack.setPrefSize(80,20);
        buttonBack.setId("deliveryID");

        HBox hBoxOne = new HBox(0, firstImageView, secondImageView, thirdImageView, fourthImageView);
        hBoxOne.setAlignment(Pos.CENTER);
        hBoxOne.setLayoutX(100);
        hBoxOne.setLayoutY(110);

        HBox hboxTwo = new HBox(20, textField, buttonNext, buttonBack);
        hboxTwo.setAlignment(Pos.CENTER);
        hboxTwo.setLayoutX(125);
        hboxTwo.setLayoutY(220);

        Label captchaLabel = new Label("Captcha Test");
        captchaLabel.setFont(new Font(20));
        captchaLabel.setLayoutX(230);
        captchaLabel.setLayoutY(50);
        captchaLabel.setId("fontWhite");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(130);
        notifLabel.setLayoutY(250);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        pane0.getChildren().addAll(hBoxOne,hboxTwo, notifLabel, captchaLabel);
        Scene scene = new Scene(pane0);
        scene.getStylesheets().add("styles.css");
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textField.getText().equals(value))
                    loadSignUp1Screen(primaryStage);
                else {
                    notifLabel.setText("Try again please, it's not true ...");
                    textField.clear();
                }
            }
        });
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadWellcomeScreen(primaryStage);
            }
        });
        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane0.setBackground(new Background(myBackground));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadLoginScreen(Stage primaryStage) {
        Pane pane1 = new Pane();
        pane1.setPrefSize(600, 400);

        RadioButton asAdminRadioButton = new RadioButton("as Admin");
        asAdminRadioButton.setLayoutX(50);
        asAdminRadioButton.setLayoutY(100);
        asAdminRadioButton.setId("fontWhite") ;

        RadioButton asUserRadioButton = new RadioButton("as User");
        asUserRadioButton.setLayoutX(50);
        asUserRadioButton.setLayoutY(130);
        asUserRadioButton.setId("fontWhite") ;

        RadioButton asDeliveryRadioButton = new RadioButton("as Delivery");
        asDeliveryRadioButton.setLayoutX(50);
        asDeliveryRadioButton.setLayoutY(160);
        asDeliveryRadioButton.setId("fontWhite") ;

        ToggleGroup toggleGroup1 = new ToggleGroup();
        asAdminRadioButton.setToggleGroup(toggleGroup1);
        asUserRadioButton.setToggleGroup(toggleGroup1);
        asDeliveryRadioButton.setToggleGroup(toggleGroup1);

        Separator separator = new Separator();
        separator.setLayoutX(150.0);
        separator.setLayoutY(100.0);
        separator.setPrefWidth(10);
        separator.setPrefHeight(80);
        separator.setOrientation(Orientation.VERTICAL);

        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(279);
        usernameTextField.setLayoutY(110);
        usernameTextField.setPrefSize(180, 20);
        usernameTextField.setPromptText("Abcdefgh");
        usernameTextField.setId("textfield");

        Label usernameLabel = new Label("Username:");
        usernameLabel.setLayoutX(198);
        usernameLabel.setLayoutY(112);
        usernameLabel.setId("fontWhite");

        Label passwordLabel = new Label("Password:");
        passwordLabel.setLayoutX(198);
        passwordLabel.setLayoutY(153);
        passwordLabel.setId("fontWhite");

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setLayoutX(280);
        passwordTextField.setLayoutY(150);
        passwordTextField.setPrefSize(180, 20);
        passwordTextField.setPromptText("Abcd1234");
        passwordTextField.setId("textfield");

        Button forgetPassButton = new Button("Forget Pass");
        forgetPassButton.setLayoutX(280);
        forgetPassButton.setLayoutY(215);
        forgetPassButton.setPrefWidth(80);
        forgetPassButton.setPrefHeight(20);
        forgetPassButton.setId("adminID");
        forgetPassButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass1Screen(primaryStage);
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(280);
        backButton.setLayoutY(255);
        backButton.setPrefWidth(180);
        backButton.setPrefHeight(20);
        backButton.setId("deliveryID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadWellcomeScreen(primaryStage);
            }
        });

        Label errorLabel = new Label();
        errorLabel.setLayoutX(280);
        errorLabel.setLayoutY(290);
        errorLabel.setPrefSize(178, 30);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font("Calibri", 10));
        errorLabel.setId("fontWhite");

        Label titleLabel = new Label("LOGIN PAGE");
        titleLabel.setLayoutY(30);
        titleLabel.setLayoutX(80);
        titleLabel.setFont(new Font(20));
        titleLabel.setId("fontWhite");

        Label creditsLabel = new Label("Producted by Mahdi, MoMehdi, Seyedali");
        creditsLabel.setLayoutY(386);
        creditsLabel.setPrefSize(298, 17);
        creditsLabel.setTextFill(Color.rgb(64, 64, 64));
        creditsLabel.setFont(new Font(8));
        creditsLabel.setId("fontWhite");

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(380);
        loginButton.setLayoutY(215);
        loginButton.setPrefWidth(80);
        loginButton.setPrefHeight(20);
        loginButton.setId("userID");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();
                if (username.equals("") || password.equals("")) {
                    errorLabel.setText("please enter username and passowrd !!!");
                } else {
                    if (toggleGroup1.getSelectedToggle() == asAdminRadioButton) {
                        String[] result = Functions.LogIn(password, "ADMIN", username, staticArrayLists);
                        if (result[0].equals("false")) {
                            usernameTextField.setText("");
                            passwordTextField.setText("");
                            errorLabel.setText("this username does not exist ... ");
                        } else {
                            if (result[1].equals("false")) {
                                usernameTextField.setText("");
                                passwordTextField.setText("");
                                errorLabel.setText("password is not correct ...");
                            } else {
                                if (result[3].equals("1")) {
                                    loadRestaurantScreen(primaryStage, Restaurant.loggedInRestaurantForAdmin.restaurantID);
                                } else {
                                    loadAdminPanelScreen(primaryStage, result[2]);
                                }
                            }
                        }
                    } else if (toggleGroup1.getSelectedToggle() == asUserRadioButton) {
                        String[] result = Functions.LogIn(password, "USER", username, staticArrayLists);
                        if (result[0].equals("false")) {
                            usernameTextField.setText("");
                            passwordTextField.setText("");
                            errorLabel.setText("this username does not exist ... ");
                        } else {
                            if (result[1].equals("false")) {
                                usernameTextField.setText("");
                                passwordTextField.setText("");
                                errorLabel.setText("password is not correct ...");
                            } else {
                                loadUserPanelScreen(primaryStage, result[2]);
                            }
                        }
                    } else if (toggleGroup1.getSelectedToggle() == asDeliveryRadioButton) {
                        String[] result = Functions.LogIn(password, "DELIVERY", username, staticArrayLists);
                        if (result[0].equals("false")) {
                            usernameTextField.setText("");
                            passwordTextField.setText("");
                            errorLabel.setText("this username does not exist ... ");
                        } else {
                            if (result[1].equals("false")) {
                                usernameTextField.setText("");
                                passwordTextField.setText("");
                                errorLabel.setText("password is not correct ...");
                            } else {
                                loadDeliveryPanelScreen(primaryStage, result[2]);
                            }
                        }
                    } else
                        errorLabel.setText("Please select your account type !!!");
                }
            }
        });

        pane1.getChildren().addAll(asAdminRadioButton, asUserRadioButton, separator, usernameTextField,
                usernameLabel, passwordLabel, passwordTextField, loginButton, forgetPassButton, backButton,
                asDeliveryRadioButton, errorLabel, titleLabel, creditsLabel);

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane1.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane1);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadForgetPass1Screen(Stage primaryStage) {
        Pane pane3 = new Pane();

        RadioButton radioBtnAdmin = new RadioButton();
        radioBtnAdmin.setLayoutX(50.0);
        radioBtnAdmin.setLayoutY(100.0);
        radioBtnAdmin.setId("fontWhite");
        radioBtnAdmin.setText("as Admin");
        pane3.getChildren().add(radioBtnAdmin);

        RadioButton radioBtnUser = new RadioButton();
        radioBtnUser.setLayoutX(50.0);
        radioBtnUser.setLayoutY(130.0);
        radioBtnUser.setId("fontWhite");
        radioBtnUser.setText("as User");
        pane3.getChildren().add(radioBtnUser);

        RadioButton radioBtnDelivery = new RadioButton();
        radioBtnDelivery.setLayoutX(50.0);
        radioBtnDelivery.setLayoutY(160.0);
        radioBtnDelivery.setId("fontWhite");
        radioBtnDelivery.setText("as Delivery");
        pane3.getChildren().add(radioBtnDelivery);

        ToggleGroup toggleGroup2 = new ToggleGroup();
        radioBtnAdmin.setToggleGroup(toggleGroup2);
        radioBtnUser.setToggleGroup(toggleGroup2);
        radioBtnDelivery.setToggleGroup(toggleGroup2);

        Separator separator = new Separator();
        separator.setLayoutX(150.0);
        separator.setLayoutY(100.0);
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(90.0);
        separator.setPrefWidth(10.0);
        pane3.getChildren().add(separator);

        TextField textFieldUsername = new TextField();
        textFieldUsername.setLayoutX(280.0);
        textFieldUsername.setLayoutY(150.0);
        textFieldUsername.setPrefHeight(20.0);
        textFieldUsername.setPrefWidth(180.0);
        textFieldUsername.setPromptText("username");
        pane3.getChildren().add(textFieldUsername);
        textFieldUsername.setId("textfield");

        Label labelUsername = new Label("Username :");
        labelUsername.setLayoutX(198.0);
        labelUsername.setLayoutY(152.0);
        labelUsername.setPrefHeight(20.0);
        labelUsername.setPrefWidth(70.0);
        labelUsername.setId("fontWhite");
        pane3.getChildren().add(labelUsername);

        Label labelError = new Label();
        labelError.setLayoutX(281.0);
        labelError.setLayoutY(293.0);
        labelError.setPrefHeight(30.0);
        labelError.setPrefWidth(178.0);
        labelError.setId("fontWhite");
        labelError.setFont(new Font("Calibri", 10.0));
        pane3.getChildren().add(labelError);

        Button buttonBack = new Button();
        buttonBack.setLayoutX(380.0);
        buttonBack.setLayoutY(215.0);
        buttonBack.setMnemonicParsing(false);
        buttonBack.setPrefHeight(20.0);
        buttonBack.setPrefWidth(80.0);
        buttonBack.setText("Back");
        buttonBack.setId("deliveryID");
        pane3.getChildren().add(buttonBack);
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });

        Button buttonNext = new Button("Next");
        buttonNext.setLayoutX(280.0);
        buttonNext.setLayoutY(215.0);
        buttonNext.setMnemonicParsing(false);
        buttonNext.setPrefHeight(20.0);
        buttonNext.setPrefWidth(80.0);
        buttonNext.setId("userID");
        pane3.getChildren().add(buttonNext);
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup2.getSelectedToggle() == radioBtnAdmin && !textFieldUsername.getText().equals("")) {
                    if (!Functions.isUserNameUnique(textFieldUsername.getText(),"ADMIN", staticArrayLists))
                        loadForgetPass2Screen(primaryStage, textFieldUsername.getText(), "ADMIN");
                    else
                        labelError.setText("Username not found !!!");
                } else if (toggleGroup2.getSelectedToggle() == radioBtnUser && !textFieldUsername.getText().equals("")) {
                    if (!Functions.isUserNameUnique(textFieldUsername.getText(),"USER", staticArrayLists))
                        loadForgetPass2Screen(primaryStage, textFieldUsername.getText(), "USER");
                    else
                        labelError.setText("Username not found !!!");
                } else if (toggleGroup2.getSelectedToggle() == radioBtnDelivery && !textFieldUsername.getText().equals("")) {
                    if (!Functions.isUserNameUnique(textFieldUsername.getText(),"DELIVERY", staticArrayLists))
                        loadForgetPass2Screen(primaryStage, textFieldUsername.getText(), "DELIVERY");
                    else
                        labelError.setText("Username not found !!!");
                } else {
                    labelError.setText("please select a Role and enter your username !!! ");
                }
            }
        });

        Label labelTitle = new Label();
        labelTitle.setLayoutY(30);
        labelTitle.setLayoutX(80);
        labelTitle.setText("FORGET PASSWORD PAGE");
        labelTitle.setFont(new Font(20.0));
        labelTitle.setId("fontWhite");
        pane3.getChildren().add(labelTitle);

        Label labelCredits = new Label();
        labelCredits.setLayoutY(386.0);
        labelCredits.setPrefHeight(17.0);
        labelCredits.setPrefWidth(298.0);
        labelCredits.setText("Producted by Mahdi, MoMehdi, Seyedali");
        labelCredits.setId("fontWhite");
        labelCredits.setFont(new Font(8.0));
        pane3.getChildren().add(labelCredits);

        Label labelPrompt = new Label();
        labelPrompt.setLayoutX(198.0);
        labelPrompt.setLayoutY(107.0);
        labelPrompt.setPrefHeight(20.0);
        labelPrompt.setPrefWidth(262.0);
        labelPrompt.setId("fontWhite");
        labelPrompt.setText("Please enter your username to reset your password");
        labelPrompt.setFont(new Font(11.5));
        pane3.getChildren().add(labelPrompt);

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane3.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane3, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadForgetPass2Screen(Stage primaryStage, String username, String RoleString) {
        Pane pane3 = new Pane();

        RadioButton radioBtnAdmin = new RadioButton();
        radioBtnAdmin.setLayoutX(50.0);
        radioBtnAdmin.setLayoutY(100.0);
        radioBtnAdmin.setText("as Admin");
        pane3.getChildren().add(radioBtnAdmin);
        radioBtnAdmin.setDisable(true);
        radioBtnAdmin.setId("fontWhite");

        RadioButton radioBtnUser = new RadioButton();
        radioBtnUser.setLayoutX(50.0);
        radioBtnUser.setLayoutY(130.0);
        radioBtnUser.setText("as User");
        pane3.getChildren().add(radioBtnUser);
        radioBtnUser.setDisable(true);
        radioBtnUser.setId("fontWhite");

        RadioButton radioBtnDelivery = new RadioButton();
        radioBtnDelivery.setLayoutX(50.0);
        radioBtnDelivery.setLayoutY(160.0);
        radioBtnDelivery.setText("as Delivery");
        pane3.getChildren().add(radioBtnDelivery);
        radioBtnDelivery.setDisable(true);
        radioBtnDelivery.setId("fontWhite");

        Separator separator = new Separator();
        separator.setLayoutX(150.0);
        separator.setLayoutY(100.0);
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(90.0);
        separator.setPrefWidth(10.0);
        pane3.getChildren().add(separator);

        TextField textFieldUsername = new TextField();
        textFieldUsername.setLayoutX(280.0);
        textFieldUsername.setLayoutY(150.0);
        textFieldUsername.setPrefHeight(20.0);
        textFieldUsername.setPrefWidth(180.0);
        textFieldUsername.setPromptText("username");
        pane3.getChildren().add(textFieldUsername);
        textFieldUsername.setEditable(false);
        textFieldUsername.setDisable(true);
        textFieldUsername.setText(username);
        textFieldUsername.setId("textfield");

        Label labelUsername = new Label("Username :");
        labelUsername.setLayoutX(198.0);
        labelUsername.setLayoutY(152.0);
        labelUsername.setPrefHeight(20.0);
        labelUsername.setPrefWidth(70.0);
        pane3.getChildren().add(labelUsername);
        labelUsername.setId("fontWhite");

        Label labelTitle = new Label();
        labelTitle.setLayoutY(30);
        labelTitle.setLayoutX(80);
        labelTitle.setText("FORGET PASSWORD PAGE");
        labelTitle.setFont(new Font(20.0));
        pane3.getChildren().add(labelTitle);
        labelTitle.setId("fontWhite");

        Label labelCredits = new Label();
        labelCredits.setLayoutY(386.0);
        labelCredits.setPrefHeight(17.0);
        labelCredits.setPrefWidth(298.0);
        labelCredits.setText("Producted by Mahdi, MoMehdi, Seyedali");
        labelCredits.setId("fontWhite");
        labelCredits.setFont(new Font(8.0));
        pane3.getChildren().add(labelCredits);
        labelCredits.setId("fontWhite");

        Label labelPrompt = new Label();
        labelPrompt.setLayoutX(198.0);
        labelPrompt.setLayoutY(107.0);
        labelPrompt.setPrefHeight(20.0);
        labelPrompt.setPrefWidth(262.0);
        labelPrompt.setText("Please enter your username to reset your password");
        labelPrompt.setFont(new Font(11.5));
        pane3.getChildren().add(labelPrompt);
        labelPrompt.setId("fontWhite");

        textFieldUsername.setEditable(false);

        Separator separator2 = new Separator();
        separator2.setLayoutX(230.0);
        separator2.setLayoutY(190.0);
        separator2.setPrefHeight(10.0);
        separator2.setPrefWidth(200.0);
        pane3.getChildren().add(separator2);

        Label questionLabel = new Label("Please answer to this question ...");
        questionLabel.setLayoutX(198.0);
        questionLabel.setLayoutY(210.0);
        questionLabel.setPrefHeight(20.0);
        questionLabel.setPrefWidth(262.0);
        questionLabel.setFont(new Font(11.7));
        pane3.getChildren().add(questionLabel);
        questionLabel.setId("fontWhite");

        int roleIndex = Functions.findRoleIndex(username, RoleString, staticArrayLists);

        Label securityQuestionLabel = new Label();
        securityQuestionLabel.setLayoutX(198.0);
        securityQuestionLabel.setLayoutY(240.0);
        pane3.getChildren().add(securityQuestionLabel);
        securityQuestionLabel.setId("fontWhite");

        if (RoleString.equals("ADMIN")) {
            System.out.println(staticArrayLists.adminStaticArrayList.size());
            Admin admin = staticArrayLists.adminStaticArrayList.get(roleIndex);
            securityQuestionLabel.setText(admin.securityQuestion);
        } else if (RoleString.equals("USER")) {
            User user = staticArrayLists.userStaticArrayList.get(roleIndex);
            securityQuestionLabel.setText(user.securityQuestion);
        } else if (RoleString.equals("DELIVERY")) {
            Delivery delivery = staticArrayLists.deliveriesArraylist.get(roleIndex);
            securityQuestionLabel.setText(delivery.securityQuestion);
        }

        TextField securityAnswerTextField = new TextField();
        securityAnswerTextField.setId("textfield");
        securityAnswerTextField.setLayoutX(198.0);
        securityAnswerTextField.setLayoutY(270.0);
        securityAnswerTextField.setPrefHeight(20.0);
        securityAnswerTextField.setPrefWidth(262.0);
        securityAnswerTextField.setPromptText("Security Question's Answer");
        pane3.getChildren().add(securityAnswerTextField);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(198.0);
        errorLabel.setLayoutY(350.0);
        errorLabel.setPrefHeight(30.0);
        errorLabel.setPrefWidth(178.0);
        errorLabel.setTextFill(javafx.scene.paint.Color.RED);
        errorLabel.setFont(new Font("Calibri", 10.0));
        pane3.getChildren().add(errorLabel);
        errorLabel.setId("fontWhite");

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(198.0);
        resetButton.setLayoutY(310.0);
        resetButton.setPrefSize(80, 30);
        resetButton.setId("userID");
        pane3.getChildren().add(resetButton);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (RoleString.equals("ADMIN")) {
                    Admin admin = staticArrayLists.adminStaticArrayList.get(roleIndex);
                    if (securityAnswerTextField.getText().equals(admin.getSecurityQuestionAnswer())) {
                        loadForgetPass3Screen(primaryStage, admin, username, RoleString);
                    } else {
                        errorLabel.setText("answer is wrong !!!");
                    }
                } else if (RoleString.equals("USER")) {
                    User user = staticArrayLists.userStaticArrayList.get(roleIndex);
                    if (securityAnswerTextField.getText().equals(user.getSecurityQuestionAnswer())) {
                        loadForgetPass3Screen(primaryStage, user, username, RoleString);
                    } else {
                        errorLabel.setText("answer is wrong !!!");
                    }
                } else if (RoleString.equals("DELIVERY")) {
                    Delivery delivery = staticArrayLists.deliveriesArraylist.get(roleIndex);
                    if (securityAnswerTextField.getText().equals(delivery.getSecurityQuestionAnswer())) {
                        loadForgetPass3Screen(primaryStage, delivery, username, RoleString);
                    } else {
                        errorLabel.setText("answer is wrong !!!");
                    }
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(298);
        backButton.setLayoutY(310);
        backButton.setPrefSize(80, 30);
        backButton.setId("deliveryID");
        pane3.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass1Screen(primaryStage);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane3.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane3, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadForgetPass3Screen(Stage primaryStage, Role role, String username, String roleString) {
        Pane pane6 = new Pane();

        Label newPasswordLabel = new Label("New Password:");
        newPasswordLabel.setLayoutX(115);
        newPasswordLabel.setLayoutY(85);
        pane6.getChildren().add(newPasswordLabel);
        newPasswordLabel.setId("fontWhite");

        Label confirmNewPasswordLabel = new Label("Confirm New Password:");
        confirmNewPasswordLabel.setLayoutX(115);
        confirmNewPasswordLabel.setLayoutY(130);
        pane6.getChildren().add(confirmNewPasswordLabel);
        confirmNewPasswordLabel.setId("fontWhite");

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setLayoutX(255);
        newPasswordField.setLayoutY(83);
        newPasswordField.setPrefHeight(20);
        newPasswordField.setPrefWidth(180);
        pane6.getChildren().add(newPasswordField);
        newPasswordField.setId("textfield");

        PasswordField confirmNewPasswordField = new PasswordField();
        confirmNewPasswordField.setLayoutX(255);
        confirmNewPasswordField.setLayoutY(126);
        confirmNewPasswordField.setPrefHeight(20);
        confirmNewPasswordField.setPrefWidth(180);
        pane6.getChildren().add(confirmNewPasswordField);
        confirmNewPasswordField.setId("textfield");

        Label successLabel = new Label();
        successLabel.setLayoutX(275);
        successLabel.setLayoutY(224);
        successLabel.setPrefHeight(20);
        successLabel.setPrefWidth(140);
        successLabel.setTextFill(Color.RED);
        successLabel.setFont(new Font(10));
        pane6.getChildren().add(successLabel);
        successLabel.setId("fontWhite");

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(255);
        resetButton.setLayoutY(169);
        resetButton.setPrefSize(80, 20);
        resetButton.setId("userID");
        pane6.getChildren().add(resetButton);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!newPasswordField.getText().equals("") && !confirmNewPasswordField.getText().equals("")) {
                    if (newPasswordField.getText().equals(confirmNewPasswordField.getText())) {
                        if (role instanceof Admin) {
                            int roleIndex = Functions.findRoleIndex(username, "ADMIN", staticArrayLists);
                            Admin admin = staticArrayLists.adminStaticArrayList.get(roleIndex);
                            admin.setPassword(newPasswordField.getText());
                        } else if (role instanceof User) {
                            int roleIndex = Functions.findRoleIndex(username, "USER", staticArrayLists);
                            User user = staticArrayLists.userStaticArrayList.get(roleIndex);
                            user.setPassword(newPasswordField.getText());
                        } else if (role instanceof Delivery) {
                            int roleIndex = Functions.findRoleIndex(username, "DELIVERY", staticArrayLists);
                            Delivery delivery = staticArrayLists.deliveriesArraylist.get(roleIndex);
                            delivery.setPassword(newPasswordField.getText());
                        }
                        successLabel.setText("Password successfully changed");
                    } else {
                        successLabel.setText("entered passwords are not the same !!!");
                    }
                } else {
                    successLabel.setText("Please enter both of textfields !!! ");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(355);
        backButton.setLayoutY(169);
        backButton.setPrefSize(80, 20);
        backButton.setId("deliveryID");
        pane6.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (role instanceof Admin) {
                    Admin admin = (Admin) Role.loggedInRole;
                    loadForgetPass2Screen(primaryStage, username, "ADMIN");
                } else if (role instanceof User) {
                    User user = (User) Role.loggedInRole;
                    loadForgetPass2Screen(primaryStage, username, "USER");
                } else if (role instanceof Delivery) {
                    Delivery delivery = (Delivery) Role.loggedInRole;
                    loadForgetPass2Screen(primaryStage, delivery.getUserName(), "DELIVERY");
                }
            }
        });
        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane6.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane6, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSignUp1Screen(Stage primaryStage) {
        Pane pane2 = new Pane();

        RadioButton asAdminRadioButton = new RadioButton("as Admin");
        asAdminRadioButton.setLayoutX(50.0);
        asAdminRadioButton.setLayoutY(100.0);
        asAdminRadioButton.setId("fontWhite");

        RadioButton asUserRadioButton = new RadioButton("as User");
        asUserRadioButton.setLayoutX(50.0);
        asUserRadioButton.setLayoutY(130.0);
        asUserRadioButton.setId("fontWhite");

        RadioButton asDeliveryRadioButton = new RadioButton("as Delivery");
        asDeliveryRadioButton.setLayoutX(50.0);
        asDeliveryRadioButton.setLayoutY(160.0);
        asDeliveryRadioButton.setId("fontWhite");

        ToggleGroup toggleGroup3 = new ToggleGroup();
        asAdminRadioButton.setToggleGroup(toggleGroup3);
        asUserRadioButton.setToggleGroup(toggleGroup3);
        asDeliveryRadioButton.setToggleGroup(toggleGroup3);

        Separator separator = new Separator();
        separator.setLayoutX(150.0);
        separator.setLayoutY(100.0);
        separator.setPrefWidth(10);
        separator.setPrefHeight(80);
        separator.setOrientation(Orientation.VERTICAL);

        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(280.0);
        usernameTextField.setLayoutY(95);
        usernameTextField.setPrefSize(180, 20);
        usernameTextField.setPromptText("username");
        usernameTextField.setId("textfield");

        Label usernameLabel = new Label("Username :");
        usernameLabel.setLayoutX(198.0);
        usernameLabel.setLayoutY(107.0);
        usernameLabel.setId("fontWhite");

        Label passwordLabel = new Label("Password :");
        passwordLabel.setLayoutX(198.0);
        passwordLabel.setLayoutY(133.0);
        passwordLabel.setId("fontWhite");

        PasswordField passwordPasswordField = new PasswordField();
        passwordPasswordField.setLayoutX(280.0);
        passwordPasswordField.setLayoutY(130);
        passwordPasswordField.setPrefSize(180, 20);
        passwordPasswordField.setPromptText("pass");
        passwordPasswordField.setId("textfield");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setLayoutX(280.0);
        confirmPasswordField.setLayoutY(165);
        confirmPasswordField.setPrefSize(180, 20);
        confirmPasswordField.setPromptText("enter your pass again");
        confirmPasswordField.setId("textfield");

        Label errorLabel = new Label();
        errorLabel.setLayoutX(280);
        errorLabel.setLayoutY(290);
        errorLabel.setPrefHeight( 30);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font("Calibri", 10));
        errorLabel.setId("fontWhite");

        Button nextButton = new Button("Next");
        nextButton.setLayoutX(280.0);
        nextButton.setLayoutY(215.0);
        nextButton.setPrefWidth(80);
        nextButton.setPrefHeight(20);
        nextButton.setId("userID");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameTextField.getText();
                String password = passwordPasswordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                if (toggleGroup3.getSelectedToggle() == asAdminRadioButton) {
                    if (confirmPassword.equals(password)) {
                        String[] answer = Functions.checkPassword(password, "ADMIN", username, staticArrayLists);
                        if (answer[0].equals("true")) {
                            if (answer[2].equals("false")) {
                                Admin admin = new Admin(username, password, Functions.setID("admin", staticArrayLists));
                                staticArrayLists.adminStaticArrayList.add(admin);
                                loadSignUp2Screen(primaryStage, admin);
                            } else {
                                errorLabel.setText("this username exist !!!");
                            }
                        } else {
                            if (answer[1].equals("1")) {
                                errorLabel.setText("passowrd error : Passowrd must have at least one number!");
                            } else if (answer[1].equals("2")) {
                                errorLabel.setText("passowrd error : Password must have at least one capital letter!");
                            } else if (answer[1].equals("3")) {
                                errorLabel.setText("passowrd error : Password must have at least one small letter!");
                            } else if (answer[1].equals("4")) {
                                errorLabel.setText("passowrd error : Password must have at least 8 charecter!");
                            }
                        }
                    } else {
                        errorLabel.setText("passowords are not the same !!!");
                    }
                } else if (toggleGroup3.getSelectedToggle() == asUserRadioButton) {
                    if (confirmPassword.equals(password)) {
                        String[] answer = Functions.checkPassword(password, "USER", username, staticArrayLists);
                        if (answer[0].equals("true")) {
                            if (answer[2].equals("false")) {
                                User user = new User(username, password, Functions.setID("user", staticArrayLists));
                                user.userLocation = Functions.setRandomLocation(staticArrayLists);
                                staticArrayLists.userStaticArrayList.add(user);
                                loadSignUp2Screen(primaryStage, user);
                            } else {
                                errorLabel.setText("this username exist !!!");
                            }
                        } else {
                            if (answer[1].equals("1")) {
                                errorLabel.setText("passowrd error : Passowrd must have at least one number!");
                            } else if (answer[1].equals("2")) {
                                errorLabel.setText("passowrd error : Password must have at least one capital letter!");
                            } else if (answer[1].equals("3")) {
                                errorLabel.setText("passowrd error : Password must have at least one small letter!");
                            } else if (answer[1].equals("4")) {
                                errorLabel.setText("passowrd error : Password must have at least 8 charecter!");
                            }
                        }
                    } else {
                        errorLabel.setText("passowords are not the same !!!");
                    }
                } else if (toggleGroup3.getSelectedToggle() == asDeliveryRadioButton) {
                    if (confirmPassword.equals(password)) {
                        String[] answer = Functions.checkPassword(password, "DELIVERY", username, staticArrayLists);
                        if (answer[0].equals("true")) {
                            if (answer[2].equals("false")) {
                                Delivery delivery = new Delivery(username, password, Functions.setID("delivery", staticArrayLists));
                                staticArrayLists.deliveriesArraylist.add(delivery);
                                delivery.deliveryLocation = Functions.setRandomLocation(staticArrayLists);
                                loadSignUp2Screen(primaryStage, delivery);
                            } else {
                                errorLabel.setText("this username exist !!!");
                            }
                        } else {
                            if (answer[1].equals("1")) {
                                errorLabel.setText("passowrd error : Passowrd must have at least one number!");
                            } else if (answer[1].equals("2")) {
                                errorLabel.setText("passowrd error : Password must have at least one capital letter!");
                            } else if (answer[1].equals("3")) {
                                errorLabel.setText("passowrd error : Password must have at least one small letter!");
                            } else if (answer[1].equals("4")) {
                                errorLabel.setText("passowrd error : Password must have at least 8 charecter!");
                            }
                        }
                    } else {
                        errorLabel.setText("passowords are not the same !!!");
                    }
                } else {
                    errorLabel.setText("Please select your account type !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(380);
        backButton.setLayoutY(215);
        backButton.setPrefWidth(80);
        backButton.setPrefHeight(20);
        backButton.setId("deliveryID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadWellcomeScreen(primaryStage);
            }
        });


        Label pageTitleLabel = new Label("SIGN UP PAGE");
        pageTitleLabel.setLayoutY(30);
        pageTitleLabel.setLayoutX(80);
        pageTitleLabel.setFont(new Font(20.0));
        pageTitleLabel.setId("fontWhite");

        Label creditLabel = new Label("Producted by Mahdi, MoMehdi, Seyedali");
        creditLabel.setLayoutY(386.0);
        creditLabel.setTextFill(Color.web("#404040"));
        creditLabel.setFont(new Font(8.0));
        creditLabel.setId("fontWhite");

        pane2.getChildren().addAll(asAdminRadioButton, asUserRadioButton, separator, usernameTextField, usernameLabel, passwordLabel,
                passwordPasswordField, nextButton, backButton, asDeliveryRadioButton, errorLabel, confirmPasswordField, pageTitleLabel, creditLabel);

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane2.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane2, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSignUp2Screen(Stage primaryStage, Role role) {
        Pane pane5 = new Pane();
        RadioButton radioButton1 = new RadioButton("as Admin");
        radioButton1.setLayoutX(50.0);
        radioButton1.setLayoutY(100.0);
        radioButton1.setMnemonicParsing(false);
        radioButton1.setDisable(true);
        radioButton1.setId("fontWhite");

        RadioButton radioButton2 = new RadioButton("as User");
        radioButton2.setLayoutX(50.0);
        radioButton2.setLayoutY(130.0);
        radioButton2.setMnemonicParsing(false);
        radioButton2.setDisable(true);
        radioButton2.setId("fontWhite");

        RadioButton radioButton3 = new RadioButton("as Delivery");
        radioButton3.setLayoutX(50.0);
        radioButton3.setLayoutY(160.0);
        radioButton3.setMnemonicParsing(false);
        radioButton3.setDisable(true);
        radioButton3.setId("fontWhite");

        Separator separator = new Separator();
        separator.setLayoutX(150.0);
        separator.setLayoutY(100.0);
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(90.0);
        separator.setPrefWidth(10.0);

        TextField textField1 = new TextField();
        textField1.setLayoutX(280.0);
        textField1.setLayoutY(95);
        textField1.setPrefHeight(20.0);
        textField1.setPrefWidth(180.0);
        textField1.setPromptText("username");
        textField1.setEditable(false);
        textField1.setDisable(true);
        textField1.setId("textfield");

        Label label1 = new Label("Username :");
        label1.setLayoutX(198.0);
        label1.setLayoutY(107.0);
        label1.setPrefHeight(20.0);
        label1.setPrefWidth(70.0);
        label1.setId("fontWhite");

        Label label2 = new Label("Password :");
        label2.setLayoutX(199.0);
        label2.setLayoutY(133.0);
        label2.setPrefHeight(20.0);
        label2.setPrefWidth(70.0);
        label2.setId("fontWhite");

        PasswordField passField2 = new PasswordField();
        passField2.setLayoutX(280.0);
        passField2.setLayoutY(130.0);
        passField2.setPrefHeight(20.0);
        passField2.setPrefWidth(180.0);
        passField2.setPromptText("pass");
        passField2.setEditable(false);
        passField2.setDisable(true);
        passField2.setId("textfield");

        PasswordField passField3 = new PasswordField();
        passField3.setLayoutX(280.0);
        passField3.setLayoutY(165);
        passField3.setPrefHeight(20.0);
        passField3.setPrefWidth(180.0);
        passField3.setPromptText("enter your pass again");
        passField3.setEditable(false);
        passField3.setDisable(true);
        passField3.setId("textfield");

        TextField textField4 = new TextField();
        textField4.setLayoutX(198.0);
        textField4.setLayoutY(270.0);
        textField4.setPrefHeight(20.0);
        textField4.setPrefWidth(262.0);
        textField4.setPromptText("Security Question's Answer");
        textField4.setId("textfield");

        Label label3 = new Label();
        label3.setLayoutX(80.0);
        label3.setLayoutY(30.0);
        label3.setText("SIGN UP PAGE");
        label3.setFont(new Font(20.0));
        label3.setId("fontWhite");

        Label label4 = new Label("Producted by Mahdi,MoMehdi,Seyedali");
        label4.setLayoutY(386.0);
        label4.setPrefHeight(17.0);
        label4.setPrefWidth(298.0);
        label4.setTextFill(javafx.scene.paint.Color.web("#404040"));
        label4.setFont(new Font(8.0));
        label4.setId("fontWhite");

        Separator separator2 = new Separator();
        separator2.setLayoutX(230.0);
        separator2.setLayoutY(190.0);
        separator2.setPrefHeight(10.0);
        separator2.setPrefWidth(200.0);

        Label label5 = new Label("Please answer to this security question");
        label5.setLayoutX(198.0);
        label5.setLayoutY(210.0);
        label5.setPrefHeight(20.0);
        label5.setPrefWidth(262.0);
        label5.setFont(new Font(11.7));
        label5.setId("fontWhite");

        Label label6 = new Label(Functions.makeSecurityQuestion(role));
        label6.setLayoutX(198.0);
        label6.setLayoutY(240.0);
        label6.setPrefHeight(20.0);
        label6.setPrefWidth(262.0);
        label6.setId("fontWhite");

        Label label7 = new Label();
        label7.setLayoutX(198);
        label7.setLayoutY(350);
        label7.setId("fontWhite");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setLayoutX(199.0);
        signUpButton.setLayoutY(310.0);
        signUpButton.setPrefHeight(20.0);
        signUpButton.setPrefWidth(80.0);
        signUpButton.setId("userID");
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textField4.getText().equals("")) {
                    role.setSecurityQuestionAnswer(textField4.getText());
                    label7.setText("Signed up successfully, you can login using login page now!");
                } else {
                    label7.setText("Signed up successfully, you can login using login page now!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(298);
        backButton.setLayoutY(310);
        backButton.setPrefSize(80, 20);
        backButton.setId("deliveryID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadWellcomeScreen(primaryStage);
            }
        });

        pane5.getChildren().addAll(signUpButton, label1, label2, label3, label4, label5, label6, label7, separator, separator2, radioButton1, radioButton2,
                radioButton3, textField1, passField2, passField3, textField4, backButton);

        BackgroundImage myBackground = new BackgroundImage(new Image("background.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane5.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane5, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAdminPanelScreen(Stage primaryStage, String adminID) {
        Pane pane7 = new Pane();
        int adminIndex = 0;
        for (int i = 0; i < staticArrayLists.adminStaticArrayList.size(); i++) {
            if (staticArrayLists.adminStaticArrayList.get(i).adminID.equals(adminID)) {
                adminIndex = i;
            }
        }
        Admin admin = staticArrayLists.adminStaticArrayList.get(adminIndex);
        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200);
        listView.setLayoutY(75);
        listView.setPrefHeight(250);
        listView.setPrefWidth(375);
        listView.getItems().addAll(Functions.showRestaurantList(admin));
        pane7.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25);
        textField.setLayoutY(125);
        textField.setPrefHeight(25);
        textField.setPrefWidth(150);
        pane7.getChildren().add(textField);
        textField.setPromptText("restaurant ID");
        textField.setId("textfield");

        Label label = new Label();
        label.setLayoutX(25);
        label.setLayoutY(100);
        label.setText("please enter restaurant ID");
        pane7.getChildren().add(label);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(25);
        notifLabel.setLayoutY(290);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane7.getChildren().add(notifLabel);

        Button selectButton = new Button();
        selectButton.setLayoutX(25);
        selectButton.setLayoutY(165);
        selectButton.setPrefHeight(20);
        selectButton.setPrefWidth(150);
        selectButton.setText("Select");
        selectButton.setId("adminID");
        pane7.getChildren().add(selectButton);
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean restaurantIdExistance = Functions.searchRestaurant(admin, textField.getText());
                if (restaurantIdExistance) {
                    loadRestaurantScreen(primaryStage, textField.getText());
                } else {
                    notifLabel.setText("Restaurant not found !!!");
                }
            }
        });

        Label restaurantsLabel = new Label();
        restaurantsLabel.setLayoutX(25);
        restaurantsLabel.setLayoutY(75);
        restaurantsLabel.setPrefHeight(25);
        restaurantsLabel.setPrefWidth(150);
        restaurantsLabel.setText("To see your restaurants");
        pane7.getChildren().add(restaurantsLabel);

        Button addRestaurantButton = new Button();
        addRestaurantButton.setLayoutX(25);
        addRestaurantButton.setLayoutY(205);
        addRestaurantButton.setPrefHeight(25);
        addRestaurantButton.setPrefWidth(150);
        addRestaurantButton.setText("Add new restaurant");
        addRestaurantButton.setId("adminID");
        pane7.getChildren().add(addRestaurantButton);
        addRestaurantButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddRestaurantScreen(primaryStage);
            }
        });

        Button logoutButton = new Button();
        logoutButton.setLayoutX(25);
        logoutButton.setLayoutY(245);
        logoutButton.setPrefHeight(25);
        logoutButton.setPrefWidth(150);
        logoutButton.setText("LOGOUT");
        logoutButton.setId("adminID");
        pane7.getChildren().add(logoutButton);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane7.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane7, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRestaurantScreen(Stage primaryStage, String restaurantID) {
        Pane pane8 = new Pane();
        Admin admin = (Admin) Role.loggedInRole;

        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(25.0);
        gridPane.setLayoutY(180.0);
        gridPane.setPrefHeight(100.0);
        gridPane.setPrefWidth(550.0);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column3.setMinWidth(10.0);
        column3.setPrefWidth(100.0);

        ColumnConstraints column4 = new ColumnConstraints();
        column4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column4.setMinWidth(10.0);
        column4.setPrefWidth(100.0);

        RowConstraints row1 = new RowConstraints();
        row1.setMaxHeight(61.59998779296875);
        row1.setMinHeight(10.0);
        row1.setPrefHeight(28.799999999999997);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints row2 = new RowConstraints();
        row2.setMaxHeight(45.60000000000001);
        row2.setMinHeight(0.0);
        row2.setPrefHeight(45.60000000000001);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        Button button1 = new Button();
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(50.0);
        button1.setPrefWidth(145.0);
        button1.setText("Menu");
        button1.setId("adminID");
        GridPane.setHalignment(button1, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button1, javafx.geometry.VPos.CENTER);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuScreenForAdmin(primaryStage);
            }
        });

        Button button2 = new Button();
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(50.0);
        button2.setPrefWidth(145.0);
        button2.setId("adminID");
        button2.setText("Open orders");
        GridPane.setHalignment(button2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button2, 1);
        GridPane.setValignment(button2, javafx.geometry.VPos.CENTER);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOpenOrderScreen(primaryStage, restaurantID);
            }
        });

        Button button3 = new Button();
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(50.0);
        button3.setPrefWidth(145.0);
        button3.setText("Display comments");
        button3.setId("adminID");
        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 0);
        GridPane.setHalignment(button3, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button3, javafx.geometry.VPos.CENTER);
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsScreen(primaryStage);
            }
        });

        Button button4 = new Button();
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(50.0);
        button4.setPrefWidth(145.0);
        button4.setId("adminID");
        button4.setText("Order history");
        GridPane.setColumnIndex(button4, 1);
        GridPane.setHalignment(button4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button4, 1);
        GridPane.setValignment(button4, javafx.geometry.VPos.CENTER);
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderHistoryForAdminScreen(primaryStage);
            }
        });

        Button button5 = new Button();
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(50.0);
        button5.setPrefWidth(145.0);
        button5.setId("adminID");
        button5.setText("Show foodtype");
        GridPane.setColumnIndex(button5, 2);
        GridPane.setRowIndex(button5, 0);
        GridPane.setHalignment(button5, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button5, javafx.geometry.VPos.CENTER);
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadShowFoodtypeScreen(primaryStage);
            }
        });

        Button button6 = new Button();
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(50.0);
        button6.setPrefWidth(145.0);
        button6.setId("adminID");
        button6.setText("Edit location");
        GridPane.setColumnIndex(button6, 2);
        GridPane.setRowIndex(button6, 1);
        GridPane.setHalignment(button6, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button6, javafx.geometry.VPos.CENTER);
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditLocationForAdminScreen(primaryStage);
            }
        });

        Button button7 = new Button();
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(50.0);
        button7.setPrefWidth(145.0);
        button7.setId("adminID");
        button7.setText("Edit foodtype");
        GridPane.setColumnIndex(button7, 3);
        GridPane.setRowIndex(button7, 0);
        GridPane.setHalignment(button7, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button7, javafx.geometry.VPos.CENTER);
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditFoodtypeScreen(primaryStage);
            }
        });

        Button button8 = new Button();
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(50.0);
        button8.setPrefWidth(145.0);
        button8.setId("adminID");
        button8.setText("Back");

        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAdminPanelScreen(primaryStage, restaurant.restaurantOwner.adminID);
            }
        });
        GridPane.setColumnIndex(button8, 3);
        GridPane.setRowIndex(button8, 1);
        GridPane.setHalignment(button8, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button8, javafx.geometry.VPos.CENTER);

        gridPane.getColumnConstraints().addAll(column1, column2, column3, column4);
        gridPane.getRowConstraints().addAll(row1, row2);
        gridPane.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8);

        Separator separator1 = new Separator();
        separator1.setLayoutX(25.0);
        separator1.setLayoutY(160.0);
        separator1.setPrefHeight(10.0);
        separator1.setPrefWidth(550.0);

        Separator separator2 = new Separator();
        separator2.setLayoutX(25.0);
        separator2.setLayoutY(290.0);
        separator2.setPrefHeight(10.0);
        separator2.setPrefWidth(550.0);

        Label restaurantNameLabel = new Label(restaurant.restaurantName);
        restaurantNameLabel.setLayoutX(25.0);
        restaurantNameLabel.setLayoutY(50.0);
        restaurantNameLabel.setFont(new Font(20.0));

        Label restaurantRatingLabel = new Label("RATE : " + restaurant.getRating());
        restaurantRatingLabel.setLayoutX(25.0);
        restaurantRatingLabel.setLayoutY(100.0);
        restaurantRatingLabel.setPrefHeight(20.0);
        restaurantRatingLabel.setPrefWidth(100.0);

        Label restaurantLocationLabel = new Label("LOCATION : " + restaurant.restaurantLocation);
        restaurantLocationLabel.setLayoutX(200.0);
        restaurantLocationLabel.setLayoutY(100.0);
        restaurantLocationLabel.setPrefHeight(20.0);
        restaurantLocationLabel.setPrefWidth(105.0);

        Label notificationLabel = new Label();
        notificationLabel.setLayoutX(25.0);
        notificationLabel.setLayoutY(133.0);
        notificationLabel.setTextFill(javafx.scene.paint.Color.RED);

        ImageView logoImageView = new ImageView();
        logoImageView.setFitHeight(100.0);
        logoImageView.setFitWidth(100.0);
        logoImageView.setLayoutX(460.0);
        logoImageView.setLayoutY(50.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);

        Label logoTextLabel = new Label("LOGO");
        logoTextLabel.setLayoutX(495.0);
        logoTextLabel.setLayoutY(90.0);

        pane8.getChildren().addAll(gridPane, separator1, separator2, restaurantNameLabel, restaurantRatingLabel, restaurantLocationLabel, notificationLabel, logoImageView, logoTextLabel);

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane8.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane8, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadMenuScreenForAdmin(Stage primaryStage) {
        Pane pane9 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefHeight(250.0);
        listView.setPrefWidth(375.0);
        listView.getItems().addAll(Functions.showMenuForAdmin());
        pane9.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25.0);
        textField.setLayoutY(125.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(150.0);
        pane9.getChildren().add(textField);
        textField.setPromptText("food ID");
        textField.setId("textfield");

        Label label1 = new Label();
        label1.setLayoutX(25.0);
        label1.setLayoutY(100.0);
        label1.setText("please enter food ID");
        pane9.getChildren().add(label1);

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(25.0);
        noticeLabel.setLayoutY(285.0);
        pane9.getChildren().add(noticeLabel);
        noticeLabel.setFont(new Font(10));
        noticeLabel.setTextFill(Color.RED);

        Button button1 = new Button();
        button1.setLayoutX(25.0);
        button1.setLayoutY(165.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(20.0);
        button1.setPrefWidth(150.0);
        button1.setText("Select");
        button1.setId("adminID");
        pane9.getChildren().add(button1);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textField.getText().equals("")) {
                    String foodID = textField.getText();
                    boolean foodIDExistance = Functions.foodIDExistanceChecker(restaurant, foodID);
                    if (foodIDExistance) {
                        Food food = Functions.foodIDfounder(restaurant, foodID);
                        Food.selectedFoodForAdmin = food;
                        loadFoodScreen(primaryStage);
                    } else {
                        noticeLabel.setText("this food ID does not exist !!!");
                    }
                } else {
                    noticeLabel.setText("please enter food ID !!!");
                }
            }
        });

        Label label2 = new Label();
        label2.setLayoutX(25.0);
        label2.setLayoutY(75.0);
        label2.setPrefHeight(25.0);
        label2.setPrefWidth(150.0);
        label2.setText("To see food details");
        pane9.getChildren().add(label2);

        Button button2 = new Button();
        button2.setLayoutX(25.0);
        button2.setLayoutY(205.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(25.0);
        button2.setPrefWidth(150.0);
        button2.setId("adminID");
        button2.setText("Add new food");
        pane9.getChildren().add(button2);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddFoodScreen(primaryStage);
            }
        });

        Button button3 = new Button();
        button3.setLayoutX(25.0);
        button3.setLayoutY(245.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(25.0);
        button3.setPrefWidth(150.0);
        button3.setId("adminID");
        button3.setText("Back");
        pane9.getChildren().add(button3);
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        Label label3 = new Label("MENU");
        label3.setLayoutX(25.0);
        label3.setLayoutY(35.0);
        label3.setFont(new Font(20.0));
        pane9.getChildren().add(label3);

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane9.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane9, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCommentsScreen(Stage primaryStage) {
        Pane pane10 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefHeight(250.0);
        listView.setPrefWidth(375.0);
        listView.getItems().addAll(Functions.displayCommentsForAdmin());
        pane10.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25.0);
        textField.setLayoutY(165.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(150.0);
        textField.setPromptText("comment ID");
        pane10.getChildren().add(textField);
        textField.setId("textfield");

        Label label1 = new Label();
        label1.setLayoutX(25.0);
        label1.setLayoutY(140.0);
        label1.setText("to add or edit its response");
        pane10.getChildren().add(label1);

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(25.0);
        noticeLabel.setLayoutY(325.0);
        noticeLabel.setFont(new Font(10.0));
        noticeLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane10.getChildren().add(noticeLabel);

        Button addButton = new Button();
        addButton.setLayoutX(25.0);
        addButton.setLayoutY(205.0);
        addButton.setPrefHeight(20.0);
        addButton.setPrefWidth(150.0);
        addButton.setText("Add new response");
        addButton.setId("adminID");
        pane10.getChildren().add(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textField.getText().equals("")) {
                    String[] answer = Functions.commentIdExistance(textField.getText());
                    if (answer[0].equals("true")) {
                        int commentIndex = Integer.parseInt(answer[1]);
                        Comment comment = restaurant.restaurantCommentsArrayList.get(commentIndex);
                        loadAddResponseScreen(primaryStage, comment);
                    } else {
                        noticeLabel.setText("there is no comments with this id !!!");
                    }
                } else {
                    noticeLabel.setText("please enter order id !!!");
                }
            }
        });

        Label label2 = new Label();
        label2.setLayoutX(25.0);
        label2.setLayoutY(115.0);
        label2.setPrefHeight(25.0);
        label2.setPrefWidth(150.0);
        label2.setText("Please enter comment ID");
        pane10.getChildren().add(label2);

        Button editButton = new Button();
        editButton.setLayoutX(25.0);
        editButton.setLayoutY(245.0);
        editButton.setPrefHeight(25.0);
        editButton.setPrefWidth(150.0);
        editButton.setText("Edit response");
        editButton.setId("adminID");
        pane10.getChildren().add(editButton);
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textField.getText().equals("")) {
                    String[] answer = Functions.commentIdExistance(textField.getText());
                    if (answer[0].equals("true")) {
                        int commentIndex = Integer.parseInt(answer[1]);
                        Comment comment = restaurant.restaurantCommentsArrayList.get(commentIndex);
                        if (comment.commentResponse.equals("")) {
                            loadEditResponseScreen(primaryStage, comment);
                        } else {
                            noticeLabel.setText("there is no response to edit !!!");
                        }
                    } else {
                        noticeLabel.setText("there is no comments with this id !!!");
                    }
                } else {
                    noticeLabel.setText("please enter order id !!!");
                }
            }
        });

        Label label4 = new Label();
        label4.setLayoutX(25.0);
        label4.setLayoutY(80.0);
        label4.setText("COMMENTS");
        label4.setFont(new Font(20.0));
        pane10.getChildren().add(label4);

        Button backButton = new Button();
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(285.0);
        backButton.setPrefWidth(150.0);
        backButton.setText("Back");
        backButton.setId("adminID");
        pane10.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane10.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane10, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOpenOrderScreen(Stage primaryStage, String restaurantID) {
        Pane pane11 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefHeight(250.0);
        listView.setPrefWidth(375.0);
        listView.getItems().addAll(Functions.displayOpenOrders());
        pane11.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25.0);
        textField.setLayoutY(165.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(150.0);
        textField.setPromptText("order ID");
        pane11.getChildren().add(textField);
        textField.setId("textfield");

        Label label1 = new Label();
        label1.setLayoutX(25.0);
        label1.setLayoutY(140.0);
        label1.setText("to edit its details");
        pane11.getChildren().add(label1);

        Label label2 = new Label();
        label2.setLayoutX(25.0);
        label2.setLayoutY(115.0);
        label2.setPrefHeight(25.0);
        label2.setPrefWidth(150.0);
        label2.setText("Please enter order ID");
        pane11.getChildren().add(label2);

        Label labelError = new Label();
        labelError.setLayoutX(25.0);
        labelError.setLayoutY(285.0);
        labelError.setTextFill(Color.RED);
        labelError.setFont(new Font(10));
        pane11.getChildren().add(labelError);

        Button editOrderButton = new Button();
        editOrderButton.setLayoutX(25.0);
        editOrderButton.setLayoutY(205.0);
        editOrderButton.setMnemonicParsing(false);
        editOrderButton.setPrefHeight(25.0);
        editOrderButton.setPrefWidth(150.0);
        editOrderButton.setId("adminID");
        editOrderButton.setText("Edit order");
        pane11.getChildren().add(editOrderButton);
        editOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textField.getText().equals("")) {
                    String orderID = textField.getText();
                    int k = -1;
                    for (int i = 0; i < restaurant.restaurantOrders.size(); i++)
                        if (restaurant.restaurantOrders.get(i).orderID.equals(orderID))
                            k = i;
                    if (k != -1) {
                        Order.LoggedInOrderForAdmin = restaurant.restaurantOrders.get(k);
                        loadEditOrderScreen(primaryStage);
                    } else
                        labelError.setText("there is no order with this id !!!");
                } else {
                    labelError.setText("please enter orderID !!!");
                }
            }
        });

        Label label4 = new Label();
        label4.setLayoutX(25.0);
        label4.setLayoutY(80.0);
        label4.setText("OPEN ORDERS");
        label4.setFont(new Font(20.0));
        pane11.getChildren().add(label4);

        Button backButton = new Button();
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(245.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(150.0);
        backButton.setText("Back");
        backButton.setId("adminID");
        pane11.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane11.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane11, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderHistoryForAdminScreen(Stage primaryStage) {
        Pane pane12 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Label titleLabel = new Label("SHOW ORDER HISTORY");
        titleLabel.setLayoutX(50.0);
        titleLabel.setLayoutY(40.0);
        titleLabel.setFont(new Font(20.0));

        ListView<String> orderListView = new ListView<>();
        orderListView.setLayoutX(50.0);
        orderListView.setLayoutY(80.0);
        orderListView.setPrefHeight(275.0);
        orderListView.getItems().addAll(Functions.showOrderHistory());
        orderListView.setPrefWidth(500.0);

        Button backButton = new Button("Back");
        backButton.setLayoutX(470);
        backButton.setLayoutY(42);
        backButton.setId("adminID");
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        pane12.getChildren().addAll(titleLabel, orderListView, backButton);

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane12.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane12, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadShowFoodtypeScreen(Stage primaryStage) {
        Pane pane13 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Label label = new Label("Foodtype");
        label.setLayoutX(50.0);
        label.setLayoutY(60.0);
        label.setFont(new Font(20.0));

        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(55.0);
        listView.setPrefHeight(200.0);
        listView.getItems().addAll(Functions.showFoodType());
        listView.setPrefWidth(300.0);

        Button backButton = new Button("Back");
        backButton.setLayoutX(50.0);
        backButton.setLayoutY(109.0);
        backButton.setPrefHeight(20.0);
        backButton.setPrefWidth(85.0);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        pane13.getChildren().addAll(label, listView, backButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane13.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane13, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditFoodtypeScreen(Stage primaryStage) {
        Pane pane14 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;

        Label label1 = new Label();
        label1.setLayoutX(50.0);
        label1.setLayoutY(60.0);
        label1.setText("EDIT FOODTYPE");
        label1.setFont(new Font(20.0));
        pane14.getChildren().add(label1);

        Label label2 = new Label();
        label2.setLayoutX(50.0);
        label2.setLayoutY(110.0);
        label2.setText("Enter foodtype you want to add");
        pane14.getChildren().add(label2);

        TextField textField1 = new TextField();
        textField1.setLayoutX(50.0);
        textField1.setLayoutY(140.0);
        textField1.setPrefWidth(200.0);
        textField1.setPromptText("foodtype");
        pane14.getChildren().add(textField1);
        textField1.setId("textfield");

        Separator separator1 = new Separator();
        separator1.setLayoutX(50.0);
        separator1.setLayoutY(220.0);
        separator1.setPrefHeight(5.0);
        separator1.setPrefWidth(200.0);
        pane14.getChildren().add(separator1);

        Label label3 = new Label();
        label3.setLayoutX(50.0);
        label3.setLayoutY(240.0);
        label3.setText("Do you want to delete your foodtypes?");
        pane14.getChildren().add(label3);

        RadioButton radioButton1 = new RadioButton();
        radioButton1.setLayoutX(50.0);
        radioButton1.setLayoutY(270.0);
        radioButton1.setText("Yes");
        pane14.getChildren().add(radioButton1);

        RadioButton radioButton2 = new RadioButton();
        radioButton2.setLayoutX(135.0);
        radioButton2.setLayoutY(270.0);
        radioButton2.setText("No");
        pane14.getChildren().add(radioButton2);

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        Label label4 = new Label();
        label4.setLayoutX(155.0);
        label4.setLayoutY(185.0);
        label4.setTextFill(javafx.scene.paint.Color.RED);
        label4.setFont(new Font(10.0));
        pane14.getChildren().add(label4);

        Label label5 = new Label();
        label5.setLayoutX(50);
        label5.setLayoutY(345);
        label5.setTextFill(javafx.scene.paint.Color.RED);
        label5.setFont(new Font(10.0));
        pane14.getChildren().add(label5);


        Button confirmBtn = new Button();
        confirmBtn.setLayoutX(50.0);
        confirmBtn.setLayoutY(305.0);
        confirmBtn.setPrefWidth(80);
        confirmBtn.setText("Confirm");
        confirmBtn.setId("adminID");
        pane14.getChildren().add(confirmBtn);
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup.getSelectedToggle() != null) {
                    if (toggleGroup.getSelectedToggle() == radioButton1) {
                        int size1 = restaurant.restaurantFoodType.size();
                        if (size1 > 0)
                            restaurant.restaurantFoodType.subList(0, size1).clear();
                        int size2 = restaurant.restaurantMenu.size();
                        if (size2 > 0)
                            restaurant.restaurantMenu.subList(0, size2).clear();
                        label5.setText("Menu and foodtypes deleted successfully !!!");
                    } else
                        label5.setText("Foodtypes didn't deleted !!!");
                } else
                    label5.setText("Select yes/no please !!!");
            }
        });

        Button addBtn = new Button();
        addBtn.setLayoutX(50.0);
        addBtn.setLayoutY(180.0);
        addBtn.setText("Add");
        addBtn.setId("adminID");
        pane14.getChildren().add(addBtn);
        addBtn.setPrefWidth(80);
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textField1.getText().equals("")) {
                    restaurant.restaurantFoodType.add(textField1.getText());
                    label4.setText("Added successfully !!!");
                    textField1.setText("");
                }
                else
                    label4.setText("Enter at least one foodtype !!!");
            }
        });

        Button backBtn = new Button();
        backBtn.setLayoutX(170.0);
        backBtn.setLayoutY(305.0);
        backBtn.setText("Back");
        backBtn.setId("adminID");
        pane14.getChildren().add(backBtn);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane14.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane14, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditLocationForAdminScreen(Stage primaryStage) {
        Pane pane15 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Label titleLabel = new Label("EDIT LOCATION");
        titleLabel.setFont(new Font(20));
        titleLabel.setLayoutX(50);
        titleLabel.setLayoutY(60);
        pane15.getChildren().add(titleLabel);

        Label locationLabel = new Label("Enter the new location");
        locationLabel.setLayoutX(50);
        locationLabel.setLayoutY(110);
        pane15.getChildren().add(locationLabel);

        TextField locationTextField = new TextField();
        locationTextField.setLayoutX(50);
        locationTextField.setLayoutY(140);
        locationTextField.setPrefWidth(200);
        locationTextField.setPrefHeight(25);
        locationTextField.setPromptText("new location");
        pane15.getChildren().add(locationTextField);
        locationTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(50.0);
        notifLabel.setLayoutY(225.0);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane15.getChildren().add(notifLabel);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(50);
        confirmButton.setLayoutY(185);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        pane15.getChildren().add(confirmButton);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!locationTextField.getText().equals("")) {
                    try {
                        int location = Integer.parseInt(locationTextField.getText());
                        if (location < 1000 && location > 0) {
                            restaurant.restaurantLocation = location;
                            notifLabel.setText("New location successfully confirmed !!!");
                        } else {
                            notifLabel.setText("Please enter a number between 0 and 1000 for location !!!");
                        }
                    } catch (Exception e) {
                        notifLabel.setText("Please enter a number for location !!!");
                    }
                } else {
                    notifLabel.setText("Please enter a number for location !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(185);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        pane15.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage, restaurant.restaurantID);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane15.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane15, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddFoodScreen(Stage primaryStage) {
        Pane pane16 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Label label1 = new Label("ADD NEW FOOD");
        label1.setFont(new Font(20));
        label1.setLayoutX(75);
        label1.setLayoutY(60);
        pane16.getChildren().add(label1);

        Label label2 = new Label("In order to add a food to the menu, Please enter food name and food price");
        label2.setLayoutX(75);
        label2.setLayoutY(125);
        pane16.getChildren().add(label2);

        TextField foodNameField = new TextField();
        foodNameField.setLayoutX(75);
        foodNameField.setLayoutY(170);
        foodNameField.setPrefWidth(190);
        foodNameField.setPromptText("food name");
        pane16.getChildren().add(foodNameField);
        foodNameField.setId("textfield");

        TextField foodPriceField = new TextField();
        foodPriceField.setLayoutX(285);
        foodPriceField.setLayoutY(170);
        foodPriceField.setPrefWidth(190);
        foodPriceField.setPromptText("food price");
        pane16.getChildren().add(foodPriceField);
        foodPriceField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(260);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane16.getChildren().add(notifLabel);

        Button addButton = new Button("Add");
        addButton.setLayoutX(75);
        addButton.setLayoutY(220);
        addButton.setPrefWidth(80);
        addButton.setId("adminID");
        pane16.getChildren().add(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!foodNameField.getText().equals("") && !foodPriceField.getText().equals("")) {
                    boolean foodIdExistance = Functions.addFood(foodNameField.getText(), Integer.parseInt(foodPriceField.getText()), staticArrayLists);
                    if (foodIdExistance) {
                        notifLabel.setText("a food with this name exist in the menu !!!");
                    } else {
                        try {
                            int foodPrice = Integer.parseInt(foodPriceField.getText());
                            String foodName = foodNameField.getText();
                            Food food = new Food(foodName, foodPrice);
                            food.foodID = Functions.setID("food", staticArrayLists);
                            restaurant.restaurantMenu.add(food);
                            staticArrayLists.allFoodsArrayList.add(food);
                            notifLabel.setText("Food successfully added to the menu !!!");
                            foodNameField.setText("");
                            foodPriceField.setText("");
                        } catch (Exception e) {
                            notifLabel.setText("Food price must be a number !!!");
                        }
                    }
                } else {
                    notifLabel.setText("Please enter foodname and foodcost correctly !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(185);
        backButton.setLayoutY(220);
        backButton.setPrefWidth(80);
        backButton.setId("adminID");
        pane16.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuScreenForAdmin(primaryStage);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane16.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane16, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadFoodScreen(Stage primaryStage) {
        Pane pane17 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Food food = Food.selectedFoodForAdmin;
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(25.0);
        gridPane.setLayoutY(180.0);
        gridPane.setPrefHeight(100.0);
        gridPane.setPrefWidth(550.0);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column3.setMinWidth(10.0);
        column3.setPrefWidth(100.0);

        RowConstraints row1 = new RowConstraints();
        row1.setMaxHeight(61.59998779296875);
        row1.setMinHeight(10.0);
        row1.setPrefHeight(28.799999999999997);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints row2 = new RowConstraints();
        row2.setMaxHeight(45.60000000000001);
        row2.setMinHeight(0.0);
        row2.setPrefHeight(45.60000000000001);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        pane17.getChildren().add(gridPane);

        Button editBtn = new Button("Edit");
        editBtn.setFont(new Font(15));
        editBtn.setPrefSize(145, 50);
        GridPane.setHalignment(editBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(editBtn, javafx.geometry.VPos.CENTER);
        editBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditFoodScreen(primaryStage);
            }
        });

        Button activeBtn = new Button("Active");
        activeBtn.setFont(new Font(15));
        activeBtn.setPrefSize(145, 50);
        activeBtn.setId("adminID");
        GridPane.setHalignment(activeBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(activeBtn, javafx.geometry.VPos.CENTER);
        activeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadActivateFoodScreen(primaryStage);
            }
        });

        Button discountBtn = new Button("Discount");
        discountBtn.setFont(new Font(15));
        discountBtn.setPrefSize(145, 50);
        discountBtn.setId("adminID");
        GridPane.setHalignment(discountBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(discountBtn, javafx.geometry.VPos.CENTER);
        discountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDiscountScreen(primaryStage);
            }
        });

        Button deactiveBtn = new Button("Deactive");
        deactiveBtn.setFont(new Font(15));
        deactiveBtn.setPrefSize(145, 50);
        deactiveBtn.setId("adminID");
        GridPane.setHalignment(deactiveBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(deactiveBtn, javafx.geometry.VPos.CENTER);
        deactiveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeactivateFoodScreen(primaryStage);
            }
        });

        Button deleteBtn = new Button("Delete");
        deleteBtn.setFont(new Font(15));
        deleteBtn.setPrefSize(145, 50);
        deleteBtn.setId("adminID");
        GridPane.setHalignment(deleteBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(deleteBtn, javafx.geometry.VPos.CENTER);
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeleteFoodScreen(primaryStage);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setFont(new Font(15));
        backBtn.setPrefSize(145, 50);
        backBtn.setId("adminID");
        GridPane.setHalignment(backBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(backBtn, javafx.geometry.VPos.CENTER);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuScreenForAdmin(primaryStage);
            }
        });
        gridPane.getColumnConstraints().addAll(column1, column2, column3);
        gridPane.getRowConstraints().addAll(row1, row2);
        gridPane.add(editBtn, 0, 0);
        gridPane.add(activeBtn, 0, 1);
        gridPane.add(discountBtn, 1, 0);
        gridPane.add(deactiveBtn, 1, 1);
        gridPane.add(deleteBtn, 2, 0);
        gridPane.add(backBtn, 2, 1);

        Separator sep1 = new Separator();
        sep1.setPrefWidth(550);
        Separator sep2 = new Separator();
        sep2.setPrefWidth(550);
        pane17.getChildren().addAll(sep1, sep2);

        Label foodNameLbl = new Label(food.foodName);
        foodNameLbl.setFont(new Font(20));
        Label foodRatingLbl = new Label("Rate : " + Double.toString(food.getRating()));

        ImageView logoImg = new ImageView();

        sep1.setLayoutX(25);
        sep1.setLayoutY(165);

        foodNameLbl.setLayoutX(40);
        foodNameLbl.setLayoutY(50);
        foodRatingLbl.setLayoutX(40);
        foodRatingLbl.setLayoutY(100);

        sep2.setLayoutX(25);
        sep2.setLayoutY(295);

        logoImg.setLayoutX(460);
        logoImg.setLayoutY(50);
        logoImg.setFitWidth(100);
        logoImg.setFitHeight(100);

        Label logoLbl = new Label("LOGO");
        logoLbl.setLayoutX(495);
        logoLbl.setLayoutY(90);

        pane17.getChildren().addAll(foodNameLbl, foodRatingLbl, logoImg, logoLbl);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane17.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane17, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditFoodScreen(Stage primaryStage) {
        Pane pane18 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Food food = Food.selectedFoodForAdmin;
        Label labelEditFood = new Label("Edit Food");
        labelEditFood.setLayoutX(75.0);
        labelEditFood.setLayoutY(60.0);
        labelEditFood.setFont(new Font(20.0));

        Label labelCurrentName = new Label("current name : " + food.foodName);
        labelCurrentName.setLayoutX(75.0);
        labelCurrentName.setLayoutY(175.0);

        Label labelCurrentPrice = new Label("current price : " + food.foodCost);
        labelCurrentPrice.setLayoutX(75.0);
        labelCurrentPrice.setLayoutY(215.0);

        TextField textFieldNewName = new TextField();
        textFieldNewName.setLayoutX(350.0);
        textFieldNewName.setLayoutY(173.0);
        textFieldNewName.setPrefWidth(200.0);
        textFieldNewName.setPromptText("new name");
        textFieldNewName.setId("textfield");

        TextField textFieldNewPrice = new TextField();
        textFieldNewPrice.setLayoutX(350.0);
        textFieldNewPrice.setLayoutY(213.0);
        textFieldNewPrice.setPrefWidth(200.0);
        textFieldNewPrice.setPromptText("new price");
        textFieldNewPrice.setId("textfield");

        Label labelInstruction = new Label("You can enter new name and price on the fields and click confirm to set");
        labelInstruction.setLayoutX(75.0);
        labelInstruction.setLayoutY(125.0);

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(75.0);
        noticeLabel.setLayoutY(270.0);

        Button buttonConfirm = new Button("Confirm");
        buttonConfirm.setLayoutX(350.0);
        buttonConfirm.setLayoutY(270.0);
        buttonConfirm.setPrefSize(80, 20);
        buttonConfirm.setId("adminID");
        buttonConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!textFieldNewName.getText().equals("") && !textFieldNewPrice.getText().equals("")) {
                    try {
                        int foodprice = Integer.parseInt(textFieldNewPrice.getText());
                        String foodname = textFieldNewName.getText();
                        food.foodName = foodname;
                        food.foodCost = foodprice;
                        noticeLabel.setText("food edited succesfully !!!");
                    } catch (Exception e) {
                        noticeLabel.setText("please enter a number as food price !!!");
                    }
                } else {
                    noticeLabel.setText("please enter both fields !!!");
                }
            }
        });


        Button buttonBack = new Button("Back");
        buttonBack.setLayoutX(470.0);
        buttonBack.setLayoutY(270.0);
        buttonBack.setPrefSize(80, 20);
        buttonBack.setId("adminID");
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });

        pane18.getChildren().addAll(labelEditFood, labelCurrentName, labelCurrentPrice, textFieldNewName,
                textFieldNewPrice, labelInstruction, buttonConfirm, buttonBack);

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane18.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane18, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDiscountScreen(Stage primaryStage) {
        Pane pane19 = new Pane();
        Food food = Food.selectedFoodForAdmin;
        Label discountLabel = new Label("Discount");
        discountLabel.setLayoutX(75.0);
        discountLabel.setLayoutY(60.0);
        discountLabel.setFont(new Font(20.0));

        Label questionLabel = new Label("How much discount do you want to set on this food?");
        questionLabel.setLayoutX(75.0);
        questionLabel.setLayoutY(130.0);

        TextField discountTextField = new TextField();
        discountTextField.setLayoutX(75.0);
        discountTextField.setLayoutY(165.0);
        discountTextField.setPrefWidth(200.0);
        discountTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(250);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(210.0);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!discountTextField.getText().equals("")) {
                    try {
                        int discount = Integer.parseInt(discountTextField.getText());
                        food.discountValue = discount;
                        food.discountActivation = true;
                        notifLabel.setText("discount set successfully !!");
                    } catch (Exception e) {
                        notifLabel.setText("please enter a number !!!");
                    }
                } else
                    notifLabel.setText("please enter a number !!!");
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(195.0);
        backButton.setLayoutY(210.0);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });

        pane19.getChildren().addAll(discountLabel, questionLabel, notifLabel, discountTextField, confirmButton, backButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane19.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane19, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDeleteFoodScreen(Stage primaryStage) {
        Pane pane20 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        Food food = Food.selectedFoodForAdmin;
        Label label1 = new Label("Delete");
        label1.setLayoutX(75.0);
        label1.setLayoutY(60.0);
        label1.setFont(new Font(20.0));

        Label label2 = new Label("Do you want to delete this food?");
        label2.setLayoutX(75.0);
        label2.setLayoutY(130.0);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(220);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        RadioButton yesRadioButton = new RadioButton("Yes");
        yesRadioButton.setLayoutX(300.0);
        yesRadioButton.setLayoutY(130.0);

        RadioButton noRadioButton = new RadioButton("No");
        noRadioButton.setLayoutX(351.0);
        noRadioButton.setLayoutY(130.0);

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(toggleGroup);
        noRadioButton.setToggleGroup(toggleGroup);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(175.0);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup.getSelectedToggle() == yesRadioButton) {
                    restaurant.restaurantMenu.remove(food);
                    loadMenuScreenForAdmin(primaryStage);
                } else if (toggleGroup.getSelectedToggle() == noRadioButton)
                    loadFoodScreen(primaryStage);
                else
                    notifLabel.setText("please select yes or no !!!");
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(170.0);
        backButton.setLayoutY(175.0);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });

        pane20.getChildren().addAll(label1, label2, notifLabel, confirmButton, backButton, yesRadioButton, noRadioButton);

        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane20.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane20, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadActivateFoodScreen(Stage primaryStage) {
        Pane pane21 = new Pane();
        Food food = Food.selectedFoodForAdmin;
        Label activeLabel = new Label("Active");
        activeLabel.setLayoutX(75);
        activeLabel.setLayoutY(60);
        activeLabel.setFont(new Font(20));

        Label promptLabel = new Label("Do you want to active this food?");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(130);

        RadioButton yesRadioButton = new RadioButton("Yes");
        yesRadioButton.setLayoutX(300);
        yesRadioButton.setLayoutY(130);
        yesRadioButton.setCache(true);

        RadioButton noRadioButton = new RadioButton("No");
        noRadioButton.setLayoutX(351);
        noRadioButton.setLayoutY(130);

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(toggleGroup);
        noRadioButton.setToggleGroup(toggleGroup);

        Label alreadyActiveLabel = new Label("");
        alreadyActiveLabel.setLayoutX(75);
        alreadyActiveLabel.setLayoutY(230);
        alreadyActiveLabel.setTextFill(javafx.scene.paint.Color.RED);
        alreadyActiveLabel.setFont(new Font(10));

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(175);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup.getSelectedToggle() == yesRadioButton) {
                    if (food.possibilityOfOrdering) {
                        alreadyActiveLabel.setText("food is already active !!!");
                    } else {
                        food.possibilityOfOrdering = true;
                        alreadyActiveLabel.setText("food actived successfully !!!");
                    }
                } else if (toggleGroup.getSelectedToggle() == noRadioButton)
                    loadFoodScreen(primaryStage);
                else
                    alreadyActiveLabel.setText("please select yes or no !!!");

            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(175);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });

        pane21.getChildren().addAll(activeLabel, promptLabel, confirmButton,
                backButton, yesRadioButton, noRadioButton, alreadyActiveLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane21.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane21, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDeactivateFoodScreen(Stage primaryStage) {
        Pane pane22 = new Pane();
        Food food = Food.selectedFoodForAdmin;
        Label deactiveLabel = new Label("Deactive");
        deactiveLabel.setLayoutX(75);
        deactiveLabel.setLayoutY(60);
        deactiveLabel.setFont(new Font(20));

        Label promptLabel = new Label("Do you want to deactive this food?");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(130);

        RadioButton yesRadioButton = new RadioButton("Yes");
        yesRadioButton.setLayoutX(300);
        yesRadioButton.setLayoutY(130);

        RadioButton noRadioButton = new RadioButton("No");
        noRadioButton.setLayoutX(351);
        noRadioButton.setLayoutY(130);

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(toggleGroup);
        noRadioButton.setToggleGroup(toggleGroup);

        Label alreadyDeactiveLabel = new Label("");
        alreadyDeactiveLabel.setLayoutX(75);
        alreadyDeactiveLabel.setLayoutY(230);
        alreadyDeactiveLabel.setTextFill(javafx.scene.paint.Color.RED);
        alreadyDeactiveLabel.setFont(new Font(10));

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(175);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup.getSelectedToggle() == yesRadioButton) {
                    if (!food.possibilityOfOrdering) {
                        alreadyDeactiveLabel.setText("food is already deactive !!!");
                    } else {
                        food.possibilityOfOrdering = false;
                        alreadyDeactiveLabel.setText("food deactived successfully !!!");
                    }
                } else if (toggleGroup.getSelectedToggle() == noRadioButton)
                    loadFoodScreen(primaryStage);
                else
                    alreadyDeactiveLabel.setText("please select yes or no !!!");

            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(175);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });

        pane22.getChildren().addAll(deactiveLabel, promptLabel, confirmButton,
                backButton, yesRadioButton, noRadioButton, alreadyDeactiveLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane22.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane22, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditOrderScreen(Stage primaryStage) {
        Pane pane23 = new Pane();
        Order order = Order.LoggedInOrderForAdmin;
        Label editOrderLabel = new Label("Edit Order");
        editOrderLabel.setLayoutX(75);
        editOrderLabel.setLayoutY(60);
        editOrderLabel.setFont(new Font(20));

        Label currentDeliveryTimeLabel = new Label("Current delivery time : " + order.deliveryTimeRemains);
        currentDeliveryTimeLabel.setLayoutX(75);
        currentDeliveryTimeLabel.setLayoutY(175);

        Label currentOrderStatusLabel = new Label("Current order status : " + order.orderStatus.toString());
        currentOrderStatusLabel.setLayoutX(330);
        currentOrderStatusLabel.setLayoutY(175);

        TextField newDeliveryTimeTextField = new TextField();
        newDeliveryTimeTextField.setLayoutX(75);
        newDeliveryTimeTextField.setLayoutY(215);
        newDeliveryTimeTextField.setPrefWidth(200);
        newDeliveryTimeTextField.setPromptText("new delivery time");
        newDeliveryTimeTextField.setId("textfield");

        Label promptLabel = new Label("You can enter new details for the orders on the fields and click confirm to set");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(125);

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(75);
        noticeLabel.setLayoutY(325);

        RadioButton cookingRadioButton = new RadioButton("COOKING");
        cookingRadioButton.setLayoutX(330);
        cookingRadioButton.setLayoutY(220);

        RadioButton sentRadioButton = new RadioButton("SENT");
        sentRadioButton.setLayoutX(435);
        sentRadioButton.setLayoutY(220);

        RadioButton deliveredRadioButton = new RadioButton("DELIVERED");
        deliveredRadioButton.setLayoutX(330);
        deliveredRadioButton.setLayoutY(250);

        RadioButton readyRadioButton = new RadioButton("READY FOR SENDING");
        readyRadioButton.setLayoutX(435);
        readyRadioButton.setLayoutY(250);

        ToggleGroup toggleGroup = new ToggleGroup();
        cookingRadioButton.setToggleGroup(toggleGroup);
        sentRadioButton.setToggleGroup(toggleGroup);
        deliveredRadioButton.setToggleGroup(toggleGroup);
        readyRadioButton.setToggleGroup(toggleGroup);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(270);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!newDeliveryTimeTextField.getText().equals("") || toggleGroup.getSelectedToggle() == null) {
                    if (!newDeliveryTimeTextField.getText().equals("") && toggleGroup.getSelectedToggle() == null) {
                        long time = Long.parseLong(newDeliveryTimeTextField.getText());
                        order.deliveryTimeRemains = time;
                        currentDeliveryTimeLabel.setText("Current delivery time : " + order.deliveryTimeRemains);
                    } else if (newDeliveryTimeTextField.getText().equals("") && toggleGroup.getSelectedToggle() != null) {
                        if (toggleGroup.getSelectedToggle() == cookingRadioButton)
                            order.orderStatus = STATUS.COOKING;
                        else if (toggleGroup.getSelectedToggle() == sentRadioButton) {
                            order.orderStatus = STATUS.SENT;
                            Restaurant.loggedInRestaurantForAdmin.restaurantOrders.remove(order);
                            Restaurant.loggedInRestaurantForAdmin.restaurantOrdersHistory.add(order);
                            staticArrayLists.OrdersWithoutDeliveryArrayList.add(order);
                        }
                        else if (toggleGroup.getSelectedToggle() == deliveredRadioButton)
                            order.orderStatus = STATUS.DELIVERED;
                        else if (toggleGroup.getSelectedToggle() == readyRadioButton)
                            order.orderStatus = STATUS.READYFORSENDING;
                        currentOrderStatusLabel.setText("Current order status : " + order.orderStatus.toString());
                    } else {
                        long time = Long.parseLong(newDeliveryTimeTextField.getText());
                        order.deliveryTimeRemains = time;

                        if (toggleGroup.getSelectedToggle() == cookingRadioButton)
                            order.orderStatus = STATUS.COOKING;
                        else if (toggleGroup.getSelectedToggle() == sentRadioButton) {
                            order.orderStatus = STATUS.SENT;
                            Restaurant.loggedInRestaurantForAdmin.restaurantOrders.remove(order);
                            Restaurant.loggedInRestaurantForAdmin.restaurantOrdersHistory.add(order);
                            staticArrayLists.OrdersWithoutDeliveryArrayList.add(order);
                        }
                        else if (toggleGroup.getSelectedToggle() == deliveredRadioButton)
                            order.orderStatus = STATUS.DELIVERED;
                        else if (toggleGroup.getSelectedToggle() == readyRadioButton)
                            order.orderStatus = STATUS.READYFORSENDING;

                        currentDeliveryTimeLabel.setText("Current delivery time : " + order.deliveryTimeRemains);
                        currentOrderStatusLabel.setText("Current order status : " + order.orderStatus.toString());
                    }
                } else {
                    noticeLabel.setText("please enter at least one value !!! ");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(195);
        backButton.setLayoutY(270);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOpenOrderScreen(primaryStage, Restaurant.loggedInRestaurantForAdmin.restaurantID);
            }
        });

        pane23.getChildren().addAll(editOrderLabel, currentDeliveryTimeLabel, newDeliveryTimeTextField,
                promptLabel, confirmButton, backButton, cookingRadioButton, sentRadioButton, deliveredRadioButton, readyRadioButton, currentOrderStatusLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane23.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane23, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddResponseScreen(Stage primaryStage, Comment comment) {
        Pane pane24 = new Pane();

        Label addNewResponseLabel = new Label("ADD NEW RESPONSE");
        addNewResponseLabel.setLayoutX(75);
        addNewResponseLabel.setLayoutY(60);
        addNewResponseLabel.setFont(new Font(20));

        Label promptLabel = new Label("Please enter your new response ....");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(125);

        TextField newResponseTextField = new TextField();
        newResponseTextField.setLayoutX(75);
        newResponseTextField.setLayoutY(170);
        newResponseTextField.setPrefWidth(190);
        newResponseTextField.setPromptText("new response");
        newResponseTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(270);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button addButton = new Button("Add");
        addButton.setLayoutX(75);
        addButton.setLayoutY(220);
        addButton.setPrefSize(80, 20);
        addButton.setId("adminID");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!newResponseTextField.getText().equals("")) {
                    if (comment.commentResponse.equals("")) {
                        comment.commentResponse = newResponseTextField.getText();
                        notifLabel.setText("you responsed to this comment successfully !!!");
                    } else {
                        notifLabel.setText("you have responsed this comment before , now you can edit it !!!");
                    }
                } else {
                    notifLabel.setText("please enter your response !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(185);
        backButton.setLayoutY(220);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsScreen(primaryStage);
            }
        });

        pane24.getChildren().addAll(addNewResponseLabel, promptLabel, notifLabel, newResponseTextField, addButton, backButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane24.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane24, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditResponseScreen(Stage primaryStage, Comment comment) {
        Pane pane25 = new Pane();

        Label editResponseLabel = new Label("Edit Response");
        editResponseLabel.setLayoutX(75);
        editResponseLabel.setLayoutY(60);
        editResponseLabel.setFont(new Font(20));

        Label currentResponseLabel = new Label("current response : " + comment.commentResponse);
        currentResponseLabel.setLayoutX(75);
        currentResponseLabel.setLayoutY(175);

        TextField newResponseTextField = new TextField();
        newResponseTextField.setLayoutX(75);
        newResponseTextField.setLayoutY(215);
        newResponseTextField.setPrefWidth(200);
        newResponseTextField.setPromptText("new response");
        newResponseTextField.setId("textfield");

        Label promptLabel = new Label("You can enter new response on the fields and click confirm to set");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(125);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(270);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("adminID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comment.commentResponse = newResponseTextField.getText();
                currentResponseLabel.setText("response changed to : " + newResponseTextField.getText());
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(195);
        backButton.setLayoutY(270);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsScreen(primaryStage);
            }
        });

        pane25.getChildren().addAll(editResponseLabel, currentResponseLabel, newResponseTextField,
                promptLabel, confirmButton, backButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane25.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane25, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddRestaurantScreen(Stage primaryStage) {
        Pane pane26 = new Pane();
        Admin admin = (Admin) Role.loggedInRole;
        Label titleLabel = new Label("ADD NEW RESTAURANT");
        titleLabel.setLayoutX(75.0);
        titleLabel.setLayoutY(60.0);
        titleLabel.setFont(new Font(20.0));

        Label infoLabel = new Label("In order to add a restaurant to your panel, please enter restaurant name");
        infoLabel.setLayoutX(75.0);
        infoLabel.setLayoutY(125.0);

        TextField restaurantNameField = new TextField();
        restaurantNameField.setLayoutX(75.0);
        restaurantNameField.setLayoutY(170.0);
        restaurantNameField.setPrefWidth(190.0);
        restaurantNameField.setPromptText("restaurant name");
        restaurantNameField.setId("textfield");

        Label infoLabel2 = new Label("Please enter restaurant food type");
        infoLabel2.setLayoutX(75.0);
        infoLabel2.setLayoutY(215.0);

        TextField restaurantFoodTypeField = new TextField();
        restaurantFoodTypeField.setLayoutX(75.0);
        restaurantFoodTypeField.setLayoutY(260.0);
        restaurantFoodTypeField.setPrefWidth(190.0);
        restaurantFoodTypeField.setPromptText("restaurant foodtype");
        restaurantFoodTypeField.setId("textfield");

        Label successLabel = new Label();
        successLabel.setLayoutX(75.0);
        successLabel.setLayoutY(360.0);
        successLabel.setTextFill(javafx.scene.paint.Color.RED);
        successLabel.setFont(new Font(10.0));

        Button addButton = new Button("Add");
        addButton.setLayoutX(75.0);
        addButton.setLayoutY(310.0);
        addButton.setPrefSize(80, 20);
        addButton.setId("adminID");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!restaurantFoodTypeField.getText().equals("") && !restaurantNameField.getText().equals("")) {
                    Admin admin = (Admin) Role.loggedInRole;
                    String foodtype = restaurantFoodTypeField.getText();
                    String restaurantName = restaurantNameField.getText();
                    boolean restaurantExistance = false;
                    for (int i = 0; i < admin.adminRestaurants.size(); i++)
                        if (admin.adminRestaurants.get(i).restaurantName.equals(restaurantName))
                            restaurantExistance = true;
                    if (restaurantExistance)
                        successLabel.setText("You have another restaurant with this name !!!");
                    else {
                        Restaurant restaurant = new Restaurant(restaurantName);
                        restaurant.restaurantOwner = admin;
                        restaurant.restaurantLocation = Functions.setRandomLocation(staticArrayLists);
                        restaurant.restaurantFoodType.add(foodtype);
                        restaurant.restaurantID = Functions.setID("restaurant", staticArrayLists);
                        admin.adminRestaurants.add(restaurant);
                        staticArrayLists.allRestaurantsArrayList.add(restaurant);
                        successLabel.setText("Restaurant added to the panel successfully !!!");
                    }
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(185.0);
        backButton.setLayoutY(310.0);
        backButton.setPrefSize(80, 20);
        backButton.setId("adminID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAdminPanelScreen(primaryStage, admin.adminID);
            }
        });

        pane26.getChildren().addAll(titleLabel, infoLabel, infoLabel2, restaurantFoodTypeField, restaurantNameField, addButton, backButton, successLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("admin.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane26.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane26, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRestaurantListForUserScreen(Stage primaryStage) {
        Pane pane27 = new Pane();
        User user = (User) Role.loggedInRole;
        ListView<String> restaurantsListView = new ListView<>();
        restaurantsListView.setLayoutX(200.0);
        restaurantsListView.setLayoutY(75.0);
        restaurantsListView.setPrefWidth(375.0);
        restaurantsListView.setPrefHeight(250.0);
        restaurantsListView.getItems().addAll(Functions.showAllAvailableRestaurants(staticArrayLists,"Normal"));

        TextField restaurantIdField = new TextField();
        restaurantIdField.setLayoutX(25.0);
        restaurantIdField.setLayoutY(125.0);
        restaurantIdField.setPrefWidth(150.0);
        restaurantIdField.setPrefHeight(25.0);
        restaurantIdField.setPromptText("restaurant ID");
        restaurantIdField.setId("textfield");

        TextField restaurantNameField = new TextField();
        restaurantNameField.setLayoutX(25.0);
        restaurantNameField.setLayoutY(235.0);
        restaurantNameField.setPromptText("restaurant name");
        restaurantNameField.setId("textfield");

        Label restaurantIdLabel = new Label("please enter restaurant ID");
        restaurantIdLabel.setLayoutX(25.0);
        restaurantIdLabel.setLayoutY(100.0);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(25);
        errorLabel.setLayoutY(340);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font(10));

        Button selectButton = new Button("Select");
        selectButton.setLayoutX(25.0);
        selectButton.setLayoutY(155.0);
        selectButton.setPrefWidth(150.0);
        selectButton.setPrefHeight(20.0);
        selectButton.setId("userID");
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!restaurantIdField.getText().equals("")) {
                    int k = Functions.selectRestaurant(restaurantIdField.getText(), staticArrayLists);
                    if (k != -1) {
                        Restaurant.loggedInRestaurantForUser = staticArrayLists.allRestaurantsArrayList.get(k);
                        loadRestaurantForUserScreen(primaryStage);
                    } else
                        errorLabel.setText("Restaurant not found !!!");
                } else
                    errorLabel.setText("Enter an ID !!!");
            }
        });

        Button searchButton = new Button("Search");
        searchButton.setLayoutX(25.0);
        searchButton.setLayoutY(268.0);
        searchButton.setPrefWidth(150.0);
        searchButton.setPrefHeight(25.0);
        searchButton.setId("userID");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                restaurantsListView.getItems().clear();
                restaurantsListView.getItems().addAll(Functions.showRelatedRestaurants(restaurantNameField.getText(),staticArrayLists));
            }
        });


        Button suggestButton = new Button("Show suggested restaurant");
        suggestButton.setLayoutX(25.0);
        suggestButton.setLayoutY(185.0);
        suggestButton.setPrefWidth(150.0);
        suggestButton.setPrefHeight(25.0);
        suggestButton.setId("userID");
        suggestButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                restaurantsListView.getItems().clear();
                restaurantsListView.getItems().addAll(Functions.showAllAvailableRestaurants(staticArrayLists,"Suggested"));
            }
        });


        Label restaurantListLabel = new Label("To see the restaurants");
        restaurantListLabel.setLayoutX(25.0);
        restaurantListLabel.setLayoutY(75.0);
        restaurantListLabel.setPrefWidth(150.0);
        restaurantListLabel.setPrefHeight(25.0);

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(300.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage, user.userID);
            }
        });

        Separator separator = new Separator();
        separator.setLayoutX(25.0);
        separator.setLayoutY(223.0);
        separator.setPrefWidth(150.0);

        pane27.getChildren().addAll(restaurantsListView, restaurantIdField, restaurantIdLabel, selectButton,
                restaurantListLabel, suggestButton, backButton, restaurantNameField,
                separator, searchButton, errorLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane27.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane27, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadUserPanelScreen(Stage primaryStage, String userID) {
        Pane pane28 = new Pane();
        User user = (User) Role.loggedInRole;
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(45.0);
        gridPane.setLayoutY(180.0);
        gridPane.setPrefWidth(510.0);
        gridPane.setPrefHeight(100.0);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column3.setMinWidth(10.0);
        column3.setPrefWidth(100.0);

        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        RowConstraints row1 = new RowConstraints();
        row1.setMaxHeight(61.59998779296875);
        row1.setMinHeight(10.0);
        row1.setPrefHeight(28.799999999999997);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints row2 = new RowConstraints();
        row2.setMaxHeight(45.60000000000001);
        row2.setMinHeight(0.0);
        row2.setPrefHeight(45.60000000000001);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        gridPane.getRowConstraints().addAll(row1, row2);

        Button restaurantListButton = new Button("Restaurant List");
        restaurantListButton.setMnemonicParsing(false);
        restaurantListButton.setPrefHeight(50.0);
        restaurantListButton.setPrefWidth(145.0);
        restaurantListButton.setId("userID");
        GridPane.setHalignment(restaurantListButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(restaurantListButton, javafx.geometry.VPos.CENTER);
        restaurantListButton.setFont(new Font(15.0));
        restaurantListButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantListForUserScreen(primaryStage);
            }
        });

        Button cartStatusButton = new Button("Cart status");
        cartStatusButton.setMnemonicParsing(false);
        cartStatusButton.setPrefHeight(50.0);
        cartStatusButton.setPrefWidth(145.0);
        cartStatusButton.setId("userID");
        GridPane.setHalignment(cartStatusButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(cartStatusButton, 1);
        GridPane.setValignment(cartStatusButton, javafx.geometry.VPos.CENTER);
        cartStatusButton.setFont(new Font(15.0));
        cartStatusButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCartStatusScreen(primaryStage);
            }
        });

        Button orderHistoryButton = new Button("Order history");
        orderHistoryButton.setMnemonicParsing(false);
        orderHistoryButton.setPrefHeight(50.0);
        orderHistoryButton.setPrefWidth(145.0);
        orderHistoryButton.setId("userID");
        GridPane.setColumnIndex(orderHistoryButton, 1);
        GridPane.setHalignment(orderHistoryButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(orderHistoryButton, javafx.geometry.VPos.CENTER);
        orderHistoryButton.setFont(new Font(15.0));
        orderHistoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderHistoryForUserScreen(primaryStage);
            }
        });

        Button chargeAccountButton = new Button("Charge account");
        chargeAccountButton.setMnemonicParsing(false);
        chargeAccountButton.setPrefHeight(50.0);
        chargeAccountButton.setPrefWidth(145.0);
        chargeAccountButton.setId("userID");
        GridPane.setColumnIndex(chargeAccountButton, 1);
        GridPane.setHalignment(chargeAccountButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(chargeAccountButton, 1);
        GridPane.setValignment(chargeAccountButton, javafx.geometry.VPos.CENTER);
        chargeAccountButton.setFont(new Font(15.0));
        chargeAccountButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadChargeAccountScreen(primaryStage);
            }
        });

        Button editLocationButton = new Button("Edit location");
        editLocationButton.setMnemonicParsing(false);
        editLocationButton.setPrefHeight(50.0);
        editLocationButton.setPrefWidth(145.0);
        editLocationButton.setId("userID");
        GridPane.setColumnIndex(editLocationButton, 2);
        GridPane.setHalignment(editLocationButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(editLocationButton, javafx.geometry.VPos.CENTER);
        editLocationButton.setFont(new Font(15.0));
        editLocationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditLocationForUserScreen(primaryStage);
            }
        });

        Button logoutButton = new Button("LOGOUT");
        logoutButton.setMnemonicParsing(false);
        logoutButton.setPrefHeight(50.0);
        logoutButton.setPrefWidth(145.0);
        logoutButton.setId("userID");
        GridPane.setColumnIndex(logoutButton, 2);
        GridPane.setHalignment(logoutButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(logoutButton, 1);
        GridPane.setValignment(logoutButton, javafx.geometry.VPos.CENTER);
        logoutButton.setFont(new Font(15.0));
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Role.loggedInRole = null;
                Role.loggedInRoleExistance = false;
                loadLoginScreen(primaryStage);
            }
        });

        gridPane.getChildren().addAll(restaurantListButton, cartStatusButton, orderHistoryButton,
                chargeAccountButton, editLocationButton, logoutButton);

        Separator separator1 = new Separator();
        separator1.setLayoutX(25.0);
        separator1.setLayoutY(160.0);
        separator1.setPrefWidth(550.0);
        separator1.setPrefHeight(10.0);

        Label userPanelLabel = new Label("Welcome " + user.getUserName());
        userPanelLabel.setLayoutX(40.0);
        userPanelLabel.setLayoutY(50.0);
        userPanelLabel.setFont(new Font(20.0));

        Label userChargeLabel = new Label("charge : " + user.getAccountCharge() + "$");
        userChargeLabel.setLayoutX(40.0);
        userChargeLabel.setLayoutY(100.0);
        userChargeLabel.setPrefWidth(111.0);

        Separator separator2 = new Separator();
        separator2.setLayoutX(25.0);
        separator2.setLayoutY(290.0);
        separator2.setPrefWidth(550.0);
        separator2.setPrefHeight(10.0);

        ImageView logoImage = new ImageView();
        logoImage.setLayoutX(460.0);
        logoImage.setLayoutY(50.0);
        logoImage.setFitWidth(100.0);
        logoImage.setFitHeight(100.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);

        Label logoLabel = new Label("LOGO");
        logoLabel.setLayoutX(495.0);
        logoLabel.setLayoutY(90.0);

        Label userLocationLabel = new Label("location : " + user.userLocation);
        userLocationLabel.setLayoutX(228.0);
        userLocationLabel.setLayoutY(100.0);
        userLocationLabel.setPrefWidth(145.0);

        Label setLocationLabel = new Label();
        setLocationLabel.setLayoutX(40.0);
        setLocationLabel.setLayoutY(130.0);
        setLocationLabel.setPrefWidth(300.0);
        setLocationLabel.setTextFill(javafx.scene.paint.Color.RED);
        setLocationLabel.setFont(new Font(10.0));

        pane28.getChildren().addAll(gridPane, separator1, userPanelLabel, userChargeLabel, separator2,
                logoImage, logoLabel, userLocationLabel, setLocationLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane28.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane28, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderHistoryForUserScreen(Stage primaryStage) {
        Pane pane29 = new Pane();
        User user = (User) Role.loggedInRole;
        ListView<String> orderListView = new ListView<>();
        orderListView.setLayoutX(200.0);
        orderListView.setLayoutY(75.0);
        orderListView.setPrefWidth(375.0);
        orderListView.setPrefHeight(250.0);
        orderListView.getItems().addAll(Functions.showOrderHistoryForUser());

        TextField orderTextField = new TextField();
        orderTextField.setLayoutX(25.0);
        orderTextField.setLayoutY(125.0);
        orderTextField.setPrefWidth(150.0);
        orderTextField.setPrefHeight(25.0);
        orderTextField.setPromptText("order ID");
        orderTextField.setId("textfield");

        Label orderLabel = new Label("please enter order ID");
        orderLabel.setLayoutX(25.0);
        orderLabel.setLayoutY(100.0);

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(25.0);
        noticeLabel.setLayoutY(235.0);
        noticeLabel.setTextFill(Color.RED);
        noticeLabel.setFont(new Font(10));

        Button selectButton = new Button("Select");
        selectButton.setLayoutX(25.0);
        selectButton.setLayoutY(165.0);
        selectButton.setMnemonicParsing(false);
        selectButton.setPrefWidth(150.0);
        selectButton.setPrefHeight(20.0);
        selectButton.setId("userID");
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!orderTextField.getText().equals("")) {
                    String[] answer = Functions.orderIdExistanceChecker(orderTextField.getText());
                    if (answer[0].equals("true")) {
                        Order order = user.userOrders.get(Integer.parseInt(answer[1]));
                        loadOrderDetailsForUserScreen(primaryStage, order);
                    } else {
                        noticeLabel.setText("order Id does not exist !!!");
                    }
                } else {
                    noticeLabel.setText("Please enter orderID !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(201.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage, user.userID);
            }
        });

        Label orderHistoryLabel = new Label("Order History");
        orderHistoryLabel.setLayoutX(25.0);
        orderHistoryLabel.setLayoutY(31.0);
        orderHistoryLabel.setFont(new Font(20.0));

        pane29.getChildren().addAll(orderListView, orderTextField, orderLabel, selectButton,
                backButton, orderHistoryLabel, noticeLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane29.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane29, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderDetailsForUserScreen(Stage primaryStage, Order order) {
        Pane pane30 = new Pane();

        Label orderDetailsLabel = new Label("Order Details");
        orderDetailsLabel.setFont(new Font(20.0));
        orderDetailsLabel.setLayoutX(50.0);
        orderDetailsLabel.setLayoutY(40.0);

        ListView<String> orderDetailsListView = new ListView<>();
        orderDetailsListView.setLayoutX(50.0);
        orderDetailsListView.setLayoutY(80.0);
        orderDetailsListView.setPrefWidth(500.0);
        orderDetailsListView.setPrefHeight(275.0);
        orderDetailsListView.getItems().addAll(Functions.orderDetailsList(order));

        Button showPathButton = new Button("Show Path");
        showPathButton.setLayoutX(290.0);
        showPathButton.setLayoutY(42.0);
        showPathButton.setMnemonicParsing(false);
        showPathButton.setPrefWidth(80.0);
        showPathButton.setId("userID");

        Button showTimeButton = new Button("Show estimated delivery time");
        showTimeButton.setLayoutX(380.0);
        showTimeButton.setLayoutY(42.0);
        showTimeButton.setMnemonicParsing(false);
        showTimeButton.setPrefWidth(80.0);
        showTimeButton.setId("userID");

        Button backButton = new Button("Back");
        backButton.setLayoutX(470.0);
        backButton.setLayoutY(42.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(80.0);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderHistoryForUserScreen(primaryStage);
            }
        });

        pane30.getChildren().addAll(orderDetailsLabel, orderDetailsListView, backButton, showPathButton, showTimeButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane30.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane30, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditLocationForUserScreen(Stage primaryStage) {
        Pane pane31 = new Pane();
        User user = (User) Role.loggedInRole;
        Label titleLabel = new Label("EDIT LOCATION");
        titleLabel.setFont(new Font(20));
        titleLabel.setLayoutX(50);
        titleLabel.setLayoutY(60);
        pane31.getChildren().add(titleLabel);

        Label locationLabel = new Label("Enter the new location");
        locationLabel.setLayoutX(50);
        locationLabel.setLayoutY(110);
        pane31.getChildren().add(locationLabel);

        TextField locationTextField = new TextField();
        locationTextField.setLayoutX(50);
        locationTextField.setLayoutY(140);
        locationTextField.setPrefWidth(200);
        locationTextField.setPrefHeight(25);
        locationTextField.setPromptText("new location");
        pane31.getChildren().add(locationTextField);
        locationTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(50.0);
        notifLabel.setLayoutY(225.0);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane31.getChildren().add(notifLabel);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(50);
        confirmButton.setLayoutY(185);
        confirmButton.setId("userID");
        confirmButton.setPrefSize(80, 20);
        pane31.getChildren().add(confirmButton);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!locationTextField.getText().equals("")) {
                    try {
                        int location = Integer.parseInt(locationTextField.getText());
                        if (location > 0 && location < 1000) {
                            user.userLocation = location;
                            notifLabel.setText("New location successfully confirmed !!!");
                        } else {
                            notifLabel.setText("location must be a number between 0 and 1000 !!!");
                        }
                    } catch (Exception exception) {
                        notifLabel.setText("please enter a number !!!");
                    }
                } else {
                    notifLabel.setText("please enter a number !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(185);
        backButton.setPrefSize(80, 20);
        backButton.setId("userID");
        pane31.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage, user.userID);
            }
        });
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane31.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane31, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadChargeAccountScreen(Stage primaryStage) {
        Pane pane32 = new Pane();
        User user = (User) Role.loggedInRole;
        Label discountLabel = new Label("Charge Account");
        discountLabel.setLayoutX(75.0);
        discountLabel.setLayoutY(60.0);
        discountLabel.setFont(new Font(20.0));

        Label questionLabel = new Label("How much do you want to charge your account?");
        questionLabel.setLayoutX(75.0);
        questionLabel.setLayoutY(130.0);

        TextField discountTextField = new TextField();
        discountTextField.setLayoutX(75.0);
        discountTextField.setLayoutY(165.0);
        discountTextField.setPrefWidth(200.0);
        discountTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(250);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(210.0);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("userID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!discountTextField.getText().equals("")) {
                    try {
                        double value = Double.parseDouble(discountTextField.getText());
                        user.setAccountCharge(user.getAccountCharge() + value);
                        notifLabel.setText("Account charged successfully !!!");
                    } catch (Exception exception) {
                        notifLabel.setText("Please enter a number !!!");
                    }
                } else {
                    notifLabel.setText("Please enter a number !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(195.0);
        backButton.setLayoutY(210.0);
        backButton.setPrefSize(80, 20);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage, user.userID);
            }
        });

        pane32.getChildren().addAll(discountLabel, questionLabel, notifLabel, discountTextField, confirmButton, backButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane32.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane32, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCartStatusScreen(Stage primaryStage) {
        Pane pane33 = new Pane();
        User user = (User) Role.loggedInRole;
        Label userCartLabel = new Label("User Cart");
        userCartLabel.setLayoutX(25.0);
        userCartLabel.setLayoutY(35.0);
        userCartLabel.setFont(new Font(20.0));

        ListView<String> orderListView = new ListView<>();
        orderListView.setLayoutX(200.0);
        orderListView.setLayoutY(75.0);
        orderListView.setPrefWidth(375.0);
        orderListView.setPrefHeight(250.0);
        orderListView.getItems().addAll(Functions.showCartStatus((User) Role.loggedInRole));

        Label orderIdLabel = new Label("please enter order ID");
        orderIdLabel.setLayoutX(25.0);
        orderIdLabel.setLayoutY(100.0);

        TextField orderIdTextField = new TextField();
        orderIdTextField.setLayoutX(25.0);
        orderIdTextField.setLayoutY(130.0);
        orderIdTextField.setPrefWidth(150.0);
        orderIdTextField.setPrefHeight(25.0);
        orderIdTextField.setPromptText("order ID");
        orderIdTextField.setId("textfield");

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(25.0);
        noticeLabel.setLayoutY(270.0);
        noticeLabel.setPrefWidth(150.0);
        noticeLabel.setPrefHeight(25.0);
        noticeLabel.setFont(new Font(10));
        noticeLabel.setTextFill(Color.RED);

        Button editButton = new Button("Edit");
        editButton.setLayoutX(25.0);
        editButton.setLayoutY(165.0);
        editButton.setPrefWidth(150.0);
        editButton.setPrefHeight(20.0);
        editButton.setMnemonicParsing(false);
        editButton.setId("userID");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = -1;
                for (int i = 0; i < ((User) Role.loggedInRole).userCart.cartorders.size(); i++)
                    if (((User) Role.loggedInRole).userCart.cartorders.get(i).orderID.equals(orderIdTextField.getText()))
                        k = i;
                if(k == -1)
                    noticeLabel.setText("Order not found !!!");
                else
                    loadOrderDetailsInCartForUserScreen(primaryStage,((User)Role.loggedInRole).userCart.cartorders.get(k));
            }
        });

        Label toSeeOrdersLabel = new Label("To see your orders");
        toSeeOrdersLabel.setLayoutX(25.0);
        toSeeOrdersLabel.setLayoutY(75.0);
        toSeeOrdersLabel.setPrefWidth(150.0);
        toSeeOrdersLabel.setPrefHeight(25.0);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(25.0);
        confirmButton.setLayoutY(200.0);
        confirmButton.setPrefWidth(150.0);
        confirmButton.setPrefHeight(25.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setId("userID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.confirmOrder(user,orderIdTextField.getText());
                if (k == -1)
                    noticeLabel.setText("Order not found !!!");
                else if (k != -1 && user.userCart.cartorders.get(k).getOrderCost() > user.getAccountCharge())
                    noticeLabel.setText("Please charge your account !!!");
                else {
                    user.setAccountCharge(user.getAccountCharge() - user.userCart.cartorders.get(k).getOrderCost()) ;
                    user.userCart.cartorders.get(k).orderedRestaurant.restaurantOrders.add(user.userCart.cartorders.get(k)) ;
                    user.userCart.cartorders.get(k).orderStatus = STATUS.COOKING ;
                    user.userOrders.add(user.userCart.cartorders.get(k));
                    user.userCart.cartorders.remove(k) ;
                    orderListView.getItems().addAll(Functions.showCartStatus((User) Role.loggedInRole));
                    noticeLabel.setText("Order successfully confirmed !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(235.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setMnemonicParsing(false);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage, user.userID);
            }
        });

        pane33.getChildren().addAll(userCartLabel, orderListView, orderIdLabel, orderIdTextField, editButton, toSeeOrdersLabel, confirmButton, backButton, noticeLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane33.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane33, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderDetailsInCartForUserScreen(Stage primaryStage,Order order) {
        Pane pane34 = new Pane();

        Label orderLabel = new Label("Order");
        orderLabel.setLayoutX(35.0);
        orderLabel.setLayoutY(60.0);
        orderLabel.setFont(new Font(20.0));

        Label orderedRestaurantLabel = new Label("orderedRestaurant: " + order.orderedRestaurant.restaurantName);
        orderedRestaurantLabel.setLayoutX(200.0);
        orderedRestaurantLabel.setLayoutY(65.0);

        ListView<String> orderDetailsListView = new ListView<>();
        orderDetailsListView.setLayoutX(200.0);
        orderDetailsListView.setLayoutY(110.0);
        orderDetailsListView.setPrefWidth(375.0);
        orderDetailsListView.setPrefHeight(200.0);
        orderDetailsListView.getItems().addAll(Functions.showOrderDetailsForUser(order));

        Label orderIdLabel = new Label("please enter order ID");
        orderIdLabel.setLayoutX(25.0);
        orderIdLabel.setLayoutY(130.0);

        TextField foodIdTextField = new TextField();
        foodIdTextField.setLayoutX(25.0);
        foodIdTextField.setLayoutY(160.0);
        foodIdTextField.setPrefWidth(150.0);
        foodIdTextField.setPrefHeight(25.0);
        foodIdTextField.setPromptText("food ID");
        foodIdTextField.setId("textfield");

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(25);
        noticeLabel.setLayoutY(300);
        noticeLabel.setFont(new Font(10));
        noticeLabel.setTextFill(Color.RED);

        Button editButton = new Button("Edit number of this food");
        editButton.setLayoutX(25.0);
        editButton.setLayoutY(195.0);
        editButton.setPrefWidth(150.0);
        editButton.setPrefHeight(20.0);
        editButton.setMnemonicParsing(false);
        editButton.setId("userID");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = -1;
                for (int i = 0; i < order.orderFoods.size(); i++)
                    if (order.orderFoods.get(i).foodID.equals(foodIdTextField.getText()))
                        k = i;
                if (k == -1)
                    noticeLabel.setText("Food not found");
                else
                    loadEditNumberScreen(primaryStage, order, order.orderFoods.get(k));
            }
        });

        Label toSeeOrdersLabel = new Label("To see your orders");
        toSeeOrdersLabel.setLayoutX(25.0);
        toSeeOrdersLabel.setLayoutY(105.0);
        toSeeOrdersLabel.setPrefWidth(150.0);
        toSeeOrdersLabel.setPrefHeight(25.0);

        Button deleteButton = new Button("Delete this food");
        deleteButton.setLayoutX(25.0);
        deleteButton.setLayoutY(230.0);
        deleteButton.setPrefWidth(150.0);
        deleteButton.setPrefHeight(25.0);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setId("userID");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = -1;
                for (int i = 0; i < order.orderFoods.size(); i++)
                    if (order.orderFoods.get(i).foodID.equals(foodIdTextField.getText()))
                        k = i;
                if (k == -1)
                    noticeLabel.setText("Food not found");
                else {
                    noticeLabel.setText("Food successfully deleted !!!");
                    order.orderFoods.remove(k);
                    orderDetailsListView.getItems().addAll(Functions.showOrderDetailsForUser(order));
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(265.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setMnemonicParsing(false);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCartStatusScreen(primaryStage);
            }
        });

        Label totalCostLabel = new Label("Total cost: " + order.getOrderCost() + "$");
        totalCostLabel.setLayoutX(200.0);
        totalCostLabel.setLayoutY(335.0);

        pane34.getChildren().addAll(orderLabel, noticeLabel, orderedRestaurantLabel, orderDetailsListView, orderIdLabel, foodIdTextField, editButton, toSeeOrdersLabel, deleteButton, backButton, totalCostLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane34.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane34, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditNumberScreen(Stage primaryStage,Order order, Food food) {
        Pane pane35 = new Pane();

        Label numberOfFoodLabel = new Label("Number of Food");
        numberOfFoodLabel.setLayoutX(75.0);
        numberOfFoodLabel.setLayoutY(60.0);
        numberOfFoodLabel.setFont(new Font(20.0));

        Label howManyLabel = new Label("How many do you want ?");
        howManyLabel.setLayoutX(75.0);
        howManyLabel.setLayoutY(130.0);

        Integer[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ChoiceBox<Integer> choiceBox = new ChoiceBox<Integer>(FXCollections.observableArrayList(num));
        choiceBox.setLayoutX(240.0);
        choiceBox.setLayoutY(126.0);
        choiceBox.setPrefWidth(150.0);

        Label noticeLabel = new Label();
        noticeLabel.setLayoutX(75);
        noticeLabel.setLayoutY(215);
        noticeLabel.setFont(new Font(10));
        noticeLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(170.0);
        confirmButton.setPrefWidth(80.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setId("userID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                food.number = choiceBox.getValue();
                noticeLabel.setText("Successfully confirmed !!!");
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(310.0);
        backButton.setLayoutY(170.0);
        backButton.setPrefWidth(80.0);
        backButton.setMnemonicParsing(false);
        backButton.setId("userID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderDetailsInCartForUserScreen(primaryStage, order);
            }
        });

        pane35.getChildren().addAll(numberOfFoodLabel, howManyLabel, noticeLabel, choiceBox, confirmButton, backButton);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane35.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane35, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDeliveryPanelScreen(Stage primaryStage, String deliverID) {
        Pane pane36 = new Pane();
        Delivery delivery = (Delivery) Role.loggedInRole;
        Label deliveryPanelLabel = new Label("Delivery Panel");
        deliveryPanelLabel.setLayoutX(40.0);
        deliveryPanelLabel.setLayoutY(50.0);
        deliveryPanelLabel.setFont(new Font(20.0));

        Separator separator1 = new Separator();
        separator1.setLayoutX(25.0);
        separator1.setLayoutY(150.0);
        separator1.setPrefWidth(550.0);
        separator1.setPrefHeight(10.0);

        Label deliveryLocationLabel = new Label("Delivery location: " + delivery.deliveryLocation);
        deliveryLocationLabel.setLayoutX(40.0);
        deliveryLocationLabel.setLayoutY(100.0);
        deliveryLocationLabel.setPrefWidth(145.0);
        deliveryLocationLabel.setPrefHeight(20.0);

        ImageView imageView = new ImageView();
        imageView.setLayoutX(460.0);
        imageView.setLayoutY(50.0);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);

        Label logoLabel = new Label("LOGO");
        logoLabel.setLayoutX(495.0);
        logoLabel.setLayoutY(90.0);

        Separator separator2 = new Separator();
        separator2.setLayoutX(25.0);
        separator2.setLayoutY(235.0);
        separator2.setPrefWidth(550.0);
        separator2.setPrefHeight(10.0);

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(45.0);
        gridPane.setLayoutY(180.0);
        gridPane.setPrefWidth(510.0);
        gridPane.setPrefHeight(58.0);

        ColumnConstraints col1 = new ColumnConstraints(128.0);
        ColumnConstraints col2 = new ColumnConstraints(128.0);
        ColumnConstraints col3 = new ColumnConstraints(128.0);
        ColumnConstraints col4 = new ColumnConstraints(128.0);
        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(28.8);
        gridPane.getRowConstraints().add(row1);

        Button showOrdersOrEndingDeliveryButton = new Button();
        showOrdersOrEndingDeliveryButton.setPrefWidth(145.0);
        showOrdersOrEndingDeliveryButton.setPrefHeight(50.0);
        showOrdersOrEndingDeliveryButton.setFont(new Font(15.0));
        showOrdersOrEndingDeliveryButton.setId("deliveryID");
        GridPane.setConstraints(showOrdersOrEndingDeliveryButton, 0, 0);

        if (delivery.activeOrderBoolean) {
            showOrdersOrEndingDeliveryButton.setText("End delivering");
            showOrdersOrEndingDeliveryButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    delivery.activeOrderBoolean = false;
                    delivery.deliveryOrdersHistory.add(delivery.activeOrder);
                    delivery.activeOrder = null;
                    loadDeliveryPanelScreen(primaryStage,deliverID);
                }
            });
        } else {
            showOrdersOrEndingDeliveryButton.setText("Show Orders");
            showOrdersOrEndingDeliveryButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    loadConfirmOrderForDeliveryScreen(primaryStage);
                }
            });
        }

        Button pathButton = new Button("Path");
        pathButton.setPrefWidth(145.0);
        pathButton.setPrefHeight(50.0);
        pathButton.setFont(new Font(15.0));
        pathButton.setId("deliveryID");
        GridPane.setConstraints(pathButton, 1, 0);

        Button editLocationButton = new Button("Edit location");
        editLocationButton.setPrefWidth(145.0);
        editLocationButton.setPrefHeight(50.0);
        editLocationButton.setFont(new Font(15.0));
        editLocationButton.setId("deliveryID");
        GridPane.setConstraints(editLocationButton, 2, 0);
        editLocationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditLocationForDeliveryScreen(primaryStage);
            }
        });


        Button logoutButton = new Button("LOGOUT");
        logoutButton.setPrefWidth(145.0);
        logoutButton.setPrefHeight(50.0);
        logoutButton.setFont(new Font(15.0));
        logoutButton.setId("deliveryID");
        GridPane.setConstraints(logoutButton, 3, 0);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });

        gridPane.getChildren().addAll(showOrdersOrEndingDeliveryButton, pathButton, editLocationButton, logoutButton);

        pane36.getChildren().addAll(deliveryPanelLabel, separator1, deliveryLocationLabel, imageView, logoLabel, separator2, gridPane);
        BackgroundImage myBackground = new BackgroundImage(new Image("delivery.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane36.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane36, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadConfirmOrderForDeliveryScreen(Stage primaryStage) {
        Pane pane37 = new Pane();
        Delivery delivery = (Delivery) Role.loggedInRole;
        Label confirmOrderLabel = new Label("Confirm order for delivering");
        confirmOrderLabel.setLayoutX(25.0);
        confirmOrderLabel.setLayoutY(30.0);
        confirmOrderLabel.setFont(new Font(20.0));

        Label toConfirmLabel = new Label("To confirm an order");
        toConfirmLabel.setLayoutX(25.0);
        toConfirmLabel.setLayoutY(75.0);
        toConfirmLabel.setPrefWidth(150.0);
        toConfirmLabel.setPrefHeight(25.0);

        ListView<String> listView = new ListView();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefWidth(375.0);
        listView.setPrefHeight(250.0);
        listView.getItems().addAll(Functions.showOrdersListForDelivery(staticArrayLists));


        Label pleaseEnterOrderIdLabel = new Label("please enter order ID");
        pleaseEnterOrderIdLabel.setLayoutX(25.0);
        pleaseEnterOrderIdLabel.setLayoutY(100.0);

        TextField orderIdTextField = new TextField();
        orderIdTextField.setLayoutX(25.0);
        orderIdTextField.setLayoutY(125.0);
        orderIdTextField.setPrefWidth(150.0);
        orderIdTextField.setPrefHeight(25.0);
        orderIdTextField.setId("textfield");

        Label errorLabel1 = new Label();
        errorLabel1.setLayoutX(25.0);
        errorLabel1.setLayoutY(250.0);
        errorLabel1.setPrefWidth(150.0);
        errorLabel1.setPrefHeight(20.0);
        errorLabel1.setTextFill(javafx.scene.paint.Color.RED);
        errorLabel1.setFont(new Font(10.0));

        Label errorLabel2 = new Label();
        errorLabel2.setLayoutX(25.0);
        errorLabel2.setLayoutY(265.0);
        errorLabel2.setPrefWidth(150.0);
        errorLabel2.setPrefHeight(20.0);
        errorLabel2.setTextFill(javafx.scene.paint.Color.RED);
        errorLabel2.setFont(new Font(10.0));

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(25.0);
        confirmButton.setLayoutY(165.0);
        confirmButton.setPrefWidth(150.0);
        confirmButton.setPrefHeight(20.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setId("deliveryID");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!orderIdTextField.getText().equals("")) {
                    String orderID = orderIdTextField.getText();
                    String[] answer = Functions.selectOrderForDelivery(staticArrayLists, orderID, map);
                    if (!answer[0].equals("true")) {
                        errorLabel1.setText("There is no order exist");
                        errorLabel2.setText("with this id !!!");
                    } else {
                        listView.getItems().clear();
                        listView.getItems().addAll(Functions.showOrdersListForDelivery(staticArrayLists));
                        errorLabel1.setText("Successfully confirmed !!!");
                        //show path to restaurant
                    }
                } else {
                    errorLabel1.setText("Please enter order id");
                    errorLabel2.setText("correctly !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(200.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setMnemonicParsing(false);
        backButton.setId("deliveryID");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeliveryPanelScreen(primaryStage, delivery.deliveryID);
            }
        });

        pane37.getChildren().addAll(confirmOrderLabel, toConfirmLabel, listView, pleaseEnterOrderIdLabel,
                orderIdTextField, confirmButton, backButton, errorLabel1, errorLabel2);
        BackgroundImage myBackground = new BackgroundImage(new Image("delivery.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane37.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane37, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditLocationForDeliveryScreen(Stage primaryStage) {
        Pane pane31 = new Pane();
        Delivery delivery = (Delivery) Role.loggedInRole;
        Label titleLabel = new Label("EDIT LOCATION");
        titleLabel.setFont(new Font(20));
        titleLabel.setLayoutX(50);
        titleLabel.setLayoutY(60);
        pane31.getChildren().add(titleLabel);

        Label locationLabel = new Label("Enter the new location");
        locationLabel.setLayoutX(50);
        locationLabel.setLayoutY(110);
        pane31.getChildren().add(locationLabel);

        TextField locationTextField = new TextField();
        locationTextField.setLayoutX(50);
        locationTextField.setLayoutY(140);
        locationTextField.setPrefWidth(200);
        locationTextField.setPrefHeight(25);
        locationTextField.setPromptText("new location");
        pane31.getChildren().add(locationTextField);
        locationTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(50.0);
        notifLabel.setLayoutY(225.0);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane31.getChildren().add(notifLabel);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(50);
        confirmButton.setLayoutY(185);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setId("deliveryID");
        pane31.getChildren().add(confirmButton);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!locationTextField.getText().equals("")) {
                    try {
                        int location = Integer.parseInt(locationTextField.getText());
                        if (location > 0 && location < 1000) {
                            delivery.deliveryLocation = location;
                            notifLabel.setText("New location successfully confirmed !!!");
                        } else {
                            notifLabel.setText("location must be a number between 0 and 1000 !!!");
                        }
                    } catch (Exception exception) {
                        notifLabel.setText("please enter a number !!!");
                    }
                } else {
                    notifLabel.setText("please enter a number !!!");
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(185);
        backButton.setPrefSize(80, 20);
        backButton.setId("deliveryID");
        pane31.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeliveryPanelScreen(primaryStage,delivery.deliveryID);
            }
        });

        BackgroundImage myBackground = new BackgroundImage(new Image("delivery.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane31.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane31, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRestaurantForUserScreen(Stage primaryStage) {
        Pane pane38 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForUser;

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(25);
        gridPane.setLayoutY(190);
        gridPane.setPrefSize(550, 63);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(25);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);

        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);
        gridPane.getRowConstraints().addAll(row1);

        Button menuBtn = new Button("Menu");
        menuBtn.setPrefSize(130, 50);
        menuBtn.setId("userID");
        gridPane.add(menuBtn, 0, 0);
        menuBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuForUserScreen(primaryStage);
            }
        });

        Button commentsBtn = new Button("Display comments");
        commentsBtn.setId("userID");
        commentsBtn.setPrefSize(130, 50);
        gridPane.add(commentsBtn, 1, 0);
        commentsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForRestaurantForUserScreen(primaryStage);
            }
        });

        Button ratingsBtn = new Button("Display Ratings");
        ratingsBtn.setId("userID");
        ratingsBtn.setPrefSize(130, 50);
        gridPane.add(ratingsBtn, 2, 0);
        ratingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForRestaurantForUserScreen(primaryStage);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setId("userID");
        backBtn.setPrefSize(130, 50);
        gridPane.add(backBtn, 3, 0);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Restaurant.loggedInRestaurantForUser = null;
                loadRestaurantListForUserScreen(primaryStage);
            }
        });

        Separator separator1 = new Separator();
        separator1.setLayoutX(25);
        separator1.setLayoutY(170);
        separator1.setPrefSize(550, 10);

        Label nameLabel = new Label(restaurant.restaurantName);
        nameLabel.setLayoutX(25);
        nameLabel.setLayoutY(50);
        nameLabel.setFont(new Font(20));

        Label locationLabel = new Label("Restaurant location: " + restaurant.restaurantLocation.toString());
        locationLabel.setLayoutX(25);
        locationLabel.setLayoutY(107);

        Separator separator2 = new Separator();
        separator2.setLayoutX(25);
        separator2.setLayoutY(265);
        separator2.setPrefSize(550, 10);

        ImageView logoImg = new ImageView();
        logoImg.setLayoutX(460);
        logoImg.setLayoutY(50);
        logoImg.setFitWidth(100);
        logoImg.setFitHeight(100);
        logoImg.setPreserveRatio(true);
        logoImg.setPickOnBounds(true);

        Label logoLabel = new Label("LOGO");
        logoLabel.setLayoutX(495);
        logoLabel.setLayoutY(90);

        pane38.getChildren().addAll(gridPane, separator1, nameLabel, locationLabel, separator2, logoImg, logoLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane38.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane38, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadMenuForUserScreen(Stage primaryStage) {
        Pane pane39 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForUser;

        ListView<String> foodListView = new ListView<>();
        foodListView.setLayoutX(200);
        foodListView.setLayoutY(75);
        foodListView.setPrefSize(375, 250);
        foodListView.getItems().addAll(Functions.showMenuForUser(restaurant));

        TextField foodIdTextField = new TextField();
        foodIdTextField.setLayoutX(25);
        foodIdTextField.setLayoutY(130);
        foodIdTextField.setPrefSize(150, 25);
        foodIdTextField.setPromptText("food ID");
        foodIdTextField.setId("textfield");

        TextField foodNameTextField = new TextField();
        foodNameTextField.setLayoutX(25);
        foodNameTextField.setLayoutY(195);
        foodNameTextField.setPrefSize(150, 25);
        foodNameTextField.setPromptText("food name");
        foodNameTextField.setId("textfield");

        Label foodIdLabel = new Label("please enter food ID");
        foodIdLabel.setLayoutX(25);
        foodIdLabel.setLayoutY(100);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(25);
        errorLabel.setLayoutY(295);
        errorLabel.setFont(new Font(10));
        errorLabel.setTextFill(Color.RED);

        Button selectBtn = new Button("Select");
        selectBtn.setLayoutX(25);
        selectBtn.setLayoutY(165);
        selectBtn.setPrefSize(150, 20);
        selectBtn.setId("userID");
        selectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.selectFood(foodIdTextField.getText());
                if (k != -1){
                    Food.selectedFoodForUser = Restaurant.loggedInRestaurantForUser.restaurantMenu.get(k);
                    loadFoodForUserScreen(primaryStage);
                } else
                    errorLabel.setText("Food not found !!!");
            }
        });

        Label foodListLabel = new Label("To see the foods");
        foodListLabel.setLayoutX(25);
        foodListLabel.setLayoutY(75);
        foodListLabel.setPrefSize(150, 25);

        Button searchBtn = new Button("Search");
        searchBtn.setLayoutX(25);
        searchBtn.setLayoutY(230);
        searchBtn.setPrefSize(150, 20);
        searchBtn.setId("userID");
        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                foodListView.getItems().clear();
                foodListView.getItems().addAll(Functions.showRelatedFoods(foodNameTextField.getText()));
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(25);
        backBtn.setLayoutY(260);
        backBtn.setPrefSize(150, 20);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });

        pane39.getChildren().addAll(foodListView, foodIdTextField, foodIdLabel, selectBtn, foodListLabel, backBtn, foodNameTextField, errorLabel, searchBtn);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane39.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane39, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadFoodForUserScreen(Stage primaryStage) {
        Pane pane40 = new Pane();
        User user = (User)Role.loggedInRole;
        Food food = Food.selectedFoodForUser;

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(25);
        gridPane.setLayoutY(190);
        gridPane.setPrefSize(550, 63);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(25);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);

        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);
        gridPane.getRowConstraints().addAll(row1);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(45);
        errorLabel.setLayoutY(133);
        errorLabel.setFont(new Font(10));
        errorLabel.setTextFill(Color.RED);

        Button addToCartBtn = new Button("Add this food to cart");
        addToCartBtn.setId("userID");
        addToCartBtn.setPrefSize(130, 50);
        gridPane.add(addToCartBtn, 0, 0);
        addToCartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                errorLabel.setText("Food added to the cart successfully !!!");
                Functions.addFoodToCart((User)Role.loggedInRole, Restaurant.loggedInRestaurantForUser, Food.selectedFoodForUser, staticArrayLists);
            }
        });

        Button commentsBtn = new Button("Display comments");
        commentsBtn.setId("userID");
        commentsBtn.setPrefSize(130, 50);
        gridPane.add(commentsBtn, 1, 0);
        commentsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForFoodForUserScreen(primaryStage);
            }
        });

        Button ratingsBtn = new Button("Display Ratings");
        ratingsBtn.setId("userID");
        ratingsBtn.setPrefSize(130, 50);
        gridPane.add(ratingsBtn, 2, 0);
        ratingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForFoodForUserScreen(primaryStage);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setId("userID");
        backBtn.setPrefSize(130, 50);
        gridPane.add(backBtn, 3, 0);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Food.selectedFoodForUser = null;
                loadMenuForUserScreen(primaryStage);
            }
        });

        Separator separator1 = new Separator();
        separator1.setLayoutX(25);
        separator1.setLayoutY(170);
        separator1.setPrefSize(550, 10);

        Label foodNameLabel = new Label(food.foodName);
        foodNameLabel.setLayoutX(45);
        foodNameLabel.setLayoutY(75);
        foodNameLabel.setFont(new Font(20));

        Separator separator2 = new Separator();
        separator2.setLayoutX(25);
        separator2.setLayoutY(265);
        separator2.setPrefSize(550, 10);

        ImageView logoImg = new ImageView();
        logoImg.setLayoutX(460);
        logoImg.setLayoutY(50);
        logoImg.setFitWidth(100);
        logoImg.setFitHeight(100);
        logoImg.setPreserveRatio(true);
        logoImg.setPickOnBounds(true);

        Label logoLabel = new Label("LOGO");
        logoLabel.setLayoutX(495);
        logoLabel.setLayoutY(90);

        pane40.getChildren().addAll(gridPane, separator1, foodNameLabel, separator2, logoImg, logoLabel, errorLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane40.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane40, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCommentsForFoodForUserScreen(Stage primaryStage) {
        Food food = Food.selectedFoodForUser;
        Pane pane47 = new Pane();

        ListView<String> commentsListView = new ListView<>();
        commentsListView.setLayoutX(200);
        commentsListView.setLayoutY(75);
        commentsListView.setPrefSize(375, 250);
        commentsListView.getItems().addAll(Functions.showFoodComments());

        TextField commentIdTextField = new TextField();
        commentIdTextField.setLayoutX(25);
        commentIdTextField.setLayoutY(145);
        commentIdTextField.setPrefSize(150, 25);
        commentIdTextField.setPromptText("comment ID");
        commentIdTextField.setId("textfield");

        Button addCommentBtn = new Button("Add new comments");
        addCommentBtn.setLayoutX(25);
        addCommentBtn.setLayoutY(225);
        addCommentBtn.setPrefSize(150, 20);
        addCommentBtn.setId("userID");
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddCommentForFoodForUserScreen(primaryStage);
            }
        });

        Label editCommentIdLabel = new Label("Please enter comment ID to edit ");
        editCommentIdLabel.setLayoutX(25);
        editCommentIdLabel.setLayoutY(120);
        editCommentIdLabel.setPrefSize(150, 25);
        editCommentIdLabel.setFont(new Font(10));

        Label errorLabel = new Label();
        errorLabel.setLayoutX(25);
        errorLabel.setLayoutY(300);
        errorLabel.setFont(new Font(10));
        errorLabel.setTextFill(Color.RED);

        Button editCommentBtn = new Button("Edit comments");
        editCommentBtn.setLayoutX(25);
        editCommentBtn.setLayoutY(185);
        editCommentBtn.setPrefSize(150, 25);
        editCommentBtn.setId("userID");
        editCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.editFoodComment(commentIdTextField.getText());
                if (k == -1)
                    errorLabel.setText("Comment not found !!!");
                else {
                    if (Role.loggedInRole.equals(Food.selectedFoodForUser.foodCommentsArrayList.get(k).commentedUser))
                        loadEditCommentForFoodForUserScreen(primaryStage,food.foodCommentsArrayList.get(k));
                    else
                        errorLabel.setText("This comment is Not yours !!!");
                }
            }
        });

        Label commentsLabel = new Label("COMMENTS");
        commentsLabel.setLayoutX(25);
        commentsLabel.setLayoutY(80);
        commentsLabel.setFont(new Font(20));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(25);
        backBtn.setLayoutY(265);
        backBtn.setPrefWidth(150);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodForUserScreen(primaryStage);
            }
        });

        pane47.getChildren().addAll(commentsListView, commentIdTextField, addCommentBtn, editCommentIdLabel, editCommentBtn,
                commentsLabel, backBtn, errorLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane47.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane47, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddCommentForFoodForUserScreen(Stage primaryStage) {
        Pane pane48 = new Pane();

        Label addCommentLabel = new Label("ADD NEW COMMENTS");
        addCommentLabel.setLayoutX(75);
        addCommentLabel.setLayoutY(60);
        addCommentLabel.setFont(new Font(20));

        Label enterCommentLabel = new Label("Please enter your new comments ....");
        enterCommentLabel.setLayoutX(75);
        enterCommentLabel.setLayoutY(125);

        TextField newCommentTextField = new TextField();
        newCommentTextField.setLayoutX(75);
        newCommentTextField.setLayoutY(170);
        newCommentTextField.setPrefWidth(190);
        newCommentTextField.setPromptText("new comments");
        newCommentTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(260);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button addCommentBtn = new Button("Add");
        addCommentBtn.setLayoutX(75);
        addCommentBtn.setLayoutY(220);
        addCommentBtn.setPrefWidth(80);
        addCommentBtn.setId("userID");
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Functions.addFoodComment(staticArrayLists,newCommentTextField.getText());
                notifLabel.setText("Thanks for your oponion :)");
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(185);
        backBtn.setLayoutY(220);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForFoodForUserScreen(primaryStage);
            }
        });

        pane48.getChildren().addAll(addCommentLabel, enterCommentLabel, notifLabel, newCommentTextField, addCommentBtn, backBtn);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane48.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane48, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditCommentForFoodForUserScreen(Stage primaryStage,Comment comment) {
        Pane pane49 = new Pane();

        Label editCommentLabel = new Label("Edit Comment");
        editCommentLabel.setLayoutX(75);
        editCommentLabel.setLayoutY(60);
        editCommentLabel.setFont(new Font(20));

        Label currentCommentLabel = new Label("current comment : " + comment.comment);
        currentCommentLabel.setLayoutX(75);
        currentCommentLabel.setLayoutY(175);

        TextField newCommentTextField = new TextField();
        newCommentTextField.setLayoutX(75);
        newCommentTextField.setLayoutY(215);
        newCommentTextField.setPrefWidth(200);
        newCommentTextField.setPromptText("new comment");
        newCommentTextField.setId("textfield");

        Label instructionLabel = new Label("You can enter new comment on the fields and click confirm to set");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(310);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmBtn = new Button("Confirm");
        confirmBtn.setLayoutX(75);
        confirmBtn.setLayoutY(270);
        confirmBtn.setPrefWidth(80);
        confirmBtn.setId("userID");
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comment.comment = newCommentTextField.getText();
                notifLabel.setText("Comment successfully edited !!!");
                currentCommentLabel.setText("current comment : " + comment.comment);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForFoodForUserScreen(primaryStage);
            }
        });

        pane49.getChildren().addAll(editCommentLabel, currentCommentLabel, notifLabel, newCommentTextField, instructionLabel, confirmBtn, backBtn);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane49.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane49, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRatingsForFoodForUserScreen(Stage primaryStage) {
        Pane pane50 = new Pane();
        User user = (User)Role.loggedInRole;

        Label addRatingLabel = new Label("ADD NEW RATINGS");
        addRatingLabel.setLayoutX(85);
        addRatingLabel.setLayoutY(70);
        addRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("Food current rating : " + Food.selectedFoodForUser.getRating());
        currentRatingLabel.setLayoutX(85);
        currentRatingLabel.setLayoutY(115);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(85);
        errorLabel.setLayoutY(130);
        errorLabel.setFont(new Font(10));
        errorLabel.setTextFill(Color.RED);

        Button addRatingBtn = new Button("Add new rating");
        addRatingBtn.setLayoutX(85);
        addRatingBtn.setLayoutY(185);
        addRatingBtn.setPrefWidth(100);
        addRatingBtn.setId("userID");
        addRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.getFoodRating(user);
                if (k != -1)
                    errorLabel.setText("You have already rated this food");
                else
                    loadSubmitRatingForFoodForUserScreen(primaryStage);
            }
        });

        Button editRatingBtn = new Button("Edit rating");
        editRatingBtn.setLayoutX(85);
        editRatingBtn.setLayoutY(220);
        editRatingBtn.setPrefWidth(100);
        editRatingBtn.setId("userID");
        editRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.getFoodRating(user);
                if (k == -1)
                    errorLabel.setText("You should submit rating first !!!");
                else
                    loadEditRatingForFoodForUserScreen(primaryStage, Food.selectedFoodForUser.foodRatingsArrayList.get(k));
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(85);
        backBtn.setLayoutY(255);
        backBtn.setPrefWidth(100);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodForUserScreen(primaryStage);
            }
        });

        ListView<String> ratingsListView = new ListView<>();
        ratingsListView.setLayoutX(250);
        ratingsListView.setLayoutY(170);
        ratingsListView.setPrefWidth(260);
        ratingsListView.setPrefHeight(150);
        ratingsListView.getItems().addAll(Functions.showFoodRatings());

        pane50.getChildren().addAll(addRatingLabel, currentRatingLabel, addRatingBtn, editRatingBtn, backBtn, ratingsListView, errorLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane50.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane50, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSubmitRatingForFoodForUserScreen(Stage primaryStage) {
        Pane pane51 = new Pane();
        User user = (User)Role.loggedInRole;

        Label addRatingLabel = new Label("ADD NEW RATING");
        addRatingLabel.setLayoutX(75);
        addRatingLabel.setLayoutY(60);
        addRatingLabel.setFont(new Font(20));

        Label instructionLabel = new Label("Please submit your new rating ....");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(210);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(313);
        ratingSlider.setLayoutY(125);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200, 20);

        Button submitBtn = new Button("Submit");
        submitBtn.setLayoutX(75);
        submitBtn.setLayoutY(170);
        submitBtn.setPrefWidth(80);
        submitBtn.setId("userID");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Food.selectedFoodForUser.foodRatingsArrayList.add(new Rating());
                Food.selectedFoodForUser.foodRatingsArrayList.get(Food.selectedFoodForUser.foodRatingsArrayList.size()-1).rating = ratingSlider.getValue();
                Food.selectedFoodForUser.foodRatingsArrayList.get(Food.selectedFoodForUser.foodRatingsArrayList.size()-1).ratingID = Functions.setID("rating",staticArrayLists);
                Food.selectedFoodForUser.foodRatingsArrayList.get(Food.selectedFoodForUser.foodRatingsArrayList.size()-1).ratedUser = user;
                ratingSlider.setDisable(true);
                notifLabel.setText("Rating submited !!!");
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(178);
        backBtn.setLayoutY(170);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForFoodForUserScreen(primaryStage);
            }
        });

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(330);
        ratingRangeLabel.setLayoutY(143);
        ratingRangeLabel.setFont(new Font(8));

        pane51.getChildren().addAll(addRatingLabel, instructionLabel, notifLabel, submitBtn, backBtn, ratingSlider, ratingRangeLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane51.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane51, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditRatingForFoodForUserScreen(Stage primaryStage,Rating rating) {
        Pane pane52 = new Pane();

        Label editRatingLabel = new Label("Edit Rating");
        editRatingLabel.setLayoutX(75);
        editRatingLabel.setLayoutY(60);
        editRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("current rating : " + rating.rating);
        currentRatingLabel.setLayoutX(75);
        currentRatingLabel.setLayoutY(175);

        Label instructionLabel = new Label("You can submit your new rating ...");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(310);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(75);
        ratingSlider.setLayoutY(220);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200, 20);

        Button confirmBtn = new Button("Confirm");
        confirmBtn.setLayoutX(75);
        confirmBtn.setLayoutY(270);
        confirmBtn.setPrefWidth(80);
        confirmBtn.setId("userID");
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rating.rating = ratingSlider.getValue();
                notifLabel.setText("Rating successfully edited !!!");
                currentRatingLabel.setText("current rating : " + rating.rating);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForFoodForUserScreen(primaryStage);
            }
        });

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(90);
        ratingRangeLabel.setLayoutY(235);
        ratingRangeLabel.setFont(new Font(8));

        pane52.getChildren().addAll(editRatingLabel, currentRatingLabel, instructionLabel, notifLabel, confirmBtn, backBtn, ratingSlider, ratingRangeLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane52.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane52, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCommentsForRestaurantForUserScreen(Stage primaryStage) {
        Restaurant restaurant = Restaurant.loggedInRestaurantForUser;
        Pane pane47 = new Pane();

        ListView<String> commentsListView = new ListView<>();
        commentsListView.setLayoutX(200);
        commentsListView.setLayoutY(75);
        commentsListView.setPrefSize(375, 250);
        commentsListView.getItems().addAll(Functions.showRestaurantComments(restaurant));

        TextField commentIdTextField = new TextField();
        commentIdTextField.setLayoutX(25);
        commentIdTextField.setLayoutY(145);
        commentIdTextField.setPrefSize(150, 25);
        commentIdTextField.setPromptText("comment ID");
        commentIdTextField.setId("textfield");

        Button addCommentBtn = new Button("Add new comments");
        addCommentBtn.setLayoutX(25);
        addCommentBtn.setLayoutY(225);
        addCommentBtn.setPrefSize(150, 20);
        addCommentBtn.setId("userID");
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddCommentForRestaurantForUserScreen(primaryStage);
            }
        });

        Label editCommentIdLabel = new Label("Please enter comment ID to edit ");
        editCommentIdLabel.setLayoutX(25);
        editCommentIdLabel.setLayoutY(120);
        editCommentIdLabel.setPrefSize(150, 25);
        editCommentIdLabel.setFont(new Font(10));

        Label errorLabel = new Label();
        errorLabel.setLayoutX(25);
        errorLabel.setLayoutY(300);
        errorLabel.setFont(new Font(10));
        errorLabel.setTextFill(Color.RED);

        Button editCommentBtn = new Button("Edit comments");
        editCommentBtn.setLayoutX(25);
        editCommentBtn.setLayoutY(185);
        editCommentBtn.setPrefSize(150, 25);
        editCommentBtn.setId("userID");
        editCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.editRestaurantComment(commentIdTextField.getText());
                if (k == -1)
                    errorLabel.setText("Comment not found !!!");
                else {
                    if (Role.loggedInRole.equals(Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.get(k).commentedUser))
                        loadEditCommentForRestaurantForUserScreen(primaryStage,restaurant.restaurantCommentsArrayList.get(k));
                    else
                        errorLabel.setText("This comment is Not yours !!!");
                }
            }
        });

        Label commentsLabel = new Label("COMMENTS");
        commentsLabel.setLayoutX(25);
        commentsLabel.setLayoutY(80);
        commentsLabel.setFont(new Font(20));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(25);
        backBtn.setLayoutY(265);
        backBtn.setPrefWidth(150);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });

        pane47.getChildren().addAll(commentsListView, commentIdTextField, addCommentBtn, editCommentIdLabel, editCommentBtn,
                commentsLabel, backBtn, errorLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane47.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane47, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddCommentForRestaurantForUserScreen(Stage primaryStage) {
        Pane pane48 = new Pane();

        Label addCommentLabel = new Label("ADD NEW COMMENTS");
        addCommentLabel.setLayoutX(75);
        addCommentLabel.setLayoutY(60);
        addCommentLabel.setFont(new Font(20));

        Label enterCommentLabel = new Label("Please enter your new comments ....");
        enterCommentLabel.setLayoutX(75);
        enterCommentLabel.setLayoutY(125);

        TextField newCommentTextField = new TextField();
        newCommentTextField.setLayoutX(75);
        newCommentTextField.setLayoutY(170);
        newCommentTextField.setPrefWidth(190);
        newCommentTextField.setPromptText("new comments");
        newCommentTextField.setId("textfield");

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(260);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button addCommentBtn = new Button("Add");
        addCommentBtn.setLayoutX(75);
        addCommentBtn.setLayoutY(220);
        addCommentBtn.setPrefWidth(80);
        addCommentBtn.setId("userID");
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Functions.addRestaurantComment(staticArrayLists,newCommentTextField.getText());
                notifLabel.setText("Thanks for your oponion :)");
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(185);
        backBtn.setLayoutY(220);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForRestaurantForUserScreen(primaryStage);
            }
        });

        pane48.getChildren().addAll(addCommentLabel, enterCommentLabel, notifLabel, newCommentTextField, addCommentBtn, backBtn);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane48.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane48, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditCommentForRestaurantForUserScreen(Stage primaryStage,Comment comment) {
        Pane pane49 = new Pane();

        Label editCommentLabel = new Label("Edit Comment");
        editCommentLabel.setLayoutX(75);
        editCommentLabel.setLayoutY(60);
        editCommentLabel.setFont(new Font(20));

        Label currentCommentLabel = new Label("current comment : " + comment.comment);
        currentCommentLabel.setLayoutX(75);
        currentCommentLabel.setLayoutY(175);

        TextField newCommentTextField = new TextField();
        newCommentTextField.setLayoutX(75);
        newCommentTextField.setLayoutY(215);
        newCommentTextField.setPrefWidth(200);
        newCommentTextField.setPromptText("new comment");
        newCommentTextField.setId("textfield");

        Label instructionLabel = new Label("You can enter new comment on the fields and click confirm to set");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(310);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmBtn = new Button("Confirm");
        confirmBtn.setLayoutX(75);
        confirmBtn.setLayoutY(270);
        confirmBtn.setPrefWidth(80);
        confirmBtn.setId("userID");
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comment.comment = newCommentTextField.getText();
                notifLabel.setText("Comment successfully edited !!!");
                currentCommentLabel.setText("current comment : " + comment.comment);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForRestaurantForUserScreen(primaryStage);
            }
        });

        pane49.getChildren().addAll(editCommentLabel, currentCommentLabel, notifLabel, newCommentTextField, instructionLabel, confirmBtn, backBtn);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane49.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane49, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRatingsForRestaurantForUserScreen(Stage primaryStage) {
        Pane pane50 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForUser;
        User user = (User)Role.loggedInRole;

        Label addRatingLabel = new Label("ADD NEW RATINGS");
        addRatingLabel.setLayoutX(85);
        addRatingLabel.setLayoutY(70);
        addRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("Restaurant current rating : " + restaurant.getRating());
        currentRatingLabel.setLayoutX(85);
        currentRatingLabel.setLayoutY(115);

        Label errorLabel = new Label();
        errorLabel.setLayoutX(85);
        errorLabel.setLayoutY(130);
        errorLabel.setFont(new Font(10));
        errorLabel.setTextFill(Color.RED);

        Button addRatingBtn = new Button("Add new rating");
        addRatingBtn.setLayoutX(85);
        addRatingBtn.setLayoutY(185);
        addRatingBtn.setPrefWidth(100);
        addRatingBtn.setId("userID");
        addRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.getRestaurantRating(user,restaurant);
                if (k != -1)
                    errorLabel.setText("You have already rated this restaurant");
                else
                    loadSubmitRatingForRestaurantForUserScreen(primaryStage);
            }
        });

        Button editRatingBtn = new Button("Edit rating");
        editRatingBtn.setLayoutX(85);
        editRatingBtn.setLayoutY(220);
        editRatingBtn.setPrefWidth(100);
        editRatingBtn.setId("userID");
        editRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int k = Functions.getRestaurantRating(user,restaurant);
                if (k == -1)
                    errorLabel.setText("You should submit rating first ...");
                else
                    loadEditRatingForRestaurantForUserScreen(primaryStage,restaurant.restaurantRatingsArrayList.get(k));
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(85);
        backBtn.setLayoutY(255);
        backBtn.setPrefWidth(100);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });

        ListView<String> ratingsListView = new ListView<>();
        ratingsListView.setLayoutX(250);
        ratingsListView.setLayoutY(170);
        ratingsListView.setPrefWidth(260);
        ratingsListView.setPrefHeight(150);
        ratingsListView.getItems().addAll(Functions.showRestaurantRatings(Restaurant.loggedInRestaurantForUser));

        pane50.getChildren().addAll(addRatingLabel, currentRatingLabel, addRatingBtn, editRatingBtn, backBtn, ratingsListView, errorLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane50.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane50, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSubmitRatingForRestaurantForUserScreen(Stage primaryStage) {
        Pane pane51 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForUser;
        User user = (User)Role.loggedInRole;

        Label addRatingLabel = new Label("ADD NEW RATING");
        addRatingLabel.setLayoutX(75);
        addRatingLabel.setLayoutY(60);
        addRatingLabel.setFont(new Font(20));

        Label instructionLabel = new Label("Please submit your new rating ....");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(210);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(313);
        ratingSlider.setLayoutY(125);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200, 20);

        Button submitBtn = new Button("Submit");
        submitBtn.setLayoutX(75);
        submitBtn.setLayoutY(170);
        submitBtn.setPrefWidth(80);
        submitBtn.setId("userID");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                restaurant.restaurantRatingsArrayList.add(new Rating());
                restaurant.restaurantRatingsArrayList.get(restaurant.restaurantRatingsArrayList.size()-1).rating = ratingSlider.getValue();
                restaurant.restaurantRatingsArrayList.get(restaurant.restaurantRatingsArrayList.size()-1).ratingID = Functions.setID("rating",staticArrayLists);
                restaurant.restaurantRatingsArrayList.get(restaurant.restaurantRatingsArrayList.size()-1).ratedUser = user;
                ratingSlider.setDisable(true);
                notifLabel.setText("Rating submited !!!");
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(178);
        backBtn.setLayoutY(170);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForRestaurantForUserScreen(primaryStage);
            }
        });

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(330);
        ratingRangeLabel.setLayoutY(143);
        ratingRangeLabel.setFont(new Font(8));

        pane51.getChildren().addAll(addRatingLabel, instructionLabel, notifLabel, submitBtn, backBtn, ratingSlider, ratingRangeLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane51.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane51, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditRatingForRestaurantForUserScreen(Stage primaryStage,Rating rating) {
        Pane pane52 = new Pane();
        Restaurant restaurant = Restaurant.loggedInRestaurantForUser;
        User user = (User)Role.loggedInRole;

        Label editRatingLabel = new Label("Edit Rating");
        editRatingLabel.setLayoutX(75);
        editRatingLabel.setLayoutY(60);
        editRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("current rating : " + rating.rating);
        currentRatingLabel.setLayoutX(75);
        currentRatingLabel.setLayoutY(175);

        Label instructionLabel = new Label("You can submit your new rating ...");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(310);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(75);
        ratingSlider.setLayoutY(220);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200, 20);

        Button confirmBtn = new Button("Confirm");
        confirmBtn.setLayoutX(75);
        confirmBtn.setLayoutY(270);
        confirmBtn.setPrefWidth(80);
        confirmBtn.setId("userID");
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rating.rating = ratingSlider.getValue();
                notifLabel.setText("Rating successfully edited !!!");
                currentRatingLabel.setText("current rating : " + rating.rating);
            }
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setId("userID");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForRestaurantForUserScreen(primaryStage);
            }
        });

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(90);
        ratingRangeLabel.setLayoutY(235);
        ratingRangeLabel.setFont(new Font(8));

        pane52.getChildren().addAll(editRatingLabel, currentRatingLabel, instructionLabel, notifLabel, confirmBtn, backBtn, ratingSlider, ratingRangeLabel);
        BackgroundImage myBackground = new BackgroundImage(new Image("user.jpg",600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT) ;
        pane52.setBackground(new Background(myBackground));
        Scene scene = new Scene(pane52, 600, 400);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void serializeObjects(StaticArrayLists staticArrayLists) {
        try {
            FileOutputStream fileout = new FileOutputStream("F:\\CP Projects\\OOP\\Phase2\\src\\StaticArrayLists.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(staticArrayLists);
            out.close();
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FileInputStream fileIn = new FileInputStream("F:\\CP Projects\\OOP\\Phase2\\src\\StaticArrayLists.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            staticArrayLists = (StaticArrayLists) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("DeSerialize failed !");
        }
        loadWellcomeScreen(primaryStage);
    }
}