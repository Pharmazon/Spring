import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import ru.shcheglov.dto.AdDTO;

/**
 * @author Alexey Shcheglov
 * @version dated 15.12.2018
 */

public class AdRestTest extends Assert {

    @Test
    public void testGet() {
        final RestTemplate template = new RestTemplate();
        final String url = "http://localhost:8080/AdService/getAdList";
        final AdDTO[] ads = template.getForObject(url, AdDTO[].class);
        assertNotNull(ads);
    }
}
