package test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.controllers.FlightsController;
import com.service.MyService;

public class TestUsingStandaloneSetup {

    private static final Logger log = LoggerFactory.getLogger(TestUsingStandaloneSetup.class);
    private static final String URL = "http://localhost:8080/api/flights";

    @Mock
    MyService myService;

    @InjectMocks
    FlightsController flightsController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under test.
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(flightsController).build();
    }

    @Test
    public void validate_get_flight() throws Exception {

        mockMvc.perform(get(URL)
                .accept(MediaType.APPLICATION_XML)
        )
                .andExpect(status().isOk())
                .andDo(print());
        //.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML));

        //Here, test a single flight, providing url
    }
    /*
	@Test
	public void validate_put_flight() throws Exception
	{
		mockMvc.perform(put(URL)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"destination\":\"Thessaloniki\",\"id\":123, \"departure\":\"Rome\", \"date\":\"2017-04-01T21:32:23+02:00\"}"))
				.andExpect(status().isOk());
			//	.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}*/
}
