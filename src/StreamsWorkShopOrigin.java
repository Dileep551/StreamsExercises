import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StreamsWorkShopOrigin {

    public static List<UserStory1> finduserStories1InSprint(List<UserStory1> userStories1) {

        return userStories1.stream()
                .filter(s -> s.sprint() == 11)
                .sorted(Comparator.comparing(UserStory1::points))
                .toList();

    }

    public static List<String> uniqePodsDeveloperWorks(List<UserStory1> userStories1) {

        return userStories1.stream()
                .map(s -> s.developer1().pod())
                .distinct()
                .sorted(Comparator.comparing(String::toLowerCase))
                .toList();
    }

    public static List<Developer1> listOfDevelopersinPod(List<UserStory1> userStories1) {

        return userStories1.stream()
                .map(UserStory1::developer1)
                .filter(developer1 -> developer1.pod().equals("Lotus"))
                .sorted(Comparator.comparing(Developer1::name))
                .distinct()
                .toList();

    }

    public static String stringOfDeveloperNames(List<UserStory1> userStories1) {

        return userStories1.stream()
                .map(s -> s.developer1().name())
                .distinct()
                .sorted()
                .reduce("", String::concat);


    }

    public static boolean isAnyDevelopersInMcLaren(List<UserStory1> userStories1) {

        return userStories1.stream()
                .anyMatch(s -> s.developer1().pod().equalsIgnoreCase("McLaren"));

    }


    public static Integer sumOfAlluserStories1(List<UserStory1> userStories1) {

        return userStories1.stream()
                .filter(s -> s.developer1().pod().equals("Lotus"))
                .map(UserStory1::points)
                .reduce(0, Integer::sum);


    }

    public static Optional<Integer> getHighestPointsOfStories(List<UserStory1> userStories1) {


        return userStories1.stream()
                .map(UserStory1::points)
                .max(Comparator.naturalOrder());


    }

    public static Optional<UserStory1> getSmallestPointedUserStory1(List<UserStory1> userStories1) {


        return userStories1.stream()
                .min(Comparator.comparing(UserStory1::points));


    }


}
