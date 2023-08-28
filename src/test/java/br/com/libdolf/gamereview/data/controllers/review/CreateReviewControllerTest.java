package br.com.libdolf.gamereview.data.controllers.review;

import br.com.libdolf.gamereview.usecases.review.CreateReviewUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateReviewControllerTest {

    @MockBean
    private CreateReviewUseCase useCase;
    @Autowired
    private MockMvc mockMvc;

    public MockHttpServletRequestBuilder requestBuild(){
        return post("/review");
    }

    @Test
    void whenMediaTypeIsNotJson_ThenReturnStatusCodeUnsupportedMediaType() throws Exception{
        mockMvc.perform(requestBuild().contentType(MediaType.APPLICATION_XML)).andExpect(status().isUnsupportedMediaType());
    }


}