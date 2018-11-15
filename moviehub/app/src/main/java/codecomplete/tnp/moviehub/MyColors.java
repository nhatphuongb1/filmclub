package codecomplete.tnp.moviehub;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;

public class MyColors {
    private static ArrayList<Integer> colors;
    private static Random random;

    public MyColors() {

        colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.WHITE);
        colors.add(Color.GRAY);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);
    }

    public static Integer getRandomColor() {
        random = new Random();
        return colors.get(random.nextInt(colors.size()));
    }
}
