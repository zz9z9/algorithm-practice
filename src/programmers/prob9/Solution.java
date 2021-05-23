package programmers.prob9;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static final Character[] operatorArr = new Character[]{'+', '-', '*'};
    static long answer = 0;

    static void dfs(boolean[] isVisited, List<Character> operOrder, List<Long> operands, List<Character> operators) {
        if (operOrder.size() == 3) {
            List<Long> copyOperands = new ArrayList<>();
            List<Character> copyOperators = new ArrayList<>();
            copyOperands.addAll(operands);
            copyOperators.addAll(operators);

            for (char targetOp : operOrder) {
                while (copyOperators.indexOf(targetOp)!=-1) {
                    for (int i = 0; i < copyOperators.size(); i++) {
                        char op = copyOperators.get(i);
                        long num1 = copyOperands.get(i);
                        long num2 = copyOperands.get(i + 1);
                        long resultNum = 0;

                        if (targetOp == op) {
                            switch (op) {
                                case '+':
                                    resultNum = num1 + num2;
                                    break;
                                case '-':
                                    resultNum = num1 - num2;
                                    break;
                                case '*':
                                    resultNum = num1 * num2;
                                    break;
                            }

                            copyOperators.remove(i);
                            copyOperands.remove(i + 1);
                            copyOperands.remove(i);
                            copyOperands.add(i, resultNum);

                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyOperands.get(0)));
            return;
        }

        for (int i = 0; i < operatorArr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                operOrder.add(operatorArr[i]);

                dfs(isVisited, operOrder, operands, operators);

                isVisited[i] = false;
                operOrder.remove(operatorArr[i]);
            }
        }
    }

    static void splitExpression(List<Long> operands, List<Character> operators, String exp) {
        StringBuilder sb = new StringBuilder();

        for (char c : exp.toCharArray()) {
            if (c == '*' || c == '+' || c == '-') {
                operands.add(Long.parseLong(sb.toString()));
                operators.add(c);
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }

        operands.add(Long.parseLong(sb.toString()));
    }

    public long solution(String expression) {
        List<Long> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        List<Character> operOrder = new ArrayList<>();
        boolean[] isVisited = new boolean[operatorArr.length];

        splitExpression(operands, operators, expression);

        dfs(isVisited, operOrder, operands, operators);

        return answer;
    }
}