package br.com.libdolf.gamereview.data.controllers.review;

import br.com.libdolf.gamereview.core.utils.JsonCreator;
import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.usecases.review.CreateReviewUseCase;
import br.com.libdolf.gamereview.utils.ReviewCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test Create Controller")
class CreateReviewControllerTest {

    @MockBean private CreateReviewUseCase useCase;

    @Autowired private MockMvc mockMvc;

    public MockHttpServletRequestBuilder requestBuild(){
        return post("/v1/review");
    }

    @Test
    @DisplayName("Test response when Media Type not is Json")
    void whenMediaTypeIsNotJson_ThenReturnStatusCodeUnsupportedMediaType() throws Exception{
        mockMvc.perform(requestBuild().contentType(MediaType.APPLICATION_XML)).andExpect(status().isUnsupportedMediaType());
    }
    @Test
    @DisplayName("Test response when Request data is Valid")
    void whenRequestDataIsValid_ThenReturnStatusCodeCreated() throws Exception {
        Mockito.when(useCase.save(any(CreateReviewUseCase.Input.class))).thenReturn(ReviewCreator.validReview());
        CreateReviewUseCase.Input input = new CreateReviewUseCase.Input(1, null, null, null);

        mockMvc.perform(requestBuild().contentType(MediaType.APPLICATION_JSON)
                .content(JsonCreator.toJson(input)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Test response when Service not save the Review")
    void whenServiceNotSaveTheReview_ThenReturnStatusBadRequest() throws Exception {
        Mockito.when(useCase.save(any(CreateReviewUseCase.Input.class))).thenReturn(new Review());
        CreateReviewUseCase.Input input = new CreateReviewUseCase.Input(1, null, null, null);

        mockMvc.perform(requestBuild().contentType(MediaType.APPLICATION_JSON)
                        .content(JsonCreator.toJson(input)))
                .andExpect(status().isBadRequest());
    }



}