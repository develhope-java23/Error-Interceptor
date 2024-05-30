package co.develhope.Interceptor;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class CalculatorState {
    private int dividend;
    private int divisor;

    public CalculatorState() {
        this.dividend = 0;
        this.divisor = 0;
    }


    public void setDividend(int dividend) {
        this.dividend = dividend;
    }


    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int performDivision() {
        if (this.divisor == 0) {
            throw new IllegalArgumentException("invalid divisor");
        }
        int result = this.dividend / this.divisor;
        return result;
    }
}
