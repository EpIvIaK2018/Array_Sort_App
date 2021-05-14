package sample;

public class Text {
	// Я изменил Программу!!!
    static String Get_text(Rect[] array, int iterator)
    {
        String[] text = new String[array.length];
        for (int i = 0; i < array.length; i++)
        {
            text[i] = Integer.toString((int)array[i].get_height());
        }
        return String.valueOf(text[iterator]);
    }
}
