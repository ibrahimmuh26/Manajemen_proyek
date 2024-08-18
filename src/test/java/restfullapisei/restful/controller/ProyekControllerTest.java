package restfullapisei.restful.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import restfullapisei.restful.model.CreateProyekRequest;
import restfullapisei.restful.model.WebResponse;
import restfullapisei.restful.repository.ProyekRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProyekControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        proyekRepository.deleteAll();
    }


    @Test
    void testCreateSuccess() throws Exception{
        CreateProyekRequest request = new CreateProyekRequest();
        request.setNama_proyek("Ibrahim Muhammad");
        request.setClient("budi");
        request.setTgl_mulai(LocalDate.of(2024,6,2));
        request.setTgl_selesai(LocalDate.of(2024,6,2));
        request.setPimpinan_proyek("budi 1");
        request.setKeterangan("sauasadasdadas");
        mockMvc.perform(
                post("/proyek")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(
                result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
                    });
                assertEquals("OK",response.getData());
                }

                );
    }
}