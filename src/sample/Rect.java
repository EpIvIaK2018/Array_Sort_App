package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Rect {
    private Rectangle rectangle;

    public Rect() { }
    public Rect(double C_x, double C_y, double Width, double Height, Color Color){
         this.rectangle = new Rectangle();
         this.rectangle.setX(C_x);
         this.rectangle.setY(C_y);
         this.rectangle.setWidth(Width);
         this.rectangle.setHeight(Height);
         this.rectangle.setFill(Color);
    }
    public Rectangle get_rect()              { return this.rectangle; }
    public double get_height()               { return this.rectangle.getHeight(); }
    public double get_C_X()                  { return this.rectangle.getX(); }
    public double get_C_Y()                  { return this.rectangle.getY(); }
    public double get_Width()                { return  this.rectangle.getWidth();}

    public void set_color(Color Color_input){
        this.rectangle.setFill(Color_input);
    }
    public void set_height(double height)    { this.rectangle.setHeight(height); }

}
