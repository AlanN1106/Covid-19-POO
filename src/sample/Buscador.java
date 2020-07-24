package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Buscador implements Initializable {

    @FXML
    private ComboBox comboBox;
    @FXML
    private Hyperlink linkContagiados;
    @FXML
    private HBox hboxContagiados;
    @FXML
    private Hyperlink linkVentiladores;
    @FXML
    private HBox hboxVentiladores;
    @FXML
    private Hyperlink linkCamas;
    @FXML
    private HBox hboxCamas;
    @FXML
    private Pane paneMapChile;
    @FXML
    private Button btnGrafico;

    private LineChart graficoContagiosTotales;
    private MyBrowser myBrowser;

    public Buscador(){//Constructor
        //myBrowser = new MyBrowser("Valparaiso");
        System.out.println("Has creado una instancia de Buscador");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listCiudades = FXCollections.observableArrayList("RM","Iquique","Valparaiso");
        comboBox.setItems(listCiudades);

        ObservableList<XYChart.Series> listSeries = FXCollections.observableArrayList();

        ObservableList<XYChart.Data> datosContagios = FXCollections.observableArrayList(
                new XYChart.Data(0,0),
                new XYChart.Data(1,6),
                new XYChart.Data(2,37),
                new XYChart.Data(3,80),
                new XYChart.Data(4,115)
        );

        listSeries.add(new XYChart.Series("Contagios",datosContagios));

        Axis xAxis = new NumberAxis(0,10,1);
        Axis yAxis = new NumberAxis(0,150,10);
        xAxis.setLabel("Dias");
        yAxis.setLabel("Contagios");

        graficoContagiosTotales = new LineChart(xAxis,yAxis,listSeries);
        graficoContagiosTotales.setTitle("Contagios Totales");
        paneMapChile.getChildren().addAll(graficoContagiosTotales);
        //browserMapChile();
        //paneMapChile.getChildren().add(vboxMapPrincipal);

        //paneMapChile.getChildren().add(myBrowser);

    }

    @FXML
    public void setGrafico(){

        try{
            String textBtn = btnGrafico.getText();

            if (textBtn.equals("Mostrar Grafico")){
                paneMapChile.getChildren().clear();
                paneMapChile.getChildren().add(graficoContagiosTotales);
                btnGrafico.setText("Mostrar Mapa");
            }
            else if (textBtn.equals("Mostrar Mapa")){
                paneMapChile.getChildren().clear();
                paneMapChile.getChildren().add(myBrowser);
                btnGrafico.setText("Mostrar Grafico");
            }
        }catch (Exception e){
            System.out.println("Ingrese una ciudad en especifico");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una ciudad primero");
            alert.showAndWait();
        }


    }

    @FXML
    public void setMapaCiudad(){


            try{
                String opcionCiudad = comboBox.getSelectionModel().getSelectedItem().toString();
                if (opcionCiudad.equals("Valparaiso")){
                    myBrowser = new MyBrowser(opcionCiudad);
                    paneMapChile.getChildren().clear();
                    paneMapChile.getChildren().add(myBrowser);
                    btnGrafico.setText("Mostrar Grafico");
                }
                else if(opcionCiudad.equals("RM")){
                    myBrowser = new MyBrowser(opcionCiudad);
                    paneMapChile.getChildren().clear();
                    paneMapChile.getChildren().add(myBrowser);
                    btnGrafico.setText("Mostrar Grafico");
                }
            }
            catch (Exception e){
                System.out.println("Ingrese una ciudad en especifico");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar una ciudad primero");
                alert.showAndWait();
            }

    }

    //CONTAGIADOS--------------------
    @FXML
    public void clickOnContagiados(){
        try{
            String opcionCiudad = comboBox.getSelectionModel().getSelectedItem().toString();
            System.out.println("Click en Contagiados ");
            if (opcionCiudad == "RM"){
                newStage("RM");
            }
            else if (opcionCiudad == "Iquique"){
                newStage("Iquique");
            }

        }
        catch (Exception e){
            System.out.println("Ingrese una ciudad en especifico");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una ciudad primero");
            alert.showAndWait();
        }
    }
    @FXML
    public void mouseOnContagiados(){
        hboxContagiados.setStyle("-fx-background-color: rgb(53,53,52)");
        linkContagiados.setTextFill(Color.WHITE);
        linkContagiados.setUnderline(false);
    }
    @FXML
    public void mouseExitContagiados(){
        hboxContagiados.setStyle("-fx-background-color: rgb(231,231,232)");
        linkContagiados.setTextFill(Color.BLACK);
    }
    //------------------------------------
    //VENTILADORES------------------------
    @FXML
    public void clickOnVentiladores(){

        try{
            String opcionCiudad = comboBox.getSelectionModel().getSelectedItem().toString();
            System.out.println("Click en ventiladores");
            if (opcionCiudad == "RM"){
                newStage("RM");
            }
            else if (opcionCiudad == "Iquique"){
                newStage("Iquique");
            }

        }
        catch (Exception e){
            System.out.println("Ingrese una ciudad en especifico");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una ciudad primero");
            alert.showAndWait();
        }
    }
    @FXML
    public void mouseOnVentiladores(){
        hboxVentiladores.setStyle("-fx-background-color: rgb(53,53,52)");
        linkVentiladores.setTextFill(Color.WHITE);
        linkVentiladores.setUnderline(false);
    }
    @FXML
    public void mouseExitVentiladores(){
        hboxVentiladores.setStyle("-fx-background-color: rgb(231,231,232)");
        linkVentiladores.setTextFill(Color.BLACK);
    }
    //-----------------------------------
    //CAMAS------------------------------
    @FXML
    public void clickOnCamas(){
        try{
            System.out.println("Click On Camas");
        }
        catch (Exception e){
            System.out.println("Ingrese una ciudad en especifico");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una ciudad primero");
            alert.showAndWait();
        }
    }
    @FXML
    public void mouseOnCamas(){
        linkCamas.setOpacity(1);
        linkCamas.setUnderline(false);
    }
    @FXML
    public void mouseExitCamas(){
        linkCamas.setOpacity(0.5);
    }

    //METODOS QUE NO ESTAN EN EL FXML-------------------

    public void newStage(String nomCiudad){
        AnchorPane anchorPane = new AnchorPane();
        Label lblAnchorPane = new Label(nomCiudad);
        anchorPane.getChildren().addAll(lblAnchorPane);
        Scene sceneNew = new Scene(anchorPane,500,500);
        Stage secundaryStage = new Stage();
        secundaryStage.setTitle(nomCiudad);
        secundaryStage.setScene(sceneNew);
        secundaryStage.show();
    }
    //CLASE INTERNA PARA AGREGAR EL MAPA
    class MyBrowser extends Region {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MyBrowser(String nomCiudad){

            final URL urlGoogleMaps = getClass().getResource("/sample/resources/map"+nomCiudad+".html");
            webEngine.load(urlGoogleMaps.toExternalForm());

            getChildren().add(webView);

        }

    }



}
