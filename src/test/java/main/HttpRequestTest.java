package main;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
/**
 *
 * @author Ása Júlía Aðalsteinsdóttir
 * @author Melkorka Mjöll Jóhansdóttir
 * @author Sigurlaug Þórðardóttir
 * @author Vagerður Sigfinnsdóttir
 * @date nóvember 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * 
 * Prófunarklasi sem sendir URL á test web client
*/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    // Fyrir random port
    @LocalServerPort
    private int port;
                 
    // Client klasi til að nota í integration test (samþættingarpróf) og notar Http API
    @Autowired
    private TestRestTemplate restTemplate;
         
    /**
    * Aðferð til að athuga hvort virkar að senda HttpRequest á slóðina /artist/add og
    * fá til baka síðu sem inniheldur Add Artist
        
    * @throws java.lang.Exception
    */
	@Test
    public void addArtistLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/artist/add",
            String.class)).contains("Add Artist");
    }

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á slóðina /event/add og
     * fá til baka síðu sem inniheldur Add Event

     * @throws java.lang.Exception
     */
    @Test
    public void addEventLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/event/add",
                String.class)).contains("Add Event");
    }

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á slóðina /location/add og
     * fá til baka síðu sem inniheldur Add Location

     * @throws java.lang.Exception
     */
    @Test
    public void addLocationLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/location/add",
                String.class)).contains("Add Location");
    }

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á aðalsíðuna og
     * fá til baka síðu sem inniheldur Main Page

     * @throws java.lang.Exception
     */
    @Test
    public void mainPageLoads() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Main Page");
    }
}
