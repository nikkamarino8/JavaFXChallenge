/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxchallenge;
/**
 *
 * @author nikka
 */
import java.util.function.Function;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class JavaFxChallenge extends Application {

    private static final String USERNAME = "nikka";
    private static final String PASSWORD = "nikka";
    private final ObservableList<Person> data = FXCollections.observableArrayList();



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Challenge ni ser Eli");

        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //labels and textfields
        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(usernameLabel, 0, 0);

        TextField usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 0);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(passwordLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 1);
        
        //button clear, cancel, log in
        Button clearButton = new Button("Clear");
        clearButton.getStyleClass().add("button");
        HBox.setHgrow(clearButton, Priority.ALWAYS);
        clearButton.setOnAction(e -> {
            usernameTextField.clear();
            passwordField.clear();
});

        Button cancelButton = new Button("Cancel");
        cancelButton.getStyleClass().add("button");
        HBox.setHgrow(cancelButton, Priority.ALWAYS);
        cancelButton.setOnAction(e -> {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
});

        Button loginButton = new Button("Log In");
        loginButton.getStyleClass().add("button");
        HBox.setHgrow(loginButton, Priority.ALWAYS);

        HBox hbButtons = new HBox(10);
        hbButtons.setAlignment(Pos.BOTTOM_RIGHT);
        hbButtons.getChildren().addAll(clearButton, cancelButton, loginButton);
        grid.add(hbButtons, 1, 2);

        //login check credentials syempre
        final Label loginStatusLabel = new Label();
        grid.add(loginStatusLabel, 1, 3);

        loginButton.setOnAction(event -> {
            String username = usernameTextField.getText();
            String password = passwordField.getText();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                loginStatusLabel.setText("Login successful!");
                primaryStage.setScene(createNewScene());
            } 
            else {
                loginStatusLabel.setText("Invalid username or password");
            }
        });

        Scene scene = new Scene(grid, 800, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
 public static class Person {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty address;
    private final SimpleIntegerProperty contact;

    public Person(String name, int age, String gender, String address, int contact) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.contact = new SimpleIntegerProperty(contact);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void getContact(int contact) {
    }

    public void setContact(int contact) {
        this.contact.set(contact);
    }
 }


    private Scene createNewScene() {
    BorderPane borderPane = new BorderPane();
    //createNewScene.setTitle("DATA BROWSER");

   Label dataEntryLabel = new Label("Data Entry Form ni Nikka");
dataEntryLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

Label nameLabel = new Label("Name:");
TextField nameField = new TextField();

Label ageLabel = new Label("Age:");
TextField ageField = new TextField();

Label genderLabel = new Label("Gender:");
TextField genderField = new TextField();

Label addressLabel = new Label("Address:");
TextField addressField = new TextField();

Label contactLabel = new Label("Contact No:");
TextField contactField = new TextField();


Button addButton = new Button("Add");
addButton.setOnAction(event -> {
    String name = nameField.getText();
    int age = Integer.parseInt(ageField.getText());
    String gender = genderField.getText();
    String address = addressField.getText();
    long contact = 0;
    try {
        contact = Long.parseLong(contactField.getText());
    } catch (NumberFormatException e) {
        System.out.println("Invalid phone number format");
        return;
    }
    Person person = new Person(name, age, gender, address, (int) contact);
    data.add(person);

    nameField.clear();
    ageField.clear();
    genderField.clear();
    addressField.clear();
    contactField.clear();
});

    //clear button
    Button clearButton = new Button("Clear");
    Label dataEntryErrorLabel = new Label();
    clearButton.setOnAction(event -> {
    nameField.clear();
    ageField.clear();
    genderField.clear();
    addressField.clear();
    contactField.clear();
});
    
    
    //positioning ng mga label thingz
    GridPane dataEntryGrid = new GridPane();
    dataEntryGrid.setAlignment(Pos.CENTER);
    dataEntryGrid.setHgap(10);
    dataEntryGrid.setVgap(10);
    dataEntryGrid.setPadding(new Insets(25, 25, 25, 25));
    dataEntryGrid.add(dataEntryLabel, 0, 0, 2, 1);
    dataEntryGrid.add(nameLabel, 0, 1);
    dataEntryGrid.add(nameField, 1, 1);
    dataEntryGrid.add(ageLabel, 0, 2);
    dataEntryGrid.add(ageField, 1, 2);
    dataEntryGrid.add(genderLabel, 0, 3);
    dataEntryGrid.add(genderField, 1, 3);
    dataEntryGrid.add(addressLabel, 2, 1);
    dataEntryGrid.add(addressField, 3,1);
    dataEntryGrid.add(contactLabel, 2, 2);
    dataEntryGrid.add(contactField, 3, 2);
    dataEntryGrid.add(addButton, 0, 6);
    dataEntryGrid.add(clearButton, 1, 6);
    dataEntryGrid.add(dataEntryErrorLabel, 0, 7, 2, 1);
    borderPane.setTop(dataEntryGrid);
  
    //table na
    TableView<Person> table = new TableView<>(data);
    table.setEditable(false);

    TableColumn<Person, String> nameCol = new TableColumn<>("Name");
    nameCol.setMinWidth(100);
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Person, Integer> ageCol = new TableColumn<>("Age");
    ageCol.setMinWidth(50);
    ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
    ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

    TableColumn<Person, String> genderCol = new TableColumn<>("Gender");
    genderCol.setMinWidth(50);
    genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

    TableColumn<Person, String> addressCol = new TableColumn<>("Address");
    addressCol.setMinWidth(200);
    addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

    TableColumn<Person, Integer> contactCol = new TableColumn<>("Contact");
    contactCol.setMinWidth(100);
    contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
   
    
    table.getColumns().addAll(nameCol, ageCol, genderCol, addressCol, contactCol);



// yung layout ng table
    VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.getChildren().addAll(table);
    borderPane.setCenter(vbox);


    
    //search
    Label searchLabel = new Label("Search:");
    TextField searchField = new TextField();
    Button searchButton = new Button("Find");

    // gagawa ng label para sa search result
    Label resultLabel = new Label("");

    //nag sesearch ng name
    Function<String, Person> searchFunction = name -> {
        for (Person person : data) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
    return null;
};

searchButton.setOnAction(event -> {
    String name = searchField.getText().trim();
    if (name.isEmpty()) {
        resultLabel.setText("Please enter a name to search.");
        return;
    }
    Person person = searchFunction.apply(name);
    if (person != null) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Found: " + person.getName());
        alert.showAndWait();
        resultLabel.setText("Found: " + person.getName());
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("No matching records found.");
        alert.showAndWait();
        resultLabel.setText("No matching records found.");
    }
});


// eto yung search box
HBox searchBox = new HBox(10, searchLabel, searchField, searchButton);
searchBox.setAlignment(Pos.CENTER);

VBox bottomBox = new VBox(10, searchBox, resultLabel);
bottomBox.setAlignment(Pos.CENTER);
bottomBox.setPadding(new Insets(25));
borderPane.setBottom(bottomBox);

Scene scene = new Scene(borderPane, 800, 750);
return scene;

}

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
    
    

