package co.develhope.Interceptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @Mock
    CalculatorState calculatorState;
    @InjectMocks
    Controller controller;

    @BeforeEach
    void setUp () {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void tryPerformDivision () {
        when(calculatorState.performDivision())
                .thenReturn(5);
        ResponseEntity<Integer> result = controller.division();
        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
    }
}
