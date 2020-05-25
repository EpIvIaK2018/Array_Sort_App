package sample;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WorkWithText {
    private Text[]   main_text;//Font.font("Consolas", FontWeight.BOLD, 18)
    String text_halper;
    Font font;
    public WorkWithText(Rect[] array, double C_Y, int width_Of_Window, int Count_Elements){
        font = new Font("Cambria" , width_Of_Window/Count_Elements/ 3);
        main_text = new Text[array.length];
        for (int i = 0; i < array.length; i++){
            Text temp = new Text();
            temp.setFill(Color.BLACK);
            temp.setFont(font);
            temp.setText(sample.Text.Get_text(array, i));
            temp.setY(C_Y);
            temp.setX(array[i].get_height() < 10 ? array[i].get_C_X() + array[i].get_Width()/2 - font.getSize() / 3.5 : array[i].get_C_X() + array[i].get_Width() / 2 - font.getSize() / 2);
            main_text[i] = temp;
            text_halper = new String();
        }
    }
    public Text[] getText(){
        return this.main_text;
    }
    public void update_markers(int i1, int i2){//Rect[] array
            text_halper =  main_text[i1].getText();
            main_text[i1].setText(main_text[i2].getText());
            main_text[i2].setText(text_halper);
    }

    public void setSingleValue(int i, String value){//Rect[] array
        main_text[i].setText(value);
    }

    public double get_fontSize(){
        return font.getSize();
    }
}
