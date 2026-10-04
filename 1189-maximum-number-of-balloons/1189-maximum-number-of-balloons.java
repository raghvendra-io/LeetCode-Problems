class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character , Integer> map = new HashMap<>();

        for(char ch : text.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int answer = map.getOrDefault('b' , 0);


        answer = Math.min(answer , map.getOrDefault('a' , 0));
        answer = Math.min(answer , map.getOrDefault('l' , 0) / 2);
        answer = Math.min(answer , map.getOrDefault('o' , 0) / 2);
        answer = Math.min(answer , map.getOrDefault('n' , 0));
        answer = Math.min(answer , map.getOrDefault('a' , 0));
        

        return answer;
       
    }
}