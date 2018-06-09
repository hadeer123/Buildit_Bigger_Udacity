package com.example.jokes;

import java.util.Locale;
import java.util.Random;

public class MyJokes {
    /**
     * String array containing some jokes specifically for google app engine.
     */
    private static final String[] JOKES_GE = {

           " I get plenty of exercise – jumping to conclusions, pushing my luck, and dodging deadlines.",
            "They threw me out of the cinema today for bringing my own food. But come on, the prices are way too high, plus I haven't had a barbecue in months.",

           " Q: Why are ghosts bad liars? \n" +"A. Because you can see right through them!",
            "Secretary: \"Doctor the invisible man has come. He says he has an appointment.\"\n" +
                    "\n" +
                    "Doctor: \"Tell him I cant see him.\"",
            "\"Grandpa, why don't you have any life insurance?\"\n" +
                    "\n" +
                   " Q:  Why shouldn't you give Elsa a balloon?\n"+
                    "A. Because she'll let it go!",

            "Q. What's the Easter Bunny's favorite restaurant?\n"+ "A. IHOP!"
    };

    /**
     * String array containing some jokes.
     */
    private static final String[] JOKES_2 = {"Can a kangaroo jump higher than a house? Of course, a house doesn't jump at all.",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                    "\n" +
                    "Doctor: \"Nine.\"",
            "A man asks a farmer near a field, \"Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.\"\n" +
                    "\n" +
                    "The farmer says, \"Sure, go right ahead. And if my bull sees you, you'll even catch the 4:11 one.\"",
            "Mother, \"How was school today, Patrick?\"\n" +
                    "\n" +
                    "Patrick, \"It was really great mum! Today we made explosives!\"\n" +
                    "\n" +
                    "Mother, \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\"\n" +
                    "\n" +
                    "Patrick, \"What school?\"",
            "Scientists have now discovered how women keep their secrets. They do so within groups of 40.",
            "When my wife starts to sing I always go out and do some garden work so our neighbors can see there's no domestic violence going on.",
            "It is so cold outside I saw a politician with his hands in his own pockets."};

    /**
     * Get a random joke
     *
     * @return random joke in string format
     */
    public static String getJoke() {
        int random = new Random(System.currentTimeMillis()).nextInt(10);
        return String.format(Locale.getDefault(), "%s", JOKES_2[random]);
    }

    /**
     * Get a random joke for google app engine module
     *
     * @return random joke in string format
     */
    public static String getGEJoke() {
        int random = new Random(System.currentTimeMillis()).nextInt(10);
        return String.format(Locale.getDefault(), "%s", JOKES_GE[random]);
    }

    /**
     * Main method to test if jokes are being printed correctly or not.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getJoke());
    }
}
