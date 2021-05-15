package sample;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Main extends Application {
    private Text [] Final_Text;

    public void Array_Merge(Rect[] array){
        for(int i = 0; i < array.length; i++){
            array[i].set_height(((int) Math.floor(Math.random() * 100)));
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        int width = 1800;
        double height = width / 3;
        primaryStage.setTitle("Sorts");
        primaryStage.setScene(new Scene(root,  width, height));

        Button Button_StartSort = new Button("Старт сортировки");
        Button Button_Reset = new Button("Сброс");
        int countOfElements = 30;
        Rect[] arrayList =    new Rect[countOfElements];
        Rect[] NewArrayList = new Rect[countOfElements];
        int step = 8;
        AnchorPane root2 = new AnchorPane();
        for (int i = 0; i < arrayList.length; i++) {
            double HeightOf_Rect = ((int) Math.floor(Math.random() * 100));
            arrayList[i] = new Rect(step, height / countOfElements + 2,(width/countOfElements) / 1.6, HeightOf_Rect, Color.GREY);
            root2.getChildren().addAll(arrayList[i].get_rect());
            step += width/countOfElements;
        }
        WorkWithText workWithText = new WorkWithText(arrayList, height / countOfElements, width, arrayList.length);
        Text [] text = workWithText.getText();
        root2.getChildren().addAll(text);
        step = 8;
        for (int i = 0; i < NewArrayList.length; i++) {
            NewArrayList[i] = new Rect(step,height / countOfElements + 152,(width/countOfElements) / 1.6, arrayList[i].get_height(), Color.GREEN);
            root2.getChildren().addAll(NewArrayList[i].get_rect());
            step += width/countOfElements;
        }
        WorkWithText NewWorkWithText = new WorkWithText(NewArrayList, height / countOfElements + 150, width, arrayList.length);
        Final_Text = NewWorkWithText.getText();
        Label label_Bubble = new Label();
        label_Bubble.setFont(new Font("Cambria",40));
        root2.setPadding(new Insets(10));
        root2.getChildren().addAll(Final_Text);
        root.getChildren().addAll(root2);

        root2.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        root2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));;

        AnchorPane anchorPane = new AnchorPane();
        root.getChildren().addAll(anchorPane);
        ToggleGroup group = new ToggleGroup();

        RadioButton RadioButton_1 = new RadioButton("Пузырьковая сортировка");
        RadioButton_1.setSelected(true);
        Radion_Button_Setting(RadioButton_1, 1.5,1.5);

        RadioButton RadioButton_2 = new RadioButton("Сортировка выбором");
        Radion_Button_Setting(RadioButton_2, 1.5,1.5);

        RadioButton RadioButton_3 = new RadioButton("Сортировка вставками");
        Radion_Button_Setting(RadioButton_3, 1.5,1.5);

        RadioButton RadioButton_4 = new RadioButton("Шейкерная сортировка");
        Radion_Button_Setting(RadioButton_4, 1.5,1.5);

        RadioButton_1.setToggleGroup(group);
        RadioButton_2.setToggleGroup(group);
        RadioButton_3.setToggleGroup(group);
        RadioButton_4.setToggleGroup(group);

        anchorPane.getChildren().addAll(Button_StartSort, Button_Reset, RadioButton_1, RadioButton_2, RadioButton_3, RadioButton_4);
        anchorPane.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(4), Insets.EMPTY)));
        AnchorPane.setBottomAnchor(Button_StartSort, (double)height);
        AnchorPane.setBottomAnchor(Button_Reset, (double)height );
        AnchorPane.setBottomAnchor(RadioButton_1, (double)height - 50);
        AnchorPane.setBottomAnchor(RadioButton_2, (double)height - 50);
        AnchorPane.setBottomAnchor(RadioButton_3, (double)height - 50);
        AnchorPane.setBottomAnchor(RadioButton_4, (double)height - 50);
        AnchorPane.setLeftAnchor(Button_Reset, (double) width - 54);
        AnchorPane.setLeftAnchor(RadioButton_1, (double) 50);
        AnchorPane.setLeftAnchor(RadioButton_2, (double) 300);
        AnchorPane.setLeftAnchor(RadioButton_3, (double) 550);
        AnchorPane.setLeftAnchor(RadioButton_4, (double) 800);
        primaryStage.show();

        label_Bubble.setText("Пузырьковая сортировка");
        // Определяется выбранная кнопка для дальнейшей сортировки
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    label_Bubble.setText(button.getText());
                }
            }
        });
        Button_StartSort.setOnAction(value ->  {
            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    RadioButton_1.setDisable(true);
                    RadioButton_2.setDisable(true);
                    RadioButton_3.setDisable(true);
                    RadioButton_4.setDisable(true);
                    switch (label_Bubble.getText()) {
                        case ("Пузырьковая сортировка"):
                            SortOfArray.Bubble_sort(NewArrayList, NewWorkWithText);
                            break;
                        case ("Сортировка выбором"):
                            SortOfArray.Selection_sort(NewArrayList, NewWorkWithText);
                            break;
                        case ("Сортировка вставками"):
                            SortOfArray.Insertion_Sort(NewArrayList, NewWorkWithText);
                            break;
                        case ("Шейкерная сортировка"):
                            SortOfArray.Shuttle_sort(NewArrayList, NewWorkWithText);
                            break;
                        default:
                            System.out.println(Button_StartSort.getText());
                            break;
                        }
                    Button_Reset.setOnAction(e -> {
                        Array_Merge(NewArrayList);
                    });
                    primaryStage.show();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.start();
        });

    }
    public static void main(String[] args) {
        launch(args);
    }

    public void Radion_Button_Setting(RadioButton R, double setScaleX, double setScaleY ){
        R.setScaleX(setScaleX);
        R.setScaleY(setScaleY);
        R.setStyle("-fx-text-fill: white;");
    }
}
