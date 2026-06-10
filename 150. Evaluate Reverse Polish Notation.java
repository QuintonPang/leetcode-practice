class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> numbers = new Stack<>();
        for(String s: tokens){
            if(isOperator(s)){
                int  b= numbers.pop();
                int  a= numbers.pop();
                int result ;

                switch(s){
                    case "+": 
                        result = a+b;
                        break;
                        case "-":
                        result = a-b;
                        break;
                        case "*":
                        result = a*b;
                        break;
                        case "/":
                        result = a/b;
                        break;
                        default:
                        throw new IllegalArgumentException("Invalid operator");

                }
                                        numbers.push(result);

            }else{
                numbers.push(Integer.parseInt(s));
            }
        }
        return  numbers.pop();
    }

    boolean isOperator(String token){
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}