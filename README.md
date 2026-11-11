# Grafo no dirigido: DFS y BFS

Implementación en Java de un grafo no dirigido usando una matriz de adyacencia. La matriz almacena `1` cuando existe una arista y `0` cuando no existe. Cada arista se registra en ambas direcciones.

## Recorridos

- `dfs(int start)` recorre en profundidad: visita un vértice y luego explora recursivamente sus vecinos no visitados.
- `bfs(int start)` recorre en anchura: usa una cola FIFO para visitar primero los vecinos más cercanos al inicio.

Ambos métodos reinician las marcas de visitado antes de empezar. Los índices de los vértices empiezan en `0`; la demostración usa las etiquetas `A` a `E`.

## Compilar y ejecutar

```sh
javac Graph.java
java Graph
```

Salida esperada:

```text
DFS desde A: A B D C E
BFS desde A: A B C D E
```

## Enlace del repositorio

Repositorio público: https://github.com/Tgtr24/TallerDfsYBfs

Para actualizar el repositorio desde esta carpeta:

```sh
git add Graph.java README.md
git commit -m "Implementa grafo no dirigido con DFS y BFS"
git push -u origin main
```
