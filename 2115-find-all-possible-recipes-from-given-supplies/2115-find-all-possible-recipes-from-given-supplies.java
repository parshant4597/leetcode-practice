class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) { 
       Set<String> set = new HashSet<>();
       for(int i= 0 ; i < supplies.length ; i++){
        set.add(supplies[i]);
       }
       Queue<Integer> qu = new LinkedList<>();
       for(int i = 0 ; i < recipes.length ; i++){
        qu.offer(i);
       }
       List<String> ans = new ArrayList<>();
       int lastsize = -1;  
       while(set.size()  > lastsize){
         lastsize = set.size();  
         int n = qu.size();
         while(n--> 0){
             int recindx = qu.poll();
             boolean flag = true ; 
             for(int i =0 ; i < ingredients.get(recindx).size() ; i++){
                String str = ingredients.get(recindx).get(i);
                if(!set.contains(str)){
                    flag = false ;
                    break;
                }
             } 
             if(!flag){
                qu.offer(recindx);
             }else{ 
                set.add(recipes[recindx]);
                ans.add(recipes[recindx]);
             }
         }
       }
       return ans ; 

        
    }
}
// class Solution {
//     public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//                 // This is a DEPENDENCY GRAPH problem - perfect for TOPOLOGICAL SORT using kahn's algo (Topo sorting using BFS)
//         // Supplies → Recipe A → Recipe B → Recipe C
//         // Kahn' sorting: get indgree of each nodes, put all nodes whose degree is zero in queue , now typical BFS until queue is empty(add any node whose degree become zero while traversing)

//         // Build dependency graph and track missing ingredients
//         Map<String,List<String>> adjList = new HashMap<>();  // ingredient → recipes needing it
//         Map<String,Integer> inDegree = new HashMap<>(); // recipe → missing ingredient count
//         Set<String> recipeSet = new HashSet<>(Arrays.asList(recipes));
//         Set<String> available = new HashSet<>(Arrays.asList(supplies));

//         //calculate indegree (missing ingredients)
//         for( int i=0;i<recipes.length;i++){
//             String recipe = recipes[i];
//             int missingCount=0;

//             for(String ingredient: ingredients.get(i)){
//                 if(!available.contains(ingredient)){
//                     missingCount++;
//                     // If ingredient is a recipe, create dependency edge
//                     if(recipeSet.contains(ingredient)){
//                         adjList.putIfAbsent(ingredient,new ArrayList<>());
//                         adjList.get(ingredient).add(recipe);
//                     }

//                 }
//             }
//             inDegree.put(recipe,missingCount);
//         }

//         // BFS: Start with recipes ready to make (indegree = 0),Kahn's algo
//         Queue<String> queue = new LinkedList<>();
//         for(String recipe : recipes){
//             if(inDegree.get(recipe)==0)
//                 queue.offer(recipe);
//         }
        
//         // Now typical BFS till queue is empty
//         List<String> result = new ArrayList<>();
//         while(!queue.isEmpty()){
//             String recipe = queue.poll();
//             result.add(recipe);// missingCount zero means ,ingredients are available to complete the reciepe
//             //update depenedent recipe, explore the child nodes
//             if(adjList.containsKey(recipe)){
//                 for(String dependent : adjList.get(recipe)){
//                     inDegree.put(dependent,inDegree.get(dependent)-1);
//                     if(inDegree.get(dependent)==0){
//                         queue.offer(dependent);
//                     }
//                 }
//             }
//         }
//         return  result;
        
//     }
// }