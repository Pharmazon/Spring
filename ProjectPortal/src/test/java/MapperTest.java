import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;
import ru.shcheglov.dto.AdDTO;

import java.io.IOException;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

public class MapperTest extends Assert {

    @Test
    public void testSerializeJSON() throws JsonProcessingException {
        final AdDTO adDTO = new AdDTO();
        adDTO.setId("1");
        adDTO.setName("Name");
        adDTO.setContent("Content");
        adDTO.setNumber("Number");

        final ObjectMapper mapper = new ObjectMapper();
        final String jsonUsual = mapper.writeValueAsString(adDTO);
        final String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(adDTO);
        assertNotNull(jsonUsual);
        System.out.println(jsonUsual);
        assertNotNull(jsonPretty);
        System.out.println(jsonPretty);
    }

    @Test
    public void testDeserializeJSON() throws IOException {
        final String json = "{ \"id\": \"123\", \"name\": \"DEMO\" }";
        final ObjectMapper mapper = new ObjectMapper();
        final AdDTO adDTO = mapper.readValue(json, AdDTO.class);
        assertNotNull(adDTO);
        assertNotNull(adDTO.getId());
        assertNotNull(adDTO.getName());
    }

    @Test
    public void testSerializeXML() throws JsonProcessingException {
        final AdDTO adDTO = new AdDTO();
        adDTO.setId("1");
        adDTO.setName("Name");
        adDTO.setContent("Content");
        adDTO.setNumber("Number");

        final ObjectMapper mapper = new XmlMapper();
        final String xml = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(adDTO);
        assertNotNull(xml);
        System.out.println(xml);
    }

    @Test
    public void testDeserializeXML() throws IOException {
        final String xml = "<item><id>123</id><name>DEMO</name></item>";
        final XmlMapper mapper = new XmlMapper();
        final AdDTO adDTO = mapper.readValue(xml, AdDTO.class);
        assertNotNull(adDTO);
        assertNotNull(adDTO.getId());
        assertNotNull(adDTO.getName());
    }

}
