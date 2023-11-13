package tbp.integration.test;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tbp.integration.test.dao.User;
import tbp.integration.test.repository.UserRepository;
import tbp.integration.test.service.UserService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringTesting2ApplicationTests {
	  @Autowired
	    private UserService service;

	    @MockBean
	    private UserRepository repository;

	    @Test
	    public void getUsersTest() {
	        when(repository.findAll())
	                .thenReturn(Stream.of(new User(367, "Daniel", 43, "usa"),
	                        new User(567, "Jhon", 23, "uae"),
	                        new User(437, "Doe", 33, "uk"))
	                        .collect(Collectors.toList()));
	        assertEquals(3,service.getUsers().size());
	    }

	    @Test
	    public void getUserbyAddressTest() {
	        String address = "Bangalore";
	        when(repository.findByAddress(address))
	                .thenReturn(Stream.of(new User(376, "Danile", 31, "USA")).collect(Collectors.toList()));
	        assertEquals(1, service.getUserbyAddress(address).size());
	    }

	    @Test
	    public void saveUserTest() {
	        User user = new User(999, "Pranya", 33, "Pune");
	        when(repository.save(user)).thenReturn(user);
	        assertEquals(user, service.addUser(user));
	    }


	    @Test
	    public void deleteUserTest() {
	        User user = new User(999, "Pranya", 33, "Pune");
	        service.deleteUser(user);
	        verify(repository, times(1)).delete(user);
	    }

}
