package com.example;

import java.util.Random;

public class SillyJokes {
    private final String[] sillyJokes = new String[]{
            "Q: Where should a 500 pound alien go? A: On a diet",
            "Q: What goes up and down but does not move? A: Stairs",
            "Q: What did one toilet say to the other? A: You look a bit flushed.",
            "Q: Why did the picture go to jail? A: Because it was framed.",
            "Q: What did one wall say to the other wall? A: I'll meet you at the corner.",
            "Q: What did the paper say to the pencil? A: Write on!",
            "Q: Why was the broom late? A: It over swept!",
            "Q: What did the stamp say to the envelope? A: Stick with me and we will go places!",
            "Q: What did the laundryman say to the impatient customer? A: Keep your shirt on!",
            "Q: Why was the belt arrested? A: Because it held up some pants!"
    };

    public String getSillyJoke() {
        int random = new Random().nextInt(10);
        return sillyJokes[random];
    }
}
