# Algorithms

## BFS
- Algorithm to traverse a graph (visits all nearer nodes before farther nodes)
- Can be used to find the shortest path in an unweighted graph
- Can be used to floodfill graphs to find the distance to each node
- In a weighted graph, if we visit a node V, there's no guarantee we have the shortest path to V

## DFS
- Algorithm to traverse a graph (traverses fully down one path before attempting another path)
- Usually used to visit an entire graph
- Slow because exhaustive

### IDDFS
- "Optimization" where DFS is used in repeated depth limits
- Equivalent to BFS but uses much less memory

## Dijkstra's
- Used to find shortest path between source node and all other nodes on a weighted graph
- Can also be used on an unweighted graph 
