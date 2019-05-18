
import com.polytech.polynetwork.AppConfig;
import com.polytech.polynetwork.MyObjectFactory;
import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.*;
import com.polytech.polynetwork.data.InMemoryStoryRepository;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


import java.util.List;

import static java.util.Arrays.asList;


public class PublicationServiceTest {

    @Test
    public void should_save_story(){

        ApplicationContext context = SpringApplication.run(AppConfig.class);

        //GIVEN
        StoryRepository storyRepository = context.getBean(StoryRepository.class);
        PublicationService publicationService = context.getBean(PublicationService.class);


        Story story1 = new Story("Hello PSG");
        Story story2 = new Story("Hello OM");
        //WHEN
        publicationService.share(story1);
        publicationService.share(story2);
        //THEN
        List stories = storyRepository.findAll();
        Assert.assertEquals(2, stories.size());
        Assert.assertEquals(asList(story1, story2), stories);
    }
}
