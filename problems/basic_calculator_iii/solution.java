class Solution {
    Map<Character, Integer> precedence = Map.of(
        '+', 1,
        '-', 1,
        '*', 2,
        '/', 2
    );
    
    public String infixToPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isWhitespace(c)) {
                continue; // Skip white spaces
            }
            System.out.println(operatorStack);

            if (Character.isDigit(c)) {
                // If the current character is a digit, we should check for multi-digit numbers
                int num = c - '0';
                while (i < infix.length() - 1 && Character.isDigit(infix.charAt(i+1))) {
                    num = num * 10 + (infix.charAt(i + 1) - '0');
                    i++;
                }
                output.append(String.valueOf(num)).append(" ");
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    output.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            } else {
                while (!operatorStack.isEmpty() && precedence.getOrDefault(c, 0) <= precedence.getOrDefault(operatorStack.peek(), 0)) {
                    char op = operatorStack.pop();
                    output.append(op).append(" ");
                }
                operatorStack.push(c);
            }
        }
        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    public int evaluate(String post) {
        Stack<Integer> operandStack = new Stack<>();
     
        String[] split = post.split(" ");
        for (String token : split) {
            System.out.println(operandStack);
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Integer.parseInt(token));
            } else {
                int b = operandStack.pop();
                int a = operandStack.pop();
                switch (token.charAt(0)) {
                case '+': 
                    operandStack.push(a + b);
                    break;
                case '-':
                    operandStack.push(a - b);
                    break;
                case '*': 
                    operandStack.push(a * b);
                    break;
                case '/': 
                    operandStack.push(a / b);
                    break;
                }
            }
        }

        return operandStack.pop();
    }
    public int calculate(String s) {
        String postfix = infixToPostfix(s);
        return evaluate(postfix);
    }
}