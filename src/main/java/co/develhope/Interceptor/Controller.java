package co.develhope.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class Controller {
    @Autowired
    private CalculatorState calculatorState;

    @PostMapping("/dividend")
    public ResponseEntity<Void> setDvidend(@RequestParam int dividend) {
        calculatorState.setDividend(dividend);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/divisor")
    public ResponseEntity<Void> setDivisor(@RequestParam int divisor) {
        calculatorState.setDivisor(divisor);
        return ResponseEntity.accepted().build();
    }


    @GetMapping("/result")
    public ResponseEntity<Integer> division() {
        try {
            return ResponseEntity.accepted().body(calculatorState.performDivision());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();


        }
    }
}
