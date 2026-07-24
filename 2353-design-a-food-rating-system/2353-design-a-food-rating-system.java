import java.util.*;

class FoodRatings {
    HashMap<String, Integer> map = new HashMap<>(); // food -> rating
    HashMap<String, String> map1 = new HashMap<>(); // food -> cuisine
    Map<String, PriorityQueue<String[]>> pqmap = new HashMap<>();

    // Custom comparator to order by highest rating, then lexicographically smaller food name
    private final Comparator<String[]> comp = (a, b) -> {
        int rateA = Integer.parseInt(a[1]);
        int rateB = Integer.parseInt(b[1]);
        if (rateA != rateB) {
            return Integer.compare(rateB, rateA);
        }
        return a[0].compareTo(b[0]);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length; 
        for (int i = 0; i < n; i++) {
            String str = foods[i];
            String cui = cuisines[i];
            int rate = ratings[i];
            map.put(str, rate);
            map1.put(str, cui);
            pqmap.computeIfAbsent(cui, k -> new PriorityQueue<>(comp))
                 .add(new String[]{str, String.valueOf(rate)});
        }
    }
    
    public void changeRating(String food, int newRating) {
        map.put(food, newRating); 
        String cui = map1.get(food); // Fixed: map1 stores cuisine for each food
        pqmap.get(cui).add(new String[]{food, String.valueOf(newRating)});
    }
    
    public String highestRated(String cui) {
        PriorityQueue<String[]> pq = pqmap.get(cui); // Fixed: pqmap holds the priority queues
        while (!pq.isEmpty()) {
            String[] top = pq.peek();
            String foodName = top[0];
            int rate = Integer.parseInt(top[1]);
            
            // Return top element if rating matches current rating; otherwise discard stale entry
            if (map.get(foodName) == rate) {
                return foodName;
            }
            pq.poll(); 
        }
        return "";
    }
}