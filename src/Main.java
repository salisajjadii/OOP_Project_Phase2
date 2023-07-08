import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    String buttonStyle = "-fx-background-color: #e1ecf4; " +
            "-fx-border-radius: 3px; " +
            "-fx-border-width: 1px; " +
            "-fx-border-color: #7aa7c7; " +
            "-fx-box-shadow: inset 0 1px 0 0 rgba(255, 255, 255, .7); " +
            "-fx-color: #39739d; ";
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
        label.setTextFill(Color.rgb(57,115,157));
        pane.getChildren().add(label);

        Button loginButton = new Button("LOG IN");
        loginButton.setFont(Font.font("Calibri", 18));
        loginButton.setLayoutX(150);
        loginButton.setLayoutY(140);
        loginButton.setPrefSize(90, 35);
        pane.getChildren().add(loginButton);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCaptchaBFLoginScreen(primaryStage);
            }
        });
        loginButton.setStyle("-fx-background-color: #e1ecf4; " +
                "-fx-border-radius: 3px; " +
                "-fx-border-width: 1px; " +
                "-fx-border-color: #7aa7c7; " +
                "-fx-box-shadow: inset 0 1px 0 0 rgba(255, 255, 255, .7); " +
                "-fx-color: #39739d; " +
                "-fx-font-family: \"-apple-system\",system-ui,\"Segoe UI\",\"Liberation Sans\",sans-serif; " +
                "-fx-font-size: 15px; " +
                "-fx-font-weight: 400; " +
                "-fx-line-spacing: 1.15385; " +
                "-fx-padding: 8px .8em; " +
                "-fx-text-align: center; " +
                "-fx-text-decoration: none; " +
                "-fx-cursor: hand; " +
                "-fx-wrap-text: false;");
        loginButton.setTextFill(Color.rgb(57,115,157));

        Button signUpButton = new Button("SIGN UP");
        signUpButton.setFont(Font.font("Calibri", 18));
        signUpButton.setLayoutX(255);
        signUpButton.setLayoutY(140);
        signUpButton.setPrefSize(90, 35);
        pane.getChildren().add(signUpButton);
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCaptchaBFSignUpScreen(primaryStage);
            }
        });
        signUpButton.setStyle("-fx-background-color: #e1ecf4; " +
                "-fx-border-radius: 3px; " +
                "-fx-border-width: 1px; " +
                "-fx-border-color: #7aa7c7; " +
                "-fx-box-shadow: inset 0 1px 0 0 rgba(255, 255, 255, .7); " +
                "-fx-color: #39739d; " +
                "-fx-font-family: \"-apple-system\",system-ui,\"Segoe UI\",\"Liberation Sans\",sans-serif; " +
                "-fx-font-size: 15px; " +
                "-fx-font-weight: 400; " +
                "-fx-line-spacing: 1.15385; " +
                "-fx-padding: 8px .8em; " +
                "-fx-text-align: center; " +
                "-fx-text-decoration: none; " +
                "-fx-cursor: hand; " +
                "-fx-wrap-text: false;");
        signUpButton.setTextFill(Color.rgb(57,115,157));

        Button exitButton = new Button("EXIT");
        exitButton.setFont(Font.font("Calibri", 18));
        exitButton.setLayoutX(360);
        exitButton.setLayoutY(140);
        exitButton.setPrefSize(90, 35);
        pane.getChildren().add(exitButton);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });
        exitButton.setStyle("-fx-background-color: #e1ecf4; " +
                "-fx-border-radius: 3px; " +
                "-fx-border-width: 1px; " +
                "-fx-border-color: #7aa7c7; " +
                "-fx-box-shadow: inset 0 1px 0 0 rgba(255, 255, 255, .7); " +
                "-fx-color: #39739d; " +
                "-fx-font-family: \"-apple-system\",system-ui,\"Segoe UI\",\"Liberation Sans\",sans-serif; " +
                "-fx-font-size: 15px; " +
                "-fx-font-weight: 400; " +
                "-fx-line-spacing: 1.15385; " +
                "-fx-padding: 8px .8em; " +
                "-fx-text-align: center; " +
                "-fx-text-decoration: none; " +
                "-fx-cursor: hand; " +
                "-fx-wrap-text: false;");
        exitButton.setTextFill(Color.rgb(57,115,157));

        Label productLabel = new Label("Producted by Mahdi, MoMehdi, Seyedali");
        productLabel.setFont(Font.font(8));
        productLabel.setLayoutY(386);
        productLabel.setPrefSize(298, 17);
        productLabel.setTextFill(Color.valueOf("#404040"));
        pane.getChildren().add(productLabel);

        Scene scene = new Scene(pane, 600, 400);
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
        textField.setPrefWidth(150);

        Button buttonNext = new Button("Next");
        buttonNext.setPrefSize(80,20);
        buttonNext.setStyle(buttonStyle);
        buttonNext.setTextFill(Color.rgb(57,115,157));
        Button buttonBack = new Button("Back");
        buttonBack.setPrefSize(80,20);
        buttonBack.setStyle(buttonStyle);
        buttonBack.setTextFill(Color.rgb(57,115,157));

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

        Button buttonNext = new Button("Next");
        buttonNext.setPrefSize(80,20);
        buttonNext.setStyle(buttonStyle);
        buttonNext.setTextFill(Color.rgb(57,115,157));
        Button buttonBack = new Button("Back");
        buttonBack.setPrefSize(80,20);
        buttonBack.setStyle(buttonStyle);
        buttonBack.setTextFill(Color.rgb(57,115,157));

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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(130);
        notifLabel.setLayoutY(250);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        pane0.getChildren().addAll(hBoxOne,hboxTwo, notifLabel, captchaLabel);
        Scene scene = new Scene(pane0);
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadLoginScreen(Stage primaryStage) {
        Pane pane1 = new Pane();
        pane1.setPrefSize(600, 400);

        RadioButton asAdminRadioButton = new RadioButton("as Admin");
        asAdminRadioButton.setLayoutX(50);
        asAdminRadioButton.setLayoutY(100);

        RadioButton asUserRadioButton = new RadioButton("as User");
        asUserRadioButton.setLayoutX(50);
        asUserRadioButton.setLayoutY(130);

        RadioButton asDeliveryRadioButton = new RadioButton("as Delivery");
        asDeliveryRadioButton.setLayoutX(50);
        asDeliveryRadioButton.setLayoutY(160);

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

        Label usernameLabel = new Label("Username:");
        usernameLabel.setLayoutX(198);
        usernameLabel.setLayoutY(112);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setLayoutX(198);
        passwordLabel.setLayoutY(153);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setLayoutX(280);
        passwordTextField.setLayoutY(150);
        passwordTextField.setPrefSize(180, 20);
        passwordTextField.setPromptText("Abcd1234");

        Button forgetPassButton = new Button("Forget Pass");
        forgetPassButton.setLayoutX(280);
        forgetPassButton.setLayoutY(215);
        forgetPassButton.setPrefWidth(80);
        forgetPassButton.setPrefHeight(20);
        forgetPassButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass1Screen(primaryStage);
            }
        });
        forgetPassButton.setStyle(buttonStyle);
        forgetPassButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(280);
        backButton.setLayoutY(255);
        backButton.setPrefWidth(180);
        backButton.setPrefHeight(20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCaptchaBFLoginScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Label errorLabel = new Label();
        errorLabel.setLayoutX(280);
        errorLabel.setLayoutY(290);
        errorLabel.setPrefSize(178, 30);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font("Calibri", 10));

        Label titleLabel = new Label("LOGIN PAGE");
        titleLabel.setLayoutY(30);
        titleLabel.setLayoutX(80);
        titleLabel.setFont(new Font(20));

        Label creditsLabel = new Label("Producted by Mahdi, MoMehdi, Seyedali");
        creditsLabel.setLayoutY(386);
        creditsLabel.setPrefSize(298, 17);
        creditsLabel.setTextFill(Color.rgb(64, 64, 64));
        creditsLabel.setFont(new Font(8));

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(380);
        loginButton.setLayoutY(215);
        loginButton.setPrefWidth(80);
        loginButton.setPrefHeight(20);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup1.getSelectedToggle() == asAdminRadioButton)
                    loadAdminPanelScreen(primaryStage);
                else if (toggleGroup1.getSelectedToggle() == asUserRadioButton)
                    loadUserPanelScreen(primaryStage);
                else if (toggleGroup1.getSelectedToggle() == asDeliveryRadioButton)
                    loadDeliveryPanelScreen(primaryStage);
                else
                    errorLabel.setText("Please select your account type !!!");
            }
        });
        loginButton.setStyle(buttonStyle);
        loginButton.setTextFill(Color.rgb(57,115,157));

        pane1.getChildren().addAll(asAdminRadioButton, asUserRadioButton, separator, usernameTextField,
                usernameLabel, passwordLabel, passwordTextField, loginButton, forgetPassButton, backButton,
                asDeliveryRadioButton, errorLabel, titleLabel, creditsLabel);

        Scene scene = new Scene(pane1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadForgetPass1Screen(Stage primaryStage) {
        Pane pane3 = new Pane();

        RadioButton radioBtnAdmin = new RadioButton();
        radioBtnAdmin.setLayoutX(50.0);
        radioBtnAdmin.setLayoutY(100.0);
        radioBtnAdmin.setText("as Admin");
        pane3.getChildren().add(radioBtnAdmin);

        RadioButton radioBtnUser = new RadioButton();
        radioBtnUser.setLayoutX(50.0);
        radioBtnUser.setLayoutY(130.0);
        radioBtnUser.setText("as User");
        pane3.getChildren().add(radioBtnUser);

        RadioButton radioBtnDelivery = new RadioButton();
        radioBtnDelivery.setLayoutX(50.0);
        radioBtnDelivery.setLayoutY(160.0);
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

        Label labelUsername = new Label("Username :");
        labelUsername.setLayoutX(198.0);
        labelUsername.setLayoutY(152.0);
        labelUsername.setPrefHeight(20.0);
        labelUsername.setPrefWidth(70.0);
        pane3.getChildren().add(labelUsername);

        Label labelError = new Label();
        labelError.setLayoutX(281.0);
        labelError.setLayoutY(293.0);
        labelError.setPrefHeight(30.0);
        labelError.setPrefWidth(178.0);
        labelError.setText("!!! ERROR SENTENCE");
        labelError.setTextFill(javafx.scene.paint.Color.RED);
        labelError.setFont(new Font("Calibri", 10.0));
        pane3.getChildren().add(labelError);

        Button buttonBack = new Button();
        buttonBack.setLayoutX(380.0);
        buttonBack.setLayoutY(215.0);
        buttonBack.setMnemonicParsing(false);
        buttonBack.setPrefHeight(20.0);
        buttonBack.setPrefWidth(80.0);
        buttonBack.setText("Back");
        pane3.getChildren().add(buttonBack);
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });
        buttonBack.setStyle(buttonStyle);
        buttonBack.setTextFill(Color.rgb(57,115,157));

        Button buttonNext = new Button("Next");
        buttonNext.setLayoutX(280.0);
        buttonNext.setLayoutY(215.0);
        buttonNext.setMnemonicParsing(false);
        buttonNext.setPrefHeight(20.0);
        buttonNext.setPrefWidth(80.0);
        pane3.getChildren().add(buttonNext);
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass2Screen(primaryStage);
            }
        });
        buttonNext.setStyle(buttonStyle);
        buttonNext.setTextFill(Color.rgb(57,115,157));

        Label labelTitle = new Label();
        labelTitle.setLayoutY(30);
        labelTitle.setLayoutX(80);
        labelTitle.setText("FORGET PASSWORD PAGE");
        labelTitle.setFont(new Font(20.0));
        pane3.getChildren().add(labelTitle);

        Label labelCredits = new Label();
        labelCredits.setLayoutY(386.0);
        labelCredits.setPrefHeight(17.0);
        labelCredits.setPrefWidth(298.0);
        labelCredits.setText("Producted by Mahdi, MoMehdi, Seyedali");
        labelCredits.setTextFill(javafx.scene.paint.Color.web("#404040"));
        labelCredits.setFont(new Font(8.0));
        pane3.getChildren().add(labelCredits);

        Label labelPrompt = new Label();
        labelPrompt.setLayoutX(198.0);
        labelPrompt.setLayoutY(107.0);
        labelPrompt.setPrefHeight(20.0);
        labelPrompt.setPrefWidth(262.0);
        labelPrompt.setText("Please enter your username to reset your password");
        labelPrompt.setFont(new Font(11.5));
        pane3.getChildren().add(labelPrompt);

        Scene scene = new Scene(pane3, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadForgetPass2Screen(Stage primaryStage) {
        Pane pane3 = new Pane();

        RadioButton radioBtnAdmin = new RadioButton();
        radioBtnAdmin.setLayoutX(50.0);
        radioBtnAdmin.setLayoutY(100.0);
        radioBtnAdmin.setText("as Admin");
        pane3.getChildren().add(radioBtnAdmin);
        radioBtnAdmin.setDisable(true);

        RadioButton radioBtnUser = new RadioButton();
        radioBtnUser.setLayoutX(50.0);
        radioBtnUser.setLayoutY(130.0);
        radioBtnUser.setText("as User");
        pane3.getChildren().add(radioBtnUser);
        radioBtnUser.setDisable(true);

        RadioButton radioBtnDelivery = new RadioButton();
        radioBtnDelivery.setLayoutX(50.0);
        radioBtnDelivery.setLayoutY(160.0);
        radioBtnDelivery.setText("as Delivery");
        pane3.getChildren().add(radioBtnDelivery);
        radioBtnDelivery.setDisable(true);

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

        Label labelUsername = new Label("Username :");
        labelUsername.setLayoutX(198.0);
        labelUsername.setLayoutY(152.0);
        labelUsername.setPrefHeight(20.0);
        labelUsername.setPrefWidth(70.0);
        pane3.getChildren().add(labelUsername);

        Label labelTitle = new Label();
        labelTitle.setLayoutY(30);
        labelTitle.setLayoutX(80);
        labelTitle.setText("FORGET PASSWORD PAGE");
        labelTitle.setFont(new Font(20.0));
        pane3.getChildren().add(labelTitle);

        Label labelCredits = new Label();
        labelCredits.setLayoutY(386.0);
        labelCredits.setPrefHeight(17.0);
        labelCredits.setPrefWidth(298.0);
        labelCredits.setText("Producted by Mahdi, MoMehdi, Seyedali");
        labelCredits.setTextFill(javafx.scene.paint.Color.web("#404040"));
        labelCredits.setFont(new Font(8.0));
        pane3.getChildren().add(labelCredits);

        Label labelPrompt = new Label();
        labelPrompt.setLayoutX(198.0);
        labelPrompt.setLayoutY(107.0);
        labelPrompt.setPrefHeight(20.0);
        labelPrompt.setPrefWidth(262.0);
        labelPrompt.setText("Please enter your username to reset your password");
        labelPrompt.setFont(new Font(11.5));
        pane3.getChildren().add(labelPrompt);

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


        Label securityQuestionLabel = new Label("Security Question Label");
        securityQuestionLabel.setLayoutX(198.0);
        securityQuestionLabel.setLayoutY(240.0);
        pane3.getChildren().add(securityQuestionLabel);

        TextField securityAnswerTextField = new TextField();
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

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(198.0);
        resetButton.setLayoutY(310.0);
        resetButton.setPrefSize(80, 30);
        pane3.getChildren().add(resetButton);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass3Screen(primaryStage);
            }
        });
        resetButton.setStyle(buttonStyle);
        resetButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(298);
        backButton.setLayoutY(310);
        backButton.setPrefSize(80, 30);
        pane3.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass1Screen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane3, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadForgetPass3Screen(Stage primaryStage) {
        Pane pane6 = new Pane();

        Label newPasswordLabel = new Label("New Password:");
        newPasswordLabel.setLayoutX(115);
        newPasswordLabel.setLayoutY(85);
        pane6.getChildren().add(newPasswordLabel);

        Label confirmNewPasswordLabel = new Label("Confirm New Password:");
        confirmNewPasswordLabel.setLayoutX(115);
        confirmNewPasswordLabel.setLayoutY(130);
        pane6.getChildren().add(confirmNewPasswordLabel);

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setLayoutX(255);
        newPasswordField.setLayoutY(83);
        newPasswordField.setPrefHeight(20);
        newPasswordField.setPrefWidth(180);
        pane6.getChildren().add(newPasswordField);

        PasswordField confirmNewPasswordField = new PasswordField();
        confirmNewPasswordField.setLayoutX(255);
        confirmNewPasswordField.setLayoutY(126);
        confirmNewPasswordField.setPrefHeight(20);
        confirmNewPasswordField.setPrefWidth(180);
        pane6.getChildren().add(confirmNewPasswordField);

        Label successLabel = new Label();
        successLabel.setLayoutX(275);
        successLabel.setLayoutY(224);
        successLabel.setPrefHeight(20);
        successLabel.setPrefWidth(140);
        successLabel.setTextFill(Color.RED);
        successLabel.setFont(new Font(10));
        pane6.getChildren().add(successLabel);

        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(255);
        resetButton.setLayoutY(169);
        resetButton.setPrefSize(80, 20);
        pane6.getChildren().add(resetButton);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                successLabel.setText("Password successfully changed");
            }
        });
        resetButton.setStyle(buttonStyle);
        resetButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(355);
        backButton.setLayoutY(169);
        backButton.setPrefSize(80, 20);
        pane6.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadForgetPass2Screen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane6, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSignUp1Screen(Stage primaryStage) {
        Pane pane2 = new Pane();

        RadioButton asAdminRadioButton = new RadioButton("as Admin");
        asAdminRadioButton.setLayoutX(50.0);
        asAdminRadioButton.setLayoutY(100.0);

        RadioButton asUserRadioButton = new RadioButton("as User");
        asUserRadioButton.setLayoutX(50.0);
        asUserRadioButton.setLayoutY(130.0);

        RadioButton asDeliveryRadioButton = new RadioButton("as Delivery");
        asDeliveryRadioButton.setLayoutX(50.0);
        asDeliveryRadioButton.setLayoutY(160.0);

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
        usernameTextField.setLayoutY(105.0);
        usernameTextField.setPrefSize(180, 20);
        usernameTextField.setPromptText("username");

        Label usernameLabel = new Label("Username :");
        usernameLabel.setLayoutX(198.0);
        usernameLabel.setLayoutY(107.0);

        Label passwordLabel = new Label("Password :");
        passwordLabel.setLayoutX(198.0);
        passwordLabel.setLayoutY(133.0);

        PasswordField passwordPasswordField = new PasswordField();
        passwordPasswordField.setLayoutX(280.0);
        passwordPasswordField.setLayoutY(130.0);
        passwordPasswordField.setPrefSize(180, 20);
        passwordPasswordField.setPromptText("pass");

        Button nextButton = new Button("Next");
        nextButton.setLayoutX(280.0);
        nextButton.setLayoutY(215.0);
        nextButton.setPrefWidth(80);
        nextButton.setPrefHeight(20);
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadSignUp2Screen(primaryStage);
            }
        });
        nextButton.setStyle(buttonStyle);
        nextButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(380);
        backButton.setLayoutY(215);
        backButton.setPrefWidth(80);
        backButton.setPrefHeight(20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCaptchaBFSignUpScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Label errorLabel = new Label("!!! ERROR SENTENCE");
        errorLabel.setLayoutX(280);
        errorLabel.setLayoutY(290);
        errorLabel.setPrefSize(178, 30);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font("Calibri", 10));

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setLayoutX(280.0);
        confirmPasswordField.setLayoutY(154.0);
        confirmPasswordField.setPrefSize(180, 20);
        confirmPasswordField.setPromptText("enter your pass again");

        Label pageTitleLabel = new Label("SIGN UP PAGE");
        pageTitleLabel.setLayoutY(30);
        pageTitleLabel.setLayoutX(80);
        pageTitleLabel.setFont(new Font(20.0));

        Label creditLabel = new Label("Producted by Mahdi, MoMehdi, Seyedali");
        creditLabel.setLayoutY(386.0);
        creditLabel.setTextFill(Color.web("#404040"));
        creditLabel.setFont(new Font(8.0));

        pane2.getChildren().addAll(asAdminRadioButton, asUserRadioButton, separator, usernameTextField, usernameLabel, passwordLabel,
                passwordPasswordField, nextButton, backButton, asDeliveryRadioButton, errorLabel, confirmPasswordField, pageTitleLabel, creditLabel);

        Scene scene = new Scene(pane2, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSignUp2Screen(Stage primaryStage) {
        Pane pane5 = new Pane();

        RadioButton radioButton1 = new RadioButton("as Admin");
        radioButton1.setLayoutX(50.0);
        radioButton1.setLayoutY(100.0);
        radioButton1.setMnemonicParsing(false);
        radioButton1.setDisable(true);

        RadioButton radioButton2 = new RadioButton("as User");
        radioButton2.setLayoutX(50.0);
        radioButton2.setLayoutY(130.0);
        radioButton2.setMnemonicParsing(false);
        radioButton2.setDisable(true);

        RadioButton radioButton3 = new RadioButton("as Delivery");
        radioButton3.setLayoutX(50.0);
        radioButton3.setLayoutY(160.0);
        radioButton3.setMnemonicParsing(false);
        radioButton3.setDisable(true);

        Separator separator = new Separator();
        separator.setLayoutX(150.0);
        separator.setLayoutY(100.0);
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(90.0);
        separator.setPrefWidth(10.0);

        TextField textField1 = new TextField();
        textField1.setLayoutX(280.0);
        textField1.setLayoutY(105.0);
        textField1.setPrefHeight(20.0);
        textField1.setPrefWidth(180.0);
        textField1.setPromptText("username");
        textField1.setEditable(false);

        Label label1 = new Label("Username :");
        label1.setLayoutX(198.0);
        label1.setLayoutY(107.0);
        label1.setPrefHeight(20.0);
        label1.setPrefWidth(70.0);

        Label label2 = new Label("Password :");
        label2.setLayoutX(199.0);
        label2.setLayoutY(133.0);
        label2.setPrefHeight(20.0);
        label2.setPrefWidth(70.0);

        PasswordField passField2 = new PasswordField();
        passField2.setLayoutX(280.0);
        passField2.setLayoutY(130.0);
        passField2.setPrefHeight(20.0);
        passField2.setPrefWidth(180.0);
        passField2.setPromptText("pass");
        passField2.setEditable(false);

        PasswordField passField3 = new PasswordField();
        passField3.setLayoutX(280.0);
        passField3.setLayoutY(154.0);
        passField3.setPrefHeight(20.0);
        passField3.setPrefWidth(180.0);
        passField3.setPromptText("enter your pass again");
        passField3.setEditable(false);

        TextField textField4 = new TextField();
        textField4.setLayoutX(198.0);
        textField4.setLayoutY(270.0);
        textField4.setPrefHeight(20.0);
        textField4.setPrefWidth(262.0);
        textField4.setPromptText("Security Question's Answer");

        Label label3 = new Label();
        label3.setLayoutX(80.0);
        label3.setLayoutY(30.0);
        label3.setText("SIGN UP PAGE");
        label3.setFont(new Font(20.0));

        Label label4 = new Label("Producted by Mahdi,MoMehdi,Seyedali");
        label4.setLayoutY(386.0);
        label4.setPrefHeight(17.0);
        label4.setPrefWidth(298.0);
        label4.setTextFill(javafx.scene.paint.Color.web("#404040"));
        label4.setFont(new Font(8.0));

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

        Label label6 = new Label("Security Question Label");
        label6.setLayoutX(198.0);
        label6.setLayoutY(240.0);
        label6.setPrefHeight(20.0);
        label6.setPrefWidth(262.0);

        Label label7 = new Label();
        label7.setLayoutX(198);
        label7.setLayoutY(350);
        label7.setTextFill(javafx.scene.paint.Color.RED);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setLayoutX(199.0);
        signUpButton.setLayoutY(310.0);
        signUpButton.setPrefHeight(20.0);
        signUpButton.setPrefWidth(80.0);
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label7.setText("Signed up successfully, you can login using login page now!");
            }
        });
        signUpButton.setStyle(buttonStyle);
        signUpButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(298);
        backButton.setLayoutY(310);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadSignUp1Screen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane5.getChildren().addAll(signUpButton, label1, label2, label3, label4, label5, label6, label7, separator, separator2, radioButton1, radioButton2,
                radioButton3, textField1, passField2, passField3, textField4, backButton);

        Scene scene = new Scene(pane5, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAdminPanelScreen(Stage primaryStage) {
        Pane pane7 = new Pane();

        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200);
        listView.setLayoutY(75);
        listView.setPrefHeight(250);
        listView.setPrefWidth(375);
        pane7.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25);
        textField.setLayoutY(125);
        textField.setPrefHeight(25);
        textField.setPrefWidth(150);
        pane7.getChildren().add(textField);
        textField.setPromptText("restaurant ID");

        Label label = new Label();
        label.setLayoutX(25);
        label.setLayoutY(100);
        label.setText("please enter restaurant ID");
        pane7.getChildren().add(label);

        Button selectButton = new Button();
        selectButton.setLayoutX(25);
        selectButton.setLayoutY(165);
        selectButton.setPrefHeight(20);
        selectButton.setPrefWidth(150);
        selectButton.setText("Select");
        pane7.getChildren().add(selectButton);
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        selectButton.setStyle(buttonStyle);
        selectButton.setTextFill(Color.rgb(57,115,157));

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
        pane7.getChildren().add(addRestaurantButton);
        addRestaurantButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddRestaurantScreen(primaryStage);
            }
        });
        addRestaurantButton.setStyle(buttonStyle);
        addRestaurantButton.setTextFill(Color.rgb(57,115,157));

        Button logoutButton = new Button();
        logoutButton.setLayoutX(25);
        logoutButton.setLayoutY(245);
        logoutButton.setPrefHeight(25);
        logoutButton.setPrefWidth(150);
        logoutButton.setText("LOGOUT");
        pane7.getChildren().add(logoutButton);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });
        logoutButton.setStyle(buttonStyle);
        logoutButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane7, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRestaurantScreen(Stage primaryStage) {
        Pane pane8 = new Pane();

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
        GridPane.setHalignment(button1, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button1, javafx.geometry.VPos.CENTER);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuScreenForAdmin(primaryStage);
            }
        });
        button1.setStyle(buttonStyle);
        button1.setTextFill(Color.rgb(57,115,157));

        Button button2 = new Button();
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(50.0);
        button2.setPrefWidth(145.0);
        button2.setText("Open orders");
        GridPane.setHalignment(button2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button2, 1);
        GridPane.setValignment(button2, javafx.geometry.VPos.CENTER);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOpenOrderScreen(primaryStage);
            }
        });
        button2.setStyle(buttonStyle);
        button2.setTextFill(Color.rgb(57,115,157));

        Button button3 = new Button();
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(50.0);
        button3.setPrefWidth(145.0);
        button3.setText("Display comments");
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
        button3.setStyle(buttonStyle);
        button3.setTextFill(Color.rgb(57,115,157));

        Button button4 = new Button();
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(50.0);
        button4.setPrefWidth(145.0);
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
        button4.setStyle(buttonStyle);
        button4.setTextFill(Color.rgb(57,115,157));

        Button button5 = new Button();
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(50.0);
        button5.setPrefWidth(145.0);
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
        button5.setStyle(buttonStyle);
        button5.setTextFill(Color.rgb(57,115,157));

        Button button6 = new Button();
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(50.0);
        button6.setPrefWidth(145.0);
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
        button6.setStyle(buttonStyle);
        button6.setTextFill(Color.rgb(57,115,157));

        Button button7 = new Button();
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(50.0);
        button7.setPrefWidth(145.0);
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
        button7.setStyle(buttonStyle);
        button7.setTextFill(Color.rgb(57,115,157));

        Button button8 = new Button();
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(50.0);
        button8.setPrefWidth(145.0);
        button8.setText("Back");
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAdminPanelScreen(primaryStage);
            }
        });
        button8.setStyle(buttonStyle);
        button8.setTextFill(Color.rgb(57,115,157));

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

        Label restaurantNameLabel = new Label("Restaurant Name");
        restaurantNameLabel.setLayoutX(25.0);
        restaurantNameLabel.setLayoutY(50.0);
        restaurantNameLabel.setFont(new Font(20.0));

        Label restaurantRatingLabel = new Label("Restaurant rating");
        restaurantRatingLabel.setLayoutX(25.0);
        restaurantRatingLabel.setLayoutY(100.0);
        restaurantRatingLabel.setPrefHeight(20.0);
        restaurantRatingLabel.setPrefWidth(100.0);

        Label restaurantLocationLabel = new Label("Restaurant location");
        restaurantLocationLabel.setLayoutX(200.0);
        restaurantLocationLabel.setLayoutY(100.0);
        restaurantLocationLabel.setPrefHeight(20.0);
        restaurantLocationLabel.setPrefWidth(105.0);

        Label notificationLabel = new Label("Please set your location and foodtype first !!!");
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

        Scene scene = new Scene(pane8, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadMenuScreenForAdmin(Stage primaryStage) {
        Pane pane9 = new Pane();

        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefHeight(250.0);
        listView.setPrefWidth(375.0);
        pane9.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25.0);
        textField.setLayoutY(125.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(150.0);
        pane9.getChildren().add(textField);
        textField.setPromptText("food ID");

        Label label1 = new Label();
        label1.setLayoutX(25.0);
        label1.setLayoutY(100.0);
        label1.setText("please enter food ID");
        pane9.getChildren().add(label1);

        Button button1 = new Button();
        button1.setLayoutX(25.0);
        button1.setLayoutY(165.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(20.0);
        button1.setPrefWidth(150.0);
        button1.setText("Select");
        pane9.getChildren().add(button1);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });
        button1.setStyle(buttonStyle);
        button1.setTextFill(Color.rgb(57,115,157));

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
        button2.setText("Add new food");
        pane9.getChildren().add(button2);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddFoodScreen(primaryStage);
            }
        });
        button2.setStyle(buttonStyle);
        button2.setTextFill(Color.rgb(57,115,157));

        Button button3 = new Button();
        button3.setLayoutX(25.0);
        button3.setLayoutY(245.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(25.0);
        button3.setPrefWidth(150.0);
        button3.setText("Back");
        pane9.getChildren().add(button3);
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        button3.setStyle(buttonStyle);
        button3.setTextFill(Color.rgb(57,115,157));

        Label label3 = new Label("MENU");
        label3.setLayoutX(25.0);
        label3.setLayoutY(35.0);
        label3.setFont(new Font(20.0));
        pane9.getChildren().add(label3);

        Label label4 = new Label("foods must print here with ID");
        label4.setLayoutX(310);
        label4.setLayoutY(195);
        pane9.getChildren().add(label4);

        Scene scene = new Scene(pane9, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCommentsScreen(Stage primaryStage) {
        Pane pane10 = new Pane();

        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefHeight(250.0);
        listView.setPrefWidth(375.0);
        pane10.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25.0);
        textField.setLayoutY(165.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(150.0);
        textField.setPromptText("comment ID");
        pane10.getChildren().add(textField);

        Label label1 = new Label();
        label1.setLayoutX(25.0);
        label1.setLayoutY(140.0);
        label1.setText("to add or edit its response");
        pane10.getChildren().add(label1);

        Button addButton = new Button();
        addButton.setLayoutX(25.0);
        addButton.setLayoutY(205.0);
        addButton.setPrefHeight(20.0);
        addButton.setPrefWidth(150.0);
        addButton.setText("Add new response");
        pane10.getChildren().add(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddResponseScreen(primaryStage);
            }
        });
        addButton.setStyle(buttonStyle);
        addButton.setTextFill(Color.rgb(57,115,157));

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
        pane10.getChildren().add(editButton);
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditResponseScreen(primaryStage);
            }
        });
        editButton.setStyle(buttonStyle);
        editButton.setTextFill(Color.rgb(57,115,157));

        Label label3 = new Label();
        label3.setLayoutX(271.0);
        label3.setLayoutY(192.0);
        label3.setText("comment must print here with ID and userID");
        pane10.getChildren().add(label3);

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
        pane10.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane10, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOpenOrderScreen(Stage primaryStage) {
        Pane pane11 = new Pane();

        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(75.0);
        listView.setPrefHeight(250.0);
        listView.setPrefWidth(375.0);
        pane11.getChildren().add(listView);

        TextField textField = new TextField();
        textField.setLayoutX(25.0);
        textField.setLayoutY(165.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(150.0);
        textField.setPromptText("order ID");
        pane11.getChildren().add(textField);

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

        Button editOrderButton = new Button();
        editOrderButton.setLayoutX(25.0);
        editOrderButton.setLayoutY(205.0);
        editOrderButton.setMnemonicParsing(false);
        editOrderButton.setPrefHeight(25.0);
        editOrderButton.setPrefWidth(150.0);
        editOrderButton.setText("Edit order");
        pane11.getChildren().add(editOrderButton);
        editOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditOrderScreen(primaryStage);
            }
        });
        editOrderButton.setStyle(buttonStyle);
        editOrderButton.setTextFill(Color.rgb(57,115,157));

        Label label3 = new Label();
        label3.setLayoutX(215.0);
        label3.setLayoutY(197.0);
        label3.setText("active orders must print here with ID and userID and restaurantID");
        pane11.getChildren().add(label3);

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
        pane11.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane11, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderHistoryForAdminScreen(Stage primaryStage) {
        Pane pane12 = new Pane();

        Label titleLabel = new Label("SHOW ORDER HISTORY");
        titleLabel.setLayoutX(50.0);
        titleLabel.setLayoutY(40.0);
        titleLabel.setFont(new Font(20.0));

        ListView<String> orderListView = new ListView<>();
        orderListView.setLayoutX(50.0);
        orderListView.setLayoutY(80.0);
        orderListView.setPrefHeight(275.0);
        orderListView.setPrefWidth(500.0);

        Label orderDetailsLabel = new Label("order details must print here");
        orderDetailsLabel.setContentDisplay(ContentDisplay.CENTER);
        orderDetailsLabel.setLayoutX(224.0);
        orderDetailsLabel.setLayoutY(209.0);

        Button backButton = new Button("Back");
        backButton.setLayoutX(470);
        backButton.setLayoutY(42);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane12.getChildren().addAll(titleLabel, orderListView, orderDetailsLabel, backButton);

        Scene scene = new Scene(pane12, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order History");
        primaryStage.show();
    }

    public void loadShowFoodtypeScreen(Stage primaryStage) {
        Pane pane13 = new Pane();

        Label label = new Label("Foodtype");
        label.setLayoutX(50.0);
        label.setLayoutY(60.0);
        label.setFont(new Font(20.0));

        ListView<String> listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(55.0);
        listView.setPrefHeight(200.0);
        listView.setPrefWidth(300.0);

        Button backButton = new Button("Back");
        backButton.setLayoutX(50.0);
        backButton.setLayoutY(109.0);
        backButton.setPrefHeight(20.0);
        backButton.setPrefWidth(85.0);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane13.getChildren().addAll(label, listView, backButton);

        Scene scene = new Scene(pane13, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditFoodtypeScreen(Stage primaryStage) {
        Pane pane14 = new Pane();

        Label label1 = new Label();
        label1.setLayoutX(50.0);
        label1.setLayoutY(60.0);
        label1.setText("EDIT FOODTYPE");
        label1.setFont(new Font(20.0));
        pane14.getChildren().add(label1);

        Label label2 = new Label();
        label2.setLayoutX(50.0);
        label2.setLayoutY(110.0);
        label2.setText("Enter the number of foodtype that you want");
        pane14.getChildren().add(label2);

        TextField textField = new TextField();
        textField.setLayoutX(50.0);
        textField.setLayoutY(140.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(300.0);
        textField.setPromptText("foodtype1, foodtype2, ...");
        pane14.getChildren().add(textField);

        Label label3 = new Label();
        label3.setLayoutX(50.0);
        label3.setLayoutY(225.0);
        pane14.getChildren().add(label3);
        label3.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button();
        confirmButton.setLayoutX(50.0);
        confirmButton.setLayoutY(185.0);
        confirmButton.setPrefWidth(100.0);
        confirmButton.setText("Confirm");
        pane14.getChildren().add(confirmButton);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label3.setText("New foodtypes successfully confirmed !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button();
        backButton.setLayoutX(180.0);
        backButton.setLayoutY(185.0);
        backButton.setPrefWidth(100.0);
        backButton.setText("Back");
        pane14.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane14, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditLocationForAdminScreen(Stage primaryStage) {
        Pane pane15 = new Pane();

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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(50.0);
        notifLabel.setLayoutY(225.0);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane15.getChildren().add(notifLabel);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(50);
        confirmButton.setLayoutY(185);
        confirmButton.setPrefSize(80, 20);
        pane15.getChildren().add(confirmButton);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("New location successfully confirmed !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(185);
        backButton.setPrefSize(80, 20);
        pane15.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane15, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddFoodScreen(Stage primaryStage) {
        Pane pane16 = new Pane();

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

        TextField foodPriceField = new TextField();
        foodPriceField.setLayoutX(285);
        foodPriceField.setLayoutY(170);
        foodPriceField.setPrefWidth(190);
        foodPriceField.setPromptText("food price");
        pane16.getChildren().add(foodPriceField);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(260);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane16.getChildren().add(notifLabel);

        Button addButton = new Button("Add");
        addButton.setLayoutX(75);
        addButton.setLayoutY(220);
        addButton.setPrefWidth(80);
        pane16.getChildren().add(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Food successfully added to the menu !!!");
            }
        });
        addButton.setStyle(buttonStyle);
        addButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(185);
        backButton.setLayoutY(220);
        backButton.setPrefWidth(80);
        pane16.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuScreenForAdmin(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane16, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadFoodScreen(Stage primaryStage) {
        Pane pane17 = new Pane();

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
        editBtn.setStyle(buttonStyle);
        editBtn.setTextFill(Color.rgb(57,115,157));

        Button activeBtn = new Button("Active");
        activeBtn.setFont(new Font(15));
        activeBtn.setPrefSize(145, 50);
        GridPane.setHalignment(activeBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(activeBtn, javafx.geometry.VPos.CENTER);
        activeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadActivateFoodScreen(primaryStage);
            }
        });
        activeBtn.setStyle(buttonStyle);
        activeBtn.setTextFill(Color.rgb(57,115,157));

        Button discountBtn = new Button("Discount");
        discountBtn.setFont(new Font(15));
        discountBtn.setPrefSize(145, 50);
        GridPane.setHalignment(discountBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(discountBtn, javafx.geometry.VPos.CENTER);
        discountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDiscountScreen(primaryStage);
            }
        });
        discountBtn.setStyle(buttonStyle);
        discountBtn.setTextFill(Color.rgb(57,115,157));

        Button deactiveBtn = new Button("Deactive");
        deactiveBtn.setFont(new Font(15));
        deactiveBtn.setPrefSize(145, 50);
        GridPane.setHalignment(deactiveBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(deactiveBtn, javafx.geometry.VPos.CENTER);
        deactiveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeactivateFoodScreen(primaryStage);
            }
        });
        deactiveBtn.setStyle(buttonStyle);
        deactiveBtn.setTextFill(Color.rgb(57,115,157));

        Button deleteBtn = new Button("Delete");
        deleteBtn.setFont(new Font(15));
        deleteBtn.setPrefSize(145, 50);
        GridPane.setHalignment(deleteBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(deleteBtn, javafx.geometry.VPos.CENTER);
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeleteFoodScreen(primaryStage);
            }
        });
        deleteBtn.setStyle(buttonStyle);
        deleteBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setFont(new Font(15));
        backBtn.setPrefSize(145, 50);
        GridPane.setHalignment(backBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(backBtn, javafx.geometry.VPos.CENTER);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuScreenForAdmin(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

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

        Label foodNameLbl = new Label("Food Name");
        foodNameLbl.setFont(new Font(20));
        Label foodRatingLbl = new Label("Food rating ");

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
        Scene scene = new Scene(pane17, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditFoodScreen(Stage primaryStage) {
        Pane pane18 = new Pane();

        Label labelEditFood = new Label("Edit Food");
        labelEditFood.setLayoutX(75.0);
        labelEditFood.setLayoutY(60.0);
        labelEditFood.setFont(new Font(20.0));

        Label labelCurrentName = new Label("current name : name");
        labelCurrentName.setLayoutX(75.0);
        labelCurrentName.setLayoutY(175.0);

        Label labelCurrentPrice = new Label("current price : price");
        labelCurrentPrice.setLayoutX(75.0);
        labelCurrentPrice.setLayoutY(215.0);

        TextField textFieldNewName = new TextField();
        textFieldNewName.setLayoutX(350.0);
        textFieldNewName.setLayoutY(173.0);
        textFieldNewName.setPrefWidth(200.0);
        textFieldNewName.setPromptText("new name");

        TextField textFieldNewPrice = new TextField();
        textFieldNewPrice.setLayoutX(350.0);
        textFieldNewPrice.setLayoutY(213.0);
        textFieldNewPrice.setPrefWidth(200.0);
        textFieldNewPrice.setPromptText("new price");

        Label labelInstruction = new Label("You can enter new name and price on the fields and click confirm to set");
        labelInstruction.setLayoutX(75.0);
        labelInstruction.setLayoutY(125.0);

        Button buttonConfirm = new Button("Confirm");
        buttonConfirm.setLayoutX(350.0);
        buttonConfirm.setLayoutY(270.0);
        buttonConfirm.setPrefSize(80, 20);
        buttonConfirm.setStyle(buttonStyle);
        buttonConfirm.setTextFill(Color.rgb(57,115,157));

        Button buttonBack = new Button("Back");
        buttonBack.setLayoutX(470.0);
        buttonBack.setLayoutY(270.0);
        buttonBack.setPrefSize(80, 20);
        buttonBack.setStyle(buttonStyle);
        buttonBack.setTextFill(Color.rgb(57,115,157));
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });

        pane18.getChildren().addAll(labelEditFood, labelCurrentName, labelCurrentPrice, textFieldNewName,
                textFieldNewPrice, labelInstruction, buttonConfirm, buttonBack);

        Scene scene = new Scene(pane18, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDiscountScreen(Stage primaryStage) {
        Pane pane19 = new Pane();

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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(250);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(210.0);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Discount successfully confirmed !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(195.0);
        backButton.setLayoutY(210.0);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));


        pane19.getChildren().addAll(discountLabel, questionLabel, notifLabel, discountTextField, confirmButton, backButton);

        Scene scene = new Scene(pane19, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDeleteFoodScreen(Stage primaryStage) {
        Pane pane20 = new Pane();

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

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(175.0);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Food successfully deleted !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(170.0);
        backButton.setLayoutY(175.0);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        RadioButton yesRadioButton = new RadioButton("Yes");
        yesRadioButton.setLayoutX(300.0);
        yesRadioButton.setLayoutY(130.0);

        RadioButton noRadioButton = new RadioButton("No");
        noRadioButton.setLayoutX(351.0);
        noRadioButton.setLayoutY(130.0);

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(toggleGroup);
        noRadioButton.setToggleGroup(toggleGroup);

        pane20.getChildren().addAll(label1, label2, notifLabel, confirmButton, backButton, yesRadioButton, noRadioButton);

        Scene scene = new Scene(pane20, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadActivateFoodScreen(Stage primaryStage) {
        Pane pane21 = new Pane();

        Label activeLabel = new Label("Active");
        activeLabel.setLayoutX(75);
        activeLabel.setLayoutY(60);
        activeLabel.setFont(new Font(20));

        Label promptLabel = new Label("Do you want to active this food?");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(130);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(175);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(175);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        RadioButton yesRadioButton = new RadioButton("Yes");
        yesRadioButton.setLayoutX(300);
        yesRadioButton.setLayoutY(130);

        RadioButton noRadioButton = new RadioButton("No");
        noRadioButton.setLayoutX(351);
        noRadioButton.setLayoutY(130);

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(toggleGroup);
        noRadioButton.setToggleGroup(toggleGroup);

        Label alreadyActiveLabel = new Label("This food is already active !!!");
        alreadyActiveLabel.setLayoutX(75);
        alreadyActiveLabel.setLayoutY(230);
        alreadyActiveLabel.setTextFill(javafx.scene.paint.Color.RED);
        alreadyActiveLabel.setFont(new Font(10));

        pane21.getChildren().addAll(activeLabel, promptLabel, confirmButton,
                backButton, yesRadioButton, noRadioButton, alreadyActiveLabel);

        Scene scene = new Scene(pane21, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDeactivateFoodScreen(Stage primaryStage) {
        Pane pane22 = new Pane();

        Label deactiveLabel = new Label("Deactive");
        deactiveLabel.setLayoutX(75);
        deactiveLabel.setLayoutY(60);
        deactiveLabel.setFont(new Font(20));

        Label promptLabel = new Label("Do you want to deactive this food?");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(130);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(175);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(175);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        RadioButton yesRadioButton = new RadioButton("Yes");
        yesRadioButton.setLayoutX(300);
        yesRadioButton.setLayoutY(130);

        RadioButton noRadioButton = new RadioButton("No");
        noRadioButton.setLayoutX(351);
        noRadioButton.setLayoutY(130);

        ToggleGroup toggleGroup = new ToggleGroup();
        yesRadioButton.setToggleGroup(toggleGroup);
        noRadioButton.setToggleGroup(toggleGroup);

        Label alreadyDeactiveLabel = new Label("This food is already deactive !!!");
        alreadyDeactiveLabel.setLayoutX(75);
        alreadyDeactiveLabel.setLayoutY(230);
        alreadyDeactiveLabel.setTextFill(javafx.scene.paint.Color.RED);
        alreadyDeactiveLabel.setFont(new Font(10));

        pane22.getChildren().addAll(deactiveLabel, promptLabel, confirmButton,
                backButton, yesRadioButton, noRadioButton, alreadyDeactiveLabel);

        Scene scene = new Scene(pane22, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditOrderScreen(Stage primaryStage) {
        Pane pane23 = new Pane();

        Label editOrderLabel = new Label("Edit Order");
        editOrderLabel.setLayoutX(75);
        editOrderLabel.setLayoutY(60);
        editOrderLabel.setFont(new Font(20));

        Label currentDeliveryTimeLabel = new Label("Current delivery time : delivery time");
        currentDeliveryTimeLabel.setLayoutX(75);
        currentDeliveryTimeLabel.setLayoutY(175);

        TextField newDeliveryTimeTextField = new TextField();
        newDeliveryTimeTextField.setLayoutX(75);
        newDeliveryTimeTextField.setLayoutY(215);
        newDeliveryTimeTextField.setPrefWidth(200);
        newDeliveryTimeTextField.setPromptText("new delivery time");

        Label promptLabel = new Label("You can enter new details for the orders on the fields and click confirm to set");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(125);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(270);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(195);
        backButton.setLayoutY(270);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOpenOrderScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        TextField newStatusTextField = new TextField();
        newStatusTextField.setLayoutX(329);
        newStatusTextField.setLayoutY(215);
        newStatusTextField.setPrefWidth(200);
        newStatusTextField.setPromptText("new status");

        Label currentOrderStatusLabel = new Label("Current order status : order status");
        currentOrderStatusLabel.setLayoutX(329);
        currentOrderStatusLabel.setLayoutY(175);

        pane23.getChildren().addAll(editOrderLabel, currentDeliveryTimeLabel, newDeliveryTimeTextField,
                promptLabel, confirmButton, backButton, newStatusTextField, currentOrderStatusLabel);

        Scene scene = new Scene(pane23, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddResponseScreen(Stage primaryStage) {
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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(270);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button addButton = new Button("Add");
        addButton.setLayoutX(75);
        addButton.setLayoutY(220);
        addButton.setPrefSize(80, 20);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("New response successdully added !!!");
            }
        });
        addButton.setStyle(buttonStyle);
        addButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(185);
        backButton.setLayoutY(220);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane24.getChildren().addAll(addNewResponseLabel, promptLabel, notifLabel, newResponseTextField, addButton, backButton);

        Scene scene = new Scene(pane24, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditResponseScreen(Stage primaryStage) {
        Pane pane25 = new Pane();

        Label editResponseLabel = new Label("Edit Response");
        editResponseLabel.setLayoutX(75);
        editResponseLabel.setLayoutY(60);
        editResponseLabel.setFont(new Font(20));

        Label currentResponseLabel = new Label("current response : response");
        currentResponseLabel.setLayoutX(75);
        currentResponseLabel.setLayoutY(175);

        TextField newResponseTextField = new TextField();
        newResponseTextField.setLayoutX(75);
        newResponseTextField.setLayoutY(215);
        newResponseTextField.setPrefWidth(200);
        newResponseTextField.setPromptText("new response");

        Label promptLabel = new Label("You can enter new response on the fields and click confirm to set");
        promptLabel.setLayoutX(75);
        promptLabel.setLayoutY(125);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75);
        confirmButton.setLayoutY(270);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(195);
        backButton.setLayoutY(270);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane25.getChildren().addAll(editResponseLabel, currentResponseLabel, newResponseTextField,
                promptLabel, confirmButton, backButton);

        Scene scene = new Scene(pane25, 600, 400);

        primaryStage.setTitle("My Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddRestaurantScreen(Stage primaryStage) {
        Pane pane26 = new Pane();

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

        Label successLabel = new Label();
        successLabel.setLayoutX(75.0);
        successLabel.setLayoutY(270.0);
        successLabel.setTextFill(javafx.scene.paint.Color.RED);
        successLabel.setFont(new Font(10.0));

        Button addButton = new Button("Add");
        addButton.setLayoutX(75.0);
        addButton.setLayoutY(220.0);
        addButton.setPrefSize(80, 20);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                successLabel.setText("Restaurant added to the panel successfully !!!");
            }
        });
        addButton.setStyle(buttonStyle);
        addButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(185.0);
        backButton.setLayoutY(220.0);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAdminPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane26.getChildren().addAll(titleLabel, infoLabel, restaurantNameField, addButton, backButton, successLabel);

        Scene scene = new Scene(pane26, 600, 400);

        primaryStage.setTitle("Add Restaurant");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRestaurantListForUserScreen(Stage primaryStage) {
        Pane pane27 = new Pane();

        ListView<String> restaurantListView = new ListView<>();
        restaurantListView.setLayoutX(200.0);
        restaurantListView.setLayoutY(75.0);
        restaurantListView.setPrefWidth(375.0);
        restaurantListView.setPrefHeight(250.0);

        TextField restaurantIdField = new TextField();
        restaurantIdField.setLayoutX(25.0);
        restaurantIdField.setLayoutY(125.0);
        restaurantIdField.setPrefWidth(150.0);
        restaurantIdField.setPrefHeight(25.0);
        restaurantIdField.setPromptText("restaurant ID");

        Label restaurantIdLabel = new Label("please enter restaurant ID");
        restaurantIdLabel.setLayoutX(25.0);
        restaurantIdLabel.setLayoutY(100.0);

        Button selectButton = new Button("Select");
        selectButton.setLayoutX(25.0);
        selectButton.setLayoutY(155.0);
        selectButton.setPrefWidth(150.0);
        selectButton.setPrefHeight(20.0);
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });
        selectButton.setStyle(buttonStyle);
        selectButton.setTextFill(Color.rgb(57,115,157));

        Button searchButton = new Button("Search");
        searchButton.setLayoutX(25.0);
        searchButton.setLayoutY(268.0);
        searchButton.setPrefWidth(150.0);
        searchButton.setPrefHeight(25.0);
        searchButton.setStyle(buttonStyle);
        searchButton.setTextFill(Color.rgb(57,115,157));

        Button suggestButton = new Button("Show suggested restaurant");
        suggestButton.setLayoutX(25.0);
        suggestButton.setLayoutY(185.0);
        suggestButton.setPrefWidth(150.0);
        suggestButton.setPrefHeight(25.0);
        suggestButton.setStyle(buttonStyle);
        suggestButton.setTextFill(Color.rgb(57,115,157));


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
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        TextField restaurantNameField = new TextField();
        restaurantNameField.setLayoutX(26.0);
        restaurantNameField.setLayoutY(235.0);
        restaurantNameField.setPromptText("restaurant name");

        Separator separator = new Separator();
        separator.setLayoutX(25.0);
        separator.setLayoutY(223.0);
        separator.setPrefWidth(150.0);

        pane27.getChildren().addAll(restaurantListView, restaurantIdField, restaurantIdLabel, selectButton,
                restaurantListLabel, suggestButton, backButton, restaurantNameField,
                separator, searchButton);

        Scene scene = new Scene(pane27, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadUserPanelScreen(Stage primaryStage) {
        Pane pane28 = new Pane();

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
        GridPane.setHalignment(restaurantListButton, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(restaurantListButton, javafx.geometry.VPos.CENTER);
        restaurantListButton.setFont(new Font(15.0));
        restaurantListButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantListForUserScreen(primaryStage);
            }
        });
        restaurantListButton.setStyle(buttonStyle);
        restaurantListButton.setTextFill(Color.rgb(57,115,157));

        Button cartStatusButton = new Button("Cart status");
        cartStatusButton.setMnemonicParsing(false);
        cartStatusButton.setPrefHeight(50.0);
        cartStatusButton.setPrefWidth(145.0);
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
        cartStatusButton.setStyle(buttonStyle);
        cartStatusButton.setTextFill(Color.rgb(57,115,157));

        Button orderHistoryButton = new Button("Order history");
        orderHistoryButton.setMnemonicParsing(false);
        orderHistoryButton.setPrefHeight(50.0);
        orderHistoryButton.setPrefWidth(145.0);
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
        orderHistoryButton.setStyle(buttonStyle);
        orderHistoryButton.setTextFill(Color.rgb(57,115,157));

        Button chargeAccountButton = new Button("Charge account");
        chargeAccountButton.setMnemonicParsing(false);
        chargeAccountButton.setPrefHeight(50.0);
        chargeAccountButton.setPrefWidth(145.0);
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
        chargeAccountButton.setStyle(buttonStyle);
        chargeAccountButton.setTextFill(Color.rgb(57,115,157));

        Button editLocationButton = new Button("Edit location");
        editLocationButton.setMnemonicParsing(false);
        editLocationButton.setPrefHeight(50.0);
        editLocationButton.setPrefWidth(145.0);
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
        editLocationButton.setStyle(buttonStyle);
        editLocationButton.setTextFill(Color.rgb(57,115,157));

        Button logoutButton = new Button("LOGOUT");
        logoutButton.setMnemonicParsing(false);
        logoutButton.setPrefHeight(50.0);
        logoutButton.setPrefWidth(145.0);
        GridPane.setColumnIndex(logoutButton, 2);
        GridPane.setHalignment(logoutButton, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(logoutButton, 1);
        GridPane.setValignment(logoutButton, javafx.geometry.VPos.CENTER);
        logoutButton.setFont(new Font(15.0));
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });
        logoutButton.setStyle(buttonStyle);
        logoutButton.setTextFill(Color.rgb(57,115,157));

        gridPane.getChildren().addAll(restaurantListButton, cartStatusButton, orderHistoryButton,
                chargeAccountButton, editLocationButton, logoutButton);

        Separator separator1 = new Separator();
        separator1.setLayoutX(25.0);
        separator1.setLayoutY(160.0);
        separator1.setPrefWidth(550.0);
        separator1.setPrefHeight(10.0);

        Label userPanelLabel = new Label("User Panel");
        userPanelLabel.setLayoutX(40.0);
        userPanelLabel.setLayoutY(50.0);
        userPanelLabel.setFont(new Font(20.0));

        Label userChargeLabel = new Label("User account charge");
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

        Label userLocationLabel = new Label("User location");
        userLocationLabel.setLayoutX(228.0);
        userLocationLabel.setLayoutY(100.0);
        userLocationLabel.setPrefWidth(145.0);

        Label setLocationLabel = new Label("Please set your location first !!!");
        setLocationLabel.setLayoutX(40.0);
        setLocationLabel.setLayoutY(130.0);
        setLocationLabel.setPrefWidth(300.0);
        setLocationLabel.setTextFill(javafx.scene.paint.Color.RED);
        setLocationLabel.setFont(new Font(10.0));

        pane28.getChildren().addAll(gridPane, separator1, userPanelLabel, userChargeLabel, separator2,
                logoImage, logoLabel, userLocationLabel, setLocationLabel);

        Scene scene = new Scene(pane28, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderHistoryForUserScreen(Stage primaryStage) {
        Pane pane29 = new Pane();

        ListView<String> orderListView = new ListView<>();
        orderListView.setLayoutX(200.0);
        orderListView.setLayoutY(75.0);
        orderListView.setPrefWidth(375.0);
        orderListView.setPrefHeight(250.0);

        TextField orderTextField = new TextField();
        orderTextField.setLayoutX(25.0);
        orderTextField.setLayoutY(125.0);
        orderTextField.setPrefWidth(150.0);
        orderTextField.setPrefHeight(25.0);
        orderTextField.setPromptText("order ID");

        Label orderLabel = new Label("please enter order ID");
        orderLabel.setLayoutX(25.0);
        orderLabel.setLayoutY(100.0);

        Button selectButton = new Button("Select");
        selectButton.setLayoutX(25.0);
        selectButton.setLayoutY(165.0);
        selectButton.setMnemonicParsing(false);
        selectButton.setPrefWidth(150.0);
        selectButton.setPrefHeight(20.0);
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderDetailsForUserScreen(primaryStage);
            }
        });
        selectButton.setStyle(buttonStyle);
        selectButton.setTextFill(Color.rgb(57,115,157));

        Label orderDetailsLabel = new Label("order details must print here");
        orderDetailsLabel.setLayoutX(312.0);
        orderDetailsLabel.setLayoutY(192.0);

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(201.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Label orderHistoryLabel = new Label("Order History");
        orderHistoryLabel.setLayoutX(25.0);
        orderHistoryLabel.setLayoutY(31.0);
        orderHistoryLabel.setFont(new Font(20.0));

        pane29.getChildren().addAll(orderListView, orderTextField, orderLabel, selectButton, orderDetailsLabel,
                backButton, orderHistoryLabel);

        Scene scene = new Scene(pane29, 600, 400);

        primaryStage.setTitle("Order History");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderDetailsForUserScreen(Stage primaryStage) {
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

        Label orderDetailsPrintLabel = new Label("order details must print here");
        orderDetailsPrintLabel.setLayoutX(224.0);
        orderDetailsPrintLabel.setLayoutY(209.0);

        Button showPathButton = new Button("Show Path");
        showPathButton.setLayoutX(290.0);
        showPathButton.setLayoutY(42.0);
        showPathButton.setMnemonicParsing(false);
        showPathButton.setPrefWidth(80.0);
        showPathButton.setStyle(buttonStyle);
        showPathButton.setTextFill(Color.rgb(57,115,157));

        Button showTimeButton = new Button("Show estimated delivery time");
        showTimeButton.setLayoutX(380.0);
        showTimeButton.setLayoutY(42.0);
        showTimeButton.setMnemonicParsing(false);
        showTimeButton.setPrefWidth(80.0);
        showTimeButton.setStyle(buttonStyle);
        showTimeButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(470.0);
        backButton.setLayoutY(42.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(80.0);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderHistoryForUserScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane30.getChildren().addAll(orderDetailsLabel, orderDetailsListView, orderDetailsPrintLabel, backButton, showPathButton, showTimeButton);

        Scene scene = new Scene(pane30, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditLocationForUserScreen(Stage primaryStage) {
        Pane pane31 = new Pane();

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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(50.0);
        notifLabel.setLayoutY(225.0);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);
        pane31.getChildren().add(notifLabel);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(50);
        confirmButton.setLayoutY(185);
        confirmButton.setPrefSize(80, 20);
        pane31.getChildren().add(confirmButton);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("New location successfully confirmed !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(170);
        backButton.setLayoutY(185);
        backButton.setPrefSize(80, 20);
        pane31.getChildren().add(backButton);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Scene scene = new Scene(pane31, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadChargeAccountScreen(Stage primaryStage) {
        Pane pane32 = new Pane();

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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(250);
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(210.0);
        confirmButton.setPrefSize(80, 20);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Account charged successfully !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(195.0);
        backButton.setLayoutY(210.0);
        backButton.setPrefSize(80, 20);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane32.getChildren().addAll(discountLabel, questionLabel, notifLabel, discountTextField, confirmButton, backButton);

        Scene scene = new Scene(pane32, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCartStatusScreen(Stage primaryStage) {
        Pane pane33 = new Pane();

        Label userCartLabel = new Label("User Cart");
        userCartLabel.setLayoutX(25.0);
        userCartLabel.setLayoutY(35.0);
        userCartLabel.setFont(new Font(20.0));

        ListView<String> orderListView = new ListView<>();
        orderListView.setLayoutX(200.0);
        orderListView.setLayoutY(75.0);
        orderListView.setPrefWidth(375.0);
        orderListView.setPrefHeight(250.0);

        Label orderIdLabel = new Label("please enter order ID");
        orderIdLabel.setLayoutX(25.0);
        orderIdLabel.setLayoutY(100.0);

        TextField orderIdTextField = new TextField();
        orderIdTextField.setLayoutX(25.0);
        orderIdTextField.setLayoutY(130.0);
        orderIdTextField.setPrefWidth(150.0);
        orderIdTextField.setPrefHeight(25.0);
        orderIdTextField.setPromptText("order ID");

        Button editButton = new Button("Edit");
        editButton.setLayoutX(25.0);
        editButton.setLayoutY(165.0);
        editButton.setPrefWidth(150.0);
        editButton.setPrefHeight(20.0);
        editButton.setMnemonicParsing(false);
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderDetailsInCartForUserScreen(primaryStage);
            }
        });
        editButton.setStyle(buttonStyle);
        editButton.setTextFill(Color.rgb(57,115,157));

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
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(235.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setMnemonicParsing(false);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadUserPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Label orderPrintLabel = new Label("orders must print here with orderID and orderedRestaurant");
        orderPrintLabel.setLayoutX(231.0);
        orderPrintLabel.setLayoutY(192.0);

        pane33.getChildren().addAll(userCartLabel, orderListView, orderIdLabel, orderIdTextField, editButton, toSeeOrdersLabel, confirmButton, backButton, orderPrintLabel);

        Scene scene = new Scene(pane33, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadOrderDetailsInCartForUserScreen(Stage primaryStage) {
        Pane pane34 = new Pane();

        Label orderLabel = new Label("Order");
        orderLabel.setLayoutX(35.0);
        orderLabel.setLayoutY(60.0);
        orderLabel.setFont(new Font(20.0));

        Label orderedRestaurantLabel = new Label("orderedRestaurant");
        orderedRestaurantLabel.setLayoutX(200.0);
        orderedRestaurantLabel.setLayoutY(65.0);

        ListView<String> orderDetailsListView = new ListView<>();
        orderDetailsListView.setLayoutX(200.0);
        orderDetailsListView.setLayoutY(110.0);
        orderDetailsListView.setPrefWidth(375.0);
        orderDetailsListView.setPrefHeight(200.0);

        Label orderDetailsPrintLabel = new Label("order details must print here with foodID and number of each food");
        orderDetailsPrintLabel.setLayoutX(210.0);
        orderDetailsPrintLabel.setLayoutY(199.0);

        Label orderIdLabel = new Label("please enter order ID");
        orderIdLabel.setLayoutX(25.0);
        orderIdLabel.setLayoutY(130.0);

        TextField foodIdTextField = new TextField();
        foodIdTextField.setLayoutX(25.0);
        foodIdTextField.setLayoutY(160.0);
        foodIdTextField.setPrefWidth(150.0);
        foodIdTextField.setPrefHeight(25.0);
        foodIdTextField.setPromptText("food ID");

        Button editButton = new Button("Edit number of this food");
        editButton.setLayoutX(25.0);
        editButton.setLayoutY(195.0);
        editButton.setPrefWidth(150.0);
        editButton.setPrefHeight(20.0);
        editButton.setMnemonicParsing(false);
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditNumberScreen(primaryStage);
            }
        });
        editButton.setStyle(buttonStyle);
        editButton.setTextFill(Color.rgb(57,115,157));

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
        deleteButton.setStyle(buttonStyle);
        deleteButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(265.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setMnemonicParsing(false);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCartStatusScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Label totalCostLabel = new Label("Total cost : totalCost$");
        totalCostLabel.setLayoutX(200.0);
        totalCostLabel.setLayoutY(335.0);

        pane34.getChildren().addAll(orderLabel, orderedRestaurantLabel, orderDetailsListView, orderDetailsPrintLabel, orderIdLabel, foodIdTextField, editButton, toSeeOrdersLabel, deleteButton, backButton, totalCostLabel);

        Scene scene = new Scene(pane34, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditNumberScreen(Stage primaryStage) {
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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(215);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(75.0);
        confirmButton.setLayoutY(170.0);
        confirmButton.setPrefWidth(80.0);
        confirmButton.setMnemonicParsing(false);
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Successfully confirmed !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(310.0);
        backButton.setLayoutY(170.0);
        backButton.setPrefWidth(80.0);
        backButton.setMnemonicParsing(false);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadOrderDetailsInCartForUserScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        pane35.getChildren().addAll(numberOfFoodLabel, howManyLabel, notifLabel, choiceBox, confirmButton, backButton);

        Scene scene = new Scene(pane35, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadDeliveryPanelScreen(Stage primaryStage){
        Pane pane36 = new Pane();

        Label deliveryPanelLabel = new Label("Delivery Panel");
        deliveryPanelLabel.setLayoutX(40.0);
        deliveryPanelLabel.setLayoutY(50.0);
        deliveryPanelLabel.setFont(new Font(20.0));

        Separator separator1 = new Separator();
        separator1.setLayoutX(25.0);
        separator1.setLayoutY(160.0);
        separator1.setPrefWidth(550.0);
        separator1.setPrefHeight(10.0);

        Label deliveryLocationLabel = new Label("Delivery location");
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
        separator2.setLayoutY(245.0);
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

        Button showOrdersButton = new Button("Show Orders");
        showOrdersButton.setPrefWidth(145.0);
        showOrdersButton.setPrefHeight(50.0);
        showOrdersButton.setFont(new Font(15.0));
        GridPane.setConstraints(showOrdersButton, 0, 0);
        showOrdersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadConfirmOrderForDeliveryScreen(primaryStage);
            }
        });
        showOrdersButton.setStyle(buttonStyle);
        showOrdersButton.setTextFill(Color.rgb(57,115,157));

        Button pathToRestaurantButton = new Button("Path to restaurant");
        pathToRestaurantButton.setPrefWidth(145.0);
        pathToRestaurantButton.setPrefHeight(50.0);
        pathToRestaurantButton.setFont(new Font(15.0));
        GridPane.setConstraints(pathToRestaurantButton, 1, 0);
        pathToRestaurantButton.setStyle(buttonStyle);
        pathToRestaurantButton.setTextFill(Color.rgb(57,115,157));

        Button pathToUserButton = new Button("Path to user");
        pathToUserButton.setPrefWidth(145.0);
        pathToUserButton.setPrefHeight(50.0);
        pathToUserButton.setFont(new Font(15.0));
        GridPane.setConstraints(pathToUserButton, 2, 0);
        pathToUserButton.setStyle(buttonStyle);
        pathToUserButton.setTextFill(Color.rgb(57,115,157));

        Button logoutButton = new Button("LOGOUT");
        logoutButton.setPrefWidth(145.0);
        logoutButton.setPrefHeight(50.0);
        logoutButton.setFont(new Font(15.0));
        GridPane.setConstraints(logoutButton, 3, 0);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadLoginScreen(primaryStage);
            }
        });
        logoutButton.setStyle(buttonStyle);
        logoutButton.setTextFill(Color.rgb(57,115,157));

        gridPane.getChildren().addAll(showOrdersButton, pathToRestaurantButton, pathToUserButton, logoutButton);

        pane36.getChildren().addAll(deliveryPanelLabel, separator1, deliveryLocationLabel, imageView, logoLabel, separator2, gridPane);

        Scene scene = new Scene(pane36, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadConfirmOrderForDeliveryScreen(Stage primaryStage){
        Pane pane37 = new Pane();

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

        Label pleaseEnterOrderIdLabel = new Label("please enter order ID");
        pleaseEnterOrderIdLabel.setLayoutX(25.0);
        pleaseEnterOrderIdLabel.setLayoutY(100.0);

        TextField orderIdTextField = new TextField();
        orderIdTextField.setLayoutX(25.0);
        orderIdTextField.setLayoutY(125.0);
        orderIdTextField.setPrefWidth(150.0);
        orderIdTextField.setPrefHeight(25.0);

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
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                errorLabel1.setText("Order successfully confirmed");
                errorLabel2.setText("for delivering !!!");
            }
        });
        confirmButton.setStyle(buttonStyle);
        confirmButton.setTextFill(Color.rgb(57,115,157));

        Button backButton = new Button("Back");
        backButton.setLayoutX(25.0);
        backButton.setLayoutY(200.0);
        backButton.setPrefWidth(150.0);
        backButton.setPrefHeight(25.0);
        backButton.setMnemonicParsing(false);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDeliveryPanelScreen(primaryStage);
            }
        });
        backButton.setStyle(buttonStyle);
        backButton.setTextFill(Color.rgb(57,115,157));

        Label ordersLabel = new Label("orders that should be delivered must print here with order ID and user location");
        ordersLabel.setLayoutX(213.0);
        ordersLabel.setLayoutY(193.0);
        ordersLabel.setFont(new Font(10.0));

        pane37.getChildren().addAll(confirmOrderLabel, toConfirmLabel, listView, pleaseEnterOrderIdLabel,
                orderIdTextField, confirmButton, backButton, ordersLabel, errorLabel1, errorLabel2);

        Scene scene = new Scene(pane37, 600, 400);

        primaryStage.setTitle("Confirm Order");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRestaurantForUserScreen(Stage primaryStage){
        Pane pane38 = new Pane();

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
        gridPane.add(menuBtn, 0, 0);
        menuBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuForUserScreen(primaryStage);
            }
        });
        menuBtn.setStyle(buttonStyle);
        menuBtn.setTextFill(Color.rgb(57,115,157));

        Button commentsBtn = new Button("Display comments");
        commentsBtn.setPrefSize(130, 50);
        gridPane.add(commentsBtn, 1, 0);
        commentsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForRestaurantForUserScreen(primaryStage);
            }
        });
        commentsBtn.setStyle(buttonStyle);
        commentsBtn.setTextFill(Color.rgb(57,115,157));

        Button ratingsBtn = new Button("Display Ratings");
        ratingsBtn.setPrefSize(130, 50);
        gridPane.add(ratingsBtn, 2, 0);
        ratingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForRestaurantForUserScreen(primaryStage);
            }
        });
        ratingsBtn.setStyle(buttonStyle);
        ratingsBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setPrefSize(130, 50);
        gridPane.add(backBtn, 3, 0);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantListForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Separator separator1 = new Separator();
        separator1.setLayoutX(25);
        separator1.setLayoutY(170);
        separator1.setPrefSize(550, 10);

        Label nameLabel = new Label("Restaurant Name");
        nameLabel.setLayoutX(25);
        nameLabel.setLayoutY(50);
        nameLabel.setFont(new Font(20));

        Label locationLabel = new Label("Restaurant location");
        locationLabel.setLayoutX(25);
        locationLabel.setLayoutY(107);
        locationLabel.setPrefSize(105, 20);

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

        Scene scene = new Scene(pane38, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadMenuForUserScreen(Stage primaryStage){
        Pane pane39 = new Pane();

        ListView<String> foodListView = new ListView<>();
        foodListView.setLayoutX(200);
        foodListView.setLayoutY(75);
        foodListView.setPrefSize(375, 250);

        TextField foodIdTextField = new TextField();
        foodIdTextField.setLayoutX(25);
        foodIdTextField.setLayoutY(130);
        foodIdTextField.setPrefSize(150, 25);
        foodIdTextField.setPromptText("food ID");

        Label foodIdLabel = new Label("please enter food ID");
        foodIdLabel.setLayoutX(25);
        foodIdLabel.setLayoutY(100);

        Button selectBtn = new Button("Select");
        selectBtn.setLayoutX(25);
        selectBtn.setLayoutY(165);
        selectBtn.setPrefSize(150, 20);
        selectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodForUserScreen(primaryStage);
            }
        });
        selectBtn.setStyle(buttonStyle);
        selectBtn.setTextFill(Color.rgb(57,115,157));

        Label foodListLabel = new Label("To see the foods");
        foodListLabel.setLayoutX(25);
        foodListLabel.setLayoutY(75);
        foodListLabel.setPrefSize(150, 25);

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(25);
        backBtn.setLayoutY(200);
        backBtn.setPrefSize(150, 25);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Label selectedFoodLabel = new Label("food must print here with the ID");
        selectedFoodLabel.setLayoutX(302);
        selectedFoodLabel.setLayoutY(192);

        pane39.getChildren().addAll(foodListView, foodIdTextField, foodIdLabel, selectBtn, foodListLabel, backBtn, selectedFoodLabel);

        Scene scene = new Scene(pane39, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadFoodForUserScreen(Stage primaryStage){
        Pane pane40 = new Pane();

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

        Button addToCartBtn = new Button("Add this food to cart");
        addToCartBtn.setPrefSize(130, 50);
        gridPane.add(addToCartBtn, 0, 0);

        Button commentsBtn = new Button("Display comments");
        commentsBtn.setPrefSize(130, 50);
        gridPane.add(commentsBtn, 1, 0);
        commentsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForFoodForUserScreen(primaryStage);
            }
        });
        commentsBtn.setStyle(buttonStyle);
        commentsBtn.setTextFill(Color.rgb(57,115,157));

        Button ratingsBtn = new Button("Display Ratings");
        ratingsBtn.setPrefSize(130, 50);
        gridPane.add(ratingsBtn, 2, 0);
        ratingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForFoodForUserScreen(primaryStage);
            }
        });
        ratingsBtn.setStyle(buttonStyle);
        ratingsBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setPrefSize(130, 50);
        gridPane.add(backBtn, 3, 0);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadMenuForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Separator separator1 = new Separator();
        separator1.setLayoutX(25);
        separator1.setLayoutY(170);
        separator1.setPrefSize(550, 10);

        Label foodNameLabel = new Label("Food Name");
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

        Label foodDetailsLabel = new Label();
        foodDetailsLabel.setLayoutX(45);
        foodDetailsLabel.setLayoutY(133);
        foodDetailsLabel.setPrefWidth(200);

        pane40.getChildren().addAll(gridPane, separator1, foodNameLabel, separator2, logoImg, logoLabel, foodDetailsLabel);

        Scene scene = new Scene(pane40, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCommentsForFoodForUserScreen(Stage primaryStage){
        Pane pane41 = new Pane();

        ListView<String> commentsListView = new ListView<>();
        commentsListView.setLayoutX(200);
        commentsListView.setLayoutY(75);
        commentsListView.setPrefSize(375, 250);

        TextField commentIdTextField = new TextField();
        commentIdTextField.setLayoutX(25);
        commentIdTextField.setLayoutY(145);
        commentIdTextField.setPrefSize(150, 25);
        commentIdTextField.setPromptText("comment ID");

        Button addCommentBtn = new Button("Add new comments");
        addCommentBtn.setLayoutX(25);
        addCommentBtn.setLayoutY(225);
        addCommentBtn.setPrefSize(150, 20);
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddCommentForFoodForUserScreen(primaryStage);
            }
        });
        addCommentBtn.setStyle(buttonStyle);
        addCommentBtn.setTextFill(Color.rgb(57,115,157));

        Label editCommentIdLabel = new Label("Please enter comment ID to edit ");
        editCommentIdLabel.setLayoutX(25);
        editCommentIdLabel.setLayoutY(120);
        editCommentIdLabel.setPrefSize(150, 25);
        editCommentIdLabel.setFont(new Font(10));

        Button editCommentBtn = new Button("Edit comments");
        editCommentBtn.setLayoutX(25);
        editCommentBtn.setLayoutY(185);
        editCommentBtn.setPrefSize(150, 25);
        editCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditCommentForFoodForUserScreen(primaryStage);
            }
        });
        editCommentBtn.setStyle(buttonStyle);
        editCommentBtn.setTextFill(Color.rgb(57,115,157));

        Label selectedCommentLabel = new Label("comment must print here with id and userId");
        selectedCommentLabel.setLayoutX(271);
        selectedCommentLabel.setLayoutY(192);

        Label commentsLabel = new Label("COMMENTS");
        commentsLabel.setLayoutX(25);
        commentsLabel.setLayoutY(80);
        commentsLabel.setFont(new Font(20));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(25);
        backBtn.setLayoutY(265);
        backBtn.setPrefWidth(150);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        pane41.getChildren().addAll(commentsListView, commentIdTextField, addCommentBtn, editCommentIdLabel, editCommentBtn, selectedCommentLabel,
                commentsLabel, backBtn);

        Scene scene = new Scene(pane41, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddCommentForFoodForUserScreen(Stage primaryStage){
        Pane pane42 = new Pane();

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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(260);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button addCommentBtn = new Button("Add");
        addCommentBtn.setLayoutX(75);
        addCommentBtn.setLayoutY(220);
        addCommentBtn.setPrefWidth(80);
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Comments added successfully !!!");
            }
        });
        addCommentBtn.setStyle(buttonStyle);
        addCommentBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(185);
        backBtn.setLayoutY(220);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForFoodForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        pane42.getChildren().addAll(addCommentLabel, enterCommentLabel, notifLabel, newCommentTextField, addCommentBtn, backBtn);

        Scene scene = new Scene(pane42, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditCommentForFoodForUserScreen(Stage primaryStage){
        Pane pane43 = new Pane();

        Label editCommentLabel = new Label("Edit Comment");
        editCommentLabel.setLayoutX(75);
        editCommentLabel.setLayoutY(60);
        editCommentLabel.setFont(new Font(20));

        Label currentCommentLabel = new Label("current comment : comment");
        currentCommentLabel.setLayoutX(75);
        currentCommentLabel.setLayoutY(175);

        TextField newCommentTextField = new TextField();
        newCommentTextField.setLayoutX(75);
        newCommentTextField.setLayoutY(215);
        newCommentTextField.setPrefWidth(200);
        newCommentTextField.setPromptText("new comment");

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
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Comment successfully edited !!!");
                currentCommentLabel.setText("current comment : new comment");
            }
        });
        confirmBtn.setStyle(buttonStyle);
        confirmBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForFoodForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        pane43.getChildren().addAll(editCommentLabel, currentCommentLabel, notifLabel, newCommentTextField, instructionLabel, confirmBtn, backBtn);

        Scene scene = new Scene(pane43, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRatingsForFoodForUserScreen(Stage primaryStage){
        Pane pane44 = new Pane();

        Label addRatingLabel = new Label("ADD NEW RATINGS");
        addRatingLabel.setLayoutX(85);
        addRatingLabel.setLayoutY(70);
        addRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("Restaurant current rating : rating");
        currentRatingLabel.setLayoutX(85);
        currentRatingLabel.setLayoutY(125);

        Button addRatingBtn = new Button("Add new rating");
        addRatingBtn.setLayoutX(85);
        addRatingBtn.setLayoutY(185);
        addRatingBtn.setPrefWidth(100);
        addRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadSubmitRatingForFoodForUserScreen(primaryStage);
            }
        });
        addRatingBtn.setStyle(buttonStyle);
        addRatingBtn.setTextFill(Color.rgb(57,115,157));

        Button editRatingBtn = new Button("Edit rating");
        editRatingBtn.setLayoutX(85);
        editRatingBtn.setLayoutY(220);
        editRatingBtn.setPrefWidth(100);
        editRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditRatingForFoodForUserScreen(primaryStage);
            }
        });
        editRatingBtn.setStyle(buttonStyle);
        editRatingBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(85);
        backBtn.setLayoutY(255);
        backBtn.setPrefWidth(100);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFoodForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        ListView<String> ratingsListView = new ListView<>();
        ratingsListView.setLayoutX(250);
        ratingsListView.setLayoutY(170);
        ratingsListView.setPrefWidth(260);
        ratingsListView.setPrefHeight(150);

        pane44.getChildren().addAll(addRatingLabel, currentRatingLabel, addRatingBtn, editRatingBtn, backBtn, ratingsListView);

        Scene scene = new Scene(pane44, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSubmitRatingForFoodForUserScreen(Stage primaryStage){
        Pane pane45 = new Pane();

        Label addRatingLabel = new Label("ADD NEW RATING");
        addRatingLabel.setLayoutX(75);
        addRatingLabel.setLayoutY(60);
        addRatingLabel.setFont(new Font(20));

        Label instructionLabel = new Label("Please enter your new rating ....");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(210);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button submitBtn = new Button("Submit");
        submitBtn.setLayoutX(75);
        submitBtn.setLayoutY(170);
        submitBtn.setPrefWidth(80);
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Rating submited !!!");
            }
        });
        submitBtn.setStyle(buttonStyle);
        submitBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(178);
        backBtn.setLayoutY(170);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForFoodForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(313);
        ratingSlider.setLayoutY(125);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200,20);

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(330);
        ratingRangeLabel.setLayoutY(143);
        ratingRangeLabel.setFont(new Font(8));

        pane45.getChildren().addAll(addRatingLabel, instructionLabel, notifLabel, submitBtn, backBtn, ratingSlider, ratingRangeLabel);

        Scene scene = new Scene(pane45, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditRatingForFoodForUserScreen(Stage primaryStage){
        Pane pane46 = new Pane();

        Label editRatingLabel = new Label("Edit Rating");
        editRatingLabel.setLayoutX(75);
        editRatingLabel.setLayoutY(60);
        editRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("current rating : rating");
        currentRatingLabel.setLayoutX(75);
        currentRatingLabel.setLayoutY(175);

        Label instructionLabel = new Label("You can enter new rating ...");
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
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Rating successfully edited !!!");
                currentRatingLabel.setText("current rating : new rating");
            }
        });
        confirmBtn.setStyle(buttonStyle);
        confirmBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForFoodForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(75);
        ratingSlider.setLayoutY(220);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200,20);

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(90);
        ratingRangeLabel.setLayoutY(235);
        ratingRangeLabel.setFont(new Font(8));

        pane46.getChildren().addAll(editRatingLabel, currentRatingLabel, instructionLabel, notifLabel, confirmBtn, backBtn, ratingSlider, ratingRangeLabel);

        Scene scene = new Scene(pane46, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadCommentsForRestaurantForUserScreen(Stage primaryStage){
        Pane pane47 = new Pane();

        ListView<String> commentsListView = new ListView<>();
        commentsListView.setLayoutX(200);
        commentsListView.setLayoutY(75);
        commentsListView.setPrefSize(375, 250);

        TextField commentIdTextField = new TextField();
        commentIdTextField.setLayoutX(25);
        commentIdTextField.setLayoutY(145);
        commentIdTextField.setPrefSize(150, 25);
        commentIdTextField.setPromptText("comment ID");

        Button addCommentBtn = new Button("Add new comments");
        addCommentBtn.setLayoutX(25);
        addCommentBtn.setLayoutY(225);
        addCommentBtn.setPrefSize(150, 20);
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadAddCommentForRestaurantForUserScreen(primaryStage);
            }
        });
        addCommentBtn.setStyle(buttonStyle);
        addCommentBtn.setTextFill(Color.rgb(57,115,157));

        Label editCommentIdLabel = new Label("Please enter comment ID to edit ");
        editCommentIdLabel.setLayoutX(25);
        editCommentIdLabel.setLayoutY(120);
        editCommentIdLabel.setPrefSize(150, 25);
        editCommentIdLabel.setFont(new Font(10));

        Button editCommentBtn = new Button("Edit comments");
        editCommentBtn.setLayoutX(25);
        editCommentBtn.setLayoutY(185);
        editCommentBtn.setPrefSize(150, 25);
        editCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditCommentForRestaurantForUserScreen(primaryStage);
            }
        });
        editCommentBtn.setStyle(buttonStyle);
        editCommentBtn.setTextFill(Color.rgb(57,115,157));

        Label selectedCommentLabel = new Label("comment must print here with id and userId");
        selectedCommentLabel.setLayoutX(271);
        selectedCommentLabel.setLayoutY(192);

        Label commentsLabel = new Label("COMMENTS");
        commentsLabel.setLayoutX(25);
        commentsLabel.setLayoutY(80);
        commentsLabel.setFont(new Font(20));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(25);
        backBtn.setLayoutY(265);
        backBtn.setPrefWidth(150);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        pane47.getChildren().addAll(commentsListView, commentIdTextField, addCommentBtn, editCommentIdLabel, editCommentBtn, selectedCommentLabel,
                commentsLabel, backBtn);

        Scene scene = new Scene(pane47, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadAddCommentForRestaurantForUserScreen(Stage primaryStage){
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

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(260);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button addCommentBtn = new Button("Add");
        addCommentBtn.setLayoutX(75);
        addCommentBtn.setLayoutY(220);
        addCommentBtn.setPrefWidth(80);
        addCommentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Comments added successfully !!!");
            }
        });
        addCommentBtn.setStyle(buttonStyle);
        addCommentBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(185);
        backBtn.setLayoutY(220);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        pane48.getChildren().addAll(addCommentLabel, enterCommentLabel, notifLabel, newCommentTextField, addCommentBtn, backBtn);

        Scene scene = new Scene(pane48, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditCommentForRestaurantForUserScreen(Stage primaryStage){
        Pane pane49 = new Pane();

        Label editCommentLabel = new Label("Edit Comment");
        editCommentLabel.setLayoutX(75);
        editCommentLabel.setLayoutY(60);
        editCommentLabel.setFont(new Font(20));

        Label currentCommentLabel = new Label("current comment : comment");
        currentCommentLabel.setLayoutX(75);
        currentCommentLabel.setLayoutY(175);

        TextField newCommentTextField = new TextField();
        newCommentTextField.setLayoutX(75);
        newCommentTextField.setLayoutY(215);
        newCommentTextField.setPrefWidth(200);
        newCommentTextField.setPromptText("new comment");

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
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Comment successfully edited !!!");
                currentCommentLabel.setText("current comment : new comment");
            }
        });
        confirmBtn.setStyle(buttonStyle);
        confirmBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadCommentsForRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        pane49.getChildren().addAll(editCommentLabel, currentCommentLabel, notifLabel, newCommentTextField, instructionLabel, confirmBtn, backBtn);

        Scene scene = new Scene(pane49, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadRatingsForRestaurantForUserScreen(Stage primaryStage){
        Pane pane50 = new Pane();

        Label addRatingLabel = new Label("ADD NEW RATINGS");
        addRatingLabel.setLayoutX(85);
        addRatingLabel.setLayoutY(70);
        addRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("Restaurant current rating : rating");
        currentRatingLabel.setLayoutX(85);
        currentRatingLabel.setLayoutY(125);

        Button addRatingBtn = new Button("Add new rating");
        addRatingBtn.setLayoutX(85);
        addRatingBtn.setLayoutY(185);
        addRatingBtn.setPrefWidth(100);
        addRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadSubmitRatingForRestaurantForUserScreen(primaryStage);
            }
        });
        addRatingBtn.setStyle(buttonStyle);
        addRatingBtn.setTextFill(Color.rgb(57,115,157));

        Button editRatingBtn = new Button("Edit rating");
        editRatingBtn.setLayoutX(85);
        editRatingBtn.setLayoutY(220);
        editRatingBtn.setPrefWidth(100);
        editRatingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadEditRatingForRestaurantForUserScreen(primaryStage);
            }
        });
        editRatingBtn.setStyle(buttonStyle);
        editRatingBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(85);
        backBtn.setLayoutY(255);
        backBtn.setPrefWidth(100);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        ListView<String> ratingsListView = new ListView<>();
        ratingsListView.setLayoutX(250);
        ratingsListView.setLayoutY(170);
        ratingsListView.setPrefWidth(260);
        ratingsListView.setPrefHeight(150);

        pane50.getChildren().addAll(addRatingLabel, currentRatingLabel, addRatingBtn, editRatingBtn, backBtn, ratingsListView);

        Scene scene = new Scene(pane50, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSubmitRatingForRestaurantForUserScreen(Stage primaryStage){
        Pane pane51 = new Pane();

        Label addRatingLabel = new Label("ADD NEW RATING");
        addRatingLabel.setLayoutX(75);
        addRatingLabel.setLayoutY(60);
        addRatingLabel.setFont(new Font(20));

        Label instructionLabel = new Label("Please enter your new rating ....");
        instructionLabel.setLayoutX(75);
        instructionLabel.setLayoutY(125);

        Label notifLabel = new Label();
        notifLabel.setLayoutX(75);
        notifLabel.setLayoutY(210);
        notifLabel.setFont(new Font(10));
        notifLabel.setTextFill(javafx.scene.paint.Color.RED);

        Button submitBtn = new Button("Submit");
        submitBtn.setLayoutX(75);
        submitBtn.setLayoutY(170);
        submitBtn.setPrefWidth(80);
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Rating submited !!!");
            }
        });
        submitBtn.setStyle(buttonStyle);
        submitBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(178);
        backBtn.setLayoutY(170);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(313);
        ratingSlider.setLayoutY(125);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200,20);

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(330);
        ratingRangeLabel.setLayoutY(143);
        ratingRangeLabel.setFont(new Font(8));

        pane51.getChildren().addAll(addRatingLabel, instructionLabel, notifLabel, submitBtn, backBtn, ratingSlider, ratingRangeLabel);

        Scene scene = new Scene(pane51, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadEditRatingForRestaurantForUserScreen(Stage primaryStage){
        Pane pane52 = new Pane();

        Label editRatingLabel = new Label("Edit Rating");
        editRatingLabel.setLayoutX(75);
        editRatingLabel.setLayoutY(60);
        editRatingLabel.setFont(new Font(20));

        Label currentRatingLabel = new Label("current rating : rating");
        currentRatingLabel.setLayoutX(75);
        currentRatingLabel.setLayoutY(175);

        Label instructionLabel = new Label("You can enter new rating ...");
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
        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                notifLabel.setText("Rating successfully edited !!!");
                currentRatingLabel.setText("current rating : new rating");
            }
        });
        confirmBtn.setStyle(buttonStyle);
        confirmBtn.setTextFill(Color.rgb(57,115,157));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(195);
        backBtn.setLayoutY(270);
        backBtn.setPrefWidth(80);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadRatingsForRestaurantForUserScreen(primaryStage);
            }
        });
        backBtn.setStyle(buttonStyle);
        backBtn.setTextFill(Color.rgb(57,115,157));

        Slider ratingSlider = new Slider();
        ratingSlider.setLayoutX(75);
        ratingSlider.setLayoutY(220);
        ratingSlider.setMax(5);
        ratingSlider.setPrefSize(200,20);

        Label ratingRangeLabel = new Label("0 ............... 1 ............... 2 ............... 3 ............... 4 ............... 5");
        ratingRangeLabel.setLayoutX(90);
        ratingRangeLabel.setLayoutY(235);
        ratingRangeLabel.setFont(new Font(8));

        pane52.getChildren().addAll(editRatingLabel, currentRatingLabel, instructionLabel, notifLabel, confirmBtn, backBtn, ratingSlider, ratingRangeLabel);

        Scene scene = new Scene(pane52, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        loadWellcomeScreen(primaryStage);
    }
}