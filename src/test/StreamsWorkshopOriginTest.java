import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamsWorkshopOriginTest {
    Developer1 matt = new Developer1("Matt", "Lotus");
    Developer1 maikel = new Developer1("Maikel", "McLaren");
    Developer1 dileep = new Developer1("Dileep", "Lotus");
    Developer1 art = new Developer1("Art", "Lotus");

    List<UserStory1> userStories1 = List.of(
            new UserStory1(art, 11, 3),
            new UserStory1(matt, 12, 13),
            new UserStory1(matt, 11, 5),
            new UserStory1(maikel, 12, 8),
            new UserStory1(maikel, 12, 13),
            new UserStory1(dileep, 12, 2)
    );

    @Test
    @DisplayName("Find all user stories in sprint 11 and sort by points (small to high)")
    void exercise1() {
        var actual = StreamsWorkShopOrigin.finduserStories1InSprint(userStories1); // TODO: replace with the solution

        var expected = List.of(new UserStory1(art, 11, 3), new UserStory1(matt, 11, 5));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("What are the unique pods the Developer1s work in, sorted alphabetically?")
    void exercise2() {
        var actual = StreamsWorkShopOrigin.uniqePodsDeveloperWorks(userStories1);  // TODO: replace with the solution

        var expected = List.of("Lotus", "McLaren");

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find all Developer1s in Lotus and sort them by name")
    void exercise3() {
        var actual = StreamsWorkShopOrigin.listOfDevelopersinPod(userStories1); // TODO: replace with the solution

        var expected = List.of(art, dileep, matt);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Return a string of all Developer1s' names sorted alphabetically")
    void exercise4() {
        var actual = StreamsWorkShopOrigin.stringOfDeveloperNames(userStories1);

        var expected = "ArtDileepMaikelMatt";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Are any Developer1s in McLaren?")
    void exercise5() {
        var actual = StreamsWorkShopOrigin.isAnyDevelopersInMcLaren(userStories1); // TODO: replace with the solution

        assertTrue(actual);
    }

    @Test
    @DisplayName("Sum all user stories' points from the Developer1s in Lotus")
    void exercise6() {
        var actual = StreamsWorkShopOrigin.sumOfAlluserStories1(userStories1);

        var expected = 23;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("What's the highest points of all the user stories?")
    void exercise7() {
        var actual = StreamsWorkShopOrigin.getHighestPointsOfStories(userStories1); // TODO: replace with the solution

        var expected = Optional.of(13);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find the user story with the smallest points")
    void exercise8() {
        var actual = StreamsWorkShopOrigin.getSmallestPointedUserStory1(userStories1); // TODO: replace with the solution

        var expected = Optional.of(new UserStory1(dileep, 12, 2));

        assertEquals(expected, actual);
    }
}