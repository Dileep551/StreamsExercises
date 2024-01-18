import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StreamsWorkShop {

    public static List<UserStory> findUserStoriesInSprint(List<UserStory> userStories) {

        return userStories.stream()
                .filter(s -> s.sprint() == 11)
                .sorted(Comparator.comparing(UserStory::points))
                .collect(Collectors.toList());

    }

    public static List<String> uniqePodsDeveloperWorks(List<Developer> developers) {

        return developers.stream()
                .map(Developer::pod)
                .distinct()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());
    }

    public static List<Developer> listOfDevelopersinPod(List<Developer> developers) {

        return developers.stream()
                .filter(s -> s.pod().equals("Lotus"))
                .sorted(Comparator.comparing(Developer::name))
                .collect(Collectors.toList());

    }

    public static String stringOfDeveloperNames(List<Developer> developers) {

        return developers.stream()
                .sorted(Comparator.comparing(Developer::name))
                .map(Developer::name)
                .reduce("", String::concat);


    }

    public static boolean isAnyDevelopersInMcLaren(List<Developer> developers) {

        return developers.stream()
                .noneMatch(s -> s.name().equals("McLaren"));

    }


    public static Integer sumOfAllUserStories(List<UserStory> userStories) {

        return userStories.stream()
                .filter(s -> s.developer().pod().equals("Lotus"))
                .map(UserStory::points)
                .reduce(0, Integer::sum);


    }

    public static Optional<Integer> getHighestPointsOfStories(List<UserStory> userStories) {


        return userStories.stream()
                .map(UserStory::points)
                .max(Comparator.naturalOrder());


    }

    public static Optional<UserStory> getSmallestPointedUserStory(List<UserStory> userStories) {


        return userStories.stream()
                .min(Comparator.comparing(UserStory::points));


    }


}
