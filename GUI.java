///////////////////////////////////////////////////////////////////////////////
//
// Title: SEO Visualizer
// Author: Milica Andric
// Description: Program that implements and tests an abstract data structure from selected file and
// creates relevant GUI. Program helps users (ex: SEO specialists) visualize unused code bytes of
// website and provides better understanding as to which issues should take priority. Users can
// then clean up and update their website accordingly.
//
///////////////////////////////////////////////////////////////////////////////
package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Class that contains driver class that implements all GUI and general user interface functions.
 * Application class from which JavaFX applications extend.
 * 
 */
public class GUI extends Application {
  private List<String> args;
  private static final int WINDOW_WIDTH = 500;
  private static final int WINDOW_HEIGHT = 400;
  private static final String APP_TITLE = "SEO Visualizer"; // title of program
  private Scene resultsScene; // secondary scene for results and data report
  private TableView<Pair> table = new TableView<Pair>(); // table GUI for displaying results
  private ObservableList<Pair> data = FXCollections.observableArrayList(); // ObservableList of Pair
                                                                           // objects to be added to
                                                                           // table
  final HBox hb = new HBox(); // HBox for TextField and Button object(s) that enable user to add
                              // information/data to table

  /**
   * The main entry point for all JavaFX applications. The start method is called after the init
   * method has returned, and after the system is ready for the application to begin running.
   * 
   * @param primaryStage - the primary stage for this application, onto which the application scene
   *                     can be set.
   * @throws Exception - if conditions that a reasonable application might want to catch occur
   */
  @SuppressWarnings("unchecked")
  @Override
  public void start(Stage primaryStage) throws Exception {
    args = this.getParameters().getRaw();

    VBox vbox = new VBox(); // creates new VBox object for starting UI images
    VBox fileUploadVbox = new VBox(); // creates new VBox object for starting UI file upload
                                      // response

    // creates and loads three Image objects
    Image toolImage1 = new Image("tool1.png");
    Image toolImage2 = new Image("tool2.png");
    Image toolImage3 = new Image("tool3.png");

    // displays toolImageView1
    ImageView toolImageView1 = new ImageView();
    toolImageView1.setImage(toolImage1);
    vbox.getChildren().add(toolImageView1);
    toolImageView1.setImage(toolImage1);
    toolImageView1.setFitWidth(150);
    toolImageView1.setPreserveRatio(true);
    toolImageView1.setSmooth(true);
    toolImageView1.setCache(true);

    // displays toolImageView2
    ImageView toolImageView2 = new ImageView();
    toolImageView2.setImage(toolImage2);
    vbox.getChildren().add(toolImageView2);
    toolImageView2.setImage(toolImage2);
    toolImageView2.setFitWidth(150);
    toolImageView2.setPreserveRatio(true);
    toolImageView2.setSmooth(true);
    toolImageView2.setCache(true);

    // displays toolImageView3
    ImageView toolImageView3 = new ImageView();
    toolImageView3.setImage(toolImage3);
    vbox.getChildren().add(toolImageView3);
    toolImageView3.setImage(toolImage3);
    toolImageView3.setFitWidth(150);
    toolImageView3.setPreserveRatio(true);
    toolImageView3.setSmooth(true);
    toolImageView3.setCache(true);

    // creates new FileChooser object
    FileChooser fileChooser = new FileChooser();

    // allows table in other scene to be edited
    table.setEditable(true);

    // creates new column for url property to add to table
    TableColumn<Pair, String> urlCol = new TableColumn<Pair, String>("Url");
    urlCol.setMinWidth(100);
    urlCol.setCellValueFactory(new PropertyValueFactory<Pair, String>("url"));
    // enables cell editing for url column
    new PropertyValueFactory<Pair, String>("url");
    urlCol.setCellFactory(TextFieldTableCell.forTableColumn());
    urlCol.setOnEditCommit(new EventHandler<CellEditEvent<Pair, String>>() {
      @Override
      public void handle(CellEditEvent<Pair, String> t) {
        ((Pair) t.getTableView().getItems().get(t.getTablePosition().getRow()))
            .setUrl(t.getNewValue());
      }
    });

    // creates new column for bytes property to add to table
    TableColumn<Pair, String> bytesCol = new TableColumn<Pair, String>("Bytes");
    bytesCol.setMinWidth(100);
    bytesCol.setCellValueFactory(new PropertyValueFactory<Pair, String>("bytes"));
    // enables cell editing for bytes column
    new PropertyValueFactory<Pair, String>("url");
    bytesCol.setCellFactory(TextFieldTableCell.forTableColumn());
    bytesCol.setOnEditCommit(new EventHandler<CellEditEvent<Pair, String>>() {
      @Override
      public void handle(CellEditEvent<Pair, String> t) {
        ((Pair) t.getTableView().getItems().get(t.getTablePosition().getRow()))
            .setUrl(t.getNewValue());
      }
    });

    // creates new column for type property to add to table
    TableColumn<Pair, String> typeCol = new TableColumn<Pair, String>("Type");
    typeCol.setMinWidth(100);
    typeCol.setCellValueFactory(new PropertyValueFactory<Pair, String>("type"));
    // enables cell editing for type column
    new PropertyValueFactory<Pair, String>("url");
    typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
    typeCol.setOnEditCommit(new EventHandler<CellEditEvent<Pair, String>>() {
      @Override
      public void handle(CellEditEvent<Pair, String> t) {
        ((Pair) t.getTableView().getItems().get(t.getTablePosition().getRow()))
            .setUrl(t.getNewValue());
      }
    });

    // adds columns to table
    table.getColumns().addAll(urlCol, bytesCol, typeCol);

    // creates new TextField object that enables user to add url
    final TextField addUrl = new TextField();
    addUrl.setPromptText("Url");
    addUrl.setMaxWidth(urlCol.getPrefWidth());

    // creates new TextField object that enables user to add bytes
    final TextField addBytes = new TextField();
    addBytes.setPromptText("Bytes");
    addBytes.setMaxWidth(bytesCol.getPrefWidth());

    // creates new TextField object that enables user to add type
    final TextField addType = new TextField();
    addType.setPromptText("Type");
    addType.setMaxWidth(typeCol.getPrefWidth());

    // creates new Button object that enables user to add TextField object(s)
    final Button addButton = new Button("Add");
    addButton.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        data.add(new Pair(addUrl.getText(), addBytes.getText(), addType.getText()));
        ArrayList<Pair> pairList = (ArrayList<Pair>) data.stream().collect(Collectors.toList()); // converts
                                                                                                 // ObservableList<Pair>
                                                                                                 // to
                                                                                                 // ArrayList<Pair>
        DS.setArray(DSHelper.listToPairArray(pairList)); // updates data structure in memory
        System.out.println(
            "The NEW number of data elements in this file is " + DS.getArray().length + "."); // confirms
                                                                                              // new
                                                                                              // data
                                                                                              // added
        addUrl.clear(); // clears user input after TextField object for url is added to table
        addBytes.clear(); // clears user input after TextField object for bytes is added to table
        addType.clear(); // clears user input after TextField object for type is added to table
      }
    });

    // adds TextField and Button object(s) to HBox
    hb.getChildren().addAll(addUrl, addBytes, addType, addButton);
    hb.setSpacing(3);

    // creates tableVbox for displaying results in table in results scene
    final VBox tableVbox = new VBox();
    tableVbox.setSpacing(5);
    tableVbox.setPadding(new Insets(10, 0, 0, 10));
    tableVbox.getChildren().addAll(table, hb);

    // creates new Button object for user to open and upload their file
    Button openFileButton = new Button("Open file");

    // create new Button object that navigates to the results scene
    Button resultsButton = new Button("Results");

    // create new Button object to close program
    Button closeButton = new Button("Exit");

    // creates TilePane object for buttons
    TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
    tileButtons.setPadding(new Insets(15, 12, 15, 12));
    tileButtons.setHgap(20.0);
    tileButtons.getChildren().addAll(openFileButton, resultsButton, closeButton);
    tileButtons.setAlignment(Pos.BASELINE_CENTER);

    // create and aligns new VBox containing back button in results scene
    VBox vbox3 = new VBox();
    Button backButton = new Button("Back");
    vbox3.getChildren().add(backButton);
    vbox3.setAlignment(Pos.BOTTOM_LEFT);

    // create and aligns new VBox containing data report in results scene
    VBox reportVbox = new VBox();
    Label reportLabel = new Label("Data Report...");
    reportVbox.getChildren().add(reportLabel);
    reportVbox.setAlignment(Pos.TOP_LEFT);

    // sets appropriate action for openFileButton
    openFileButton.setOnAction(e -> {
      File selectedFile = fileChooser.showOpenDialog(primaryStage);
      if (!selectedFile.getName().contains(".txt")) {
        Label incorrectFileLabel =
            new Label(selectedFile.getName() + " is not a text file. Please select a text file.");
        // centers incorrectFileLabel
        incorrectFileLabel.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(incorrectFileLabel, 0.0);
        AnchorPane.setRightAnchor(incorrectFileLabel, 0.0);
        incorrectFileLabel.setAlignment(Pos.CENTER);
        fileUploadVbox.getChildren().add(incorrectFileLabel);
        throw new IllegalArgumentException("Please select a text file.");
      }
      Label fileUploadLabel = new Label(
          selectedFile.getName() + " was successfully uploaded! Click the results button below.");
      // centers fileUploadLabel
      fileUploadLabel.setMaxWidth(Double.MAX_VALUE);
      AnchorPane.setLeftAnchor(fileUploadLabel, 0.0);
      AnchorPane.setRightAnchor(fileUploadLabel, 0.0);
      fileUploadLabel.setAlignment(Pos.CENTER);
      fileUploadVbox.getChildren().add(fileUploadLabel);
      ArrayList<String> list = DSHelper.fileToList(selectedFile); // creates new list with data
                                                                  // from selected file
      String[] array = DSHelper.listToArray(list); // converts list to array
      Pair[] pairArray = DSHelper.getArray(); // retrieve data structure
      pairArray = DSHelper.arraySplitter(array); // creates array with Pair
                                                 // objects
      DSHelper.elements(pairArray); // counts number of code types from selected file

      // adds information from array into ObservableList<Pair> data
      for (int i = 0; i < pairArray.length; i++) {
        data.addAll(FXCollections.observableArrayList(
            new Pair(pairArray[i].getUrl(), pairArray[i].getBytes(), pairArray[i].getType())));
        table.setItems(data); // adds data to table
        ArrayList<Pair> pairList = (ArrayList<Pair>) data.stream().collect(Collectors.toList());// converts
                                                                                                // ObservableList<Pair>
                                                                                                // to
                                                                                                // ArrayList<Pair>
        DS.setArray(DSHelper.listToPairArray(pairList)); // updates data structure in memory
      }
      System.out
          .println("The number of data elements in this file is " + DS.getArray().length + ".");
      // creates data report with updated information
      Label jsLabel = new Label("Total js files: " + DSHelper.getJs());
      reportVbox.getChildren().add(jsLabel);
      Label cssLabel = new Label("Total css files: " + DSHelper.getCss());
      reportVbox.getChildren().add(cssLabel);
      Label htmlLabel = new Label("Total html files: " + DSHelper.getHtml());
      reportVbox.getChildren().add(htmlLabel);
      Label pyLabel = new Label("Total py files: " + DSHelper.getPy());
      reportVbox.getChildren().add(pyLabel);
    });

    // sets appropriate action for resultsButton
    resultsButton.setOnAction(e -> primaryStage.setScene(resultsScene));

    // sets appropriate action for closeButton
    closeButton.setOnAction(e -> Platform.exit());

    // creates main layout
    BorderPane root = new BorderPane();
    root.setCenter(vbox);

    // sets fileUploadVbox to top panel
    root.setTop(fileUploadVbox);

    // sets toolImageView1 to center panel
    root.setCenter(toolImageView1);
    BorderPane.setAlignment(toolImageView1, Pos.CENTER);

    // sets toolImageView2 to center panel
    root.setRight(toolImageView2);
    BorderPane.setAlignment(toolImageView2, Pos.CENTER);

    // sets toolImageView3 to center panel
    root.setLeft(toolImageView3);
    BorderPane.setAlignment(toolImageView3, Pos.CENTER);

    // sets TilePane object containing main buttons to bottom center panel
    root.setBottom(tileButtons);
    BorderPane.setAlignment(tileButtons, Pos.BASELINE_CENTER);

    // creates main scene
    Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    mainScene.getStylesheets().add("application.css"); // applies css to mainScene

    // sets appropriate action for backButton
    backButton.setOnAction(e -> primaryStage.setScene(mainScene));

    // creates results layout
    BorderPane root2 = new BorderPane();
    root2.setLeft(vbox3);
    root2.setRight(tableVbox);
    root2.setTop(reportVbox);

    // initializes and sets up secondary scene
    resultsScene = new Scene(root2, WINDOW_WIDTH, WINDOW_HEIGHT);
    resultsScene.getStylesheets().add("application.css"); // applies css to resultsScene

    // sets the primary stage
    primaryStage.setTitle(APP_TITLE);
    primaryStage.setScene(mainScene);
    primaryStage.show();
  }

  /**
   * Driver program for all JavaFX applications and GUI.
   * 
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
  }
}
