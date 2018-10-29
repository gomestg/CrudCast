package com.challenges.people;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.challenges.people.model.People;
import com.challenges.people.repositories.PeopleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PeopleApplicationTests {

	private final String BASE_PATH = "http://localhost:8080/rest/people";
	
	@Autowired
    private PeopleRepository repository;
	
	private RestTemplate restTemplate;
	
	@Before
    public void setUp() throws Exception {
        repository.deleteAll();
 
        repository.save(new People(1L, "Diego Samuel", "786.453.879-88", "Rua", "Asa Sul", "23", "Centro", "Olinda", "PE", "(81) 87657 9876", "(81) 78654 9876"));
        repository.save(new People(2L, "Pedro Luiz", "122-675.777-09", "Rua", "Asa Norte", "24", "Centro", "Olinda", "PE", "(81) 45231 6735", "(81) 12314 8876"));
        repository.save(new People(3L, "Rafael Silva", "234.122.111-00", "Rua", "Asa Lest", "25", "Centro", "Olinda", "PE", "(81) 56342 0987", "(81) 01928 6754"));
        
        restTemplate = new RestTemplate();
    }
	
	@Test
	public void findAll() {
		ResponseEntity<List<People>> response = restTemplate.exchange(
				BASE_PATH,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<People>>(){});
		
		List<People> peoples = response.getBody();
		
		Assert.assertEquals(3, peoples.size());
	}
	
	@Test
	public void findById() {
		final Long id = 1L;
		
		People people = restTemplate.getForObject(BASE_PATH + "/" + id, People.class);
		
		Assert.assertEquals(id, people.getId());
		Assert.assertEquals("Diego Samuel", people.getName());
		Assert.assertEquals("786.453.879-88", people.getCpf());
	}
	
	@Test
	public void create() {
		People people = new People();
		
		people.setName("Carlos José");
		people.setCpf("564.786.233-09");
		
		final Long newId = 4L;
		
		People response = restTemplate.postForObject(BASE_PATH + "/save/" + newId, people, People.class);
		
		Assert.assertEquals(newId, response.getId());
		Assert.assertEquals("Carlos José", response.getName());
		Assert.assertEquals("564.786.233-09", response.getCpf());
	}

	@Test
	public void update() {
		People people = new People();
		
		people.setName("Rafael Jorge da Silva");
		people.setCpf("234.122.111-00");
		
		final Long id = 3L;
		
		People response = restTemplate.postForObject(BASE_PATH + "/save/" + id, people, People.class);
		
		Assert.assertEquals(id, response.getId());
		Assert.assertNotEquals("Rafael Silva", response.getName());
		Assert.assertEquals("234.122.111-00", response.getCpf());
	}
	
	@Test(expected = HttpClientErrorException.class)
	public void delete() throws HttpClientErrorException {
		final Long id = 2L;
		
		restTemplate.delete(BASE_PATH + "/remove/" + id);
		restTemplate.getForObject(BASE_PATH + "/" + id, People.class);
	}
}
