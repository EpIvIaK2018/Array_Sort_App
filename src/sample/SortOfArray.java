package sample;

public class SortOfArray extends Thread implements Cloneable {
    static private int Lvalue = 0;
    static private boolean There_is_a_change = false;
    static private boolean Begin = false;
    static private int Rvalue = 0;

    public static void Bubble_sort(Rect[] array, WorkWithText text) {
        if (!Begin) {
            Rvalue = array.length - 1;
            Begin = true;
        }
        There_is_a_change = false;
        while (Rvalue > 0) {
            for (int i = Lvalue; i < Rvalue; i++) {
                if (array[i].get_height() > array[i + 1].get_height()) {
                    Lvalue = i;
                    int temp = (int) array[i].get_height();
                    text.update_markers(i, i + 1);
                    array[i].set_height(array[i + 1].get_height());
                    array[i + 1].set_height(temp);
                    break;
                }
                if (i == Rvalue - 1) There_is_a_change = true;
            }
            if (There_is_a_change) {
                Lvalue = 0;
                Rvalue--;
            }
            break;
        }
    }

    static private boolean Up;
    static private boolean Down;
    static private int Count;
    static private int CurrentLeft;
    static private int CurrentRight;
    public static void Shuttle_sort(Rect[] array, WorkWithText text){
        if (!Begin) {
            Lvalue = 0;
            Rvalue = array.length - 1;
            Up = true;
            Down = false;
            Begin = true;
            Count = 0;
        }
        while(true) {
            if (Up) {
                for (int i = CurrentLeft; i < Rvalue; i++) {
                    Count = i;
                    if (array[i].get_height() > array[i + 1].get_height()) {
                        int temp = (int) array[i].get_height();
                        text.update_markers(i, i + 1);
                        array[i].set_height(array[i + 1].get_height());
                        array[i + 1].set_height(temp);
                        CurrentLeft = i;
                        break;
                    }
                }
                if(Count == Rvalue - 1){
                    Lvalue++;
                    CurrentLeft = Lvalue;
                    CurrentRight = Rvalue;
                    Up = false;
                    Down = true;
                    Count = 0;
                }
            }
            else if (Down) {
                for (int i = CurrentRight; i >= Lvalue; i--) {
                    Count = i;
                    if (array[i].get_height() < array[i - 1].get_height()) {
                        int temp = (int) array[i].get_height();
                        text.update_markers(i, i - 1);
                        array[i].set_height(array[i - 1].get_height());
                        array[i - 1].set_height(temp);
                        CurrentRight = i;
                        break;
                    }
                }
                if(Count == Lvalue) {
                    Rvalue--;
                    CurrentRight = Rvalue;
                    Up = true;
                    Down = false;
                }
            }
            break;
        }
    }

    public static void Insertion_Sort(Rect[] array, WorkWithText text) {
        for (int i = 0; i < array.length; i++) {
            int val = (int) array[i].get_height();
            int j = i - 1;
            while (j >= 0 && array[j].get_height() > val) {
                array[j + 1].set_height(array[j].get_height());
                text.update_markers(j + 1, j);
                --j;
                break;
            }
            array[j + 1].set_height(val);
        }
    }

    public static void Selection_sort(Rect[] array, WorkWithText text) {
        if (!Begin) {
            Lvalue = 0;
            Begin = true;
        }
        double Min = 500;
        while (Lvalue < array.length) {
            int Iterator = 0;
            for (int i = Lvalue; i < array.length; i++) {
                if (Min > (int) array[i].get_height()) {
                    Min = (int) array[i].get_height();
                    Iterator = i;
                }
            }
            double t = array[Lvalue].get_height();
            text.update_markers(Iterator, Lvalue);
            array[Lvalue].set_height(Min);
            array[Iterator].set_height(t);
            Lvalue++;
            break;
        }
    }
}


