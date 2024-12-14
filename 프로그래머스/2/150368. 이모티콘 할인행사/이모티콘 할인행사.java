class Solution {
    
    int resultUsr = 0;
    int resultPrice = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] dcRates = new int[emoticons.length];
        makeCombination(users, emoticons, dcRates, 0);
        return new int[] {resultUsr, resultPrice};
    }
    
    private void makeCombination(int[][] users, int[] emoticons, int[] dcRates, int depth) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, dcRates);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            dcRates[depth] = i;
            makeCombination(users, emoticons, dcRates, depth + 1);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons, int[] dcRates) {
        int usrCount = 0;
        int totalPrice = 0;
        
        for (int[] user : users) {
            int rate = user[0];
            int price = user[1];
            
            int sum = 0;
            
            for (int i = 0; i < dcRates.length; i++) {
                if (dcRates[i] >= rate) {
                    sum += (emoticons[i] * (100 - dcRates[i]) / 100);
                }
                
                if (sum > price) break;
            }
            
            if (sum < price) {
                totalPrice += sum;
            } else {
                usrCount++;
            }
        }
        
        if (resultUsr < usrCount) {
            resultUsr = usrCount;
            resultPrice = totalPrice;
        } else if (resultUsr == usrCount) {
            if (resultPrice < totalPrice) {
                resultPrice = totalPrice;
            }
        }
    }
}