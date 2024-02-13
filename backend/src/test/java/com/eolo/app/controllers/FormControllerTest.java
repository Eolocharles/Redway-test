package com.eolo.app.controllers;

import com.eolo.app.entities.User;
import com.eolo.app.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FormControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Model model;

    @InjectMocks
    private FormController formController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testForm() {
        String result = formController.form(model);
        assertEquals("form", result);
        verify(model).addAttribute(eq("user"), any(User.class));
    }

    @Test
    public void testSave_Success() {
        User user = new User();
        String result = formController.save(user);
        assertEquals("redirect:/success", result);
        verify(userRepository).save(user);
    }

    @Test
    public void testSave_Error() {
        doThrow(new RuntimeException("Simulated save error")).when(userRepository).save(any(User.class));
        User user = new User();
        String result = formController.save(user);
        assertEquals("redirect:/error", result);
        verify(userRepository).save(user);
    }

    @Test
    public void testSuccess() {
        String result = formController.success();
        assertEquals("success", result);
    }
}
