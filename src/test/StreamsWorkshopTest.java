import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StreamsWorkshopTest {
    Developer matt = new Developer("Matt", "Lotus");
    Developer maikel = new Developer("Maikel", "McLaren");
    Developer dileep = new Developer("Dileep", "Lotus");
    Developer art = new Developer("Art", "Lotus");

    List<Developer> developers = List.of(matt,maikel,dileep,art);

    List<UserStory> userStories = List.of(
            new UserStory(art, 11, 3),
            new UserStory(matt, 12, 13),
            new UserStory(matt, 11, 5),
            new UserStory(maikel, 12, 8),
            new UserStory(maikel, 12, 13),
            new UserStory(dileep, 12, 2)
    );

    @Test
    @DisplayName("Find all user stories in sprint 11 and sort by points (small to high)")
    void exercise1() {

        var actual = StreamsWorkShop.findUserStoriesInSprint(userStories); // TODO: replace with the solution

        var expected = List.of(new UserStory(art, 11, 3), new UserStory(matt, 11, 5));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("What are the unique pods the developers work in, sorted alphabetically?")
    void exercise2() {
        var actual = StreamsWorkShop.uniqePodsDeveloperWorks(developers);  // TODO: replace with the solution

        var expected = List.of("Lotus", "McLaren");

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find all developers in Lotus and sort them by name")
    void exercise3() {
        var actual = StreamsWorkShop.listOfDevelopersinPod(developers); // TODO: replace with the solution

        var expected = List.of(art, dileep, matt);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Return a string of all developers' names sorted alphabetically")
    void exercise4() {
        var actual = StreamsWorkShop.stringOfDeveloperNames(developers); // TODO: replace with the solution

        var expected = "ArtDileepMaikelMatt";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Are any developers in McLaren?")
    void exercise5() {
        var actual = StreamsWorkShop.isAnyDevelopersInMcLaren(developers); // TODO: replace with the solution

        assertTrue(actual);
    }

    @Test
    @DisplayName("Sum all user stories' points from the developers in Lotus")
    void exercise6() {
        var actual = StreamsWorkShop.sumOfAllUserStories(userStories); // TODO: replace with the solution

        var expected = 23;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("What's the highest points of all the user stories?")
    void exercise7() {
        var actual = StreamsWorkShop.getHighestPointsOfStories(userStories); // TODO: replace with the solution

        var expected = Optional.of(13);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find the user story with the smallest points")
    void exercise8() {
        var actual = StreamsWorkShop.getSmallestPointedUserStory(userStories); // TODO: replace with the solution

        var expected = Optional.of(new UserStory(dileep, 12, 2));

        assertEquals(expected, actual);
    }
}