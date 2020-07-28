using System;
using System.Collections.Generic;
using System.IO;

namespace Graph_Implementation
{
    public class Graph
    {
        private GraphType graphType;
        private DistanceType distanceType;
        private List<Node> nodes;
        private List<Edge> edges;

        public Graph(GraphType graphType, DistanceType distanceType) {
            this.graphType = graphType;
            this.distanceType = distanceType;
            nodes = new List<Node>();
            edges = new List<Edge>();
        }

        public void CreateGraphFromList(List<string> lines, char splitCharacter) { 
            foreach(string line in lines) {
                float weight = 0;
                string[] tokens = line.Split(splitCharacter);
                Node start = new Node(tokens[0]);
                nodes.Add(start);
                Node end = new Node(tokens[1]);
                nodes.Add(end);

                if(distanceType == DistanceType.WEIGTHED) {
                    weight = float.Parse(tokens[3]);
                }

                Edge edge = new Edge(start, end, graphType, weight);
                edges.Add(edge);
            }
        }

        public void CreateGraphFromFile(File file, char splitCharacter)
        {
            List<string> lines = file.GetLines();
            foreach (string line in lines)
            {
                float weight = 0;
                string[] tokens = line.Split(splitCharacter);
                Node start = new Node(tokens[0]);
                nodes.Add(start);
                Node end = new Node(tokens[1]);
                nodes.Add(end);

                if (distanceType == DistanceType.WEIGTHED)
                {
                    weight = float.Parse(tokens[3]);
                }

                Edge edge = new Edge(start, end, graphType, weight);
                edges.Add(edge);
            }
        }

        public Node AddNode(string name) {
            Node node = new Node(name);
            nodes.Add(node);
            return node;
        }

        public void RemoveNode(Node node) {
            nodes.Remove(node);
        }

        public void RemoveNode(string name) {
            Node node = Find(name);
            if (node != null)
                nodes.Remove(node);
        }

        public void AddNode(Node node) {
            nodes.Add(node);
        }

        public Node Find(string name) {
            Node node = null;
            node = nodes.Find(x => x.name == name);
            return node;
        }

        public Edge AddEdge(Node start, Node end) {
            Edge edge = new Edge(start, end, 0);
            edges.Add(edge);
            return edge;
        }

        public Edge AddEge(Node start, Node end, float weight) {
            Edge edge = new Edge(start, end, weight);
            edges.Add(edge);
            return edge;
        }

        public void Remove(Edge edge) {
            edges.Remove(edge);
        }

        public void WriteNodes() {
            Console.WriteLine("NODE LIST");
            foreach (Node node in nodes)
                Console.WriteLine("Node: " + node.name + "\n");
        }

        public void WriteEdges() {
            Console.WriteLine("EDGE LIST");
            foreach(Edge edge in edges) {
                string str = edge.start.name + " - " + edge.end.name;
                if (distanceType == DistanceType.WEIGTHED)
                    str += " (" + edge.weight + ")\n";
                Console.WriteLine("Edge: " + str);
            }
        }


        public float[,] GetAdjacencyMatrix() {
            float[,] adjacencyMatrix = new float[nodes.Count, nodes.Count];
            for(int i = 0; i < nodes.Count; i++) {
                for (int j = 0; j < nodes.Count; j++)
                {
                    adjacencyMatrix[i, j] = float.PositiveInfinity;
                }
            }

            foreach (Edge edge in edges) {
                int startIndex = nodes.FindIndex(x => x == edge.start);
                int endIndex = nodes.FindIndex(x => x == edge.end);
                adjacencyMatrix[startIndex, endIndex] = edge.weight;
            }

            return adjacencyMatrix;
        }
    }




}
