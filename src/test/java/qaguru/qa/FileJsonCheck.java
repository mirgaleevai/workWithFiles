package qaguru.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import qaguru.qa.model.Samples;

import java.io.IOException;
import java.io.InputStream;

public class FileJsonCheck {

    ClassLoader cl = FileJsonCheck.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonFileCheck() throws IOException {
        InputStream stream = cl.getResourceAsStream("sample1.json");
        Samples samples = objectMapper.readValue(stream, Samples.class);

                Assertions.assertEquals("Apple", samples.getFruit());
                Assertions.assertEquals("Large", samples.getSize());
                Assertions.assertEquals("Red", samples.getColor());
                Assertions.assertEquals(12.3, samples.getItems().get(0).getPrice());
                Assertions.assertEquals(1, samples.getItems().get(0).getProductID());

            }
        }

