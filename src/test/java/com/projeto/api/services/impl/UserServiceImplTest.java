package com.projeto.api.services.impl;

import com.projeto.api.domain.User;
import com.projeto.api.domain.dto.UserDTO;
import com.projeto.api.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Alejandro";
    public static final String EMAIL = "alejandro@email.com";
    public static final String PASSWORD = "password";
    @InjectMocks
    private UserServiceImpl service;
    
    @Mock
    private UserRepository repository;
    
    @Mock
    private ModelMapper mapper;
    
    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);

        User response = service.findById(1);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
    
    private void startUser() {
        user = new User(ID, NOME, EMAIL, PASSWORD);
        userDTO = new UserDTO(1, NOME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(1, NOME, EMAIL, PASSWORD));
    }
}