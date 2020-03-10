package com.droid.war.controller;

import com.droid.war.view.LoginView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Mock
    AdminController adminController;
    @Mock
    UserController userController;
    @Mock
    ControllerUtils controllerUtils;
    @InjectMocks
    LoginController loginController = new LoginController(new LoginView(), userController, adminController);

    @Test
    public void startTestForAdmin() {
        //prepare
        when(controllerUtils.readInt(anyListOf(Integer.class))).thenReturn(1);
        when(controllerUtils.readString(any(Pattern.class))).thenReturn("Igor").thenReturn("aaa");

        //act
        loginController.start();

        verify(adminController, times(1)).start();
    }

    @Test
    public void startTestForUser() {
        //prepare
        when(controllerUtils.readInt(anyListOf(Integer.class))).thenReturn(1);
        when(controllerUtils.readString(any(Pattern.class))).thenReturn("User").thenReturn("pass");

        //act
        loginController.start();

        //assert
        verify(userController, times(1)).start();
    }
}
