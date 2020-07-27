using System;
namespace Graph_Implementation
{
    public class Edge
    {
        public Node start;
        public Node end;
        public float weight;

        public Edge(Node start, Node end, GraphType graphType, float weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public Edge(Node start, Node end, float weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }
}
