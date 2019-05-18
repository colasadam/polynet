import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.*;
import com.polytech.polynetwork.data.InMemoryStoryRepository;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class FeedServiceTest {

    @Test
    public void should_fetch_user_feed(){
        StoryRepository storyRepository = new InMemoryStoryRepository();
        FeedService fs = new FeedServiceImp(storyRepository);
        Story story1 =new Story("Hello PSG");
        Story story2 =new Story("Hello OM");

        storyRepository.save(story1);
        storyRepository.save(story2);

        List stories = fs.fetchAll();

        Assert.assertEquals(2, stories.size());

        Assert.assertEquals(asList(story1,story2),stories);
    }
}