package com.dio.eletronicosapi;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.dio.eletronicosapi.document.Eletronicos;
import com.dio.eletronicosapi.repository.EletronicosRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.List;
import static com.dio.eletronicosapi.constants.EletronicosConstant.ELETRONICOS_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class EletronicosapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	EletronicosRepository eletronicosRepository;

	@Test
	public void getEletronicosByID() {
		webTestClient.get().uri(ELETRONICOS_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}
	@Test
	public void getOneEletronicosNotFound(){

		webTestClient.get().uri(ELETRONICOS_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();
	}
	@Test
	public void deleteEletronicos(){
		webTestClient.delete().uri(ELETRONICOS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}
}

