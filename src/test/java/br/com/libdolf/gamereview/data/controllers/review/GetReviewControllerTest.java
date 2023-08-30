package br.com.libdolf.gamereview.data.controllers.review;

import br.com.libdolf.gamereview.core.utils.JsonCreator;
import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.usecases.review.GetReviewUseCase;
import br.com.libdolf.gamereview.utils.ReviewCreator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Test Get Controller")
class GetReviewControllerTest {
    @MockBean
    private GetReviewUseCase useCase;

    @Autowired
    private MockMvc mockMvc;

    public MockHttpServletRequestBuilder requestBuild() {
        return get("/v1/review");
    }
    @Test
    @DisplayName("Test if response is a Json")
    void whenRequestIsSuccessful_ThenReturnMediaTypeJson() throws Exception{
        Mockito.when(useCase.findAll()).thenReturn(List.of(ReviewCreator.validReview()));
        mockMvc.perform(requestBuild()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Test response when Get is a Array empty")
    void whenTheResponseIsAEmptyArray_ThenReturnStatusCodeNotFound() throws Exception {
        Mockito.when(useCase.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(requestBuild().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test response when sucessful")
    void whenGetFindAllIsSuccessful_ThenReturnArrayListAndStatusCodeOk() throws Exception {
        Review review = ReviewCreator.validReview();

        GetReviewController.Response response = new GetReviewController.Response(
                review.getId(),
                review.getGame().getName(),
                review.getTitle(),
                review.getReview(),
                review.getRating(),
                review.getPublicationDate());

        Mockito.when(useCase.findAll()).thenReturn(List.of(review));
        mockMvc.perform(requestBuild())
                .andExpect(status().isOk())
                .andExpect(content().json(JsonCreator.toJson(List.of(response))));
    }
}