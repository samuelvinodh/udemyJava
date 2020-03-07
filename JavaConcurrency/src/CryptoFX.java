import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CryptoFX extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cryptocurrency Prices");
        GridPane gridPane = createGrid();
        Map<String, Label> cryptoLabels = createCryptoPriceLabels();
        addLabelsToGrid(cryptoLabels, gridPane);
        double width = 300;
        double height = 250;
        StackPane root = new StackPane();
        Rectangle background = createAnimatedBackground(width, height);
        root.getChildren().add(background);
        root.getChildren().add(gridPane);
        primaryStage.setScene(new Scene(root, width, height));

        PricesContainer pricesContainer = new PricesContainer();
        PriceUpdater priceUpdater = new PriceUpdater(pricesContainer);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(pricesContainer.getLock().tryLock()){
                    try{
                        Label bitcoinLabel = cryptoLabels.get("BTC");
                        bitcoinLabel.setText(String.valueOf(pricesContainer.getBitcoinPrice()));
                        Label etherLabel = cryptoLabels.get("ETH");
                        etherLabel.setText(String.valueOf(pricesContainer.getEtherPrice()));
                        Label litecoinLabel = cryptoLabels.get("LTC");
                        litecoinLabel.setText(String.valueOf(pricesContainer.getLitecoinPrice()));
                        Label bitcoinCashLabel = cryptoLabels.get("BCH");
                        bitcoinCashLabel.setText(String.valueOf(pricesContainer.getBitcoinCashPrice()));
                        Label rippleLabel = cryptoLabels.get("XRP");
                        rippleLabel.setText(String.valueOf(pricesContainer.getRipplePrice()));
                    } finally {
                        pricesContainer.getLock().unlock();
                    }
                }
            }
        };
        animationTimer.start();
        priceUpdater.start();

        primaryStage.show();
    }

    private Rectangle createAnimatedBackground(double width,double height){
        Rectangle background = new Rectangle(width, height);
        FillTransition fillTransition = new FillTransition(Duration.millis(1000),background,
                Color.LIGHTGREEN,Color.LIGHTBLUE);
        fillTransition.setCycleCount(Timeline.INDEFINITE);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        return background;
    }

    private void addLabelsToGrid(Map<String, Label> labels, GridPane gridPane){
        int row = 0;
        for(Map.Entry<String,Label> entry: labels.entrySet()){
            String cryptoName = entry.getKey();
            Label labelName = new Label(cryptoName);
            labelName.setTextFill(Color.BLUE);
            labelName.setOnMousePressed(event -> labelName.setTextFill(Color.RED));
            labelName.setOnMouseReleased((EventHandler)  event -> labelName.setTextFill(Color.BLUE));
            gridPane.add(labelName,0,row);
            gridPane.add(entry.getValue(),1,row);
            row++;
        }
    }

    private Map<String, Label> createCryptoPriceLabels(){

        Label bitcoinPrice = new Label("0");
        bitcoinPrice.setId("BTC");

        Label etherPrice = new Label("0");
        etherPrice.setId("ETH");

        Label litecoinPrice = new Label("0");
        litecoinPrice.setId("LTC");

        Label bitcoinCashPrice = new Label("0");
        bitcoinCashPrice.setId("BCH");

        Label ripplePrice = new Label("0");
        ripplePrice.setId("XRP");

        Map<String, Label> cryptoLabelMap = new HashMap<>();
        cryptoLabelMap.put("BTC",bitcoinPrice);
        cryptoLabelMap.put("ETH",etherPrice);
        cryptoLabelMap.put("LTC",litecoinPrice);
        cryptoLabelMap.put("BCH",bitcoinCashPrice);
        cryptoLabelMap.put("XRP",ripplePrice);
        return cryptoLabelMap;
    }

    private GridPane createGrid(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
}
class PricesContainer{
    private Lock lock = new ReentrantLock();
    private double bitcoinPrice;
    private double etherPrice;
    private double litecoinPrice;
    private double bitcoinCashPrice;
    private double ripplePrice;

    public Lock getLock() {
        return lock;
    }

    public double getBitcoinPrice() {
        return bitcoinPrice;
    }

    public void setBitcoinPrice(double bitcoinPrice) {
        this.bitcoinPrice = bitcoinPrice;
    }

    public double getEtherPrice() {
        return etherPrice;
    }

    public void setEtherPrice(double etherPrice) {
        this.etherPrice = etherPrice;
    }

    public double getLitecoinPrice() {
        return litecoinPrice;
    }

    public void setLitecoinPrice(double litecoinPrice) {
        this.litecoinPrice = litecoinPrice;
    }

    public double getBitcoinCashPrice() {
        return bitcoinCashPrice;
    }

    public void setBitcoinCashPrice(double bitcoinCashPrice) {
        this.bitcoinCashPrice = bitcoinCashPrice;
    }

    public double getRipplePrice() {
        return ripplePrice;
    }

    public void setRipplePrice(double ripplePrice) {
        this.ripplePrice = ripplePrice;
    }
}

class PriceUpdater extends Thread{
    private PricesContainer pricesContainer;
    private Random random = new Random();

    public PriceUpdater(PricesContainer pricesContainer) {
        this.pricesContainer = pricesContainer;
    }

    @Override
    public void run(){
        while(true){
            pricesContainer.getLock().lock();
            try{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pricesContainer.setBitcoinPrice(random.nextInt(20000));
                pricesContainer.setEtherPrice(random.nextInt(2000));
                pricesContainer.setLitecoinPrice(random.nextInt(500));
                pricesContainer.setBitcoinCashPrice(random.nextInt(5000));
                pricesContainer.setRipplePrice(random.nextDouble());
            } finally {
                pricesContainer.getLock().unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}