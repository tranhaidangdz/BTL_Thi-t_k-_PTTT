package bai18_bieuthuc_hauto;

import java.util.Stack;

/*Để thực hiện yêu cầu của bạn, chúng ta sẽ cần thực hiện các bước sau:

Cập nhật lớp SimpleSuffix trong dự án BagQueueStack để hỗ trợ phép chia số thực.
Tạo hai file Java: một để chứa mã nguồn của lớp SimpleSuffix và một để chứa mã nguồn của chương trình chính.
Trong chương trình chính, đọc biểu thức từ một file, tính toán kết quả, và ghi kết quả vào một file khác. */
public class SimpleSuffix {
    private static final String OPERATORS = "+-*/";

    public static double evaluate(String expression) {

        Stack<Double> operands = new Stack<>();

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (!OPERATORS.contains(token)) {
                operands.push(Double.parseDouble(token));
            } else {
                double operand2 = operands.pop();
                double operand1 = operands.pop();
                switch (token) {
                    case "+":
                        operands.push(operand1 + operand2);
                        break;
                    case "-":
                        operands.push(operand1 - operand2);
                        break;
                    case "*":
                        operands.push(operand1 * operand2);
                        break;
                    case "/":
                        operands.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        return operands.pop();
    }
}
