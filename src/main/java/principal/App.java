package principal;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	private Label userLabel, passLabel;
	private TextField userText,monedaText, cambioText;
	private PasswordField passText;
	private ComboBox<String> monedaCombo, cambioCombo;
	private Button loginButton, cambioButton;
	private int posMoneda = 0, posCambio = 0;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		userLabel = new Label("Usuario");
		userLabel.setMinWidth(80);
		
		passLabel = new Label("Contraseña");
		passLabel.setMinWidth(80);
		
		userText = new TextField();
		userText.setPromptText("Nombre del usuario");
		userText.setMaxWidth(80);
		
		passText = new PasswordField();
		passText.setPromptText("Contraseña");
		passText.setMaxWidth(80);
		
		authModeCombo = new ComboBox<String>();
		authModeCombo.getItems().addAll("Cuenta Local", "LDPA", "Base de Datos");
		authModeCombo.setPromptText("Autentificacion");
		
		loginButton = new Button("Acceder");
		loginButton.setDefaultButton(true);
		loginButton.setOnAction(e -> onLoginButtonAction(e));
				
		HBox userBox = new HBox(5, userLabel, userText);
		userBox.setAlignment(Pos.CENTER);		
		
		HBox passBox = new HBox(5, passLabel, passText);
		passBox.setAlignment(Pos.CENTER);
		
		HBox authBox = new HBox(5, monedaCombo, loginButton);
		authBox.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(5, userBox, passBox, authBox);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 320,200);
		
		primaryStage.setTitle("Iniciar Sesion");
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
		monedaText = new TextField();
		monedaText.setPromptText("");
		monedaText.setMaxWidth(80);
		
		monedaCombo = new ComboBox<String>();
		monedaCombo.getItems().addAll("Euro", "Libra", "Dollar", "Yen");
		monedaCombo.setPromptText(monedaCombo.getSelectionModel().getSelectedItem());
		
		cambioText = new TextField();
		cambioText.setPromptText("");
		cambioText.setMaxWidth(80);
		
		cambioCombo = new ComboBox<String>();
		cambioCombo.getItems().addAll("Euro", "Libra", "Dollar", "Yen");
		cambioCombo.setPromptText(cambioCombo.getSelectionModel().getSelectedItem());
		
		cambioButton = new Button("Cambiar");
		cambioButton.setDefaultButton(true);
		cambioButton.setOnAction(e -> onLoginButtonAction(e));
		
		HBox monedaBox = new HBox(5, monedaText, monedaCombo);
		monedaBox.setAlignment(Pos.CENTER);
		
		HBox cambioBox = new HBox(5, cambioText, cambioCombo);
		cambioBox.setAlignment(Pos.CENTER);
		
		HBox button = new HBox(5, cambioButton);
		button.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(5, monedaBox, cambioBox, button);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 320,200);
		
		primaryStage.setTitle("Iniciar Sesion");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void onLoginButtonAction(ActionEvent e) {
		String entrada;
		String moneda;
		double numero;
		entrada = monedaText.getText().toString();
		numero = Double.parseDouble(entrada);
		moneda = monedaCombo.getValue();/*
		Divisa d1 = new Divisa(moneda, numero);
		Divisa d2 = new Divisa(cambioCombo.getValue(), 0.0);*/
		
		Divisa euro = new Divisa("Euro", 1.0);
		Divisa yen = new Divisa("Yen", 117.49);
		Divisa libra = new Divisa("Libra", 0.89);
		Divisa dolar = new Divisa("Dolar", 1.09);
		
		Divisa[] tipoDivisaArray = { euro, libra, dolar, yen };
		try {
			for(int i = 0; i < tipoDivisaArray.length; i++) {
				if(tipoDivisaArray[i].getNombre().equalsIgnoreCase(monedaCombo.getSelectionModel().getSelectedItem())) {
					posMoneda = i;
				}
			}
			for(int i = 0; i < tipoDivisaArray.length; i++) {
				if(tipoDivisaArray[i].getNombre().equalsIgnoreCase(cambioCombo.getSelectionModel().getSelectedItem())) {
					posCambio = i;
				}
			}
		
		
		
		
		Double cantidad = Double.parseDouble(monedaText.getText());
		
		cambioText.setPromptText(String.valueOf(tipoDivisaArray[posCambio].fromEuro(tipoDivisaArray[posMoneda].toEuro(cantidad))));
		
		}catch(Exception a) {
			System.out.println(a);
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setContentText("Fallo en el programa");
			alert.showAndWait();
			Platform.exit();
		}
		
	}
	
	/*
	private void onLoginButtonAction(ActionEvent e) {
		String user = userText.getText();
		String pass = passText.getText();
		String auth = monedaCombo.getSelectionModel().getSelectedItem();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Intento de inicio de sesion");
		alert.setContentText("Usuario "+ user + "\n"+
							 "Contraseña "+ pass + "\n"+
							 "Modo de autentificacion "+ auth
		);
		alert.showAndWait();
		Platform.exit();
		
	}
	*/



	public static void main(String[] args) {
		launch(args);
	}

}
