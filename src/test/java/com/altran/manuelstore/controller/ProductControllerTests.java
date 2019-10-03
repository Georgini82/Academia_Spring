package com.altran.manuelstore.controller;

import com.altran.manuelstore.models.Produto;
import com.altran.manuelstore.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductControllerTests {

    @MockBean
    ProductRepository produto;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldCreateProdut() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo("TESTE");
        produto.setDescricao("TESTE");
        produto.setNome("produto de TESTE");
        produto.setPreco((float) 30.0);
        produto.setStock(200);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
                .content(new ObjectMapper().writeValueAsString(produto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }



}
